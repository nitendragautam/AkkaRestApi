package com.nitendragautam.scalarestapi.actors

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import cakesolutions.kafka.KafkaConsumer
import cakesolutions.kafka.akka.KafkaConsumerActor.{Confirm, Subscribe}
import cakesolutions.kafka.akka.{ConsumerRecords, KafkaConsumerActor}
import com.typesafe.config.ConfigFactory
import org.apache.kafka.clients.consumer.OffsetResetStrategy
import org.apache.kafka.common.serialization.{StringDeserializer, StringSerializer}
import org.slf4j.{Logger, LoggerFactory}

import scala.concurrent.duration._
object ConsumerActors{
  def apply(system :ActorSystem): ActorRef ={
val config =ConfigFactory.load()

    val kafkaConsumerConf = KafkaConsumer.Conf(
      new StringDeserializer,
      new StringDeserializer,
      bootstrapServers =config.getString("consumer.bootstrap.servers"),
      groupId = "messageGroup",
      enableAutoCommit = false,
      autoOffsetReset = OffsetResetStrategy.LATEST)
      .withConf(config)

val actorConf =KafkaConsumerActor.Conf(1.seconds,3.seconds)
system.actorOf(Props(new ConsumerActors(kafkaConsumerConf,actorConf)))
  }
}


/*
Akka based actors for Kafka consumers
 */
class ConsumerActors(kafkaConfig: KafkaConsumer.Conf[String,String],
                     actorConfig: KafkaConsumerActor.Conf) extends Actor{
private val logger :Logger =LoggerFactory.getLogger(classOf[ConsumerActors])

val recordsExtractor =ConsumerRecords.extractor[String,String]

val kafkaTopic ="inputMessage"

  val kafkaConsumerActor =context.actorOf(
    KafkaConsumerActor.props(kafkaConfig,actorConfig,self)
  )

  context.watch(kafkaConsumerActor)
  kafkaConsumerActor !Subscribe.AutoPartition(List(kafkaTopic))



  def receive ={

    case recordsExtractor(records) =>
kafkaConsumerActor !Confirm(records.offsets,commit=true)
  }


  //Process Records
  private def processRecords(records :ConsumerRecords [String ,Array[Byte]])={
    records.pairs.foreach{case (key,value) =>



      logger.info("Received Message Key "+key.mkString)

      logger.info("Received Message Value " +new String(value,"UTF-8"))
    }
  }
}

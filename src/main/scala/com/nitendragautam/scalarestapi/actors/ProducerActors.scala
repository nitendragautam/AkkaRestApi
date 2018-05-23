package com.nitendragautam.scalarestapi.actors

import akka.actor.Actor
import cakesolutions.kafka.KafkaProducer
import com.typesafe.config.ConfigFactory
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.serialization.StringSerializer
import org.slf4j.{Logger, LoggerFactory}

/*
Akka based Kafka Producers which sends Key and Value as Messages
 */
class ProducerActors extends Actor{
private val logger :Logger =
  LoggerFactory.getLogger(classOf[ProducerActors])
  val config =ConfigFactory.load()
val kafkaTopic ="inputMessage"
  val kafkaProducerConfig =KafkaProducer.Conf(
    keySerializer = new StringSerializer,
    valueSerializer = new StringSerializer,
    bootstrapServers= config.getString("config.bootstrap.servers")
  )

  import ProducerActors._

override def receive : Receive ={


  case KafkaBrokerMessage(kafkaMessageKey,kafkaMessageValue) =>{
val kafkaRecord = new ProducerRecord[String,String](kafkaTopic,kafkaMessageKey,kafkaMessageValue)
val producer = KafkaProducer.apply(kafkaProducerConfig)
    producer.send(kafkaRecord)
    producer.close()
  }
  case invalidMessage =>
logger.info("Cannot Handle these kind of Mesages " +invalidMessage)
}
}


object ProducerActors{

  case class KafkaBrokerMessage(kafkaMessageKey : String ,kafkaMessageValue :String)
}
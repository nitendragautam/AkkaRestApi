package edu.ndsu.kafkarestapi.actors

import akka.actor.Actor
import cakesolutions.kafka.KafkaProducer
import com.typesafe.config.ConfigFactory
import edu.ndsu.kafkarestapi.actors.ProducerActors.LogAnalyticsKafkaMessage
import org.apache.kafka.common.serialization.StringSerializer
import org.slf4j.{Logger, LoggerFactory}

/*
Akka based Kafka Producers
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


  case LogAnalyticsKafkaMessage(kafkaMessageKey,kafkaMessageValue) =>{

  }
  case invalidMessage =>
logger.info("Cannot Handle these kind of Mesages " +invalidMessage)
}
}


object ProducerActors{

  case class LogAnalyticsKafkaMessage(kafkaMessageKey : String ,kafkaMessageValue :String)
}
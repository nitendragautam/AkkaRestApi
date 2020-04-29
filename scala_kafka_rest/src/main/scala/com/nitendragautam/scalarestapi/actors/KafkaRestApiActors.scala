package com.nitendragautam.scalarestapi.actors

import java.text.SimpleDateFormat
import java.util.{Calendar, TimeZone}

import akka.actor.{Actor, ActorRef, Props}
import ProducerActors.KafkaBrokerMessage
import com.nitendragautam.scalarestapi.services.KafkaMessageRequest
import com.typesafe.config.ConfigFactory
import org.slf4j.{Logger, LoggerFactory}




class KafkaRestApiActors extends Actor{

  private val logger: Logger = LoggerFactory.getLogger(classOf[KafkaRestApiActors])

  val config = ConfigFactory.load()

val kafkaProducerActor :ActorRef =context.system.actorOf(Props[ProducerActors])
  override def receive = {

    case kafkaMessageRequest :KafkaMessageRequest =>
      {
val firstName= kafkaMessageRequest.firstName
val lastName = kafkaMessageRequest.lastName
val kafkaMessageKey=getTodaysDate()
        val kafkaMessage = firstName +"\t" +lastName

        //Send Message to Producer Actors
kafkaProducerActor !KafkaBrokerMessage(kafkaMessageKey,kafkaMessage)
      }


  }
/*
Gets todays Date
 */
private def getTodaysDate(): String ={
val gmtTime = TimeZone.getTimeZone("GMT")
  val format = new SimpleDateFormat("YYYYMMddHmmss")
  format.setTimeZone(gmtTime)
  val todaysDate=Calendar.getInstance().getTime()
  format.format(todaysDate)
}
}

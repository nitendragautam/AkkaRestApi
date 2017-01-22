package edu.ndsu.kafkarestapi.actors

import akka.actor.Actor
import akka.actor.Actor.Receive
import edu.ndsu.kafkarestapi.model.LogAnalyticsRequest


class LogAnalyticsActors extends Actor{


  override def receive = {

    case logAnalyticsRequest :LogAnalyticsRequest =>
      {
val dataAddress= logAnalyticsRequest.dataLocation

        println(dataAddress)
      }

  }


}

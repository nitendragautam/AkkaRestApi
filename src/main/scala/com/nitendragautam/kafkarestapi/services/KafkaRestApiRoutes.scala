package com.nitendragautam.kafkarestapi.services

import akka.actor.{ActorSystem, Props}
import akka.http.scaladsl.model.{HttpEntity, HttpResponse, StatusCode}
import akka.http.scaladsl.server.Directives._
import com.nitendragautam.kafkarestapi.actors.KafkaRestApiActors

import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
/** Handles the Incoming Rest WebS Services Request
  *
  *
  *
  */
class KafkaRestApiRoutes(implicit system: ActorSystem)
extends KafkaMessageRequestJson
{

val kafkaRestApiActor = system.actorOf(Props[KafkaRestApiActors])


var routes ={
  path("KafkaRestApiService" / "sendLogsToKafka"){
    post {
      entity(as[KafkaMessageRequest]){
        kafkaMessageRequest =>
//Call Kafka Rest API Actor
          system.scheduler.scheduleOnce(200 millis,kafkaRestApiActor,kafkaMessageRequest)
          complete {



            //Status Code Integer
            HttpResponse(StatusCode.int2StatusCode(200),
              entity = s"Data : Request Received.")
          }
      }
    }
  } ~
    path("LogAnalyticsService" / "ping"){
    get {
      complete {
        HttpResponse(entity = HttpEntity(java.util.Calendar.getInstance().getTime.toString))
      }
    }
  }
}
}

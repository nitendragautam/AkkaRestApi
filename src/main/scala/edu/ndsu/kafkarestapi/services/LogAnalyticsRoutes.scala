package edu.ndsu.kafkarestapi.services

import akka.actor.{ActorSystem, Props}
import akka.http.scaladsl.model.{HttpEntity, HttpResponse, StatusCode}
import akka.http.scaladsl.server.Directives._
import edu.ndsu.kafkarestapi.actors.LogAnalyticsActors
import edu.ndsu.kafkarestapi.model.{LogAnalyticsRequest, LogAnalyticsRequestJSON}

/** Handles the Incoming Rest WebS Services Request
  *
  *
  *
  */
class LogAnalyticsRoutes(implicit system: ActorSystem)
extends LogAnalyticsRequestJSON
{

val logAnalyticsActor = system.actorOf(Props[LogAnalyticsActors])


var routes ={
  path("LogAnalyticsService" / "sendLogsToKafka"){
    post {
      entity(as[LogAnalyticsRequest]){
        logAnalyticsRequest =>

          complete {

            val logData = logAnalyticsRequest.dataLocation

            //Status Code Integer
            HttpResponse(StatusCode.int2StatusCode(200),
              entity = s"Data : $logData Request Received.")
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

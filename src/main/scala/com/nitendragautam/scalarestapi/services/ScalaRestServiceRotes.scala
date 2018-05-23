package com.nitendragautam.scalarestapi.services

import akka.actor.{ActorSystem}
import akka.http.scaladsl.model.{HttpEntity, HttpResponse, StatusCode}
import akka.http.scaladsl.server.Directives._
import com.typesafe.config.ConfigFactory


/** Handles the Incoming RestServices Request
  **
  */
class ScalaRestService extends RestServices {

  val scalaRestServiceRoutes = pingRoute
}
trait RestServices extends KafkaMessageRequestJson
{

  implicit val system = ActorSystem()

  val config = ConfigFactory.load()
//val kafkaRestApiActor = system.actorOf(Props[KafkaRestApiActors])


var kafkaRoute =
  path("ScalaRestAPIService" / "sendLogsToKafka"){
    post {
      entity(as[KafkaMessageRequest]){
        kafkaMessageRequest =>
//Call Kafka Rest API Actor
         // system.scheduler.scheduleOnce(200 millis,kafkaRestApiActor,kafkaMessageRequest)
          complete {



            //Status Code Integer
            HttpResponse(StatusCode.int2StatusCode(200),
              entity = s"Data : Request Received.")
          }
      }
    }
  }

  //Read the config from config File
  val versionRoute =
    path("ScalaRestAPIService" /"config"){
      get {

        complete { //When completed

          HttpResponse (entity = HttpEntity(config.getString("api.version")))

        }

      }
    }


  val pingRoute =
    path("ScalaRestAPIService" / "ping"){
    get {
      complete {
        HttpResponse(entity = HttpEntity(java.util.Calendar.getInstance().getTime.toString))
      }
    }
  }





}

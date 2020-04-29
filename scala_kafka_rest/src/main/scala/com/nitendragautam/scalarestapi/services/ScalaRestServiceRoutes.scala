package com.nitendragautam.scalarestapi.services

import akka.actor.{ActorSystem, Props}
import akka.http.scaladsl.model.{HttpEntity, HttpResponse, StatusCode}
import akka.http.scaladsl.server.Directives._
import com.nitendragautam.scalarestapi.actors.KafkaRestApiActors
import com.nitendragautam.scalarestapi.util.GeneralUtility
import com.typesafe.config.ConfigFactory
import org.slf4j.{Logger, LoggerFactory}

import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

/** Handles the Incoming RestServices Request
  **
  */
class ScalaRestService extends RestServices {


  val scalaRestServiceRoutes = pingRoute ~ getTimeRoute ~kafkaRoute
}
trait RestServices extends MessageRequestJson
{

  private val logger:Logger = LoggerFactory.getLogger(classOf[RestServices])
  implicit val system = ActorSystem()

  val config = ConfigFactory.load()
  val utility = new GeneralUtility



var kafkaRoute =
  path("scalarestapi" / "sendmessagetokafka"){
    post {
      entity(as[KafkaMessageRequest]){
        kafkaMessageRequest =>

          val apiStatus = utility.isApiEnabled("kafka")

          apiStatus match {
            case true =>
              {
                logger.info("Calling Kafka rest API")
                val kafkaRestApiActor = system.actorOf(Props[KafkaRestApiActors])
                //Call Kafka Rest API Actor
                system.scheduler.scheduleOnce(200 millis,kafkaRestApiActor,kafkaMessageRequest)
                complete(HttpResponse(StatusCode.int2StatusCode(200),
                  entity = s"Data : Request Received."))
              }
            case false =>{

              logger.info("Kafka Rest API is Disabled")
              complete(HttpResponse(StatusCode.int2StatusCode(405),
                entity = s"Data : Method Disabled."))
            }

            }

          }

      }
    }


  //Rest Api With S2S Authentification Enabled




  //Read the config from config File
  val versionRoute =
    path("scalarestapi" /"config"){
      get {

        complete { //When completed

          HttpResponse (entity = HttpEntity(config.getString("api.version")))

        }

      }
    }


  val pingRoute =
    path("scalarestapi" / "ping"){
    get {
      complete {
        HttpResponse(StatusCode.int2StatusCode(200),entity=HttpEntity("pong"))
      }
    }
  }

  val getTimeRoute =
    path("scalarestapi" / "gettime"){
      get{
        complete{
          HttpResponse(entity = HttpEntity(java.util.Calendar.getInstance().getTime.toString))
        }
      }
    }





}

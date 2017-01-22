package edu.ndsu.kafkarestapi.main

import akka.actor.{ActorSystem, Props}
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.typesafe.config.ConfigFactory
import edu.ndsu.kafkarestapi.services.LogAnalyticsRoutes





object ApplicationBoot extends App {

  // Defines all implicit dependencies required by Akka HTTP.
  // The ActorSystem instance is needed both by
  // Akka HTTP .

  // we need an ActorSystem to host our application in
  implicit val system = ActorSystem("KafkaRestApiApp")
  implicit val materializer = ActorMaterializer()

  val mainRouteService = new LogAnalyticsRoutes()
  val config = ConfigFactory.load()
  val address = config.getString("server.address")
  val port = config.getInt("server.port")

  //Starting the Web Service
  Http().bindAndHandle(mainRouteService.routes,address,port)
}
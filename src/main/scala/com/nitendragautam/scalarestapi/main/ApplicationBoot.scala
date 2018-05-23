package com.nitendragautam.scalarestapi.main

import akka.actor.{ActorSystem, Props}
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.nitendragautam.scalarestapi.services.ScalaRestService
import com.typesafe.config.ConfigFactory





object ApplicationBoot extends App {

  // Defines all implicit dependencies required by Akka HTTP.
  // The ActorSystem instance is needed both by
  // Akka HTTP .

  // we need an ActorSystem to host our application in
  implicit val system = ActorSystem("KafkaRestApiApp")
  implicit val materializer = ActorMaterializer()

  implicit val scalaRestService = new ScalaRestService
  val mainRoute = scalaRestService.scalaRestServiceRoutes
  val config = ConfigFactory.load()
  val address = config.getString("server.address")
  val port = config.getInt("server.port")

  //Starting the Web Service
  Http().bindAndHandle(mainRoute,address,port)
}
package com.nitendragautam.scalarestapi.services

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json.DefaultJsonProtocol

/**
  *Case Class for Handling  Scala Rest API JSON When Post API is called
  *
  */
case class KafkaMessageRequest(firstName :String, lastName :String)


/*
Object Class for Handling Scala Rest API  JSON
 */

trait KafkaMessageRequestJson extends SprayJsonSupport with DefaultJsonProtocol{
  implicit val kafkaMessageJsonFormat = jsonFormat2(KafkaMessageRequest)
}

/*
{
	"firstName":"Hello",
	"lastName":"World"
}
 */
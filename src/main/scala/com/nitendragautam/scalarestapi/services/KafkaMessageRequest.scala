package com.nitendragautam.scalarestapi.services

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json.DefaultJsonProtocol

/**
  *Case Class for Handling  Scala Rest API JSON When Post API is called
  *
  */
case class KafkaMessageRequest(firstName :String, lastName :String)



/* Case class for IOT Vehicle Data Sensors Used for Self Driving Vehicle*/
case class VehicleData(vehicleId: String,
                       vehicleType: String,
                       routeId: String,
                       latitude: String,
                       longitude: String,
                       timeStamp: String,
                       vehicleSpeed: Double,
                       fuelLevel: Double,
                       outsideTemperature: Int,
                       engineTemperature: Int)


/**
  * trait for handling Marshalling and Unmarshalling of JSON
  */

trait MessageRequestJson extends SprayJsonSupport with DefaultJsonProtocol{
  implicit val kafkaMessageJsonFormat = jsonFormat2(KafkaMessageRequest)
  implicit val vehicleDataJsonFormat = jsonFormat10(VehicleData)

}

/*
{
	"firstName":"Hello",
	"lastName":"World"
}
 */
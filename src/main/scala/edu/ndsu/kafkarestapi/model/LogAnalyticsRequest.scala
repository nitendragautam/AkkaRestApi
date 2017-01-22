package edu.ndsu.kafkarestapi.model

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json.DefaultJsonProtocol

/**
  *Case Class for Handling LogAnalytics JSON When Post API is called
  *
  */
case class LogAnalyticsRequest(dataLocation :String)


/*
Object Class for Handling LogAnalyticsRequest JSON
 */

trait LogAnalyticsRequestJSON extends SprayJsonSupport with DefaultJsonProtocol{
  implicit val logAnalyticsJOSNFormat = jsonFormat1(LogAnalyticsRequest)
}

/*
{
	"dataLocation":"Location of Data"
}
 */
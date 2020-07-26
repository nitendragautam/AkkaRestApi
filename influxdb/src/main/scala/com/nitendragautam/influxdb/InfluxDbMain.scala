package com.nitendragautam.influxdb

import java.util.concurrent.TimeUnit

import org.influxdb.dto.Point


object InfluxDbMain {

  def main(args :Array[String]): Unit ={

    val influxdbRestService = new InfluxdbRestService


//Create aDatabase
val dbName= "loganalytics"
    influxdbRestService.createDatabase(dbName)




    val point1 = Point

                 .measurement("cpu")
                 .time(System.currentTimeMillis() ,TimeUnit.MILLISECONDS)
                  .tag("atag", "test")  //Tag Name
                  .addField("idle",80L)   //Field Name and Value
                  .addField("userTime",190L)
                  .addField("system", 120L)
                  .build()

    val point2 = Point
      .measurement("cpu")  //This identifies the Data
      .time(System.currentTimeMillis() ,TimeUnit.MILLISECONDS)
      .tag("atag", "test")
      .addField("idle",30L)
      .addField("userTime",90L)
      .addField("system", 190L)
      .build()

    influxdbRestService.writeDataInfluxDb(point1 ,dbName)
    influxdbRestService.writeDataInfluxDb(point2 ,dbName)



    val databaseQuery ="SELECT * FROM cpu"
    val queryResut =influxdbRestService.queryDatabase(databaseQuery ,dbName)
    println(queryResut.getResults)


  }
}

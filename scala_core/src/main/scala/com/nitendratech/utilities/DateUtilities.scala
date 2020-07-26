package com.nitendratech.utilities

import java.text.SimpleDateFormat
import java.util.{Calendar, Date, TimeZone}

/**
  * Created by nitendragautam on 6/23/2017.
  */
object DateUtilities {


  def main (args:Array[String]): Unit ={
    val dateFormat = "yyyy-MM-dd-HH-mm-ss"

    val dateString = "2018-02-25-17-02-31"

    println(System.currentTimeMillis()-getEpochTime(dateString,dateFormat))
  }
/*
Converts date into Given Format
 */
  def convertDateFormat(dateString :Date ,dateFormat :String): String ={
  val format = new SimpleDateFormat(dateFormat)
    format.format(dateString)
  }



  def getEpochTime(dateString: String ,dateFormat: String): Long ={
val format = new SimpleDateFormat(dateFormat)
    val date = format.parse(dateString)
    val timeInMilliSec = date.getTime

    timeInMilliSec
  }

  /**
    * Get Latest Date Time
    * @param timeZoneID
    * @param inputDateFormat
    * @return Date String
    */
  def getLatestDateTime(timeZoneID: String, inputDateFormat:String): String ={
  val timeZone = TimeZone.getTimeZone(timeZoneID)
    val dateFormat = new SimpleDateFormat(inputDateFormat)
    dateFormat.setTimeZone(timeZone)
    val date = Calendar.getInstance().getTime()
    dateFormat.format(date)
  }

  /**
    *Get Splunk Query Time
    * @return String
    */

  def getSplunkTime() :String ={
    val gmt = TimeZone.getTimeZone("GMT")
    val format = new SimpleDateFormat("hh:mm:ss")
    format.setTimeZone(gmt)
    val date = Calendar.getInstance().getTime()
    format.format(date)
  }

}

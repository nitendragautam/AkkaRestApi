package com.nitendragautam.scalarestapi.util

import com.typesafe.config.ConfigFactory

/**
  * Created by nitendragautam on 6/2/2018.
  */
class GeneralUtility {
  val config = ConfigFactory.load()


  def isApiEnabled(apiName: String): Boolean ={
    var isApiEnabled = false

    val apiStatus = config.getString("api."+apiName)

    if (apiStatus.equals("enabled"))
        isApiEnabled = true

    isApiEnabled
  }

}

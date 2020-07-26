package com.nitendragautam.utilities

/**
  * Created by nitendragautam on 3/25/2018.
  */
class ProxyUtility {


  def getProxy(): Unit= {

    val properties = System.getProperties

    //Set the httpProxy
    properties.setProperty("https.proxyHost","proxy1")

    properties.setProperty("https:proxyHost","80")

    //Excluding the Hosts which does not Requires proxy
    properties.setProperty("http.nonProxyHosts","www.google.com*|www.quora.com*")

  }

}

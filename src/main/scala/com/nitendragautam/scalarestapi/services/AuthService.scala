package com.nitendragautam.scalarestapi.services

import java.util.Base64

import com.typesafe.config.ConfigFactory

import scala.concurrent.Future

/**
  * Created by nitendragautam on 6/2/2018.
  */
class AuthService {

  val config = ConfigFactory.load()

  def validateToken(authToken :String,clientId :String,requestId:String ) =Future[Boolean]
    {

      var isValidToken =false
      val appClientID= config.getString("auth.clientId")
      val appClientSecret = config.getString("auth.clientSecret")
      val appToken = config.getString("auth.appToken")
      val enCodingFromRequest = appClientID +":" +
        appClientSecret +":" + requestId + ":" +appToken

      val bytesEncoded = Base64.getEncoder.encodeToString(enCodingFromRequest.getBytes)

      if(appClientID.equals(clientId) && bytesEncoded.equals(authToken)){
        isValidToken = true

      }

      isValidToken

    }

}

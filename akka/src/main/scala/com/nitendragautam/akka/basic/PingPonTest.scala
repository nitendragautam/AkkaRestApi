package com.nitendragautam.akka.basic

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

/**
  * Created by nitendragautam on 7/7/2018.
  */

case object PingMessage
case object PongMessage
case object StartMessage
case object StopMessage

/**
  * Ping Actor
  */
class Ping(pong: ActorRef) extends Actor {

  var count = 0

  // Method without Any Parameter
  def incrementAndPrint {count += 1; println("ping")}

  // If any Object is received

  def receive ={

    case StartMessage =>
      incrementAndPrint
      pong ! PingMessage

    case PongMessage =>
      incrementAndPrint


      if(count > 99){

        sender ! StopMessage
        println("Ping Stopped")
        context.stop(self)
      } else {
        sender ! PingMessage
      }

  }

}

/**
  * Pong Actor
* */


class Pong extends Actor {

  def receive = {

    //If Ping Message is received send  message Back
    case PingMessage =>
      println("pong")
      sender ! PongMessage



    case StopMessage =>
      println("pong Stopped")
      context.stop(self)

  }
}




object PingPonTest extends App{

  // Create a new Actor System

  val system = ActorSystem("PingPongSystem")

  /* Create a Pong Actor */
  val pong = system.actorOf(Props[Pong],name="pong")


  /* Create a ping Actor */

 val ping = system.actorOf(Props(new Ping(pong)),name="ping")


  // Send Message to Ping Actor

  ping ! StartMessage

}

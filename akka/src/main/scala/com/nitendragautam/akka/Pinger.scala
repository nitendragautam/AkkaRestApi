package com.nitendragautam.akka

import akka.actor.{Actor, ActorRef, ActorSystem, PoisonPill, Props}

import scala.concurrent.duration._

case object Ping
case object Pong


object PingPongApp {

  def main(args:Array[String]){
  //Need a Actor System for Actor
  val system = ActorSystem("PingPongApp")

  val pinger = system.actorOf(Props[Pinger],"pinger")

  //Pinger as a reference of ponger
  val ponger = system.actorOf(Props(classOf[Ponger],pinger),"ponger")

  import system.dispatcher

  //Schedule the Actor System after 500 millis System
  system.scheduler.scheduleOnce(500 millis){

    ponger ! Ping  //Send Ping messages to ponger

  }

}}


class Pinger  extends Actor {

var countDown = 50

  def receive = {

    case Pong =>

      println("received Pong")

      if (countDown > 0){
        countDown -=1 //Decrease by 1
        sender() ! Ping //Send Ping to sender
      } else {
        sender() ! PoisonPill  //Telling the Sender to Shut Down
        self ! PoisonPill


      }

  }
}


//Passing Actor Reference to Ponger
class Ponger(pinger :ActorRef) extends Actor {


  def receive = {
    case Ping =>
      println("Ping Received")
      pinger ! Pong
  }
}


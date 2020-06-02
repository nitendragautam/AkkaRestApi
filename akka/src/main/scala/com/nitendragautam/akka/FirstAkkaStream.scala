package com.nitendragautam.akkastreams

import akka.actor.ActorSystem
import akka.stream.{ActorMaterializer, OverflowStrategy}
import akka.stream.scaladsl.{Flow, Keep, RunnableGraph, Sink, Source}

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
/**
  * Ref :https://opencredo.com/introduction-to-akka-streams-getting-started/

 */

object FirstAkkaStream {

  def main(args :Array[String]): Unit = {
    implicit val system = ActorSystem("StreamActorSystem")
    //ActorMaterializer is responsible for creating actors that runs the processing flow
    implicit val materializer = ActorMaterializer()

    //Stream Sources
    val sourceFromRange =Source( 1 to 10)
    val sourceFromIterable =Source(List(1,2,3))
    val sourceFromFuture = Source.fromFuture(Future.successful("hello"))
    val sourceWithSingleElement =Source.single("just one")
    val sourceEmittingTheSameElement = Source.repeat("again and again")
    val emptySource =Source.empty



//Stream Sinks
    val sinkPrintingOutElements = Sink.foreach[String](println(_))
    val sinkCalculatingASumOfElements = Sink.fold[Int ,Int](0)(_ + _)
    val sinkReturningTheFirstElement = Sink.head
    val sinkNoop = Sink.ignore


    //Flow
    val flowDoublingElements = Flow[Int].map(_ *2)
    val flowFilteringOutOddElements = Flow[Int].filter(_ % 2 ==0)
    val flowBatchingElemets = Flow[Int].grouped(10)
    val flowBufferingElements = Flow[String].buffer(1000,OverflowStrategy.backpressure)

/*
Defining the Stream
 */

    val streamCalculatingSumOfElements
    :RunnableGraph[Future[Int]]=
      sourceFromIterable.toMat(sinkCalculatingASumOfElements)(Keep.right)

    //Include Transformations
    val streamCalculatingSumOfDoubledElements :
      RunnableGraph[Future[Int]] =
    sourceFromIterable.via(flowDoublingElements)
      .toMat(sinkCalculatingASumOfElements)(Keep.right)

    //Running the Stream
    //To use Future ,need to use Executing COntext
    /*import scala.concurrent.ExecutionContext.Implicits.global
    http://docs.scala-lang.org/overviews/core/futures.html#the-global-execution-context
     */
    val sumOfElements :Future[Int]=
    streamCalculatingSumOfElements.run()

    sumOfElements.foreach(println) //prints 6
    val sumOfDoubledElements :Future[Int]=
      streamCalculatingSumOfDoubledElements.run()
      sumOfDoubledElements.foreach(println)  //prints 12

//running the stream by attaching specified Link
    sourceFromIterable.via(flowDoublingElements).runWith(
      sinkCalculatingASumOfElements)
      .foreach(println)

//Runs the Stream by attaching sink that folds over elements on a stream
    Source(List(1,2,3)).map(_ * 2).runFold(0)(_ + _).foreach(println)

  }}
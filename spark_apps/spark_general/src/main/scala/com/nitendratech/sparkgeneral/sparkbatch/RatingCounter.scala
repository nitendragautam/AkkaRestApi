package com.nitendratech.scalaspark.sparkbatch

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.log4j._



/** Count up how many of each star rating exists in the MovieLens 100K data set. */
object RatingsCounter {

  /** Our main function where the action happens */
  def main(args: Array[String]) {


    // Set the log level to only print errors
    Logger.getLogger("org").setLevel(Level.ERROR)
val sparkConf = new SparkConf()
           .setAppName("RatingsCounter")
           .setMaster("local") //Need Local for running Spark from the IDE

    // Create a SparkContext using every core of the local machine, named RatingsCounter
    val sc = new SparkContext(sparkConf)

    // Load up each line of the ratings data into an RDD
    val lines = sc.textFile("datasets/ml-100k/u.data")

    // Convert each line to a string, split it out by tabs, and extract the third field.
    // (The file format is userID, movieID, rating, timestamp)
    /*
    Takes all the lines and maps to variable x ,which then is converted to String and Splitted based on space
    the third row or ratings is extracted .
     */
   val ratingsRDD = lines.map(x => x.toString().split("\t")(2)) //Extracting the Third Field as we are only interested in Ratings


    // Count up how many times each value (rating) occurs and returns a Map Object

   val results = ratingsRDD.countByValue()

    //Sorting the result by actual Ratings Value
    // Sort the resulting map of (rating, count) tuples
    val sortedResults = results.toSeq.sortBy(_._1)

    // Print each result on its own line.
   sortedResults.foreach(println)

    sc.stop()
  }
}

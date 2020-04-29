package com.nitendragautam.scalablog

/**
  * Scala Data Structures
  *
  * Arrays
  * Lists
  * Sets
  * Tuple
  * Maps
  * Option
  */
object DataStructures {

  def main(args: Array[String]): Unit ={

    /**
      * In Scala, an array is a collection of similar elements.
      * It can contain duplicates. Arrays are also immutable in nature.
      * Further, you can access elements of an array using an index:
      */

    //Declare an Array by Assigining some Values
    var name1 = Array("Nitendra" ,"Gautam","Ram","Hadoop")

    println(name1(0))

    //Declare an Array Using new Keywords

    var nameArray: Array[String]= new Array[String](3)

    var name = new Array[String](3)

    //Assign Values to Array
    name(0) ="Nitendra"
    name(1)= "Faizy"
    name(2) = "Learning Scala"

    println(name.length)

    //Access an Element in a List using Index
    print(name(0))


  }

}

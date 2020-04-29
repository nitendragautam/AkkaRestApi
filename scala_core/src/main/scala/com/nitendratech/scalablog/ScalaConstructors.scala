package com.nitendragautam.scalablog

object ScalaConstructors {


  def main(args: Array[String]): Unit = {


    /*
    Constructors can have Optional Parameters by providing a default Value
     */


    class Point(var a: Int =0,  var b: Int =0)

    val origin = new Point //As no Value is Defined , Value of a and b is set to Zero

    val point1 = new Point(2)
    println(point1.a) //Prints 2
    println(point1.b)  //Prints 2

    /*
    In Point Class a and b have the default value of 0 .
    If no arguments is given ,value of a and b would be taken as zero.
    In Scala arguments in constructor is read from left to Right.
    If we just want to pass the b parameter , we would need to name the Parameter
     */

    val point2 = new Point(3) //a will be assigned as 3
    println(point2.a) //Prints 3

    val point3 = new Point(b=4) //b will be assigned as 4

    println(point3.b)



  }
}

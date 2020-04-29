package com.nitendragautam.scalablog

object ScalaClass {









  def main(args: Array[String]): Unit = {

    /*
  Scala Classes are Blueprint for Creating Objects.They can Contain methods,values,
  variables,types,objects, traits and Classes which are Collectively called Members

  Minimal Class Definition is the simply the Keyword Class and an identifier.
  Class Name should be Capitalized.
   */

    class Person

    val person1 = new Person

    /*
    In Scala new is used to Create an instance of the Class.Class ```Person``` has a
    default Constructor which takes no arguments because we have not defined any constructor .

     */

    class Point(var x: Int, var y: Int) {

      def move(dx: Int, dy: Int): Unit = {
        x = x + dx
        y = y + dy

      }

      override def toString: String =
        s"($x, $y)"
    }


    val point1 = new Point(2, 5)

    //Get first Element
    println(point1.x) //Prints 2

    println(point1) //Prints 2,5

    /*
  Here the Point Class has four members : Variables x and y ,methods move and toString .
  In Scala primary constructor is the class Signature (var x: Int, var y: Int) which is different
  from other Languages.
  Here the move method takes two Integer arguments and returns the Unit () Value, which is similar to void in Java.

  ```toString``` method does not take arguments but returns a String Value.
  As ```toString```` methods overrides the toString from AnyRef ,it is used with override Keyword


   */
  }



}

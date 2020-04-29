package com.nitendragautam.scalablog

object ScalaPrivateGettersSetters {

  def main(args: Array[String]): Unit ={


    /*
    Scala Members are public by Default .If we want to hide them from
    outside the class we can make it private.

     */

    class Point{

      private var _x = 0
      private var _y = 0
      private val bound = 100

      def x = _x
      def x_= (newValue: Int): Unit ={
        if (newValue < bound ) _x = newValue else printWarning
      }


      def y = _y
      def y_= (newValue: Int): Unit = {
        if (newValue < bound) _y = newValue else printWarning
      }

      private def printWarning = println("WARNING: Out of Bounds")

    }

    val point1 = new Point

    point1.x = 99
    point1.y = 101 //Prints Out of Bounds Warning

    /*
    Here data is stored in private variables _x and _y.
    Methods ```def x``` and ```def y``` for accessing the private data.

    ```def x_=```  and ```def y_=``` are for validating and setting the value of ```_x``` and
    ```_y```.
    Here use use the special syntax for the setters ```_=``` appended to the identifier of the getter and the
    parameters come after.

     */


  }

}

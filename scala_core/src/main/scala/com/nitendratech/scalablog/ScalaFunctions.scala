package com.nitendragautam.scalablog

import com.google.gson.Gson
import com.nitendratech.utilities.DomainCollections.PersonDetail
import com.nitendratech.utilities.JsonDataUtility.nestedJson

/**
  * Created by nitendragautam on 9/16/2017.
  */
object ScalaFunctions {


  def main(args: Array[String]): Unit ={
   //Get Car Models from Json

    val jsonToCaseClass = new Gson().fromJson(nestedJson,classOf[PersonDetail])

    //Convert Json Data to Case Classes Object using Gson

    val carDetailsList = jsonToCaseClass.carsDetails



    //Seperate the Car Details by Space

    val carData = carDetailsList.map(_.models).mkString(" ")
    val carModelsList = carDetailsList.map(_.models)
    carModelsList.toList.foreach(f=>println(f))

    //functions
    def multiply(x :Int) ={x*x} //Define Multiply Function
    println("Multiply => "+multiply(3))

    def f1(s:String):Unit={
      println("Hello "+s)
    }
    f1("Nitendra ")

    def f2 :Unit= println("Hello from f2")
    f2


    //Bad Code
    def f4{println("Hello")} //Not Recommended

    def sum(x:Int ,y:Int) =println(x+y)
    println(sum(x=10,y=20))//named argument

    //anonymous function
    println((1 to 5).map(2*))
    println((1 to 5).map(x => x*x)) //Square of all the numbers

    println((1 to 5).map(_*2)) //underscore matches all numbers

    //Partial application

    def adder(m :Int ,n :Int) =  m +n


    val add2 = adder(2 ,_:Int)  //Using _as unnamed parameter

    println(add2(5))


    /*
    Curried fucntion in Scala
     */

    def multiplyCur(m :Int)(n:Int): Int = m*n

    //Calling with Both Arguments
    println(multiplyCur(3) (4))

    //Filling the first Parameter and partially applying the second parameter
    val timesTwo = multiplyCur(2) _

    println(timesTwo(3))

    //Taking  any function of multiple arguments and curry it.

    val currieAdd = (adder _).curried

    val addTwo = currieAdd(2)

    println(addTwo(6))  //Will add 6 +2
  }
}

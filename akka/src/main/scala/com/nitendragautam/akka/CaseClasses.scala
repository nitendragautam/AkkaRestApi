package com.nitendragautam.akka

import com.google.gson.Gson

/**
  * Created by nitendragautam on 6/9/2017.
  */
object CaseClasses {


  def main(args:Array[String]): Unit ={

    case class Person(name :String ,Address :String ,phone :String)

    val p1 = Person("Nitendra" ,"Dallas" ,"555")
    println(p1.name) //Get Name

    println(new Gson().toJson(p1))

  }
}

package com.nitendratech.scalapractice

import com.google.gson.Gson

/**
 * Created by @author nitendratech on 5/16/20
 */
object CaseClassExample {


  def main(args: Array[String]): Unit = {

    case class Person(name :String ,Address :String ,phone :String)
    val p1 = Person("Nitendra" ,"Dallas" ,"555")
    println(p1.name) //Get Name

    println(new Gson().toJson(p1))
  }

}

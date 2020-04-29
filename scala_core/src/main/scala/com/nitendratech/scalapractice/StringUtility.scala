package com.nitendratech.scalapractice

/**
  * Created by nitendragautam on 7/25/2017.
  */
object StringUtility {

  def main(args :Array[String]): Unit ={

   val s1 ="Hello"
    val s2 ="Hello"

    //Check if two are equal
    println(s1 == s2)

    val s3 = s1
    val s4: String = null

    //Check if String is equal to Null

    println(s3 == s4) //Does not show Null Pointer Exception

    //Compare two strings ignoring their Cases
    println(s1.equalsIgnoreCase(s2))


//Creatting MultilineStrings by using triple quotes
   val multiLineString =
     """This Is
       Multiline String
      sentence"""

    println(multiLineString)


    val multiLineString1 =
      """ This is
        |Multi Line String
        | Example
      using pipe | Symbol""".stripMargin

    println(multiLineString1)


    val multiLineString3 =
      """ This is MultiLine String
        #Example
        #Using
      new Symbol""".stripMargin('#')

    println(multiLineString3)

/*
Processing a String one Character at Time
 */

val upperCaseString = "hello ,world".map(c =>c.toUpper) //Change to Upper Case
    println(upperCaseString)

    val upperCaseSt = "hello ,world".map(_.toUpper)  //Changing to Upper Case in shorten Way

    println(upperCaseSt)



  }
}

package com.nitendratech.scalapractice

/**
  * Created by nitendragautam on 7/25/2017.
  */
object StringUtil {

  //Seperates the List of Words with supplied seperator
  def joiner(strings :List[String] ,seperator :String): String =
  strings.mkString(seperator)

  //Calls the Joins method with Parameters
  def joiner (strings :List[String]): String = joiner(strings ,"+")

def main(args :Array[String]): Unit ={


  println(joiner(List("Programming" ,"Scala" ,"is","Fun")))
}
}



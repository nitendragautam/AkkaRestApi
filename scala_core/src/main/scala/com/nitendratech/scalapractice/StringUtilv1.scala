package com.nitendratech.scalapractice

/**
  * Created by nitendragautam on 7/25/2017.
  */
object StringUtilv1 {

  //joiner method which takes default separator as space
  def joiner(strings :List[String] ,separator :String =" ") :String =
  strings.mkString(separator)

  def main(args :Array[String]): Unit ={
    println (joiner(List("Programming","Scala")))  //Default Separator

    println(joiner(List("Programming","Scala"),separator="+")) //Using custom Seperator


  }
}

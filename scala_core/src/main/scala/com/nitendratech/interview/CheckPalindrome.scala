package com.nitendragautam.interview


object CheckPalindrome{

  def checkPalindrome(s:String) :Boolean = s.reverse == s


  def main(args:Array[String]): Unit ={

    println(checkPalindrome("ana"))
  }


}

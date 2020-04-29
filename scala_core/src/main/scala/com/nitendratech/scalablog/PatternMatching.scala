package com.nitendragautam.scalablog

/**
 * Using Scala Case Classes instead of if/else statements 
 * 
 * to match patterns
 */
object PatternMatching {
  
  
  def matchColorToNumber(color:String) :Int = {
    
     val num= color match {
      case "Red" => 1
      case "Blue" =>2
      case "Green" =>3
      case "Yellow" =>4
      case _ => 0
      
    }
    
     num
  }
  
  def executeOperation(x:Int ,y: Int ,operator: String) :Double = {
    
    operator match {
      
      case "+" => x+y
      case "-" => x-y
      case "*" => x*y
      case "/" => (x/y).toDouble
      case _ => 0
   
    }

    }
  def matchDate(customDate: String): Unit ={

    customDate.length() match {
      case 8 => println(s"Date ${customDate} is of Format YYYYMMDD")
      case 6 => println(s" Date ${customDate} is of Format YYYYMM")
      case _ => println(s"Date ${customDate} is not in correct Format")
    }
    
  }
  def main(args:Array[String]){
    println(matchColorToNumber("Red"))
    println(executeOperation(2,3,""))

    matchDate("20190112")
    matchDate("201801")
    matchDate("")
  }
  
}
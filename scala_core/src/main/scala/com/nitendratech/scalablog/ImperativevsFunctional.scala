package com.nitendragautam.scalablog

/**
  * Created by nitendragautam on 10/7/2017.
  */
object ImperativevsFunctional {


  def main(args: Array[String]): Unit ={
println("Total Imperative Style "+totalImperative(List(1,3,5,7)))
    println("Total Functional Style "+totalFunctional(List(1,3,5,7)))
  }


  def totalImperative(list: List[Int]) ={

    var sum = 0

    for (i <- list){
      sum += i
    }
    sum
  }

  /**
    *
    * Functional Style Programming
    * Where we don't assign ant Variables
    * Functions don't have side effects
    * Referential Transparency
    */
  def totalFunctional(list: List[Int]) ={

    list.foldLeft(0) { (carryOver ,e) =>
      carryOver + e
    }

  }



}

package com.nitendragautam.scalablog

/**
 * One-Liners and For Comprehensions Example
 */
object ComprehensionExample {
  
  case class Participant(name: String ,score: Int ,active: Boolean)
  
  def main( args: Array[String]){
    
    val participants = Seq(
        Participant("Bill",35,true),
        Participant("Jack",56 ,false),
        Participant("Hari",96,true),
        Participant("Tom",56,true)
        )
        
        //Apply Some Filter
        println( participants.filter(_.score <50))
       
      val result = participants.filter(_.score <50).filter(_.active)
       .map(_.copy(active = false)) //changed the active status of selected participants to false
        
       println(result) //Gets a new Participant data with value of active as False
       
  }
  
}
package com.nitendratech.interview

object CollectionExcercise {


def getMinMaxFromList(a: Array[Int]): (Int,Int) ={

  if(a.isEmpty) throw new java.lang.UnsupportedOperationException("array is empty")

  else{
    a.foldLeft((a(0), a(0)))
    {
      case ((min,max),e) => (math.min(min,e),math.max(max,e))
    }
  }

}

  def main(args: Array[String]): Unit ={


    val inputList = Array(20,5,9,10)

    println(CollectionExcercise.getMinMaxFromList(inputList))
  }
}

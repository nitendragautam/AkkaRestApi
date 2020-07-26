package com.nitendratech.utilities

import java.io.File

import scala.io.Source

/**
  * Created by nitendragautam on 11/17/2017.
  */
class CommonUtilities {



  /*
  Read contents from the Files
   */


  def readFileContent(filePath: String) :String ={

    val fileContents = Source.fromFile(new File(filePath))

    //Return the Content
    fileContents.getLines().mkString
  }

  /**
    * Tails the files
    * @param filePath
    * @return
    */
  def tailFiles(filePath: String) : String = {

  val pathOfFile = new File(filePath)

  val fileSource = Source.fromFile(pathOfFile).getLines()

fileSource.toList.takeRight(5).toString()
}


  /*
  Returns the size of the File
   */
  def getFileSize(filePath: String): Int = {

    Source.fromFile(new File(filePath)).toString().size
  }




}



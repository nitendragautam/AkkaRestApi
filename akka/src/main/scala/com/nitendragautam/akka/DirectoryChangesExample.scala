package com.nitendragautam.akka

import java.nio.file.{FileSystem, FileSystems}

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.alpakka.file.scaladsl.DirectoryChangesSource
import scala.concurrent.duration._
/**
  * Created by nitendragautam on 6/3/2018.
  * Akka File Connectors
  * https://doc.akka.io/docs/alpakka/ffa20494/file.html
  */
object DirectoryChangesExample {

  def main(args: Array[String]): Unit ={

    implicit val system:ActorSystem = ActorSystem()
    implicit val materializer = ActorMaterializer()

    val directoryPath="D:\\App"

    val fs = FileSystems.getDefault()

    val changes = DirectoryChangesSource(fs.getPath(directoryPath),pollInterval=1.second ,maxBufferSize = 10000)

    changes.runForeach {
      case (path,change) =>println("Path: " + path + ",Change: " + change)

    }
  }

}

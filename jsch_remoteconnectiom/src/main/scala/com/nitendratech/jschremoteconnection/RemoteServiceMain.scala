package com.nitendratech.jschremoteconnection

import com.typesafe.config.ConfigFactory

/**
  * Created by nitendragautam on 4/28/2018.
  */
object RemoteServiceMain {


  def main(args:Array[String]): Unit ={


  val jschRemoteService = new JschRemoteService()

    val session = jschRemoteService.getRemoteSession()
    val remoteSftpChannel = jschRemoteService.getSftpChannel(session)


    //Check if directory exists

    val remotePath ="/home/nitendragautam/file.txt"
    jschRemoteService.isRemoteFileExists(remoteSftpChannel,remotePath)


    //Creates Folder Remotely
    jschRemoteService.createRemoteFolder(remoteSftpChannel,"/home/nitendragautam/folder1")

  }
}

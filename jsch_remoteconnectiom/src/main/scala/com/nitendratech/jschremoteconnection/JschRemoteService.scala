package com.nitendratech.jschremoteconnection

import java.io.{ByteArrayInputStream, InputStream}
import java.util.zip.GZIPInputStream

import com.jcraft.jsch._
import com.typesafe.config.ConfigFactory
import org.apache.commons.io.IOUtils
import org.slf4j.LoggerFactory

/**
  * Created by nitendragautam on 3/17/2018.
  *Contains Utility for Interacting with remote Server
  *
  */
class JschRemoteService {
  val logger = LoggerFactory.getLogger(classOf[JschRemoteService])

  val config = ConfigFactory.parseResources("application.conf")
  val REMOTE_SERVER_IP_ADDRESS=config.getString("remoteServer.remoteIPAddress")
  val REMOTE_SERVER_USER_NAME=config.getString("remoteServer.userName")
  val REMOTE_SERVER_USER_PASS=config.getString("remoteServer.userPassWord")


  /**
    * Connects a remote server and gets a gets a remote session
    * session.connect() opens a new connection to remote SSH Server
    *
    */

  def getRemoteSession(): Session ={
    val jsch = new JSch()
    val session = jsch.getSession(REMOTE_SERVER_USER_NAME,REMOTE_SERVER_IP_ADDRESS,22)
    session.setPassword(REMOTE_SERVER_USER_PASS)
    session.setConfig("StrictHostKeyChecking","no")
    session.connect()
    session

  }

  /**
    * Gets SFTP Session
    * @param jschSession
    * @return
    */

  def getSftpChannel(jschSession :Session):ChannelSftp ={
    val sftpChannel = jschSession.openChannel("sftp").asInstanceOf[ChannelSftp]
    sftpChannel.connect()
    sftpChannel
  }



  /**
    * Check if remote FIle Exists in Remote Server
    * @param sftpChannel
    * @param remotePath
    * @return
    */

  def isRemoteFileExists(sftpChannel:ChannelSftp, remotePath: String): Boolean = {

    var isRemoteFileExists = false
    try {
      val iS =  sftpChannel.get(remotePath)

      if (iS!= null)
        isRemoteFileExists = true
      else
        isRemoteFileExists =false
    }
    catch {
      case e: JSchException => {
        logger.info("JschException " + e.getMessage() )
      } case e: SftpException =>{
        logger.info(" Sftp Exception "+ e.getMessage )
      }
    }
  isRemoteFileExists

  }


  /**
    * Create a folder in Remote Server
    * @param sftpChannel
    * @param remotePath
    */
  def createRemoteFolder(sftpChannel: ChannelSftp ,remotePath: String): Unit = {
    sftpChannel.connect() //Connect through Sftp Channel
    sftpChannel.mkdir(remotePath)
  }



  /**
    *  Delete a remote Folder along with its Contents
    * @param sftpChannel
    * @param remotePath
    * @param remoteFileName
    */
  def deleteFolderRemote(sftpChannel: ChannelSftp, remotePath: String, remoteFileName: String): Unit ={
      sftpChannel.cd(remotePath)

    //Check if Remote Path is Empty
      if(sftpChannel.ls(remotePath).isEmpty == true)
        sftpChannel.rmdir(remotePath)
      else
        sftpChannel.rm(remotePath + "/" +remoteFileName) //First Delete the File
        sftpChannel.rmdir(remotePath) //Delete the Directory

  }


  /**
    *  Downloads the content from Remote Server as InputStream
    * @param sftpChannel
    * @param remoteFilePath
    * @return
    */
  def getContentFromRemote(sftpChannel:ChannelSftp, remoteFilePath: String): InputStream ={

    sftpChannel.get(remoteFilePath)
  }



  /**
    * Copy/Upload files to remote Server
    * @param sftpChannel
    * @param fileName
    * @param gzipInputStream
    * @param remotePath
    */
    def uploadFilestoRemote(sftpChannel: ChannelSftp,fileName: String ,gzipInputStream: GZIPInputStream ,remotePath: String): Unit ={

      sftpChannel.cd(remotePath)
      sftpChannel.put(new ByteArrayInputStream(IOUtils.toByteArray(gzipInputStream)),fileName)
    }


  /**
    * Executes a script on Remote Server
    * @param jschSession
    * @param command
    * @param commandType
    * @return
    */
  def runScriptonRemoteServer(jschSession: Session ,command:String ,commandType:String): String ={
    var results=""

    //Create a Execution Channel
    val channelExec = jschSession.openChannel("exec").asInstanceOf[ChannelExec]

    //Set Command
    channelExec.setCommand(commandType + " "+ command)
    channelExec.setInputStream(null)

    //Gets the Input Stream for Exec Channel which can be used to read the stream coming from the remote Server

    val in = channelExec.getInputStream

    //Execute the command

    //Read the Output from the InputStream from the remote Script

    results = IOUtils.toString(in,"UTF-8")

    val exitStatus = channelExec.getExitStatus

    //Wait till a thread is finished

    while(exitStatus == -1){
      Thread.sleep(1000)
    }

    results
  }


  /**
    * Execute a remote script without a exit code
    * @param jschSession
    * @param command
    */

  def executeRemoteScript(jschSession: Session, command:String): Unit ={
    //Creates a execution Channel
    val channelExec = jschSession.openChannel("exec").asInstanceOf[ChannelExec]

    channelExec.setCommand(command)
    channelExec.setInputStream(null)

    //Execute the command
    channelExec.connect()
  }

  /**
    * Closes all Channels
    * @param jschSession
    * @param sftpChannel
    */
  def closeAllChannels(jschSession: Session, sftpChannel: ChannelSftp ): Unit ={
    jschSession.disconnect()
    sftpChannel.disconnect()
  }
}

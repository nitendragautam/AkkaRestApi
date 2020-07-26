package com.nitendratech.utilities



/**
  * Created by nitendragautam on 6/2/2018.
  */
class LoggerUtil {

  private val logger: Logger = LoggerFactory.getLogger(classOf[LoggerUtil])


  /**
    * Logs a message with the `INFO` level.
    * @param logMessage the message to log
    */
  def info(logMessage: => String) {
    logger.info(logMessage)
  }

  /**
    * Logs a message with the `INFO` level with information about
    * errors
    *
    * @param logMessage the message to log
    * @param error the associated exception
    */
  def info(logMessage: => String, error: => Throwable) {
    logger.info(logMessage, error)
  }

  /**
    * Logs a message with the `DEBUG` level.
    * @param logMessage the message to log
    */
  def debug(logMessage: => String) {
    logger.debug(logMessage)
  }

  /**
    * Logs a message with the `DEBUG` Log level.
    *
    * @param logMessage the message to log
    * @param error the associated exception
    */
  def debug(logMessage: => String, error: => Throwable) {
    logger.debug(logMessage, error)
  }

  /**
    * Logs a message with the `ERROR` level.
    *
    * @param logMessage the message to log
    */
  def error(logMessage: => String) {
    logger.error(logMessage)
  }

  /**
    * Logs a message with the `ERROR` level.
    *
    * @param logMessage the message to log
    * @param error the associated exception
    */
  def error(logMessage: => String, error: => Throwable) {
    logger.error(logMessage, error)
  }

  /**
    * Logs a message with the `WARN` level.
    *
    * @param message the message to log
    */
  def warn(message: => String) {
    logger.warn(message)
  }

  /**
    * Logs a message with the `WARN` level.
    *
    * @param message the message to log
    * @param error the associated exception
    */
  def warn(message: => String, error: => Throwable) {
    logger.warn(message, error)
  }

}

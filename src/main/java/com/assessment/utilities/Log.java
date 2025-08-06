package com.assessment.utilities;

import org.apache.logging.log4j.*;

/**
 * Utility wrapper around Log4j logger.
 */
public class Log {
  private static final Logger logger = LogManager.getLogger(Log.class);

  /**
   * Logs an info-level message.
   *
   * @param msg Message to log
   */
  public static void info(String msg) {
    logger.info(msg);
  }

  /**
   * Logs an error-level message.
   *
   * @param msg Message to log
   */
  public static void error(String msg) {
    logger.error(msg);
  }
}

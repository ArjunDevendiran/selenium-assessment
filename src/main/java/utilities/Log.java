package utilities;

import org.apache.logging.log4j.*;

public class Log {
  private static final Logger logger = LogManager.getLogger(Log.class);
  public static void info(String msg){ logger.info(msg); }
  public static void error(String msg){ logger.error(msg); }
}

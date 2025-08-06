package utilities;

import java.io.*;
import java.util.Properties;

public class ConfigReader {
  private static Properties prop = new Properties();
  static {
    try (InputStream in = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
      prop.load(in);
    } catch (Exception e) { throw new RuntimeException(e); }
  }
  public static String get(String key) { return prop.getProperty(key); }
  public static String getUrl() {
    String env = get("env");
    return get(env + ".url");
  }
}

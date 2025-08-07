package com.assessment.utilities;

import java.io.*;
import java.util.Properties;

/**
 * Utility class for reading configuration properties.
 * Supports dynamic environment-based URLs like qa, dev, and stage.
 */
public class ConfigReader {
  private static final Properties prop = new Properties();

  static {
    try (InputStream in = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
      prop.load(in);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Get a property value by key.
   *
   * @param key Property key
   * @return Property value as String
   */
  public static String get(String key) {
    return prop.getProperty(key);
  }

  /**
   * Get the application URL based on the current environment.
   *
   * @return URL string
   */
  public static String getPageUrl() {
    String env = get("env");
    return get(env + ".url");
  }

  /**
   * Get the application's specific page URL based on the current environment.
   *
   * @param pageName String Name of the page (e.g., "questionnaire")
   * @return URL string
   */
  public static String getPageUrl(String pageName) {
    String env = get("env");
    return get(env + "." + pageName + ".url");
  }
}

package com.assessment.utilities;

import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.HashMap;
import java.util.Map;

  /**
   * Utility class for loading and accessing properties from configuration files.
   */
  public class PropertiesUtility {
    private static final Map<String, Properties> propertiesMap = new HashMap<>();
    private static final String TEST_DATA_DIR = "testData";

    /**
     * Loads a properties file from the testData directory.
     *
     * @param fileName String Name of the properties file (e.g., "dropdown.properties").
     * @throws RuntimeException If the file is not found or cannot be loaded.
     */
    public static void loadPropertiesFile(String fileName) {
      Properties props = new Properties();
      String filePath = Paths.get(TEST_DATA_DIR, fileName).toString();

      try (InputStream input = PropertiesUtility.class.getClassLoader()
              .getResourceAsStream(filePath)) {
        if (input == null) {
          throw new RuntimeException("Properties file not found: " + filePath);
        }
        props.load(input);
        propertiesMap.put(fileName, props);
      } catch (Exception e) {
        throw new RuntimeException("Failed to load properties file: " + filePath, e);
      }
    }

    /**
     * Retrieves a property value from a specified properties file.
     *
     * @param fileName String Name of the properties file (e.g., "dropdown.properties").
     * @param key  String The property key to look up.
     * @return The property value as a String.
     * @throws RuntimeException If the file or key is not found.
     */
    public static String getProperty(String fileName, String key) {
      Properties props = propertiesMap.get(fileName);
      if (props == null) {
        loadPropertiesFile(fileName); // Lazy-load if not already loaded
        props = propertiesMap.get(fileName);
      }

      String value = props.getProperty(key);
      if (value == null) {
        throw new RuntimeException(
                "Key '" + key + "' not found in file: " + fileName);
      }
      return value;
    }
  }

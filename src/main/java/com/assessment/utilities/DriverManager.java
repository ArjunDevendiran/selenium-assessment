package com.assessment.utilities;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@Getter
public class DriverManager {
  private WebDriver driver;

  public void initDriver() {
    if (driver == null) {
      driver = new ChromeDriver();
    }
  }

  public void quitDriver() {
    if (driver != null) {
      driver.quit();
    }
  }
}

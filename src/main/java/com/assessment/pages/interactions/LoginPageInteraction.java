package com.assessment.pages.interactions;

import com.assessment.utilities.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Interaction Page for the Login page.
 */
public class LoginPageInteraction {

  WebDriver driver;

  /**
   * Constructor to initialize WebDriver.
   *
   * @param driver Selenium WebDriver instance
   */
  public LoginPageInteraction(WebDriver driver) {
    this.driver = driver;
  }

  By username = By.id("username");
  By password = By.id("password");
  By submit = By.id("submit");

  /**
   * Open the login page URL.
   *
   * @param url Login page URL
   */
  public void open(String url) {
    driver.get(url);
    Log.info("Opened URL: " + url);
  }

  /**
   * Perform login with provided credentials.
   *
   * @param user Username
   * @param pass Password
   */
  public void login(String user, String pass) {
    driver.findElement(username).sendKeys(user);
    driver.findElement(password).sendKeys(pass);
    driver.findElement(submit).click();
    Log.info("Clicked login");

  }
}

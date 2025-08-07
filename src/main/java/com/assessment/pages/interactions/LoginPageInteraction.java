package com.assessment.pages.interactions;

import com.assessment.pages.models.LoginPageModel;
import com.assessment.utilities.DriverManager;
import com.assessment.utilities.Log;
import com.assessment.utilities.WaitUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Interaction Page for the Login page.
 */
public class LoginPageInteraction {

  private final WaitUtility waitUtility;
  private final WebDriver driver;
  private final LoginPageModel loginPageModel;
  /**
   * Constructor to initialize dependencies.
   *
   * @param driverManager DriverManager instance to interact with the browser
   * @param waitUtility WaitUtility class to interact with wait methods
   */
  public LoginPageInteraction(DriverManager driverManager, WaitUtility waitUtility) {
    this.driver = driverManager.getDriver();
    this.waitUtility = waitUtility;
    this.loginPageModel = new LoginPageModel(driver);
  }

  /**
   * Gets Login page locators
   *
   * @param element String
   * @return eleLocator By
   */
  public WebElement getLoginPageElementLocator(String element) {
    WebElement eleLocator;
    switch (element.toUpperCase()) {
      case "USERNAME":
        eleLocator = loginPageModel.getUsernameField();
        break;
      case "PASSWORD":
        eleLocator = loginPageModel.getPasswordField();
        break;
      case "LOGIN":
        eleLocator = loginPageModel.getLoginButton();
        break;
      default:
        Log.error(String.format("Unknown element requested: %s", element));
        throw new IllegalArgumentException(String.format("Unknown element requested: %s", element));
    }
    return eleLocator;
  }

  /**
   * Open the page URL.
   *
   * @param url String page URL
   */
  public void openTestSite(String url) {
    Log.debug(String.format("Opening URL: %s", url));
    driver.get(url);
    waitUtility.waitForPageToFinishLoad();
    Log.info(String.format("Opened URL: %s", url));
  }

  /**
   * Open the specified page URL.
   *
   * @param url String page URL
   */
  public void navigateToPage(String url) {
    Log.debug(String.format("Opening URL: %s", url));
    driver.navigate().to(url);
    waitUtility.waitForPageToFinishLoad();
    Log.info(String.format("Opened URL: %s", url));
  }

  /**
   * Enters the username and password in the login page fields.
   *
   * @param data String
   * @param field String
   */
  public void enterDataInExpectedField(String data, String field) {
    Log.debug(String.format("Entering: %s in %s", data, field));
    WebElement element = waitUtility.waitForElementToBeClickable(getLoginPageElementLocator(field));
    element.sendKeys(data);
    Log.info(String.format("Entered: %s in %s", data, field));
  }

  /**
   * Clicks Submit button.
   */
  public void clickSubmitButton() {
    Log.debug("Clicking Submit button");
    waitUtility.waitForElementToBeClickable(loginPageModel.getLoginButton()).click();
    Log.info("Clicked Submit button");
  }

  /**
   * Getting logged in success message.
   */
  public String getSuccessToastMessage() {
    Log.debug("Getting logged in success message");
    return waitUtility.waitForElementToBeVisible(loginPageModel.getSuccessToast()).getText().trim();
  }

  /**
   * Getting error message.
   */
  public String getErrorMessage() {
    Log.debug("Getting email error message");
    return waitUtility.waitForElementToBeVisible(loginPageModel.getEmailErrorMessage()).getText().trim();
  }

  /**
   * Getting page title for assertion.
   */
  public String getPageTitle() {
    Log.debug("Getting page header text");
    return driver.getTitle().trim();
  }

  /**
   * Getting page header title for assertion.
   */
  public String getPageHeaderText() {
    Log.debug("Getting page header text");
    return waitUtility.waitForElementToBeVisible(loginPageModel.getHeaderText()).getText().trim();
  }
}

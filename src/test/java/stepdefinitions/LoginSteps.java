package stepdefinitions;
import com.assessment.utilities.Log;
import io.cucumber.java.en.*;
import com.assessment.pages.interactions.LoginPageInteraction;
import com.assessment.utilities.ConfigReader;
import org.testng.Assert;

/**
 * Step definitions for login feature using Cucumber.
 */
public class LoginSteps {

  private final LoginPageInteraction loginPageInteraction;

  /**
   * Constructor to initialize dependencies.
   *
   * @param loginPageInteraction  LoginPageInteraction to get access to its methods
   */
  public LoginSteps(LoginPageInteraction loginPageInteraction) {
    this.loginPageInteraction = loginPageInteraction;
  }

  /**
   * Opens the test site based on environment config.
   */
  @Given("I open the Test environment")
  public void openTestSite(){
    Log.info("Opens the test site based on environment config");
    loginPageInteraction.openTestSite(ConfigReader.getLoginPageUrl());
  }

  /**
   * Enters the username and password in the login page fields.
   *
   * @param data String
   * @param field String
   */
  @When("I enter {string} in {string} field in the login page")
  public void enterDataInExpectedField(String data, String field){
    Log.info(String.format("Enters the username: %s and password: %s in the login page fields", data, field));
    loginPageInteraction.enterDataInExpectedField(data, field);
  }

  /**
   * Clicks Submit button.
   */
  @When("I click on Submit button in the login page")
  public void clickSubmitButton(){
    Log.info("Clicks Submit button");
    loginPageInteraction.clickSubmitButton();
  }

  /**
   * Assert that expected text is visible in the page.
   *
   * @param expectedValue String
   */
  @Then("I should see {string} toast")
  public void validateUserLoggedInSuccessfully(String expectedValue) {
    Log.info(String.format("Validating logged in page displays expected success toast message: %s", expectedValue));
    String actualValue = loginPageInteraction.getSuccessToastMessage();
    Assert.assertTrue(actualValue.contains(expectedValue), "Login success message is not displayed");
  }

  /**
   * Assert that expected error text is visible in the page.
   *
   * @param expectedValue String
   */
  @Then("I should see {string} error message")
  public void validateErrorMessage(String expectedValue) {
    Log.info(String.format("Validating login page displays expected error message: %s", expectedValue));
    String actualValue = loginPageInteraction.getErrorMessage();
    Assert.assertTrue(actualValue.contains(expectedValue), "Error  message is not displayed");
  }

  /**
   * Assert expected page title.
   *
   * @param pageTitle String
   */
  @Then("I should see page title {string}")
  public void validateLoginPageTitle(String pageTitle) {
    Log.info(String.format("Validating login page title displays expected text: %s", pageTitle));
    Assert.assertEquals(loginPageInteraction.getPageTitle(), pageTitle);
  }

  /**
   * Assert expected page header.
   *
   * @param text String
   */
  @Then("I should see page header {string}")
  public void validatePageHeader(String text) {
    Log.info(String.format("Validating login page title displays expected text: %s", text));
    Assert.assertEquals(loginPageInteraction.getPageHeaderText(), text);
  }

  /**
   * Assert expected field is displayed.
   *
   * @param field String
   */
  @Then("I should see {string} field")
  public void validateFieldIsDisplayed(String field) {
    Log.info(String.format("Validating field: %s is displayed", field));
    Assert.assertTrue(loginPageInteraction.getLoginPageElementLocator(field).isDisplayed(), String.format("Field: %s is not displayed", field));
  }

  /**
   * Assert expected button is displayed.
   *
   * @param button String
   */
  @Then("I should see {string} button")
  public void validateButtonIsDisplayed(String button) {
    Log.info(String.format("Validating button: %s is displayed", button));
    Assert.assertTrue(loginPageInteraction.getLoginPageElementLocator(button).isDisplayed(), String.format("Button: %s is not displayed", button));
  }

  /**
   * Assert expected button is displayed.
   *
   * @param button String
   * @param status String
   */
  @Then("^I should see \"([^\"]*)\" button is enabled (true|false)$")
  public void validateButtonIsDisplayed(String button, String status) {
    Log.info(String.format("Validating button: %s is enabled: %s", button, status));
    boolean shouldBeEnabled = Boolean.parseBoolean(status);
    boolean isEnabled = loginPageInteraction.getLoginPageElementLocator(button).isEnabled();
    boolean expected = !isEnabled && !shouldBeEnabled || isEnabled && shouldBeEnabled;
    Assert.assertTrue(expected, String.format("Button: '%s' enable/disable status is not as expected.", button));
  }

  /**
   * Assert expected field is masked.
   *
   * @param field String
   */
  @Then("I should see {string} field is masked")
  public void validateFieldIsMasked(String field) {
    Log.info(String.format("Validating field: %s is masked", field));
    String type = loginPageInteraction.getLoginPageElementLocator(field).getAttribute("type");
    Assert.assertEquals(type, "password", "Password field is not masked");
  }
}
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
   * Open the login page based on environment config.
   */
  @Given("I open the Test environment")
  public void openTestSite(){
    loginPageInteraction.openTestSite(ConfigReader.getUrl());
  }

  /**
   * Enters the username and password in the login page fields.
   *
   * @param data String
   * @param field String
   */
  @When("I enter {string} in {string} field in the login page")
  public void enterDataInExpectedField(String data, String field){
    loginPageInteraction.enterDataInExpectedField(data, field);
  }

  /**
   * Clicks Submit button.
   */
  @When("I click on Submit button in the login page")
  public void clickSubmitButton(){
    loginPageInteraction.clickSubmitButton();
  }

  /**
   * Assert that expected text is visible in the page.
   *
   * @param expectedValue String
   */
  @Then("I should see {string}")
  public void validateUserLoggedInSuccessfully(String expectedValue) {
    Log.debug(String.format("Validating logged in page displays expected value %s", expectedValue));
    String actualValue = loginPageInteraction.getUserLoggedInMessage();
    Assert.assertTrue(actualValue.contains(expectedValue), "Login success message is not displayed");
  }
}
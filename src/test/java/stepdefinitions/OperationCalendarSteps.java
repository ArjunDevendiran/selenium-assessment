package stepdefinitions;

import com.assessment.pages.interactions.LoginPageInteraction;
import com.assessment.pages.interactions.OperationCalendarPageInteraction;
import com.assessment.utilities.ConfigReader;
import com.assessment.utilities.Log;
import com.assessment.utilities.PropertiesUtility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

/**
 * Step definitions for Operation Calendar feature using Cucumber.
 */
public class OperationCalendarSteps {

  private final OperationCalendarPageInteraction operationCalendarPageInteraction;
  private final LoginPageInteraction loginPageInteraction;

  /**
   * Constructor to initialize dependencies.
   *
   * @param operationCalendarPageInteraction  OperationCalendarPageInteraction to get access to its methods
   * @param loginPageInteraction  LoginPageInteraction to get access to its methods
   */
  public OperationCalendarSteps(OperationCalendarPageInteraction operationCalendarPageInteraction, LoginPageInteraction loginPageInteraction) {
    this.operationCalendarPageInteraction = operationCalendarPageInteraction;
    this.loginPageInteraction = loginPageInteraction;
  }

  /**
   * Opens the test site based on environment config.
   *
   * @param pageName String Name of the page
   */
  @Given("I open the Questionnaire page")
  public void openTestSite(String pageName) {
    Log.info(String.format("Opens the page: %s", pageName));
    loginPageInteraction.navigateToPage(ConfigReader.getPageUrl());
  }

  /**
   * Expands Event dropdown
   */
  @When("I expand the Event dropdown")
  public void expandEventDropdown() {
    Log.info("Expands Event dropdown");
    operationCalendarPageInteraction.expandEventDropdown();
  }

  /**
   * Selects the 5th item from the dropdown
   */
  @When("I select the 5th item from the Event dropdown")
  public void selectFifthEventItemByPosition() {
    Log.info("Selects the 5th item from the dropdown");
    // Select by index (4 for 5th item, zero-based)
    operationCalendarPageInteraction.getEventDropdownList().get(4).click();
  }

  /**
   * Validates that the selected item matches the expected value
   *
   * @param expectedValueKey String Key for the expected value in properties file
   * @param propertiesFile String Name of the properties file containing expected values
   */
  @Then("I should see the selected item matches {string} from {string}")
  public void validateSelectedEventItem(String expectedValueKey, String propertiesFile) {
    Log.info("Validates that the selected item matches the expected value");
    String expectedText = PropertiesUtility.getProperty(propertiesFile, expectedValueKey);
    String actualText = operationCalendarPageInteraction.getSelectedEvent();
    Assert.assertEquals(actualText, expectedText,
            String.format("Selected item mismatch. Expected: '%s', Actual: '%s'",
                    expectedText, actualText));
  }

}
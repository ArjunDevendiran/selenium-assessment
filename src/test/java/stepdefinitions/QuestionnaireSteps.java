package stepdefinitions;

import com.assessment.pages.interactions.LoginPageInteraction;
import com.assessment.pages.interactions.QuestionnairePageInteraction;
import com.assessment.utilities.ConfigReader;
import com.assessment.utilities.Log;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

/**
 * Step definitions for login feature using Cucumber.
 */
public class QuestionnaireSteps {

  private final QuestionnairePageInteraction questionnairePageInteraction;
  private final LoginPageInteraction loginPageInteraction;

  /**
   * Constructor to initialize dependencies.
   *
   * @param questionnairePageInteraction  QuestionnairePageInteraction to get access to its methods
   * @param loginPageInteraction  LoginPageInteraction to get access to its methods
   */
  public QuestionnaireSteps(QuestionnairePageInteraction questionnairePageInteraction, LoginPageInteraction loginPageInteraction) {
    this.questionnairePageInteraction = questionnairePageInteraction;
    this.loginPageInteraction = loginPageInteraction;
  }

  /**
   * Opens the test site based on environment config.
   *
   * @param pageName String Name of the page to open
   */
  @Given("I open the {string} page")
  public void openTestSite(String pageName){
    Log.info("Opens the test site based on environment config");
    loginPageInteraction.navigateToPage(ConfigReader.getPageUrl(pageName));
  }

  /**
   * Randomly selects radio buttons for all questions.
   */
  @When("I randomly select radio buttons for all questions")
  public void enterDataInExpectedField(){
    Log.info("Randomly selects radio buttons for all questions");
    questionnairePageInteraction.randomlySelectRadioButtonsForAllRadioButtonPairs();
  }

  /**
   * Validates All questions at least 1 radio button should be selected.
   */
  @Then("I should see all questions at least 1 radio button selected")
  public void validateAtleaseOneRadioButtonOfallQsSelected(){
    Log.info("Validates all questions at least 1 radio button should be selected");
    List<WebElement> radioButtonPairs = questionnairePageInteraction.getRadioButtonPairs();

    for (WebElement radioButtonPair : radioButtonPairs) {
      List<WebElement> selectedRadioButton = radioButtonPair.findElements(By.cssSelector("input[type='radio']:checked"));
      Assert.assertFalse(selectedRadioButton.isEmpty(), "At least one radio button from the pair is not selected");
    }
  }

}
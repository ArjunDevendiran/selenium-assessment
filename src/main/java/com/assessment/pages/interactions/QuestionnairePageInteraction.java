package com.assessment.pages.interactions;

import com.assessment.pages.models.QuestionnairePageModel;
import com.assessment.utilities.DriverManager;
import com.assessment.utilities.Log;
import com.assessment.utilities.WaitUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

/**
 * Interaction Page for the Login page.
 */
public class QuestionnairePageInteraction {

  private final WaitUtility waitUtility;
  private final WebDriver driver;
  private final QuestionnairePageModel questionnairePageModel;
  Random random = new Random();
  /**
   * Constructor to initialize dependencies.
   *
   * @param driverManager DriverManager instance to interact with the browser
   * @param waitUtility WaitUtility class to interact with wait methods
   */
  public QuestionnairePageInteraction(DriverManager driverManager, WaitUtility waitUtility) {
    this.driver = driverManager.getDriver();
    this.waitUtility = waitUtility;
    this.questionnairePageModel = new QuestionnairePageModel(driver);
  }

  /**
   * Getting Radio button pairs
   */
  public List<WebElement> getRadioButtonPairs() {
    Log.debug("Getting Radio button pairs");
    waitUtility.waitForElementToBeVisible(questionnairePageModel.getQuestionnaireSection());
    return questionnairePageModel.getRadioButtonPairsList();
  }

  /**
   * Randomly selects Radio buttons for all radio button pairs
   */
  public void randomlySelectRadioButtonsForAllRadioButtonPairs() {
    Log.debug("Randomly selecting Radio buttons for all radio button pairs");
    List<WebElement> radioButtonPairList = getRadioButtonPairs();

    for (WebElement radioButtonPair : radioButtonPairList) {
      waitUtility.waitForElementToBeVisible(radioButtonPair);
      List<WebElement> radioButtons = radioButtonPair.findElements(By.tagName("input"));

      if (radioButtons.size() >= 2) {
        int randomIndex = this.random.nextInt(2);
        WebElement radioToSelect = radioButtons.get(randomIndex);
        waitUtility.scrollElementIntoView(radioToSelect);
        radioToSelect.click();
      }
    }
  }

}

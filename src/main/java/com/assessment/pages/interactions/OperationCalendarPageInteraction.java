package com.assessment.pages.interactions;

import com.assessment.pages.models.OperationCalendarPageModel;
import com.assessment.utilities.DriverManager;
import com.assessment.utilities.Log;
import com.assessment.utilities.WaitUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Interaction Page for the Operation Calendar page.
 */
public class OperationCalendarPageInteraction {

  private final WaitUtility waitUtility;
  private final WebDriver driver;
  private final OperationCalendarPageModel operationCalendarPageModel;
  /**
   * Constructor to initialize dependencies.
   *
   * @param driverManager DriverManager instance to interact with the browser
   * @param waitUtility WaitUtility class to interact with wait methods
   */
  public OperationCalendarPageInteraction(DriverManager driverManager, WaitUtility waitUtility) {
    this.driver = driverManager.getDriver();
    this.waitUtility = waitUtility;
    this.operationCalendarPageModel = new OperationCalendarPageModel(driver);
  }

  /**
   * Expands Event dropdown.
   */
  public void expandEventDropdown() {
    Log.debug("Expanding Event dropdown");
    WebElement element = waitUtility.waitForElementToBeClickable(operationCalendarPageModel.getEventDropdown());
    element.click();
  }

  /**
   * Gets Event dropdown list.
   *
   * @return List<WebElement> List of dropdown options
   */
  public List<WebElement> getEventDropdownList() {
    Log.debug("Getting Event dropdown list");
    return operationCalendarPageModel.getEventDropdownOptions();
  }

  /**
   * Gets selected Event from the dropdown.
   *
   * @return expectedText String
   */
  public String getSelectedEvent() {
    Log.debug("Getting selected Event from the dropdown");
    return operationCalendarPageModel.getSelectedEvent().getText().trim();
  }


}

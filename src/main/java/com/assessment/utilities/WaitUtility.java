package com.assessment.utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtility {

  private final WebDriver driver;
  // Default timeout for waiting conditions
  private final int defaultTimeoutInSeconds = 4;
  private final int pollingIntervalInSeconds = 2;

  public WaitUtility(DriverManager driverManager) {
    this.driver = driverManager.getDriver();
  }

  /**
   * Wait for a page to finish loading
   */
  public void waitForPageToFinishLoad() {
    new WebDriverWait(driver, Duration.ofSeconds(defaultTimeoutInSeconds)).until(
            webDriver -> ((JavascriptExecutor) webDriver)
                    .executeScript("return document.readyState")
                    .equals("complete")
    );
  }

  /**
   * Waits for an element to become visible on the page using a locator from SupplyLocatorInfo.
   *
   * @param elementInfo By data containing the locator of the element.
   * @return The visible WebElement.
   */
  public WebElement waitForElementToBeVisible(WebElement elementInfo) {
    FluentWait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(defaultTimeoutInSeconds))
            .pollingEvery(Duration.ofSeconds(pollingIntervalInSeconds))
            .ignoring(NoSuchElementException.class);
    try {
      return wait.until(ExpectedConditions.visibilityOf(elementInfo));
    } catch (Exception e) {
      return null;
    }
  }

  /**
   * Waits for an element to be clickable.
   *
   * @param elementInfo By data containing the locator of the element.
   * @return The WebElement that is clickable.
   */
  public WebElement waitForElementToBeClickable(WebElement elementInfo) {
    FluentWait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(defaultTimeoutInSeconds))
            .pollingEvery(Duration.ofSeconds(pollingIntervalInSeconds))
            .ignoring(NoSuchElementException.class);
    try {
      return wait.until(ExpectedConditions.elementToBeClickable(elementInfo)); // Wait until element is clickable
    } catch (Exception e) {
      return null;
    }
  }

  /**
   * Executes Script Scroll Into View
   *
   * @param webEle WebElement
   */
  public void scrollElementIntoView(WebElement webEle) {
    JavascriptExecutor jse = (JavascriptExecutor) driver;
    jse.executeScript("arguments[0].scrollIntoView();", webEle);
  }
}

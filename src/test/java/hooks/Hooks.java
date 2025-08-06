package hooks;

import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.cucumber.adapter.*;
import com.assessment.utilities.ConfigReader;

/**
 * Cucumber hooks for browser setup and teardown.
 */
public class Hooks {
  public static WebDriver driver;

  /**
   * Before each scenario, initialize the browser.
   */
  @Before
  public void beforeScenario() {
    driver = new ChromeDriver();
  }

  /**
   * Take screenshot on step failure.
   *
   * @param scenario Cucumber scenario
   */
  @AfterStep
  public void afterStep(io.cucumber.java.Scenario scenario) {
    if (scenario.isFailed()) {
      byte[] src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
      scenario.attach(src, "image/png", "failure");
    }
  }

  /**
   * After each scenario, close the browser.
   */
  @After
  public void afterScenario() {
    driver.quit();
  }
}
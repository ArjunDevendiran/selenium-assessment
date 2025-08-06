package hooks;

import com.assessment.utilities.DriverManager;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * Cucumber hooks for browser setup and tear down.
 */
public class Hooks {

  private final DriverManager driverManager;

  public Hooks(DriverManager driverManager) {
    this.driverManager = driverManager;
  }

  /**
   * Before each scenario, initialize the browser.
   */
  @Before
  public void beforeScenario() {
    driverManager.initDriver(); // initializes WebDriver
  }

  /**
   * Take screenshot on step failure.
   *
   * @param scenario Cucumber scenario
   */
  @AfterStep
  public void afterStep(io.cucumber.java.Scenario scenario) {
    if (scenario.isFailed()) {
      byte[] src = ((TakesScreenshot) driverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
      scenario.attach(src, "image/png", "failure");
    }
  }

  /**
   * After each scenario, close the browser.
   */
  @After
  public void afterScenario() {
    driverManager.quitDriver();
  }
}
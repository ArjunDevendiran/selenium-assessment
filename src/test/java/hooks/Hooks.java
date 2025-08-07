package hooks;

import com.assessment.utilities.DriverManager;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
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
  public void afterStep(Scenario scenario) {if (scenario.isFailed()) {
    String screenshotBase64 = ((TakesScreenshot)driverManager.getDriver())
            .getScreenshotAs(OutputType.BASE64);

    // 1. For ExtentReports
    ExtentCucumberAdapter.getCurrentStep().fail(
            MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotBase64).build());

    // 2. For Cucumber HTML report
    scenario.attach(screenshotBase64, "image/png", "Failure");
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
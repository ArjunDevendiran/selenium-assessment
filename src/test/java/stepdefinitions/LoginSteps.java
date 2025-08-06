package stepdefinitions;
import io.cucumber.java.en.*;
import com.assessment.pages.interactions.LoginPageInteraction;
import com.assessment.utilities.ConfigReader;
import hooks.Hooks;
import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * Step definitions for login feature using Cucumber.
 */
public class LoginSteps {
  LoginPageInteraction page = new LoginPageInteraction(Hooks.driver);

  /**
   * Open the login page based on environment config.
   */
  @Given("I open the login page")
  public void openLogin(){
    page.open(ConfigReader.getUrl());
  }

  /**
   * Login with provided username and password.
   *
   * @param u Username
   * @param p Password
   */
  @When("I login with username {string} and password {string}")
  public void login(String u, String p){
    page.login(u,p);
  }

  /**
   * Assert that expected text is visible in the page body.
   *
   * @param expected Expected result text
   */
  @Then("I should see {string}")
  public void verify(String expected){
    String body = Hooks.driver.findElement(By.tagName("body")).getText();
    Assert.assertTrue(body.contains(expected));
  }
}
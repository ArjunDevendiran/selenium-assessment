package com.assessment.pages.models;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Model class for the Login page elements.
 * Contains only locators with Lombok-generated getters and setters.
 */
@Getter
@Setter
public class LoginPageModel {

  @FindBy(id = "username")
  private WebElement usernameField;

  @FindBy(id = "password")
  private WebElement passwordField;

  @FindBy(id = "submit")
  private WebElement submitButton;

  @FindBy(tagName = "body")
  private WebElement loggedInPageElement;

  public LoginPageModel(WebDriver driver) {
    PageFactory.initElements(driver, this);
  }
}



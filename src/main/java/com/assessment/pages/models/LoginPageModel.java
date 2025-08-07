package com.assessment.pages.models;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Model class for the Login page elements.
 * Contains only locators with Lombok-generated getters
 */
@Getter
public class LoginPageModel {

  @FindBy(id = "username")
  private WebElement usernameField;

  @FindBy(id = "password")
  private WebElement passwordField;

  @FindBy(id = "kc-login")
  private WebElement loginButton;

  @FindBy(css = "div[role='alert'][class*='success']")
  private WebElement successToast;

  @FindBy(xpath = "//*[contains(@class, 'error')]")
  private WebElement emailErrorMessage;

  @FindBy(id = "kc-page-title")
  private WebElement headerText;

  public LoginPageModel(WebDriver driver) {
    PageFactory.initElements(driver, this);
  }
}



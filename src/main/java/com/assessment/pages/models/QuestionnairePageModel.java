package com.assessment.pages.models;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Model class for the Questionnaire page elements.
 * Contains only locators with Lombok-generated getters
 */
@Getter
public class QuestionnairePageModel {

  @FindBy(css = ".ui-datatable-subtable-header")
  private WebElement questionnaireSection;

  @FindBy(css = "table.selectmanycheckbox-field")
  private List<WebElement> radioButtonPairsList;

  public QuestionnairePageModel(WebDriver driver) {
    PageFactory.initElements(driver, this);
  }
}



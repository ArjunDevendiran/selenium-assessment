package com.assessment.pages.models;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Model class for the Operation Calendar page elements.
 * Contains only locators with Lombok-generated getters
 */
@Getter
public class OperationCalendarPageModel {

  @FindBy(css = "span[id*='OperationCalendarEventList']")
  private WebElement eventDropdown;

  @FindBy(css = "span[id*='OperationCalendarEventList'] > ul[class*='autocomplete-list'] > li")
  private List<WebElement> eventDropdownOptions;

  // Assuming the selected event's HTML class attribute contains 'selected'
  @FindBy(css = "span[id*='OperationCalendarEventList'] > ul[class*='autocomplete-list'] > li[class*='selected']")
  private WebElement selectedEvent;

  public OperationCalendarPageModel(WebDriver driver) {
    PageFactory.initElements(driver, this);
  }
}



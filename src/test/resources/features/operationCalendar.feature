@OperationCalendarFlow
Feature: Operation Calendar feature

  @OperationCalendarTest-1 @OperationCalendarFlow @Regression @FE
  Scenario Outline: Validate selecting 5th list item from the Event dropdown list
    Given I open the Test environment
    When I login with username "<username>" and password "<password>" from "login.properties"
    And I open the "operationCalendar" page
    And I expand the Event dropdown
    And I select the 5th item from the Event dropdown
    Then I should see the selected item matches "<expected_value_key>" from "<properties_file>"
    Examples:
      | properties_file             | expected_value_key             | username          | password       |
      | operationCalendar.properties | event.dropdown.expected.item_5 | ${login.username} | ${login.password} |

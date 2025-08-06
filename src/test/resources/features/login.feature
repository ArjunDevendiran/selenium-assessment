Feature: Login Feature

  Scenario: Validate successful login
    Given I open the Test environment
    When I enter "student" in "username" field in the login page
    And I enter "Password123" in "password" field in the login page
    And I click on Submit button in the login page
    Then I should see "Logged In Successfully"
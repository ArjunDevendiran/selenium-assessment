Feature: Login Feature

  Scenario: Validate successful login
    Given I open the login page
    When I login with username "student" and password "Password123"
    Then I should see "Logged In Successfully"
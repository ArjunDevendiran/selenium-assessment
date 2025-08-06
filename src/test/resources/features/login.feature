@LoginFlow
Feature: Login Feature

  @TICKET-1 @LoginFlow @Regression @FE
  Scenario Outline: Validate User is able to Login successfully
    Given I open the Test environment
    When I enter "<username>" in "username" field in the login page
    And I enter "<password>" in "password" field in the login page
    And I click on Submit button in the login page
    Then I should see "<result>" toast
    Examples:
      | username        | password | result  |
      | test@gmail.com  | test123  | success |

  @TICKET-2 @LoginFlow @Regression @FE
  Scenario: Validate error message when Incorrect Email Format is entered
    Given I open the Test environment
    When I enter "testgmailcom" in "username" field in the login page
    And I enter "test123" in "password" field in the login page
    And I click on Submit button in the login page
    Then I should see "enter correct email" error message

  @TICKET-3 @LoginFlow @Regression @FE
  Scenario: Validate error message when username (not registered) is entered
    Given I open the Test environment
    When I enter "123@gmail.com" in "username" field in the login page
    And I enter "test123" in "password" field in the login page
    And I click on Submit button in the login page
    Then I should see "invalid email" error message

  @TICKET-4 @LoginFlow @Regression @FE
  Scenario: Validate Login page
    Given I open the Test environment
    Then I should see page title "Log in to VMD-SERAPIS-01"
    And I should see page header "Log in"
    And I should see "Username" field
    And I should see "Password" field
    And I should see "Login" button

  @TICKET-5 @LoginFlow @Regression @FE
  Scenario: Validate Login button is disabled when username and password field are empty
    Given I open the Test environment
    Then I should see "Login" button is enabled false

  @TICKET-6 @LoginFlow @Regression @FE
  Scenario: Validate password is masked when password is entered
    Given I open the Test environment
    When I enter "test123" in "password" field in the login page
    Then I should see "Password" field is masked

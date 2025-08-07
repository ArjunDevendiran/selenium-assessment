@LoginFlow
Feature: Login Feature

  @LoginTest-1 @LoginFlow @Regression @FE
  Scenario Outline: Validate User is able to Login successfully
    Given I open the Test environment
    When I enter "<username>" in "username" field in the login page from "<properties_file>"
    And I enter "<password>" in "password" field in the login page from "<properties_file>"
    And I click on Submit button in the login page
    Then I should see "<result>" toast
    Examples:
      | properties_file             | username          | password       | result  |
      | login.properties | ${login.username} | ${login.password} | success |

  @LoginTest-2 @LoginFlow @Regression @FE
  Scenario Outline: Validate error message when Incorrect Email Format is entered
    Given I open the Test environment
    When I enter "<username>" in "username" field in the login page from "<properties_file>"
    And I enter "<password>" in "password" field in the login page from "<properties_file>"
    And I click on Submit button in the login page
    Then I should see "<result>" error message
    Examples:
      | properties_file             | username          | password       | result  |
      | login.properties | ${login.username} | ${login.password} | enter correct email |

  @LoginTest-3 @LoginFlow @Regression @FE
  Scenario Outline: Validate error message when username (not registered) is entered
    Given I open the Test environment
    When I enter "<username>" in "username" field in the login page from "<properties_file>"
    And I enter "<password>" in "password" field in the login page from "<properties_file>"
    And I click on Submit button in the login page
    Then I should see "<result>" error message
    Examples:
      | properties_file             | username          | password       | result  |
      | login.properties | ${login.username} | ${login.password} | invalid email |

  @LoginTest-4 @LoginFlow @Regression @FE
  Scenario: Validate Login page
    Given I open the Test environment
    Then I should see page title "Log in to VMD-SERAPIS-01"
    And I should see page header "Log in"
    And I should see "Username" field
    And I should see "Password" field
    And I should see "Login" button

  @LoginTest-5 @LoginFlow @Regression @FE
  Scenario: Validate Login button is disabled when username and password field are empty
    Given I open the Test environment
    Then I should see "Login" button is enabled false

  @LoginTest-6 @LoginFlow @Regression @FE
  Scenario Outline: Validate password is masked when password is entered
    Given I open the Test environment
    And I enter "<password>" in "password" field in the login page from "<properties_file>"
    Then I should see "Password" field is masked
    Examples:
      | properties_file             | password       |
      | login.properties | ${login.password} |

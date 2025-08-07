@QuestionnaireFlow
Feature: Questionnaire feature

  @QuestionnaireTest-1 @QuestionnaireFlow @Regression @FE
  Scenario Outline: Validate user is able to select Yes or No radio buttons for all questions randomly
    Given I open the Test environment
    When I login with username "<username>" and password "<password>" from "login.properties"
    And I open the "questionnaire" page
    When I randomly select radio buttons for all questions
    Then I should see all questions at least 1 radio button selected
    Examples:
      | username          | password       |
      | ${login.username} | ${login.password} |
@QuestionnaireFlow
Feature: Questionnaire feature

  @TICKET-1 @QuestionnaireFlow @Regression @FE
  Scenario: Validate user is able to select Yes or No radio buttons for all questions randomly
    Given I open the Questionnaire page
    When I randomly select radio buttons for all questions
    Then I should see all questions at least 1 radio button selected
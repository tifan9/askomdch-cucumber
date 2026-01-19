Feature: AskOmDch Login Feature
  In order to Shop online
  As a valid AskOmDch customer
  I want to login successfully
  Background:
    Given I am on the login page
  Scenario Outline: Login with valid credentials
    When I login with username "<username>" and password "<password>"
    And I click on login button
    Then I should see a welcome message for "<username>" on Dashboard

    Examples:
      | username | password |
      | tester124  | password123   |
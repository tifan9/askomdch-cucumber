Feature: AskOmDch Registration Feature
  In order to Shop online
  As a valid AskOmDch customer
  I want to register successfully
  Background:
    Given I am on the registration page
  Scenario: Customer to register with valid credential
    When I enter valid details:
      | userName   | email                  | password      |
      | tester1298  | tester1298@gmail.com    |   password123 |
    And I click on register button
    Then I should be redirected to the dashboard
    And I see welcome message contains my username
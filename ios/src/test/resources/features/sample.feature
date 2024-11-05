Feature: BrowserStack Demo

  Scenario: BStack Sample Test - Input text
    Given I am on homepage
    When I click on Text Button
    Then I enter text - Hello
    Then I should get Hello in the output

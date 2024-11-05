Feature: BrowserStack Local Testing

  Scenario: BStack Local Test - Checking active connection
    Given I am on the homepage
    When I click on test button
    Then I should get a message about active connection


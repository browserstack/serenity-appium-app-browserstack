Feature: BrowserStack Local Testing

  Scenario: BStack Local Test - Checking active connection
    Given I am on the homepage
    When I click on test action
    Then I should get list of text messages
    Then there should be a message about active connection


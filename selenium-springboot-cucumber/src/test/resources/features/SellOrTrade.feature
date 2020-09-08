@sellOrTrade
Feature: Sell or trade feature

  Scenario: Successful sell or trade
    Given a User clicks on Sell or Trade
    When I input license plate number "7PD101"
    Then I select state "Alabama"
    And the user clicks get started



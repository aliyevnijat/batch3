@sellOrTrade
Feature: Sell or trade feature

  Scenario Outline: Successful sell or trade
    Given a User clicks on Sell or Trade
    When I input license plate number "<plate>"
    Then I select state "<state>"
#    And the user clicks get started

    Examples:
      | plate  | state    |
      | 6YR453 | Colorado |
      | Azeri  | Alaska   |



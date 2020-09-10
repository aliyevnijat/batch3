@smoke_test
Feature: This feature is to validate body types

@bodyTypes
  Scenario Outline: Verify body types and number of cars for each body type
    Given I shop for a new car
    Then I click on Body Type
    And I choose body type "<bodyTypes>"
    Then I should see <numberOfCars> cars


    Examples:
      | bodyTypes | numberOfCars |
      | Sedans    | 27           |

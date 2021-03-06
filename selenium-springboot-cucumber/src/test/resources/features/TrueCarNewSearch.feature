@smoke_test
Feature: Shop New Page Search Tests

  @models
  Scenario Outline: Verify car models
    Given I shop for new car
    Then I verify there are 35 car makes
    And I select make "<make>"
    And I verify car models are "<models>"

    Examples:
      | make  | models                   |
      | Audi  | A3,A4,A5,A6,A7,A8,e-tron |
      | Honda | Accord,Civic             |
      | Kia   | Forte,K5                 |





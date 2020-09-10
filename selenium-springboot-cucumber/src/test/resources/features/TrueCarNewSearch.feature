@shopNew
Feature: Shop New Page Search Tests


  @models
  Scenario Outline: Verify car models
    Given I shop for a new car
    Then I should see 35 car makes
    When I click on make "<make>"
    Then I should see car models "<models>"

    Examples:
      | make     | models                                 |
      | MINI     | Clubman,Convertible,Countryman,Hardtop |
      | Acura    | ILX,MDX,NSX,RDX,RLX,TLX                |
      | Chrysler | 300,Pacifica,Voyager                   |




Feature: Research model of chosen make


  @researchModel
  Scenario Outline: User is able to check model
    Given click on Research
    When  select make "<make>" and  model "<model>"
    And verify header "<header>"on new page

    Examples:
      | make  | model  | header            |
      | BMW   | M4     | 2020 BMW M4       |
      | Honda | Accord | 2020 Honda Accord |
      | Audi  | A4     | 2020 Audi A4      |

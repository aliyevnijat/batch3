@Bodytype
  Feature: Exploring new cars section
    Scenario: to see how many body typed cars we have
      Given i am on the home page and clicking for shop new
      When i am choosing body type in new page
      Then i have to verify 9 body types there

@EstimateYourVehicle
  Feature: Getting value on my vehicle
    Scenario Outline:
      Given iam on home page and clicking on get value on your current vehicle
      When i am clicking on make and model section
      And i am choosing "<year>" , "<Make>","<Model>","<Style>"
      Then i am clicking on Get Started


      Examples:
      |year|Make|Model|Style|
      |2018|Honda|Accord|Hybrid |
      |2015|Toyota|Camry|Hybrid SE|
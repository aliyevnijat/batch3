@Makecompare
  Feature: comparing makes and models
    Scenario Outline:comparing given makes and models
      When i am on the home page and clicking on MAkecomaprision
      And i am selecting "<make>" and "<model>"
      And i am clicking on compare
      Then i have to verify shown text on top
      Examples:
      |make|model|
      |Audi,BMW|A4,3 Series|
      |Acura,Alfa Romeo| ILX,4C    |


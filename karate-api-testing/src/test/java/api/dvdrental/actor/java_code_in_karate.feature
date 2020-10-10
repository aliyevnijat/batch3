Feature: How to use java code?

  Background:
    * call read('classpath:api/dvdrental/utils.feature')

  Scenario: How to use java code?
    # How to use java code in karate feature file
    # How to call different feature file
    # Authentication in karate
#    * print currDate()
#    * print pastDate(10)
#    * print randomNumber(100)
  * def minusDate =
    """
    function(month,day){
      var LocalDate = Java.type('java.time.LocalDate')
      var today = LocalDate.now()
      var pastDate = today.minusMonths(month).minusDays(day)
      var DateTimeFormatter = Java.type('java.time.format.DateTimeFormatter')
      var formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
      return pastDate.format(formatter);
    }
    """

    * print minusDate(2,2)

    #BREAK UNTIL 8:30 PM EST


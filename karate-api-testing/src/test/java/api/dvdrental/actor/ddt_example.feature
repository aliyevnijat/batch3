Feature: Actors Data Driven
  This feature is for DDT

  Background:
    * configure report = { showLog: true, showAllSteps: false }
    * def jsonRequest = read('classpath:api/dvdrental/jsonFiles/actor.json')
  @ddt
  Scenario Outline: Search for the actors
    Then url baseUrl + '/actor?first_name=eq.' + '<firstName>'
    And method get
    * def arr =  get response
    * print arr.length
    And status 200
    And match response[*].first_name == <firtsNames>
    And assert arr.length == <numberOfrecords>

    Examples:
      | firstName | numberOfrecords | firtsNames                           |
      | Nick      | 5               | ["Nick","Nick","Nick","Nick","Nick"] |
      | Ed        | 3               | ["Ed","Ed","Ed"]                     |


  Scenario Outline: Field Level validation -> <description>
    Then url baseUrl + '/actor'
    * set jsonRequest[0].first_name = '<firstName>'
    * set jsonRequest[0].last_name = '<lastName>'
    * remove jsonRequest[0].actor_id
    * remove jsonRequest[0].last_update
    Then request jsonRequest
    And method post
    And status 400
    And match response.message == '<errorMessage>'

    Examples:
      | description                  | firstName                                        | lastName                                         | errorMessage                                  |
      | Firstname more than 45 chars | ThomasThomasThomasThomasThomasThomasThomasThomas | Smith                                            | value too long for type character varying(45) |
      | Lastname more than 45 chars  | Ed                                               | ThomasThomasThomasThomasThomasThomasThomasThomas | value too long for type character varying(45) |


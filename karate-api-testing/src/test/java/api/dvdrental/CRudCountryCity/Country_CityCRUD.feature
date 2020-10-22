Feature: Doing CRUD operations using Country and City tables

  Background:
    * configure report = { showLog: true, showAllSteps: false }
    * def jsonCountry = read('classpath:api/dvdrental/jsonFiles/Country.json')
    * def jsonCity = read('classpath:api/dvdrental/jsonFiles/City.json')

    # Creating multiply countries at the same time
  Scenario Outline:Creating countries and corrosponding cities at the same time
    Given url baseUrl + '/country'
    * set jsonCountry[0].country = '<country>'
    * set jsonCountry[1].country = '<country1>'
    * set jsonCountry[2].country = '<country2>'
    Then request jsonCountry
    Then method post
    And status 201
    Examples:
    |country|country1|country2|
    | FakeCountry      | FakeCountry1       | FakeCountry2        |
#    This step should be capturing country id's of newly created countries
  Scenario: Capturing country id
   Given url baseUrl + '/country?country=eq.FakeCountry'
    Then method get
    * def count_id = response[0].country_id
    * print count_id
    And status 200

    Given url baseUrl + '/country?country=eq.FakeCountry1'
    Then method get
    * def count_id1 = response[0].country_id
    * print count_id1
    And status 200

    Given url baseUrl + '/country?country=eq.FakeCountry2'
    Then method get
    * def count_id2 = response[0].country_id
    * print count_id2
    And status 200

    Given url baseUrl +'/city'
    * set jsonCity[0].city = 'FakeCity'
    * set jsonCity[0].country_id = count_id
    * set jsonCity[1].city = 'FakeCity1'
    * set jsonCity[1].country_id = count_id1
    * set jsonCity[2].city = 'FakeCity2'
    * set jsonCity[2].country_id = count_id2
    Then request jsonCity
    Then method post
    And status 201

    Given url baseUrl + '/city?city=eq.FakeCity'
    Then method get
    * def ct_id = response[0].city_id
    * print ct_id
    And status 200

    Given url baseUrl + '/city?city=eq.FakeCity1'
    Then method get
    * def ct_id1 = response[0].city_id
    * print ct_id1
    And status 200

    Given url baseUrl + '/city?city=eq.FakeCity2'
    Then method get
    * def ct_id2 = response[0].city_id
    * print ct_id2
    And status 200
    # Deleting all cities we have created so far
    Given url baseUrl + '/city?city_id=eq.' + ct_id
    Then method delete
    And status 204

    Given url baseUrl + '/city?city_id=eq.' + ct_id1
    Then method delete
    And status 204

    Given url baseUrl + '/city?city_id=eq.' + ct_id2
    Then method delete
    And status 204
    #Then we are deleting the countries we have created at the first steps

    Given url baseUrl + '/country?country_id=eq.' + count_id
    Then method delete
    And status 204

    Given url baseUrl + '/country?country_id=eq.' + count_id1
    Then method delete
    And status 204

    Given url baseUrl + '/country?country_id=eq.' + count_id2
    Then method delete
    And status 204
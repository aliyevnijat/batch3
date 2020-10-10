Feature: Create country and city
  This feature to create country and city

  Background:
    * configure report = { showLog: true, showAllSteps: false }
    * def jsonCountry = read('classpath:api/dvdrental/jsonFiles/country.json')
    * def jsonCity = read('classpath:api/dvdrental/jsonFiles/city.json')
  @country_city
  Scenario Outline: Create country and city
    #Create country
    Given url baseUrl + '/country'
    * set jsonCountry[0].country = '<country>'
    * print jsonCountry
    Then request jsonCountry
    Then method post
    And status 201
    # Get Country
    Given url baseUrl + '/country?country=eq.' + '<country>'
    Then method get
    * def cntry_id = get response[0].country_id
    And status 200
    And match response[0].country ==  '<country>'
    #Create city
    Given url baseUrl + '/city'
    * set jsonCity[0].city = '<city>'
    * set jsonCity[0].country_id = cntry_id
    Then request jsonCity
    Then method post
    And status 201
    #Get City
    Given url baseUrl + '/city?city=eq.' + '<city>'
    Then method get
    * def ct_id = get response[0].city_id
    And status 200
    And match response[0].city == '<city>'
    And match response[0].country_id == cntry_id
    # Delete both
    Given url baseUrl + '/city?city_id=eq.' + ct_id
    Then method delete
    And status 204
    Given url baseUrl + '/country?country_id=eq.' + cntry_id
    Then method delete
    And status 204

    Examples:
      | country | city     |
      | BIT     | Stoneham |
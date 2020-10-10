Feature: Customer
  This feature is create customer

  Background:
    * configure report = { showLog: true, showAllSteps: false }
    * def addressJson = read('classpath:api/dvdrental/jsonFiles/address.json')

  @actore2e
  Scenario: Create customer
#    Given url baseUrl + '/address'
#    * set addressJson[0].address = '53 Salem Street'
#    * set addressJson[0].district = 'Massachusetts'
#    * set addressJson[0].city_id = 94
#    * set addressJson[0].postal_code = '02342'
#    Then request addressJson
#    Then method post
#    And status 201
    # Retrieve the address (in this case where address =
    # 53 Salem Street)
    # capture address_id assign
    # to a variable and print it...

    # And Create customer whose address is address you just
    # created

    Given url baseUrl + "/address"
    And param address = 'eq.53 Salem Street'
    Then method get

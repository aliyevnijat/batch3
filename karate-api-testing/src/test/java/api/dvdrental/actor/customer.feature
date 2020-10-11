Feature: CRUD
  This feature creates, gets and deletes  address and customer

  Background:
    * configure report = { showLog: true, showAllSteps: false }
    * def addressJson = read('classpath:api/dvdrental/jsonFiles/address.json')
    * def customerJson = read('classpath:api/dvdrental/jsonFiles/customer.json')


  Scenario Outline: CRUD customer
#  create address
    Given url baseUrl + '/address'
    * set addressJson[0].address = '<address>'
    * set addressJson[0].district = '<district>'
    * set addressJson[0].city_id = <city_id>
    * set addressJson[0].postal_code = <postal_code>
    Then request addressJson
    Then method post
    And status 201

#  get address
    Given url baseUrl + '/address?district=eq.' + '<district>'
    Then method get
    And status 200
    * def adrs_id = get response[0].address_id
    * print address_id

# create customer
    Given url baseUrl + '/customer'
    * set customerJson[0].first_name = '<first_name>'
    * set customerJson[0].last_name = '<last_name>'
    * set customerJson[0].address_id = adrs_id
    * set customerJson[0].store_id = <store_id>
    Then request customerJson
    Then method post
    And status 201

# get customer
    Given url baseUrl + '/customer?first_name=eq.' + '<first_name>'
    Then method get
    And  status 200
    And match response[0].last_name == '<last_name>'
    And match response[0].address_id == adrs_id
    * def custom_id = get response[0].customer_id
    * print custom_id

#   delete customer and address
    Given url baseUrl + '/customer?customer_id=eq.' + custom_id
    Then method delete
    And status 204
    Given url baseUrl + '/address?address_id=eq.' + adrs_id
    Then method delete
    And status 204
    Examples:
      | address          | district    | city_id | postal_code | first_name | last_name | store_id |
      | 38 London Street | LondonDerry | 361     | 08152       | Aydan      | Memmedli  | 13       |
      | 36 Nasimi Ave    | Qabala      | 322     | 70673       | Meleyke    | Haciyeva  | 2        |
      | 52 Nizami Street | Qusar       | 576     | 63152       | Gulzar     | Huseynli  | 1        |
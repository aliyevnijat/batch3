
Feature: Crud operations

Background:
  * configure report = { showLog: true, showAllSteps: false }
  * def addressJson = read('classpath:api/dvdrental/jsonFiles/adress.json')
  * def customerJson = read('classpath:api/dvdrental/jsonFiles/customer.json')


Scenario: Create customer
Given url baseUrl + '/address'
* set addressJson[0].address = '40 Nerimanov Street'
* set addressJson[0].district = 'California'
* set addressJson[0].city_id = 100
* set addressJson[0].postal_code = '01906'
Then request addressJson
Then method post
And status 201
  
   # Getting that adrress
  Given url baseUrl + '/address?address=eq.40+Nerimanov+Street'
  Then method get
  * def add_id = response[0].address_id
  * print add_id
  # Creating a customer related to this address
  Given url baseUrl + '/customer'
  * set customerJson[0].first_name = 'Abraham'
  * set customerJson[0].last_name = 'Lincoln'
  * set customerJson[0].address_id = add_id
  Then request customerJson
  Then method post
  And status 201
  #Getting that customer
  Given url baseUrl + '/customer?first_name=eq.Abraham&last_name=eq.Lincoln'
    Then method get
  * def cust_id = response[0].customer_id
  And status 200
  # Then deleting that customer from database
  Given url baseUrl + '/customer?customer_id=eq.' + cust_id
  Then method delete
  And status 204
  # Deleting that address belongs that customer
  Given url baseUrl + '/address?address_id=eq.' + add_id
  Then method delete
  And status 204


  
  
Feature: Create -> Retrieve -> Modify -> Delete
  I want to use this feature to do CRUD in actors table

  Background: 
    * configure report = { showLog: true, showAllSteps: false }
    * def jsonRequest = read('classpath:api/dvdrental/jsonFiles/actor.json')

  @actor
  Scenario: CRUD
   # Creating new actor   
  Given url baseUrl + '/actor'
  * set jsonRequest[0].first_name = 'Cahangir'
  * set jsonRequest[0].last_name = 'Memmedov'
  * remove jsonRequest[0].actor_id
  * remove jsonRequest[0].last_update
  Then request jsonRequest
  Then method post
  And status 201
  # Getting newly created actor
  Given url baseUrl + '/actor?first_name=eq.Cahangir&last_name=eq.Memmedov'
    Then method get
    And status 200
    And match response[0].first_name == 'Cahangir'
    And match response[0].last_name == 'Memmedov'
    * def act_id = response[0].actor_id
   # Modifying newly created actor's name
    Given url baseUrl + '/actor?actor_id=eq.' + act_id
   * set jsonRequest[0].actor_id = act_id
   * set jsonRequest[0].first_name = 'Nesimi'
   * set jsonRequest[0].last_name = 'Huseynov'
   Then request jsonRequest
   Then method put
   And status 204
   # Getting modified actor
   Given url baseUrl +'/actor?actor_id=eq.' + act_id
   Then method get
   And status 200
   And match response[0].first_name == 'Nesimi'
   And match response[0].last_name == 'Huseynov'
   # Deleting actor
   Given url baseUrl + '/actor?actor_id=eq.' + act_id
   Then method delete
   And status 204
   # Verifying that actor has been deleted
   Given url  baseUrl + 'actor?actor_id=eq.' + act_id
   Then method get
   And status 200
    And assert response.arr == null



  



    
    
    
    
    

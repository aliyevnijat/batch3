

    Feature: DDT on actors table

       Background:
         * configure report = { showLog: true, showAllSteps: false }
         * def jsonRequest = read('classpath:api/dvdrental/jsonFiles/actor.json')

         Scenario Outline: Searching for actors
           Then url  baseUrl + '/actor?first_name=eq.' + '<firstname>'
           And method get
           And status 200
           * def arr = get response
           And assert arr.length == '<numberofrecords>'
           And match response[*].first_name == <expectedfirstnames>

           Examples:
           |firstname|numberofrecords|       expectedfirstnames  |
           | Nick |    5     |   ["Nick","Nick","Nick","Nick","Nick"]            |
           |  Ed  |   5     |    ["Ed","Ed","Ed","Ed","Ed"]                               |


            Scenario Outline: Field level validation -> <description>
              Then url baseUrl + '/actor'
              * set jsonRequest[0].first_name = '<firstname>'
              * set jsonRequest[0].last_name = '<lastname>'
              Then request jsonRequest
              Then method post
              And status 400
              And match response.message == '<errormessage>'
              

              Examples:
              |description|firstname|lastname|errormessage|
              |Firstname more than 45      | AdigozelAdigozelAdigozelAdigozelAdigozelAdigozel         |  Qodjayev      |    value too long for type character varying(45)        |
              |   Lastname more than 45    |  Xaneli    | GulmmemmedovGulmmemmedovGulmmemmedovGulmmemmedovGulmmemmedov  | value too long for type character varying(45)           |
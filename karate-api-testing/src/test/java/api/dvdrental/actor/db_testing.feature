Feature: DB testing

  Background:
    * def config =
    """
    {
      username: 'postgres',
      password: '12345678',
      url: 'jdbc:postgresql://bit-postgres-db.cqmfjvjmeenj.us-east-2.rds.amazonaws.com:5432/dvdrental',
      driverClassName: 'org.postgresql.Driver'
    }
    """
    * def DbUtils = Java.type('api.dbc.DbUtils')
    * def db = new DbUtils(config)

  Scenario: DB Testing
    * def d = db.readRows("select * from customer")
    * def foo = []
    * def fun = function(i){ karate.appendTo(foo, d[i].email) }
    * karate.repeat(d.size(), fun)
    * def someFunction =
  """
    function (arr){
      var str = ''
      for(i = 0; i < arr.length; i++){
        str += arr[i] + '\n'
      }
      return str
    }
  """
  * karate.write(someFunction(foo), 'email.csv')




  Feature: DB testing
    Background:
  * def config = { username: 'postgres', password: '12345678', url: 'jdbc:postgresql://bit-postgres-db.cqmfjvjmeenj.us-east-2.rds.amazonaws.com:5432/dvdrental', driverClassName: 'org.postgresql.Driver' }
  * def DbUtils = Java.type('api.dbc.DbUtils')
  * def db = new DbUtils(config)

      Scenario: DB
        * def dbc = db.readRows("select email from customer")
        * def foo = []
        * def fun = function(i){ karate.appendTo(foo,dbc[i].email)}
        * karate.repeat(dbc.size(),fun)
        * def Some_function =
        """
        function(arr){
        var str = ''
        for(i = 0; i <arr.length;i++){
        str+=arr[i]+'\n'
        } return str
        }
        """
        * karate.write(Some_function(foo),'email.csv')


Voting system for deciding where to have lunch (REST only).

Тестовое задание

Implementation Stack:

For admin CRUD:

Spring Boot
Spring HATEOAS
Spring Data REST
For Voting:

Spring Data JPA
Install:

git clone https://github.com/gkislin/lunch-voting
Run (from project directory)

Dev environment

$ mvn spring-boot:run
or

$ mvn clean package
$ java -Dfile.encoding=UTF8 -Dspring.profiles.active="dev" -jar target/lunch-voting.jar
H2 console
User: sa, no password
JDBC URL: jdbc:h2:mem:voting
Remote connection URL: jdbc:h2:tcp://localhost:9092/mem:voting
Prod environment

$ mvn -P prod spring-boot:run`
or

$ mvn clean package`
$ java -Dfile.encoding=UTF8 -jar target/lunch-voting.jar
User: sa, password: zD5z6Wx
JDBC URL: jdbc:h2:file:~/voting
Remote connection URL: jdbc:h2:tcp://localhost:9092/~/voting
The HAL Browser

    User login: user@yandex.ru
      password: password
"Authorization: Basic dXNlckB5YW5kZXgucnU6cGFzc3dvcmQ="


   Admin login: admin@gmail.com
      password: admin
"Authorization:Basic YWRtaW5AZ21haWwuY29tOmFkbWlu"
User handling

403:Forbidden
curl 'http://localhost:8080/api/users' -i -H'Authorization: Basic dXNlckB5YW5kZXgucnU6cGFzc3dvcmQ='
Users list
Users 0
Users by email: admin@gmail.com
CURL:

 curl 'http://localhost:8080/api/users' -i -H'Authorization:Basic YWRtaW5AZ21haWwuY29tOmFkbWlu'
 curl 'http://localhost:8080/api/users/0' -i -H'Authorization:Basic YWRtaW5AZ21haWwuY29tOmFkbWlu'
 curl 'http://localhost:8080/api/users/search/by-email?email=admin@gmail.com' -i -H'Authorization:Basic YWRtaW5AZ21haWwuY29tOmFkbWlu'
 curl 'http://localhost:8080/api/users' -i -d'{"name" : "NewUser", "email" : "new@mail.ru","password" : "123456","roles" : ["ROLE_USER"]}' -H'Authorization:Basic YWRtaW5AZ21haWwuY29tOmFkbWlu' -H'Content-Type: application/json'
Restorant handling

Restaurant list
Restaurant 0
Restaurant by name: name=Don
CURL:

 curl 'http://localhost:8080/api/restaurants' -i -H'Authorization: Basic dXNlckB5YW5kZXgucnU6cGFzc3dvcmQ='
 curl 'http://localhost:8080/api/restaurants/0' -i -H'Authorization: Basic dXNlckB5YW5kZXgucnU6cGFzc3dvcmQ='
 curl 'http://localhost:8080/api/restaurants/search/by-name?name=Don' -i -H'Authorization: Basic dXNlckB5YW5kZXgucnU6cGFzc3dvcmQ='
Modification (Access denied for User):

 curl 'http://localhost:8080/api/restaurants' -i -d'{"name" : "Subway"}' -H'Authorization: Basic dXNlckB5YW5kZXgucnU6cGFzc3dvcmQ=' -H'Content-Type: application/json'
Modification (Access allowed for Admin):

 curl 'http://localhost:8080/api/restaurants' -i -d'{"name" : "Subway"}' -H'Authorization: Basic YWRtaW5AZ21haWwuY29tOmFkbWlu' -H'Content-Type: application/json'
 curl 'http://localhost:8080/api/restaurants/3' -i -X DELETE -H'Authorization: Basic YWRtaW5AZ21haWwuY29tOmFkbWlu' -H'Content-Type: application/json'
Menu handling

Menu list
Menu 0
Menu for date 2015-11-19
Menu for restaurant 0
CURL:

 curl 'http://localhost:8080/api/menus' -i -H'Authorization: Basic YWRtaW5AZ21haWwuY29tOmFkbWlu'
 curl 'http://localhost:8080/api/menus/0' -i -H'Authorization: Basic YWRtaW5AZ21haWwuY29tOmFkbWlu'
 curl 'http://localhost:8080/api/menus' -i -d'{"date" : "2015-11-17", "restaurant":"http://localhost:8080/api/restaurants/0"}' -H'Authorization: Basic YWRtaW5AZ21haWwuY29tOmFkbWlu' -H'Content-Type: application/json'
 curl 'http://localhost:8080/api/menus/1' -i -X PUT -d'{"date" : "2015-11-16"}' -H'Authorization: Basic YWRtaW5AZ21haWwuY29tOmFkbWlu' -H'Content-Type: application/json'
 curl 'http://localhost:8080/api/menus/search/by-date?date=2015-11-19' -i -H'Authorization:Basic YWRtaW5AZ21haWwuY29tOmFkbWlu'
 curl 'http://localhost:8080/api/menus/search/by-restaurant?restaurant=http://localhost:8080/api/restaurants/0' -i -H'Authorization:Basic YWRtaW5AZ21haWwuY29tOmFkbWlu'
Lunch handling

Lunch list
Lunch 1
Lunch for date 2015-11-19
Lunch for menu 1
CURL:

 curl 'http://localhost:8080/api/lunches' -i -H'Authorization: Basic YWRtaW5AZ21haWwuY29tOmFkbWlu'
 curl 'http://localhost:8080/api/lunches/11' -i -H'Authorization: Basic YWRtaW5AZ21haWwuY29tOmFkbWlu'
 curl 'http://localhost:8080/api/lunches' -i -d'{"name" : "Desert", "price": 85, "menu":"http://localhost:8080/api/menus/0"}' -H'Authorization: Basic YWRtaW5AZ21haWwuY29tOmFkbWlu' -H'Content-Type: application/json'
 curl 'http://localhost:8080/api/lunches' -i -d'{"name" : "Desert", "menu":"http://localhost:8080/api/menus/5"}' -H'Authorization: Basic YWRtaW5AZ21haWwuY29tOmFkbWlu' -H'Content-Type: application/json'
 curl 'http://localhost:8080/api/lunches/search/by-date?date=2015-11-19' -i -H'Authorization:Basic YWRtaW5AZ21haWwuY29tOmFkbWlu'
 curl 'http://localhost:8080/api/lunches/search/by-menu?menu=http://localhost:8080/api/menus/1' -i -H'Authorization:Basic YWRtaW5AZ21haWwuY29tOmFkbWlu'
Voting

Current Vote
Vote for menu 0:

 curl 'http://localhost:8080/api/vote/0' -i -X POST -H'Authorization: Basic dXNlckB5YW5kZXgucnU6cGFzc3dvcmQ=' -H'Content-Type: application/json'
Vote for menu 2:

 curl 'http://localhost:8080/api/vote/2' -i -X POST -H'Authorization: Basic dXNlckB5YW5kZXgucnU6cGFzc3dvcmQ=' -H'Content-Type: application/json'
Check current vote:

 curl 'http://localhost:8080/api/vote' -i -H'Authorization: Basic dXNlckB5YW5kZXgucnU6cGFzc3dvcmQ='

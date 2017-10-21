Voting system for deciding where to have lunch (REST only).
==================

## Тестовое задание
**Design and implement a REST API using Hibernate/Spring/SpringMVC without frontend.**

###The task is:


    Build a voting system for deciding where to have lunch.
    2 types of users: admin and regular users
    Admin can input a restaurant and it's lunch menu of the day (2-5 items usually, just a dish name and price)
    Menu changes each day (admins do the updates)
    Users can vote on which restaurant they want to have lunch at
    Only one vote counted per user
    If user votes again the same day:
        If it is before 11:00 we asume that he changed his mind.
        If it is after 11:00 then it is too late, vote can't be changed
        
        Each restaurant provides new menu each day.



Implementation Stack:

For admin CRUD:
- <a href="https://projects.spring.io/spring-framework/">Spring Framework</a>
- <a href="https://projects.spring.io/spring-security/">Spring Security</a>
- <a href="https://projects.spring.io/spring-data-jpa/">Spring Data JPA</a>


## Install:

    git clone https://github.com/AndrewChertok/VoteRestaurant


## <a href="http://localhost:8080/">To login page</a>

        User login: user@gmail.com
          password: user
    "Authorization: Basic dXNlckBnbWFpbC5jb206dXNlcg=="


       Admin login: admin@gmail.com
          password: admin
    "Authorization:Basic YWRtaW5AZ21haWwuY29tOmFkbWlu"

### Dishes handling

    403:Forbidden
    curl 'http://localhost:8080/dish/admin' -i -H'Authorization: Basic YWRtaW5AZ21haWwuY29tOmFkbWlu'

- <a href="http://localhost:8080/dish/admin">Dishes list</a>
- <a href="http://localhost:8080/dish/admin/10">Dish 10</a>
- <a href="http://localhost:8080/dish/admin?from=2017-10-17&to=">Dishes by dates</a>

CURL:

    
    # get All Dishes
    curl --user admin@gmail.com:admin http://localhost:8080/dish/admin
    
    # get Dish by Id 
    curl --user admin@gmail.com:admin http://localhost:8080/dish/admin/10
    
    # delete Dish by id
    curl --user admin@gmail.com:admin –X DELETE http://localhost:8080/dish/admin/10
    
    # create Dish and bind with restaurant id
    curl --user admin@gmail.com:admin –X POST -d '{"name":"Coca-Cola","price":5}' -H 'Content-Type:application/json' http://localhost:8080/dish/admin/5
    
    # update Dish by id
    curl --user admin@gmail.com:admin –X PUT -d '{"name":"NEW","price":100}' -H 'Content-Type:application/json' http://localhost:8080/dish/admin/update/11
    
    # get Dishes by date
    curl --user admin@gmail.com:admin http://localhost:8080/dish/admin?from=2017-10-17&to=


### Restaurant handling

- <a href="http://localhost:8080/restaurant/admin">Restaurant list</a>
- <a href="http://localhost:8080/restaurant/admin/5">Restaurant 5</a>
- <a href="http://localhost:8080/restaurant/admin?name=Belaggio">Restaurant by name: name=Belaggio</a>

CURL:

     # get All Restaurants
     curl --user admin@gmail.com:admin http://localhost:8080/restaurant/admin
     
     # get Restaurant Id 
     curl --user admin@gmail.com:admin http://localhost:8080/restaurant/admin/5 
     
     # delete Restaurant by id
     curl --user admin@gmail.com:admin –X DELETE http://localhost:8080/restaurant/admin/4
     
     # create Restaurant 
     curl --user admin@gmail.com:admin –X POST -d '{"name":"New Restauran"}' -H 'Content-Type:application/json' http://localhost:8080/restaurant/admin
     
     # update Restaurant by id
     curl --user admin@gmail.com:admin –X PUT -d '{"name":"New Veronica"}' -H 'Content-Type:application/json' http://localhost:8080/restaurant/admin/5
     
     # update Restaurant by name
     curl --user admin@gmail.com:admin http://localhost:8080/restaurant/admin?name=Belaggio
     
     # get Restaurants by date
     curl --user admin@gmail.com:admin http://localhost:8080/restaurant/admin?from=2017-10-17&to=


### Users handling

   
- <a href="http://localhost:8080/user/admin">Users list</a>
- <a href="http://localhost:8080/user/admin/1">User 1</a>
- <a href="http://localhost:8080/user/admin?email=admin@gmail.com">User by email: email=admin@gmail.com</a>

CURL:

    
    # get All Users
    curl --user admin@gmail.com:admin http://localhost:8080/user/admin
    
    # get User by Id 
    curl --user admin@gmail.com:admin http://localhost:8080/user/admin/1 
    
    # create User
    curl --user admin@gmail.com:admin –X POST -d '{"name":"New User","email":"usernew@gmail.ru","password":"usernew","roles":["ROLE_USER"]}' -H 'Content-Type:application/json' http://localhost:8080/user/admin
    
    # update User by id
    curl --user admin@gmail.com:admin –X PUT -d '{"name":"User2","email":"user2@gmail.ru","password":"user2","roles":["ROLE_USER"]}' -H 'Content-Type:application/json' http://localhost:8080/user/admin/1
    
    # delete User by id
    curl --user admin@gmail.com:admin –X DELETE http://localhost:8080/user/admin/1
    
    # update User by email
    curl --user admin@gmail.com:admin http://localhost:8080/user/admin?email=admin@gmail.com


Modification (Access denied for User):

     
     curl --user user@gmail.com:user –X PUT -d '{"name":"New Veronica"}' -H 'Content-Type:application/json' http://localhost:8080/restaurant/admin/5


Modification (Access allowed for Admin):

     
      curl --user admin@gmail.com:admin –X DELETE http://localhost:8080/restaurant/admin/4
      curl --user admin@gmail.com:admin –X POST -d '{"name":"New User","email":"usernew@gmail.ru","password":"usernew","roles":["ROLE_USER"]}' -H 'Content-Type:application/json' http://localhost:8080/user/admin

### Vote handling

- <a href="http://localhost:8080/vote/5">Vote for Restaurant id 5</a>
- <a href="http://localhost:8080/vote/">Results of Poll</a>

CURL:

     
     curl --user admin@gmail.com:admin http://localhost:8080/vote/5
     curl --user admin@gmail.com:admin http://localhost:8080/vote/


### Project Description


**Project "Vote for the restaurant":
In the project there are Restaurants with a list of dishes, dishes are stored separately from restaurants and are associated with the restaurant by id and administrators and users. The user can edit his profile and vote for the restaurant choosing a more pleasant list of dishes for dinner. The user can give only one vote per day to one restaurant and only to 11:00 AM. Until 11:00 AM he can change his mind by giving his vote to another restaurant, after 11:00 AM the user can not vote any more until the next day.
Every day the administrator adds new dishes to restaurants and, if necessary, edits old restaurants: removes, changes or creates new ones and dishes: removes, changes or creates new ones**

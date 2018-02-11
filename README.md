# REST API using Hibernate/Spring/SpringMVC (without frontend)
The project is implemented using the following technologies: Maven, Spring MVC, Security, JPA(Hibernate), REST. Data storage is implemented using HSQLDB.

## Short description.
This project is a voting system for deciding where to have lunch.

- 2 types of users: admin and regular users
- Admin can input a restaurant and it's lunch menu of the day (2-5 items usually, just a dish name and price)
- Menu changes each day (admins do the updates)
- Users can vote on which restaurant they want to have lunch at
- Only one vote counted per user
- If user votes again the same day:
  - If it is before 11:00 we asume that he changed his mind.
  - If it is after 11:00 then it is too late, vote can't be changed

## CURL examples (Application context: /restaurant-vote-sys)

### ADMIN

#### Get all restaurants 
curl -s http://localhost:8080/restaurant-vote-sys/rest/admin/restaurant --user user1@gmail.com:password1

#### Get restaurant with id 2
curl -s http://localhost:8080/restaurant-vote-sys/rest/admin/restaurant/2 --user user1@gmail.com:password1

#### Create restaurant 
curl -s -X POST -d '{"name":"new restaurant","lunchMenuId":"1"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/restaurant-vote-sys/rest/admin/restaurant/ --user user1@gmail.com:password1

#### Update restaurant with id 1
curl -s -X PUT -d '{"id":"1","name":"updated restaurant","lunchMenuId":"1"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/restaurant-vote-sys/rest/admin/restaurant/ --user user1@gmail.com:password1

#### Delete restaurant with id 1 
curl -s -X DELETE http://localhost:8080/restaurant-vote-sys/rest/admin/restaurant/1 --user user1@gmail.com:password1

### REGULAR

#### Get all restaurants 
curl -s http://localhost:8080/restaurant-vote-sys/rest/regular/restaurant_info --user user2@gmail.com:password2

#### Vote
curl -s -X PUT http://localhost:8080/restaurant-vote-sys/rest/regular/restaurant_info/vote/1 --user user2@gmail.com:password2

#### Menu details 
curl -s http://localhost:8080/restaurant-vote-sys/rest/regular/restaurant_info/menu_details/1 --user user2@gmail.com:password2

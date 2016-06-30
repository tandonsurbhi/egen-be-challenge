# egen-be-challenge
To develop the below REST service API using Spark Java and mongoDB 

###createUser : Takes input as JSON. Creates the user if he is not already available in the data store.


Request URL: http://localhost:4567/egenChallange/api/v1/users/create


Request Type : POST


Header : Content-Type= application/json


Request Body :: 
{  
   "id":"1630215c-2608-44b9-aad4-9d56d8aafd4c",
   "firstName":"Dorris",
   "lastName":"Keeling",
   "email":"Darby_Leffler68@gmail.com",
   "address":{  
      "street":"193 Talon Valley",
      "city":"South Tate furt",
      "zip":"47069",
      "state":"IA",
      "country":"US"
   },
   "dateCreated":"2016-03-15T07:02:40.896Z",
   "company":{  
      "name":"Denesik Group",
      "website":"http://jodie.org"
   },
   "profilePic":"http://lorempixel.com/640/480/people"
}

###getAllUsers : Gives the list of all users that are in the data store


Request URL: http://localhost:4567/egenChallange/api/v1/users/view


Header : Content-Type= application/json


Request Type : GET



###updateUser : Takes input as JSON, finds the user from the data store. If found, updates the required fields, if not found, sends back a 404 saying user not found
Request URL: http://localhost:4567/egenChallange/api/v1/users/update/1630215c-2608-44b9-aad4-9d56d8aafd4c


Header : Content-Type= application/json


Request Type : PUT


Request Body :: 
{  
   "id":"1630215c-2608-44b9-aad4-9d56d8aafd4c",
   "firstName":"Surbhi",
   "lastName":"Tandon",
   "email":"surbhitandon57@gmail.com",
   "address":{  
      "street":"401 E 32nd St",
      "city":"Chicago",
      "zip":"60616",
      "state":"IL",
      "country":"US"
   },
   "dateCreated":"2016-03-15T07:02:40.896Z",
   "company":{  
      "name":"Egen",
      "website":"http://www.egen.com"
   },
   "profilePic":"http://lorempixel.com/640/480/people"
}

###findUser : Takes input as userId, finds the user from the data store. If found, updates the required fields, if not found, sends back a 404 saying user not found

Request URL: http://localhost:4567/egenChallange/api/v1/users/find/1630215c-2608-44b9-aad4-9d56d8aafd4c


Header : Content-Type= application/json



Request Type : GET


###Installation Guide::


Import this project in eclipse Or any IDE
For installation use mvn clean install (Make sure MongoDB database is up and running) or we use mvn clean install -DskipTests


###Running Application::


After Compilation of Code run this application using as Java Application. Main method is present in class UserManagmentApp.

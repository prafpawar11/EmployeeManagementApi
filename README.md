<b> Install MySql Database </b>
and inside the MySql create an Amdocs database.

We have different types of Resources as <b> Employee, Customer, and Register<b>

In Employee Resource we have different Endpoints
 
<b> POST Request: It is used to create a new Entity in server <b>
BaseURI= http://localhost:9191
Resource Name : /api/v2/employees
Content-Type	application/json
Request Body:
{
  "address": "string",
  "emailId": "string",
  "firstname": "string",
  "lastname": "string",
  "mobilenumber": "string",
  "username": "string"
}


<b> GET Request	is used to get all employee information <b>

BaseURI= http://localhost:9191
Resource Name : /api/v2/employees
e.g.
http://localhost:9191/api/v2/employees

<b> GET Request	is used to get employee information using employee ID number<b>
BaseURI= http://localhost:9191
Resource Name : /api/v2/employees
PATH Parameter: {id}
e.g.
	http://localhost:9191/api/v2/employees/2

<b> GET Request is used to get Employee by using first name <b>
BaseURI= http://localhost:9191
Resource Name : /api/v2/employee
Query Parameter: 
firstname:  {{firstname}
e.g.
	http://localhost:9191/api/v2/employee?firstName=Monika


<b>PUT Request is used to update whole employee information using employee ID number <b>
BaseURI= http://localhost:9191
Resource Name : /api/v2/employees
PATH Parameter: {id}
Content-Type: application/json
Request Body:

{
  "address": "string",
  "emailId": "string",
  "firstname": "string",
  "lastname": "string",
  "mobilenumber": "string",
  "username": "string"
}

<b>PATCH Request is used to update partial employee information using employee ID number <b>
BaseURI= http://localhost:9191
Resource Name : /api/v2/employees
PATH Parameter: {id}
Content-Type: application/json
Request Body:

{
  "address": "string",
  "emailId": "string",
  "firstname": "string",
  "lastname": "string",
  "mobilenumber": "string",
  "username": "string"
}
<b> DELETE Request is used to delete the employee entity using employee ID number <b>
BaseURI= http://localhost:9191
Resource Name : /api/v2/employees
PATH Parameter: {id}

<hr>
POST
http://localhost:9191/api/v2/employees

-	Capture id and store in env variable
-	Capture firstname and store in env variables
-	TC of status code
-	TC for status line
-	TC for response time
-	TC for Content-type
-	TC for username key
-	
GET all employee info
http://localhost:9191/api/v2/employees

-	TC of status code
-	TC for status line
-	TC for response time
-	TC for Content-type
-	TC for username key

GET emp information by using id
http://localhost:9191/api/v2/employees/{id}

-	TC of status code
-	TC for status line
-	TC for response time
-	TC for Content-type
-	TC for username key

GET employee using firstname
http://localhost:9191/api/v2/employees?firstname=’{{firstname}}’

-	TC of status code
-	TC for status line
-	TC for response time
-	TC for Content-type
-	TC for username key

PUT update employee information
http://localhost:9191/api/v2/employees/{id}

-	TC of status code
-	TC for status line
-	TC for response time
-	TC for Content-type
-	TC for username key
GET emp information by using id
http://localhost:9191/api/v2/employees/{id}

-	TC of status code
-	TC for status line
-	TC for response time
-	TC for Content-type
-	TC for username key

PATCH update employee partial information by using id
http://localhost:9191/api/v2/employees/{id}
-	TC of status code
-	TC for status line
-	TC for response time
-	TC for Content-type
-	TC for username key

GET emp information by using id
http://localhost:9191/api/v2/employees/{id}

-	TC of status code
-	TC for status line
-	TC for response time
-	TC for Content-type
-	TC for username key
-	
DELETE emp information by using id
http://localhost:9191/api/v2/employees/{id}
-	TC of status code
-	TC for status line
-	TC for response time

GET emp information by using id
http://localhost:9191/api/v2/employees/{id}
-	TC of status code
-	TC for status line
-	TC for response time

Employee Spring Boot APIs Collection (getpostman.com)

https://documenter.getpostman.com/view/10316061/2sA35JzfZe


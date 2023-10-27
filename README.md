# Gmail-API
Gmail api which is returning 200  sender and  subject data

note :-I add output pdf and postman collection file in project file

clone project link
https://github.com/deepak251222/Gmail-API.git

Doc Type collection 
https://documenter.getpostman.com/view/24219652/2s9YRGw8K5

Technologies Used Backend: Spring Boot (Java) Database: MySQL Tools: IntelliJ IDEA, POSTMAN, JSON

Create a MySQL database and configure the database connection settings in application.properties. Run the application:

Open the project in IntelliJ IDEA or your preferred Java IDE. Configure the application properties and database settings. Run the Spring Boot application. Postman Collection:

Use the provided Postman collection file to test the API endpoints.

Usage

Use the API endpoints provided in the Postman collection to:

get data :-localhost:8081/api/gmail
o/p :- some output 
[
    {
        "Sender": "Deepak Kumar <deepak251222@gmail.com>",
        "Subject": "Regarding job"
    },
    {
        "Sender": "Deepak Kumar <deepak251222@gmail.com>",
        "Subject": "Deepak Kumar cv"
    },
    {
        "Sender": "Deepak Kumar <deepak251222@gmail.com>",
        "Subject": "Sreenivasashu@gmail.com"
    },
    {
        "Sender": "Deepak Kumar <deepak251222@gmail.com>",
        "Subject": "Subject: Sick Leave Request"
    },
    {
        "Sender": "Deepak Kumar <deepak251222@gmail.com>",
        "Subject": "To Close my account"
    },
.........
]

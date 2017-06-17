# Introduction 
 msched is a online schedule management and course registration system allows user to:
 - manage entry, block, course, student, faculty, classes
 - assigne faculty to classes
 - manage student enrollment
 - ability to automatically generate schedule for entry...
      
### Technologies
- Spring Tool Suites (You many use your prefered IDE and configue it to work with Spring Boot)
- Spring Boot, Spring Data JPA, MVC, REST
- SQL (PostgreSQL)
- JSP
- Boostrap, HTML, CSS, jQuery
### Requirement
- make sure your machine have PostgreSQL 9.6 installed
- open pgAdmin and create database name: msched 
- you can modify the configuration for database in [application.properties]( https://github.com/roat167/msched/blob/master/src/main/resources/application.properties)
## Build and Deploy
- Open a command prompt and navigate to the root directory of the project
- Type the following command: 

            mvn spring-boot:run
            
- By default, this will start springboot embedded tomcat. You can test the application in your web browser by navigate to url: http://localhost:8080

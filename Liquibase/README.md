# Database Tracking with Liquibase <br/>
Enter your db credentials in liquibase.properties, change the schema if needed. <br/>
(Couldn't managed environment variables like in application.properties file, since this file is only managed by maven.)<br/> <br/>
After mvn clean install and running the project
<br/>
Check the data in PERSON and DATABASECHANGELOG tables. <br/><br/>
**In DB:** alter table person add column newAgeee int;  <br/><br/>
**In Terminal:**  mvn liquibase:generateChangeLog <br/><br/>
You will see the table attribute change in the generated changeLog <br/><br/><br/>
_This storyline occurs in changelog-master.xml, there are 3 different alternatives implemented to achieve this. <br/> 
To use this one, change the **spring.liquibase.change-log** property to the mentioned one in application.properties._ 


I. PRE-REQUISITES
Java 1.8 or above
Maven 3.3 or above
Tomcat 9
MySQL Database

II. INSTALLATION
Download the uploaded source code
Open your favourite IDE(Eclipse/Intellij)
Import the code in the IDE for example in Eclipse : File -> Import -> Maven -> Existing Maven project
Create a MySql Database and tables
Update the application.properties file in the code with database connection details
spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/{database name}
spring.datasource.username=root
spring.datasource.password={password}
Right click on the Project -> Run as -> Maven clean
Right click on the Project -> Run as -> Maven install
Right click on the Project -> Run as -> Run Configurations. Set Goal as "spring-boot:run" -> Apply -> Run


III. TO RUN THIS APPLICATION:
Installing Tomcat 9:
Download and extract the .zip file
Go to the bin folder and run the startup.bat. The tomcat server will start at port 8080. 

Download the WAR file.
Create a database in Mysql. Create tables in the database
Create a application.properties file similar to the one in the source code
Go to <TOMCAT_HOME>/bin/setenv.sh file (create if missing). Add the following line
export spring.config.additional-location={application.properties folder location}
Make sure the database name, username, password specified is correct.

Copy the WAR file:
Use File Explorer to copy the WAR(tcontact-mysql-0.0.1-SNAPSHOT.war) to webapps folder in the tomcat. The tomcat console will start the deployment.
Go to http://localhost:8080/{WAR name} on the web browser.


To Run using the source code(not the war file):
Download the source code and go inside the project folder
$ mvnw clean install
$ mvn spring-boot:run





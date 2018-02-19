# REST API Server
# Steps to set development environment
Prequistise:
- Java (1.8+) (Java 9 has cahnged the version scheme to 9.0 from 1.9, so it runs into issue)
- gradle - 4.4.1
- PostgresQL 10+ : (Create the following)
    Development:
     CREATE DATABASE rms;
     CREATE USER rms WITH PASSWORD 'rms123@';
     GRANT ALL PRIVILEGES ON DATABASE rms to rms;
    Integration Testing:
     CREATE DATABASE rms_test;
     CREATE USER rms_test WITH PASSWORD rms_test;
     GRANT ALL PRIVILEGES ON DATABASE rms to rms_test;
- Install lombok.jar to support auto getters and setters in your IDE
    
1. Clone the repository
    git clone https://github.com/lalitmcb/rms.git
2. cd to rms
    cd rms/server   
3. Run 
    gradle wrapper --gradle-version 4.4.1 
   why wrapper is not checked in. It's a matter of taste
    https://stackoverflow.com/questions/20348451/why-should-the-gradle-wrapper-be-committed-to-vcs
    
# Continuous development
 1. You can create the project for your IDE.
   For eclipse
     ./gradlew eclipse
 2. To run the application 
     ./gradlew bootRun
 3. To login do a POST call to
     http://localhost:8080/login
     {
	   "email":"admin@admin.admin.khalibali",
       "password":"kidnap_president#"
     }
     It should return 
     
     
# Deployable artifact
1. Make a jar with emebedded tomcat 
     gradlew clean build
2. Run the application
     java -jar build/libs/rms-0.1.0.jar

# Debugging
1. ./gradlew bootRun --debug-jvm
   https://tedvinke.wordpress.com/2017/03/22/debugging-grails-3-spring-boot-or-gradle-with-eclipse/
2.The other options is to define GRADLE_OPTS environment variable as per your OS. (It did not work for 
  me and I don't know the reason. It should work ideally)
      GRADLE_OPTS="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5006"
  If you want to debug during application start phase, change suspend to y. This will
  make the application to wait till a debugger is attached.


# PostgresQL Notes:
1. All table names to be lowercase otherwise one has to double quote life long.
2. Use users (plural) and groups (plural) as table name as it conflicts with postgres User table.

# Disclaimer:
Many aspects of this project has been taken from multiple sources on web. I have tried to put some
links down below which I thought are dealing with some aspect in a comprehensive way.
I still have missed a lot of links but just for the sake of keeping it to the point I have been
frugal. (Please pardon me for the same.)
Also I have not put the links which are very obvious. Like Spring framework project or gradle project.
The home page of these frameworks are always the first good place to start.

LetsEncrpt
SSL using letsencrypt - https://dzone.com/articles/spring-boot-secured-by-lets-encrypt

Spring Security
https://auth0.com/blog/implementing-jwt-authentication-on-spring-boot/

Spring security cors
https://stackoverflow.com/questions/40286549/spring-boot-security-cors
   (Look at The Gilbert Arenas Dagger answer)

Integration/Unit Testing
https://stackoverflow.com/questions/281758/unit-tests-vs-integration-tests-with-spring
https://www.petrikainulainen.net/programming/gradle/getting-started-with-gradle-integration-testing/

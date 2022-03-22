FROM openjdk:17.0.2-oracle
ADD target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]

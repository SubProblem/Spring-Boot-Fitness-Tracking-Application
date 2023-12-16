FROM openjdk:17-alpine

WORKDIR /app

COPY target/fitness-tracking-app-0.0.1-SNAPSHOT.jar app.jar

COPY src/main/resources/application.properties application.properties

ENTRYPOINT ["java", "-jar", "app.jar"]


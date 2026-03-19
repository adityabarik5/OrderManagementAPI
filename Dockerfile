FROM eclipse-temurin:8-jdk-alpine

WORKDIR /app

COPY target/orderapp-1.0-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]
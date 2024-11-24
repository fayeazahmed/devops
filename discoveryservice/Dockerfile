FROM maven:3.9.5-eclipse-temurin-21 AS build

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline -B

COPY . .

RUN mvn clean package -DskipTests

FROM openjdk:21-jdk

WORKDIR /app

COPY --from=build /app/target/discoveryservice-0.0.1-SNAPSHOT.jar /app/discoveryservice-0.0.1-SNAPSHOT.jar

EXPOSE 8761

ENTRYPOINT ["java", "-jar", "/app/discoveryservice-0.0.1-SNAPSHOT.jar"]

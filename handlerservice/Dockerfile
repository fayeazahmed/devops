FROM maven:3.9.5-eclipse-temurin-21 AS build

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline -B

COPY . .

RUN mvn clean package -DskipTests

FROM openjdk:21-jdk

WORKDIR /app

COPY --from=build /app/target/handlerservice-0.0.1-SNAPSHOT.jar /app/handlerservice-0.0.1-SNAPSHOT.jar

RUN mkdir -p /app/devops-files

EXPOSE 8002

ENTRYPOINT ["java", "-jar", "/app/handlerservice-0.0.1-SNAPSHOT.jar", "-Dspring.profiles.active=${SPRING_PROFILES_ACTIVE}"]

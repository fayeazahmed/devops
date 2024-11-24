@echo off
start cmd /k "mvn -f discoveryservice/pom.xml spring-boot:run -Dspring-boot.run.profiles=local"
start cmd /k "mvn -f gatewayservice/pom.xml spring-boot:run -Dspring-boot.run.profiles=local"
start cmd /k "mvn -f requestservice/pom.xml spring-boot:run -Dspring-boot.run.profiles=local"
start cmd /k "mvn -f handlerservice/pom.xml spring-boot:run -Dspring-boot.run.profiles=local"

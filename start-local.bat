@echo off
start cmd /k "mvn -f discoveryservice/pom.xml spring-boot:run -Dspring-boot.run.profiles=local"
start cmd /k "set LOKI_URL=http://localhost:3100/loki/api/v1/push && mvn -f gatewayservice/pom.xml spring-boot:run -Dspring-boot.run.profiles=local"
start cmd /k "set LOKI_URL=http://localhost:3100/loki/api/v1/push && mvn -f requestservice/pom.xml spring-boot:run -Dspring-boot.run.profiles=local"
start cmd /k "set LOKI_URL=http://localhost:3100/loki/api/v1/push && mvn -f handlerservice/pom.xml spring-boot:run -Dspring-boot.run.profiles=local"

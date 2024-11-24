#!/bin/bash

mvn -f discoveryservice/pom.xml spring-boot:run -Dspring-boot.run.profiles=local > discoveryservice.log 2>&1 &
mvn -f gatewayservice/pom.xml spring-boot:run -Dspring-boot.run.profiles=local > gatewayservice.log 2>&1 &
mvn -f requestservice/pom.xml spring-boot:run -Dspring-boot.run.profiles=local > requestservice.log 2>&1 &
mvn -f handlerservice/pom.xml spring-boot:run -Dspring-boot.run.profiles=local > handlerservice.log 2>&1 &
tail -f discoveryservice.log gatewayservice.log requestservice.log handlerservice.log

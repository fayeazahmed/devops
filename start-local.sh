#!/bin/bash

mvn -f discoveryservice/pom.xml spring-boot:run -Dspring-boot.run.profiles=local > discoveryservice.log 2>&1 &
LOKI_URL=http://locahost:3100/loki/api/v1/push mvn -f gatewayservice/pom.xml spring-boot:run -Dspring-boot.run.profiles=local > gatewayservice.log 2>&1 &
LOKI_URL=http://locahost:3100/loki/api/v1/push mvn -f requestservice/pom.xml spring-boot:run -Dspring-boot.run.profiles=local > requestservice.log 2>&1 &
LOKI_URL=http://locahost:3100/loki/api/v1/push mvn -f handlerservice/pom.xml spring-boot:run -Dspring-boot.run.profiles=local > handlerservice.log 2>&1 &
tail -f discoveryservice.log gatewayservice.log requestservice.log handlerservice.log

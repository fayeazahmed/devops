## Devops

###  Local
Start all the services locally.

Run *docker-compose.local.yml*

    docker compose -f docker-compose.local.yml up -d
This will start *Kafka* on :9092 in localhost.

Start *MySql* database locally, then start the microservices with *start.bat/start.sh*

    mvn -f discoveryservice/pom.xml spring-boot:run -Dspring-boot.run.profiles=local
    mvn -f gatewayservice/pom.xml spring-boot:run -Dspring-boot.run.profiles=local
    mvn -f requestservice/pom.xml spring-boot:run -Dspring-boot.run.profiles=local
    mvn -f handlerservice/pom.xml spring-boot:run -Dspring-boot.run.profiles=local

###  Dev
Start all the services in dev (Docker Desktop).

Run *docker-compose.dev.yml*

    docker compose -f docker-compose.dev.yml up -d
This will start all services inside *Docker Desktop*.

###  Prod
Start all the services in prod (VirtualBox Ubuntu Live Server).

Run *docker-compose.prod.yml*

    docker compose -f docker-compose.prod.yml up -d
This will start all services inside *Docker Desktop*.
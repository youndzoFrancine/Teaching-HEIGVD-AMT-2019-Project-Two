#!/bin/bash

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"
cd $DIR
pwd
mvn -f authentication/spring-server/pom.xml clean --quiet
docker-compose -f docker/topologie/docker-compose.yml --log-level ERROR down >/dev/null
docker-compose -f docker/topologie/docker-compose.yml --log-level ERROR up --build --force-recreate -d  mysql  db_authentication   phpmyadmin
sleep 60
mvn -f authentication/spring-server/pom.xml  package
cp authentication/spring-server/target/AuthenticationSpecifications-1.0.0.jar docker/images/authentication/
docker-compose -f docker/topologie/docker-compose.yml --log-level ERROR up --build --force-recreate -d mysql  db_authentication backend-auth   phpmyadmin

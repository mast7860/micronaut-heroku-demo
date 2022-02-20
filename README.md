## Micronaut 3.3.1 Documentation

- [User Guide](https://docs.micronaut.io/3.3.1/guide/index.html)
- [API Reference](https://docs.micronaut.io/3.3.1/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/3.3.1/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)
---

- [Shadow Gradle Plugin](https://plugins.gradle.org/plugin/com.github.johnrengelman.shadow)## Feature flyway documentation

- [Micronaut Flyway Database Migration documentation](https://micronaut-projects.github.io/micronaut-flyway/latest/guide/index.html)

- [https://flywaydb.org/](https://flywaydb.org/)

## Feature lombok documentation

- [Micronaut Project Lombok documentation](https://docs.micronaut.io/latest/guide/index.html#lombok)

- [https://projectlombok.org/features/all](https://projectlombok.org/features/all)

## Feature http-client documentation

- [Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#httpClient)

## Feature jdbc-hikari documentation

- [Micronaut Hikari JDBC Connection Pool documentation](https://micronaut-projects.github.io/micronaut-sql/latest/guide/index.html#jdbc)

## Feature data-jdbc documentation

- [Micronaut Data JDBC documentation](https://micronaut-projects.github.io/micronaut-data/latest/guide/index.html#jdbc)

#Running Local

## Setup docker locally
```
https://1rfan.medium.com/running-containers-on-a-mac-905ba21f383c
```

## Option 1 : Run individual container
```
docker run --name postgres-server -p 5432:5432 -e POSTGRES_PASSWORD=password -d postgres

./gradlew clean build

docker build . -t micronaut-heroku-demo:latest

docker run --name micronaut-demo-app -p 8080:8080 -e DATABSE_HOST=host.docker.internal micronaut-heroku-demo
```

## Option 2 : Use docker-compose
```
./gradlew clean build

docker compose build && docker compose up
```

## Useful docker commands
```
docker compose ps : to see the state of all the containers
docker compose up : start
docker compose down : remove
docker compose build : build images
docker compose up -d --build : Rebuild and restart the containers
```
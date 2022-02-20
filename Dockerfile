FROM eclipse-temurin:17-jre-alpine

COPY build/libs/*-all.jar micronaut-heroku-demo.jar

EXPOSE 8080

CMD java -Dmicronaut.environments=${ENVIRONMENT} ${JAVA_OPTS} -jar micronaut-heroku-demo.jar
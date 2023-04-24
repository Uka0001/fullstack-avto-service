FROM openjdk:17-oracle
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]

FROM postgres
ENV POSTGRES_DB autoservice_db
COPY psql_dump.sql /docker-entrypoint-initdb.d/
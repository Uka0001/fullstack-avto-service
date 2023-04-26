FROM postgres
ENV POSTGRES_DB autoservice_db
COPY *.sql /docker-entrypoint-initdb.d/init/
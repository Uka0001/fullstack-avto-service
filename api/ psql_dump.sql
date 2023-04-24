FROM postgres
ADD . /init_data
run "createdb" "--template=template0" "autoservice_db"
run  "psql" "-d" "autoservice_db"  --command="create role my_admin superuser"
run  "psql" "autoservice_db" "<" "init_data/psql_dump.sql"
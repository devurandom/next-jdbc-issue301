#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
	CREATE TABLE table_a (id SERIAL PRIMARY KEY);
	CREATE TABLE table_b (fkey INTEGER REFERENCES table_a (id) ON DELETE CASCADE);
EOSQL

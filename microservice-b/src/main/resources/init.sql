CREATE DATABASE dogs;

\c quarkus_test

CREATE TABLE Dogs (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);
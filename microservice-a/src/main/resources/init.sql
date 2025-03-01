CREATE DATABASE cats;

\c quarkus_test

CREATE TABLE Cats (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);
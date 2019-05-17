-- Creates database for use by the app
CREATE DATABASE tranquil_minds;
-- Creates user that the app will use under normal day to day running.
-- It has no permissions by default; they will have to be specifically
-- granted in the alembic files when tables are created.
CREATE ROLE minds WITH LOGIN PASSWORD 'password';

-- Need to connect to the database we have just created
\c tranquil_minds

-- Create table
CREATE TABLE "testimonies" (
    "id" serial PRIMARY KEY,
    "title" VARCHAR,
    "date" DATE,
    "content" VARCHAR
);

-- Permission user
GRANT SELECT, UPDATE, INSERT, DELETE ON TABLE testimonies TO minds;
GRANT USAGE ON SEQUENCE "testimonies_id_seq" TO minds;

INSERT INTO testimonies VALUES
    ('Very Good', "2010-05-16", "What a great counselor she is"),
    ('Good', "2011-07-15", "What a good counselor she is"),
    ('Crap', "2012-11-17", "What a crap counselor she is");


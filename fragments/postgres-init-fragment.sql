-- Creates database for use by the app
CREATE DATABASE kinder_kat;
-- Creates user that the app will use under normal day to day running.
-- It has no permissions by default; they will have to be specifically
-- granted in the alembic files when tables are created.
CREATE ROLE kitty_kat WITH LOGIN PASSWORD 'password';

-- Need to connect to the database we have just created
\c kinder_kat

-- Create table
CREATE TABLE "kitties" (
    "id" serial,
    "img_id" varchar(256),
    "vote" int,
    "kat_name" varchar(256),
    PRIMARY KEY ("id")
);

-- Permission user
GRANT SELECT, UPDATE, INSERT, DELETE ON TABLE "kitties" TO kitty_kat;
GRANT USAGE ON SEQUENCE "kitties_id_seq" TO kitty_kat;

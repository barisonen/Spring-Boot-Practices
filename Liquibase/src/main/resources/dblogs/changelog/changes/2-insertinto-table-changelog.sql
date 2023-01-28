--liquibase formatted sql

--changeset baris:2 labels:offwego
INSERT INTO person(name, surname) VALUES('baris','onen');
INSERT INTO person(name, surname) VALUES('osmanthecat','onen');

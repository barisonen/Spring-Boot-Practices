--liquibase formatted sql

--changeset baris:5
ALTER TABLE person
ADD age INT;
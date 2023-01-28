--liquibase formatted sql

--changeset baris:1 context:startingourjourney labels:offwego
CREATE TABLE person(id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(50) NOT NULL,
    surname VARCHAR(50) NOT NULL);
-- rollback drop table person
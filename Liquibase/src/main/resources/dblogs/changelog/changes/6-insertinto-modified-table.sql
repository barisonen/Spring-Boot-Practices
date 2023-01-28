--liquibase formatted sql

--changeset baris:6
--comment: /* lets welcome our new friend burhan, who also has age information */
INSERT INTO person(name, surname, age) VALUES ('burhan', 'altintop', 37);
--liquibase formatted sql

--changeset baris:6
--comment: /* lets welcome our new friend burhan, who also has age information */
UPDATE person
SET age = 5
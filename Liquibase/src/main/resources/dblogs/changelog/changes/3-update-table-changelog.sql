--liquibase formatted sql

--changeset baris:3
--precondition-sql-check expectedResult:2 SELECT COUNT(*) FROM person
--comment: /* this is intentional, do not fire me for messing with the data. */
UPDATE person SET surname = 'modified_onen' WHERE name = 'baris'
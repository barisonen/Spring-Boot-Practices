--liquibase formatted sql

--changeset osman:1
--precondition-sql-check expectedResult:modified_onen SELECT surname FROM person WHERE name = 'baris'
--comment: /* dear baris, if you can update your surname, its fair for me to update my name. */
UPDATE person SET name = 'modified_osman' WHERE name = 'osman'
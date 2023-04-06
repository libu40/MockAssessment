--liquibase formatted sql

--changeset Libu Mathew:2
INSERT INTO applicationinfo(applicationName,applicationVersion) VALUES('LiquibaseWithSpringBoot','1.0');
INSERT INTO applicationinfo(applicationName,applicationVersion) VALUES('LiquibaseWithSpringBoot','2.0');

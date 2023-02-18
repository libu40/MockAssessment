--liquibase formatted sql
--changeset libu:create-tables

CREATE TABLE employee
(
    id   INT PRIMARY KEY,
    name VARCHAR(40)
);

CREATE TABLE branch
(
    id     INT PRIMARY KEY,
    name   VARCHAR(40),
    emp_id INT,
    FOREIGN KEY (emp_id) REFERENCES employee (id) ON DELETE CASCADE
);

--liquibase formatted sql
--changeset libu:inset-employee-01
INSERT INTO employee
VALUES (01, 'User1');
INSERT INTO employee
VALUES (02, 'User2');
INSERT INTO employee
VALUES (03, 'User3');
INSERT INTO employee
VALUES (04, 'User4');

--liquibase formatted sql
--changeset libu:inset-branch-01
INSERT INTO branch
VALUES (1, 'User1', 01);
INSERT INTO branch
VALUES (2, 'User2', 02);
INSERT INTO branch
VALUES (3, 'User3', 03);
INSERT INTO branch
VALUES (4, 'User4', 04);

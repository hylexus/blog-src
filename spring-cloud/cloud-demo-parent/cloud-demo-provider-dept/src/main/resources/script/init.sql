DROP DATABASE IF EXISTS cloudDemo01;
CREATE DATABASE cloudDemo01
  CHARSET 'utf8';

USE cloudDemo01;
CREATE TABLE dept (
  id        INT PRIMARY KEY AUTO_INCREMENT,
  name      VARCHAR(20) NOT NULL,
  db_source VARCHAR(20)
);

INSERT INTO dept (name, db_source)
VALUES ('开发部', database()),
       ('人事部', database()),
       ('财务部', database()),
       ('市场部', database()),
       ('运维部', database()),
       ('产品部', database()),
       ('测试部', database());
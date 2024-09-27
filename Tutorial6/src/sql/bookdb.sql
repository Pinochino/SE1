/* create database */
CREATE DATABASE bookdb;
/* use this database */
USE bookdb;
/* create a table */
CREATE TABLE book (
id INT PRIMARY KEY AUTO_INCREMENT,
title VARCHAR(50) NOT NULL,
author VARCHAR(50) NOT NULL,
price FLOAT NOT NULL);
/* insert sample data to this table */
INSERT INTO book(title, author, price)
VALUES ("Java Web", "John", 100),
("Spring Boot", "David", 120);


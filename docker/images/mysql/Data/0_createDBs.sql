DROP DATABASE IF EXISTS gestiondescours;
DROP DATABASE IF EXISTS Users;
DROP DATABASE IF EXISTS users;
DROP DATABASE IF EXISTS gestionCours;

CREATE DATABASE IF NOT EXISTS Users;
CREATE DATABASE IF NOT EXISTS gestionCours;

USE Users;

-- Adresse
CREATE TABLE  Users.UserEntity(
	email VARCHAR(100) PRIMARY KEY,
    firstname VARCHAR(100),
    lastname VARCHAR(100),
    password VARCHAR(100),
    role VARCHAR(100) 
);

USE gestionCours;

-- Personne
CREATE TABLE gestionCours.Subjects(
    name VARCHAR(100) PRIMARY KEY,
    credit_etcs INT(11) NOT NULL
);

-- Enrollments
CREATE TABLE gestionCours.Enrollments(
	email VARCHAR(100),
    name VARCHAR(100),
    foreign key (email) references Users.UserEntity(email),
    foreign key (name) references Subjects(name)
);

CREATE USER IF NOT EXISTS 'amtprojet2'@'%' IDENTIFIED BY 'pswrd';

GRANT ALL ON gestionCours.* TO 'amtprojet2'@'%';
GRANT ALL ON Users.* TO 'amtprojet2'@'%';



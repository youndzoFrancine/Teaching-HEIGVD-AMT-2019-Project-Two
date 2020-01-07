DROP DATABASE IF EXISTS gestiondescours;
DROP DATABASE IF EXISTS Users;
DROP DATABASE IF EXISTS users;
DROP DATABASE IF EXISTS gestionCours;

CREATE DATABASE IF NOT EXISTS Users;
CREATE DATABASE IF NOT EXISTS gestionCours;

USE Users;

CREATE USER IF NOT EXISTS 'amtprojet2'@'%' IDENTIFIED BY 'pswrd';

GRANT ALL ON gestionCours.* TO 'amtprojet2'@'%';
GRANT ALL ON Users.* TO 'amtprojet2'@'%';



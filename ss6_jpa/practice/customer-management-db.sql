drop database if exists cms;

create database cms;

use cms;

create table customers (
id int not null primary key auto_increment,
first_name varchar(50) not null,
last_name varchar(50) not null
);
insert into customers
(first_name,last_name)
values 
('Duy','hello'),
('Duy','hello'),
('Duy','hello'),
('Duy','hello'),
('Duy','hello');

DELIMITER //
CREATE PROCEDURE Insert_Customer(IN first_name VARCHAR(255), IN last_name VARCHAR(255))
BEGIN
    INSERT INTO customers(firstName,lastName) VALUES (first_name,last_name);
END//
DELIMITER ;
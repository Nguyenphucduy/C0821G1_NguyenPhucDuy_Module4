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
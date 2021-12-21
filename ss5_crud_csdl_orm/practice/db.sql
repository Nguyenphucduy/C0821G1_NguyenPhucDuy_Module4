drop database if exists customer_managers;

create database customer_managers;

use customer_managers;

create table customer (
customer_id int not null primary key auto_increment,
customer_name varchar(50) not null,
customer_email varchar(50) not null,
customer_address varchar(50) not null
);
insert into customer
(customer_name,customer_email,customer_address)
values 
('Duy','Diamond','qn'),
('Duy','Diamond','qn'),
('Duy','Diamond','qn'),
('Duy','Diamond','qn'),
('Duy','Diamond','qn');
drop database if exists product_managers;

create database product_managers;

use product_managers;

create table product (
id int not null primary key auto_increment,
`name` varchar(50) not null,
price double not null,
manufacture varchar(50) not null
);
insert into product
(`name`,price,manufacture)
values 
('Duy',1,'qn'),
('Duy',1,'qn'),
('Duy',2,'qn'),
('Duy',3,'qn'),
('Duy',1,'qn');
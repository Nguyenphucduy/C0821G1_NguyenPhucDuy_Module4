drop database if exists student_management;

create database student_management;

use student_management;

create table student (
id int not null primary key auto_increment,
`name` varchar(50) not null,
date_of_birth date not null,
gender int not null,
grade double not null
);
create table class (
id int not null primary key auto_increment,
class_name varchar(50) not null
);


insert into student
(`name`,date_of_birth,gender,grade)
values 
('Duy','2000-01-01',1,5),
('Duy','2000-01-01',1,5),
('Duy','2000-01-01',1,5),
('Duy','2000-01-01',1,5),
('Duy','2000-01-01',1,5);
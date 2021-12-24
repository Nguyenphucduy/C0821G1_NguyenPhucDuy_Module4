drop database if exists blog_mg;

create database blog_mg;

use blog_mg;

create table blog (
id int not null primary key auto_increment,
topic varchar(255) not null,
content varchar(255)  not null
);
insert into blog
(topic,content)
values 
('Duy','hello'),
('Duy','hello'),
('Duy','hello'),
('Duy','hello'),
('Duy','hello');
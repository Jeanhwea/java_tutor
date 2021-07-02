show databases;

create database test01 default character set utf8mb4 collate utf8mb4_general_ci;

create user 'user01'@'%' identified by 'user01';
grant all privileges on *.* to 'user01'@'%';
flush privileges;

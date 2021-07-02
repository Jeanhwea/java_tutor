show databases;

create database test01 default character set utf8mb4 collate utf8mb4_general_ci;

create user 'user01'@'%' identified by 'user01';
grant all privileges on *.* to 'user01'@'%';
flush privileges;


drop table author;

create table author (
  id int auto_increment primary key,
  name varchar(128) not null,
  age int,
  gender varchar(32)
);

desc author;

show create table author\G

select * from author;

insert into author('aaa', 10, 'M');

commit;

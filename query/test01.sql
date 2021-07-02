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

delete from author;


insert into author(name,age,gender) values ('aaa', 10, 'M');
insert into author(name,age,gender) values ('abc', 1, 'M');
insert into author(name,age,gender) values ('bbb', 10, 'F');
insert into author(name,age,gender) values ('baa', 2, 'M');
insert into author(name,age,gender) values ('bac', 22, 'F');
insert into author(name,age,gender) values ('caa', 70, 'M');
insert into author(name,age,gender) values ('bca', 30, 'M');

alter table author add unique key(name, age, gender);

alter table author change a1 a int;

update author set int01 = id - 30;

commit;

select * from author;

explain select * from author where a > 'a'\G

explain select age, id from author where name > 'a'\G

explain select * from author where name > 'c'\G

explain select * from author where gender > 'a'\G

explain select * from author where id > 32\G

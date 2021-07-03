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
  gender varchar(32),
  a int,
  b int,
  c int
);

desc author;


delete from author;

insert into author(name, age, gender, a, b, c) values ('daa', 11, 'M', 10, 21, 34);
insert into author(name, age, gender, a, b, c) values ('dbc', 12, 'M', 10, 22, 33);
insert into author(name, age, gender, a, b, c) values ('dbb', 10, 'F', 10, 23, 31);
insert into author(name, age, gender, a, b, c) values ('daa', 40, 'M', 11, 21, 31);
insert into author(name, age, gender, a, b, c) values ('dac', 22, 'F', 11, 22, 32);
insert into author(name, age, gender, a, b, c) values ('daa', 70, 'M', 11, 23, 33);
insert into author(name, age, gender, a, b, c) values ('dca', 30, 'M', 11, 20, 30);

alter table author add unique key uk_author_nag (name, age, gender);

alter table author drop key uk_author_nag;

alter table author drop index a;

create index ix_author_abc on author(a, b, c);

alter table author add index (a,b,c);

show create table author\G

show index from author;



alter table author add c int;

alter table author change a1 a int;

update author set c = id % 2;


select * from author;


explain select c from author where b > 2\G

explain select * from author where a > 'a'\G

explain select age, id from author where name > 'a'\G

explain select * from author where name > 'c'\G

explain select * from author where gender > 'a'\G

explain select * from author where id > 32\G


select (cast 'a' as int);

select '1' = 1;
select '0' = 1;

use shop_springboot;

drop table if exists `goods`;
create table goods(
    id bigint unsigned primary key auto_increment,
    name varchar(50) not null,
    price decimal(10,2) not null
);

insert into goods(name,price) values('iPhone X', 8999);
insert into goods(name,price) values('iPhone SE', 4599);
insert into goods(name,price) values('Chocolate', 8.99);
insert into goods(name,price) values('Hamburger', 14.88);

drop table if exists `consumer`;
create table consumer(
    id bigint unsigned primary key auto_increment,
    username varchar(50) not null,
    password varchar(50) not null,
    phoneNumber varchar(30) not null
);

insert into consumer(username, password, phoneNumber) values('Rose', '1234','1111');
insert into consumer(username, password, phoneNumber) values('Tom', '2222','2222');
insert into consumer(username, password, phoneNumber) values('Dick', '3333','3333');
insert into consumer(username, password, phoneNumber) values('Jerry', '4444','4444');

drop table if exists `favorite`;
create table favorite(
    id bigint unsigned primary key auto_increment,
    name varchar(50) not null ,
    price decimal(10,2) not null
);

drop table if exists `onlineUsers`;
create table onlineUsers(
    id bigint unsigned primary key auto_increment,
    username varchar(50) not null
);
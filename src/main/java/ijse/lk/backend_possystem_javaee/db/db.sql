drop database if exists javaee;

create database if not exists javaee;

use javaee;
create table customer(
    id varchar(100) primary key ,
    name varchar(100),
    address varchar(100),
    contact int(20)
);
drop table item;
create table item(
    id varchar(255) primary key ,
    description varchar(255) not null ,
    unitPrice decimal(10,2) not null ,
    qty int(255)not null
)
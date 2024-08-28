drop database if exists javaee;

create database if not exists javaee;

use javaee;
create table customer(
    customerId varchar(100) primary key ,
    name varchar(100),
    address varchar(100),
    contact int(20)
)
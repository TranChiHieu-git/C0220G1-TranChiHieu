create database mydb;
 create table mydb.customers(
 id int(10) not null auto_increment primary key ,
 name varchar(50) not null,
 address varchar(255) not null,
 email varchar(255) not null
 );
 
 create table mydb.orders(
 order_id int (10) not null auto_increment primary key,
 staff varchar(100) not null,
 customer_id int(10) not null,
 foreign key(customer_id) references mydb.customers(id)
 );
 
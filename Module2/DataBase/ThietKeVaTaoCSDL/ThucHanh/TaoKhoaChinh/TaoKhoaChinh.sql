create database mydatabase;
create table mydatabase.user
(
user_id int(10) auto_increment primary key,
user_name varchar(50),
password varchar(50),
email varchar(50)
);

create table mydatabase.roles
(
role_id int(10),
role_name varchar(50),
primary key (role_id)
);

create table mydatabase.userroles(
user_id int(10) not null,
role_id int(10) not null,
primary key (user_id,role_id),
foreign key(user_id) references mydatabase.user(user_id),
foreign key(role_id) references mydatabase.roles(role_id)
);

create table mydatabase.services(
services_id int(10) not null,
services_name varchar(50) not null,
services_cost int(20) not null
);

alter table mydatabase.services
add  primary key(services_id);

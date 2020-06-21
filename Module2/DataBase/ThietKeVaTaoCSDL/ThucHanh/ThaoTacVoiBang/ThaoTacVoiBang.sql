create table my_db.contacts
(
id int(11) not null auto_increment,
last_name varchar(30) not null,
first_name varchar(25),
birthday date,
constraint contacts_pk primary key (id)
);

create table my_db.suppliers
(
supplier_id int(11) not null auto_increment,
supplier_name varchar(50) not null,
account_rep varchar(50) not null default 'TBD',
constraint suppliers_pk primary key (supplier_id)
);

drop table my_db.suppliers,my_db.contacts;

alter table my_db.contacts
add full_name varchar(30) not null
after first_name;

alter table my_db.contacts
modify first_name varchar(100) not null;

alter table my_db.contacts
drop column full_name;

alter table my_db.contacts
change column id maso
int(9) not null;

alter table my_db.contacts
rename to my_db.people;

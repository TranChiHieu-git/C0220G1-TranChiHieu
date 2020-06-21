create database serum_car;

create table serum_car.Offices(
officeCode varchar(10) not null primary key,
city varchar(50) not null,
phone varchar(50) not null,
addressLine1 varchar(50) not null,
addressLine2 varchar(50),
state varchar(50),
country varchar(50) not null,
postalCode varchar(15) not null
); 

create table serum_car.Customers(
customerNumber int not null auto_increment primary key,
customerName varchar(50) not null,
contactLastName varchar(50) not null,
contactFirstName varchar(50) not null,
phone varchar(50) not null,
addressLine1 varchar(50) not null,
addressLine2 varchar(50),
city varchar(50) not null,
state varchar(50) not null,
postalCode varchar(15) not null,
country varchar(50) not null,
creditLimit float(50),
officeCode varchar(10),
foreign key (officeCode) references serum_car.Offices(officeCode)
);

create table serum_car.Productline(
productLine varchar(50) not null primary key,
textDescription text,
image varchar(250)
);

create table serum_car.Products(
productCode int not null auto_increment primary key,
productName varchar(70) not null,
productScale varchar(10) not null,
productVendor int not null,
productDescription text not null,
quantityInStock int not null,
buyPrice float(50) not null,
MSRP float(50) not null,
productLine varchar(50),
foreign key (productLine) references serum_car.Productline(productLine)
);

create table serum_car.Orders(
orderNumber int not null auto_increment primary key,
orderDate date not null,
requiredDateg date not null,
shippedDate date,
status varchar(15) not null,
comments text,
quantityOrdered int not null,
priceEach float(50) not null,
customerNumber int,
productCode int ,
foreign key (productCode) references serum_car.Products(productCode), 
foreign key (customerNumber) references serum_car.Customers(customerNumber)
);

create table serum_car.Payments(
customerNumber int not null auto_increment,
checkNumber varchar(50) not null primary key,
paymentDate date not null,
amount float(50) not null,
foreign key (customerNumber) references serum_car.Customers(customerNumber)
);

create table serum_car.Employees(
employeeNumber int not null auto_increment primary key,
lastName varchar(50) not null,
firstName varchar(50) not null,
email varchar(100) not null,
jobTitle varchar(50) not null,
reportTo int,
foreign key (reportTo) references serum_car.employees(employeeNumber),
officeCode varchar(10),
foreign key (officeCode) references serum_car.Offices(officeCode)
);

drop database serum_car;

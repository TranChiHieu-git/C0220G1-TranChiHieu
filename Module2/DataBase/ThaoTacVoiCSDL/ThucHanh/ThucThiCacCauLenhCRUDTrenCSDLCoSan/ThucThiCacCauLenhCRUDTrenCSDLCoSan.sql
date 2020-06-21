select * from classicmodels.customers;

select customernumber, contactlastname, contactfirstname, phone, city 
from classicmodels.customers;

select customernumber, contactlastname, contactfirstname, phone, city 
from classicmodels.customers 
where contactfirstname = 'Peter' and city = 'Melbourne';

select customernumber, contactlastname, contactfirstname, phone, city 
from classicmodels.customers 
where contactfirstname like '%A%';

select customernumber, contactlastname, contactfirstname, phone, city 
from classicmodels.customers 
where customernumber between 103 and 125;

select customernumber, contactlastname, contactfirstname, phone, city, country
from classicmodels.customers 
where country in ('USA','Spain','France') ;

select customernumber, contactlastname, contactfirstname, phone, city 
from customers 
where country = 'USA' or country = 'France';

select customernumber, contactlastname, contactfirstname, phone, city 
from customers 
order by contactfirstname asc ;

select customernumber, contactlastname, contactfirstname, phone, city 
from customers 
order by contactfirstname desc limit 10;

select count(country) as 'Số khách hàng số ở France' 
from classicmodels.customers 
where country='France';

insert into customers (customernumber, customername, contactfirstname, contactlastname, phone, addressline1, city, country) 
values (500, 'AgileLead', 'Lan', 'Tran', '0978822683', 'Ham Nghi', 'Ha Noi', 'Viet Nam' );

update customers 
set customername = 'Baane Mini Imports'
where customernumber = 103;

SET SQL_SAFE_UPDATES = 0;
SET FOREIGN_KEY_CHECKS=0;
SET FOREIGN_KEY_CHECKS=1;

select customernumber, contactlastname, contactfirstname, phone, city 
from customers;

delete from classicmodels.customers
where city = 'Nantes' ;
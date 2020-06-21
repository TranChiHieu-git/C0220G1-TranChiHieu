SELECT * FROM classicmodels.customers;

update classicmodels.customers set addressLine2='Level 2'
where customerNumber = '103';

delete from classicmodels.customers where customerNumber='103'; 

insert into classicmodels.customers
values(99,'abc','TEN','HO','012365987','Quang tri','level 4','Quang Tri','Victoria','19999','Viet Nam',null,null);
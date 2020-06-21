SELECT * FROM classicmodels.customers;

select customerName,phone,city,country from classicmodels.customers;

update classicmodels.customers set customerName='Hieu Tran Inc.'  where customerNumber='131';

select * from classicmodels.customers where customerName ='tran chi hieu';

select * from classicmodels.customers where customerName like '%ieu%';

select * from classicmodels.customers where customerName like '%a%';

select * from classicmodels.customers where city in ('Las Vegas','NYC','Madrid');
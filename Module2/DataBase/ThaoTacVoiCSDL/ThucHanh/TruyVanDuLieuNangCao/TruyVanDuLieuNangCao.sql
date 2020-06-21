select productCode, productName, buyprice, quantityInStock 
from classicmodels.products
where buyprice > 56.76 and quantityInStock > 10;

SELECT productCode,productName, buyprice, textDescription
FROM classicmodels.products
INNER JOIN classicmodels.productlines
ON products.productline = productlines.productline
WHERE buyprice > 56.76 AND buyprice < 95.59;

select productCode, productName, buyprice, quantityInStock, productVendor, productLine 
from classicmodels.products 
where productLine = 'Classic Cars' or productVendor = 'Min Lin Diecast';
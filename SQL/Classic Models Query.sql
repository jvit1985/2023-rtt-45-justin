select * from employees where firstName = "Leslie";

select * from employees where VacationHours < 40;

select lastName, firstName from employees where firstName like "M%";

select e.firstName, e.lastName, c.customerName, c.phone, c.state
from employees e, customers c
where e.employeeNumber = c.salesRepEmployeeNumber
order by e.firstName, e.lastName;

select * from employees;

update employees set extension = "JJJJ" where firstName like "J%" and employeeNumber > 0;

insert into employees ( employeeNumber, lastName, firstName, extension, email, officeCode, reportsTo, jobTitle, VacationHours )
			values	  ( 2023, "Vititoe", "Justin", "JJJJ", "e@mail.com", 1, 1002, "Title", 500 );
            
delete from employees where employeeNumber = 2023;

SELECT 
    orderNumber,
    orderLineNumber,
    quantityOrdered * priceEach AS subtotal
FROM    orderdetails
ORDER BY subtotal DESC;

SELECT    firstName, lastName, reportsTo
FROM    employees
ORDER BY reportsTo DESC;

SELECT orderNumber, SUM(quantityOrdered) as Qty,
    IF(MOD(SUM(quantityOrdered),2),'Odd', 'Even') as oddOrEven
FROM    orderdetails
GROUP BY    orderNumber
ORDER BY    orderNumber; 

SELECT TRUNCATE(1.555,1);

SELECT productCode, AVG(quantityOrdered * priceEach) as avg_order_value
FROM     orderDetails
GROUP BY     productCode;

SELECT     productCode,
  ROUND(AVG(quantityOrdered * priceEach)) as avg_order_item_value
FROM     orderDetails
GROUP BY    productCode;

SELECT   TRUNCATE(1.999,1),  ROUND(1.999,1);

UPDATE products 
SET productDescription = REPLACE(productDescription,'abuot','about');

SELECT DATEDIFF('2011-08-17','2011-08-17');

SELECT DATEDIFF('2011-08-17','2011-08-08'); 

SELECT DATEDIFF('2011-08-08','2011-08-17'); 

SELECT orderNumber, DATEDIFF(requiredDate, shippedDate) as  daysLeft
FROM     orders
ORDER BY  daysLeft DESC;

SELECT orderNumber, DATEDIFF(requiredDate, orderDate) as remaining_days
FROM    orders
WHERE    status = 'In Process'
ORDER BY remaining_days;

SELECT 
    orderNumber,
    ROUND(DATEDIFF(requiredDate, orderDate) / 7, 2),
    ROUND(DATEDIFF(requiredDate, orderDate) / 30,2)
FROM     orders 
WHERE    status = 'In Process';

SELECT 
    orderNumber,
    DATE_FORMAT(orderdate, '%Y-%m-%d') orderDate,
    DATE_FORMAT(requireddate, '%a %D %b %Y') requireddate,
    DATE_FORMAT(shippedDate, '%W %D %M %Y') shippedDate
FROM    orders;

SELECT     orderNumber,
    DATE_FORMAT(shippeddate, '%W %D %M %Y')  as 'Shipped date'
FROM    orders
ORDER BY shippeddate;

SELECT LPAD('hi',4,'??');

SELECT LPAD('hi',1,'??');

SELECT firstName, LPAD(firstName,10,'kk'), LPAD(firstName,5,'kk'), LPAD(firstName,4,'kk')  				                    
FROM classicmodels.employees;

SELECT LTRIM('  SQL LTRIM function');

SELECT RTRIM('SQL RTRIM function   ');

SELECT YEAR('2002-01-01');

SELECT YEAR(shippeddate) as year,  COUNT(ordernumber) as orderQty
FROM    orders 
GROUP BY YEAR(shippeddate)
ORDER BY YEAR(shippeddate);

SELECT DAY('2022-01-15');

SELECT  DAY(orderdate) as dayofmonth, COUNT(*)
FROM    orders
WHERE    YEAR(orderdate) = 2004
GROUP BY dayofmonth
ORDER BY dayofmonth;

select c.customerNumber, c.customerName, count(o.orderNumber)
from customers c, orders o
where c.customerNumber = o.customerNumber
group by c.customerNumber
order by customerName;

select c.customerName, o.orderNumber, p.productCode, p.productName, od.quantityOrdered, p.buyPrice, p.MSRP, (p.MSRP - p.buyPrice) as product_margin,
		(p.MSRP * od.quantityOrdered) as customer_paid, ((p.MSRP - p.buyPrice) * od.quantityOrdered) as total_margin
from orders o, orderdetails od, products p, customers c
where od.productCode = p.productCode
and o.orderNumber = od.orderNumber
and c.customerNumber = o.customerNumber;

select c.customerName, p.productCode, p.productName, count(p.productCode)
from customers c, products p, orders o, orderdetails od
where od.productCode = p.productCode
and o.orderNumber = od.orderNumber
and c.customerNumber = o.customerNumber
group by c.customerNumber, p.productCode
order by p.productCode;

select p.productCode, p.productName, count(p.productCode) as order_count
from products p, orderdetails od
where p.productCode = od.productCode
group by p.productCode
order by order_count desc, productName asc;

select p.productLine, pl.textDescription, count(p.productCode) as product_count
from products p, productlines pl
where p.productLine = pl.productLine
group by p.productLine;

-- see the total profit for each item including the number of items purchased
-- so .. if product x was ordered 10 times and had 50 items ordered in each order I want to see the total gross margin
select subtable.*, subtable.net_sales - subtable.COGS as total_profit, (net_sales - COGS) / net_sales * 100 as profit_margin
from (
select p.productCode, p.productName, sum(od.quantityOrdered) as quantity_sold, sum(p.buyPrice * od.quantityOrdered) as COGS, 
	sum(p.MSRP * od.quantityOrdered) as net_sales
from products p, orderdetails od
where p.productCode = od.productCode
group by p.productCode
) as subtable
order by profit_margin asc;

-- Homework 1 of all the customer that have made orders I want to see the customer name, first order date, month of the first order, the last order date, 
-- year of the last order and how long this customer has been a customer ( last - first ) in days
select c.customerName, MIN(o.orderDate) as first_order_date, month(min(o.orderDate)) as first_month, MAX(o.orderDate) as last_order_date,
	year(max(o.orderDate)) as most_recent_year, datediff(now(), min(o.orderDate)) as days_as_customer
from customers c, orders o
where c.customerNumber = o.customerNumber
group by customerName
order by days_as_customer desc;

-- Homework 2 I want to know the average margin for all orders sorted by the order with the highest margein first. This includes the margin on the quantity of products sold
select o.orderNumber, avg(MSRP - buyPrice) as avg_margin
from orderdetails od, orders o, products p
where o.orderNumber = od.orderNumber
and od.productCode = p.productCode
group by o.orderNumber
order by avg_margin desc;


-- Homework 3 - I want to see my most profitable customers by the average proit margin of all their orders
select c.customerNumber, c.customerName, avg(MSRP - buyPrice) as avg_margin
from customers c, orders o, orderdetails od, products p
where p.productCode = od.productCode
and c.customerNumber = o.customerNumber
and od.orderNumber = o.orderNumber
group by c.customerNumber
order by avg_margin desc;

-- Lab 304.3.1 Operators

SELECT    customername, country
FROM    customers
WHERE    country = 'USA' OR country = 'France';

SELECT    customername, country, creditLimit  
FROM    customers
WHERE (country = 'USA' OR country = 'France') AND creditlimit > 100000;

SELECT  customername, country, creditLimit FROM    customers
WHERE    country = 'USA' OR country = 'France' AND creditlimit > 100000;

SELECT     productCode,  productName,  buyPrice 
FROM    products
WHERE     buyPrice BETWEEN 90 AND 100;

SELECT productCode, productName, buyPrice 
FROM products
WHERE  buyPrice >= 90 AND buyPrice <= 100;

SELECT productCode, productName, buyPrice FROM products 
WHERE buyPrice NOT BETWEEN 20 AND 100;

SELECT productCode, productName, buyPrice FROM products
WHERE  buyPrice < 20     OR     buyPrice > 100;

SELECT customerName, country, salesrepemployeenumber
FROM customers
WHERE salesrepemployeenumber IS NULL
ORDER BY  customerName; 

SELECT customerName, country, salesrepemployeenumber
FROM  customers
WHERE  salesrepemployeenumber IS NOT NULL
ORDER BY customerName;

SELECT  c.customerNumber, c.customerName,  orderNumber, o.STATUS
FROM customers c
LEFT JOIN orders o 
ON c.customerNumber = o.customerNumber
WHERE  orderNumber IS NULL;

-- create a case statement if the price Each < 50 then print low, price < 100 print medium, price >=100 then high
SELECT MSRP,
	CASE
		WHEN MSRP < 50 THEN 'low'
        WHEN MSRP < 100 THEN 'medium'
        ELSE 'high'
	end as price_each
FROM products p;

SELECT m.employeeNumber AS ManagerID, m.lastName AS Manager,  e.lastName AS 'employee', e.employeeNumber AS EmployeeID
FROM    employees e
INNER JOIN employees m ON m.employeeNumber = e.reportsTo
ORDER BY m.employeeNumber;

-- Lab 304.3.2

select c.customerName as 'Customer Name', concat(e.lastName, ', ', e.firstName) as 'Sales Rep'
from customers c JOIN employees e 
on c.salesRepEmployeeNumber = e.employeeNumber
order by c.customerName asc;

select p.productName as 'Product Name', sum(od.quantityOrdered) as 'Total # Ordered', sum(od.quantityOrdered * od.priceEach) as 'Total Sale'
from products p LEFT JOIN orderdetails od 
on p.productCode=od.productCode
group by p.productName, p.buyPrice
order by 3 desc;

select status as 'Order Status', count(status) as 'Total Orders'
from orders
group by status
order by status;

select 
     pl.productLine as 'Product Line', 
     count(od.productCode) as 'total Sold'
from productLines pl join products p 
on pl.productLine=p.productLine
 JOIN orderdetails od on p.productCode=od.productCode
group by pl.productLine
order by 2 desc;

select 
   monthname(paymentDate) AS Month, 
   year(paymentDate) AS Year,
   format(sum(amount), 2) AS 'Payments Received'
from payments
group by monthname(paymentDate), year(paymentDate)
order by year(paymentDate), month(paymentDate);

SELECT p.productName Name, p.productLine AS `Product Line`, p.productScale AS `Scale`, p.productVendor AS `Vendor` FROM productlines l NATURAL JOIN products p 
WHERE l.productLine = "Classic Cars" OR l.productLine = "Vintage Cars"
ORDER BY p.productLine DESC, p.productName ASC;

SELECT productCode, ROUND(SUM(quantityOrdered * priceEach)) AS sales
FROM orderdetails
	INNER JOIN orders USING (orderNumber)
WHERE YEAR(shippedDate) = 2003
GROUP BY productCode
ORDER BY sales DESC
LIMIT 5;

SELECT productName, sales
FROM  (SELECT productCode, ROUND(SUM(quantityOrdered * priceEach)) AS sales
    FROM orderdetails  INNER JOIN orders USING (orderNumber)
    WHERE YEAR(shippedDate) = 2003
    GROUP BY productCode
    ORDER BY sales DESC
    LIMIT 5) as top5products2003
INNER JOIN products USING (productCode);

-- Homework - having 1
-- All order that have more than 2 line items in that order. Show me the order number and the count of line items and order by the highest line items
-- first. hint: 1st write a query that will give you te count of all line items then add a having to limit

-- Homework
-- See the most expensiv order based on MSRP and item quantity

-- Homework
-- See all the customers that are in states in which we have an office
-- change this query to use a regular join
select * from offices;
select state from offices where state is not null;
select * from customers c where c.state in (select o.state from offices o where state is not null);

select *
from customers c,
	(select o.state from offices o where state is not null) os
where c.state = os.state;

-- self join
select e.lastName as employeeLastName, e.firstName as employeeFirstName, rt.lastName as reportToLastName, rt.firstName as reportsToFirstName
from employees e, employees rt
where e.reportsTo is null or e.reportsTo = rt.employeeNumber;

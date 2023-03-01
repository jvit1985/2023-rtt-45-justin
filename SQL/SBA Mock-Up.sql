select * from orders o, users u
where u.USER_ID = o.USER_ID
and u.FIRST_NAME = 'Marion';

-- Need help with figuring out
select u.USER_ID, u.FIRST_NAME, u.LAST_NAME, u.CITY 
from users u
left join orders o on u.USER_ID = o.USER_ID
where o.USER_ID is null;


-- create a query to select the names and prices of all items that have been part of 2 or more separate orders
select distinct i.NAME, i.PRICE from items i, order_items oi, orders o
where oi.ITEM_ID = i.ITEM_ID
and o.ORDER_ID = oi.ORDER_ID
group by oi.ORDER_ID;

-- create a query to return the order id, item name, item price, and quantity from orders made at stores in the the city "New York" 
-- order by order id ascending order
select o.ORDER_ID, oi.ITEM_ID, i.NAME, i.PRICE, oi.QUANTITY from
orders o, order_items oi, items i, stores s
where o.ORDER_ID = oi.ORDER_ID
and i.ITEM_ID = oi.ITEM_ID
and s.STORE_ID = o.STORE_ID
and s.city = 'New York'
order by o.ORDER_ID asc;

-- create a query that calculates total revenue generated by each item. Revenue for an item can be found as (item price * total quantity ordered)
-- Return the first column as 'ITEM_NAME' and the second column as 'REVENUE'
select i.NAME as 'ITEM_NAME', (i.PRICE * oi.QUANTITY) as 'REVENUE'
from items i, order_items oi
where oi.ITEM_ID = i.ITEM_ID
group by i.ITEM_ID;

-- create a query with the following output
-- Column 1 - Store Name - name of the store
-- Column 2 - Order Quantity - number of times an order has been made in this store
-- Column 3 - Sales Figure - 1 order or less = 'Low' more than 3 = 'High' between = 'Medium'
-- Order by order quantity in descending order
select s.NAME, oi.QUANTITY,
CASE
		WHEN oi.QUANTITY <= 1 THEN 'low'
        WHEN oi.QUANTITY < 3 THEN 'medium'
        ELSE 'high'
	end as SALES_FIGURE
from stores s, order_items oi
group by s.STORE_ID
order by oi.QUANTITY desc;


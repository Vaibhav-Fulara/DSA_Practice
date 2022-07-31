# Write your MySQL query statement below
SELECT c.name AS "Customers" FROM customers AS c LEFT JOIN orders AS o ON c.id = o.customerId 
where o.customerid is null;
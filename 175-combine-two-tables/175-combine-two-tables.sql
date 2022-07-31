# Write your MySQL query statement below
SELECT p.firstname, p.lastname, o.city, o.state FROM Person as p LEFT JOIN Address AS o ON p.personID = o.personID;
# Write your MySQL query statement below
SELECT d.name AS "Department", c.name AS "Employee", c.salary 
FROM Employee c, Department d WHERE c.departmentid = d.id AND (Departmentid, salary) in
(SELECT Departmentid, max(Salary) as max FROM Employee GROUP BY departmentid)
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      SELECT distinct(e1.salary) FROM Employee e1 
      WHERE N-1 = (SELECT COUNT(DISTINCT salary) FROM Employee e2 
                          WHERE e1.salary < e2.salary)
  );
END


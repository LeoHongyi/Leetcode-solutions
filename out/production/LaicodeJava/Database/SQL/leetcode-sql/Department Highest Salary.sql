# Write your MySQL query statement below
SELECT
    d.name as Department,
    e1.name as Employee,
    e1.Salary as Salary
FROM
    Employee e1
        JOIN
    Department d ON e1.DepartmentId = d.Id
WHERE
    (E1.DepartmentId, Salary) IN 
    (SELECT
        DepartmentId, Max(Salary)
    FROM
        Employee e2
    GROUP BY DepartmentId);
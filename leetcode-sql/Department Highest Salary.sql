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
    1 > (SELECT
            COUNT(*)
        FROM
            Employee e2
        WHERE
            e2.Salary > e1.Salary
            AND e2.DepartmentId = e1.DepartmentId);
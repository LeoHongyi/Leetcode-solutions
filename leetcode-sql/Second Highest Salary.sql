# Write your MySQL query statement below
SELECT
    IFNULL(
    (SELECT DISTINCT 
        e.Salary
    FROM
        Employee e
    ORDER BY
        e.Salary DESC
    LIMIT 1 OFFSET 1), Null) AS SecondHighestSalary;
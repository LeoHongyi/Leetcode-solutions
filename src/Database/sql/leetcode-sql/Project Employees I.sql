SELECT
    A.project_id,
    ROUND(AVG(A.experience_years), 2) as average_years
FROM (SELECT
    p.project_id,
    p.employee_id,
    e.experience_years
FROM
    Project p
        JOIN
    Employee e ON p.employee_id = e.employee_id) AS A
GROUP BY A.project_id
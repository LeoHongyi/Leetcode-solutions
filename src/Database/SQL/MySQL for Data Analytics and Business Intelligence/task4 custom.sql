/*
Task 4
Create an SQL stored procedure that will allow you 
to obtain the average male and female salary per 
department within a centain salary range. Let this 
range be defined by two values the user can insert
when calling the procedure.
Finally, visualize the obtained result-set in
Tableau as a double bar chart.
* store procedure
* average salary
* group by gender, department
* salary range MIN MAX by user input
* double bar chart
*/

USE employees_mod;
DROP PROCEDURE IF EXISTS filter_salary;

DELIMITER $$
CREATE PROCEDURE filter_salary(IN p_salary_min FLOAT, 
IN p_salary_max FLOAT)
BEGIN
	SELECT
		AVG(s.salary) as average_salary,
        e.gender,
        d.dept_name
    FROM
		t_employees e
			JOIN
		t_salaries s ON e.emp_no = s.emp_no
			JOIN
		t_dept_emp de ON e.emp_no = de.emp_no
			JOIN
		t_departments d ON de.dept_no = d.dept_no
	WHERE s.salary BETWEEN p_salary_min AND p_salary_max
	GROUP BY de.dept_no, e.gender
    ORDER BY de.dept_no, e.gender;
END $$
DELIMITER ;

CALL filter_salary(30000, 90000);

SELECT 
    MIN(salary)
FROM
    t_salaries;
SELECT 
    MAX(salary)
FROM
    t_salaries;


/*
Compare the average salary of female versus male employees in the
entire company unitl year 2002, and add a filter allowing you to
see that per each department.
* average salay
* yearly
* group by gender
* <= 2002
* line chart
*/
USE employees_mod;
SELECT
	e.gender,
	d.dept_name,
	ROUND(AVG(s.salary), 2) as salary,
    YEAR(s.from_date) as calendar_year
FROM
    t_dept_emp de
        JOIN
	t_employees e ON e.emp_no = de.emp_no
		JOIN
	t_salaries s ON e.emp_no = s.emp_no
		JOIN
	t_departments d on d.dept_no = de.dept_no
GROUP BY d.dept_no, e.gender, calendar_year
HAVING calendar_year <= 2002
ORDER BY d.dept_no;
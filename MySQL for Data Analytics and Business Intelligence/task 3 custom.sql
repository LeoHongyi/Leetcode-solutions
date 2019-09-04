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
	ee.gender,
	d.dept_name,
	AVG(s.salary) as salary,
    e.calendar_year
FROM
	(SELECT
		DISTINCT YEAR(hire_date) as calendar_year
	FROM
		t_employees
	ORDER BY calendar_year
    ) AS e
		JOIN
    t_dept_emp de ON e.calendar_year = YEAR(de.from_date)
        JOIN
	t_employees ee ON ee.emp_no = de.emp_no
		JOIN
	t_salaries s ON ee.emp_no = s.emp_no
		JOIN
	t_departments d on d.dept_no = de.dept_no
GROUP BY 2, 1, 4
HAVING calendar_year <= 2002
ORDER BY 2, 1, 4;
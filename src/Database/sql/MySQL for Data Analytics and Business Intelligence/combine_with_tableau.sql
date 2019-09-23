/*
	Compare the number of male managers to the number of female managers from different 
    departments for each year, starting from 1990.
    * count(managers)
    * group by year, gender
    * year()>= 1990
    * use area chart, a type fo graph which can be preceived as a line chart
*/
USE employees_mod;

SELECT
	d.dept_name as dept_name,
    ee.gender as gender,
    dm.emp_no as emp_no,
	dm.from_date as from_date,
    dm.to_date as to_date,
    e.calendar_year as calendar_year,
    CASE
		WHEN YEAR(dm.from_date) <= e.calendar_year AND YEAR(dm.to_date) <= e.calendar_year THEN 1
        ELSE 0
    END AS active_emp
FROM
	(SELECT
		DISTINCT YEAR(ee.hire_date) AS calendar_year
	FROM
		t_employees ee
	ORDER BY calendar_year) AS e
		CROSS JOIN
	t_dept_manager AS dm
		JOIN
	t_departments AS d ON dm.dept_no = d.dept_no
		JOIN
	t_employees AS ee ON dm.emp_no = ee.emp_no
ORDER BY ee.emp_no, e.calendar_year;

SELECT 
    d.dept_name,
    ee.gender,
    dm.emp_no,
    dm.from_date,
    dm.to_date,
    e.calendar_year,
    CASE
        WHEN YEAR(dm.to_date) >= e.calendar_year AND YEAR(dm.from_date) <= e.calendar_year THEN 1
        ELSE 0
    END AS active
FROM
    (SELECT 
        YEAR(hire_date) AS calendar_year
    FROM
        t_employees
    GROUP BY calendar_year) e
        CROSS JOIN
    t_dept_manager dm
        JOIN
    t_departments d ON dm.dept_no = d.dept_no
        JOIN 
    t_employees ee ON dm.emp_no = ee.emp_no
ORDER BY dm.emp_no, calendar_year;

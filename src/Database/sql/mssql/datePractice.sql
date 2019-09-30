
/*1. Write a query to display the first day of the month (in datetime format) three months before the current month.
Go to the editor
Sample current date : 2014-09-03
Expected result : 2014-06-01*/
SELECT
DATE(PERIOD_ADD(
EXTRACT(YEAR_MONTH FROM CURDATE()), -3) * 100 + 1);


/*2. Write a query to display the last day of the month (in datetime format) three months before the current month.
Go to the editor*/
SELECT (SUBDATE(ADDDATE
     (CURDATE(),INTERVAL 1 MONTH),
         INTERVAL DAYOFMONTH(CURDATE())DAY))
            AS LastDayOfTheMonth;

/*3. Write a query to get the distinct Mondays from hire_date in employees tables. Go to the editor
Sample table: employees*/
SELECT DISTINCT(STR_TO_DATE
     (CONCAT(YEARWEEK(hire_date),'1'),'%x%v%w'))
          FROM employees;


/*4. Write a query to get the first day of the current year. Go to the editor*/
SELECT MAKEDATE(EXTRACT(YEAR FROM CURDATE()),1);

/*5. Write a query to get the last day of the current year. Go to the editor*/
SELECT STR_TO_DATE(CONCAT(12,31,
      EXTRACT(YEAR FROM CURDATE())), '%m%d%Y');

/*6. Write a query to calculate the age in year. Go to the editor*/
SELECT YEAR(CURRENT_TIMESTAMP) -
         YEAR("1967-06-08") -
             (RIGHT(CURRENT_TIMESTAMP, 5) <
                  RIGHT("1967-06-08", 5)) as age;

/*7. Write a query to get the current date in the following format. Go to the editor
Sample date : 2014-09-04
Output : September 4, 2014*/

SELECT DATE_FORMAT(CURDATE(),'%M %e, %Y')
   AS 'Current_date';


/*8. Write a query to get the current date in Thursday September 2014 format. Go to the editor
Thursday September 2014*/
SELECT DATE_FORMAT(NOW(), '%W %M %Y');




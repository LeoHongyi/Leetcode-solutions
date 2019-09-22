# Write your MySQL query statement below
SELECT
    class
FROM(
    SELECT
        c.class,
        count(DISTINCT c.student) as counts
    FROM
        courses c
    GROUP BY
        c.class) as nums
WHERE counts >= 5
ORDER BY nums.counts DESC;

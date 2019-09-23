# Write your MySQL query statement below
SELECT
    w.name as name,
    w.population as population,
    w.area as area
FROM
    World w
WHERE
    w.area > 3000000
    OR w.population > 25000000;
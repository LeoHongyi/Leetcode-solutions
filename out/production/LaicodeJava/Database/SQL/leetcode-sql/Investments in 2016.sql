SELECT
    SUM(i.TIV_2016) as TIV_2016
FROM
    insurance i
WHERE
    i.TIV_2015 IN(
        SELECT
            TIV_2015
        FROM
            insurance
        GROUP BY TIV_2015
        HAVING COUNT(*) > 1
    )
    AND CONCAT(LAT, LON) IN(
        SELECT
            CONCAT(LAT, LON)
        FROM
            insurance
        GROUP BY LAT, LON
        HAVING COUNT(*) = 1);
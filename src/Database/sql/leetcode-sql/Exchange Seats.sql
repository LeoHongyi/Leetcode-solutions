# swith id, not student names
SELECT
    (CASE
        WHEN MOD(id, 2) != 0 AND counts != id THEN id + 1
        WHEN MOD(id, 2) != 0 AND counts = id THEN id
        ELSE id - 1
    END) as id,
    student
FROM
    seat,
    (SELECT
        count(*) as counts
     FROM
        seat) as seat_counts
ORDER BY id ASC;
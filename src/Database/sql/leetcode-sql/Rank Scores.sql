SELECT
    Score,
    (SELECT
        count(*)
    FROM
        (SELECT DISTINCT
            Score s
        FROM
            Scores) AS tmp
    WHERE
        s >= Score) AS Rank
FROM
    Scores
ORDER BY Score DESC;
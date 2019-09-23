SELECT
    c.name
FROM
    customer c
WHERE
    referee_id IS NULL
    OR referee_id <> 2;
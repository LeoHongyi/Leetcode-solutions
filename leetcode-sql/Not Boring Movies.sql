SELECT
    c.id,
    c.movie,
    c.description,
    c.rating
FROM
    cinema c
WHERE
    MOD(c.id, 2) != 0
    AND c.description != 'boring';
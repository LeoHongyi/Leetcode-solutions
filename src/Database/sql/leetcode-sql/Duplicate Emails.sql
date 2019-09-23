# use Group by and count > 1
SELECT
    p.Email
FROM
    Person p
GROUP BY
    p.Email
HAVING
    count(p.Email) > 1;
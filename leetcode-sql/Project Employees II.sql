SELECT
    project_id
FROM
    Project p
GROUP BY project_id
ORDER BY COUNT(*) DESC
LIMIT 1;
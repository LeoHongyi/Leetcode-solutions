SELECT
    project_id,
    COUNT(*)
FROM
    Project p
GROUP BY
    project_id;
SELECT
    DISTINCT project_id
FROM
    Project
HAVING project_id = (
    SELECT
        project_id
    FROM
        Project p
    GROUP BY project_id
    ORDER BY COUNT(*) DESC
    LIMIT 1);
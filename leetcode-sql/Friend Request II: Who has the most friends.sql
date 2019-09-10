SELECT
    t2.ids,
    t2.count
FROM(
    SELECT
        ids,
        count(*) as count
    FROM(
        SELECT
            requester_id as ids
        FROM
            request_accepted
        UNION ALL
        SELECT
            accepter_id
        FROM
            request_accepted) AS t1
    GROUP BY ids) as t2
ORDER BY t2.count DESC
LIMIT 1;
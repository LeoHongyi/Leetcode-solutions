# Write your MySQL query statement below
SELECT
    a.extra as report_reason,
    count(distinct a.post_id) as report_count
FROM
    Actions a
WHERE
    a.action_date = '2019-07-04'
    AND a.action = 'report'
GROUP BY a.extra;
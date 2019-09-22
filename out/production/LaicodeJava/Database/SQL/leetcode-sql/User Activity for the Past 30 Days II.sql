select 
    round(
        ifnull(
            count(distinct session_id)
            /
            count(distinct user_id),0),2) as average_sessions_per_user
from 
    activity
where activity_date <= '2019-07-27' and activity_date > '2019-06-27'
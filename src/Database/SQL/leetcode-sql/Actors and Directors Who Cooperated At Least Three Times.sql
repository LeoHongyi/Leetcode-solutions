SELECT
    actor_id as ACTOR_ID,
    director_id as DIRECTOR_ID
FROM
    ActorDirector ad
GROUP BY actor_id, director_id
HAVING COUNT(actor_id) >= 3;
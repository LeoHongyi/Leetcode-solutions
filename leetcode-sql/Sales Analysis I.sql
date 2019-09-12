SELECT
    seller_id
FROM(
    SELECT
        seller_id,
        SUM(quantity) as sum_quantity
    FROM
        Sales s
    GROUP BY seller_id) as quantity
WHERE
    seller_id = MAX(sum_quantity);

# join table and sum()
SELECT
    p.product_id,
    SUM(quantity) as total_quantity
FROM
    Sales s
        JOIN
    Product p ON s.product_id = p.product_id
GROUP BY p.product_id
ORDER BY p.product_id;
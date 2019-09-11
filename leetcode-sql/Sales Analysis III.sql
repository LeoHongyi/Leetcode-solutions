SELECT
    s.product_id,
    p.product_name
FROM
    Sales s
        JOIN
    Product p on s.product_id = p.product_id
WHERE
    s.sale_date > '2019-01-01'
    AND s.sale_date < '2019-03-31';
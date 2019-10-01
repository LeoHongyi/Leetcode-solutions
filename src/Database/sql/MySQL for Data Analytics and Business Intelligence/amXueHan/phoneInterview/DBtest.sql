/**
Table: OrderInfo
fields:
    OrderId,
    productId,
    Order_date,
    quantity,
    price
*/

/**
1. Find product sold in both year in 2016 and 2017. 
Assume you have data for any years
*/
SELECT
    product_id
FROM
    Order_info
WHERE
    DATE BETWEEN '01-01-2016' TO '12-31-2017'
    INNER JOIN ProductId FROM Orderinofo BETWEEN

/**
2. Find top 7 purchased item per year based on amount
*/
SELECT
    product_id
FROM
    Order_info
GROUP BY  Product_id, order_date
ORDER BY quantity DESC
;
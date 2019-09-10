SELECT
    c.Name as Customers
FROM
    Customers c
WHERE
    c.id NOT IN(
        SELECT 
            customerid 
        from 
            orders
    );
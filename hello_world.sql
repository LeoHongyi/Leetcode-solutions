SELECT first_name, last_name, email
FROM customer
WHERE store_id = 2
;

SELECT count(title)
FROM film
WHERE rental_rate = .99
;

SELECT count(title), rental_rate
FROM film
GROUP BY rental_rate
;

SELECT rating, count(film_id)
FROM film
GROUP BY 1
;

SELECT customer.customer_id, customer.first_name, customer.last_name, address.address

FROM customer, address
WHERE customer.address_id = address.address_id
;

SELECT
  f.title as "Film Title",
  count(r.rental_id) as "Number of Rentail",
  f.rental_rate as "Rental price",
  count(r.rental_id) * f.rental_rate as Revenue
FROM
  film f,
  rental r,
  inventory i
WHERE
  f.film_id = i.film_id
  AND i.inventory_id = r.inventory_id
GROUP BY
  1
ORDER BY
  4 desc
;

SELECT
  p.customer_id, SUM(p.amount)
FROM
  payment p
GROUP BY
  1
ORDER BY
  2 desc
;

SELECT
  i.store_id as "Store ID", sum(p.amount) as Revenue
FROM
  inventory i, payment p, rental r
WHERE
    p.rental_id = r.rental_id
    AND r.inventory_id = i.inventory_id
GROUP BY
  1
ORDER BY
  2 desc
;


SELECT
  r.rental_date, count(r.rental_id)
FROM
    rental r
GROUP BY
  1
ORDER BY
  2 desc
;


SELECT
  left(r.rental_date, 7), count(r.rental_id)
FROM
    rental r
GROUP BY
  1
ORDER BY
  2 desc
;

SELECT
  f.title as "Film Title",
  max(r.rental_date) as "Last Rental Date",
  min(r.rental_date) "First Rental Date"
FROM
    rental r, inventory i, film f
WHERE
    r.inventory_id = i.inventory_id
    AND i.film_id = f.film_id
GROUP BY
  f.film_id
;

-- Every customer's last rental date
SELECT
  concat(c.first_name, " ", c.last_name) as Name,
  c.email as email,
  max(r.rental_date) as last_rental_date
FROM
    customer c,
    rental r
WHERE
    r.customer_id = c.customer_id
GROUP BY
  c.customer_id
;

-- revenue by month
SELECT
    left(p.payment_date, 7) as Month,
    sum(p.amount) as Monthly_revenue
FROM
    payment p
GROUP BY
  1
;

-- How many distinct renters per month
SELECT
    left(r.rental_date, 7) as Month,
    count(r.rental_id) as total_rentals,
    count(distinct r.customer_id) as unique_renters,
    count(r.rental_id)/count(distinct r.customer_id) as avg_num_rentals_per_renter
FROM
    rental r
GROUP BY
  1
;

-- Number of distinct movies rented per month
SELECT
    left(r.rental_date, 7) as Month,
    count(r.rental_id) as total_rentals,
    count(distinct i.film_id) as unique_films_rented,
    count(r.rental_id)/count(distinct i.film_id) as rental_per_film
FROM
    rental r,
    inventory i
WHERE
    r.inventory_id = i.inventory_id
GROUP BY
  1
;

-- IN(),comparison operators, HAVING

-- number of rentals in the Comedy, Sports and Family
SELECT
    c.name as category,
    count(r.rental_id) as num_rentals
FROM
    rental r,
    inventory i,
    film f,
    film_category fc,
    category c
WHERE
    r.inventory_id = i.inventory_id
    AND i.film_id = f.film_id
    AND f.film_id = fc.film_id
    AND fc.category_id = c .category_id
    AND c.name in ("Comedy", "Sports", "Family")
GROUP BY
  1
;


-- comparison operators (>, =)

-- user's who have rented at least 3 times
SELECT
    r.customer_id as customer,
    count(r.rental_id) as num_rentals
FROM
    rental r
GROUP BY
  1
HAVING count(r.rental_id) >= 3
;

-- revenue for store 1 where film is rated R or PG-13
  SELECT
    i.store_id as Store,
    f.rating as movie_rating,
    sum(p.amount) as store_revenue
  FROM
    film f, 
    payment p, 
    inventory i, 
    rental r
  WHERE
    p.rental_id = r.rental_id
    AND r.inventory_id = i.inventory_id
    AND i.film_id = f.film_id
    AND i.store_id = 1
    AND f.rating in ('R', 'PG-13')
    AND r.rental_date between '2005-06-08' 
    AND '2005-07-19'
  GROUP BY
    1, 2
  ORDER BY
    3 desc
  ;

-- Rentals per customer
SELECT
  rpc.num_rentals,
  count(distinct rpc.customer_id) as num_customers,
  sum(p.amount) as total_revenue
FROM
  (
    SELECT
      r.customer_id,
      count(distinct r.rental_id) as num_rentals
    FROM
      rental r
    GROUP BY
      1
  ) as rpc,
  payment p
WHERE
  rpc.customer_id = p.customer_id
  AND rpc.num_rentals > 20
GROUP BY
  1;

-- Rentals per customer
create temporary table rpc as
SELECT
  r.customer_id,
  count(distinct r.rental_id) as num_rentals
FROM
  rental r
GROUP BY
  1;
  
SELECT
  sum(p.amount) as total_revenue
FROM
  rpc,
  payment p
WHERE
  rpc.customer_id = p.customer_id
  AND rpc.num_rentals > 20;

SELECT
  ac.customer_id,
  ac.fav_color,
  rc.num_purchases
FROM
  active_customer ac,
  reward_customer rc
WHERE
  ac.customer_id =rc.customer_id;

-- JOIN example
SELECT
  ac.customer_id,
  ac.fav_color,
  rc.num_purchases
FROM
  active_customer ac
  JOIN reward_customer rc 
  ON ac.customer_id = rc.customer_id;

-- LEFT JOIN
SELECT
  ac.customer_id,
  ac.fav_color,
  rc.num_purchases
FROM
  active_customer ac
  LEFT JOIN reward_customer rc
  ON ac.customer_id = rc.customer_id;

-- Join lecture temporary tables
/*
all columns from active customers (active = 1)
AND 
phone number from the address 
customer_id, active, phone_number
*/
SELECT
  c.*,
  a.phone
FROM
  customer c
  JOIN address a ON c.address_id = a.address_id
WHERE
  c.active = 1
GROUP BY
  1;

/*
at least 30 rentals
customer_id, number of rentals and last rental date
just using rental table
*/
SELECT
  r.customer_id,
  count(r.rental_id) as num_rentals,
  max(rental_date) as latest_rental_date
FROM
  rental r
GROUP BY
  1
HAVING
  num_rentals >= 30
ORDER BY
  2 desc;

/*
reward users who are also active users
columns: customer_id,
email,
first_name
*/
drop temporary table if exists activeUsers;
create temporary table activeUsers
SELECT
    c.*,
    a.phone
FROM
    customer c
    JOIN address a ON c.address_id = a.address_id
WHERE
    c.active = 1
GROUP BY
    1;

drop temporary table if exists rewardUsers;
create temporary table rewardUsers
SELECT
    r.customer_id,
    count(r.rental_id) as num_rentals,
    max(rental_date)
FROM
    rental r
GROUP BY
    1
HAVING
    num_rentals >= 30;
    
-- reward users AND ACTIVE users using the JOIN functions
    
SELECT
  a.customer_id,
  a.email,
  a.first_name
FROM
  activeUsers a
  JOIN rewardUsers r on a.customer_id = r.customer_id
GROUP BY
  1;

/*
All reward users
columns: customer_id,
email,
phone(for those who are also active users)
*/
drop temporary table if exists activeUsers;
create temporary table activeUsers
SELECT
    c.*,
    a.phone
FROM
    customer c
    JOIN address a ON c.address_id = a.address_id
WHERE
    c.active = 1
GROUP BY
    1;

drop temporary table if exists rewardUsers;
create temporary table rewardUsers
SELECT
    r.customer_id,
    count(r.rental_id) as num_rentals,
    max(rental_date)
FROM
    rental r
GROUP BY
    1
HAVING
    num_rentals >= 30;
    
-- All reward users information
SELECT
  r.customer_id,
  c.email,
  a.phone
FROM
  rewardUsers r
  JOIN customer c on r.customer_id = c.customer_id
  LEFT JOIN activeUsers a on a.customer_id = r.customer_id
GROUP BY
  1
ORDER BY
3;
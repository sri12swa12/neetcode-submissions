with prod as (
    select customer_id, product_id, count(product_id) as ct
    from orders
    where customer_id in (select customer_id from customers)
    group by customer_id, product_id
),
freq as (
    select customer_id, product_id,
    DENSE_RANK() OVER (partition by customer_id order by ct desc) as rn
    from prod
)
select f.customer_id, f.product_id, p.product_name
from freq f
join products p
on f.product_id = p.product_id
where f.rn = 1
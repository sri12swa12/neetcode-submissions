-- Write your query below
with hight as (
    select transaction_id, 
    DENSE_RANK() OVER (partition by extract(day from day) order by amount DESC) as rn
    from transactions
)
select transaction_id from hight where rn=1
order by transaction_id
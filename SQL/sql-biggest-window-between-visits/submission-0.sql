-- Write your query below
with append as (
    select distinct user_id, '2021-1-1'::date as visit_date
    from user_visits
    union
    select user_id, visit_date
    from user_visits
),
days as (
    select user_id, visit_date, lag(visit_date) over (partition by user_id order by visit_date) as prev_date
    from append
)
select user_id, max(visit_date - prev_date) as biggest_window
from days
group by user_id
order by user_id
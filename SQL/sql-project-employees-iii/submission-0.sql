-- Write your query below
with rnk as (

    select p.project_id, p.employee_id,
    DENSE_RANK() OVER (partition by p.project_id order by e.experience_years DESC) as rk
    from project p
    join employee e
    on p.employee_id = e.employee_id
)
select project_id, employee_id
from rnk where rk = 1
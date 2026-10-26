-- Write your query below
with direct as (
    select employee_id from employees where manager_id = 1 and employee_id!=1
),
ind1 as (
    select employee_id from employees 
    where manager_id  in  (select employee_id from direct)
),
ind2 as (
    select employee_id from employees 
    where manager_id in  (select employee_id from ind1)
),
all_reportee as (
    select * from direct
    union all
    select * from ind1
    union all
    select * from ind2
)
select distinct employee_id from all_reportee

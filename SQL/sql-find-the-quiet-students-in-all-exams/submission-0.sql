-- Write your query below
with ls_and_hs as 
(
    select exam_id, student_id,
    rank() over (partition by exam_id order by score) as ls,
    rank() over (partition by exam_id order by score DESC) as hs
    from exam
    where score is not null
),
nqs as (
    select distinct student_id from ls_and_hs
    where ls = 1 or hs = 1
)
select DISTINCT s.student_id, s.student_name  from exam e
join student s
on e.student_id = s.student_id
where e.student_id not in (select student_id from nqs)
order by s.student_id

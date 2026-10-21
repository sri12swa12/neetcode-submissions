-- Write your query below
SELECT
    t.task_id,
    s.subtask_id
FROM tasks t
CROSS JOIN LATERAL generate_series(1, t.subtasks_count) AS s(subtask_id)
WHERE NOT EXISTS (
    SELECT 1
    FROM executed e
    WHERE e.task_id = t.task_id
      AND e.subtask_id = s.subtask_id
)
ORDER BY t.task_id, s.subtask_id;
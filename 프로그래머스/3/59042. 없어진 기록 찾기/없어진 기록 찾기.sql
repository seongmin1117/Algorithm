-- 코드를 입력하세요

SELECT o.animal_id, o.name
from animal_ins as i  
right outer join animal_outs as o
on i.animal_id = o.animal_id
where i.intake_condition is null
order by o.animal_id asc;

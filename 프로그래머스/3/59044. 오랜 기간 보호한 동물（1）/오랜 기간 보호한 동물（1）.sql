select a.name as name, a.datetime as datetime

from animal_ins as a left join animal_outs as b

on a.animal_id = b.animal_id

where b.animal_id is null

order by datetime

limit 3;
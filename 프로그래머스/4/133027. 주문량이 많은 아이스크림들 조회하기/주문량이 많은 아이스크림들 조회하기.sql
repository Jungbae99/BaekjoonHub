select flavor 
from
    (select * from july
    union all
    select * from first_half
    ) a


group by flavor
order by sum(total_order) desc
limit 3;
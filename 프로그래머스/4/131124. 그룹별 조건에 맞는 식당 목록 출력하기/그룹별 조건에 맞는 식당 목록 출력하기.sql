
select member_name, review_text, date_format(review_date, '%Y-%m-%d') as review_date
from rest_review as R
    inner join (
        select m.member_id, m.member_name from member_profile as M 
            inner join (
            select member_id, count(review_id) as r_count 
            from rest_review
            group by member_id
            order by r_count desc limit 1
            ) as r on m.member_id = r.member_id
    ) as tmp on r.member_id = tmp.member_id
order by review_date, review_text
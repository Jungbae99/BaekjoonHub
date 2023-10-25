-- 코드를 입력하세요
SELECT ii.ingredient_type INGREDIENT_TYPE, sum(TOTAL_ORDER) as TOTAL_ORDER

from first_half as  fh

join ICECREAM_INFO  as ii

where fh.flavor = ii.flavor 

group by INGREDIENT_TYPE

order by total_order ;
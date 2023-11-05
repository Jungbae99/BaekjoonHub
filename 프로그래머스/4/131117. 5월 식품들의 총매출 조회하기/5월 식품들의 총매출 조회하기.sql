-- 코드를 입력하세요
SELECT p.product_id , p.product_name, sum(o.amount * p.price) as total_sales

from food_order o left join food_product p 
on o.product_id = p.product_id

where o.produce_date like '2022-05%'
group by p.product_id
order by 3 desc, 1
select year(sales_date) as year, month(sales_date) as month, user_info.gender, count(distinct online_sale.user_id) as users

from online_sale
  join user_info
  on online_sale.user_id = user_info.user_id and
  gender is not null
  
  group by year(sales_date), month(sales_date), user_info.gender
  order by year(sales_date), month(sales_date), user_info.gender
select b.category as CATEGORY, sum(bs.sales) as TOTAL_SALES

from book b join book_sales bs 

on b.book_id = bs.book_id

where month(bs.sales_date) = 1 and year(bs.sales_date) = 2022

group by b.category 

order by b.category;
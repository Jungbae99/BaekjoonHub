select a.category, a.price, a.product_name

from food_product a join (
    select category, max(price) MAX_PRICE
    from food_product
    where category in ("과자","국", "김치", "식용유")
    group by category
) b
on a.category = b.category and a.price = b.MAX_PRICE

order by price desc;



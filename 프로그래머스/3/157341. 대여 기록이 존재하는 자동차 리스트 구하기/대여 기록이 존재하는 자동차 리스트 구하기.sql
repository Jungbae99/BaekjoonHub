-- 코드를 입력하세요
SELECT distinct cc.car_id from car_rental_company_car as cc

join car_rental_company_rental_history as ch

on cc.car_id = ch.car_id 

where month(ch.start_date) = 10 and cc.car_type ='세단'

order by car_id desc;
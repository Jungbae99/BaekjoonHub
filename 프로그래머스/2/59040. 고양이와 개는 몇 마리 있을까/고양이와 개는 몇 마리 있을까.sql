
select animal_type, count(animal_type) from animal_ins
group by animal_type
order by animal_type;

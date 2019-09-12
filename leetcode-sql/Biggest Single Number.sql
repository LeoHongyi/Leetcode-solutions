select(
    select 
         num
    from 
            my_number
    group by num
    having count(*) = 1
    order by num desc 
    limit 1
) as num;
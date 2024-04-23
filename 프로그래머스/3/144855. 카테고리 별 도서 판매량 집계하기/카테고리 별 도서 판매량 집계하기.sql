-- 코드를 입력하세요

select category, sum(sumBook) as total_sales
from book
left join (
select book_id, sum(sales) as sumBook
from book_sales
where sales_date like '2022-01%'
group by book_id
    ) as sub
    on book.book_id = sub.book_id
group by category
order by category asc
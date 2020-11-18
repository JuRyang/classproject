--문제풀이
select * from book;
select*from customer;
select*from orders;

--1 마당서점의고객이요구하는다음질문에대해SQL 문을작성하시오.
--(5) 박지성이구매한도서의출판사수

select DISTINCT o.bookid 
from customer c, orders o
where c.custid=o.custid
and c.name='박지성'
;


select count(distinct publisher)
from book
where bookid in (select DISTINCT o.bookid 
from customer c, orders o
where c.custid=o.custid
and c.name='박지성')
;

--조인을 이용한 해결
select  count (distinct b.publisher)
from customer c, book b, orders o
where o.custid = c.custid and o.bookid = b.bookid
and c.name='박지성'
;

--내가 푼거
select custid from customer where name = '박지성';

select count(publisher)
from book , orders
where book.bookid = orders.bookid 
and custid=(select custid from customer where name='박지성')
;

--(6) 박지성이구매한도서의이름, 가격, 정가와판매가격의차이

select b.bookname, b.price, b.price-o.saleprice "pricegap"
from  customer c, book b, orders o
where c.custid = o.custid and b.bookid= o.bookid
and c.name = '박지성'
;

select custid from customer where name = '박지성'; 

select *
from book b, orders o
where b.bookid = o.bookid
and o.custid =(select custid from customer where name = '박지성')
;


--
select  bookname, price -saleprice "pricegap" from book , orders
where book.bookid = orders.bookid
and custid=(select custid from customer where name='박지성')
;

--(7) 박지성이구매하지않은도서의이름

--도서의 이름 출력

--박지성이 구매한 도서의 아이디
select bookid
from orders
where custid = (select custid from customer where name = '박지성')
;

select bookname
from book
where bookid not in(
                  select custid 
                  from orders
                  where  custid = (
                       select custid from customer where name = '박지성'
                       ))
;


-- 방법2
select distinct b.bookname
from  customer c, book b, orders o
where c.custid = o.custid 
and b.bookid= o.bookid 
and c.name != '박지성'
;










select  *  from book , orders
where book.bookid = orders.bookid
and custid =(select custid from customer where name='박지성');



select bookname  from book 
where bookname not in
(select bookname from  book b,orders o ,customer c
where b.bookid = o.bookid
and c.custid = o.custid
and c.name = '박지성');

--(8) 주문하지않은고객의이름(부속질의사용)

select distinct custid
from orders ;

--구매 고객 리스트
select name
from customer
where custid not in (select distinct custid from orders)
;


--조인을 이용한 문제해결 o.custid(+) ***
select c.name
from orders o, customer c
where o.custid(+) = c.custid
and o.orderid is null 
;


select name 
from  customer 
where custid not in(select custid from orders);

--(9) 주문금액의총액과주문의평균금액
select sum(saleprice), avg(saleprice)
from orders
;



select sum(saleprice)"total",avg(saleprice)"AVGSALEPRICE" from orders;

--(10) 고객의이름과고객별구매액
select c.name, sum(saleprice)
from customer c, orders o
where c.custid = o.custid
group by c.name
;

--
select name, saleprice
from customer c,orders o,book b
where  c.custid  = o.custid
and b.bookid = o.bookid
order by name
;

--(11) 고객의이름과고객이구매한도서목록

select c.name, b.bookname
from customer c, book b, orders o
where c.custid = o.custid
and b.bookid = o.bookid
;




select name, bookname
from customer c,orders o,book b
where b.bookid = o.bookid
and c.custid= o.custid
order by name;




--(12) 도서의가격(Book 테이블)과판매가격(Orders 테이블)의차이가가장많은주문

--orders orderid
select o.orderid, b.price - o.saleprice
from book b, orders o
where o.bookid = b.bookid
and b.price - o.saleprice >= all(
                           --   select max(b.price - o.saleprice)
                              select b.price - o.saleprice
                              from book b, orders o
                              where o.bookid = b.bookid
)
;

--2
select o.orderid, b.price - o.saleprice
from book b, orders o
where o.bookid = b.bookid
and b.price - o.saleprice = (
                              select max(b.price - o.saleprice)
                              from book b, orders o
                              where o.bookid = b.bookid
)
;

select max(b.price - o.saleprice)
from book b, orders o
where o.bookid = b.bookid
;






--(13) 도서의판매액평균보다자신의구매액평균이더높은고객의이름

--판매액 평균
select avg(saleprice)from orders; --11800
select * from customer;

--자신의 구매액 평균
select c.name, avg(saleprice)
from customer c, orders o
where c.custid = o.custid
group by c.name
having avg(saleprice)> (select avg(saleprice)from orders)
;

--(1)박지성이 구매한 도서의 출판사와 같은 출판사에서 도서를 구매한 고객의 이름
--<다시보기>
--박지성이 구매한 도서의 출판사
select distinct publisher 
from book b, customer c,orders o
where c.custid = o.custid
and o.bookid = b.bookid
and c.name = '박지성'
;

--
select c.name
from book b, customer c,orders o
where c.custid = o.custid
and o.bookid = b.bookid
and b.publisher in(
               select distinct publisher 
               from book b, customer c,orders o
               where c.custid = o.custid
               and o.bookid = b.bookid
               and c.name = '박지성'

)
and c.name != '박지성'
;


--(2) 두 개 이상의 서로 다른 출판사에서 도서를 구매한 고객의 이름

select c.name,count(distinct b.publisher)
from customer c, book b, orders o
where c.custid = o.custid and b.bookid = o.bookid
group by c.name
having count(distinct b.publisher)>1 --****
;

select c.name, b.bookname, b.publisher 
from book b, customer c,orders o
where c.custid = o.custid
and o.bookid = b.bookid
order by c.name
;

--서브쿼리 3개이상인 경우 결합 조인해야 함.(성능의 문제)














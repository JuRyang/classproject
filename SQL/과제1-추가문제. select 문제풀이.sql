--select 추가 문제 

--1 마당서점의고객이요구하는다음질문에대해SQL 문을작성하시오.
--(1) 도서번호가1인도서의이름
select bookname
from BOOK
where bookid = 1
;
--(2) 가격이20,000원이상인도서의이름 :book

select bookname,price
from Book
where price>=20000
;
--(3) 박지성의총구매액(박지성의고객번호는1번으로놓고작성):orders
select sum(saleprice) as totalprice
from Orders
where custid = 1  --박지성의 custid
;

select sum(saleprice) as totalprice
from Orders
where custid =(select custid from customer where name = '박지성')  --박지성의 custid
;


--(4) 박지성이구매한도서의수(박지성의고객번호는1번으로놓고작성)
-- 박지성의 구매 횟수 = 구매한 도서의 수 

select count(*) as "구매횟수"
from orders 
where custid =1
;

select count(saleprice) 
from Orders
where custid = 1
;


--2 마당서점의운영자와경영자가요구하는다음질문에대해SQL 문을작성하시오.
--(1) 마당서점도서의총개수 :book의 총 row의 개수

select  count(*)  as"도서의 총 개수"
from Book
;

select  count(bookname) 
from Book
;

--(2) 마당서점에도서를출고하는출판사의총개수 :book의 총 row의 개수
select count (DISTINCT publisher)
from Book
;


--(3) 모든고객의이름, 주소 :모든은 where절이 없다
select name, address
from Customer
;

--(4) 2014년7월4일~7월7일사이에주문받은도서의주문번호
select orderid 
from orders
where orderdate  between '14/07/04' and '14/07/07'
;


--(5) 2014년7월4일~7월7일사이에주문받은도서를제외한도서의주문번호

select orderid 
from orders
where orderdate  not between '14/07/04' and '14/07/07'
;


--(6) 성이‘김’씨인고객의이름과주소
select name, address
from Customer
where name like'김%'
;

--(7) 성이‘김’씨이고이름이‘아’로끝나는고객의이름과주소 :name '김%아'
select name,address
from Customer
where name Like '김%아'
;
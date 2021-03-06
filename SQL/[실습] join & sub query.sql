--1 마당서점의고객이요구하는다음질문에대해SQL 문을작성하시오.
--(5) 박지성이구매한도서의출판사수
select custid from customer where name = '박지성';

select count(publisher)
from book , orders
where book.bookid = orders.bookid 
and custid=(select custid from customer where name='박지성')
;

--(6) 박지성이구매한도서의이름, 가격, 정가와판매가격의차이
select  bookname, price -saleprice "pricegap" from book , orders
where book.bookid = orders.bookid
and custid=(select custid from customer where name='박지성')
;

--(7) 박지성이구매하지않은도서의이름
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

select name from  customer where custid not in(select custid from orders);

--(9) 주문금액의총액과주문의평균금액
select sum(saleprice)"total",avg(saleprice)"AVGSALEPRICE" from orders;

--(10) 고객의이름과고객별구매액
select name, saleprice
from customer c,orders o,book b
where  c.custid  = o.custid
and b.bookid = o.bookid
order by name
;

--(11) 고객의이름과고객이구매한도서목록

select name, bookname
from customer c,orders o,book b
where b.bookid = o.bookid
and c.custid= o.custid
order by name;


--(12) 도서의가격(Book 테이블)과판매가격(Orders 테이블)의차이가가장많은주문

--(13) 도서의판매액평균보다자신의구매액평균이더높은고객의이름

--(1)박지성이 구매한 도서의 출판사와 같은 출판사에서 도서를 구매한 고객의 이름
--(2) 두 개 이상의 서로 다른 출판사에서 도서를 구매한 고객의 이름


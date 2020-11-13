--[실습] join & sub query

--1 마당서점의고객이요구하는다음질문에대해SQL 문을작성하시오.
--(5) 박지성이구매한도서의출판사수

select * from orders o, customer c ; --박지성 custid = 1
select count(DISTINCT publisher) * from book;

select count(DISTINCT publisher) ,
(select * from customer cs, orders od where cs.custid = od.custid))                                                  

;


select * from orders ,book,customer ;

--(6) 박지성이구매한도서의이름, 가격, 정가와판매가격의차이
select * from customer ; -- custid =1
select saleprice,bookname,price from orders,book where custid =1; --박지성 주문 내역
select * from orders,book where custid =1 and (book.price - orders.saleprice);
select  bookname from book, orders ;


--(7) 박지성이구매하지않은도서의이름
select * from orders ; 

select  * from orders o  where o.custid = 1 ; --박지성 주문 내역
select bookname from book where bookid>3 ;

--(8) 주문하지않은고객의이름(부속질의사용)
select name 
from customer 
where (select orderid from orders where orderid = null);

select * from orders  where orderid = null;


--(9) 주문금액의총액과주문의평균금액
select SUM(saleprice)"Total",avg(saleprice) from orders;



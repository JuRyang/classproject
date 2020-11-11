--2020.11.11

--JOIN

--CROSS JOIN: 조건 없이 테이블과 테이블을 붙여준다.
select  *
from emp, dept
;

-- ANSI JOIN : CROSS JOIN  **연습하기, 
select * 
from emp cross join dept
;

--Equi JOIN emp, dept 테이블을 붙이는데 조건을 해줘야 한다(DEPNO를 같다는 조건)
select *
from emp, dept
where emp.deptno = dept.deptno
;

--SCOTT의 사원번호와 이름(EMP), 부서이름, 지역(DEPT)을 출력하세요
select empno, ename, dname, loc
from emp, dept
WHERE emp.deptno = dept.deptno and ename='SCOTT'
;

--select empno, ename, deptno, dname, loc 오류
-- deptno는 emp, dept 중복이기 때문 어느 deptno인지 구분해서 사용
select empno, ename, emp.deptno, dname, loc 
from emp, dept
WHERE emp.deptno = dept.deptno and ename='SCOTT'
;


select emp.empno, emp.ename, emp.deptno, dept.dname,dept.loc 
from emp , dept 
WHERE emp.deptno = dept.deptno and ename='SCOTT'
;

--테이블에 별칭 사용
select e.empno, e.ename, e.deptno, d.dname, d.loc 
from emp e, dept d
WHERE e.deptno = d.deptno and e.ename='SCOTT'
;

--ANSI -> T1 INNER JOIN T2 ON 조인의 조건

select * 
from emp inner join dept  -- inner join on 과 같이 쓰임
on emp.deptno = dept.deptno
;

select * 
from emp join dept  -- inner생략 가능 
--on emp.deptno = dept.deptno
USING(deptno)  --공통 컬럼은 하나만 가지게 해준다. 공통걸럼을 구별 할 필요가 없다.
;

--NATURAL JOIN:동일 컬럼 조인의 조건을 생략, 같은 이름의 컬럼은 하나씩
select ename, deptno, dname
from emp NATURAL JOIN dept  -- using과 같음
;








-- Non Equi Join : 동등 비교가 아닌 비교연산이 가능
--급여 등급을 5개로 나누어 놓은 salgrade에서 정보를 얻어 와서
--각 사원의 급여 등급을 지정
--사원(emp) 테이블과 급여 등급(salgrade) 테이블을 조인  
--다음은 사원의 급여가 몇 등급인지 살펴보는 예제입니다.

--1. CROSS JOIN -> 조건
select *
from emp e, salgrade s --별칭 부여
where e.sal BETWEEN s.losal AND s.hisal
;

select * from salgrade;






--Self Join : 자신의 테이블을 조인
-- SMITH의 매니저 이름이 무엇인지

select ename, mgr
from emp
where ename='SMITH'
;

select ename from emp where empno =7902;
--이 방식으로 하면 코드 두가지 번거로움

-- 방법2  Self Join 
select e.ename, e.mgr, m.ename
from emp e, emp m
where e. mgr = m.empno
and e.ename='SMITH'
;

--OUTER JOIN: 정보가 부족한 컬럼을 뒤에 출력하는 
select e.ename, e.mgr, m.ename
from emp e, emp m
where e. mgr = m.empno(+)  --empno(+) 오라클에서만 사용 (null값 나오는 )
;

-- ANSI outer JOIN
--[LEFT | RIGHT | FULL] OUTER JOIN T2

--위치에 따라 출력 테이블이 달라짐
select *
from emp m right outer join emp e
on e.mgr = m.empno
;

select *
from emp e left outer join emp m
on e.mgr = m.empno
;

--회원, 구매 
--customer, orders
select * from customer;
select * from orders order by custid;

select * 
from customer c, orders o
where c.custid =  o.custid (+)
;

--회원별 구매 횟수
select c.name, count(o.orderid),sum(o.saleprice) , avg(o.saleprice)
from customer c, orders o
where c.custid =  o.custid (+)
group by c. name
;


--============================================================

--서브커리
--스칼라 부속질의 – SELECT 부속질의   단일 행 단일 열
--인라인 뷰      – FROM 부속질의     복합 행 복합 열
--중첩질의       – WHERE 부속질의    단일 열, 단순비교 -> 단일 행, 집합비교-> 복합 행

--중첩질의: 단순 비교

--평균 급여(서브 쿼리)보다 더 많은 급여를 받는 사원을 검색
select avg(sal) from emp;
--2073.214285714285714285714285714285714286

select *
from emp
where sal >2073.214285714285714285714285714285714286 --평균 급여
;

select *
from emp
where sal >(select avg(sal) from emp) --평균 급여
;

--scott 사원의 같은 부서에 근무하는 사원의 리스트를 출력
select deptno from emp where ename = 'SCOTT';

select ename, deptno
from emp 
where deptno=(select deptno from emp where ename = 'SCOTT'); -- SCOTT이 소속된 부서 번호

--sal 3000이상 받는 사원이 소속된 부서
select distinct deptno from emp where sal >=3000;

select *
from emp
--where deptno = 10 or deptno = 20  두개라 이렇게 사용하지만 부서명이 더 많을땐 아래 방법으로
where deptno in (select distinct deptno from emp where sal >=3000)
;


-- 30번 소속 사원들 중에서 급여를 가장 많이 받는 사원보다 
--더 많은 급여를 받는 
--사람의 이름, 급여를 출력

select max(sal) from emp where deptno = 30;
select sal from emp where deptno=30;

select ename, sal
from emp
--where sal > 2850
--where sal > (select max(sal) from emp where deptno = 30)
--where sal > all(select sal from emp where deptno=30) --and
where sal > any(select sal from emp where deptno=30) --or
;



--ROWNUM
select rownum, empno,ename,hiredate --오라클 내 처리해주는 가상rownum
from emp
where rownum < 4
order by hiredate
;
desc emp;


select rownum, empno, ename, hiredate from emp order by hiredate;

select rownum, empno, ename, hiredate
from (select rownum, empno, ename, hiredate from emp order by hiredate desc)--인라인 뷰
where rownum < 4
;

--가장 급여를 많이 받는 사원 3명을 출력하자

select rownum, ename, sal  from emp order by sal desc;

select rownum, ename, sal
from (select rownum, ename, sal  from emp order by sal desc)
where rownum < 4
;

--mysql --> top    select * from emp limit 0,3

select name from customer where custid = 1;

--스칼라 부속질의: select절 프리젠테이션 영역에 쓸 수 있는 부속질의, 단일행, 단일열, 단일값의 결과만 나와야한다.

select custid,(select name from customer where customer.custid = orders.custid),
        saleprice, orderdate
from orders
;

--마당서점의 고객별 group by
--판매액을 보이시오 orders
--(결과는 고객이름과 고객별 판매액을 출력).

select c.custid, c.name, sum(o.saleprice)
from customer c, orders o
where c.custid = o.custid(+)
group by c.custid, c.name
order by sum(o.saleprice)
;

select o.custid,(
           select name from customer c where o.custid=c.custid
            ),       
           sum(o.saleprice)
from orders 
group by o.custid
;

select custid, name
from customer
where custid <= 2
;


-- 인라인 뷰: from절 이후에 들어가는 서브 쿼리, 가상 테이블,rownum이 새롭게 생성
select c.name, sum(o.saleprice), avg(o.saleprice)
from orders o,(
     select custid, name
     from customer
     where custid <= 2
     ) c
     where o.custid = c.custid
     group by c.name
;

--평균 주문금액 이하(조건)의 
--주문에 대해서 주문번호(orderid)와 금액(saleprice)을 보이시오. 
select avg(saleprice) from orders;

select orderid, saleprice
from orders
--where saleprice <= 11800  -- 평균 주문 금액
where saleprice <= (select avg(saleprice) from orders)
;

--각 고객의 평균 주문금액보다 큰 금액의 주문 내역에 대해서 
--주문번호, 고객번호, 금액을 보이시오
select avg(saleprice) from orders where custid =1;


select orderid,custid, saleprice
from orders o1
where saleprice > 
(select avg(saleprice) from orders o2 where o2.custid =o1.custid) -- custid =1이면 고객의 평균과 비교해서 큰 주문금액만 출력
;

select * from customer where address like '%대한민국%';

-- 대한민국에 거주하는 고객에게 판매한 도서의 총판매액을 구하시오. 
select sum(saleprice)
from orders
where custid in (select custid from customer where address like '%대한민국%')
;


--3번 고객이 주문한 도서의 최고 금액보다 
--더 비싼 도서를 구입한 
--주문의 주문번호와 금액을 보이시오.
select max(saleprice) from orders where custid=3;

select orderid, saleprice
from orders
--where saleprice >(select max(saleprice) from orders where custid=3)
where saleprice > all(select saleprice from orders where custid = 3)
;

--EXISTS 연산자로 대한민국에 거주하는 고객에게 판매한 도서의 총 판매액을 구하시오.
select * from customer where address Like '%대한민국%';

select sum(saleprice)
from orders o
where EXISTS (select * from customer c where address Like '%대한민국%' and o.custid = c. custid )
;






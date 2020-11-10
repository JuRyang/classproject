
--1 마당서점의고객이요구하는다음질문에대해SQL 문을작성하시오.
--(1) 도서번호가1인도서의이름
select bookname
from BOOK
where bookid = 1
;
--(2) 가격이20,000원이상인도서의이름
select bookname,price
from Book
where price>=20000
;
--(3) 박지성의총구매액(박지성의고객번호는1번으로놓고작성)
select sum(saleprice) 
from Orders
where custid = 1
;

--(4) 박지성이구매한도서의수(박지성의고객번호는1번으로놓고작성)

select count(saleprice) 
from Orders
where custid = 1
;


--2 마당서점의운영자와경영자가요구하는다음질문에대해SQL 문을작성하시오.
--(1) 마당서점도서의총개수
select  bookname TO_CHAR(bookname, '') 
from Book
;

--(2) 마당서점에도서를출고하는출판사의총개수
select bookname
from Book
;


--(3) 모든고객의이름, 주소
select name, address
from Customer
;

--(4) 2014년7월4일~7월7일사이에주문받은도서의주문번호
--select orderid 
--from Orders
--where orderdate = '2014.07.04'
 --'2014.07.05','2014.07.06','2014.07.07'
;

--(5) 2014년7월4일~7월7일사이에주문받은도서를제외한도서의주문번호



--(6) 성이‘김’씨인고객의이름과주소
select name, address
from Customer
where name like'김%'
;

--(7) 성이‘김’씨이고이름이‘아’로끝나는고객의이름과주소
select name,address
from Customer
where name Like '김%아'
;

-- 16. SUBSTR 함수를 사용하여 사원들의 입사한 년도와 입사한 달만 출력하시오.
select SUBSTR( ''
from emp
;

select SUBSTR('ABCDEFG',3,4) from DUAL; -- 3자리부터 4개자리만 출력 CDEF
select SUBSTR('000903-2512355',1,8) from DUAL;
select rPAD(SUBSTR('000903-2512355',1,8),14,'*') from DUAL;

-- 17. SUBSTR 함수를 사용하여 4월에 입사한 사원을 출력하시오.
select TO_CHAR(hiredate,'YYYY/MM/DD')
from emp
where 
;




-- 18. MOD 함수를 사용하여 사원번호가 짝수인 사람만 출력하시오.

-- 19. 입사일을 년도는 2자리(YY), 월은 숫자(MM)로 표시하고 요일은 약어 (DY)로 지정하여 출력하시오.
select TO_CHAR(hiredate,'YY/MM  DY')
from emp
;

-- 20. 올해 몇 칠이 지났는지 출력하시오. 현재날짜에서 올해 1월 1일을 뺀 결과를 출력하고
-- TO_DATE 함수를 사용하여 데이터 형을 일치 시키시오.
SELECT TRUNC(SYSDATE-TO_DATE('2020/01/01', 'YYYY/MM/DD')) 
FROM DUAL; 

-- 21. 사원들의 상관 사번을 출력하되 상관이 없는 사원에 대해서는 NULL 값 대신 0으로 출력하시오.
select EMPNO


-- 22. DECODE 함수로 직급에 따라 급여를 인상하도록 하시오.
--직급이 ‘ANALIST”인 사원은 200, ‘SALESMAN’인 사원은 180,
--‘MANAGER’인 사원은 150, ‘CLERK”인 사원은 100을 인상하시오.​

select ename, sal,job,
decode(job, 
      'ANALYST',sal +200,
      'SALESMAN',sal +180,
      'MANAGER',sal + 150,
      'CLERK',sal +100
      )as upsal
      from emp
      order by sal
      ;
      

-- 23. 모든 사원의 급여 최고액, 최저액, 총액 및 평균 급여를 출력하시오.
-- 평균에 대해서는 정수로 반올림하시오.
select 
       MAX(sal) as "가장 많이 받는 급여액",
       min(sal) as "가장 작은 급여액",
       round(avg(sal))
       
from emp
;



-- 24. 각 담당 업무 유형별로 급여 최고액, 최저액, 총액 및 평균 액을 출력하시오.
-- 평균에 대해서는 정수로 반올림 하시오.
select deptno,
       MAX(sal),
       min(sal),
       sum(sal),
       round(avg(sal))
   from emp    
       group by deptno
       order by deptno
;


-- 25. COUNT(*) 함수를 이용하여 담당업무가 동일한 사원 수를 출력하시오.​

select COUNT(job)
   from emp       
;


-- 26. 관리자 수를 출력하시오.
select  count(*)
from emp
where job = 'MANAGER'
;

-- 27. 급여 최고액, 급여 최저액의 차액을 출력하시오.​
select 
       MAX(sal) as "가장 많이 받는 급여액",
       min(sal) as "가장 작은 급여액",
       MAX(sal) -min(sal) as "차액"
       
from emp

-- 28. 직급별 사원의 최저 급여를 출력하시오.
-- 관리자를 알 수 없는 사원과 최저 급여가 2000 미만인 그룹은 제외시키고
-- 결과를 급여에 대한 내림차순으로 정렬하여 출력하시오.





-- 29. 각 부서에 대해 부서번호, 사원 수, 부서 내의 모든 사원의 평균 급여를 출력하시오.
-- 평균 급여는 소수점 둘째 자리로 반올림 하시오.



-- 30. 각 부서에 대해 부서번호 이름, 지역 명, 사원 수, 부서내의 모든 사원의 평균 급여를 출력하시오.
-- 평균 급여는 정수로 반올림 하시오. DECODE 사용.​
select deptno
decode( deptno,
    10,'ACCOUNTING', --deptno =10 이면 부서이름을 출력
    20,'RESEARCH', --deptno =20 이면 부서이름을 출력
    30,'SALES', --deptno =300 이면 부서이름을 출력
    40,'OPERATIONS' --deptno =40 이면 부서이름을 출력
        )AS dname
        from emp 
        order by deptno
;


-- 31. 업무를 표시한 다음 해당 업무에 대해 부서 번호별 급여 및 부서 10, 20, 30의 급여 총액을 각각 출력하시오.
-- 별칭은 각 job, dno, 부서 10, 부서 20, 부서 30, 총액으로 지정하시오.







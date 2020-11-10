--2020.11.10
--함수

--단일행, 집합함수

--단일 행 함수

--단일행 함수: 숫자, 문자, 날짜, 변환

--운영에 관련된, 데이터 저장을 하기위해  dual을 쓰는건 아님
desc dual;
--숫자함수
select ABS(-15.5) from dual;
select FLOOR(15.7) from dual;  --값은 15 뒤에 값 삭제
select ROUND(15.693) from dual;  -- 반올림 값 16
select ROUND(15.693,1) from dual;  -- 소수점 1자리까지 출력하고 반올림
select log(10,100) from dual; --지수 구하는 함수
select POWER(2,8) from dual;  -- 2의 8승 

--문자함수
select concat('나는',' 손흥민 입니다.') from dual;
select concat('저의 이름은',ename) from emp where job = 'MANAGER';
select LOWER('MR. SCOTT MCMILLAN') "Lowercase" FROM DUAL;
select lower (ename) from emp;
select LPAD('Page 1',15,'*') from DUAL; --15자리 중 왼쪽으로 *이 채워진다
select rPAD('000903-2',15,'*') from DUAL; --15자리 중 뒤에 오른쪽으로 *이 채워진다
select SUBSTR('ABCDEFG',3,4) from DUAL; -- 3자리부터 4개자리만 출력 CDEF
select SUBSTR('000903-2512355',1,8) from DUAL;
select rPAD(SUBSTR('000903-2512355',1,8),14,'*') from DUAL;

select Ltrim('         =from=',' ') from dual;  --공백삭제(왼쪽 삭제
select Rtrim('=from==','=') from dual;  --오른쪽에 있는 = 삭제
select trim ('=' from '=====from====') as "from" from dual;
select trim (' ' from '     =====from====     ') as "from" from dual; --공백이 사라짐

select REPLACE('JACK and JUE','J','BL') from dual; -- j를 찾아서 BL로 바꿔라
select REPLACE('010202-1234569','-','') from dual; 
--자바에서 표현하는 것보다 DB로 표현할때 더 간편하다 
--자바는 사용할 때마다 인스턴스를 선언 해야하기 때문에

--날짜 함수
select sysdate from dual;
select sysdate+14 from dual; --현재 날짜에 +14일 더한 값 
select sysdate+21 from dual;
select sysdate-3 from dual;

select add_months(sysdate,4)from dual; --현재 날짜에 4개월 더하기
select add_months(sysdate,-4)from dual;
select last_day (sysdate) from dual; --달에 마지막 날짜 출력

--변환 함수
--TO_CHAR: 날짜 -> 문자, 숫자 -> 문자

--날짜 -> 문자
select sysdate, to_char(sysdate,'YYYY.MM.DD day dy AM PM HH HH24 mi ss') from dual; -- dy는 짧게 화 ,월 이렇게 출력
-- 현재 오전이기 때문에 pm을 써도 오전으로 출력 HH24로 입력해도 현시간으로 출력 
--2020.11.10. 12:00
select to_char(sysdate,'YYYY.MM.dd. hh24:mi:ss')from dual;

--숫자 -> 문자
select to_char(10000.123,'L000,000.00') from dual;  --100.000.12 출력 L은 원화로 바꿔줌
select to_char(10000,'L999,999.99') from dual; -- 위에 차이

select sal, to_char(sal*1100,'L00,000,0000') from emp;
select sal, to_char(sal*1100,'L99,999,999') from emp;
select ename,job, sal, to_char(sal*1100*12+nvl(comm,0)+1100,'L99,999,999') from emp order by sal desc;
--nvl(comm,0) comm에 null값이 있기 때문에


--문자 -> 날짜
--2020.11.01. 12:00
select TO_DATE('2009/09/05', 'YYYY/MM/DD') from dual;
select TO_DATE('2020.11.01.', 'YYYY.MM.DD.') from dual;

--오늘이 2020년 1월 1일에서 며칠 지났는지 확인
select trunc(sysdate - to_date('20-01-01','YY-MM-DD')) from dual; --trunc를 이용해 반올림
--며칠 살았는지
select trunc(sysdate - to_date('1994-09-03','YYYY-MM-DD')) from dual;

--문자 -> 숫자
select TO_NUMBER('100.00', '999.99') from dual;
select TO_NUMBER('100.00', '999.99') * TO_NUMBER('10.00', '999.99') from dual; --사칙연산 가능

--decode 함수: switch문과 비슷하다.
--사원이름, 부서번호, 부서이름 출력
select ename, deptno,
decode( deptno,
    10,'ACCOUNTING', --deptno =10 이면 부서이름을 출력
    20,'RESEARCH', --deptno =20 이면 부서이름을 출력
    30,'SALES', --deptno =300 이면 부서이름을 출력
    40,'OPERATIONS' --deptno =40 이면 부서이름을 출력
        )AS dname

from emp order by deptno
;

--. 직급에 따라 급여를 인상하도록 하자. 
-- 직급이 'ANAlYST'인 사원은 5%, 
    --   'SALESMAN'인 사원은 10%, 
       --'MANAGER'인 사원은 15%, 'CLERK'인 사원은 20%인 인상한다. 
       select ename, sal,job,
       decode(job, 
       'ANALYST',sal * 1.05,
       'SALESMAN',sal * 1.1,
       'MANAGER',sal * 1.15,
       'CLERK',sal * 1.20
       ) as upsal
       from emp
       order by sal
       ;
select distinct job from emp;       
--select ename, deptno,

select ename as name, deptno as dno,
    case 
       when deptno=10 then 'ACCOUNTING'
       when deptno=20 then 'RESEARCH'
       when deptno=30 then 'SALES'
       when deptno=40 then 'PERATION'
    end as dname
from emp
order by dname
;


--그룹합수: 하나의 행의 컬럼을 대상이 아닌 행의 그룹의 컬럼들을 묶어 그룹화 하고 연산하는 함수
--그룹함수: SUM,AVG,COUNT,MAX,MIN

select 
       to_char(sum(sal)*1100,'L999,999,999') as "월 급여 총액", 
       round(avg(sal))*1100 as "월 급여 평균",
       count(sal) as "급여를 받는 사원의 수",
       count(comm) as "커미션을 받는 사원 수",
       MAX(sal) as "가장 많이 받는 급여액",
       min(sal) as "가장 작은 급여액"
from emp
;

select
    sum(comm),
    avg(nvl(comm,0)), --avg(comm)
    count(nvl(comm,0)),
    max(comm),
    min(comm)
from emp
;

--전체 행을 구한다.
select 
          count(*)as "MANAGER의 수",
          avg(sal) as "매니저의 평균 급여",
          max(sal),
          min(sal)
from emp
where job = 'MANAGER'
;


--직무의 개수 
select count(distinct job)
--select distinct job
from emp
order by job
;


--특정 컬럼을 기준으로 그룹핑 : group by 컬럼


select deptno,ename
from emp
group by deptno, ename
;

select deptno,comm
from emp
group by deptno, comm
;

select deptno from emp order by deptno; 
 
select * from emp order by deptno; 

select deptno
from emp
group by deptno
;

--각 부서의 소속 인월을 구하자
select deptno,count(*) as "cnt"
from emp 
group by deptno
--order by count(*) desc
order by deptno
; 


-- 각 부서별 총 급여액 출력
--group by deptno : 부서별로 그룹핑
select deptno, sum(sal)
from emp
group by deptno
order by deptno
;

--부서별 급여 평균
select deptno,round(avg(sal),2)
from emp
group by deptno
order by deptno
;

--부서별 급여 최고 금액과 최소 금액을 출력
select deptno, max (sal), min (sal), max(sal)-min(sal)
from emp
group by deptno
order by deptno
;

--부서별로 그룹지은 후(GROUP BY), 
--그룹 지어진 부서별 평균 급여가 2000 이상인(HAVING) 
--부서번호와 부서별 평균 급여를 출력

select deptno,avg(sal)
from emp
group by deptno
having avg(sal)>=2000
-- having not(avg(sal)>=2000) <->  sal)>=2000  반대
order by deptno
;

--부서별 급여의  최대값과 최소값을 구하되 
--최대 급여가 2900이상인 부서만 출력합니다. 
select deptno, max(sal),min(sal)
FROM emp
group by deptno
having max(sal)>=2900
order by deptno
;

--직무별 지표: 사원의 수, 급여의 총합 , 평균 급여, 최대 급여, 최소 급여 

select job,
        count(*) || '명'as "사원의 수",
        to_char( sum(sal)*1100,'L999,999,999') as "급여의 총합",
        to_char(  avg(sal)*1100,'L999,999,999')as "급여평균", 
        to_char(max(sal),'L999,999,999') as "최대 급여",
        to_char( min(sal),'L999,999,999')as "최소 급여"

from emp
where job !='PRESIDENT' --그룹하기 위한 행을 선택하는 기준
group by job
order by job
;


select * from tab;
desc book;
select * from book;

desc customer;
select * from customer;

desc orders;









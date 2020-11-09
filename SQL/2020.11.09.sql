--2020.11.09
--Select 기본

--scott 계정으로 로그인
--scott 계정이 소유한 테이블 객체를 확인:Tab - > 사용자가 가지는 테이블의 정보를 저장하는 데이터 딕셔너리
select * from tab;

--테이블의 구조 확인: DESC
--테이블의 데이터를 검색하기 전 구조를 확인할 때
DESC emp; 
desc dept;

--데이터의 조회 명령: Select
--SELECT 컬럼명, ...FROM 테이블 이름(조회의 대상) -->기본 문법
--SELECT의 결과는 -> TABLE이다!!

SELECT             --조회하는 명령어
    *              --컬럼 이름들을 기술해준다. 기술하는 순서에 따라 결과도 순서에 맞게 출력
FROM emp           --조회하고자하는 테이블 이름을 기술
;                  --Sql의 종료

-- from          컬럼표현
--부서 테이블의 모든 데이터를 조회하자
select *
from dept
;

desc dept
--부서테이블에서 -> FROM
--부서의 이름과 위치를 출력 -> SELECT
select dname,loc
from dept
;

--저장되어있는 컬럼을 참조를 하지만, select로 다양한 형태로 출력할 수 있다.
select loc,deptno,dname,dname
from dept
;

--모든 사원의 정보를 출력하자
SELECT
    *
FROM emp
;

--사원의 이름, 사번, 직급(직무)를 포함하는 리스트 출력
SELECT ename,empno,job --출력할 컬럼
from emp  --대상
;

--select절의 컬럼의 사직연산 가능
--임시테이블 dual:컬럼은 x를 가지는 테이블
select 100+200,200-100,100*10,100/10
from dual;

select ename,sal,sal*12
from emp
;

select * from emp;

- 연봉의 계산을 sal*12+comm으로 계산하자

select ename, sal, sal*12, comm, sal*12+comm

from emp

;



-- null : 값은 존재하는데 정해지지 않은 값

-- 연산이 불가 : 사칙연산, 비교연산



-- nvl 함수 : null 값을 치환 해주는 함수

-- nvl(컬럼, 대체값) : 컬럼의 값이 null 일 때 대체값으로 치환, 이 때 대체값은 컬럼의 타입에 맞는 데이터 이어야 한다.

-- 연봉의 계산을 sal*12+comm으로 계산하자

select ename, sal, sal*12 sal12, nvl(comm,0) as comm, sal*12+nvl(comm, 0) as "12개월 연봉"

from emp

;



-- 데이터베이스의 sql 내부의 문자열 처리는 작은 따움표 ''

-- 문자열의 조합

select ename || '의 직무는 ' || job ||'입니다.'

from emp;



-- Distinct : 데이터의 중복값을 제거 하고 출력

select deptno

from emp;



select DISTINCT deptno

from emp;






--특정 데이터를 추출하는 where절
--select 컬럼명...from 테이블 이름 where 조건식

--급여가 3000이상인 사원의 리스트를 출력하자
select ename, job, sal
from emp
where sal >=3000
;

select ename--, job, sal
from emp
where sal >4000
;

--10번 부서에 소속된 사원들의 리스트를 출력
select *
from emp
where deptno=10
;

--사원이름이 FORD인 사원의 정보를 출력
select *
from emp
where ename='FORD' 
;

--81/11/17 입사한 사원의 정보를 출력
select *
from emp
where hiredate='81/11/17' --날짜 비교에서도 날짜도 작은 따움표로 묶어서 사용
;

-- 10번 부서 소속인 사원들 중에서(and) 
--직급이 MANAGER인 사람을 검색하여 
--사원명, 부서번호, 직급을 출력하려고 한다면 
--두 가지 조건을 제시해야 합니다.  
--행을 찾는 조건
--   [조건1] 10번 부서 소속인 사원 : DEPTNO=10    
--   [조건2] 직급이 MANAGER인 사원 : JOB='MANAGER' 

select ename, deptno, job
from emp
where deptno=10 and job='MANAGER' 
;

-- 10번 부서에 소속된 사원이거나 직급이 MANAGER인 사람을 검색하여 사원명, 부서번호, 직급을 출력합시다.  
--[조건1] 10번 부서 소속인 사원 : DEPTNO=10    
--[조건2] 직급이 MANAGER인 사원 : JOB='MANAGER' 

select ename, deptno, job
from EMP
WHERE deptno = 10 or job = 'MANAGER'  --조건으로 행을 먼저 찾자
;


-- 부서번호가 10번이 아닌 사원의 
-- 사원이름, 부서번호, 직급을 출력해 봅시다.  
select *
from emp
--where not deptno = 10 
--where deptno ! =10
where deptno<>10
;
 

--다음은 2000에서 3000 사이의 급여를 받는 사원을 조회
select ename, sal
from emp
--where sal >=2000 and sal<= 3000
where sal between 2000 and 3000 -- a이상 b이하의 범위
;

--1987년에 입사한 사원을 출력해 봅시다. 
--1987/0101 ~ 197/12/31
select * 
from emp
--where hiredate between '1987/01/01'and'1987/12/31'
where hiredate >= '87/01/01' and hiredate<= '87/12/31'
;

--이번에는 커미션이 300 이거나 500 이거나 1400 인 사원을 검색하기
select *
from emp
--where comm =300 or comm =500 or comm = 1400 or comm = 1000  --or 계속 쓸 쑤 있지만 복잡
where comm in(300,500,1400,1000,3000)
;

--찾으려는 이름이 F로 시작 하는 것은 알지만 그 뒤의 문자는 모를 경우 
select *
from emp
--where ename like 'F%' --F로 시작하고 뒤에는 어떤 문자가 와도 상관없다.
--where ename like '%S'  --S로 끝나는 이름 출력
--where ename like'%A%' --이름에 A문자를 포함하는 이름을 검색 ****기억하기
--where ename like'_A%'--첫 번째 문자는 어떤 문자든 상관없고 두번째 문자는 반드시 A문자를 포함하는
--where ename like'__R%' -- 첫 번째, 두 번째 문자에는 어떤 문자이든 상관없고, 세번째에는 R문자를 포함하는 이름을 검색
-- 990808-1000000 -> '_______1%' 앞에 무슨 숫자든 - 뒤에 1인 정보 출력
--'1987/12/19' -> "_____12%" 앞에 무슨 숫자든 12월만 출력 941103 ->'__11__'

where ename not like '%A%'
;
--커미션을 받지 않는 사원을  검색
SELECT *
FROM emp
--where comm =null 오류
--where comm is null
where comm is not null or comm =0
;

--커미션을 받는 사원을 검색
select *
from emp
where comm is not null and comm >0
;

--사원의 리스트를 
--급여의 오름차순으로 정렬해보자
select *
from emp
--order by sal asc --오름차순
--order by sal desc -- 내림차순
--order by sal  --생략인 경우 오름차순 default
--order by ename desc
--order by comm --null값은 마지막에
--order by comm desc -- 내림차순은 null 맨앞으로
--order by hiredate -- 날짜의 작다 표현은 오래된 날짜 : 오름차순은 오래된 날짜부터 최근날짜로 정렬
order by hiredate desc, sal asc
;





--select hiredate from emp;

--32. EQUI 조인을 사용하여 SCOTT 사원의 부서번호와 부서 이름을 출력하시오.
select * from emp;

​select dname
from emp, dept
where emp.deptno = dept.deptno
and ename = 'SCOTT';
​

​

--33. INNER JOIN과 ON 연산자를 사용하여 
--사원 이름과 함께 그 사원이 소속된 부서이름과 지역 명을 출력하시오.


select ename, dname, loc
from emp INNER JOIN dept
ON emp.deptno = dept.deptno
;
​
​

--36. 조인과 WildCARD를 사용하여 
--이름에 ‘A’가 포함된 모든 사원의 이름과 부서명을 출력하시오.
select * from emp where ename like '%A%';

select ename, dname
from emp INNER JOIN dept
ON emp.deptno = dept.deptno
where ename like '%A%';
;




--37. JOIN을 이용하여 NEW YORK에 근무하는 
--모든 사원의 이름, 업무, 부서번호 및 부서명을 출력하시오.

select * from dept where deptno = '10';

select e.ename,e.job, d.deptno, d.dname,d.loc
from emp e ,dept d
where  e.deptno = d.deptno
and d.deptno = '10'
;


--38. SELF JOIN을 사용하여 
--사원의 이름 및 사원번호, 관리자 이름을 출력하시오.

select e.ename, e.empno, e.mgr
from emp e, emp m
where e. mgr = m.empno
;

​


--39. OUTER JOIN, 
--SELF JOIN을 사용하여 
--관리자가 없는 사원을 포함하여 
--사원번호를 기준으로 내림차순 정렬하여 출력하시오.

select *
from emp e , emp m
where e.mgr = m.mgr(+) order by e.empno desc
;


--40. SELF JOIN을 사용하여 
--지정한 사원의 이름, 부서번호, 지정한 사원과 
--동일한 부서에서 근무하는 사원을 출력하시오. ( SCOTT )
select * from emp e, dept d  where e.ename like 'SCOTT';  --ANALYST

select e.ename, d.deptno, e.job
from emp e, dept d  
where job = 'ANALYST'
;


--41. SELF JOIN을 사용하여 
--    WARD 사원보다 늦게 입사한 사원의 이름과 입사일을 출력하시오.
select * from emp where ename = 'WARD'; --81/02/22
select * from emp;

select e.ename, e.hiredate
from emp e
where hiredate > any(select hiredate from emp where ename='WARD')
;

​
--42. SELF JOIN 을 사용하여 
--    관리자보다 먼저 입사한 모든 사원의 이름 및 입사일 
--    관리자의 이름 및 입사일과 함께 출력하시오.

select * from emp;
select mgr from emp ;





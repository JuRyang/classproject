--43. 사원 번호가 7788인 사원과 담당 업무가 같은 사원을 표시(사원 이름과 담당업무)하시오.
select * from emp where empno like '7788';

select ename,(select job from emp where empno like '7788')
from emp
;


--44. 사원번호가 7499인 사원보다 
--급여가 많은 사원을 표시하시오. 
--사원이름과 감당 업무
select sal from emp where empno = '7499';

select ename, job
from emp
where sal >(select sal from emp where empno = '7499') 
;


--45. 최소급여를 받는 사원의 이름, 
--   담당업무 및 급여를 표시하시오. (그룹함수 사용)

select * from emp;
select rownum, ename,job, sal  from emp order by sal asc;


select ename, job, sal
from emp
where sal = (select min(sal) from emp);

​
--46. 평균급여가 가장 적은 직급의 직급 이름과 직급의 평균을 구하시오. 다시풀기

select min(avg(sal)) from emp group by job; --평균 급여


select job, avg(sal)
from emp 
group by job
having avg(sal) = (select min(avg(sal)) from emp group by job)
;



​


--47. 각 부서의 최소 급여를 받는 사원의 이름, 급여, 부서번호를 표시하시오. 다시풀기

select *
from emp 
;

select min(sal) from emp group by deptno
;


select ename, sal,deptno
from emp
where sal IN(select min(sal) from emp group by deptno);



--48. 담당업무가 ANALYST 인 사원보다 급여가 적으면서 
--업무가 ANALYST가 아닌 사원들을 표시(사원번호, 이름, 담당 업무, 급여)하시오.

select *
from emp
where sal>(select avg(sal) from emp) --평균 급여
;


--49. 부하직원이 없는 사원의 이름을 표시하시오.
select * from emp,dept  ;

select ename 
from emp 
where empno  NOT IN ( select mgr from emp
            where mgr is not  null);



--50. 부하직원이 있는 사원의 이름을 표시하시오.
select* from emp ;

select ename 
from emp 
where empno in( select mgr from emp
            where mgr is not null);

​


--51. BLAKE와 동일한 부서에 속한 
--사원의 이름과 입사일을 표시하는 질의를 작성하시오. ( 단 BLAKE는 제외 )
select * from dept;
select deptno from emp ,dept;

select d.deptno  
from emp e , dept d 
where e.deptno = d.deptno
and ename='BLAKE'; --30

select e.ename, e.hiredate
from emp e, dept d
where e.deptno = d.deptno
and d.deptno = 30  and e.ename != 'BLAKE';

​


--52. 급여가 평균 급여보다 많은 
--사원들의 사원 번호와 이름을 표시하되 
--결과를 급여에 대해서 오름차순으로 정렬하시오.
select avg(sal) from emp ;

select empno, ename
from emp
where sal>(select avg(sal) from emp)
order by sal asc;


​

​

​

--53. 이름에 K가 포함된 사원과 
--같은 부서에서 일하는 사원의 사원 번호와 이름을 표시하시오. <다시풀기>
select ename from emp,dept;

select distinct(deptno) from emp  where ename like '%K%'; --k 들어간 사람


select empno, ename
from emp
where deptno in (select distinct(deptno) from emp  where ename like '%K%');




--54. 부서위치가 DALLAS인 사원의 이름과 부서번호 및 담당업무를 표시하시오.

select * from dept,emp where loc ='DALLAS';

select e.ename, d.deptno, e.job, d.loc
from emp e , dept d
where e.deptno = d.deptno
and d.loc ='DALLAS' ;
​

​

​

--55. KING에게 보고하는 사원의 이름과 급여를 표시하시오.

select ename, sal
from emp
where job ='MANAGER';
​


--56. RESEARCH 부서의 사원에 대한 부서번호, 사원이름 및 담당 업무를 표시하시오.
select *from dept, emp where dname ='RESEARCH';

select e.empno, e.ename, e.job
from emp e, dept d
where e.deptno = d.deptno
and dname ='RESEARCH';
​



--57. 평균 월급보다 많은 급여를 받고 
--이름에 M이 포함된 사원과 같은 부서에서 근무하는 사원의 
--사원 번호, 이름, 급여를 표시하시오.
select* from emp where ename like '%M%';  --이름에 M이 들어간 사람들


select deptno,ename, sal from emp  where sal > (select avg(sal) from emp );
 
​



--58. 평균급여가 가장 적은 업무를 찾으시오. <다시풀기>

select min(avg(sal)) from emp group by job;



select job,avg(sal)
from emp 
group by job
having avg(sal) = (select min(avg(sal)) from emp group by job)
;



--59. 담당업무가 MANAGER 인 사원이 소속된 부서와 동일한 부서의 사원을 표시하시오.<다시풀기>
select * from emp,dept;
select deptno from emp where job = 'MANAGER';
--where job = 'MANAGER';

select ename 
from emp 
where deptno in (select deptno from emp where job = 'MANAGER');


​

​
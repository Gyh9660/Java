--5일차 문제풀이-------

--7.
-- EQUI join : 오라클에서만 사용하는 구문, 두테이블의 키가 일치하는 것만 출력
-- ANSI : INNER JOIN  으로 변환 가능 (모든 DBMS 에서 공통 구문,MSSQL,My SQL....
select e.ename 사원이름 ,e.eno 사원번호 , m.ename 관리자이름 , m.eno 관리자번호
from employee e , employee m
where e.manager = m.eno;

select * from employee;
select e.ename 사원이름 ,e.eno 사원번호 , m.ename 관리자이름 , m.eno 관리자번호
from employee e inner join employee m
on e.manager = m.eno;

--8
select e.ename 사원이름 ,e.eno 사원번호 , m.ename 관리자이름 , m.eno 관리자번호
from employee e , employee m
where e.manager = m.eno(+)
order by e.eno desc;

select e.ename 사원이름 ,e.eno 사원번호 , m.ename 관리자이름 , m.eno 관리자번호
from employee e left outer join employee m
on e.manager = m.eno;
--9.
select e.ename 이름, e.dno 부서번호, m.ename 동료
from employee e , employee m
where e.dno = m.dno -- <== 두 테이블의 부서 컬럼을 공통키로 사용
and e.ename = 'SCOTT'
and m.ename <> 'SCOTT';


select * from employee where ename = 'SCOTT';
select * from employee where dno = 20;

select ename, dno, ename, dno from employee;

--10.
select * from employee;

select * from employee
where hiredate > '81/02/22';

select * from employee
where hiredate > to_date(19810222, 'YYYYMMDD');

select * from employee
where hiredate > to_date ('1981_02_22', 'YYYY_MM_DD');

select m.ename 이름 ,m.hiredate 입사일
from employee e , employee m
where e.hiredate < m.hiredate 
and e.ename = 'WARD'
order by m.hiredate;

select ename, hiredate , ename ,hiredate from employee;

select e2.ename 이름, e2.hiredate 입사일
from employee e1 , employee e2
where e2.hiredate > e1.hiredate
and e1.ename = 'WARD'
order by e2.hiredate asc;

--11
select eno, ename, manager, hiredate from employee;

select e1.ename 사원이름, e1.hiredate 사원의입사일, e2.ename , e2.hiredate
from employee e1 , employee e2
where e1.manager = e2.eno
and e1.hiredate < e2.hiredate;

select e.ename 사원이름, e.hiredate 입사일, m.ename 관리자이름, m.hiredate 관리자입사일
from employee e , employee m
where e.manager = m.eno
and e.hiredate < m.hiredate;

select eno, ename, manager, hiredate, eno, ename, manager, hiredate
from employee;

--subquery
--1. 
select job, ename from employee where eno =7788;
select ename, job from employee where job = 'ANALYST';

select ename, job from employee 
where job = (select job from employee where eno =7788)
and eno <> '7788';

--2.
select ename 사원이름 , job 업무, salary 월급
from employee
where salary > (select salary from employee where eno=7499);

--3.
--i--
select ename 사원이름, job 업무, salary 급여
from employee
where salary in (select min(salary) from employee group by job );
--t--
select job, count(*), min(salary)
from employee
group by job;

select ename 사원이름, job 담당업무, salary 급여
from employee
where salary in ( select min(salary) from employee group by job);

--4
--t--

select job ,round(avg(salary)) from employee 
group by job;
select * from employee where job ='CLERK';

select ename 이름, job 직급, salary 급여
from employee
where salary = ( select min(salary) from employee
                    group by job
                    having avg(salary)= (select min(avg(salary))
                    from employee group by job)
               );
--t2--
select min (salary) 급여, job 직급
from employee
group by job
having avg (salary) <= all (select avg(salary)from employee
group by job);
               
--i--               
select ename 사원이름, salary 급여 ,job 직급
from employee
where salary = ( select min(salary)from employee group by job
having min(salary) <all(select round(avg(salary)) from employee group by job));

--i2--
select job 직급 , min(salary) 급여
from employee 
group by job
having min(salary)<all(select round(avg(salary)) from employee group by job);

--5.

select ename 사원이름, job 담당업무, salary 급여
from employee
where salary in ( select min(salary)
from employee 
group by job);

--6.
select * from employee where job ='ANALYST';

select eno 사원번호, ename 이름, job 담당업무, salary 급여
from employee
where salary < all(select salary from employee where job ='ANALYST')
and job <> 'ANALYST';

--7.


select eno,ename 사원이름
from employee
where eno not in ( select manager from employee where manager is not null);

--8.
select eno,ename 사원이름
from employee
where eno in ( select manager from employee where manager is not null);


--9.
select * from employee where ename = 'BLAKE';
select ename 성명, hiredate 입사일 , dno
from employee
where dno = (select dno from employee where ename = 'BLAKE')
and ename <> 'BLAKE';

--10
select eno, ename, salary
from employee
where salary > (select round(avg(salary)) from employee)
order by salary;

-11
select eno 사원번호, ename 이름
from employee
where dno in (select dno from employee where ename like '%K%');

select * from employee where ename like '%K%';

--12
select * from department;
--i--
select ename 이름, dno 부서번호, job 담당업무
from employee
where dno = (select dno from department where loc = 'DALLAS');

--t -join--
select ename, e.dno, job, loc
from employee e, department d
where e.dno = d.dno
and loc = 'DALLAS';
--t -sub query--
select ename, e.dno , job ,loc
from employee e , department d
where e.dno =d.dno
and e.dno in (select dno from department where loc ='DALLAS');

--13.
select * from employee;
select ename 이름, salary 급여
from employee
where manager = (select eno from employee where ename = 'KING');

--14.
select * from department;
--i--
select dno 부서번호, ename 사원이름 ,job 업무
from employee
where dno = (select dno from department where dname = 'RESEARCH');

--t join--
select d.dno 부서번호, ename 사원이름, job 담당업무,dname 부서명
from employee e, department d
where e.dno = d.dno
and d.dname = 'RESEARCH';

--t sun query
select e.dno 부서번호, ename 사원이름, job 담당업무 , dname 부서명
from employee e, department d
where e.dno = d.dno
and e.dno in (select dno from department where dname = 'RESEARCH');

--15.
select avg(salary) from employee;

select eno 사원번호, ename 이름, salary 급여
from employee
where salary > (select round(avg(salary)) from employee)
and dno in (select dno from employee where ename like '%M%');

select * from employee where ename like '%M%';
--16
--t--
select job 업무, avg(salary) 평균급여
from employee
group by job
having avg(salary) = (select min(avg(salary)) from employee group by job);

--i--
select job , avg(salary)
from employee
group by job
having avg(salary) <= all (select avg(salary) from employee group by job);

--17
select ename 사원이름
from employee
where dno in (select dno from employee where job = 'MANAGER')
--and job <> 'MANAGER'
;

select * from employee where job = 'MANAGER';

----------------6일차 ----------------

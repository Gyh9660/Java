--1.
select * from employee;

select max(salary)최고액, min(salary)최저액, sum(salary)총액 , round(avg(salary))평균
from employee;  

--2.
select job 업무,count(*), max(salary) 최고액, min(salary)최저액, sum(salary)총액, round(avg(salary))평균
from employee
group by job;

--rollup , cube : group by 절에서 사용하는 특수한 키워드\
select job 업무,count(*), max(salary) 최고액, min(salary)최저액, sum(salary)총액, round(avg(salary))평균
from employee
group by rollup(job);

select job 업무,count(*), max(salary) 최고액, min(salary)최저액, sum(salary)총액, round(avg(salary))평균
from employee
group by cube(job)
order by job;

-- 두개 이상의 컬럼을 그룹핑
select dno, job 업무,count(*), max(salary) 최고액, min(salary)최저액, sum(salary)총액, round(avg(salary))평균
from employee
group by job,dno -- 두개이상의 컬럽을 그룹핑 : 두컬럼이 모두 만족
order by dno;

select dno, job 업무,count(*), max(salary) 최고액, min(salary)최저액, sum(salary)총액, round(avg(salary))평균
from employee
group by rollup(dno,job)
order by dno;

select dno, job 업무,count(*), max(salary) 최고액, min(salary)최저액, sum(salary)총액, round(avg(salary))평균
from employee
group by cube(dno,job)
order by dno;

--3.
select distinct job
from employee;

select count(distinct job)
from employee;


select job , count(*)
from employee
group by job; --이게맞음

--4.
select count(distinct manager)
from employee; --이게맞음 count는 null을 포함하지 않는다.

select manager , count(*) 관리자수
from employee
group by manager;

--5.
select max(salary) - min(salary) DIFFERENCE
from employee;

--6. where , having 모두 사용.
select job, min(salary)
from employee
where manager is not null
group by job
having min(salary)>2000;
--having not min(salary)<2000;

--7.

select dno, count(*), round(avg(salary),1)
from employee
group by dno;

--8.
select decode(dno,10,'SALES'
                 ,20,'RESERCH'
                 ,30,'ACCOUNTING'
             )"dname",
       decode(dno,10,'CHICAO'
                 ,20,'DALLS'
                 ,30,'NEW YORK'
                 )"Location",
count(*)"Number of People" , round(avg(salary)) "Salary"
from employee
group by dno;

--조인문제 
--1.
select *
from employee;
select *
from department;
select ename, d.dno, dname
from employee e , department d
where e.dno = d.dno
and ename = 'SCOTT';

--제약조건 : 테이블의 컬럼에 할당되어서 데이터의 무결성을 확보
    -- Primary key : 테이블에 한번만 사용할 수 있다. 하나의 컬럼, 두개이상을 그룹핑해서 적용가능.
            -- 중복된 값을 넣을수 없다. NULL값을 넣을수 없다.
    -- UNIQUE : 테이블에 여러 컬럼에 할당 할 수 있다. 중복된 값을 넣을 수 없다.
                --NULL 넣을수 있다. 단 한번만 null
    -- Foreign key : 다른 테이블의 특정 컬럼의 값을 참조해서 넣을 수있다.
                --자신의 컬럼에 임의의 값을 할당하지 못한다.
    -- NOT NULL : NULL 값을 컬럼에 할당할 수 없다.
    -- CHECK : 컬럼에 값을 할당 할 때 체크해서 (조건에 만족하는) 값을 할당.
    -- Default : 값을 넣지 않을때 기본값이 할당.
    
--2.
select ename 사원이름, dname 부서이름, loc 지역명
from employee e inner join department d
on e.dno = d.dno;

--3.
--join에서 using 사용하는 경우
    --natural join : 공통 키 컬럼을 oracle 내부에서 자동검색해서 처리
        --반드시 두테이블의 공통키 컬럼의 데이터 타입이 같아야한다.
    --using 사용이유 : 두테이블의 공통키컬럼의 데이터 타입이 다른경우 using을 사용한다.
    -- 두 테이블의 공통 키 컬럼이  여러개인 경우 using 사용
select dno, loc , job
from employee e inner join department d
using (dno)
where dno =10;
-- on사용
select e.dno, loc, job
from employee e inner join department d
on e.dno = d.dno
where e.dno =10;



--4.
select ename, dname, loc
from employee e Natural join department d
where commission is not null;

--5.
select ename, dname
from employee e, department d
where e.dno = d.dno
and ename like '%A%';

--6
select ename, job , dno, dname ,loc
from employee e natural join department d
where loc = 'NEW YORK';

--=================================0422=============================
--self join : 자기 자신의 테이블을 조인한다. (주로 사원의 상사 정보를 출력할때 사용함,조직도출력)
/*  별칭을 반드시 사용해야한다.
    select 절 : 어느 테이블에 있는 컬럼인지 반드시 명시
*/

select eno, ename, manager
from employee
where manager = '7788';

select *
from employee;

--EQUI join 으로 self join 처리
select e.eno 사원번호, e.ename 사원이름, e.manager 직속상관번호 ,m.ename 직속상관이름
from employee e , employee m    --Self JOIN :
where e.manager = m.eno
order by e.ename ;

select eno, ename, manager, eno, ename
from employee;

--ANSI 호환 : INNER JOIN으로 처리
select e.eno 사원번호, e.ename 사원이름, e.manager 직속상관번호 ,m.ename 직속상관이름
from employee e INNER JOIN employee m    --Self JOIN :
on e.manager = m.eno
order by e.ename ;

-- EQUI JOIN - SELF JOIN
select e.ename || '의 직속상관은' || e.manager ||'입니다.'
from employee e, employee m
where e.manager = m.eno
order by e.ename;

--ANSI 호환 INNER JOIN 으로 SELF JOIN처리

select e.ename || '의 직속상관은' || e.manager ||'입니다.'
from employee e INNER JOIN employee m
on e.manager = m.eno
order by e.ename;

--Outer join :
/*  특정 컬럼의 두 테이블에서 공통적이지 않는 내용을 출력 해야 할떄.
    공통적이지 않는 컬럼은 NULL로 출력이됨
    + 기호를 사용해서 출력 : Oracle
    ANSI 호환 :  OUTER JOIN 구문을 사용해서 출력 <== 모든 DBMS 에서 호환
*/
--Oracle 용 
select e.ename, m.ename
from employee e join employee m
on e.manager = m.eno (+) --공통적이지않아도 무조건 출력해라 
order by e.ename ;

--ansi 호환을 사용해서 출력.
    -- Left outer join : 공통적인 부분이 없더라도 왼쪽은 무조건 모두 출력
    -- rigth outer join : 공통적인 부분이 없더라도 오른쪽은 무조건 모두 출력
    -- full outer join : 공통적인 부분이 없더라도 양쪽모두 무조건 출력
select e.ename, m.ename
from employee e left outer join employee m
on e.manager = m.eno
order by e.ename;

------5일차 서브쿼리

-- sub query : select 문 내에 select 문이 있는 쿼리
select ename, salary
from employee;
select salary
from employee
where ename='SCOTT';
-- scott의 월급보다 많은 사용자를 출력하라. (서브 쿼리)

select ename, salary
from employee
where salary >=3000;

select ename, salary
from employee
where salary >= (select salary from employee where ename ='SCOTT');

--SCOTT와 동일한 부서에 근무하는 사원들 출력하기 (sub Query)

select dno from employee where ename = 'SCOTT';
select ename, dno from employee where dno =20;

select ename ,dno
from employee
where dno = (select dno from employee where ename ='SCOTT');
--and not ename = 'SCOTT'; <<=scott와 동일한 부서에 근무하는 사원출력 + 그중에 scott는빼기

--최소 급여를 받는 사원의 이름, 담당업무, 급여 출력하기 (sub query)
select min (salary ) from employee;
select ename, job, salary from employee where salary = 800;

select ename, job ,salary
from employee
where salary = (select min(salary) from employee); --단일값이나와줘야함


--30번 부서(dno)에서 최소 월급을 받는 사원보다 많은 사원들 이름과 부서번호와 월급출력
select ename, dno , salary
from employee
where  salary > (select min(salary) from employee where dno =30);

--선생님풀이
select salary from employee where dno = 30;
select min(salary) from employee where dno=30;

select ename, dno, salary
from employee
where salary > (select min(salary) from employee where dno =30);

--Having 절에 sub query 사용하기


--30번부서의 최소월급보다 큰 각 부서의 최소 월급
select dno, min(salary), count(dno)
from employee
group by dno
having min(salary) > (select min(salary) from employee where dno =30);

/*  단일행 서브 쿼리 : Sub Query의 결과 값이 단 하나만 출력.
        단일행 비교 연산자 : > , = , >= , < , <= , <>(같지않다), 
    다중행 서브 쿼리 : sub query의 결과 값이 여러개 출력
        다중행 서브쿼리 연산자 : IN, ANY, SOME, ALL, EXISTS
            IN : 메인 쿼리의 비교 조건 ('='연산자로 비교할 경우)이 서브쿼리의 결과값중에
            하나라도 일치하면 참
            ANY, SOME : 메인 쿼리의 비교 조건이 서브쿼리의 검색 결과와 하나 이상 일치 하면 참
            ALL : 메인 쿼리의 비교 조건이 서브 쿼리의 검색 결과와 모든 값이 일치 하면 참
            EXIST : 메인 쿼리의 비교 조건이 서브 쿼리의 결과값 중에서 만족하는 값이 
            하나라도 존재하면 참
*/

-- IN 연산자 사용하기
select ename, eno, dno, salary
from employee
order by dno;

--부서별로 최소 월급을 받는 사용자들 출력 하기 (서브쿼리를 반드시 사용)
select dno, min(salary) , count(*)
from employee
group by dno;

select ename, dno , salary
from employee
where salary in (950, 800, 1300);

select ename, dno , salary
from employee
where salary in (select min(salary) from employee group by dno);

-- ANY 연산자 사용
/*  서브 쿼리가 반환하는 각 각의 값과 비교함
    ' < any ' 는 최대값 보다 작음을 나타냄.
    ' > any ' 는 최소값 보다 큼을 나타냄.
    ' = any ' 는 in과 동일함.
*/

-- 직급이 SALESMAN이 아니면서 급여가 임의의 SALESMAN보다 작은 사원을 출력.
                            --SALESMAN의 최고임금보다 작은사원?
select eno, ename, job, salary
from employee
where salary < any (select salary from employee where job = 'SALESMAN')
--where salary < (select max(salary) from employee where job = 'SALESMAN')
and job <> 'SALESMAN';

select ename, job, salary
from employee
order by job;

select ename
from employee
where salary < any (select salary from employee where job = 'SALESMAN');

--ALL 연산자
/*  sub query의 반환하는 모든 값과 비교
        ' > all ' : 최대값 보다 큼을 나타냄
        ' < all ' : 최소값 보다 작음을 나타냄
*/
--예) 직급이 SALESMAN이 아니면서 SALESMAN보다 급여가 작은사원들
            --1250 (최소값) 보다 작은 사원 (직급은 salesman아닌)
select eno, ename, job, salary
from employee
where salary < all(select salary from employee where job = 'SALESMAN')
and job <> 'SALESMAN';

--담당 업무가 분석가(ANALYST)인 사원보다 급여가 적으면서 업무가 분석가가 아닌 사원들 출력
select eno, ename, job, salary
from employee
where salary < all(select salary from employee where job ='ANALYST')
and job <> 'ANALYST';

--급여가 평균 급여보다 많은 사원들의 사원번호와 이름을 표시하되 결과 급겨에 대해서 오름차순
select eno, ename, salary
from employee
where salary < (select avg(salary) from employee )
order by salary;



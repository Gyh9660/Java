--1.
select *
from employee;

select substr(hiredate,1,5) 년월
from employee;

--2.
select ename 사원이름 ,hiredate 입사년도
from employee
where substr(hiredate,4,2) = 04;

--3.
select ename 사원이름 , manager 직속상관
from employee
where mod(manager,2) =1;

--3-1.
select ename 사원이름, salary 월급
from employee
where mod(salary , 3)= 0;

--4.
select ename 사원이름 ,hiredate 입사날 ,to_char(hiredate, 'YY MON DD DY') 출력결과
from employee;


--5.
select trunc(sysdate-to_date(20220101,'YYYYMMDD')) "현재-1월1일"
from dual;

--5-1.

select trunc(sysdate-to_date(19960122,'YYYYMMDD')) "현재-태어난날짜"
from dual;

--5-2
select trunc (MONTHS_BETWEEN(sysdate,'19960122'))
from dual;


--6.
select ename,manager, NVL(manager,0) 처리후, nvl2(manager,manager,0)처리2
from employee;

--7
select ename ,job, salary, decode(job,'ANALYST',salary+200,
                                       'SALESMAN',salary+180,
                                       'MANAGER',salary+150,
                                       'CLERK',salary+100,
                                       salary
                                    )"인상된 급여"
from employee;
--8.
select eno 사원번호, rpad(substr(eno,1,2),4,'*')가린번호,
ename 사원이름, rpad(substr(ename,1,1),4,'*')가린이름
from employee;

select eno 사원번호, rpad (substr(eno,1,2),length(eno),'*')가린번호,
ename 사원이름, rpad(substr(ename,1,1),length(ename),'*')가린이름
from employee;

select ename, length(ename)
from employee;
--9
select '801210-1234567' 주민번호,
rpad(substr('801210-1234567',1,8),14,'*')가린주민번호,
'010-1122-3344' 전화번호,
rpad(substr('010-1122-3344',1,6),13,'*')가린전화번호
from dual;

select '801210-1234567' 주민번호,
rpad(substr('801210-1234567',1,8),length('801210-1234567'),'*')가린주민번호,
'010-1122-3344' 전화번호,
rpad(substr('010-1122-3344',1,6),length('010-1122-3344'),'*')가린전화번호
from dual;



--10
select eno 사원번호, ename 사원명, manager 직속상관,
case when manager is null then '0000'
     when substr(manager,1,2)='75' then '5555'
     when substr(manager,1,2)='76' then '6666'
     when substr(manager,1,2)='77' then '7777'
     when substr(manager,1,2)='78' then '8888'
     else to_char(manager)
     end 직속상관처리
from employee;


select eno 사원번호, ename 사원명, manager 직속상관,
case when manager is null then 0000
     when substr(manager,1,2)= 75 then 5555
     when substr(manager,1,2)= 76 then 6666
     when substr(manager,1,2)= 77 then 7777
     when substr(manager,1,2)= 78 then 8888
     else manager
     end 직속상관처리
from employee;

/*
    그룹 함수 : 동일한 값에 대해서 그룹핑해서 처리하는 함수
        group by 절에 특정 컬럼을 정의할 경우,
        해당 컬럼의 동일한 값들을 그룹핑해서 연산을 적용.

    집계함수 : 
        - SUM : 그룹의 합계
        - AVG : 그룹의 평균
        - MAX : 그룹의 최대값
        - MIN : 그룹의 최소값
        - COUNT : 그룹의 총 갯수 (레코드수 record, 로우수 row)
        
*/

select sum(salary), round(avg(salary),2), max(salary), min(salary)
from employee;

--주의 : 집계 함수를 처리 할때, 출력컬럼 주의

select sum(salary)
from employee;

select ename
from employee;

select *
from employee;


--sum avg max min(집계함수들)은null값을 자동으로 처리해서 연산한다.
select sum(commission), avg(commission), max(commission), min(commission)
from employee;

--count () : 레코드 수 , 로우수
            --NULL은 처리되지 않는다.
            --테이블의 전체 레코드 수를 가져올 경우 : 
            --count(*) 또는 NOT NULL컬럼을 count()
desc employee;


select eno
from employee;

select count (eno)
from employee;


select commission
from employee;

select count(commission)
from employee;

select count (*)
from employee;

select *
from employee;

--전체 레코드 카운트
select count(*)
from employee;

select count(eno)
from employee;

--중복되지않은 직업의 갯수 (job)
select job
from employee;

select count(distinct job)
from employee;

-- 부서의 갯수 (dno)
select dno
from employee;

select count(distinct dno)
from employee;

--Group by : 특정 컬럼의 값을 그룹핑한다. 주로 집계함수를 select절에서 같이 사용
/*
    select 컬럼명, 집계함수처리된컬럼
    from 테이블
    where 조건
    group by 컬럼명
    having 조건 (group by한 결과에 대한 조건)
    order by 정렬

*/

--부서별 평균 급여.
select dno 부서번호, trunc( avg(salary)) 평균급여
from employee
group by dno; --dno 컬럼의 중복을 그룹핑

select dno 
from employee
order by dno ;
 
--전체 평균 급여.
select avg(salary) 평균급여
from employee;


--group by를 사용하면서 select 절에 가져올 컬럼을 잘지정해야한다.
select dno,count(dno), sum(salary) , 
trunc( avg(salary)), max(commission),min(commission) 
from employee
group by dno;

select job
from employee;

--동일한 직책을 그룹핑해서 월급의 평균,합계,최대값,최소값 출력
select job,count(job), round( avg(salary),1), sum(salary),max(salary),min(salary)
from employee
group by job; --동일한 직책을 그룹핑해서 집계를 한다.

--여러 컬럼을 그룹핑 하기
select dno, job , count(*),sum(salary)
from employee
group by dno,job -- 두컬럼 모두 일치하는 것을 그룹핑
order by count(*) desc;

select dno, job
from employee
where dno = 20 and job = 'CLERK';

--having : group by 에서 나온 결과를 조건으로 처리 할때
    -- 별칭이름을 조건으로 사용하면 안된다.
    
--부서별 월급의 합계가 9000 이상인것만 출력.
select dno, count(*), sum(salary)부서별합계, round(avg(salary),2) 부서별평균
from employee
group by dno
having sum(salary)>9000
order by dno;

--부서별 월급의 평균이 2000이상만 출력
select dno, count(*), sum(salary)부서별합계, round(avg(salary),2) 부서별평균
from employee
group by dno
having avg(salary)>2000
order by dno;

--1. 모든 사원의 급여 최고액, 최저액, 총액, 및 평균 급여를 출력 하시오.
--컬럼의 별칭은 동일(최고액, 최저액, 총액, 평균)하게 지정하고 평균에 대해서는 정수로 반올림 하시오.
select *
from employee;

select max(salary)최고액, min(salary)최저액, sum(salary)총액, round(avg(salary))평균
from employee;

--2. 각 담당업무 유형별로 급여 최고액, 최저액, 총액 및 평균액을 출력하시오.
--컬럼의 별칭은 동일(최고액, 최저액, 총액, 평균)하게 지정하고 평균에 대해서는 정수로 반올림 하시오. 
select job 담당업무, max(salary)최고액, min(salary)최저액, sum(salary)총액, round(avg(salary))평균
from employee
group by job;

--3. count(*)함수를 사용하여 담당 업무가 동일한 사원수를 출력하시오. 
select job , count(*)
from employee
group by job;

--4. 관리자 수를 나열 하시오. 컬럼의 별칭은 "관리자수" 로 나열 하시오. 
select manager 관리자, count(*) 관리자수
from employee
group by manager;


--5. 급여 최고액, 최저 급여액의 차액을 출력 하시오, 컬럼의 별칭은 "DIFFERENCE"로 지정하시오. 
select max(salary)최고,min(salary)최저,(max(salary) - min(salary))DIFFERENCE
from employee;

--6. 직급별 사원의 최저 급여를 출력하시오. 관리자를 알 수 없는 사원 및 최저 급여가 2000미만인 그룹은 제외 시키고
--결과를 급여에 대한 내림차순으로 정렬하여 출력 하시오. 
select job 직급 ,manager 관리자 , min(salary)최저
from employee
group by job,manager
having min(salary)>2000 and manager is not null;

--7. 각 부서에대해 부서번호, 사원수, 부서내의 모든 사원의 평균 급여를 출력하시오. 
--컬럼의 별칭은 [부서번호, 사원수, 평균급여] 로 부여하고 평균급여는 소숫점 2째자리에서 반올림 하시오. 
select dno 부서번호, count(*) 사원수, round(avg(salary),1)평균급여
from employee
group by dno;

--8. 각 부서에 대해 부서번호이름, 지역명, 사원수, 부서내의 모든 사원의 평균 급여를 출력하시오. 
--결럼의 별칭은 [부서번호이름, 지역명, 사원수,평균급여] 로 지정하고 평균급여는 정수로 반올림 하시오.  
/*
[출력예시] 

dname		Location		Number of People		Salary
-----------------------------------------------------------------------------------------------
SALES		CHICAO			6		1567
RESERCH		DALLS			5		2175
ACCOUNTING   	NEW YORK		3		2917

*/

select decode(dno,10,'SALES',
                  20,'RESERCH',
                  30,'ACCOUNTING'
             )"dname" ,
decode(dno,10,'CHICAO',
           20,'DALLS',
           30,'NEW YORK'
       )"Location" ,
       
count(*) "Number of People",
round(avg(salary))"Salary"
from employee
group by dno;



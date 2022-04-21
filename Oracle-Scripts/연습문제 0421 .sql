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
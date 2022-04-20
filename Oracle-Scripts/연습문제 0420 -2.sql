--1. SUBSTR 함수를 사용하여 사원들의 입사한 년도와 입사한 달만 출력하시오
select ename 사원이름,SUBSTR(hiredate, 1, 5) "년도/달"
from employee;

--2. SUBSTR 함수를 사용하여 4월에 입사한 사원을 출력 하시오.
select ename 사원이름, hiredate 입사년도
from employee
where substr(hiredate, 4,2) like('04');

--3. MOD함수를 사용하여 직송상관이 홀수인 사원만 출력하시오
select ename 사원이름 , manager 직송상관
from employee
where MOD(manager,2) = 1;

-- 3-1. MOD 함수를 사용하여 월급이 3의 배수인 사원들만 출력하세요.
select ename 사원이름, salary 월급
from employee
where MOD(salary,3)= 0;

--4. 입사한 년도는 2자리 (YY), 월은 (MON)로 표시하고 요일은 약어(DY)로 지정하여 출력
select ename 사원이름, to_char (hiredate,'YY MON DY') "YY/MON/DY"
from employee;  

--5 올해 몇일이 지났는지 출력 하시오. 현재 날짜에서 올해 1월 1일을 뺸 결과를 출력하고
-- TO_DATE함수를 사용하여 데이터 형식을 일치 시키시오
select trunc( sysdate - to_date(20220101,'YYYYMMDD')) "몇일 지났는지"
from dual;

--5-1 자신이 태어난 날짜에서 현재까지 몇 일이 지났는지 출력 하세요.
select trunc(sysdate - to_date(19960122,'YYYYMMDD')) "현재-태어난날"
from dual;

--5-2 자신이 태어난 날짜에서 현재까지 몇 개월이 지났는지 출력 하세요.
select trunc (months_between(sysdate ,'19960122')) "지난개월 1"
from dual;

select trunc (months_between(sysdate ,to_date(19960122,'YYYYMMDD'))) "지난개월 2"
from dual;

-- 6. 사원들의 상관 사번을 출력하되 상관이 없는 사원에 대해서는 null값 대신 0으로 출력
select ename 사원이름 , NVL(manager, 0) 상관사번
from employee;

--7. DECODE 함수로 직급에 따라 급여를 인상하도록 하시오. 직급이 'ANAIYST' 사원은 200,
--'SALESMAN' 사원은 180, 'MANAGER'인 사원은 150, 'CLERK'인 사원은 100을 인상하시오.

select ename 사원이름 , salary 급여, decode (job ,'CLERK',salary+100,
                                                'MANAGER',salary+150,
                                                'SALESMAN',salary+180,
                                                'ANAIYST',salary+200,
                                                salary
                                           ) 인상된급여
from employee;                                         

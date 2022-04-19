-- 2일차 : DQL : Select

-- desc
desc department;

select * from department;

/*
SQL : 구조화된 질의 언어

Select 구문의 전체 필드 내용

Select      <== 컬럼명
Distinct    <== 컬럼내의 값의 중복을 제거해라
From        <== 테이블명, 뷰명
Where       <== 조건
Group By    <== 특정 값을 그룹핑
Having      <== 그룹핑 한 값을 정렬
Order by    <== 값을 정렬해서 출력

*/

desc employee;
select *
from employee;

--특정 컬럼만 출력 하기
select eno, ename from employee;

-- 특정 컬럼을 여러번 출력

select eno, ename, eno, ename, ename from employee;

select eno, ename, salary from employee;

-- 컬럼에 연산을 적용할 수 있다.

select eno, ename, salary, salary*12 from employee;

-- 컬럼명 알리어스(Alias) : 컬럼의 이름을 변경, 
    --컬럼에 연산을 하거나 함수를 사용하면 컬럼명이 없어진다.
select eno, ename, salary, salary*12 as 연봉 from employee;
select eno as 사원번호, ename as 사원명,  salary as 월급, salary *12 연봉 from employee;                     
select eno 사원번호, ename 사원명 , salary 월급, salary*12 연봉 from employee;
    --공백이나 특수문자가 들어 갈때는 ""으로 처리해야 한다.
select eno "사원 #번호" , ename "사원?명", salary 월급, salary*12 연봉 from employee;

-- nvl 함수 : 연산시에 null을 처리하는 함수
select * from employee;

--nvl 함수를 사용하지 않고 전체 연봉을 계산. 
--(null이 포함된 컬럼에 연산을 적용하면 null출력)
    --null을 0으로 처리해서 연산해야 함. : NVL 함수 
select eno 사원번호 , ename 사원명 , salary 월급, commission 보너스,
salary * 12,
salary * 12 + commission -- 전체연봉 
from employee;

--nvl 함수를 사용해서 연산
select eno 사원번호 , ename 사원명 , salary 월급, commission 보너스,
salary * 12,
salary * 12 + NVL(commission, 0) -- 전체연봉 
from employee;

--특정 컬럼의 내용을 중복 제거후 출력
select * from employee;
select dno from employee;
select distinct dno from employee;

-- 오류 발생 ename에는 중복없음 다른컬럼 떄문에 오류날수 있다
-- 보통 distinct는 컬럼1개에 적용
select ename, distinct dno from employee;

-- 조건을 사용해서 검색 (Where)
select * from employee;

select 
eno 사원번호,
ename 사원명,
job 직책,
manager 직속상관,
hiredate 입사날짜,
salary 월급,
commission 보너스,
dno 부서번호
from employee;

-- 사원 번호가 7788인 사원의 이름을 검색.
select * from employee
where eno = 7788;

select ename from employee
where eno = 7788;

--사원 번호가 7788인 사람의 부서번호, 월급과 입사날짜를 검색.
select hiredate 입사날짜, salary 월급, dno 부서번호 
from employee
where eno = 7788;

desc employee;
-- 값을 가져올때 문자는 '' 안에넣고 대소문자 구분
select *
from employee
where ename = 'SMITH';

--레코드(로우)를 가져올때 
    --number 일때는 '' 붙이지 않는다.
    --문자 데이터를(char,varchar2)나 날짜(data)를 가져올땐 ''를 처리
    --대소문자를 구붅
    
-- 입사 날짜가 '81/12/03'인 사원 출력
select ename, hiredate
from employee
where hiredate = '81/12/03';

--부서 코드가 10인 모든 사원들을 출력.
select ename, dno
from employee
where dno = 10;

select * from employee;

-- 월급이 3000 이상인 사람의 이름과 부서와, 입사날짜,월급을 출력
select ename 사원명, dno 부서, hiredate 입사날짜, salary 월급
from employee
where salary >= 3000;

-- NULL 검색 : is 키워드 사용 <== 주의 : null검색시 = 사용하면 안된다.

select *
from employee
where commission is null;

-- commission이 300이상인 사원이름과, 직책, 월급을 출력
select ename, job, salary, commission
from employee
where commission >= 300;

-- 커미션이 없는 사람들의 이름을 출력.
select ename, commission
from employee
where commission is null;


--조건에서 and , or, not 

--월급이 500이상 2500 미마인 사람들의 이름, 사원번호, 입사날짜를 출력
select ename, eno, hiredate, salary
from employee
where salary >= 500 and salary <2500;


-- 1. 직책이 SALESMAN 이거나 부서코드가 20인 사원이름,직책,월급,부서코드 출력
select * from employee;

select ename, job, salary, dno
from employee
where job = 'SALESMAN' or dno = 20;

--2. 커미션이 없는 사용자중에 부서코드가 20인 사용자의 이름, 부서코드, 입사날짜를 출력

select ename, dno, hiredate, commission
from employee
where commission is null and dno = 20;

--3. 커미션이 null이 아닌 사용자의 이름, 입사날짜, 월급출력

select ename, hiredate, salary , commission
from employee
where not commission is null;

-- 날짜 검색 :
select * from employee;

-- 1982/1/1 ~ 1983/12/31 사이에 입사한 사원의 이름,직책,입사날짜
select ename, job, hiredate
from employee
where hiredate >= '82/1/1' and hiredate <= '83/12/31';

-- 1981년도에 입사한 사원들 사원의 이름, 직책, 입사날짜
select ename, job, hiredate
from employee
where hiredate >= '81/1/1' and hiredate <= '81/12/31';

-- between A and B : A 이상 B 이하
select ename, job, hiredate
from employee
where hiredate between '81/1/1' and '81/12/31';

-- IN 연산자
--커미션이 300, 500, 1400인 사원의 이름과 직책, 입사입을 출력
select * from employee;

select ename, job, hiredate ,commission
from employee
where commission = 300 or commission = 500 or commission = 1400;

select ename, job, hiredate ,commission
from employee
where commission in (300,500,1400);

-- like : 컬럼내의 특정한 문자열을 검색 <== 글검색 기능을 사용할때
    -- % : 뒤에 어떤글자가 와도 상관없다.
    -- _ : 한글자가 어떤값이 와도 상관없다.
    
--F로 시작하는 이름을 가진 사원을 모두검색
select * from employee;

select *
from employee
where ename like 'A%';

--이름이 ES로 끝나는 사원 검색 하기

select ename from employee
where ename like '%ES';

-- J로 시작되고 J뒤의 두글자가 어떤것이 와도 상관없는 사원출력, 뒤에는 ES로 마무리됨
SELECt ename
FROM employee
where ename like 'J__%ES';

--마지막 글자가 R로끝나는 사원출력
select *
from employee
where ename like '%R';

-- MAN단어가 들어간 직책 을 출력
select *
from employee
where job like '%MAN%';


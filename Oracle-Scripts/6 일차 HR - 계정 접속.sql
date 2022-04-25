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

--11
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
/* CRUD ( Create, Read, Update, Delete)

Object (객체) : DataBase 에 존재 (XE, <= Express Edtion(무료버전)
, Standard Edition(유료),Enterprise Edition(유료))
    1. 테이블 , 2. 뷰 , 3. 저장프로시저 , 4. 트리거 ,
    5. 인덱스 , 6. 함수 ,7. 시퀀스 <== DDL (Create, Alter, Drop)
    

테이블 생성 ( Create) -- DDL 객체 생성

    Create Table 테이블명 (
        컬럼명 자료형 null허용여부 [제약조건],
        컬럼명 자료형 null허용여부 [제약조건],
        컬럼명 자료형 null허용여부 [제약조건]
    );

*/

create table dept (
    dno number(2) not null,
    dname varchar2(14) not null,
    loc varchar2(13) null
    );
    
select * from dept;

--DML : 테이블의 값(레코드, 로우)을 넣고(INSERT), 수정하고(UPDATE) 삭제(DELETE)하는 구문
/*  --트렌잭션을 발생 시킴 :  log에 기록을 먼저 하고 Database에 적용한다.
    
    insert into 테이블명 (컬럼명1,컬럼명2,컬럼명3)
    valaues (값1, 값2, 값3 )
*/
begin transaction ; -- 트랜 잭션 시작 (insert, update, delete 구문이 시작되면  자동으로 시작)
rollback ; --트랜 잭션을 롤백 (RAM에 적용된 트랜잭션을 삭제)
commit ; --트랜 잭션을 적용( 실제 DataBase에 영원히 적용)

insert into dept (dno, dname, loc) 
values (10, 'MANAHER', 'SEOUL');
    
    --insert, update, delete 구문은 자동으로 트랜잭션이 시작(begin transaction)
        --RAM에만 적용되어 있는 상태
rollback ;

commit;

/* insert 시 컬럼명을 생략
    insert into dept 
    values (값1,값2,값3)
*/

select * from dept;

insert into dept
values (20, 'ACCOUNTING', 'PUSAN');

commit;

desc dept ;

/* null 허용 컬럼에 값을 넣지 않기
*/
insert into dept(dno,dname)
values(30, 'RESEARCH');

/*데이터 유형에 맞지 않는 값 넣으면 오류 발생*/

insert into dept (dno, dname, loc)
values (300, 'SALES' , 'TAEGUE'); -- 오류발생, NUMBER(2)

insert into dept (loc, dname, dno)
values ('TAEGUN', 'SALESSSSSSSSSSSSS' , 60); --오류 발생, dname varchar2(14)를 넘음


--자료형 ( 문자 자료형)
    --char (10) : 고정크기 10바이트 , 3바이트만 넣을 경우 빈공간 7바이트 생김
        --성능이 빠름(장점), 하드공간낭비(단점)
        --자릿수를 알수 있는 고정크기 컬럼 (주민번호, 전화번호)
    --varchar2 (10) : 가변크기 10바이트,3바이트만 넣을 경우 3바이트만 공간할당
        --성능이 느림(단점), 하드공간낭비가 없다(장점)
        --자릿수가 가변크기인 경우 (주소, 메일주소, )
    --Nchar (10) : 유니코드 10자(한글,중국어,일본어....)
    --Nvarchar2  (10) : 유니코드 10자 (한글,중국어,일본어....)
    
--자료형 (숫자 자료형)
    -- NUMBER(2) : 정수 2자리만 입력 가능
    -- NUMBER (7,3) : 정수 7자리 , 소숫점 3자리까지 저장이 됨.
    -- NUMBER (8,5) : 정수 8자리, 소수점 5자리까지 저장됨.
    
create table test1_tb1 (
    a number(3,2) not null,
    b number(7,5) not null,
    c char(6) null,
    d varchar2(10) null,
    e Nchar (6) null,
    f Nvarchar2(10) null
    );
    

    
desc test1_tb1 ;

drop table test1_tb1 ;

select * from test1_tb1;

insert into test1_tb1 (a,b,c,d,e,f)
values ( 3.22, 77.55555,'aaaaaa','bbbbbbbbbb','한글여섯자리','한글열자까지입니다한');

insert into test1_tb1 (a,b,c,d,e,f)
values ( 3.22, 77.555,'한글','한글','한글여섯자리','한글열자까지입니다한');

--한글 1자는 3byte를 차지한다.

create table test2_tb2(
    a NUMBER (3,2) not null); --NUMBER (3,2) :전체 3자리중 소수 2자리
    
insert into test2_tb2 (a)
values (3.22);
select * from test2_tb2;
commit;    

create table member1 (
    no number (10) not null,
    id varchar2 (50) not null,
    passwd varchar2 (50) not null,
    name Nvarchar2 (6) not null,
    phone varchar2(50) null,
    address varchar2(100) null,
    mdate date not null,
    email varchar2 (50) null
    );
    
insert into member1 (no,id,passwd,name,phone,address,mdate,email)
values (1,'aaa','password','홍길동','010-1111-1111','서울 중구 남산동',sysdate,'aaa@aaa.com');

insert into member1
values (2,'bbb','password','이순신','010-2222-2222','서울 중구 남산동',sysdate,'bbb@bbb.com');

--null 허용 컬럼에 null로 값을 할당.
insert into member1 (no,id,passwd,name,phone,address,mdate,email)
values (3,'ccc','password','김유신',null,null,sysdate,null);

--null허용 컬럼에 값을 넣지 않을 경우 null값이 들어감.
insert into member1 (no,id,passwd,name,mdate)
values (4,'ddd','password','이성계',sysdate);


commit; --안하면 감점--

select * from member1;

drop table member1; 
    
desc member1;    
    
--데이터 수정 (update : 데이터 수정후 commit ,
        --반드시 where 조건을 사용해야 한다.그렇지 않으면 모든 레코드가 수정됨.
        /*
            update 테이블명
            set 컬럼명 = 수정할 값
            where 컬럼명 = 값
        */
        update member1 --member1 테이블을 수정
        set name = '신사임당' --name 컬럼을 '신사임당'으로 바꾸는데
        where no = 2; -- no컬럼이 2번인 컬럼의 값을 바꿔라
        commit;
    
--where를 쓰지않으면 name컬럼이 모두 바뀜 
select * from member1;    
update member1
set name = '을지문덕'
where no = 3;
rollback;
commit;

update member1
set id = 'abcd'
where no = 3;

update member1
set name = '김유신'
where no =1;

update member1
set mdate = '2022/01/01'
where no = 4;

update member1
set email = 'abcd@abcd.com'
where no = 1;
rollback;
commit;
select * from member1;

--하나의 레코드에서 여러컬럼 동시에 수정하기
update member1
set name = '김유신' , email = 'kkk@kkk.com' , phone = '010-7777-7777'
where no = 1;

select * from member1;

update member1
set mdate = to_date('2022-01-01','YYYY-MM-DD')
--set madet = '2022-01-01'
where no = 3;
commit;

--레코드 (로우) 삭제 (delete : 반드시 where 조건을 사용해야함.)

/*
    delete 테이블명 
    where 컬럼명 = 값
    
*/

select * from member1;

delete member1
where no = 3;

commit;

delete member1 ; -- where없이 사용하면 모든 레코드가 삭제됨

rollback;

/*
    update와 delete는 반드시 where조건을 사용해야 한다. 
    트랜잭션을 종료 (rollback, commit)                  
    
*/

/*
    update, delete 시 where절에 사용되는 컬럼은 고유한 컬럼이어햐 한다.
    (Primary key, Unique 컬럼을 사용해야 한다.)
    그렇지 않으면 여러 컬럼이 업데이트 되거나 삭제될 수가 있다.
    
*/
update member1
set name = '김똘똘'
where no = 4;
select * from member1;

--제약 조건 : 컬럼의 무결성을 확보하기 위해서 사용, 
    --무결성 : 결함업는 데이터 (즉, 오류없는 데이터, 내가원하는 데이터만 저장)
    --primary key
        --하나의 테이블에 한번만 사용
        --중복된 데이터를 넣을수 없게함.
        --null값을 넣을 수 없다. (할당 할 수 없다.)
create table member2 (
    no number (10) not null primary key,
    id varchar2 (50) not null,
    passwd varchar2 (50) not null,
    name Nvarchar2 (6) not null,
    phone varchar2(50) null,
    address varchar2(100) null,
    mdate date not null,
    email varchar2 (50) null
    );
    
    insert into member2 (no,id,passwd,name,phone,address,mdate,email)
values (7,'aaa','password','홍길동','010-1111-1111','서울 중구 남산동',sysdate,'aaa@aaa.com');

insert into member2
values (2,'bbb','password','이순신','010-2222-2222','서울 중구 남산동',sysdate,'bbb@bbb.com');

--null 허용 컬럼에 null로 값을 할당.
insert into member2 (no,id,passwd,name,phone,address,mdate,email)
values (3,'ccc','password','김유신',null,null,sysdate,null);

--null허용 컬럼에 값을 넣지 않을 경우 null값이 들어감.
insert into member2 (no,id,passwd,name,mdate)
values (4,'ddd','password','이성계',sysdate);

select * from member2;

update member2
set name = '김유신'
where no = 6; -- <== 테이블에서 중복되지 않는 고유한 컬럼을 조건으로 사용해야 한다.

commit;
rollback;

/*
    제약조건
        -- UNIQUE : 중복되지 않는 고유한 값을 저장. 
            -- 하나의 테이블에서 여러 컬럼에 지정 할 수 있다.
            -- null값을 허용한다. null은 한번만 넣을 수 있다.
            
*/

create table member3 (
    no number (10) not null primary key, -- 중복된 값을 넣을 수 없다.
    id varchar2 (50) not null Unique , -- 중복된 값을 넣을 수 없다.
    passwd varchar2 (50) not null,
    name Nvarchar2 (6) not null,
    phone varchar2(50) null,
    address varchar2(100) null,
    mdate date not null,
    email varchar2 (50) null
    );
    
    insert into member3 (no,id,passwd,name,phone,address,mdate,email)
values (1,'aaa','password','홍길동','010-1111-1111','서울 중구 남산동',sysdate,'aaa@aaa.com');

insert into member3
values (2,'bbb','password','이순신','010-2222-2222','서울 중구 남산동',sysdate,'bbb@bbb.com');

--null 허용 컬럼에 null로 값을 할당.
insert into member3 (no,id,passwd,name,phone,address,mdate,email)
values (3,'ccc','password','김유신',null,null,sysdate,null);

--null허용 컬럼에 값을 넣지 않을 경우 null값이 들어감.
insert into member3 (no,id,passwd,name,mdate)
values (6,'fff','password','이성계',sysdate);

select * from member3;

commit;
rollback;
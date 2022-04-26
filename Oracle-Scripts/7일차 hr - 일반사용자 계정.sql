--7일차 -- 제약조건

--테이블 복사 : 테이블의 전체를 복사함.
    --테이블을 복사하면, 컬럼과 레코드만 복사가 됨.
    --테이블에 할당된 제약조건은 복사되지 않는다. (Alter Table을 사용해서 할당해야한다.)
    --제약 조건 : 컬럼에 할당되어 있다. 무결성을 체크
            -- NOT NULL, Primary Key, Unique, Foreign Key, check, default


--테이블의 전체 레코드를 복사    
create table dept_copy
as
select * from department; --select 해온 테이블을 복사 (as넣고)

desc department;
desc dept_copy;

select * from dept_copy;

create table emp_copy
as
select * from employee;

select * from emp_copy;

--테이블 복사 : 특정 컬럼만 복사하기
create table emp_second
as
select eno, ename, salary, dno from employee;

select * from emp_second;

--테이블 복사 : 조건을 사용해서 테이블 복사
create table emp_third
as
select eno, ename , salary
from employee
where salary > 2000;

select * from emp_third;

--테이블 복사 : 컬럼명을 바꾸어서 복사
create table emp_forth
as
select eno 사원번호, ename 사원명, salary 월급
from employee;

select * from emp_forth;

select 사원번호, 사원명, 월급 from emp_forth; -- 테이블명, 컬럼명, <==영문 사용을 권장.

--테이블 복사 : 계산식을 이용해서 테이블 복사 : 반드시 별칭이름을 사용해야 한다.
create table emp_fifth
as
select eno, ename, salary*12 as salary from employee;

select * from emp_fifth;

--테이블 복사 : 테이블 구조만 복사, 레코드는 복사하지 않는다.

create table emp_sixth
as
select * from employee
where 0=1 ;-- where 조건 : false 를 리턴 => 테이블 구조만복사, 레코드복사 x

select * from emp_sixth;
desc emp_sixth;

-- 테이블 수정 : Alter Table
create table dept20
as
select * from department;

desc dept20;
select * from dept20;

--기존의 테이블에서 컬럼을 추가 함. 주의 : 반드시 추가할 컬럼에 null을 허용해야 한다.
Alter table dept20
add (birth date);

alter table dept20
add (email varchar2(100));

alter table dept20
add (address varchar2(200));

--컬럼의 자료형을 수정 :
desc dept20;

alter table dept20
modify dname varchar2 (100);

alter table dept20
modify dno number(4);

alter table dept20
modify address Nvarchar2(200);

--특정 컬럼 삭제 : 업무시간 외에 작업. 부하가 많이 걸릴수 있다.

desc dept20;

Alter table dept20
drop column birth;

select * from dept20;

alter table dept20
drop column email;

-- 컬럼을 삭제시에 부하가 많이 발생이 됨.
    --set unused : 특정 컬럼을 사용 중지(업무중), 야간에 삭제,
    
alter table dept20
set unused (address);

desc dept20;

alter table dept20  --야간에 사용 중지된 컬럼을 삭제
drop unused column; --사용하지 않는 컬럼을 삭제하겠다.

/*컬럼 이름 변경*/
Alter table dept20
rename column  LOC to LOCATIONS;

desc dept20;

alter table dept20
rename column DNO to D_Number;

-- 테이블 이름 변경
rename dept20 to dept30;

desc dept30;

--테이블 삭제
drop table dept30;

/*
    DDL : Create (생성) , Alter ( 수정) , Drop (삭제)
        <<객체>>
            테이블,뷰,인덱스,틔거,시퀀스,함수,저장프로시져....
*/
/*
    DML : Insert (레코드 추가) , Update (레코드 수정), Delete (레코드 삭제)
        <<테이블의 값 (레코드 ,로우) >>
*/
/*
    DQL : Select 
*/
/*
    테이블의 전체 내용이나 테이블 삭제시
    1. delete   : 테이블의 레코드를 삭제, where없으면 모든 레코드를 삭제
    2. truncate : 테이블의 레코드를 삭제, 속도가 굉장히 빠르다. <<빠른 포멧>>
    3. drop     : 테이블 자체를 삭제
*/

create table emp30
as
select * from employee;

select * from emp10;

-- emp10 : delete를 사용해서 삭제
    delete emp10;
    commit;
    select * from emp10;
-- emp20 : truncate를 사용해서 삭제
    truncate table emp20;

    select * from emp20;

-- emp30 : drop를 사용해서 삭제
    drop table emp30;
    select * from emp30;
    
    
drop table EMP;
drop table emp_copy;
drop table dept;
--1--
create table dept(
    dno number(2) not null,
    dname varchar2(14) null,
    loc varchar2(13) null
    );

--2--    
create table emp(
    eno number(4) not null,
    ename varchar2(10) null,
    dno number(2) null
    );

--3--
alter table emp
modify ename varchar2(25);

--4--
create table employee2
as
select eno "EMP_ID", ename "NAME", salary "SAL", dno "DEPT_ID" from employee;

--5--
drop table emp;

--6--
rename employee2 to emp;

--7--
alter table dept
drop column dname;

--7-2--
alter table dept
set unused (dname);

alter table dept
drop unused column;

--8--
alter table dept
set unused (loc);

--9--
alter table dept
drop unused column;

--09----
--1--
create table emp_insert
as
select * from emp
where 0=1;

--2--
alter table emp_insert
add hiredate date;

insert into emp_insert(emp_id,name,sal,dept_id,hiredate)
values(1111,'권용희',3000,30,sysdate);

select * from emp_insert;
desc emp_insert;

--3-- 
insert into emp_insert(emp_id,name,sal,dept_id,hiredate)
values(2222,'유준상',3000,20,to_date(20220425,'YYYYMMDD'));

--4--
create table emp_copy
as
select * from employee;

--5--
select * from emp_copy;

update emp_copy
set dno = 10
where eno = 7788;
commit;
--6--
update emp_copy
set job = (select job from emp_copy where eno =7499) ,
salary = (select salary from emp_copy where eno=7499)
where eno = 7788;
commit;
--7--
update emp_copy
set dno = (select dno from emp_copy where eno = 7369)
where eno in (select eno from emp_copy where job =(select job from emp_copy where eno = 7369));
commit;
--8--
drop table dept_copy;
create table dept_copy
as
select * from department;

--9--
select * from dept_copy;
delete dept_copy
where DNAME = 'RESEARCH';
commit;

--10--
delete dept_copy
where dno = 10 or dno = 40;
commit;


/*
    데이터 사전 : 시스템의 각종 정보를 출력해 주는 테이블
        user_   : 자신의 계정에 속한 객체정보를 출력
        all_    : 자신의 계정이 서유한 객체나 권한을 부여 받은 객체 정보를 출력
        dba_    : 데이터 베이스 관리자만 접근 가능한 객체 정보를 출력.
*/

show user;
select * from user_tables;      --사용자가 생성한 테이블 정보 출력
select table_name from user_tables;
select * from user_views;       --사용자가 생성한 뷰에 대한 정보 출력
select * from user_indexes;     --사용자가 생성한 인덱스 정보
select * from user_constraints; --제약 조건 확인
select * from user_constraints
where table_name = 'EMPLOYEE';
select * from user_sequences;

select * from all_tables; -- 모든 테이블을 출력, 권한을 부여 받은 테이블
select * from all_views;

select * from dba_tables; --관리자 계정에서만 실행 가능
/*
    제약 조건 : 테이블의 무결성을 확보 하기 위해서 컬럼에 부여되는 규칙.
        1. Primary Key
        2. Unique
        3. not null
        4. CHECK
        5. Foreign Key
        6. Default
*/
--1 Primary Key : 중복된 값을 넣을 수 없다.

-- a . 테이블 생성시 컬럼에 부여
    --제약 조건 이름 : 지정하지 않을 경우 : Oracle 에서 랜덤한 이름으로 생성,
        --제약 조건을 수정할때 제약조건 이름을 사용해서 수정.
        --PK_customer01_id : Primary key 제약조건, customer01테이블, id 컬럼에 지정된
        --NN_customer01_pwd : Not Null 제약조건, customer01 테이블, pwd 컬럼명

    create table customer01 ( --constraint PK_customer01_id, 제약조건 이름
    id varchar2(20) not null constraint PK_customer01_id Primary key,
    pwd varchar2(20) constraint NN_customer01_pwd not null ,
    name varchar2(20) constraint NN_customer01_name not null ,
    phone varchar2(30) null,
    address varchar2(100) null
    );
    
    select * from user_constraints
    where table_name = 'CUSTOMER01'; --db에들어갈떄는 대문자로 들어가기떄문에 소문자로 처리 x대문자로 찾아야함
   
    create table customer02 (  --constraint PK_customer01_id, 제약조건 이름
    id varchar2(20) not null Primary key,
    pwd varchar2(20) not null ,
    name varchar2(20) not null ,
    phone varchar2(30) null,
    address varchar2(100) null
    );
    select * from user_constraints
    where table_name = 'CUSTOMER02';

--테이블의 컬럼 생성후 제약 조건 할당.
 create table customer03 ( 
    id varchar2(20) not null ,
    pwd varchar2(20) constraint NN_customer03_pwd not null ,
    name varchar2(20) constraint NN_customer03_name not null ,
    phone varchar2(30) null,
    address varchar2(100) null,
    constraint PK_customer03_id Primary key (id)
    );
    
/*
    foreign key (참조키) : 다른 테이블(부모)의 primary key, unique 컬럼을 참조해서 값을 할당.
    check : 컬럼에 값을 할당할때 check에 맞는 값을 할당.
    
*/

--부모 테이블
    Create table parentTbl(
    name varchar2(20),
    age number(3) constraint CK_ParentTbl_age check (AGE>0 and AGE <200),
    gender varchar2(3) constraint CK_ParentTbl_gender check (gender IN ('M','W')),
    infono number constraint PK_ParentTbl_infono Primary key
    );
    
desc parentTbl;    
select * from user_constraints
where table_name = 'PARENTTBL';


--자식 테이블
Create table ChildTbl (
    

















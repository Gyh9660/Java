--08 테이블 생성 수정제거

--1. dept테이블 생성
select * from user_tables --데이터 사전 : 시스템의 각종 정보를 출력
where table_name = 'DEPT';

drop table dept;

create table dept (
    dno number(2) not null,
    dname varchar2(14) null,
    loc varchar2(13) null
    );
    
--2. emp테이블 생성

drop table emp;

create table emp(
    eno number(4) not null,
    ename varchar2(10) null,
    dno number(2) null
    );
    --DB 설정에 따라서, null허용 여부가 다르게 셋팅되어있을수 있다.
--3. emp 테이블의 dname컬럼의 크기를 10->25
alter table emp
modify ename varchar(25);

desc emp;

select length (ename) from employee -- ename에 몇자가 들어가있는지 확인
where length (ename) >5;


--4. employee 복사해서 employee2생성 사원번호,이름,급여,부서번호
create table employee2
as
select eno,ename,salary,dno
from employee;

select * from employee2; 
--테이블 복사시에 제약조건 복사 안됨
    --primary key, unique, not null, default,check, foreign key....
    
--5 .emp 삭제
drop table emp;

-- 6. employee2 -> emp
rename employee2 to emp;

desc employee2;
desc emp;

--7 dept 에서 dname 제거
select * from dept;

--실제 운영하는 시스템에서는 레코드가 많이 들어가있다. 컬럼제거시 부하가 많이발생(야간)

alter table dept
drop column dname;

--8 dept loc unused <-- 제거할 컬럼을 비할성화 (업무시간에)

alter table dept
set unused column loc;

alter table dept
set unused (loc);

--9. unused 제거 (야간에 작업)
alter table dept
drop unused columns;  -- column X columns O 

--09 데이터 조작과 트랜잭션

--1 emp 구조복사 emp_insert 빈테이블

select * from emp;

drop table emp_insert;

create table emp_insert
as
select * from emp
where 0=1; --조건을 false로 설정


--2 emp_insert 에 본인추가 sysdate로 입사일 표시

--테이블에 컬럼을 추가할때 null 허용하면서 추가해야 한다.

alter table emp_insert
add hiredate date;

desc emp_insert;

select * from emp_insert;

insert into emp_insert
values(1111,'권용희',3000,10,sysdate);

commit;
--3 emp_insert 테이블에 옆사람 추가 hiredate to_date로 어제

insert into emp_insert
values(1122,'홍길동',3000,10,to_date(sysdate -1,'YY/MM/DD'));
commit;

--4 employee 구조내용 복사 emp_copy
drop table emp_copy;
create table emp_copy
as
select * from employee;

--5. 사원번호 7788 사원의 부서번호 10으로 수정 copy사용
select * from emp_copy;

update emp_copy
set dno = 10
where eno = 7788; --주의 where 뺴먹으면 다바뀜 (update나 delete시)

commit; --트랜잭션 처리

--6 사원번호가 7788 사원의 담당업무 및 급여를 사원번호 7499의 담당업무및 급여와 일치하도록 갱신
select * from emp_copy where eno = 7788 or eno = 7499;

update emp_copy
set job = (select job from emp_copy where eno = 7499) ,
salary = (select salary from emp_copy where eno = 7499)
where eno = 7788;
commit;
--7 7369와 업무가 동일한 사원의 번호를 7369의 부서번호로 갱신
select * from emp_copy where eno =7369;

update emp_copy
set dno = (select dno from emp_copy where eno = 7369)
where job = (select job from emp_copy where eno = 7369);
commit;

--8. department 구조 내용 복사 dept_copy생성
drop table dept_copy;

create table dept_copy
as
select * from department;

--9 부서명이 reserach인 부서제거
select * from dept_copy;
select * from department;
delete dept_copy
where dname = 'RESEARCH';
commit;


--10 부서 10 40인 부서제거
delete dept_copy
where dno in (10,40);
commit;

--10 데이터 무결성과 제약 조건

--1 employee 구조복사 emp_sample , 사원번호에 primary key, my_emp_pk

--테이블 복사할때 제약조건은 복사되지 않는다. alter table를 사용해서 넣어줘야함.
create table emp_sample
as
select * 
from employee 
where 0=1;
select * from emp_sample;

alter table emp_sample
add constraint my_emp_pk primary key(eno);

select * from user_constraints
where table_name in ('EMP_SAMPLE','DEPT_SAMPLE');

--2  departmnet 테이블 구조 복사 dept_sample 부서번호 컬럼에 primary key my_dept_pk
create table dept_sample
as
select * from department
where 0=1;

alter table dept_sample
add constraint my_dept_pk primary key(dno);

select * from user_constraints
where table_name in ('EMP_SAMPLE','DEPT_SAMPLE');

--3. 사원 테이블의 부서번호 컬럼에 존재하지 않는 부서의 사원이 배정되지 않도록 외래키 제약조건 my_emp_dept_fk
alter table emp_sample
add constraint my_emp_dept_fk foreign key(dno) references dept_sample(dno);

--4 사원테이블 커미션 컬럼에 0보다 큰값만 입력할수 있도록 제약
alter table emp_sample
add constraint my_emp_ck check (commission >0);

select * from user_constraints
where table_name in ('EMP_SAMPLE','DEPT_SAMPLE');

--5 사원테이블 월급 컬럽을 기본값 1000으로 설정
-- modify = dafault , not null
alter table emp_sample
modify salary default 1000;

--6 사원테이블 이름컬럼에 중복 되지 않도록 제약조건 설정

select * from user_constraints
where table_name in ('EMP_SAMPLE','DEPT_SAMPLE');

alter table emp_sample
add constraint my_emp_uk unique(ename);

--7 사원테이블의 커밋션에 null을 입력할수 없도록 제약조건
alter table emp_sample
modify commission constraint my_emp_nn not null;

--8 생성한 모든 제약조건 제거

select * from user_constraints
where table_name in ('EMP_SAMPLE','DEPT_SAMPLE');

--제약 조건을 제거시 : foreign key 참조하면 제거가 안된다.
    --1. foreign key를 먼저 제거후 primary key 제거하는 방법
    --2. primary key 제거할때 cascade 옵션을 줘서 foreign key 먼저제거후 primary key제거
alter table emp_sample
drop primary key;

alter table dept_sample
drop primary key cascade;

alter table emp_sample
drop constraint my_emp_ck;

alter table emp_sample
drop constraint my_emp_uk;

alter table emp_sample
drop constraint my_emp_nn;

--10 뷰문제

--1. 20번 부서에 소속된 사원의사원번호,이름,부서번호를 출력하는 select문을 하나의view로 정의
    --뷰의 이름 :v_em_dno
    --뷰 : 가상의 테이블, select 문만 올수 있다.
        --보안을 위해서 - 실제 테이블의 컬럼을 숨길수 있따.
        --편의성을 위해서 : 복잡한 구문을 view를 생성하면 , 복잡한join
    create view emp_view
    as
    select * from employee;
    
    create view dept_view
    as
    select * from employee;
    
    create view v_em_dno
    as
    select eno, ename,dno
    from emp_view
    where dno =20;
    
--뷰실행
select * from v_em_dno;

--2. 이미 생성한 뷰 에 대해서 급여 출력할수있도록 수정

create or replace view v_em_dno
as
select eno, ename, dno, salary
from emp_view
where dno =20;

--3. 생성된 뷰 제거
drop view v_em_dno;

--4. 각 부서의 급여의 최소값, 최대값,평균,총합을 구하는뷰생성 주의:별칭이름 사용
--뷰이름 v_sal_emp
create view v_sal_emp
as
select dno , min(salary) MIN, max(salary) MAX, round(avg(salary)) AVG, sum(salary) SUM
from emp_view
group by dno;

select * from v_sal_emp;

--5.  이미 생성된 뷰를 읽기전용뷰로 수정
create or replace view v_sal_emp
as
select dno , min(salary) MIN, max(salary) MAX, round(avg(salary)) AVG, sum(salary) SUM
from emp_view
group by dno with read only;


-------9일차 시퀀스 인덱스------------------
/*
    시권스 : 자동 번호 발생기 
        -- 한번 값이 발생되면 (번호가 자동 발생되면) 뒤로 되돌릴 수 없다.(삭제후 다시 생성해야 한다.)
        -- primary key 컬럼에 번호를 자동으로 발생시키기 위해서 사용
        -- primary key 키컬럼에는 중복되지 않는 고유한 값을 신경을 안써도 된다.
*/
--초기값 : 10 , 증가값 : 10
create sequence sample_seq
    increment by 10   -- 증가값
    start with 10;    -- 초기값

--sequence 정보를 출력하는 데이터 사전
select * from user_sequences;

select sample_seq.nextval from dual; -- 시퀀스의 다음값을 출력
select sample_seq.currval from dual; -- 시퀀스의 현재값을 출력

--초기값 2, 증가값 : 2 
create sequence sample_seq2
    increment by 2
    start with 2
    nocache;     --캐시를 사용하지 않겟다. (RAM) -- 서버의 부하를 줄여줄수 있다. (캐시사용하면)    

select sample_seq2.nextval from dual; -- 시퀀스의 다음값을 출력
select sample_seq2.currval from dual; -- 시퀀스의 현재값을 출력


--시퀀스를 primary key에 적용하기

create table dept_copy80
as
select *
from department
where 0=1;

select * from dept_copy80;

--시퀀스 생성 : 초기값 10, 증가값 10
create sequence dept_seq
    increment by 10
    start with 10
    nocache;    
    
    /*sequence 에 cache를 사용하는경우 / 사용하지 않는경우*/
    -- cache : 서버의 성능을 향상하기 위해서 사용 (기본값 : 20개 )
    -- 서버가 다운된 경우 : 캐쉬된 넘버링이 모두 날라감. 새로운 값을 할당 받는다.
    -- 문제발생햇을경우 drop하고 다시설정해줘야함.
    
insert into dept_copy80 (dno, dname, loc)
values ( dept_seq.nextval, 'HR', 'SEOUL');

select * from dept_copy80;

create sequence emp_seq_no 
    increment by 1
    start with 1
    nocache;
    
create table emp_copy80
as
select * from employee
where 0=1;

select * from emp_copy80;

-- 시퀀스를 테이블의 특정 컬럼에 적용

insert into emp_copy80
values ( emp_seq_no.nextval ,'SMITH','SALESMAN',2222,sysdate,3000,300,20);

-- 기존의 시퀀스 수정
select * from user_sequences;

alter sequence emp_seq_no
    maxvalue 1000;
    
alter sequence emp_seq_no 
    cycle ; --최대값이 적용되고 다시 처음부터 순환
    
alter sequence emp_seq_no 
    nocycle ;    --순환하지 않겟다.
    
select * from user_sequences;
drop sequence sample_seq;


--인덱스--
/*
    INDEX : 테이블의 컬럼에 생성, 특정 컬럼의 검색을 빠르게사용할 수 있도록 한다.
        - INDEX Page : 컬럼의 중요 키워드를 걸러서 위치 정보를 담아놓은 페이지를 INDEX Page라고한다.
            - DB공간의 10%
        - 색인(index ) : 책의 색인, 책의 내용의 중요 키워드를 수집해서 위치를 알려줌.
        - 테이블 스캔 : 레코드의 처음 ~ 마지막까지 검색 (검색 속도가 느리다.),인덱스를 사용하지않고 검색
            - Index 가 생성되어있지 않는 컬럼은 테이블 스캔을 한다.
        - Primary Key, Uniqe 키가 적용된 컬럼은 INDEX page가 생성되어 검색을 빠르게 할수있다.
        - where 절에서 자주 검색을 하는 컬럼에 index를 생성.
        - 테이블의 검색을 자주하는 컬럼에 index를 생성한다, 
          테이블 스캔을 하지 않고 index page를 검색해서 위리츨 빠르게 찾는다.
        - Index 를 생성할때 부하가 많이 걸린다. 주로 업무시간을 피해서 야간에 생성함.
        - index는 잘생성해야 한다.

*/

-- index 정보가 저장되어 있는 데이터 사전.
    -- user_tab_columns , user_ind_columns
    select * from user_tab_columns;
    select * from user_ind_columns;
    
select * from user_tab_columns
where table_name in ('TBL1','TBL2','EMPLOYEE','DEPARTMENT');
    
select index_name, table_name , column_name
from user_ind_columns
where table_name in ('EMPLOYEE','DEPARTMENT');

select * from employee; -- ENO 컬럼에 Primary key가 들어가있다. <== 자동으로 index 가 만들어짐

/*
    index 자동 생성 , (primary key, unique) 컬럼에는 index page가 자동으로 생성된다.
    
*/

create table tbl1 (
    a number(4) constraint PK_tbl1_a primary key,
    b number(4),
    c number(4)
    );
    
select index_name, table_name , column_name
from user_ind_columns
where table_name in ('TBL1','TBL2','EMPLOYEE','DEPARTMENT');

select * from tbl1;

create table tbl2(
    a number(4) constraint PK_tbl2_a primary key,
    b number(4) constraint UK_tbl2_b unique,
    c number(4) constraint uk_tbl2_c unique,
    d number(4),
    e number(4)
    );
    
create table emp_copy90
as
select * from employee;

select * from emp_copy90;

select index_name, table_name , column_name
from user_ind_columns
where table_name in ('EMP_COPY90');

select * from emp_copy90
where ename = 'KING'; --ename 컬럼에 index가 없으므로 king을 검색하기 위해서 테이블스캔한다.


-- ename 컬럼에 index 생성하기 (야간에 작업해야 한다, 부하가 많이 걸린다.)

-- 컬럼에 index가 생성되어 있지 않으면 테이블 스캔을 한다. 처음부터 하나하나 검색한다.
-- 컬럼에 index가 생성되어 있으면 index page(책의 목차)를 검색한다.

create index id_emp_ename
on emp_copy90(ename);
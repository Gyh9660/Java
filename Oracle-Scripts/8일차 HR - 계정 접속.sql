--테이블 삭제시 주의사항 : 다른 테이블에서 foreign key로 자신의 테이블을
--참조하고 있으면 삭제가 안된다.
    --다른 테이블이 참조하고 있더라도 강제로 삭제하는 옵션 : cascade

drop table orders;
drop table member;     --오류발생 : orders 테이블의 id컬럼이 member 테이블의id 컬럼을 참조하고 있다.
drop table tb_zipcode; -- 오류발생 : member테이블의 zipcode가 tb_zipcode테이블의 zipcode컬럼을 참조하고 있어서
drop table products;

-- 제약조건 제거후에 삭제 (Foreign key가 다른걸 참조하고있어서)
alter table member
drop constraint FK_member_zipcode_tb_zipcode;

alter table orders
drop constraint FK_orders_id_member;

alter table orders
drop constraint FK_orders_product_code;

--제약 조건 확인
select * from user_constraints
where table_name = 'MEMBER';

select * from user_constraints
where table_name = 'ORDERS';

select * from user_constraints
where table_name = 'TB_ZIPCODE';

/*
    foreign key로 참조 되는 테이블 생성, 삭제시
    1. 자식 테이블 먼저 삭제 후 부모 테이블 삭제
    2. foreign key제약 조건을 모두 제거후 테이블 삭제
    3. cascade constraints 옵션으로 테이블을 강제 삭제
*/
drop table member;
--cascade constraints 옵션을 사용해서 삭제, <== foreign key제약 조건을 먼저 제거후 삭제.


drop table member cascade constraints;
drop table tb_zipcode cascade constraints;
drop table products cascade constraints;
drop table orders cascade constraints;
select * from member;

--테이블 생성시 (Foreign key) : 부모테이블(FK가 참조하는 테이블)을
--먼저 생성해야 한다. 자식테이블생성.
    --자식 테이블을 생성할때 FK를 넣지 않고 생성후, 부모테이블 생성후,
    --Alter table를 사용해서 나중에 FK를 넣어준다.
    
create table tb_zipcode(
    zipcode varchar2(7) not null constraint PK_tb_zipcode_zipcode primary key,
    sido varchar2(30),
    gugum varchar2(30),
    dong varchar2(30),
    bungi varchar2(30)
    );
   
create table member(
    id varchar2(20) not null constraint PK_member_id primary key,
    pwd varchar2(20),
    name varchar2(20),
    zipcode varchar2(7), constraint FK_member_zipcode_tb_zipcode foreign key (zipcode) references tb_zipcode(zipcode)
    );
    
CREATE TABLE products (
    product_code VARCHAR2(20) NOT NULL CONSTRAINT PK_products_product_code PRIMARY KEY,
    product_name VARCHAR2(100),
    product_kind CHAR(1),
    product_price1 VARCHAR2(10),
    product_price2 VARCHAR2(10),
    product_content VARCHAR2(1000),
    product_image VARCHAR2(50),
    sizeSt VARCHAR2(5),
    sizeEt VARCHAR2(5),
    product_quantity VARCHAR2(5),
    useyn CHAR(1),
    indate DATE
    );
    
    CREATE TABLE orders(
    o_seq NUMBER(10) NOT NULL CONSTRAINT PK_orders_o_seq PRIMARY KEY,
    product_code VARCHAR2(20),
    CONSTRAINT FK_orders_product_code FOREIGN KEY (product_code) REFERENCES products(product_code),
    id VARCHAR2(16),
    CONSTRAINT FK_orders_id_member FOREIGN KEY (id) REFERENCES member(id),
    product_size VARCHAR2(5),
    quantity VARCHAR2(5),
    result CHAR(1),
    indate DATE
    );
    
    
    select * from tb_zipcode;
    
    
--트랜잭션 발생 : DML : insert update delete 에서만 발생 
                --<== commit;
                


--1. 누락 컬럼 추가
alter table tb_zipcode
add (zip_seq varchar2(30));

--2. 컬럼 이름 변경
alter table tb_zipcode
rename column bungi to bunji;
    
alter table tb_zipcode
rename column gugum to gugun;

--3 부족한 자릿수 변경
alter table tb_zipcode
modify dong varchar2(100);

--4. 제약 조건 잠시 비활성화 하기 (잠시 비활성화 하기)
-- <== Bulk insert (대량으로 insert)할때 제약조건을 disable/
    -- 제약 조건으로 인해서 insert되는 속도가 굉장히 느리다.
alter table tb_zipcode
disable constraint PK_tb_zipcode_zipcode; -- 오류발생 :member 테이블의 zipcode 컬럼이 이 테이블을 참조하고 있기 때문에

alter table tb_zipcode
disable constraint PK_tb_zipcode_zipcode cascade; --member 테이블의 fk가 적용된 제약조건도 함께 disable

select * from user_constraints
where table_name in('MEMBER','TB_ZIPCODE');

select * from user_constraints
where table_name ='TB_ZIPCODE';


select constraint_name, table_name, status from user_constraints
where table_name in('MEMBER','TB_ZIPCODE');

select * from tb_zipcode;

truncate table tb_zipcode; -- 기존의 레코드만 모두 제거 (빠르게 모든레코드삭제)

delete tb_zipcode; -- 기존의 레코드만 모두 제거 : 삭제가 느리다(대량일 경우)
commt;

--제약 조건 활성화 하기
alter table member
enable novalidate constraint FK_member_zipcode_tb_zipcode;

alter table tb_zipcode
enable novalidate constraint PK_tb_zipcode_zipcode;

select constraint_name, table_name, status from user_constraints
where table_name in('MEMBER','TB_ZIPCODE');

select count(*) from tb_zipcode;

--zip_seq 컬럼의 정렬이 제대로 안된 이유를 살펴보고, 제대로 정렬되도록 해보자
    --문자 정렬 형식으로 출력됨, to_number로 숫자로 형변환후 정렬
select * from tb_zipcode
order by to_number(zip_seq);

truncate table tb_zipcode;

select constraint_name, table_name, status from user_constraints
where table_name in('MEMBER','TB_ZIPCODE');


desc tb_zipcode;

select * from tb_zipcode
where zip_seq = '3';

/*제약 조건 수정 (Alter Table) : 기존의 테이블에 제약 조건을 수정*/

create table emp_copy50
as
select * from employee;

create table dept_copy50
as
select * from department;

select * from emp_copy50;
select * from dept_copy50;

select * from user_constraints
where table_name in ('EMPLOYEE','DEPARTMENT');

select * from user_constraints
where table_name in ('EMP_COPY50','DEPT_COPY50');

--테이블을 복사하면 레코드만 복사가 된다. 테이블의 제약 조건은 복사되어 오지 않는다.
    --Alter Table를 사용해서 제약조건을 적용
    
select * from emp_copy50; 
select * from dept_copy50;
--Primary Key
alter table emp_copy50
add constraint PK_emp_copy50_eno primary key(eno);

alter table dept_copy50
add constraint PK_dept_copy50_dno primary key(dno);

--Foreign Key
alter table emp_copy50
add constraint FK_emp_copy50_dno foreign key(dno) references dept_copy50(dno);

--NOT NULL 제약 조건 추가. (구문이 다르다. add대신에 modify를 사용)
    --null이 기존에 이미 존재하는 컬럼은 not null처리 해줄수 없음
    --안의 null을 먼저 처리해주고 not null처리 해줘야한다.

desc employee;
desc emp_copy50; --primary key는 not null을 따로 넣지 않아도 자동으로 할당
desc department;
desc dept_copy50; --not null넣지 않앗지만 primary key 제약 조건을 할당


--기존의 null이 들어가있는 곳에는 not null컬럼으로 지정 할 수 없다.

select ename from employee
where ename is null;

alter table emp_copy50
modify ename not null;

alter table emp_copy50
modify ename constraint NN_emp_copy50_ename not null;

    -- commission 컬럼에 not null 할당 하기
    -- null이 들어가 있는 경우 null을 처리해줘야 한다.
    -- update 테이블명 set 컬럼명 = 바꿀값 where 컬럼명 is null  
select * from emp_copy50;

alter table emp_copy50
modify commission constraint NN_emp_copy50_commission not null;

update emp_copy50
set commission = 0
where commission is null;

-- Unique 제약 조건 추가 : 컬럼에 중복된 값이 있으면 넣을수 없음(할당 불가)
    --
    
select * from emp_copy50;

select ename , count(*)
from emp_copy50
group by ename
having count(*) > 1;

alter table emp_copy50
add constraint UK_emp_copy50_ename unique (ename);

desc emp_copy50;

--check 제약 조건 추가 : 기존에 존재하는값이 check제약 조간에 위배되면
--먼저 수정을해줘야 설정할수 있다?

select * from emp_copy50;

alter table emp_copy50
add constraint CK_emp_copy50_salary check (salary >0 and salary <10000);

--default 제약 조건 추가 <제약조건이 아님: 제약조건 이름을 할당할 수 없다.
    --값을 넣지 않을 경우 default 값이 들어감 
alter table emp_copy50
modify salary default 1000;

desc emp_copy50;

insert into emp_copy50 (eno, ename, commission)
values (9999,'JULI',100);

insert into emp_copy50
values (8888,'JULIA',null,null,default,default,1500,null);

select * from emp_copy50;

alter table emp_copy50
modify hiredate default sysdate;

/*제약 조건 제거 : Alter Table 테이블명 drop*/

--Primary key 제거
alter table emp_copy50 --오류 없이 제거됨.
drop primary key; 

alter table dept_copy50 --오류 발생 : foreign key가 참조하기 떄문에 삭제 안됨.
drop primary key;

alter table dept_copy50 --foreign key를 먼저 제거하고 primary key 제거
drop primary key cascade;

select * from user_constraints
where table_name in ( 'EMP_COPY50','DEPT_COPY50');

-- not null 컬럼 제거 하기 :<< 제약 조건 이름으로 삭제
alter table emp_copy50
drop constraint NN_EMP_COPY50_ENAME;

--Unique, check  제약조건 제거 << 제약 조건 이름으로 제거
alter table emp_copy50
drop constraint UK_EMP_COPY50_ENAME;

alter table emp_copy50
drop constraint CK_EMP_COPY50_SALARY;

alter table emp_copy50
drop constraint NN_EMP_COPY50_COMMISSION;

--default 는 null 허용 컬럼은 default nul로 셋팅: default 제약 조건을 제거 하는 것
alter table emp_copy50
modify hiredate default null;

select * from emp_copy50;
/*  제약 조건 disable/enable
    <= 제약조건을 잠시 중지 킵.
    대량(Bulk Insert)으로 값을 테이블에 추가할때 부하가 많이 걸린다. disable==> enable
    index를 생성할때 부하가 많이 걸린다. disable  ==> enable

*/

alter table dept_copy50
add constraint PK_dept_copy50_dno primary key(dno);

alter table emp_copy50
add constraint PK_emp_copy50_eno primary key(eno);


alter table emp_copy50
add constraint FK_emp_copy50_dno foreign key(dno) references dept_copy50(dno);

select * from user_constraints
where table_name in ('EMP_COPY50','DEPT_COPY50');

select * from emp_copy50;
select * from dept_copy50;

alter table emp_copy50
disable constraint FK_emp_copy50_dno;

insert into emp_copy50 (eno, ename, dno)
values (8989,'AAAA',50);

insert into dept_copy50
values (50, 'HR','SEOUL');

alter table emp_copy50
enable constraint FK_emp_copy50_dno;

------------------8일차 - 뷰, 스퀀스, 인덱스
/*
    뷰(view) :가상의 테이블을 뷰(view)라 한다.
        --테이블을 데이터 값을 가지고 있다.
        --뷰는 데이터 값을 가지지 않는다. 실행 코드만 들어가 있다.
        --뷰를 사용하는 목적 :
            1. 보안을 위해서 : 실제테이블의 특정 컬럼을 가져와서
                실제 테이블의 중요 컬럼을 숨길 수 있다.
            2. 복잡한 쿼리를 뷰를 생성해서 편리하게 사용 가능
                (복잡한 JOIN 쿼리)
        --뷰는 일반적으로 select 구문이 온다. (실행)
        --뷰는 insert, update, delete 구문이 올 수 없다.
        --뷰에 값을 insert하면 실제 테이블에 저장이 된다.
            실제 테이블의 제약조건을 잘 만족해야 된다.
        --뷰에 값을 insert할 경우 실제 테이블의 제약조건에
            따라서 inset될 수도 있고 그렇지 않을수도 있다.
        --그룹함수를 적용한 view에는 insert할 수 없다.
        
        
*/

create table dept_copy60
as
select * from department;

create table emp_copy60
as
select * from employee;

-- 뷰 생성
create view V_emp_job
as
select eno, ename, dno, job
from emp_copy60
where job like 'SALESMAN';

--뷰 생성 확인
select * from user_views;

--뷰의 실행 (select * from 뷰이름)
select * from v_emp_job;

--복잡한 join 쿼리를 뷰에 생성하기

create view v_join
as
select e.dno, ename, job,dname, loc
from employee e, department d
where e.dno = d.dno
and job = 'SALESMAN';

select * from v_join;

--뷰를 사용해서 실제 테이블의 중요한 정보 숨기기.(보안)

select * from emp_copy60;

create view simple_emp
as
select ename, job,dno
from emp_copy60;

select * from simple_emp; --view, 사용자들은 뭔지 모름 (테이블인줄암)
--view를 사용해서 실제 테이블의 중요 컬럼을 숨긴다.

select * from user_views;

-- 뷰를 생성할때 반드시 별칭이름을 사용해야 경우, group by절 할때

create view v_groupping
as
select dno, count(*) groupCount , avg(salary) AVG, sum(salary) SUM
from emp_copy60
group by dno;

select * from v_groupping;

--뷰를 생성할때 as 하위에 select문이 와야한다. 
--insert,update,delete 문은 올수없다.
create view v_error
as
insert into dno --dept_copy60(dno,dname,loc)
values (60,'HR','BUSAN');

-- view에 값을 insert할수 있을까? 컬럼에 제약조건을 만족하면
-- view에도 값을 넣을수 있다.
    --실제 테이블에 값이 insert 된다.
    
create view v_dept
as
select dno, dname
from dept_copy60;

select * from v_dept;

insert into v_dept  --view 에 값을 insert, 제약조건이 일치할때 잘 insert된다.
values (70,'HR');   --dept_copy60에 저장된다.

select * from dept_copy60; 

create or replace view v_dept  -- v_dept가 존재하지 않을 경우 :create
as                             -- 존재할 경우 : replace(수정)
select dname, loc
from dept_copy60;

select * from v_dept;

insert into v_dept
values('SYS','BUSAN');

select * from dept_copy60;

update dept_copy60
set dno = 80
where dno is null;

commit;

alter table dept_copy60
add constraint PK_dept_copy60_dno primary key (dno);

select * from user_constraints
where table_name in ('DEPT_COPY60');

select * from v_dept;

insert into v_dept
values ('HR3','BUSAN2');

select * from user_views;

select * from v_groupping; -- 그룹핑된 view에는 insert할수 없다.

create or replace view v_groupping
as
select dno, count(*) groupCount , round(avg(salary),2) AVG, sum(salary) SUM
from emp_copy60
group by dno;

select * from v_groupping;

drop view v_groupping;

-- insert, update, delete 가 가능한 뷰
    --insert,update,delete가 오면 안되는건 create 시에 as밑에는 올수없고 select만 와야함
create view v_dept10
as
select dno, dname, loc --select 자리에는 select만 와야함
from dept_copy60;

insert into v_dept10
values (90 ,'HR4','BUSAN4');

update v_dept10
set dname = 'HR5', loc = 'BUSAN5'
where dno = 90;

delete v_dept10
where dno = 90;

commit;

select * from v_dept10;

--읽기만 가능한 뷰를 생성. (insert, update, delete 못하도록 설정)
-- 나머진 다 비슷하지만 제일 마지막에 with read only;
create view v_read_only
as
select dno, dname, loc
from dept_copy60 with read only ;

select * from v_read_only; --read only view이기때문에 

insert into v_read_only     --insert,update,delete 불가
values(88,'HR7','BUSAN7');

update v_read_only
set dname = 'HR77', loc = 'BUSAN77'
where dno = 88;

delete v_read_only
where dno =88;

--10 : 테이터 무결성과 제약 조건, 11 뷰

--1. employee 테이블의 구조를 복사하여 emp_sample 란 이름의 테이블을 만드시오. 
--사원 테이블의 사원번호 컬럼에 테이블 레벨로 primary key 제약조건을 지정하되 
--제약조건 이름은 my_emp_pk로 지정하시오. 
create table emp_sample
as
select * from employee;

alter table emp_sample
add constraint my_emp_pk primary key(eno);

--2. department 테이블의 구조를 복사하여 dept_sample 란 이름의 테이블을 만드시오. 
--부서 테이블의 부서번호 컬럼에 레벨로 primary key 제약 조건을 지정하되 
--제약 조건이름은 my_dept_pk로 지정하시오. 
create table dept_sample
as
select * from department;

alter table dept_sample
add constraint my_dept_pk primary key(dno);

select * from user_constraints
where table_name in('EMP_SAMPLE','DEPT_SAMPLE');
--3. 사원 테이블의 부서번호 컬럼에 존재하지 않는 부서의 사원이 배정되지 않도록 
--외래키 제약조건을 지정하되 제약 조건이름은 my_emp_dept_fk 로 지정하시오. 
--[주의 : 위 복사한 테이블을 사용하시오]
alter table emp_sample
add constraint my_emp_dept_fk foreign key(dno) references dept_sample(dno);

--4. 사원테이블의 커밋션 컬럼에 0보다 큰 값만을 입력할 수 있도록 제약 조건을 지정하시오. 
--[주의 : 위 복사한 테이블을 사용하시오]
update emp_sample
set commission = 100
where commission is null or commission = 0;

alter table emp_sample
add constraint my_emp_ck check (commission >0);

select * from emp_sample;
--5. 사원테이블의 웝급 컬럼에 기본 값으로 1000 을 입력할 수 있도록 제약 조건을 지정하시오. 
--[주의 : 위 복사한 테이블을 사용하시오]

alter table emp_sample
modify salary default 1000;

--6. 사원테이블의 이름 컬럼에 중복되지 않도록  제약 조건을 지정하시오. 
--[주의 : 위 복사한 테이블을 사용하시오]
alter table emp_sample
add constraint my_emp_uk unique(ename);


--7. 사원테이블의 커밋션 컬럼에 null 을 입력할 수 없도록 제약 조건을 지정하시오. 
--[주의 : 위 복사한 테이블을 사용하시오]
alter table emp_sample
modify commission constraint my_emp_nn not null;

--8. 위의 생성된 모든 제약 조건을 제거 하시오. 
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

select * from user_constraints
where table_name in('EMP_SAMPLE','DEPT_SAMPLE');

--뷰 문제 

--1. 20번 부서에 소속된 사원의 사원번호과 이름과 부서번호를 출력하는 select 문을 하나의 view 로 정의 하시오.
	--뷰의 이름 : v_em_dno  
create view v_em_dno
as
select eno, ename, dno
from emp_sample
where dno = 20;

select * from v_em_dno;
--2. 이미 생성된 뷰( v_em_dno ) 에 대해서 급여 역시 출력 할 수 있도록 수정하시오. 
create or replace view v_em_dno
as
select eno, ename, dno, salary
from  emp_sample
where dno=20;

--3. 생성된  뷰를 제거 하시오. 
drop view v_em_dno;

--4. 각 부서의 급여의  최소값, 최대값, 평균, 총합을 구하는 뷰를 생성 하시오. 
	--뷰이름 : v_sal_emp
create view v_sal_emp
as
select dno, min(salary) MIN, max(salary) MAX, round(avg(salary)) AVG, sum(salary) SUM
from emp_sample
group by dno;

select * from v_sal_emp;

--5. 이미 생성된 뷰( v_em_dno ) 에 대해서 <<읽기 전용 뷰로>> 수정하시오. 
create or replace view v_em_dno
as
select eno, ename, dno, salary
from  emp_sample 
where dno=20 with read only;

select * from v_em_dno;




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


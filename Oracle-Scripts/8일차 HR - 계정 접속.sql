--���̺� ������ ���ǻ��� : �ٸ� ���̺��� foreign key�� �ڽ��� ���̺���
--�����ϰ� ������ ������ �ȵȴ�.
    --�ٸ� ���̺��� �����ϰ� �ִ��� ������ �����ϴ� �ɼ� : cascade

drop table orders;
drop table member;     --�����߻� : orders ���̺��� id�÷��� member ���̺���id �÷��� �����ϰ� �ִ�.
drop table tb_zipcode; -- �����߻� : member���̺��� zipcode�� tb_zipcode���̺��� zipcode�÷��� �����ϰ� �־
drop table products;

-- �������� �����Ŀ� ���� (Foreign key�� �ٸ��� �����ϰ��־)
alter table member
drop constraint FK_member_zipcode_tb_zipcode;

alter table orders
drop constraint FK_orders_id_member;

alter table orders
drop constraint FK_orders_product_code;

--���� ���� Ȯ��
select * from user_constraints
where table_name = 'MEMBER';

select * from user_constraints
where table_name = 'ORDERS';

select * from user_constraints
where table_name = 'TB_ZIPCODE';

/*
    foreign key�� ���� �Ǵ� ���̺� ����, ������
    1. �ڽ� ���̺� ���� ���� �� �θ� ���̺� ����
    2. foreign key���� ������ ��� ������ ���̺� ����
    3. cascade constraints �ɼ����� ���̺��� ���� ����
*/
drop table member;
--cascade constraints �ɼ��� ����ؼ� ����, <== foreign key���� ������ ���� ������ ����.


drop table member cascade constraints;
drop table tb_zipcode cascade constraints;
drop table products cascade constraints;
drop table orders cascade constraints;
select * from member;

--���̺� ������ (Foreign key) : �θ����̺�(FK�� �����ϴ� ���̺�)��
--���� �����ؾ� �Ѵ�. �ڽ����̺����.
    --�ڽ� ���̺��� �����Ҷ� FK�� ���� �ʰ� ������, �θ����̺� ������,
    --Alter table�� ����ؼ� ���߿� FK�� �־��ش�.
    
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
    
    
--Ʈ����� �߻� : DML : insert update delete ������ �߻� 
                --<== commit;
                


--1. ���� �÷� �߰�
alter table tb_zipcode
add (zip_seq varchar2(30));

--2. �÷� �̸� ����
alter table tb_zipcode
rename column bungi to bunji;
    
alter table tb_zipcode
rename column gugum to gugun;

--3 ������ �ڸ��� ����
alter table tb_zipcode
modify dong varchar2(100);

--4. ���� ���� ��� ��Ȱ��ȭ �ϱ� (��� ��Ȱ��ȭ �ϱ�)
-- <== Bulk insert (�뷮���� insert)�Ҷ� ���������� disable/
    -- ���� �������� ���ؼ� insert�Ǵ� �ӵ��� ������ ������.
alter table tb_zipcode
disable constraint PK_tb_zipcode_zipcode; -- �����߻� :member ���̺��� zipcode �÷��� �� ���̺��� �����ϰ� �ֱ� ������

alter table tb_zipcode
disable constraint PK_tb_zipcode_zipcode cascade; --member ���̺��� fk�� ����� �������ǵ� �Բ� disable

select * from user_constraints
where table_name in('MEMBER','TB_ZIPCODE');

select * from user_constraints
where table_name ='TB_ZIPCODE';


select constraint_name, table_name, status from user_constraints
where table_name in('MEMBER','TB_ZIPCODE');

select * from tb_zipcode;

truncate table tb_zipcode; -- ������ ���ڵ常 ��� ���� (������ ��緹�ڵ����)

delete tb_zipcode; -- ������ ���ڵ常 ��� ���� : ������ ������(�뷮�� ���)
commt;

--���� ���� Ȱ��ȭ �ϱ�
alter table member
enable novalidate constraint FK_member_zipcode_tb_zipcode;

alter table tb_zipcode
enable novalidate constraint PK_tb_zipcode_zipcode;

select constraint_name, table_name, status from user_constraints
where table_name in('MEMBER','TB_ZIPCODE');

select count(*) from tb_zipcode;

--zip_seq �÷��� ������ ����� �ȵ� ������ ���캸��, ����� ���ĵǵ��� �غ���
    --���� ���� �������� ��µ�, to_number�� ���ڷ� ����ȯ�� ����
select * from tb_zipcode
order by to_number(zip_seq);

truncate table tb_zipcode;

select constraint_name, table_name, status from user_constraints
where table_name in('MEMBER','TB_ZIPCODE');


desc tb_zipcode;

select * from tb_zipcode
where zip_seq = '3';

/*���� ���� ���� (Alter Table) : ������ ���̺� ���� ������ ����*/

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

--���̺��� �����ϸ� ���ڵ常 ���簡 �ȴ�. ���̺��� ���� ������ ����Ǿ� ���� �ʴ´�.
    --Alter Table�� ����ؼ� ���������� ����
    
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

--NOT NULL ���� ���� �߰�. (������ �ٸ���. add��ſ� modify�� ���)
    --null�� ������ �̹� �����ϴ� �÷��� not nulló�� ���ټ� ����
    --���� null�� ���� ó�����ְ� not nulló�� ������Ѵ�.

desc employee;
desc emp_copy50; --primary key�� not null�� ���� ���� �ʾƵ� �ڵ����� �Ҵ�
desc department;
desc dept_copy50; --not null���� �ʾ����� primary key ���� ������ �Ҵ�


--������ null�� ���ִ� ������ not null�÷����� ���� �� �� ����.

select ename from employee
where ename is null;

alter table emp_copy50
modify ename not null;

alter table emp_copy50
modify ename constraint NN_emp_copy50_ename not null;

    -- commission �÷��� not null �Ҵ� �ϱ�
    -- null�� �� �ִ� ��� null�� ó������� �Ѵ�.
    -- update ���̺�� set �÷��� = �ٲܰ� where �÷��� is null  
select * from emp_copy50;

alter table emp_copy50
modify commission constraint NN_emp_copy50_commission not null;

update emp_copy50
set commission = 0
where commission is null;

-- Unique ���� ���� �߰� : �÷��� �ߺ��� ���� ������ ������ ����(�Ҵ� �Ұ�)
    --
    
select * from emp_copy50;

select ename , count(*)
from emp_copy50
group by ename
having count(*) > 1;

alter table emp_copy50
add constraint UK_emp_copy50_ename unique (ename);

desc emp_copy50;

--check ���� ���� �߰� : ������ �����ϴ°��� check���� ������ ����Ǹ�
--���� ����������� �����Ҽ� �ִ�?

select * from emp_copy50;

alter table emp_copy50
add constraint CK_emp_copy50_salary check (salary >0 and salary <10000);

--default ���� ���� �߰� <���������� �ƴ�: �������� �̸��� �Ҵ��� �� ����.
    --���� ���� ���� ��� default ���� �� 
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

/*���� ���� ���� : Alter Table ���̺�� drop*/

--Primary key ����
alter table emp_copy50 --���� ���� ���ŵ�.
drop primary key; 

alter table dept_copy50 --���� �߻� : foreign key�� �����ϱ� ������ ���� �ȵ�.
drop primary key;

alter table dept_copy50 --foreign key�� ���� �����ϰ� primary key ����
drop primary key cascade;

select * from user_constraints
where table_name in ( 'EMP_COPY50','DEPT_COPY50');

-- not null �÷� ���� �ϱ� :<< ���� ���� �̸����� ����
alter table emp_copy50
drop constraint NN_EMP_COPY50_ENAME;

--Unique, check  �������� ���� << ���� ���� �̸����� ����
alter table emp_copy50
drop constraint UK_EMP_COPY50_ENAME;

alter table emp_copy50
drop constraint CK_EMP_COPY50_SALARY;

alter table emp_copy50
drop constraint NN_EMP_COPY50_COMMISSION;

--default �� null ��� �÷��� default nul�� ����: default ���� ������ ���� �ϴ� ��
alter table emp_copy50
modify hiredate default null;

select * from emp_copy50;
/*  ���� ���� disable/enable
    <= ���������� ��� ���� ŵ.
    �뷮(Bulk Insert)���� ���� ���̺� �߰��Ҷ� ���ϰ� ���� �ɸ���. disable==> enable
    index�� �����Ҷ� ���ϰ� ���� �ɸ���. disable  ==> enable

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

------------------8���� - ��, ������, �ε���
/*
    ��(view) :������ ���̺��� ��(view)�� �Ѵ�.
        --���̺��� ������ ���� ������ �ִ�.
        --��� ������ ���� ������ �ʴ´�. ���� �ڵ常 �� �ִ�.
        --�並 ����ϴ� ���� :
            1. ������ ���ؼ� : �������̺��� Ư�� �÷��� �����ͼ�
                ���� ���̺��� �߿� �÷��� ���� �� �ִ�.
            2. ������ ������ �並 �����ؼ� ���ϰ� ��� ����
                (������ JOIN ����)
        --��� �Ϲ������� select ������ �´�. (����)
        --��� insert, update, delete ������ �� �� ����.
        --�信 ���� insert�ϸ� ���� ���̺� ������ �ȴ�.
            ���� ���̺��� ���������� �� �����ؾ� �ȴ�.
        --�信 ���� insert�� ��� ���� ���̺��� �������ǿ�
            ���� inset�� ���� �ְ� �׷��� �������� �ִ�.
        --�׷��Լ��� ������ view���� insert�� �� ����.
        
        
*/

create table dept_copy60
as
select * from department;

create table emp_copy60
as
select * from employee;

-- �� ����
create view V_emp_job
as
select eno, ename, dno, job
from emp_copy60
where job like 'SALESMAN';

--�� ���� Ȯ��
select * from user_views;

--���� ���� (select * from ���̸�)
select * from v_emp_job;

--������ join ������ �信 �����ϱ�

create view v_join
as
select e.dno, ename, job,dname, loc
from employee e, department d
where e.dno = d.dno
and job = 'SALESMAN';

select * from v_join;

--�並 ����ؼ� ���� ���̺��� �߿��� ���� �����.(����)

select * from emp_copy60;

create view simple_emp
as
select ename, job,dno
from emp_copy60;

select * from simple_emp; --view, ����ڵ��� ���� �� (���̺����پ�)
--view�� ����ؼ� ���� ���̺��� �߿� �÷��� �����.

select * from user_views;

-- �並 �����Ҷ� �ݵ�� ��Ī�̸��� ����ؾ� ���, group by�� �Ҷ�

create view v_groupping
as
select dno, count(*) groupCount , avg(salary) AVG, sum(salary) SUM
from emp_copy60
group by dno;

select * from v_groupping;

--�並 �����Ҷ� as ������ select���� �;��Ѵ�. 
--insert,update,delete ���� �ü�����.
create view v_error
as
insert into dno --dept_copy60(dno,dname,loc)
values (60,'HR','BUSAN');

-- view�� ���� insert�Ҽ� ������? �÷��� ���������� �����ϸ�
-- view���� ���� ������ �ִ�.
    --���� ���̺� ���� insert �ȴ�.
    
create view v_dept
as
select dno, dname
from dept_copy60;

select * from v_dept;

insert into v_dept  --view �� ���� insert, ���������� ��ġ�Ҷ� �� insert�ȴ�.
values (70,'HR');   --dept_copy60�� ����ȴ�.

select * from dept_copy60; 

create or replace view v_dept  -- v_dept�� �������� ���� ��� :create
as                             -- ������ ��� : replace(����)
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

select * from v_groupping; -- �׷��ε� view���� insert�Ҽ� ����.

create or replace view v_groupping
as
select dno, count(*) groupCount , round(avg(salary),2) AVG, sum(salary) SUM
from emp_copy60
group by dno;

select * from v_groupping;

drop view v_groupping;

-- insert, update, delete �� ������ ��
    --insert,update,delete�� ���� �ȵǴ°� create �ÿ� as�ؿ��� �ü����� select�� �;���
create view v_dept10
as
select dno, dname, loc --select �ڸ����� select�� �;���
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

--�б⸸ ������ �並 ����. (insert, update, delete ���ϵ��� ����)
-- ������ �� ��������� ���� �������� with read only;
create view v_read_only
as
select dno, dname, loc
from dept_copy60 with read only ;

select * from v_read_only; --read only view�̱⶧���� 

insert into v_read_only     --insert,update,delete �Ұ�
values(88,'HR7','BUSAN7');

update v_read_only
set dname = 'HR77', loc = 'BUSAN77'
where dno = 88;

delete v_read_only
where dno =88;

--10 : ������ ���Ἲ�� ���� ����, 11 ��

--1. employee ���̺��� ������ �����Ͽ� emp_sample �� �̸��� ���̺��� ����ÿ�. 
--��� ���̺��� �����ȣ �÷��� ���̺� ������ primary key ���������� �����ϵ� 
--�������� �̸��� my_emp_pk�� �����Ͻÿ�. 
create table emp_sample
as
select * from employee;

alter table emp_sample
add constraint my_emp_pk primary key(eno);

--2. department ���̺��� ������ �����Ͽ� dept_sample �� �̸��� ���̺��� ����ÿ�. 
--�μ� ���̺��� �μ���ȣ �÷��� ������ primary key ���� ������ �����ϵ� 
--���� �����̸��� my_dept_pk�� �����Ͻÿ�. 
create table dept_sample
as
select * from department;

alter table dept_sample
add constraint my_dept_pk primary key(dno);

select * from user_constraints
where table_name in('EMP_SAMPLE','DEPT_SAMPLE');
--3. ��� ���̺��� �μ���ȣ �÷��� �������� �ʴ� �μ��� ����� �������� �ʵ��� 
--�ܷ�Ű ���������� �����ϵ� ���� �����̸��� my_emp_dept_fk �� �����Ͻÿ�. 
--[���� : �� ������ ���̺��� ����Ͻÿ�]
alter table emp_sample
add constraint my_emp_dept_fk foreign key(dno) references dept_sample(dno);

--4. ������̺��� Ŀ�Լ� �÷��� 0���� ū ������ �Է��� �� �ֵ��� ���� ������ �����Ͻÿ�. 
--[���� : �� ������ ���̺��� ����Ͻÿ�]
update emp_sample
set commission = 100
where commission is null or commission = 0;

alter table emp_sample
add constraint my_emp_ck check (commission >0);

select * from emp_sample;
--5. ������̺��� ���� �÷��� �⺻ ������ 1000 �� �Է��� �� �ֵ��� ���� ������ �����Ͻÿ�. 
--[���� : �� ������ ���̺��� ����Ͻÿ�]

alter table emp_sample
modify salary default 1000;

--6. ������̺��� �̸� �÷��� �ߺ����� �ʵ���  ���� ������ �����Ͻÿ�. 
--[���� : �� ������ ���̺��� ����Ͻÿ�]
alter table emp_sample
add constraint my_emp_uk unique(ename);


--7. ������̺��� Ŀ�Լ� �÷��� null �� �Է��� �� ������ ���� ������ �����Ͻÿ�. 
--[���� : �� ������ ���̺��� ����Ͻÿ�]
alter table emp_sample
modify commission constraint my_emp_nn not null;

--8. ���� ������ ��� ���� ������ ���� �Ͻÿ�. 
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

--�� ���� 

--1. 20�� �μ��� �Ҽӵ� ����� �����ȣ�� �̸��� �μ���ȣ�� ����ϴ� select ���� �ϳ��� view �� ���� �Ͻÿ�.
	--���� �̸� : v_em_dno  
create view v_em_dno
as
select eno, ename, dno
from emp_sample
where dno = 20;

select * from v_em_dno;
--2. �̹� ������ ��( v_em_dno ) �� ���ؼ� �޿� ���� ��� �� �� �ֵ��� �����Ͻÿ�. 
create or replace view v_em_dno
as
select eno, ename, dno, salary
from  emp_sample
where dno=20;

--3. ������  �並 ���� �Ͻÿ�. 
drop view v_em_dno;

--4. �� �μ��� �޿���  �ּҰ�, �ִ밪, ���, ������ ���ϴ� �並 ���� �Ͻÿ�. 
	--���̸� : v_sal_emp
create view v_sal_emp
as
select dno, min(salary) MIN, max(salary) MAX, round(avg(salary)) AVG, sum(salary) SUM
from emp_sample
group by dno;

select * from v_sal_emp;

--5. �̹� ������ ��( v_em_dno ) �� ���ؼ� <<�б� ���� ���>> �����Ͻÿ�. 
create or replace view v_em_dno
as
select eno, ename, dno, salary
from  emp_sample 
where dno=20 with read only;

select * from v_em_dno;




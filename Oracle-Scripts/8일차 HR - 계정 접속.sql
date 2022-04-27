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


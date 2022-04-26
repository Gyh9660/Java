--7���� -- ��������

--���̺� ���� : ���̺��� ��ü�� ������.
    --���̺��� �����ϸ�, �÷��� ���ڵ常 ���簡 ��.
    --���̺� �Ҵ�� ���������� ������� �ʴ´�. (Alter Table�� ����ؼ� �Ҵ��ؾ��Ѵ�.)
    --���� ���� : �÷��� �Ҵ�Ǿ� �ִ�. ���Ἲ�� üũ
            -- NOT NULL, Primary Key, Unique, Foreign Key, check, default


--���̺��� ��ü ���ڵ带 ����    
create table dept_copy
as
select * from department; --select �ؿ� ���̺��� ���� (as�ְ�)

desc department;
desc dept_copy;

select * from dept_copy;

create table emp_copy
as
select * from employee;

select * from emp_copy;

--���̺� ���� : Ư�� �÷��� �����ϱ�
create table emp_second
as
select eno, ename, salary, dno from employee;

select * from emp_second;

--���̺� ���� : ������ ����ؼ� ���̺� ����
create table emp_third
as
select eno, ename , salary
from employee
where salary > 2000;

select * from emp_third;

--���̺� ���� : �÷����� �ٲپ ����
create table emp_forth
as
select eno �����ȣ, ename �����, salary ����
from employee;

select * from emp_forth;

select �����ȣ, �����, ���� from emp_forth; -- ���̺��, �÷���, <==���� ����� ����.

--���̺� ���� : ������ �̿��ؼ� ���̺� ���� : �ݵ�� ��Ī�̸��� ����ؾ� �Ѵ�.
create table emp_fifth
as
select eno, ename, salary*12 as salary from employee;

select * from emp_fifth;

--���̺� ���� : ���̺� ������ ����, ���ڵ�� �������� �ʴ´�.

create table emp_sixth
as
select * from employee
where 0=1 ;-- where ���� : false �� ���� => ���̺� ����������, ���ڵ庹�� x

select * from emp_sixth;
desc emp_sixth;

-- ���̺� ���� : Alter Table
create table dept20
as
select * from department;

desc dept20;
select * from dept20;

--������ ���̺��� �÷��� �߰� ��. ���� : �ݵ�� �߰��� �÷��� null�� ����ؾ� �Ѵ�.
Alter table dept20
add (birth date);

alter table dept20
add (email varchar2(100));

alter table dept20
add (address varchar2(200));

--�÷��� �ڷ����� ���� :
desc dept20;

alter table dept20
modify dname varchar2 (100);

alter table dept20
modify dno number(4);

alter table dept20
modify address Nvarchar2(200);

--Ư�� �÷� ���� : �����ð� �ܿ� �۾�. ���ϰ� ���� �ɸ��� �ִ�.

desc dept20;

Alter table dept20
drop column birth;

select * from dept20;

alter table dept20
drop column email;

-- �÷��� �����ÿ� ���ϰ� ���� �߻��� ��.
    --set unused : Ư�� �÷��� ��� ����(������), �߰��� ����,
    
alter table dept20
set unused (address);

desc dept20;

alter table dept20  --�߰��� ��� ������ �÷��� ����
drop unused column; --������� �ʴ� �÷��� �����ϰڴ�.

/*�÷� �̸� ����*/
Alter table dept20
rename column  LOC to LOCATIONS;

desc dept20;

alter table dept20
rename column DNO to D_Number;

-- ���̺� �̸� ����
rename dept20 to dept30;

desc dept30;

--���̺� ����
drop table dept30;

/*
    DDL : Create (����) , Alter ( ����) , Drop (����)
        <<��ü>>
            ���̺�,��,�ε���,Ʒ��,������,�Լ�,�������ν���....
*/
/*
    DML : Insert (���ڵ� �߰�) , Update (���ڵ� ����), Delete (���ڵ� ����)
        <<���̺��� �� (���ڵ� ,�ο�) >>
*/
/*
    DQL : Select 
*/
/*
    ���̺��� ��ü �����̳� ���̺� ������
    1. delete   : ���̺��� ���ڵ带 ����, where������ ��� ���ڵ带 ����
    2. truncate : ���̺��� ���ڵ带 ����, �ӵ��� ������ ������. <<���� ����>>
    3. drop     : ���̺� ��ü�� ����
*/

create table emp30
as
select * from employee;

select * from emp10;

-- emp10 : delete�� ����ؼ� ����
    delete emp10;
    commit;
    select * from emp10;
-- emp20 : truncate�� ����ؼ� ����
    truncate table emp20;

    select * from emp20;

-- emp30 : drop�� ����ؼ� ����
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
values(1111,'�ǿ���',3000,30,sysdate);

select * from emp_insert;
desc emp_insert;

--3-- 
insert into emp_insert(emp_id,name,sal,dept_id,hiredate)
values(2222,'���ػ�',3000,20,to_date(20220425,'YYYYMMDD'));

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
    ������ ���� : �ý����� ���� ������ ����� �ִ� ���̺�
        user_   : �ڽ��� ������ ���� ��ü������ ���
        all_    : �ڽ��� ������ ������ ��ü�� ������ �ο� ���� ��ü ������ ���
        dba_    : ������ ���̽� �����ڸ� ���� ������ ��ü ������ ���.
*/

show user;
select * from user_tables;      --����ڰ� ������ ���̺� ���� ���
select table_name from user_tables;
select * from user_views;       --����ڰ� ������ �信 ���� ���� ���
select * from user_indexes;     --����ڰ� ������ �ε��� ����
select * from user_constraints; --���� ���� Ȯ��
select * from user_constraints
where table_name = 'EMPLOYEE';
select * from user_sequences;

select * from all_tables; -- ��� ���̺��� ���, ������ �ο� ���� ���̺�
select * from all_views;

select * from dba_tables; --������ ���������� ���� ����
/*
    ���� ���� : ���̺��� ���Ἲ�� Ȯ�� �ϱ� ���ؼ� �÷��� �ο��Ǵ� ��Ģ.
        1. Primary Key
        2. Unique
        3. not null
        4. CHECK
        5. Foreign Key
        6. Default
*/
--1 Primary Key : �ߺ��� ���� ���� �� ����.

-- a . ���̺� ������ �÷��� �ο�
    --���� ���� �̸� : �������� ���� ��� : Oracle ���� ������ �̸����� ����,
        --���� ������ �����Ҷ� �������� �̸��� ����ؼ� ����.
        --PK_customer01_id : Primary key ��������, customer01���̺�, id �÷��� ������
        --NN_customer01_pwd : Not Null ��������, customer01 ���̺�, pwd �÷���

    create table customer01 ( --constraint PK_customer01_id, �������� �̸�
    id varchar2(20) not null constraint PK_customer01_id Primary key,
    pwd varchar2(20) constraint NN_customer01_pwd not null ,
    name varchar2(20) constraint NN_customer01_name not null ,
    phone varchar2(30) null,
    address varchar2(100) null
    );
    
    select * from user_constraints
    where table_name = 'CUSTOMER01'; --db�������� �빮�ڷ� ���⋚���� �ҹ��ڷ� ó�� x�빮�ڷ� ã�ƾ���
   
    create table customer02 (  --constraint PK_customer01_id, �������� �̸�
    id varchar2(20) not null Primary key,
    pwd varchar2(20) not null ,
    name varchar2(20) not null ,
    phone varchar2(30) null,
    address varchar2(100) null
    );
    select * from user_constraints
    where table_name = 'CUSTOMER02';

--���̺��� �÷� ������ ���� ���� �Ҵ�.
 create table customer03 ( 
    id varchar2(20) not null ,
    pwd varchar2(20) constraint NN_customer03_pwd not null ,
    name varchar2(20) constraint NN_customer03_name not null ,
    phone varchar2(30) null,
    address varchar2(100) null,
    constraint PK_customer03_id Primary key (id)
    );
    
/*
    foreign key (����Ű) : �ٸ� ���̺�(�θ�)�� primary key, unique �÷��� �����ؼ� ���� �Ҵ�.
    check : �÷��� ���� �Ҵ��Ҷ� check�� �´� ���� �Ҵ�.
    
*/

--�θ� ���̺�
    Create table parentTbl(
    name varchar2(20),
    age number(3) constraint CK_ParentTbl_age check (AGE>0 and AGE <200),
    gender varchar2(3) constraint CK_ParentTbl_gender check (gender IN ('M','W')),
    infono number constraint PK_ParentTbl_infono Primary key
    );
    
desc parentTbl;    
select * from user_constraints
where table_name = 'PARENTTBL';
select * from ParentTbl;

insert into ParentTbl
values ('ȫ�浿', 30,'M',1);

insert into ParentTbl
values ('��ʶ�',300,'K',1); --���� �߻� : 300 (check ����), K (check����) ,1 (primary key ����)

insert into ParentTbl
values ('��ʶ�',50,'M',2);

--�ڽ� ���̺�
Create table ChildTbl (
    id varchar2(40) constraint PK_ChildTbl_id Primary key,
    pw varchar2(40),
    infono number,
    constraint FK_ChildTbl_infono foreign key (infono) references ParentTbl(infono)
    );

insert into ChildTbl
values ('aaa','1234',1);

insert into ChildTbl
values ('bbb','1234',2);

commit;

select * from ChildTbl;

--�θ����̺�
create table ParentTbl2 (
    dno number(2) not null Primary key ,
    dname varchar2 (50),
    ioc varchar2 (50)
    );

insert into ParentTbl2
values(10,'SALES','SEOUL');

--�ڽ� ���̺�
create table ChildTbl2(
    no number not null,
    ename varchar(50),
    dno number(2) not null,
    foreign key (dno) references ParentTbl2(dno)
    );

insert into ChildTbl2
values(1,'Park','10');

select * from ChildTbl2;

--default ���� ���� : ���� �Ҵ� ���� ������ default ���� �Ҵ�.
Create Table emp_sample01(
    eno number(4) not null primary key,
    ename varchar(50),
    salary number(7,2) default 1000
    );
    
    select * from emp_sample01;
  
    insert into emp_sample01
    values (111,'ȫ�浿', 1500);

--default �÷��� ���� �Ҵ����� �ʴ� ���. default �� �Ҵ�� ���� ����
    insert into emp_sample01(eno, ename)
    values (2222,'ȫ���');

    insert into emp_sample01
    values (3333,'������',default);

Create Table emp_sample02(
    eno number(4) not null primary key,
    ename varchar(50) default 'ȫȫȫ',
    salary number(7,2) default 1000
    );
insert into emp_sample02 (eno)
values (10);

select * from emp_sample02;

insert into emp_sample02
values (20, default,default);

/*
    Primary Key, Foreign Key, Unique, Check, Default, Not Null
*/

create table member10 (
    no number not null constraint PK_member10_no Primary key,
    name varchar(50) constraint NN_member10_name Not Null,
    birthday date default sysdate,
    age number(3) check (age > 0 and age <150),
    gender char(1) check (gender in ('M', 'W')),
    dno number(2) Unique
    );

insert into member10
values(1, 'ȫ�浿', default, 30,'M',10);

insert into member10
values(2, '������', default, 30,'M',20); -- 300 / K = check constraint üũ ���� , 10 -unique����

select * from member10;

create table orders10 (
    no number not null primary key,
    p_no varchar2(100) not null,
    p_name varchar2(100) not null,
    price number check (price >10),
    phone varchar2(100) default '010-0000-0000',
    dno number(2) not null,
    foreign key (dno) references member10(dno)
    );
    
insert into orders10
values (1, '11111', '������' , 5000, default,10);

select * from orders10;

drop table member;
drop table orders;

create table member(    --������ ȸ�������� ����
    id varchar2(20) not null constraint PK_member_id primary key, --�� ���̵�
    pwd varchar2(20),                                  --�� ��ȣ
    name varchar2(50),                                 --�� �̸�
    zipcode varchar2(7),                               --���� ��ȣ
    address varchar2(20),                              --�ּ�
    tel varchar2(13),                                  --����ó
    indate date default sysdate,                       --������
    constraint FK_member_zipcode foreign key (zipcode) references tb_zipcode(zipcode)
    );
    
    select * from member;
    
    insert into member
    values ('aaaa','1111','ȫ�浿','333-444','GASAN','010-0000-0000',default);
    
    insert into member
    values ('bbbb','1111','ȫ����','444-555','DOKSAN','010-1111-1111',default);
    
    insert into member
    values ('cccc','1111','ȫ���','555-666','GASAN','010-2222-2222',default);
    
    commit;
    
create table tb_zipcode(    --�����ȣ ������ ����
    zipcode varchar2(7) not null constraint PK_tb_zipcode_zipcode primary key, --�����ȣ
    sido varchar2(30),                                                         --�õ�
    gugum varchar2(30),                                                        --����
    dong varchar2(30),                                                         --��
    bungi varchar2(30)                                                         --����
    );
    delete tb_zipcode;
    delete member;
    delete orders;
    rollback;
    select * from tb_zipcode;
    
    Alter table tb_zipcode
    rename column  gogum to GOGUN;
    
    Alter table tb_zipcode
    add (ZIP_SEQ varchar2(6));
    
    Alter table tb_zipcode
    rename column  bungi to BUNJI;
    
    Alter table tb_zipcode
    modify dong varchar(100);
    
    Alter table tb_zipcode
    drop constraint PK_tb_zipcode_zipcode;
  
    Alter table member
    drop constraint FK_member_zipcode;
    
    insert into tb_zipcode
    values('333-444','SEOUL','GEUMCHEON','GASAN','111',null);
    
    insert into tb_zipcode
    values('444-555','SEOUL','GEUMCHEON','DOKSAN','112','113');
    
    insert into tb_zipcode
    values('555-666','SEOUL','GEUMCHEON','GASAN','153','114');
    
    commit;
    
create table products(  --��ǰ ������ ����
    product_code varchar2(20) not null constraint PK_products_product_code primary key, --��ǰ �ڵ�
    product_name varchar2(100),                                                         --��ǰ��
    product_kind char(1),                                                               --��� ��ǰ ����
    product_price1 varchar2(10),                                                        --��ǰ����
    product_price2 varchar2(10),                                                        --��ǰ�ǸŰ�
    product_content varchar2(1000),                                                     --��ǰ����
    product_image varchar2(50),                                                         --��ǰ�̹�����
    sizeSt varchar2(5),                                                                 --������ ����
    sizeEt varchar2(5),                                                                 --������ ��
    product_quantity varchar2(5),                                                       --����
    useyn char(1),                                                              --��ǰ ��� ����(�������)
    indate date                                                                 --�����
    );
    
    select * from products;
    
    insert into products
    values ('0001','���','1','1000','3000','RED APPLE','APPLE','1','5','10','1',sysdate);
    
    insert into products
    values ('0002','������','1','1000','5000','ORANGE','ORANGE','1','6','15','1',sysdate);
    
    insert into products
    values ('0003','�ٳ���','1','1200','11000','BANANA','BANANA','1','10','15','1',sysdate);
    
    commit;
    
create table orders ( --�ֹ������� ����
    o_seq number(10) not null constraint PK_order_o_seq primary key,    --�ֹ� �Ϸ� ��ȣ
    product_code varchar2(20),                                          --�ֹ� ��ǰ �ڵ�
    id varchar2(16),                                                    --�ֹ��� ���̵�
    product_size varchar2(5),                                           --�ֹ� ��ǰ ������
    quantity varchar2(5),                                               --�ֹ� ����
    result char(1),                                                     --�ֹ� ó�� ����
    indate date,                                                        --�ֹ���
    constraint FK_orders_product_code foreign key (product_code) references products(product_code),
    constraint FK_orders_id foreign key (id) references member(id)
    );
    
    select * from orders;
    
    insert into orders
    values('1234','0001','aaaa','5','10','1',sysdate);
    
    insert into orders
    values('1235','0002','bbbb','5','12','1',sysdate);
    
    insert into orders
    values('1236','0003','cccc','5','14','1',sysdate);
    
    commit;
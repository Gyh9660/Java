--08 ���̺� ���� ��������

--1. dept���̺� ����
select * from user_tables --������ ���� : �ý����� ���� ������ ���
where table_name = 'DEPT';

drop table dept;

create table dept (
    dno number(2) not null,
    dname varchar2(14) null,
    loc varchar2(13) null
    );
    
--2. emp���̺� ����

drop table emp;

create table emp(
    eno number(4) not null,
    ename varchar2(10) null,
    dno number(2) null
    );
    --DB ������ ����, null��� ���ΰ� �ٸ��� ���õǾ������� �ִ�.
--3. emp ���̺��� dname�÷��� ũ�⸦ 10->25
alter table emp
modify ename varchar(25);

desc emp;

select length (ename) from employee -- ename�� ���ڰ� ���ִ��� Ȯ��
where length (ename) >5;


--4. employee �����ؼ� employee2���� �����ȣ,�̸�,�޿�,�μ���ȣ
create table employee2
as
select eno,ename,salary,dno
from employee;

select * from employee2; 
--���̺� ����ÿ� �������� ���� �ȵ�
    --primary key, unique, not null, default,check, foreign key....
    
--5 .emp ����
drop table emp;

-- 6. employee2 -> emp
rename employee2 to emp;

desc employee2;
desc emp;

--7 dept ���� dname ����
select * from dept;

--���� ��ϴ� �ý��ۿ����� ���ڵ尡 ���� ���ִ�. �÷����Ž� ���ϰ� ���̹߻�(�߰�)

alter table dept
drop column dname;

--8 dept loc unused <-- ������ �÷��� ���Ҽ�ȭ (�����ð���)

alter table dept
set unused column loc;

alter table dept
set unused (loc);

--9. unused ���� (�߰��� �۾�)
alter table dept
drop unused columns;  -- column X columns O 

--09 ������ ���۰� Ʈ�����

--1 emp �������� emp_insert �����̺�

select * from emp;

drop table emp_insert;

create table emp_insert
as
select * from emp
where 0=1; --������ false�� ����


--2 emp_insert �� �����߰� sysdate�� �Ի��� ǥ��

--���̺� �÷��� �߰��Ҷ� null ����ϸ鼭 �߰��ؾ� �Ѵ�.

alter table emp_insert
add hiredate date;

desc emp_insert;

select * from emp_insert;

insert into emp_insert
values(1111,'�ǿ���',3000,10,sysdate);

commit;
--3 emp_insert ���̺� ����� �߰� hiredate to_date�� ����

insert into emp_insert
values(1122,'ȫ�浿',3000,10,to_date(sysdate -1,'YY/MM/DD'));
commit;

--4 employee �������� ���� emp_copy
drop table emp_copy;
create table emp_copy
as
select * from employee;

--5. �����ȣ 7788 ����� �μ���ȣ 10���� ���� copy���
select * from emp_copy;

update emp_copy
set dno = 10
where eno = 7788; --���� where �������� �ٹٲ� (update�� delete��)

commit; --Ʈ����� ó��

--6 �����ȣ�� 7788 ����� ������ �� �޿��� �����ȣ 7499�� �������� �޿��� ��ġ�ϵ��� ����
select * from emp_copy where eno = 7788 or eno = 7499;

update emp_copy
set job = (select job from emp_copy where eno = 7499) ,
salary = (select salary from emp_copy where eno = 7499)
where eno = 7788;
commit;
--7 7369�� ������ ������ ����� ��ȣ�� 7369�� �μ���ȣ�� ����
select * from emp_copy where eno =7369;

update emp_copy
set dno = (select dno from emp_copy where eno = 7369)
where job = (select job from emp_copy where eno = 7369);
commit;

--8. department ���� ���� ���� dept_copy����
drop table dept_copy;

create table dept_copy
as
select * from department;

--9 �μ����� reserach�� �μ�����
select * from dept_copy;
select * from department;
delete dept_copy
where dname = 'RESEARCH';
commit;


--10 �μ� 10 40�� �μ�����
delete dept_copy
where dno in (10,40);
commit;

--10 ������ ���Ἲ�� ���� ����

--1 employee �������� emp_sample , �����ȣ�� primary key, my_emp_pk

--���̺� �����Ҷ� ���������� ������� �ʴ´�. alter table�� ����ؼ� �־������.
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

--2  departmnet ���̺� ���� ���� dept_sample �μ���ȣ �÷��� primary key my_dept_pk
create table dept_sample
as
select * from department
where 0=1;

alter table dept_sample
add constraint my_dept_pk primary key(dno);

select * from user_constraints
where table_name in ('EMP_SAMPLE','DEPT_SAMPLE');

--3. ��� ���̺��� �μ���ȣ �÷��� �������� �ʴ� �μ��� ����� �������� �ʵ��� �ܷ�Ű �������� my_emp_dept_fk
alter table emp_sample
add constraint my_emp_dept_fk foreign key(dno) references dept_sample(dno);

--4 ������̺� Ŀ�̼� �÷��� 0���� ū���� �Է��Ҽ� �ֵ��� ����
alter table emp_sample
add constraint my_emp_ck check (commission >0);

select * from user_constraints
where table_name in ('EMP_SAMPLE','DEPT_SAMPLE');

--5 ������̺� ���� �÷��� �⺻�� 1000���� ����
-- modify = dafault , not null
alter table emp_sample
modify salary default 1000;

--6 ������̺� �̸��÷��� �ߺ� ���� �ʵ��� �������� ����

select * from user_constraints
where table_name in ('EMP_SAMPLE','DEPT_SAMPLE');

alter table emp_sample
add constraint my_emp_uk unique(ename);

--7 ������̺��� Ŀ�Լǿ� null�� �Է��Ҽ� ������ ��������
alter table emp_sample
modify commission constraint my_emp_nn not null;

--8 ������ ��� �������� ����

select * from user_constraints
where table_name in ('EMP_SAMPLE','DEPT_SAMPLE');

--���� ������ ���Ž� : foreign key �����ϸ� ���Ű� �ȵȴ�.
    --1. foreign key�� ���� ������ primary key �����ϴ� ���
    --2. primary key �����Ҷ� cascade �ɼ��� �༭ foreign key ���������� primary key����
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

--10 �乮��

--1. 20�� �μ��� �Ҽӵ� ����ǻ����ȣ,�̸�,�μ���ȣ�� ����ϴ� select���� �ϳ���view�� ����
    --���� �̸� :v_em_dno
    --�� : ������ ���̺�, select ���� �ü� �ִ�.
        --������ ���ؼ� - ���� ���̺��� �÷��� ����� �ֵ�.
        --���Ǽ��� ���ؼ� : ������ ������ view�� �����ϸ� , ������join
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
    
--�����
select * from v_em_dno;

--2. �̹� ������ �� �� ���ؼ� �޿� ����Ҽ��ֵ��� ����

create or replace view v_em_dno
as
select eno, ename, dno, salary
from emp_view
where dno =20;

--3. ������ �� ����
drop view v_em_dno;

--4. �� �μ��� �޿��� �ּҰ�, �ִ밪,���,������ ���ϴº���� ����:��Ī�̸� ���
--���̸� v_sal_emp
create view v_sal_emp
as
select dno , min(salary) MIN, max(salary) MAX, round(avg(salary)) AVG, sum(salary) SUM
from emp_view
group by dno;

select * from v_sal_emp;

--5.  �̹� ������ �並 �б������� ����
create or replace view v_sal_emp
as
select dno , min(salary) MIN, max(salary) MAX, round(avg(salary)) AVG, sum(salary) SUM
from emp_view
group by dno with read only;


-------9���� ������ �ε���------------------
/*
    �ñǽ� : �ڵ� ��ȣ �߻��� 
        -- �ѹ� ���� �߻��Ǹ� (��ȣ�� �ڵ� �߻��Ǹ�) �ڷ� �ǵ��� �� ����.(������ �ٽ� �����ؾ� �Ѵ�.)
        -- primary key �÷��� ��ȣ�� �ڵ����� �߻���Ű�� ���ؼ� ���
        -- primary key Ű�÷����� �ߺ����� �ʴ� ������ ���� �Ű��� �Ƚᵵ �ȴ�.
*/
--�ʱⰪ : 10 , ������ : 10
create sequence sample_seq
    increment by 10   -- ������
    start with 10;    -- �ʱⰪ

--sequence ������ ����ϴ� ������ ����
select * from user_sequences;

select sample_seq.nextval from dual; -- �������� �������� ���
select sample_seq.currval from dual; -- �������� ���簪�� ���

--�ʱⰪ 2, ������ : 2 
create sequence sample_seq2
    increment by 2
    start with 2
    nocache;     --ĳ�ø� ������� �ʰٴ�. (RAM) -- ������ ���ϸ� �ٿ��ټ� �ִ�. (ĳ�û���ϸ�)    

select sample_seq2.nextval from dual; -- �������� �������� ���
select sample_seq2.currval from dual; -- �������� ���簪�� ���


--�������� primary key�� �����ϱ�

create table dept_copy80
as
select *
from department
where 0=1;

select * from dept_copy80;

--������ ���� : �ʱⰪ 10, ������ 10
create sequence dept_seq
    increment by 10
    start with 10
    nocache;    
    
    /*sequence �� cache�� ����ϴ°�� / ������� �ʴ°��*/
    -- cache : ������ ������ ����ϱ� ���ؼ� ��� (�⺻�� : 20�� )
    -- ������ �ٿ�� ��� : ĳ���� �ѹ����� ��� ����. ���ο� ���� �Ҵ� �޴´�.
    -- �����߻�������� drop�ϰ� �ٽü����������.
    
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

-- �������� ���̺��� Ư�� �÷��� ����

insert into emp_copy80
values ( emp_seq_no.nextval ,'SMITH','SALESMAN',2222,sysdate,3000,300,20);

-- ������ ������ ����
select * from user_sequences;

alter sequence emp_seq_no
    maxvalue 1000;
    
alter sequence emp_seq_no 
    cycle ; --�ִ밪�� ����ǰ� �ٽ� ó������ ��ȯ
    
alter sequence emp_seq_no 
    nocycle ;    --��ȯ���� �ʰٴ�.
    
select * from user_sequences;
drop sequence sample_seq;


--�ε���--
/*
    INDEX : ���̺��� �÷��� ����, Ư�� �÷��� �˻��� �����Ի���� �� �ֵ��� �Ѵ�.
        - INDEX Page : �÷��� �߿� Ű���带 �ɷ��� ��ġ ������ ��Ƴ��� �������� INDEX Page����Ѵ�.
            - DB������ 10%
        - ����(index ) : å�� ����, å�� ������ �߿� Ű���带 �����ؼ� ��ġ�� �˷���.
        - ���̺� ��ĵ : ���ڵ��� ó�� ~ ���������� �˻� (�˻� �ӵ��� ������.),�ε����� ��������ʰ� �˻�
            - Index �� �����Ǿ����� �ʴ� �÷��� ���̺� ��ĵ�� �Ѵ�.
        - Primary Key, Uniqe Ű�� ����� �÷��� INDEX page�� �����Ǿ� �˻��� ������ �Ҽ��ִ�.
        - where ������ ���� �˻��� �ϴ� �÷��� index�� ����.
        - ���̺��� �˻��� �����ϴ� �÷��� index�� �����Ѵ�, 
          ���̺� ��ĵ�� ���� �ʰ� index page�� �˻��ؼ� ������ ������ ã�´�.
        - Index �� �����Ҷ� ���ϰ� ���� �ɸ���. �ַ� �����ð��� ���ؼ� �߰��� ������.
        - index�� �߻����ؾ� �Ѵ�.

*/

-- index ������ ����Ǿ� �ִ� ������ ����.
    -- user_tab_columns , user_ind_columns
    select * from user_tab_columns;
    select * from user_ind_columns;
    
select * from user_tab_columns
where table_name in ('TBL1','TBL2','EMPLOYEE','DEPARTMENT');
    
select index_name, table_name , column_name
from user_ind_columns
where table_name in ('EMPLOYEE','DEPARTMENT');

select * from employee; -- ENO �÷��� Primary key�� ���ִ�. <== �ڵ����� index �� �������

/*
    index �ڵ� ���� , (primary key, unique) �÷����� index page�� �ڵ����� �����ȴ�.
    
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
where ename = 'KING'; --ename �÷��� index�� �����Ƿ� king�� �˻��ϱ� ���ؼ� ���̺�ĵ�Ѵ�.


-- ename �÷��� index �����ϱ� (�߰��� �۾��ؾ� �Ѵ�, ���ϰ� ���� �ɸ���.)

-- �÷��� index�� �����Ǿ� ���� ������ ���̺� ��ĵ�� �Ѵ�. ó������ �ϳ��ϳ� �˻��Ѵ�.
-- �÷��� index�� �����Ǿ� ������ index page(å�� ����)�� �˻��Ѵ�.

create index id_emp_ename
on emp_copy90(ename);
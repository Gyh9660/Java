--1 equi����
select eno �����ȣ, ename ����̸�, job ��å , d.dno �μ���ȣ , d.dname �μ��̸�
from hr.employee e , hr.department d 
where e.dno = d.dno
and ename = 'SCOTT';

--2 inner join
select eno �����ȣ, ename ����̸�, job ��å , d.dno �μ���ȣ , d.dname �μ��̸�
from hr.employee e inner join hr.department d 
on e.dno = d.dno
and ename = 'SCOTT';

--3 copy
drop table emp_copy;

create table emp_copy
as
select * from employee;

drop table dept_copy;
create table dept_copy
as
select * from department;

--4 ��������
alter table emp_copy
add constraint emp_copy_eno_pk primary key(eno);

alter table dept_copy
add constraint dept_copy_dno_pk primary key(dno);

alter table emp_copy
add constraint emp_copy_dno_fk foreign key(dno) references dept_copy(dno);

select * from user_constraints
where table_name in('EMP_COPY','DEPT_COPY');

--5 �����
create view v_emp_job
as
select eno �����ȣ, ename ����̸�, dno �μ���ȣ, job ��å
from employee
where job = 'SALESMAN';

select * from v_emp_job;

--6 v_auto_join �� �̸����� 1�� ������ join ������ �����ϴ� �並 ����ÿ� �並 ����ϴ� �����ۼ�
create view v_auto_join
as
select eno �����ȣ, ename ����̸�, job ��å , d.dno �μ���ȣ , d.dname �μ��̸�
from hr.employee e , hr.department d 
where e.dno = d.dno
and ename = 'SCOTT';

select * from v_auto_join;

--7 �ε�������
create index idx_employee_ename
on employee(ename);

--8 NVL2�Լ� ��� ������� 
select ename ����̸� ,NVL2( commission , salary*12+commission, salary*12) ����
from employee;

--9 ������ ���� �ʱⰪ 1 ������ 1 nocache / dept_copy ���� dno �÷��� ����������
create sequence seq_dept_dno
    increment by 1
    start with 1
    nocache;

create table dept_copy_seq
as
select * from department
where 0=1;

insert into dept_copy_seq
values (seq_dept_dno.nextval,'SALES','CHICAGO');

commit;

select * from dept_copy_seq;

--10 self join 
select e.eno �����ȣ, e.ename ����̸� , e.manager ���޻���ȣ , d.ename ���޻���
from employee e inner join employee d
on e.manager = d.eno;
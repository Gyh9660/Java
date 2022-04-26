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
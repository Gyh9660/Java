--1 equi조인
select eno 사원번호, ename 사원이름, job 직책 , d.dno 부서번호 , d.dname 부서이름
from hr.employee e , hr.department d 
where e.dno = d.dno
and ename = 'SCOTT';

--2 inner join
select eno 사원번호, ename 사원이름, job 직책 , d.dno 부서번호 , d.dname 부서이름
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

--4 제약조건
alter table emp_copy
add constraint emp_copy_eno_pk primary key(eno);

alter table dept_copy
add constraint dept_copy_dno_pk primary key(dno);

alter table emp_copy
add constraint emp_copy_dno_fk foreign key(dno) references dept_copy(dno);

select * from user_constraints
where table_name in('EMP_COPY','DEPT_COPY');

--5 뷰생성
create view v_emp_job
as
select eno 사원번호, ename 사원이름, dno 부서번호, job 직책
from employee
where job = 'SALESMAN';

select * from v_emp_job;

--6 v_auto_join 뷰 이름으로 1번 문항의 join 구문을 생성하는 뷰를 만드시오 뷰를 출력하는 구문작성
create view v_auto_join
as
select eno 사원번호, ename 사원이름, job 직책 , d.dno 부서번호 , d.dname 부서이름
from hr.employee e , hr.department d 
where e.dno = d.dno
and ename = 'SCOTT';

select * from v_auto_join;

--7 인덱스생성
create index idx_employee_ename
on employee(ename);

--8 NVL2함수 사용 연봉출력 
select ename 사원이름 ,NVL2( commission , salary*12+commission, salary*12) 연봉
from employee;

--9 시퀀스 생성 초기값 1 증가값 1 nocache / dept_copy 생성 dno 컬럼에 시퀀스적용
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
select e.eno 사원번호, e.ename 사원이름 , e.manager 직급상사번호 , d.ename 직급상사명
from employee e inner join employee d
on e.manager = d.eno;
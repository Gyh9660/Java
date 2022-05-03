--저장프로시저 사용 문제--
--1. 각 부서별로 최소급여, 최대급여, 평균급여를 출력하는 저장프로시져를 생성하시오. 
--	[employee, department ] 테이블 이용
set serveroutput on
declare
    v_dno employee.dno%type;
    v_min employee.salary%type;
    v_max employee.salary%type;
    v_avg employee.salary%type;
    
    cursor c1
    is
    select dno , min(salary),max(salary),round(avg(salary))
    from employee
    group by dno;
begin
    DBMS_OUTPUT.PUT_line('부서번호   최소급여   최대급여   평균급여');
    DBMS_OUTPUT.PUT_line('-------------------------------');
    open c1;
    loop
        fetch c1 into v_dno,v_min,v_max,v_avg;
        exit when c1%notfound;
    DBMS_OUTPUT.PUT_line(v_dno||'   '||v_min||'   '||v_max||'   '||v_avg);
    end loop;
    close c1;
end;
/

--2.  사원번호, 사원이름, 부서명, 부서위치를 출력하는 저장프로시져를 생성하시오.  
--	[employee, department ] 테이블 이용
declare
    v_eno employee.eno%type;
    v_ename employee.ename%type;
    v_dname department.dname%type;
    v_loc department.loc%type;

    cursor c2
    is
    select e.eno, e.ename, d.dname, d.loc
    from employee e, department d
    where e.dno = d.dno;
begin
    DBMS_OUTPUT.PUT_line('사원번호   사원이름   부서이름   부서위치');
    DBMS_OUTPUT.PUT_line('-------------------------------');
    open c2;
    loop
        fetch c2 into v_eno,v_ename,v_dname,v_loc;
        exit when c2%notfound;
        DBMS_OUTPUT.PUT_line(v_eno||'   '||v_ename||'   '||v_dname||'   '||v_loc);
    end loop;
    close c2;
end;
/
--3. 급여를 입력 받아  입력받은 급여보다 높은 사원의 사원이름, 급여, 직책을 출력 하세요.
--	저장프로시져명 : sp_salary_b
create or replace procedure sp_salary_b(
    v_salary in employee.salary%type
)
is
    v_ename employee.ename%type;
    v_job employee.job%type;
    v_salary2 employee.salary%type;
    
    cursor c3
    is
    select ename,salary, job
    from employee
    where salary>v_salary;
begin
    DBMS_OUTPUT.PUT_line('사원이름   급여   직책');
    DBMS_OUTPUT.PUT_line('--------------------');
    open c3;
    loop
        fetch c3 into v_ename,v_salary2,v_job;
        exit when c3%notfound;
        DBMS_OUTPUT.PUT_line(v_ename||'   '||v_salary2||'   '||v_job);
    end loop;
    close c3;
    
end;
/
exec sp_salary_b(1000);


--4. 인풋 매개변수 : emp_c10, dept_c10  두개를 입력 받아 각각 employee, department 테이블을 복사하는 저장프로시져를 생성하세요. 
--	저장프로시져명 : sp_copy_table
create or replace procedure sp_copy_table(
    v_empname varchar2,
    v_deptname varchar2
)
is
    c4 integer;
    v_sql varchar2(200);
    c5 integer;
    v_sql2 varchar2(200);
begin
    v_sql := ('CREATE TABLE ' ||v_empname || ' as select * from employee');
    v_sql2 := ('CREATE TABLE ' ||v_deptname || ' as select * from department');
    c4 := DBMS_SQL.OPEN_CURSOR;
    DBMS_SQL.parse (c4, v_sql,dbms_sql.v7);
    DBMS_SQL.CLOSE_CURSOR(c4);
    c5 := DBMS_SQL.OPEN_CURSOR;
    DBMS_SQL.parse (c5, v_sql2,dbms_sql.v7);
    DBMS_SQL.CLOSE_CURSOR(c5);
end;
/
exec sp_copy_table('emp_c10','dept_c10');
select * from dept_c10;
select * from emp_c10;

--5. dept_c10 테이블에서 dno, dname, loc 컬럼의 값을 인풋 받아 인풋 받은 값을 insert하는 저장프로시져를 생성하시요. 
--	입력 값 : 50  'HR'  'SEOUL'
--	입력 값 : 60  'HR2'  'PUSAN' 
create or replace procedure sp_dept1(
    v_dno in number,
    v_dname in varchar2,
    v_loc in varchar2
)
is
begin
    INSERT INTO dept_c10 
    VALUES(v_dno,v_dname,v_loc);
end;
/
exec sp_dept1(50,'HR','SEOUL');
exec sp_dept1(60,'HR2','PUSAN');
select * from dept_c10;
--6. emp_c10 테이블에서 모든 컬럼의 값을 인풋 받아 인풋 받은 값을 insert하는 저장프로시져를 생성하시요. 
--	입력 값 : 8000  'SONG'    'PROGRAMMER'  7788  sysdate  4500  1000  50 
create or replace procedure sp_emp1(
    v_eno in number,
    v_ename in varchar2,
    v_job in varchar2,
    v_manager in number,
    v_hiredate in date,
    v_salary in number,
    v_commission in number,
    v_dno in number
)
is

begin
    INSERT INTO emp_c10 
    VALUES(v_eno,v_ename,v_job,v_manager,v_hiredate,v_salary,v_commission,v_dno); 
end;
/
exec sp_emp1(8000,'SONG','PROGRAMER',7788,sysdate,4500,1000,50);
select * from emp_c10;

--6번문제 job 컬럼 크기가 9이라 programmer 안들어가서 m뺏음

--7. dept_c10 테이블에서 4번문항의 부서번호 50의 HR 을 'PROGRAM' 으로 수정하는 저장프로시져를 생성하세요. 
--	<부서번호와 부서명을 인풋받아 수정하도록 하시오.> 
--	입력갑 : 50  PROGRAMMER 
create or replace procedure sp_dept2(
    v_dno in number,
    v_dname in varchar2
)
is
begin
    update dept_c10
    set dname = v_dname
    where dno = v_dno;
end;
/
exec sp_dept2(50,'PROGRAM');
select * from dept_c10;

--8. emp_c10 테이블에서 사원번호를 인풋 받아 월급을 수정하는 저장 프로시져를 생성하시오. 
--	입력 값 : 8000  6000
create or replace procedure sp_emp2(
    v_eno in number,
    v_salary in number
)
is
begin
    update emp_c10
    set salary = v_salary
    where eno = v_eno;
end;
/
exec sp_emp2(8000,6000);
select * from emp_c10;

commit;
--9. 위의 두 테이블명을 인풋 받아 두 테이블을 삭제하는 저장프로시져를 생성 하시오. 
create or replace procedure sp_drop_table(
    v_empname varchar2,
    v_deptname varchar2
)
is
    c6 integer;
    v_sql3 varchar2(200);
    c7 integer;
    v_sql4 varchar2(200);
begin
    v_sql3 := ('DROP TABLE ' ||v_empname);
    v_sql4 := ('DROP TABLE ' ||v_deptname);
    c6 := DBMS_SQL.OPEN_CURSOR;
    DBMS_SQL.parse (c6, v_sql3,dbms_sql.v7);
    DBMS_SQL.CLOSE_CURSOR(c6);
    c7 := DBMS_SQL.OPEN_CURSOR;
    DBMS_SQL.parse (c7, v_sql4,dbms_sql.v7);
    DBMS_SQL.CLOSE_CURSOR(c7);
end;
/
exec sp_drop_table('emp_c10','dept_c10');
select * from dept_c10;
select * from emp_c10;


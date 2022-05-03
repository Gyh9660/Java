--�������ν��� ��� ����--
--1. �� �μ����� �ּұ޿�, �ִ�޿�, ��ձ޿��� ����ϴ� �������ν����� �����Ͻÿ�. 
--	[employee, department ] ���̺� �̿�
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
    DBMS_OUTPUT.PUT_line('�μ���ȣ   �ּұ޿�   �ִ�޿�   ��ձ޿�');
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

--2.  �����ȣ, ����̸�, �μ���, �μ���ġ�� ����ϴ� �������ν����� �����Ͻÿ�.  
--	[employee, department ] ���̺� �̿�
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
    DBMS_OUTPUT.PUT_line('�����ȣ   ����̸�   �μ��̸�   �μ���ġ');
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
--3. �޿��� �Է� �޾�  �Է¹��� �޿����� ���� ����� ����̸�, �޿�, ��å�� ��� �ϼ���.
--	�������ν����� : sp_salary_b
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
    DBMS_OUTPUT.PUT_line('����̸�   �޿�   ��å');
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


--4. ��ǲ �Ű����� : emp_c10, dept_c10  �ΰ��� �Է� �޾� ���� employee, department ���̺��� �����ϴ� �������ν����� �����ϼ���. 
--	�������ν����� : sp_copy_table
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

--5. dept_c10 ���̺��� dno, dname, loc �÷��� ���� ��ǲ �޾� ��ǲ ���� ���� insert�ϴ� �������ν����� �����Ͻÿ�. 
--	�Է� �� : 50  'HR'  'SEOUL'
--	�Է� �� : 60  'HR2'  'PUSAN' 
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
--6. emp_c10 ���̺��� ��� �÷��� ���� ��ǲ �޾� ��ǲ ���� ���� insert�ϴ� �������ν����� �����Ͻÿ�. 
--	�Է� �� : 8000  'SONG'    'PROGRAMMER'  7788  sysdate  4500  1000  50 
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

--6������ job �÷� ũ�Ⱑ 9�̶� programmer �ȵ��� m����

--7. dept_c10 ���̺��� 4�������� �μ���ȣ 50�� HR �� 'PROGRAM' ���� �����ϴ� �������ν����� �����ϼ���. 
--	<�μ���ȣ�� �μ����� ��ǲ�޾� �����ϵ��� �Ͻÿ�.> 
--	�Է°� : 50  PROGRAMMER 
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

--8. emp_c10 ���̺��� �����ȣ�� ��ǲ �޾� ������ �����ϴ� ���� ���ν����� �����Ͻÿ�. 
--	�Է� �� : 8000  6000
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
--9. ���� �� ���̺���� ��ǲ �޾� �� ���̺��� �����ϴ� �������ν����� ���� �Ͻÿ�. 
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


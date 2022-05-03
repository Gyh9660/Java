--cursor for loop ������ Ŀ���� ����ؼ� ���� ���ڵ�� ����ϱ�
    --open, close�� �����ؼ� ���,
    --�� ���̺��� ��ü ������ ��� �Ҷ� ���

set serveroutput on
declare
    v_dept department%rowtype;
    cursor c1
    is
    select * from department;

begin
    dbms_output.put_line('�μ���ȣ   �μ���   ������');
    dbms_output.put_line('-----------------------');
    for v_dept in c1 loop
        dbms_output.put_line (v_dept.dno||'   '||v_dept.dname||'   '||v_dept.loc);
    end loop;

end;
/
--1--
set serveroutput on
declare
    v_emp employee%rowtype;
    cursor c2
    is
    select * from employee;
begin
    dbms_output.put_line('�����ȣ ����� ���� ��� �Ի��� ���� ���� �μ���ȣ');
    dbms_output.put_line('-----------------------');
    for v_emp in c2 loop
        dbms_output.put_line(v_emp.eno||' '||v_emp.ename||' '||v_emp.job||' '||v_emp.manager||' '||v_emp.hiredate||' '||v_emp.salary||' '||v_emp.commission||' '||v_emp.dno);
    end loop;
end;
/

declare
    v_empl employee%rowtype;
    cursor c3
    is
    select eno, ename, salary, dno
    from employee
    where salary >2000 and dno in(20,30);
begin
    dbms_output.put_line('�����ȣ ����� ���� �μ���ȣ');
    dbms_output.put_line('--------------------------');
    for v_empl in c3 loop
        dbms_output.put_line(v_empl.eno||' '||v_empl.ename||' '||v_empl.salary||' '||v_empl.dno);
    end loop;
end;
/

--���� ���ν��� (stored procedure) , �Լ� (Function), Ʈ����(Trigge)

/*
    �������ν����� ����
    1. PL/SQL�� ��밡���ϴ�. �ڵ�ȭ
    2. ������ ������.
        �Ϲ����� SQL ���� : ���� �м� -> ��ü�̸�Ȯ�� -> ������ Ȯ�� ->����ȭ -> ������ ->����
        �������ν��� ó�� ���� :���� �м� -> ��ü�̸�Ȯ�� -> ������ Ȯ�� ->����ȭ -> ������ ->����
        �������ν��� �ι�°���� ���� : �����ϵ�(�޸𸮿� �ε��)�������� �ٷ� ����
        
    3. �Է� �Ű�����, ��� �Ű������� ����Ҽ� �ִ�.
    4. �Ϸ��� �۾��� ��� ������ �� �ִ�.( ���ȭ�� ���α׷��� ����)

*/
--1. �������ν��� ����.
    --���� ����� ������ ����ϴ� ���� ���ν���;
create procedure sp_salary
is
    v_salary employee.salary%type; -- �������ν����� is������� ������ ����
begin
    select salary into v_salary
    from employee
    where ename= 'SCOTT';
    
    dbms_output.put_line('SCOTT�� �޿��� : ' ||v_salary || '�Դϴ�.');
end;
/

/* �������ν��� ������ Ȯ���ϴ� ������ ����*/
select * from user_source
where name = 'SP_SALARY';

/*3. ���� ���ν��� ����
execute sp_salary;
*/
-- ��ü�̸�
EXECUTE sp_salary;
 -- ����̸�
exec sp_salary;

/*4. ���� ���ν��� ����*/
create or replace procedure sp_salary -- ������ ���� ������ ����
is
    v_salary employee.salary%type; -- �������ν����� is������� ������ ����
    v_commission employee.commission%type;
begin
    select salary,commission into v_salary,v_commission
    from employee
    where ename= 'SCOTT';
    
    dbms_output.put_line('SCOTT�� �޿��� : ' ||v_salary ||
    '���ʽ��� : '||v_commission|| ' �Դϴ�.');
end;
/

/*5. ���� ���ν��� ����*/

drop procedure sp_salary;

-----<<��ǲ �Ű������� ó���ϴ� ���� ���ν���>>-------
create or replace procedure sp_salary_ename( -- �Է� �Ű�����(in), ��¸Ű�����(out)�� ����
    v_ename in employee.ename%type -- ������ in �ڷ���
    --- <== ���� : �Ű������� �������϶� , ��ó�� ;�� ������ �ȵȴ�
)
is -- �������� (���� ���ν������� ����� ���� ���� ���
    v_salary employee.salary%type;
    
begin
    select salary into v_salary -- ����
    from employee
    where ename = v_ename; -- ��ǲ �Ű����� : v_ename
    
    dbms_output.put_line (v_ename ||'�� �޿��� : ' ||v_salary || '�Դϴ�.');
end;
/

exec sp_salary_ename('KING');
exec sp_salary_ename('SCOTT');
exec sp_salary_ename('SMITH');
select * from employee;

/*
�̸�, �μ���ȣ�� ��ǲ �޾Ƽ� �̸�, ��å, �μ���ȣ�� 
����ϴ� ���� ���ν����� �����ϼ��� (Ŀ�������)
*/
create or replace procedure sp_job_dno (
    v_dno in employee.dno%type
)
is
    v_ename employee.ename%type;
    v_job employee.job%type;
    
    cursor c1
    is
    select ename,job into v_ename,v_job
    from employee
    where dno = v_dno;
begin
    open c1;
    loop
        fetch c1 into v_ename,v_job;
        exit when c1%notfound;
        dbms_output.put_line('�̸� '||v_ename||' ��å '||v_job||' �μ���ȣ '||v_dno);
    end loop;
    close c1;
end;
/
select * from employee;
exec sp_job_dno(10);

/*���̺� �̸� ��ǲ �޾Ƽ� employee���̺� �����Ͽ� �����ϴ� �������ν��� ����
��ǲ�� emp_copy33*/
create or replace procedure sp_emp (
    v_empname in varchar2
    )
is
    c1 integer;
    v_sql varchar2(200); -- sql������ �����ϴ� ����

begin
    v_sql := 'CREATE TABLE ' ||v_empname || ' as select * from employee';
    --���̺� ���������� ������ �Ҵ�.
   
    c1 := DBMS_SQL.OPEN_CURSOR; --Ŀ�� ���
    DBMS_SQL.parse (c1, v_sql,dbms_sql.v7); --Ŀ���� ����ؼ� sql������ ����
    DBMS_SQL.CLOSE_CURSOR(c1);      --Ŀ������
end;
/
--grant create table to public; sys �������� ���� 

exec sp_emp('emp_copy33');

select* from emp_copy33;


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

--------<< ��� �Ű����� ���>>-----------------
/* ���� ���ν��� : ��� �Ű������� ���� (�������� ),
�Լ� : ��� �Ű������� �ϳ��� ���´�. 
        -- OUT Ű���带 ���.
        -- �������ν����� ȣ��ÿ� ���� ��¸Ű����� ���������� ȣ���̰���
        -- ȣ��� ��¸Ű����� �̸� �տ� ':������(��¸Ű�������)'
        -- ��� �Ű������� ����ϱ� ���ؼ� PRINT ��ɹ��̳� PL/SQL�� ����ؼ� ��� �Ҽ��ִ�.
        

*/
create or replace procedure sp_salary_ename2 (
    v_ename in employee.ename%type,     --�Է¸Ű�����
    v_salary out employee.salary%type   --��¸Ű�����
)
is
begin
    select salary into v_salary
    from employee
    where ename = v_ename;
    
end;
/
select * from user_source where name = 'SP_SALARY_ENAME2';
--������ �������� Ȯ��.
select * from user_source where name = 'OUT1';

variable var_salary varchar2(50);
--ȣ��ο��� �ƿ�ǲ �Ű������� ����
exec sp_salary_ename2('SCOTT',:var_salary);
-- :var_salary <=: ����
print var_salary;

--OUT �Ķ���͸� ������ ������ ������������ ���� �� ��� (PL/SQL)
--�����ȣ�� ��ǲ�޾Ƽ� ����̸�,�޿�,��å �� out�Ķ���Ϳ� �Ѱ��ִ�
--���ν����� PL/SQL�� ����ؼ� ���
create or replace procedure sel_empno( --in ,out: �ڷ����� �����ڷ���
    v_eno in number,                --%type, �⺻�ڷ���(����Ʈ������)�� �����մ�
    v_ename out varchar2,
    v_salary out number,
    v_job out varchar2
)
is
begin
    select ename, salary, job into v_ename, v_salary, v_job
    from employee
    where eno = v_eno;
end;
/
-- PL/SQL�� ����ؼ� ���� ���ν��� ȣ��
declare
    v_ename varchar2(20);
    v_salary number(20);
    v_job varchar2(20);
begin
    --�͸� ��Ͽ����� �������ν��� ȣ��� exec�� ������ �ʴ´�.
    sel_empno (7788,v_ename,v_salary,v_job); 
    --�������ν��� ȣ�� , �����տ� : ����������
    dbms_output.put_line('��ȸ��� : '||v_ename||' | '||v_salary||' | '||v_job);
    
end;
/







--10. �̸��� ��ǲ �޾Ƽ� �����, �޿�, �μ���ȣ, �μ���, �μ���ġ�� 
--OUT �Ķ���Ϳ� �Ѱ��ִ� ���ν����� PL / SQL���� ȣ��
create or replace procedure out1(
    v_name in employee.ename%type,
    v_ename out varchar2,
    v_salary out number,
    v_dno out number,
    v_dname out varchar2,
    v_loc out varchar2
)
is

begin
    select e.ename, e.salary, d.dno ,d.dname,d.loc into v_ename,v_salary,v_dno,v_dname,v_loc
    from employee e,department d
    where e.dno = d.dno
    and e.ename = v_name;

end;
/

select * from employee;
select * from department;

declare
    v_ename varchar2(20);
    v_salary number(20);
    v_dno number(20);
    v_dname varchar2(20);
    v_loc varchar2(20);
begin
    out1 ('KING',v_ename,v_salary,v_dno,v_dname,v_loc);
    dbms_output.put_line('����̸� : '||v_ename||', �޿� : '||v_salary||', �μ���ȣ : '||v_dno||', �μ��̸� : '||v_dname||', �μ���ġ : '||v_loc);
end;
/

--11-1. �μ���ȣ�� �޾Ƽ� �����, �޿�, ��å�� OUT �Ķ���Ϳ� �Ѱ��ִ� ���ν����� PL / SQL���� ȣ��
--�𸣰ٴ� �̰� 
create or replace procedure out23(
    v_dno in number,
    c1 out sys_refcursor
)
is
begin
    open c1 for
    select ename, salary,job
    from employee
    where dno = v_dno;

end;
/
declare
    v_ename employee.ename%type;
    v_salary employee.salary%type;
    v_job employee.job%type;
    v_dno employee.dno%type;
    c1 sys_refcursor;
begin
    out23(10,c1);
    loop
        fetch c1 into v_ename,v_salary,v_job;
        exit when c1%notfound;
        dbms_output.put_line(v_ename||' '||v_salary||' '||v_job);
    end loop; -- dbms~_line ���� ���� ||' '||���ؾ��� ,���ϸ� �����߻�
    close c1;
end;
/

--11. �����ȣ�� �޾Ƽ� �����, �޿�, ��å,�μ���,�μ���ġ�� OUT �Ķ���Ϳ� �Ѱ��ִ� ���ν����� PL / SQL���� ȣ��
create or replace procedure out2(
    v_eno in number,
    v_ename out varchar2,
    v_salary out number,
    v_job out varchar2,
    v_dname out varchar2,
    v_loc out varchar2
)
is
begin
    select e.ename, e.salary,e.job,d.dname,d.loc into v_ename,v_salary,v_job,v_dname,v_loc
    from employee e, department d
    where e.dno= d.dno
    and e.eno =v_eno;

end;
/

declare
    v_ename varchar2(20);
    v_salary number(20);
    v_job varchar2(20);
    v_dname varchar2(20);
    v_loc varchar2(20);
begin
    out2(7788,v_ename,v_salary,v_job,v_dname,v_loc);
    dbms_output.put_line('��°�� : '||v_ename||'   '||v_salary||'   '||v_job||'   '||v_dname||'   '||v_loc);
end;
/


/* �Լ� (Function) : ���� �־ �ϳ��� ���� ��ȯ �޾ƿ´�.
    �Լ� : SQL ���� ������ ��밡��
    --��, �������ν����� out�Ű������� ������ �޾ƿü� �ִ�.
    <== SQL���� �������� ���Ұ�.
    
*/

create or replace function fn_salary_ename ( -- ��ǲ�Ű�����
    v_ename in employee.ename%type
)
RETURN number     --ȣ���ϴ� ������ ���� ������. ������ �ڷ���
is
    v_salary number(7,2);
begin
    select salary into v_salary
    from employee
    where ename = v_ename;      --��ǲ �Ű� ����
    return v_salary;
end;
/

/*�Լ��� ������ ����*/
select * from user_source
where name = 'FN_SALAY_ENAME';

--1. �Լ����
variable var_salary number;
exec :var_salary := fn_salary_ename('SCOTT');
print var_salary;

--2. �Լ� ��� (SQL ���� ������ �Լ� ���)
select ename , fn_salary_ename('SCOTT') ���� --<==�̸��� �����°� select ������ �������
from employee
where ename = 'SCOTT';


--�Լ� ����
drop FUNCTION fn_salary_ename;
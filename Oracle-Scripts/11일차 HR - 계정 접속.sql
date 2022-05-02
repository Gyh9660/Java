
--Object Privileges: ���̺�, ��,Ʈ����,�Լ�
    --�������ν���, ������, �ε����� �ο��Ǵ� ���� �Ҵ�
    /*
    =================================================
    ����      Table   view    SEQUENCE    PROCEDEUR
    -------------------------------------------------
    Alter       0                0
    DELETE      0      0         
    EXECUTE                                  0
    INDEX       0
    INSERT      0      0
    REFERENCE   0      
    SELECT      0      0        0
    UPDATE      0      0
    --------------------------------------------------

    */
    --sys��������������
    -- Ư�� ���̺� select ���� �ο� �ϱ�
    create user user_test10 identified by 1234; -- ���� ����.
    
    --��ü�� ��½� ��ü ��տ� ��ü�� �����ָ��� �־�����Ѵ�.
    -- 
    select * from hr.employee;
    
    select * from employee; --�ڱ��ڽ��� ������ ��ü�ϋ��� ��������
    
    create table emp_copy55
    as
    select * from employee;
    
    create table dept_copy55
    as
    select * from department;
    
    create table dept_copy56
    as
    select * from department;

drop table dept_copy57;  

create table dept_copy57
as
select * from department;


-------- PL/SQL : ����Ŭ���� �����׷��� ��Ҹ� ������ SQL, �����ϰ� ó���ؼ� ����
/*        MSSQL: T-SQL
 SQL : ����ȭ�� ���Ǿ��. ����: ������ ���α׷��� ����� ������ �� ����.

*/

set serveroutput on --PL/SQL�� ����� Ȱ��ȭ

/* PL SQL�� �⺻ �ۼ� ����*/

begin

    -- PL SQL ����

end;
/


-- PL/SQL���� �⺻ ���

set serveroutput on
begin
    dbms_output.put_line ('Welcome to Oracle');
end;
/

--�ڷ��� ����
/*
    1. Oracle �� �ڷ����� ���.
    2. �����ڷ��� : ���̺��� �÷��� ����� �ڷ����� �����ؼ� ���.
        %type : ���̺��� Ư�� �÷��� �ڷ����� �����ؼ� ���.
        %rowtype : ���̺� ��ü �÷��� �ڷ����� ��� �����ؼ� ���.

*/


-- PL/SQL���� ���� ����
/* ������ := �� */
set serveroutput on
declare -- ���� ���� (���� �����)
    v_eno number(4);                -- ����Ŭ�� �ڷ���
    v_ename employee.ename%type;    -- ���� �ڷ��� : �ٸ� ���̺��� �÷�
                                    -- �� �ڷ����� �����ؼ� ����.
begin                              
    v_eno := 7788; -- := ������ ���� �Ҵ� �Ҷ� ���.
    v_ename := 'SCOTT';
    
    dbms_output.put_line('�����ȣ      ����̸�');
    dbms_output.put_line('--------------------');
    dbms_output.put_line(v_eno|| '      '||v_ename);   
    
end;
/


/* �����ȣ�� ����̸� ��� �ϱ� */
set serveroutput on
declare
    v_eno employee.eno%type; -- employee�� eno�÷��� Ÿ��(�ڷ���)����
    v_ename employee.ename%type;
    
begin
    dbms_output.put_line('�����ȣ      ����̸�');
    dbms_output.put_line('--------------------');
    
    select eno,ename into v_eno,v_ename
    from employee
    where ename = 'SCOTT';
        
    dbms_output.put_line(v_eno|| '      '||v_ename); 
end;
/

select eno, ename
from employee
where ename = 'SCOTT';

/* PL SQL���� ��� ����ϱ�*/

/* if~ End if �� ����ϱ�*/

set serveroutput on
declare
    v_employee employee%rowtype; --rowtype : employee ���̺��� ��� �÷��� �ڷ����� �����ؼ����
                        --v_employee ������ employee���̺��� ����÷��� ����
    annsal number (7,2); -- �ѿ����� �����ϴ� ����
begin
    select * into v_employee
    from employee
    where ename = 'SCOTT';
    
    if (v_employee.commission is null)
    then v_employee.commission := 0;
    end if;
    
    annsal := v_employee.salary * 12 + v_employee.commission;
    dbms_output.put_line('�����ȣ  ����̸�  ����');
    dbms_output.put_line('-----------------------------------');
    dbms_output.put_line(v_employee.eno ||'  '||v_employee.ename||'  '|| annsal);
    
    
end;
/
select * from employee
where ename = 'SCOTT';

/*

v_employee.eno  := 7788;
v_employee.ename  := 'SCOTT';
v_employee.job "= ANALYST;
v_employee.manager := 7566;
v_employee.hiredate := 87/07/13;
v_employee.salary := 3000;
v_employee.commission is null;
v_employee.dno := 20;

*/

/*PL/SQL�� ����ؼ� department ���̺��� ��������Ƽ� ���
    ������ dno = 20
*/
--1. %rowtype : ���̺��� ��� �÷��� �����ؼ� ���

set serveroutput on
declare
    v_department department%rowtype;
begin
    select * into v_department
    from department
    where dno = 20;
    
    dbms_output.put_line('�μ���ȣ  �μ��̸�  ����');
    dbms_output.put_line('--------------------');
    dbms_output.put_line(v_department.dno||'  '||v_department.dname||'  '||v_department.loc);

end;
/

--2. %type ������ data type�� ���̺��� �÷��ϳ��ϳ��� �����ؼ� �Ҵ�.
set serveroutput on
declare
    v_dno department.dno%type;
    v_dname department.dname%type;
    v_loc department.loc%type;
begin
    select dno,dname,loc into v_dno,v_dname,v_loc
    from department
    where dno = 20;
    
    dbms_output.put_line('�μ���ȣ  �μ��̸�  ����');
    dbms_output.put_line('--------------------');
    dbms_output.put_line(v_dno||'  '||v_dname||'  '||v_loc);

end;
/
select * from department;

/* IF ~ ELSIF ~ END IF */

set serveroutput on
declare
    v_eno employee.eno%type;
    v_ename employee.ename%type;
    v_dno employee.dno%type;
    v_dname department.dname%type := null;
begin
    select eno, ename, dno into v_eno, v_ename, v_dno
    from employee
    where ename = 'SCOTT';
    
    if (v_dno = 10)
    then v_dname := 'ACCOUNT';
    elsif (v_dno = 20)
    then v_dname := 'RESEARCH';
    elsif (v_dno = 30)
    then v_dname := 'SALES';
    elsif (v_dno = 40)
    then v_dname := 'OPERATIONS';
    end if;
    
    dbms_output.put_line('�����ȣ   �����   �μ���');
    dbms_output.put_line('------------------------');
    dbms_output.put_line(v_eno||'   '||v_ename||'   '||v_dname);

end;
/

/* employee ���̺��� eno, ename , salary, dno 
PL/SQL�� ����ؼ� ���
����
���ʽ� 1400�� �Ϳ� ���ؼ� ���
*/
select * from employee
where commission = 1400;

--1. %type
set serveroutput on
declare
    v_eno employee.eno%type;
    v_ename employee.ename%type;
    v_salary employee.salary%type;
    v_dno employee.dno%type;

begin
    select eno,ename,salary,dno into v_eno , v_ename , v_salary, v_dno
    from employee
    where commission = 1400;
    
    DBMS_OUTPUT.PUT_line('�����ȣ   �����   ����   �μ���ȣ');
    DBMS_OUTPUT.PUT_line('-------------------------------');
    DBMS_OUTPUT.PUT_line(v_eno||'   '||v_ename||'   '||v_salary||'   '||v_dno);

end;
/

--2. %rowtype
set serveroutput on

declare
    v_employee employee%rowtype;
    
begin
    select * into v_employee
    from employee
    where commission = 1400;
    
    DBMS_OUTPUT.PUT_line('�����ȣ   �����   ����   �μ���ȣ');
    DBMS_OUTPUT.PUT_line('-------------------------------');
    DBMS_OUTPUT.PUT_line(v_employee.eno||'   '||v_employee.ename||'   '||v_employee.salary||'   '||v_employee.dno);

end;
/


/* Ŀ�� (cusor) :  PL/SQL���� selcet �� ����� ���� ���ڵ尡 �ƴ϶� 
���ڵ���� ��� Ŀ���� �ʿ��ϴ�.
*/
/*
declare

    cursor Ŀ����              1. Ŀ�� ����
    is
    Ŀ���� ������ select ����   

begin
    open Ŀ���� ;             2. Ŀ������
    loop
        fatch ����        3.Ŀ���� �̵��ϰ� ���
    end loop;
    close Ŀ����;          4. Ŀ���� ����
    
end;
/
*/

/* Ŀ���� ����ؼ� department ���̺��� ��� ������ ����ϱ�*/
set serveroutput on

declare
    v_dept department%rowtype; --���� ����
    
    cursor c1                   --1. Ŀ�� ����
    is
    select * from department;
    
begin
    dbms_output.put_line('�μ���ȣ   �μ���   �μ���ġ');
    dbms_output.put_line('-------------------------');
    open c1;                    --2. Ŀ������
    loop
        fetch c1 into v_dept.dno,v_dept.dname,v_dept.loc;
        exit when c1%notfound;
        dbms_output.put_line(v_dept.dno||'   '||v_dept.dname||'   '||v_dept.loc);
    end loop;
    close c1;                   --4. Ŀ������

end;
/
/* Ŀ���� �Ӽ��� ��Ÿ���� �Ӽ���
Ŀ����%notfound : Ŀ�� ���� ���� ��� �ڷᰡ FETCH�Ǿ��ٸ� true����
Ŀ����%found : Ŀ�� ���� ���� ��� �ڷᰡ FETCH���� �ʾҴٸ� true����
(Ŀ������ ���� FETCH ���� �ʴ� �ڷᰡ �����ϸ� true)
Ŀ����%isopen : Ŀ���� ���µǾ��ٸ� true
Ŀ����%rowcount : Ŀ���� ���� ���ڵ� ����

- SQL%ISOPEN: ������ ����Ǵ� ���� CLOSE �Ǳ� ������ �׻� FALSE.

- SQL%FOUND: ��ȸ�� ����� 1�� �̻��� ��� TRUE.

- SQL%NOTFOUND: ��ȸ�� ����� 0���� ��� TRUE.

- SQL%ROWCOUNT: �ֱ� ����� ������ ����� ��.
*/


/*
    �����, �μ���, �μ���ġ, ������ ����ϼ���

*/
declare
 v_ename employee.ename%type;
 v_dname department.dname%type;
 v_loc department.loc%type;
 v_salary employee.salary%type;
 
 cursor c1
 is
 select ename, dname, loc, salary into v_ename, v_dname, v_loc, v_salary
 from employee e, department d
 where e.dno = d.dno;
 
begin
    dbms_output.put_line('�����   �μ���   �μ���ġ   ����');
    dbms_output.put_line('-------------------------');
    open c1;
    loop
        fetch c1 into v_ename,v_dname,v_loc,v_salary;
        exit when c1%notfound;
        dbms_output.put_line(v_ename||'   '||v_dname||'   '||v_loc||'   '||v_salary);
    end loop;
    close c1;
end;
/
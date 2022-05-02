
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
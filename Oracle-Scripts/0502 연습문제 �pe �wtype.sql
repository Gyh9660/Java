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


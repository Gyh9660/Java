--1.
set serveroutput on

create or replace procedure sp_ex1
is --���� �����, Ŀ�� ����
    v_dno employee.dno%type;
    v_min employee.salary%type;
    v_max employee.salary%type;
    v_avg employee.salary%type;
    
    cursor c1
    is
    select dno, min(salary), max(salary), round(avg(salary))
    from employee
    group by dno;
    
begin
    dbms_output.put_line('�μ���ȣ   �ּұ޿�   �ִ�޿�   ��ձ޿�');
    dbms_output.put_line('------------------------------------');
    open c1;
    loop
        fetch c1 into v_dno,v_min,v_max,v_avg;
        exit when c1%notfound;
        dbms_output.put_line(v_dno||'   '||v_min||'   '||v_max||'   '||v_avg);
    end loop;
    close c1;
end;
/
exec sp_ex1;


--2

create or replace procedure sp_ex2
is
    v_eno employee.eno%type;
    v_ename employee.ename%type;
    v_dname department.dname%type;
    v_loc department.loc%type;
    
    cursor c1
    is
    select eno, ename, dname,loc
    from employee e , department d
    where e.dno = d.dno;
begin
     dbms_output.put_line('�����ȣ   ����̸�   �μ���   �μ���ġ');
    dbms_output.put_line('------------------------------------');
    open c1;
    loop
        fetch c1 into v_eno,v_ename,v_dname,v_loc;
        exit when c1%notfound;
        dbms_output.put_line(v_eno||'   '||v_ename||'   '||v_dname||'   '||v_loc);
    end loop;
    close c1;
end;
/

exec sp_ex2;

--3
create or replace procedure sp_ex3(
    v_salary in employee.salary%type
)
is
    v_emp employee%rowtype; -- ��� �÷��� �ڷ����� ����
    cursor c1
    is
    select ename, salary, job
    from employee
    where salary > v_salary;
begin
    dbms_output.put_line('����̸�   �޿�   ��å');
    dbms_output.put_line('------------------------------------');
    open c1;
    loop
        fetch c1 into v_emp.ename, v_emp.salary, v_emp.job;
        exit when c1%notfound;
        dbms_output.put_line(v_emp.ename||'   '||v_emp.salary||'   '||v_emp.job);
    end loop;
    close c1;
end;
/
exec sp_ex3(1500);

--4
--PL/SQL ���ο��� �͸� ������� ���̺��� ���� : grant create table to public; <==sys���� ��������
--���� ���ν��� ������ : revoke create table from public;

create or replace procedure sp_ex4(
    v_emp in varchar2,
    v_dept in varchar2
) -- ���� : ; ������ȵ�, �ڷ����� ũ�⸦ �����ϸ�ȵ�
is
    c1 integer;
    v_sql1 varchar2(500); -- ���̺� ���� ������ ���� ����
    v_sql2 varchar2(500);
begin
    v_sql1 := 'create table '||v_emp||' as select * from employee' ;
    v_sql2 := 'create table '||v_dept||' as select * from department';
    
    c1 := dbms_sql.open_cursor;     --Ŀ�� ����
    dbms_sql.parse(c1, v_sql1,dbms_sql.v7);
    dbms_sql.parse(c1, v_sql2,dbms_sql.v7);
    dbms_sql.close_cursor(c1);      --Ŀ�� ����
    
end;
/

exec sp_ex4 ( 'emp_c10', 'dept_c10');
drop table emp_c10;

--5.
create or replace procedure sp_ex5 (
    v_dno in dept_c10.dno%type,
    v_dname in dept_c10.dname%type,
    v_loc in dept_c10.loc%type
)
is
begin
    insert into dept_c10
    values (v_dno,v_dname,v_loc);
    
    dbms_output.put_line('���������� �� �Է��� �Ǿ����ϴ�.');
end;
/
exec sp_ex5 (50,'HR','SEOUL');
exec sp_ex5 (60,'HR2','BUSAN');
select * from dept_c10;

--6.

create or replace procedure sp_se6(
    v_eno in emp_c10.eno%type,
    v_ename in emp_c10.ename%type,
    v_job in emp_c10.job%type,
    v_manager in emp_c10.manager%type,
    v_hiredate in emp_c10.hiredate%type,
    v_salary in emp_c10.salary%type,
    v_commission in emp_c10.commission%type,
    v_dno in emp_c10.dno%type
)
is
begin
    insert into emp_c10
    values (v_eno,v_ename,v_job,v_manager,v_hiredate,v_salary,v_commission,v_dno);
    
    dbms_output.put_line('���������� �� �Է��� �Ǿ����ϴ�.');

end;
/
exec sp_se6(8000,'SONG','PROGRAMER',7788,sysdate,4500,1000,50);
select * from emp_c10;

--7
create or replace procedure sp_ex7(
    v_dno in dept_c10.dno%type,
    v_dname in dept_c10.dname%type
)
is
begin
    update dept_c10
    set dname = v_dname
    where dno = v_dno;

    dbms_output.put_line('���������� �� �Է��� �Ǿ����ϴ�.');

end;
/

exec sp_ex7(50,'PROGRAM');
select * from dept_c10;

--8.
create or replace procedure sp_ex8(
    v_eno in emp_c10.eno%type,
    v_salary in emp_c10.salary%type
)
is
begin
    update emp_c10
    set salary = v_salary
    where eno = v_eno;

    dbms_output.put_line('���������� �� �Է��� �Ǿ����ϴ�.');

end;
/

exec sp_ex8 ( 8000,6000);
select * from emp_c10;


--9.

create or replace procedure sp_ex9(
    v_emp in varchar2,
    v_dept in varchar2
) -- ���� : ; ������ȵ�, �ڷ����� ũ�⸦ �����ϸ�ȵ�
is
    c1 integer;
    v_sql1 varchar2(500); -- ���̺� ���� ������ ���� ����
    v_sql2 varchar2(500);
begin
    v_sql1 := 'drop table '||v_emp;
    v_sql2 := 'drop table '||v_dept;
    
    c1 := dbms_sql.open_cursor;     --Ŀ�� ����
    dbms_sql.parse(c1, v_sql1,dbms_sql.v7);
    dbms_sql.parse(c1, v_sql2,dbms_sql.v7);
    dbms_sql.close_cursor(c1);      --Ŀ�� ����
    
end;
/

exec sp_ex9 ('emp_c10','dept_c10');
select * from emp_c10;
select * from dept_c10;

--10.
create or replace procedure sp_ex10 (
    v_ename in employee.ename%type,
    v_o_ename out employee.ename%type,
    v_salary out employee.salary%type,
    v_dno out employee.dno%type,
    v_dname out department.dname%type,
    v_loc out department.loc%type
)
is

begin
    select ename, salary, e.dno, dname, loc into v_o_ename, v_salary, v_dno,v_dname,v_loc
    from employee e, department d
    where e.dno = d.dno
    and ename = v_ename; --v_ename�� ���������ؼ�
end;
/

declare --out ���� ���� ����
    v_ename employee.ename%type;
    v_salary employee.salary%type;
    v_dno employee.dno%type;
    v_dname department.dname%type;
    v_loc department.loc%type;
begin
    --�͸� ��������� exec /execute ��������, �� �տ� : �� ����
    sp_ex10('KING',v_ename,v_salary,v_dno,v_dname,v_loc);
    dbms_output.put_line('�����  ����  �μ���ȣ  �μ���  �μ���ġ  ');
    dbms_output.put_line('--------------------------------------');
    dbms_output.put_line(v_ename||'  '||v_salary||'  '||v_dno||'  '||v_dname||'  '||v_loc);
end;
/

--11.
create or replace procedure sp_ex11(
    v_eno in employee.eno%type, 
    v_ename out employee.ename%type, 
    v_salary out employee.salary%type, 
    v_job out employee.job%type, 
    v_dname out department.dname%type, 
    v_loc out department.loc%type
)
is

begin
    select ename, salary, job ,dname,loc into v_ename,v_salary,v_job,v_dname,v_loc
    from employee e, department d
    where e.dno = d.dno
    and eno = v_eno;
end;
/

declare
    v_ename employee.ename%type;
    v_salary employee.salary%type;
    v_job employee.job%type;
    v_dname department.dname%type;
    v_loc department.loc%type;
begin
    sp_ex11(7788,v_ename,v_salary,v_job,v_dname,v_loc);
    dbms_output.put_line('�����  ����  ��å  �μ���  �μ���ġ  ');
    dbms_output.put_line('--------------------------------------');
    dbms_output.put_line(v_ename||'  '||v_salary||'  '||v_job||'  '||v_dname||'  '||v_loc);
end;
/

--Ʈ����--
/* Ʈ���� (Trigger) : ������ ��Ƽ� (Ʈ����), ��Ƽ踦 ���� �Ѿ��� �߻��.
        -���̺� �����Ǿ� �ִ�.
        -���̺� �̺�Ʈ�� �߻��ɶ� �ڵ����� �۵��Ǵ� ���α׷� �ڵ�
        -���̺� �߻��Ǵ� �̺�Ʈ (Insert, Update, Delete)
        -Ʈ���ſ��� ���ǵ� begin ~ end ������ ������ �����.
        -before Ʈ���� : ���̺��� Ʈ���Ÿ� ���� �����ϰ� insert,update,delete�� ����
        -after Ʈ���� : insert,update,delete�� ������ Ʈ���� ����
        --�� ) �ֹ� ���̺� ���� �־����� ������̺� �ڵ����� ����
        --�� ) �߿� ���̺��� �α׸� ���涧�� ����
        -- :new => ������ �ӽ� ���̺� , Ʈ���Ű� ������ ���̺� ���Ӱ� ������ ���ڵ��� �ӽ� ���̺�(insert)
        -- :old => ������ �ӽ� ���̺� , Ʈ���Ű� ������ ���̺� �����Ǵ� ���ڵ��� �ӽ� ���̺�(delete)?
        -- Ʈ���Ŵ� �ϳ��� ���̺� �� 3������ �����̵�. (insert, update, delete)
*/
--�ǽ� ���̺� 2�� ���� : ���̺��� ������ ����
create table dept_original
as
select * from department
where 0=1;

drop table dept_copy;

alter table dept_copy
drop constraint dept_copy_dno_pk cascade;

create table dept_copy
as
select * from department
where 0=1;

select * from dept_original;
select * from dept_copy;

--Ʈ���� ���� (dept_original ���̺� ��Ź, insert�̺�Ʈ�� �߻��ɶ� �ڵ����� �۵�)

create or replace trigger tri_sample1
    --Ʈ���Ű� ������ ���̺�, �̺�Ʈ(insert , update, delete),Before,after

    after insert            --insert �̺�Ʈ�� �۵��ǰ��� Ʈ���� �ߵ�(begin~end ������ �ڵ�)
    on dept_original        --on ������ ���̺�
    for each row            --��� row�� ���ؼ�
begin       --Ʈ���Ű� ������ �ڵ�
    if inserting then
        dbms_output.put_line('Insert Trigger �߻�!!!');
        insert into dept_copy
        values(:new.dno,:new.dname,:new.loc); -- new <== �����ӽ����̺�
    end if;
end;
/

/*Ʈ���� Ȯ�� ������ ���� : user_source*/
select * from user_source where name = 'TRI_SAMPLE1';


select * from dept_original;
select * from dept_copy;

insert into dept_original
values (13, 'PROGRAM2', 'PUSAN2'); 

/* delete Ʈ���� : dept_original ���� �����ϸ� dept_copy���� �ش系���� ����*/

create or replace trigger tri_del
    --Ʈ���Ű� �۵���ų ���̺�, �̺�Ʈ
    after delete     -- ���� ���̺� delete�� ���� ������ Ʈ���� �۵�
    on dept_original -- dept_original���̺� Ʈ���� ����
    for each row
begin
    dbms_output.put_line('Delete Trigger �߻�!!!');
    delete dept_copy
    where dept_copy.dno = :old.dno;     --dept_original���� �����Ǵ� ���� �ӽ� ���̺� : old

end;
/

select * from dept_original;
select * from dept_copy;

delete dept_original
where dno = 15;

commit;

/* update Ʈ���� : dept_original���̺��� Ư�� ���������ϸ� dept_copy ���̺��� ������ ������Ʈ*/

create or replace trigger tri_update
    after update
    on dept_original
    for each row
begin
    dbms_output.put_line('update trigger �߻�!!!');
    update dept_copy
    set dept_copy.dname = :new.dname
    where dept_copy.dno = :old.dno;
end;
/

select * from dept_original;    -- <<�ֹ� ���̺� ����>>
select * from dept_copy;        -- <<��� ���̺� ����>>

update dept_original
set dname = 'PROGRAM2'
where dept_original.dno = 13;
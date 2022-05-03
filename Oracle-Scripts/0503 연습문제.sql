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
exec sp_job_dno(30);

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
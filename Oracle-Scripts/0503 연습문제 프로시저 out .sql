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
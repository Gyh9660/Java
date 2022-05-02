/*
    사원명, 부서명, 부서위치, 월급을 출력하세요

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
    dbms_output.put_line('사원명   부서명   부서위치   월급');
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
--2 %rowtype
set serveroutput on
declare
    v_employee employee%rowtype;
    v_department department%rowtype;
    
    cursor c1
    is
    select ename,dname,loc,salary
    from employee e, department d
    where e.dno = d.dno;
begin
    open c1;
    loop
        fetch c1 into v_employee.ename,v_department.dname,v_department.loc,v_employee.salary;
        exit when c1%notfound;
        dbms_output.put_line(v_employee.ename||'   '||v_department.dname||'   '||v_department.loc||'   '||v_employee.salary);
    end loop;
    close c1;
end;
/
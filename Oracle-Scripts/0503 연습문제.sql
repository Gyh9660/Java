/*
이름, 부서번호를 인풋 받아서 이름, 직책, 부서번호를 
출력하는 저장 프로시저를 생성하세요 (커서를사용)
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
        dbms_output.put_line('이름 '||v_ename||' 직책 '||v_job||' 부서번호 '||v_dno);
    end loop;
    close c1;
end;
/
select * from employee;
exec sp_job_dno(30);

/*테이블 이름 인풋 받아서 employee테이블 복사하여 생성하는 저장프로시져 생성
인풋값 emp_copy33*/
create or replace procedure sp_emp (
    v_empname in varchar2
    )
is
    c1 integer;
    v_sql varchar2(200); -- sql쿼리를 저장하는 변수

begin
    v_sql := 'CREATE TABLE ' ||v_empname || ' as select * from employee';
    --테이블 생성쿼리를 변수에 할당.
   
    c1 := DBMS_SQL.OPEN_CURSOR; --커서 사용
    DBMS_SQL.parse (c1, v_sql,dbms_sql.v7); --커서를 사용해서 sql쿼리를 실행
    DBMS_SQL.CLOSE_CURSOR(c1);      --커서중지
end;
/
--grant create table to public; sys 계정에서 실행 

exec sp_emp('emp_copy33');

select* from emp_copy33;
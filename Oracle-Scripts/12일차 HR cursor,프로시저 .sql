--cursor for loop 문으로 커서를 사용해서 여러 레코드셋 출력하기
    --open, close를 생략해서 사용,
    --한 테이블의 전체 내용을 출력 할때 사용

set serveroutput on
declare
    v_dept department%rowtype;
    cursor c1
    is
    select * from department;

begin
    dbms_output.put_line('부서번호   부서명   지역명');
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
    dbms_output.put_line('사원번호 사원명 업무 상사 입사일 월급 수당 부서번호');
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
    dbms_output.put_line('사원번호 사원명 월급 부서번호');
    dbms_output.put_line('--------------------------');
    for v_empl in c3 loop
        dbms_output.put_line(v_empl.eno||' '||v_empl.ename||' '||v_empl.salary||' '||v_empl.dno);
    end loop;
end;
/

--저장 프로시져 (stored procedure) , 함수 (Function), 트리거(Trigge)

/*
    저장프로시져의 장점
    1. PL/SQL을 사용가능하다. 자동화
    2. 성능이 빠르다.
        일반적인 SQL 구문 : 구문 분석 -> 개체이름확인 -> 사용권한 확인 ->최적화 -> 컴파일 ->실행
        저장프로시저 처음 실행 :구문 분석 -> 개체이름확인 -> 사용권한 확인 ->최적화 -> 컴파일 ->실행
        저장프로시져 두번째부터 실행 : 컴파일된(메모리에 로드된)컴파일이 바로 실행
        
    3. 입력 매개변수, 출력 매개변수를 사용할수 있다.
    4. 일련의 작업을 묶어서 저장할 수 있다.( 모듈화된 프로그래밍 가능)

*/
--1. 저장프로시져 생성.
    --스콧 사원의 월급을 출력하는 저장 프로시져;
create procedure sp_salary
is
    v_salary employee.salary%type; -- 저장프로시저는 is블락에서 변수를 선언
begin
    select salary into v_salary
    from employee
    where ename= 'SCOTT';
    
    dbms_output.put_line('SCOTT의 급여는 : ' ||v_salary || '입니다.');
end;
/

/* 저장프로시져 정보를 확인하는 데이터 사정*/
select * from user_source
where name = 'SP_SALARY';

/*3. 저장 프로시져 실행
execute sp_salary;
*/
-- 전체이름
EXECUTE sp_salary;
 -- 약식이름
exec sp_salary;

/*4. 저장 프로시져 수정*/
create or replace procedure sp_salary -- 없으면 생성 있으면 수정
is
    v_salary employee.salary%type; -- 저장프로시저는 is블락에서 변수를 선언
    v_commission employee.commission%type;
begin
    select salary,commission into v_salary,v_commission
    from employee
    where ename= 'SCOTT';
    
    dbms_output.put_line('SCOTT의 급여는 : ' ||v_salary ||
    '보너스는 : '||v_commission|| ' 입니다.');
end;
/

/*5. 저장 프로시저 삭제*/

drop procedure sp_salary;

-----<<인풋 매개변수를 처리하는 저장 프로시져>>-------
create or replace procedure sp_salary_ename( -- 입력 매개변수(in), 출력매개변수(out)를 정의
    v_ename in employee.ename%type -- 변수명 in 자료형
    --- <== 주의 : 매개변수가 여러개일때 , 로처리 ;는 넣으면 안된다
)
is -- 변수선언 (저장 프로시저에서 사용할 변수 선언 블락
    v_salary employee.salary%type;
    
begin
    select salary into v_salary -- 변수
    from employee
    where ename = v_ename; -- 인풋 매개변수 : v_ename
    
    dbms_output.put_line (v_ename ||'의 급여는 : ' ||v_salary || '입니다.');
end;
/

exec sp_salary_ename('KING');
exec sp_salary_ename('SCOTT');
exec sp_salary_ename('SMITH');
select * from employee;

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
exec sp_job_dno(10);

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


--저장프로시저 사용 문제--
--1. 각 부서별로 최소급여, 최대급여, 평균급여를 출력하는 저장프로시져를 생성하시오. 
--	[employee, department ] 테이블 이용
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
    DBMS_OUTPUT.PUT_line('부서번호   최소급여   최대급여   평균급여');
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

--2.  사원번호, 사원이름, 부서명, 부서위치를 출력하는 저장프로시져를 생성하시오.  
--	[employee, department ] 테이블 이용
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
    DBMS_OUTPUT.PUT_line('사원번호   사원이름   부서이름   부서위치');
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
--3. 급여를 입력 받아  입력받은 급여보다 높은 사원의 사원이름, 급여, 직책을 출력 하세요.
--	저장프로시져명 : sp_salary_b
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
    DBMS_OUTPUT.PUT_line('사원이름   급여   직책');
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


--4. 인풋 매개변수 : emp_c10, dept_c10  두개를 입력 받아 각각 employee, department 테이블을 복사하는 저장프로시져를 생성하세요. 
--	저장프로시져명 : sp_copy_table
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

--5. dept_c10 테이블에서 dno, dname, loc 컬럼의 값을 인풋 받아 인풋 받은 값을 insert하는 저장프로시져를 생성하시요. 
--	입력 값 : 50  'HR'  'SEOUL'
--	입력 값 : 60  'HR2'  'PUSAN' 
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

--6. emp_c10 테이블에서 모든 컬럼의 값을 인풋 받아 인풋 받은 값을 insert하는 저장프로시져를 생성하시요. 
--	입력 값 : 8000  'SONG'    'PROGRAMMER'  7788  sysdate  4500  1000  50 
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
--6번문제 job 컬럼 크기가 9이라 programmer 안들어가서 m뺏음

--7. dept_c10 테이블에서 4번문항의 부서번호 50의 HR 을 'PROGRAM' 으로 수정하는 저장프로시져를 생성하세요. 
--	<부서번호와 부서명을 인풋받아 수정하도록 하시오.> 
--	입력갑 : 50  PROGRAMMER 
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

--8. emp_c10 테이블에서 사원번호를 인풋 받아 월급을 수정하는 저장 프로시져를 생성하시오. 
--	입력 값 : 8000  6000
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

--9. 위의 두 테이블명을 인풋 받아 두 테이블을 삭제하는 저장프로시져를 생성 하시오. 
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

--------<< 출력 매개변수 사용>>-----------------
/* 저장 프로시저 : 출력 매개변수가 지원 (여러개의 ),
함수 : 출력 매개변수를 하나만 갖는다. 
        -- OUT 키워드를 사용.
        -- 저장프로시저를 호출시에 먼저 출력매개변수 변수선언후 호출이가능
        -- 호출시 출력매개변수 이름 앞에 ':변수명(출력매개변수명)'
        -- 출력 매개변수를 출력하기 위해서 PRINT 명령문이나 PL/SQL을 사용해서 출력 할수있다.
        

*/
create or replace procedure sp_salary_ename2 (
    v_ename in employee.ename%type,     --입력매개변수
    v_salary out employee.salary%type   --출력매개변수
)
is
begin
    select salary into v_salary
    from employee
    where ename = v_ename;
    
end;
/
select * from user_source where name = 'SP_SALARY_ENAME2';
--데이터 사전에서 확인.
select * from user_source where name = 'OUT1';

variable var_salary varchar2(50);
--호출부에서 아웃풋 매개변수를 선언
exec sp_salary_ename2('SCOTT',:var_salary);
-- :var_salary <=: 주의
print var_salary;

--OUT 파라미터를 여러개 가지는 저장프리시저 생성 및 출려 (PL/SQL)
--사원번호를 인풋받아서 사원이름,급여,직책 을 out파라미터에 넘겨주는
--프로시저를 PL/SQL을 사용해서 출력
create or replace procedure sel_empno( --in ,out: 자료형은 참조자료형
    v_eno in number,                --%type, 기본자료형(바이트수생략)을 쓸수잇다
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
-- PL/SQL을 사용해서 저장 프로시져 호출
declare
    v_ename varchar2(20);
    v_salary number(20);
    v_job varchar2(20);
begin
    --익명 블록에서는 저장프로시저 호출시 exec를 붙이지 않는다.
    sel_empno (7788,v_ename,v_salary,v_job); 
    --저장프로시저 호출 , 변수앞에 : 붙이지않음
    dbms_output.put_line('조회결과 : '||v_ename||' | '||v_salary||' | '||v_job);
    
end;
/







--10. 이름을 인풋 받아서 사원명, 급여, 부서번호, 부서명, 부서위치을 
--OUT 파라미터에 넘겨주는 프로시저를 PL / SQL에서 호출
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
    dbms_output.put_line('사원이름 : '||v_ename||', 급여 : '||v_salary||', 부서번호 : '||v_dno||', 부서이름 : '||v_dname||', 부서위치 : '||v_loc);
end;
/

--11-1. 부서번호를 받아서 사원명, 급여, 직책을 OUT 파라미터에 넘겨주는 프로시저를 PL / SQL에서 호출
--모르겟다 이건 
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
    end loop; -- dbms~_line 쓸때 연결 ||' '||로해야함 ,로하면 오류발생
    close c1;
end;
/

--11. 사원번호를 받아서 사원명, 급여, 직책,부서명,부서위치를 OUT 파라미터에 넘겨주는 프로시저를 PL / SQL에서 호출
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
    dbms_output.put_line('출력결과 : '||v_ename||'   '||v_salary||'   '||v_job||'   '||v_dname||'   '||v_loc);
end;
/


/* 함수 (Function) : 값을 넣어서 하나의 값을 반환 받아온다.
    함수 : SQL 구문 내에서 사용가능
    --비교, 저장프로시져는 out매개변수를 여러개 받아올수 있다.
    <== SQL구문 내에서는 사용불가.
    
*/

create or replace function fn_salary_ename ( -- 인풋매개변수
    v_ename in employee.ename%type
)
RETURN number     --호출하는 곳으로 값을 던져줌. 리턴할 자료형
is
    v_salary number(7,2);
begin
    select salary into v_salary
    from employee
    where ename = v_ename;      --인풋 매개 변수
    return v_salary;
end;
/

/*함수의 데이터 사전*/
select * from user_source
where name = 'FN_SALAY_ENAME';

--1. 함수사용
variable var_salary number;
exec :var_salary := fn_salary_ename('SCOTT');
print var_salary;

--2. 함수 사용 (SQL 구문 내에서 함수 사용)
select ename , fn_salary_ename('SCOTT') 월급 --<==이름만 가져온것 select 구문과 관계없음
from employee
where ename = 'SCOTT';


--함수 삭제
drop FUNCTION fn_salary_ename;
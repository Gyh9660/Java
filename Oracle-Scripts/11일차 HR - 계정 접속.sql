
--Object Privileges: 테이블, 뷰,트리거,함수
    --저장프로시져, 시퀀스, 인덱스에 부여되는 권한 할당
    /*
    =================================================
    권한      Table   view    SEQUENCE    PROCEDEUR
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
    --sys계정에서만가능
    -- 특정 테이블에 select 권한 부여 하기
    create user user_test10 identified by 1234; -- 계정 생성.
    
    --객체를 출력시 객체 명앞에 객체의 소유주명을 넣어줘야한다.
    -- 
    select * from hr.employee;
    
    select * from employee; --자기자신이 소유한 객체일떄는 생략가능
    
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


-------- PL/SQL : 오라클에서 프래그래밍 요소를 적용한 SQL, 유연하게 처리해서 적용
/*        MSSQL: T-SQL
 SQL : 구조화된 질의언어. 단점: 유연한 프로그래밍 기능을 적용할 수 없다.

*/

set serveroutput on --PL/SQL의 출력을 활성화

/* PL SQL의 기본 작성 구문*/

begin

    -- PL SQL 구문

end;
/


-- PL/SQL에서 기본 출력

set serveroutput on
begin
    dbms_output.put_line ('Welcome to Oracle');
end;
/

--자로형 선언
/*
    1. Oracle 의 자로형을 사용.
    2. 참조자료형 : 테이블의 컬럼의 선언된 자료형을 참조해서 사용.
        %type : 테이블의 특정 컬럼의 자료형을 참조해서 사용.
        %rowtype : 테이블 전체 컬럼의 자료형을 모두 참조해서 사용.

*/


-- PL/SQL에서 변수 선언
/* 변수명 := 값 */
set serveroutput on
declare -- 변수 선언 (변수 선언부)
    v_eno number(4);                -- 오라클의 자료형
    v_ename employee.ename%type;    -- 참조 자료형 : 다른 테이블의 컬럼
                                    -- 의 자료형을 참조해서 적용.
begin                              
    v_eno := 7788; -- := 변수의 값을 할당 할때 사용.
    v_ename := 'SCOTT';
    
    dbms_output.put_line('사원번호      사원이름');
    dbms_output.put_line('--------------------');
    dbms_output.put_line(v_eno|| '      '||v_ename);   
    
end;
/


/* 사원번호와 사원이름 출력 하기 */
set serveroutput on
declare
    v_eno employee.eno%type; -- employee의 eno컬럼의 타입(자료형)참조
    v_ename employee.ename%type;
    
begin
    dbms_output.put_line('사원번호      사원이름');
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

/* PL SQL에서 제어문 사용하기*/

/* if~ End if 문 사용하기*/

set serveroutput on
declare
    v_employee employee%rowtype; --rowtype : employee 테이블의 모든 컬럼의 자료형을 참조해서사용
                        --v_employee 변수는 employee테이블의 모든컬럼을 참조
    annsal number (7,2); -- 총연봉을 저장하는 변수
begin
    select * into v_employee
    from employee
    where ename = 'SCOTT';
    
    if (v_employee.commission is null)
    then v_employee.commission := 0;
    end if;
    
    annsal := v_employee.salary * 12 + v_employee.commission;
    dbms_output.put_line('사원번호  사원이름  연봉');
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

/*PL/SQL을 사용해서 department 테이블을 변수에담아서 출력
    조건은 dno = 20
*/
--1. %rowtype : 테이블의 모든 컬럼을 참조해서 사용

set serveroutput on
declare
    v_department department%rowtype;
begin
    select * into v_department
    from department
    where dno = 20;
    
    dbms_output.put_line('부서번호  부서이름  지역');
    dbms_output.put_line('--------------------');
    dbms_output.put_line(v_department.dno||'  '||v_department.dname||'  '||v_department.loc);

end;
/

--2. %type 변수의 data type을 테이블의 컬럼하나하나를 참조해서 할당.
set serveroutput on
declare
    v_dno department.dno%type;
    v_dname department.dname%type;
    v_loc department.loc%type;
begin
    select dno,dname,loc into v_dno,v_dname,v_loc
    from department
    where dno = 20;
    
    dbms_output.put_line('부서번호  부서이름  지역');
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
    
    dbms_output.put_line('사원번호   사원명   부서명');
    dbms_output.put_line('------------------------');
    dbms_output.put_line(v_eno||'   '||v_ename||'   '||v_dname);

end;
/

/* employee 테이블의 eno, ename , salary, dno 
PL/SQL을 사용해서 출력
조건
보너스 1400인 것에 대해서 출력
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
    
    DBMS_OUTPUT.PUT_line('사원번호   사원명   월급   부서번호');
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
    
    DBMS_OUTPUT.PUT_line('사원번호   사원명   월급   부서번호');
    DBMS_OUTPUT.PUT_line('-------------------------------');
    DBMS_OUTPUT.PUT_line(v_employee.eno||'   '||v_employee.ename||'   '||v_employee.salary||'   '||v_employee.dno);

end;
/


/* 커서 (cusor) :  PL/SQL에서 selcet 한 결과가 단일 레코드가 아니라 
레코드셋인 경우 커서가 필요하다.
*/
/*
declare

    cursor 커서명              1. 커서 선언
    is
    커서를 부착할 select 구문   

begin
    open 커서명 ;             2. 커서오픈
    loop
        fatch 구문        3.커서를 이동하고 출력
    end loop;
    close 커서명;          4. 커서를 종료
    
end;
/
*/

/* 커서를 사용해서 department 테이블의 모든 내용을 출력하기*/
set serveroutput on

declare
    v_dept department%rowtype; --변수 선언
    
    cursor c1                   --1. 커서 선언
    is
    select * from department;
    
begin
    dbms_output.put_line('부서번호   부서명   부서위치');
    dbms_output.put_line('-------------------------');
    open c1;                    --2. 커서오픈
    loop
        fetch c1 into v_dept.dno,v_dept.dname,v_dept.loc;
        exit when c1%notfound;
        dbms_output.put_line(v_dept.dno||'   '||v_dept.dname||'   '||v_dept.loc);
    end loop;
    close c1;                   --4. 커서종료

end;
/
/* 커서의 속성을 나타내는 속성값
커서명%notfound : 커서 영역 내의 모든 자료가 FETCH되었다면 true리턴
커서명%found : 커서 영역 내의 모든 자료가 FETCH되지 않았다면 true리턴
(커서영역 내의 FETCH 되지 않는 자료가 존재하면 true)
커서명%isopen : 커서가 오픈되었다면 true
커서명%rowcount : 커서가 얻어온 레코드 갯수

- SQL%ISOPEN: 쿼리가 실행되는 순간 CLOSE 되기 때문에 항상 FALSE.

- SQL%FOUND: 조회된 결과가 1개 이상인 경우 TRUE.

- SQL%NOTFOUND: 조회된 결과가 0개인 경우 TRUE.

- SQL%ROWCOUNT: 최근 수행된 쿼리의 결과행 수.
*/


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
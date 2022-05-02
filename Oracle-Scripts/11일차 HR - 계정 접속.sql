
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
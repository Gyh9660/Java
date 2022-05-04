--1.
set serveroutput on

create or replace procedure sp_ex1
is --변수 선언부, 커서 선언
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
    dbms_output.put_line('부서번호   최소급여   최대급여   평균급여');
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
     dbms_output.put_line('사원번호   사원이름   부서명   부서위치');
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
    v_emp employee%rowtype; -- 모든 컬럼의 자료형을 선언
    cursor c1
    is
    select ename, salary, job
    from employee
    where salary > v_salary;
begin
    dbms_output.put_line('사원이름   급여   직책');
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
--PL/SQL 내부에서 익명 블락에서 테이블을 생성 : grant create table to public; <==sys계정 으로접속
--저장 프로시저 실행후 : revoke create table from public;

create or replace procedure sp_ex4(
    v_emp in varchar2,
    v_dept in varchar2
) -- 주의 : ; 넣으면안됨, 자료형의 크기를 지정하면안됨
is
    c1 integer;
    v_sql1 varchar2(500); -- 테이블 생성 쿼리를 담을 변수
    v_sql2 varchar2(500);
begin
    v_sql1 := 'create table '||v_emp||' as select * from employee' ;
    v_sql2 := 'create table '||v_dept||' as select * from department';
    
    c1 := dbms_sql.open_cursor;     --커서 오픈
    dbms_sql.parse(c1, v_sql1,dbms_sql.v7);
    dbms_sql.parse(c1, v_sql2,dbms_sql.v7);
    dbms_sql.close_cursor(c1);      --커서 종료
    
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
    
    dbms_output.put_line('정상적으로 잘 입력이 되었습니다.');
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
    
    dbms_output.put_line('정상적으로 잘 입력이 되었습니다.');

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

    dbms_output.put_line('정상적으로 잘 입력이 되었습니다.');

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

    dbms_output.put_line('정상적으로 잘 입력이 되었습니다.');

end;
/

exec sp_ex8 ( 8000,6000);
select * from emp_c10;


--9.

create or replace procedure sp_ex9(
    v_emp in varchar2,
    v_dept in varchar2
) -- 주의 : ; 넣으면안됨, 자료형의 크기를 지정하면안됨
is
    c1 integer;
    v_sql1 varchar2(500); -- 테이블 생성 쿼리를 담을 변수
    v_sql2 varchar2(500);
begin
    v_sql1 := 'drop table '||v_emp;
    v_sql2 := 'drop table '||v_dept;
    
    c1 := dbms_sql.open_cursor;     --커서 오픈
    dbms_sql.parse(c1, v_sql1,dbms_sql.v7);
    dbms_sql.parse(c1, v_sql2,dbms_sql.v7);
    dbms_sql.close_cursor(c1);      --커서 종료
    
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
    and ename = v_ename; --v_ename을 조건으로해서
end;
/

declare --out 받을 변수 선언
    v_ename employee.ename%type;
    v_salary employee.salary%type;
    v_dno employee.dno%type;
    v_dname department.dname%type;
    v_loc department.loc%type;
begin
    --익명 블락에서는 exec /execute 를생략함, 값 앞에 : 도 생략
    sp_ex10('KING',v_ename,v_salary,v_dno,v_dname,v_loc);
    dbms_output.put_line('사원명  월급  부서번호  부서명  부서위치  ');
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
    dbms_output.put_line('사원명  월급  직책  부서명  부서위치  ');
    dbms_output.put_line('--------------------------------------');
    dbms_output.put_line(v_ename||'  '||v_salary||'  '||v_job||'  '||v_dname||'  '||v_loc);
end;
/

--트리거--
/* 트리거 (Trigger) : 권총의 방아쇠 (트리거), 방아쇠를 당기면 총알이 발사됨.
        -테이블에 부착되어 있다.
        -테이블에 이벤트가 발생될때 자동으로 작동되는 프로그램 코드
        -테이블에 발생되는 이벤트 (Insert, Update, Delete)
        -트리거에서 정의된 begin ~ end 사이의 문장이 실행됨.
        -before 트리거 : 테이블에서 트리거를 먼저 실행하고 insert,update,delete가 적용
        -after 트리거 : insert,update,delete가 실행후 트리거 실행
        --예 ) 주문 테이블에 값을 넣엇을때 배송테이블에 자동으로 적용
        --예 ) 중요 테이블의 로그를 남길때도 사용됨
        -- :new => 가상의 임시 테이블 , 트리거가 부착된 테이블에 새롭게 들어오는 레코드의 임시 테이블(insert)
        -- :old => 가상의 임시 테이블 , 트리거가 부착된 테이블에 삭제되는 레코드의 임시 테이블(delete)?
        -- 트리거는 하나의 테이블에 총 3개까지 부착이됨. (insert, update, delete)
*/
--실습 테이블 2개 생성 : 테이블의 구조만 복사
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

--트리거 생성 (dept_original 테이블에 부탁, insert이벤트가 발생될때 자동으로 작동)

create or replace trigger tri_sample1
    --트리거가 부착될 테이블, 이벤트(insert , update, delete),Before,after

    after insert            --insert 이벤트가 작동되고나서 트리거 발동(begin~end 사이의 코드)
    on dept_original        --on 부착될 테이블
    for each row            --모든 row에 대해서
begin       --트리거가 실행할 코드
    if inserting then
        dbms_output.put_line('Insert Trigger 발생!!!');
        insert into dept_copy
        values(:new.dno,:new.dname,:new.loc); -- new <== 가상임시테이블
    end if;
end;
/

/*트리거 확인 데이터 사전 : user_source*/
select * from user_source where name = 'TRI_SAMPLE1';


select * from dept_original;
select * from dept_copy;

insert into dept_original
values (13, 'PROGRAM2', 'PUSAN2'); 

/* delete 트리거 : dept_original 에서 제거하면 dept_copy에서 해당내용을 제거*/

create or replace trigger tri_del
    --트리거가 작동시킬 테이블, 이벤트
    after delete     -- 원본 테이블에 delete를 먼저 실행후 트리거 작동
    on dept_original -- dept_original테이블에 트리거 부착
    for each row
begin
    dbms_output.put_line('Delete Trigger 발생!!!');
    delete dept_copy
    where dept_copy.dno = :old.dno;     --dept_original에서 삭제되는 가상 임시 테이블 : old

end;
/

select * from dept_original;
select * from dept_copy;

delete dept_original
where dno = 15;

commit;

/* update 트리거 : dept_original테이블의 특정 값을수정하면 dept_copy 테이블의 내용을 업데이트*/

create or replace trigger tri_update
    after update
    on dept_original
    for each row
begin
    dbms_output.put_line('update trigger 발생!!!');
    update dept_copy
    set dept_copy.dname = :new.dname
    where dept_copy.dno = :old.dno;
end;
/

select * from dept_original;    -- <<주문 테이블 가정>>
select * from dept_copy;        -- <<배송 테이블 가정>>

update dept_original
set dname = 'PROGRAM2'
where dept_original.dno = 13;
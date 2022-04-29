show user;

--최고 관리자 계정(sys) : 계정을 생성할 수 있는 권한을 가지고 있다.

--아이디 : usertest01 비밀번호 : 1234
create user usertest01 identified by 1234;

--계정과 암호를 생성했다고 해서 오라클에서 접속(X) 접속할 수 있는 권한을 부여받아야 접속가능

--system privileges :
    -- create session : 오라클에 접속할수있는 권한
    -- create table : 오라클에서 테이블을 생성할수있는권한
    -- create sequence : 시퀀스를 생성할 수 있는 권한
    -- create view : 뷰를 생성 할 수 있는 권한.

-- 생성한 계정에게 오라클에 접속할 수 있는 create session 권한을 부여

/*
    DDL : 객체생성 (create , alter ,drop)
    DML : 레코드 조작 (insert, update , delete)
    DQL : 레코드 검색 (select)
    DTL : 트랜잭션 ( Begin transaction, rollback, commit)
    DCL : 권한관리 ( grant ,revoke ,deny)
    
*/

--생성한 계정에게 오라클에 접속 할 수 있는 create session 권한을 부여
-- grant 부여할권한 to 계정명
grant create session to usertest01;

-- 오라클에 접속할수있다고 해서 다른권한이 있는건아님 (테이블접근권한...)
grant create table to usertest01;

/* 테이블 스페이스 (Table Space) : 객체 (테이블,뷰,시퀀스,인덱스,트리거,저장프로시저,함수....)
    를 저장하는 공간. 관리자 계정에서 각 사용자별 테이블 스페이스를 확인.
    일반계정에서는 확인 x
    system : dba (관리자 계정에서만 접근가능)
*/
select * from dba_users;  --dba_ 는 최고관리자(sys)계정에서만 사용가능(확인가능)
-- default_tablespace / temporary_tablespace 주로 확인 주요확인?

select username, default_tablespace as DataFile , temporary_tablespace LogFile
from dba_users
where username in ('HR', 'USERTEST01');

--계정에게 테이블 스페이스 변경 (system ==> users) 변경
alter user usertest01
default tablespace users --DataFile 저장 :객체가 저장되는 공간(테이블,뷰,트리거,인덱스...)
temporary tablespace temp; -- LOG를 저장 : DML (Insert ,Update, Delete)
-- LOG를 호칭할때 Transaction log : 시스템의 문제 발생시 백업시점이 아니라 오류난 시점까지 복원하기 위해서 필요

--테이블 스페이스 : 객체와 로그를 저장하는 물리적인 파일
    --DataFile : 객체를 저장하고 있다. (테이블,뷰,인덱스....)
    --Log : Transaction Log 를 저장
    
    -- DataFile과 Log 파일은 물리적으로 다른 하드공간에 저장해야 성능을 높일수 있다.
        --RAID된 공간에 저장하면 성능을 높일 수 있다.



-- 계정에게 users 테이블 스페이스를 사용할수 있는 공간 할당. (users 테이블 스페이스에 2mb를 사용할수있는 공간 할당)
alter user usertest01
quota 2m on users;

-------------------------------------
--문제: usertest02 계정을 생성후에 users 테이블 스페이스에서 테이블 (tbl2) 생성후에 insert
create user usertest02 identified by 1234;

grant create session to usertest02;

grant create table to usertest02;

alter user usertest02
default tablespace users
temporary tablespace temp;

alter user usertest02
quota 2m on users;
--alter user usertest02 quota unlimit on users <== unlimit라는 옵션이 있긴잇음.

select username, default_tablespace as DataFile , temporary_tablespace LogFile
from dba_users
where username in ('USERTEST02');

select * from all_tables --테이블의 소유주를 출력해 준다. 계정별로 소유한 테이블을 출력
where owner in ('HR','USERTEST01','USERTEST02');

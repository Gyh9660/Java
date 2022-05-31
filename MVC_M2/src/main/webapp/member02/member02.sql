select * from member02;

drop table member02;

create table member02 (
    u_id varchar2(50) not null primary key, --메일 주소
    u_pass varchar2(50) not null,         --암호화 해서 DB저장
    u_name varchar2(50) not null,
    r_date date default sysdate not null,
    u_address varchar2(200) not null,
    u_tel varchar2 (50) not null,
    u_birthday date not null
    );
    
    select * from member02;
    
    insert into member02
    values ('admin@kosmo.com','12341234','관리자',default,'서울시','010-1234-1234',sysdate);
    
    insert into member02
    values ('hong@kosmo.com','12341234','홍길동',default,'부산시','010-2345-2345',sysdate);
    
    commit;
    
    
   logon02 : LogonDTO,java ,LogonDAO.java
   member02 : 회원 가입 처리 (DB 에insert) , ID와 PAss 인증 처리 <==AJAX 사용해서 처리
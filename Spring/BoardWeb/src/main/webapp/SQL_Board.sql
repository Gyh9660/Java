create table USERS (
ID varchar2(8) primary key,
PASS varchar2(8),
NAME varchar2(20),
ROLE varchar2(5)
);

insert into USERS values ( 'admin','1234','관리자','Admin');

insert into USERS values ( 'user','1234','홍길동','User');

select * from users

create table board (
SEQ number(5) primary key,
TITLE varchar2(200) ,
WRITER varchar2(20),
CONTENT varchar2(2000),
REG_DATE date default sysdate,
CNT number(5) default 0
);

insert into board values( 1,'가입 인사','관리자','안녕하세요 반갑습니다.',default,default);

select * from board
select * from user01;

create table user01(
    u_id varchar2(20) not null primary key,
    pass varchar2(20) not null,
    u_name varchar2(10) not null,
    phone varchar2(15) not null,
    email varchar2(30) not null,
    zip_code varchar2(10) not null,
    address varchar2(100) not null,
    u_date date default sysdate not null
);
/*
create table movie (
  m_id number not null primary key,
  title varchar2(20) not null, --제목
  type varchar2(10) not null, --공포,액션 .....
  m_date date default sysdate not null,
  price number not null, --티켓 가격?
  image varchar2(30) not null, -- 사진
  stock number not null, -- 남은좌석..?
  content varchar2(1500) not null -- 영화소개
  -- 제작자, 출연, 상영일
);
*/
select * from pro;
create table pro(
  p_id number not null primary key,
  p_name varchar2(20) not null,
  p_type varchar2(100) not null,
  p_date date default sysdate not null,
  price number not null,
  image varchar2(30) not null,
  stock number not null,
  review varchar2(1500) null
);
drop table pro;
drop sequence seq_pro_num;
create SEQUENCE seq_pro_num
    INCREMENT by 1
    start with 1
    nocache;

create table order( -- ->예약으로 변경?
    o_id number not null primary key,
    m_id varchar2(20) not null,
    p_id number not null,
    qua number not null,
    total_amo number not null,
    o_date date default sysdate not null,
    constraint FK_order_mid_mem_mid foreign key (m_id) references mem(m_id).
    constraint FK_order_pid_pro_pid foreign key (p_id) references pro(p_id)
   
);

create table qnaboard(
    q_id number constraint PK_qnaboard_id primary key, 
    u_id varchar2(20) not null,
    subject varchar2(100) not null,
    content varchar2(2000) not null,
    inputdate date default sysdate not null,
    readcount number default 0,
    masterid number default 0 , 
    replaynum number default 0, 
    step number default 0,
    constraint FK_qna_uid_user_uid foreign key (u_id) references user01(u_id)
);
create SEQUENCE seq_qna_num
    INCREMENT by 1
    start with 1
    nocache;
drop sequence seq_qna_num; 
drop table qnaboard;
select * from qnaboard order by q_id desc ;
select * from qnaboard;
insert into qnaboard values(seq_qna_num.nextval,'qw!@12','1번-2','1223534',sysdate,default,seq_qna_num.currval,3,3);
commit;
select max(q_id) from  qnaboard;
 SELECT * FROM (     SELECT Tb.*, ROWNUM rNum FROM (         SELECT * FROM qnaboard         ORDER BY q_id DESC     ) Tb  )  WHERE rNum BETWEEN 1 AND 10;
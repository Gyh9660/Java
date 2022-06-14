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

create SEQUENCE seq_pro_num
    INCREMENT by 1
    start with 1
    nocache;

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

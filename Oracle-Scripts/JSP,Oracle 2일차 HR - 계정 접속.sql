
--회원 정보를 저장하는 테이블
create table mbTbl (
    idx number not null,        -- 시퀀스 부착, 자동증가 컬럼.
    id varchar2(100) not null,
    pass varchar2(100) not null,
    name varchar2(100) not null,
    email varchar2(100) not null,
    city varchar2(100) null,
    phone varchar2(100) null
);

select * from mbtbl;

alter table mbtbl
add constraint mbtbl_id_pk primary key(id);

create SEQUENCE seq_mbTbl_idx
    INCREMENT by 1
    START with 1
    NOCACHE;
    
/*더미 데이터 입력*/
insert into mbTbl (idx,id,pass,name,email,city,phone)
values (seq_mbTbl_idx.nextval,'admin','1234','관리자','kosmo@kosmo.com','서울','010-1111-1111');

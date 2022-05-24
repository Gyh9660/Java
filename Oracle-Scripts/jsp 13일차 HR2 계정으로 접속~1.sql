create table t_member2 (
    id varchar2(10) primary key,
    pwd varchar2(10) not null,
    name varchar2(50) not null,
    email varchar2(100) null,
    joinDate date default sysdate
    );
    
        --더미 데이터 입력
insert into t_member2
values ('hong', '1234', '홍길동','hong@gamil.com',sysdate);
insert into t_member2
values ('lee', '1234', '이순신','lee@gamil.com',sysdate);
insert into t_member2
values ('kim', '1234', '김유신','kim@gamil.com',sysdate);

select * from t_member2;

desc t_member2;
commit;
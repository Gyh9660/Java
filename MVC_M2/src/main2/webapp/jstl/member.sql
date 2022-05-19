
drop table member;

create table member (
    id varchar2(100) not null primary key,
    pass varchar2(100),
    name varchar2(100)
    );
    
    insert into member values ('1','1234','홍길동');
    insert into member values ('2','1235','김똘똘');
    
    commit;
    
    select * from member;
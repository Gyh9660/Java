select * from mvcboard;

/*
1. db���� -> 2. dto ����
*/


create table t_member (
    id varchar2(10) primary key,
    pwd varchar2(10) not null,
    name varchar2(50) not null,
    email varchar2(100) null,
    joinDate date default sysdate
    );
    --���� ������ �Է�
insert into t_member
values ('hong', '1234', 'ȫ�浿','hong@gamil.com',sysdate);
insert into t_member
values ('lee', '1234', '�̼���','lee@gamil.com',sysdate);
insert into t_member
values ('kim', '1234', '������','kim@gamil.com',sysdate);

select * from t_member order by id desc;
select * from (select Tb.*, ROWNUM rNum from ( select * from t_member order by id desc)Tb);
desc t_member;
commit;
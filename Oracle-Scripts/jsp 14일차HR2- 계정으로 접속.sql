select * from member;

drop table member;

create table member (
    id varchar2(10) not null,
    pass varchar2(10) not null,
    name varchar2(30) not null,
    regidate date default sysdate not null,
    primary key (id)
);
--���� ������ �Է�
insert into member ( id, pass, name)
values ('admin','1234','������');

insert into member ( id, pass, name)
values ('hong','1234','ȫ�浿');

select * from member;

commit;

-- ȸ�� ����� ��Ÿ���� �÷�

create table member03 (
    id varchar2(10) not null,
    pass varchar2(10) not null,
    name varchar2(30) not null,
    regidate date default sysdate not null,
    grade varchar2(50) not null, 
    primary key (id)
);

--���� ������ �Է�
insert into member03 ( id, pass, name,grade)
values ('admin','1234','������','vip');

insert into member03 ( id, pass, name,grade)
values ('hong','1234','ȫ�浿','gold');

insert into member03 ( id, pass, name,grade)
values ('kim','1234','������','silver');

select * from member03;

commit;

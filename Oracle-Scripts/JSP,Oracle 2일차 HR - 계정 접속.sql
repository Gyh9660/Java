
--ȸ�� ������ �����ϴ� ���̺�
create table mbTbl (
    idx number not null,        -- ������ ����, �ڵ����� �÷�.
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
    
/*���� ������ �Է�*/
insert into mbTbl (idx,id,pass,name,email,city,phone)
values (seq_mbTbl_idx.nextval,'admin','1234','������','kosmo@kosmo.com','����','010-1111-1111');

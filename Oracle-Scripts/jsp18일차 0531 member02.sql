select * from member02;

drop table member02;

create table member02 (
    u_id varchar2(50) not null primary key, --���� �ּ�
    u_pass varchar2(50) not null,         --��ȣȭ �ؼ� DB����
    u_name varchar2(50) not null,
    r_date date default sysdate not null,
    u_address varchar2(200) not null,
    u_tel varchar2 (50) not null,
    u_birthday date not null
    );
    
    select * from member02;
    
    insert into member02
    values ('admin@kosmo.com','12341234','������',default,'�����','010-1234-1234',sysdate);
    
    insert into member02
    values ('hong@kosmo.com','12341234','ȫ�浿',default,'�λ��','010-2345-2345',sysdate);
    
    commit;

create table b_user(
u_id varchar2 (30) not null primary key,
u_pass varchar2 (30) not null,
email varchar2 (40) not null,
grade varchar2 (20) default '1' not null,
phone varchar2 (20) not null,
nick varchar2 (20) not null,
u_name varchar2 (20) not null,
u_profile varchar2 (40) default 'none' not null,
point number default 0 not null,
apoint number default 0 not null,
u_date date default sysdate not null
);
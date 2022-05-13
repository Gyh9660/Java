
create table guestboard(
    name varchar2(10),
    email varchar2(50),
    inputdate varchar2(40) primary key,
    subject varchar2(20),
    content varchar2(2000)
    );
    drop table guestboard;
    select * from guestboard;
    
    insert into guestboard (name,email,inputdate,subject,content)
    values ('33','33',to_char(sysdate, 'yyyy-mm-dd hh:mi:ss'),'33','33');
    

create table guestboard2 (
	name varchar2(100),
	email varchar2(100),
	inputdate varchar2 (100) primary key,
	subject varchar2(100),
	content varchar2(2000)
	);
    
    select * from guestboard2;
    
desc guestboard2;

insert into guestboard2 (name,email,inputdate,subject,content)
values( '홍길동6','kim@cacaca.com','2022. 5. 16. 오전 11:55:22','제목입니다.','내용입니다.');
commit;


select * from guestboard2 order by inputdate desc;

delete guestboard2
where name = 'null';


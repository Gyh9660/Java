
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
values( 'ȫ�浿6','kim@cacaca.com','2022. 5. 16. ���� 11:55:22','�����Դϴ�.','�����Դϴ�.');
commit;


select * from guestboard2 order by inputdate desc;

delete guestboard2
where name = 'null';



/*
insert into freeboard(id,name,password,email,subject,content,
inputdate,masterid,readcount,replaynum,step)
values(36, 'ȫ�浿 5', '1234','ccc@ccc.com', '����5', '���� 5 ���� 5 \' ���� 5',
'22-05-13 11:54 ����',41,0,0,0);
*/
select * from freeboard
order by id desc;

select * from freeboard
order by masterid desc, replaynum asc , step asc, id asc;

select * from freeboard
where masterid in (select masterid from freeboard where id =36);
-- masterid     : �亯���� �׷���
-- replaynum    : 0 = ó����, 1 = ó������ �亯��1, 2 = ó������ �亯��2
-- step         : 0 = ó����, 1 = �亯��, 2 = �亯���� �亯��, <= ���Ǳ���

select * from freeboard
order by masterid desc, replaynum, step, id;
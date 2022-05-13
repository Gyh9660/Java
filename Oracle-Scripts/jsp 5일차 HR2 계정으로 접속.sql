
/*
insert into freeboard(id,name,password,email,subject,content,
inputdate,masterid,readcount,replaynum,step)
values(36, '홍길동 5', '1234','ccc@ccc.com', '제목5', '내용 5 내용 5 \' 내용 5',
'22-05-13 11:54 오전',41,0,0,0);
*/
select * from freeboard
order by id desc;

select * from freeboard
order by masterid desc, replaynum asc , step asc, id asc;

select * from freeboard
where masterid in (select masterid from freeboard where id =36);
-- masterid     : 답변글의 그룹핑
-- replaynum    : 0 = 처음글, 1 = 처음글의 답변글1, 2 = 처음글의 답변글2
-- step         : 0 = 처음글, 1 = 답변글, 2 = 답변글의 답변글, <= 글의깊이

select * from freeboard
order by masterid desc, replaynum, step, id;
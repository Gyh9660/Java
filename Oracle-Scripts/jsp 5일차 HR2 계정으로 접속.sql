
select * from freeboard;

select * from freeboard
order by masterid desc, replaynum , step, id;
select * from freeboard
where masterid in (select masterid from freeboard where id =36);
-- masterid     : 답변글의 그룹핑
-- replaynum    : 0 = 처음글, 1 = 처음글의 답변글1, 2 = 처음글의 답변글2
-- step         : 0 = 처음글, 1 = 답변글, 2 = 답변글의 답변글, <= 글의깊이

select * from freeboard
order by masterid desc, replaynum, step, id;

select * from freeboard;

select * from freeboard
order by masterid desc, replaynum , step, id;
select * from freeboard
where masterid in (select masterid from freeboard where id =36);
-- masterid     : �亯���� �׷���
-- replaynum    : 0 = ó����, 1 = ó������ �亯��1, 2 = ó������ �亯��2
-- step         : 0 = ó����, 1 = �亯��, 2 = �亯���� �亯��, <= ���Ǳ���

select * from freeboard
order by masterid desc, replaynum, step, id;
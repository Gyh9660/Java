create table test111( 
     inputdate varchar2(40)
     );

insert into test111(inputdate)
values(to_char(sysdate, 'yyyy-mm-dd hh:mi:ss'));

select * from test111;

create table testtbl(
    a number not null,
    b number null,
    c varchar2(10) null
    );

insert into testtbl
values (1,1,'������');

select * from testtbl;
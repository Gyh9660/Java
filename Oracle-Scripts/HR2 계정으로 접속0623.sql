create table user1(
 userID varchar2(50) not null,
 userPassword varchar2(50) not null,
 userName varchar2(50) not null,
 userGender varchar2(50) not null,
 userEmail varchar2(50) not null
 );
 
 
 create table product(
 productId NUMBER not null,
 pname varchar2(2000) not null,
 unitPrice varchar2(50) not null,
 description varchar2(4000) not null,
 manufacturer varchar2(50) not null,
 category varchar2(50) not null,
 filename varchar2(200) not null,
 quantity varchar2(50) not null
 );
 
 

create sequence productId
 increment by 1
 start with 1;
 
 
update product
set filename='36'
where filename='ÆíÁý_p-36-1.jpg';



create table cart(
    name varchar2(200),
    price int,
    qnt int, 
    sumPrice int,
    userId varchar2(200));



create table order1(
    userid varchar2(20),
    address varchar2(50),
    orderdate date default sysdate,
    arrive varchar2(20),
    ojname varchar2(100),
    ojprice int,
    ojqnt int,
    totalprice int,
    sumprice int
);


create table bbs(
    bbsId int,
    bbsTitle varchar2(200),
    userId varchar2(200),
    bbsDate date default sysdate,
    bbsContent varchar2(2000),
    bbsAvailable int
    );
    
select * from bbs;


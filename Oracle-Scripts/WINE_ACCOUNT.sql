
create table grade_pt_rade (
    men_grade varchar2(20) not null constraint PK_grade_pt_rade_men_grade primary key,
    grade_pt_rate number(3,2)
    );
    
insert into grade_pt_rade
values ('gold',3);

insert into grade_pt_rade
values ('silver',1.5);

insert into grade_pt_rade
values ('VIP',5);

select * from grade_pt_rade;

select * from user_constraints
where table_name in('GRADE_PT_RADE','MEMBER','STOCK_MANAGEMENT','WINE_TYPE','MANAGER','THEME','WINE','NATION','TODAY','SALE');

create table member (
    mem_id varchar2(6) not null constraint PK_member_mem_id primary key,
    mem_grade varchar2(20) null,
    mem_pw varchar2(20) not null,
    mem_birth date default sysdate not null,
    mem_tel varchar2(20) null,
    mem_pt varchar2(10) default 0 not null,
    constraint FK_member_mem_grade foreign key (mem_grade) references grade_pt_rade(men_grade)
    );
insert into member
values ('aaaaaa','silver','123456',default,'010-0000-0000','1000');

insert into member
values ('bbbbbb','gold','123456','2022-01-01','010-1111-1111','5000');

insert into member
values ('cccccc','VIP','123456',to_date(20211212,'YYYY-MM-DD'),'010-2222-2222','10000');

select * from member;

create table today(
    today_code varchar2(6) not null constraint PK_today_today_code primary key,
    today_sens_value number(3) null,
    today_intell_value number(3) null,
    today_phy_value number(3) null
    );
insert into today
values ('aa1234',3,5,6);

insert into today
values ('b25234',6,3,1);

insert into today
values ('a2hf34',7,4,8);

select * from today;

create table nation(
    nation_code varchar2(26) not null constraint PK_nation_nation_code primary key,
    nation_name varchar2(50) not null
    );

insert into nation
values ('bb1234','한국');

insert into nation
values ('hs1e34','일본');

insert into nation
values ('abcdef12345678','미국');

select * from nation;

create table theme(
    theme_code varchar2(6) not null constraint PK_theme_theme_code primary key,
    theme_name varchar2(50) not null
    );
    
insert into theme
values ('theme1','봄');

insert into theme
values ('theme2','여름');

insert into theme
values ('theme3','가을');

select * from theme;

create table wine_type(
    wine_type_code varchar2(6) not null constraint PK_wine_type_wine_type_code primary key,
    wine_type_name varchar2(50)
    );
 
insert into wine_type
values ('type01','화이트와인');

insert into wine_type
values ('type02','레드와인');

insert into wine_type
values ('type03','와인');

select * from wine_type;

create table wine(
    wine_code varchar2(26) not null constraint PK_wine_wine_code primary key,
    wine_name varchar2(100) not null,
    wine_url blob null,
    nation_code varchar2(6) null,
    wine_type_code varchar2(6) null,
    wine_sugar_code number(2) null,
    wine_price number(15) default 0 not null,
    wine_vintage date null,
    theme_code varchar2(6) null,
    today_code varchar2(6) null,
    constraint FK_wine_nation_code foreign key(nation_code) references nation(nation_code),
    constraint FK_wine_wine_type_code foreign key(wine_type_code) references wine_type(wine_type_code),
    constraint FK_wine_theme_code foreign key(theme_code) references theme(theme_code),
    constraint FK_wine_today_code foreign key(today_code) references today(today_code)
    );
    
insert into wine
values ('winecode01','wine1','1111','bb1234','type01',5,default,sysdate,'theme1','aa1234');
    
insert into wine
values ('winecode02','wine2','1112','hs1e34','type02',7,10000000,'2000-01-01','theme2','b25234');

insert into wine
values ('wine03','wine3','1113','hs1e34','type03',10,25142142,'1990-11-22','theme3','a2hf34');

select * from wine;
     
create table sale( --구매 관련 정보 관리
    sale_date date default sysdate not null constraint PK_sale_sale_date primary key,
    wine_code varchar2(6) not null,
    mem_id varchar2(30) not null,
    sale_amount varchar2(5) default 0 not null,
    sale_price varchar2(6) default 0 not null,
    sale_tot_price varchar2(15) default 0 not null,
    constraint FK_sale_wine_code foreign key(wine_code) references wine(wine_code),
    constraint FK_sale_mem_id foreign key(mem_id)references member(mem_id)
    );

insert into sale
values (sysdate,'wine03','aaaaaa',default,default,default);

insert into sale
values (sysdate-1,'wine03','bbbbbb','12','55000','10000');

insert into sale
values ('2002-05-05','wine03','cccccc','2','5000','1000');

select * from sale;

create table manager(
    manager_id varchar2(30) not null constraint PK_manager_manager_id primary key,
    manager_pwd varchar2(20) not null,
    manager_tel varchar2(20)
    );
    
insert into manager
values('ma01','1234','010-9999-9999');

insert into manager
values('ma02','1234','010-8888-8888');

insert into manager
values('ma03','1234','010-7777-7777');

select * from manager;

create table stock_management (
    stock_code varchar2(6) not null constraint PK_stock_management_stock_code primary key,
    wine_code varchar2(6) null,
    manager_id varchar2(30) null,
    ware_date date default sysdate not null,
    stock_amount number(5) default 0 not null,
    constraint FK_stock_management_wine_code foreign key(wine_code) references wine(wine_code),
    constraint FK_stock_management_manager_id foreign key(manager_id) references manager(manager_id)
    );

insert into stock_management
values ('0001','wine03','ma01',default,default);

insert into stock_management
values ('0002','wine03','ma02',sysdate,40);

insert into stock_management
values ('0003','wine03','ma03',to_date(20110124,'YYYYMMDD'),60);

select * from stock_management;

commit;
----------------확인----------------------------

select * from user_constraints
where table_name in('GRADE_PT_RADE','MEMBER','STOCK_MANAGEMENT','WINE_TYPE','MANAGER','THEME','WINE','NATION','TODAY','SALE');

select * from sale;
select * from member;
select * from grade_pt_rade;
select * from today;
select * from nation;
select * from wine;
select * from theme;
select * from stock_management;
select * from manager;
select * from wine_type;
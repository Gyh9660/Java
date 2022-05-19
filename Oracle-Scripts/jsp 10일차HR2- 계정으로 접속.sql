create table mvcboard (
    idx number primary key,
    name varchar2(50) not null,
    title varchar2(200) not null,
    content varchar2(2000) not null,
    postdate date default sysdate not null,
    ofile varchar2(200),
    afile varchar2(50),
    downcount number(5) default 0 not null,
    pass varchar2(50) not null,
    visitcount number default 0 not null
    );
    
create SEQUENCE seq_board_num
    INCREMENT by 1
    start with 1
    nocache;
    
-- ���� ������ �Է� ( 5�� ���� �� �Է�    

insert into mvcboard (idx,name,title,content,pass)
values(SEQ_BOARD_NUM.nextval,'������','�ڷ�� ����1 �Դϴ�','����1','1234');

insert into mvcboard (idx,name,title,content,pass)
values(SEQ_BOARD_NUM.nextval,'�庸��','�ڷ�� ����2 �Դϴ�','����2','1234');

insert into mvcboard (idx,name,title,content,pass)
values(SEQ_BOARD_NUM.nextval,'�̼���','�ڷ�� ����3 �Դϴ�','����3','1234');

insert into mvcboard (idx,name,title,content,pass)
values(SEQ_BOARD_NUM.nextval,'������','�ڷ�� ����4 �Դϴ�','����4','1234');

insert into mvcboard (idx,name,title,content,pass)
values(SEQ_BOARD_NUM.nextval,'������','�ڷ�� ����5 �Դϴ�','����5','1234');

commit;

select * from mvcboard;

desc mvcboard;

-- DB���� Ư�� ���ڵ常 ����Ҷ� (�˻� ���� ���)
SELECT * FROM (
SELECT Tb.*, ROWNUM rNum FROM (
SELECT * FROM mvcboard ORDER BY idx DESC)Tb)
WHERE rNum BETWEEN 1 AND 2;

-- �˻� ����� ����ؼ� ���
SELECT * FROM (
SELECT Tb.*, ROWNUM rNum FROM (
SELECT * FROM mvcboard where title like '%����%' 
ORDER BY idx DESC)Tb)
WHERE rNum BETWEEN 1 AND 2;

desc mvcboard;

select * from mvcboard
where idx = 5;

select count(*) from mvcboard
where pass = '12344' and idx = '1';

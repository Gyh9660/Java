
create table freeboard (
    id number constraint PK_freeboard_id primary key, --�ڵ� ���� �÷�
    name varchar2(100) not null,
    password varchar2(100) null,
    email varchar2(100) null,
    subject varchar2(100) not null, -- ������
    content varchar2(2000) not null, -- �۳���
    inputdate varchar2(100) not null, -- �۾� ��¥
    masterid number default 0 , -- �����亯�� �Խ��ǿ��� �亯�� ���� �׷����Ҷ� ��� 
    readcount number default 0, -- �� ��ȸ��
    replaynum number default 0,  -- �����亯�� �Խ��ǿ��� �亯�� ���� �׷����Ҷ� ���
    step number default 0  -- �����亯�� �Խ��ǿ��� �亯�� ���� �׷����Ҷ� ���
    );
    
select * from freeboard where id = 3;
desc freeboard;
delete freeboard;
commit;
insert into freeboard (
id,name,password,email,subject, 
content, inputdate, masterid, readcount, replaynum, step)
values (1,'ȫ��','1234','bbbb@bbb.com',
'ù��° ���Դϴ�.','ù ��° �����Դϴ�. �� ���� �Դϴ�. �� ���� 2 �Դϴ�.',
'22-05-11 11:54 ����',1,0,0,0);


-- �亯���� �����ϴ� ���̺��� ��� �Ҷ�, ������ �� �ؼ� �����;� �Ѵ�.
select * from freeboard order by masterid desc, replaynum, step, id;
-- masterid �� �������� desc�ؼ� �����;���, replayunm, step, id �� asc�� �����Ǿ��ִ�.
    --masterid �÷��� �ߺ��� ���� ������� , replaynum �� asc����, 
        -- replaynum���� �ߺ��Ȱ��� ������ ��� step�� asc����,
            --step���� �ߺ��Ȱ��� ������ ��� id�� asc����
select * from freeboard
order by id desc;

-- id �÷� : ���ο� ���� ��ϵ� �� ������ id�÷��� �ִ밪�� �����ͼ� +1 
-- <= �� �� ��ȣ�� �ѹ���
-- �亯���� ó���ϴ� �÷��� 3�� �ʿ��ϴ�. (masterid , replyNum, sep)
-- masterid     : ���� �亯�� ���� �׷��� , id �÷��� ���� �״�� �� ���, �亯�ฮ �ƴϴ�, ó����
    
-- replyNum     : �亯 �ۿ� ���� �ѹ��� (1,2,3.....)
-- step         : �亯 ���� ���� �ѹ��� (0,1,2,3,.....)
        -- 0 -> ó���� (�ڽ��� ��, �亯x)
        -- 1 -> ó������ �亯��
        -- 2 -> ó������ �亯���� �亯�� ......
        -- 3 -> ó������ �亯���� �亯���� �亯��..........
        
        
        
        
        

create table freeboard2 (
    id number constraint PK_freeboard2_id primary key, --�ڵ� ���� �÷�
    name varchar2(100) not null,
    password varchar2(100) null,
    email varchar2(100) null,
    subject varchar2(100) not null, -- ������
    content varchar2(2000) not null, -- �۳���
    inputdate varchar2(100) not null, -- �۾� ��¥
    masterid number default 0 , -- �����亯�� �Խ��ǿ��� �亯�� ���� �׷����Ҷ� ��� 
    readcount number default 0, -- �� ��ȸ��
    replynum number default 0,  -- �����亯�� �Խ��ǿ��� �亯�� ���� �׷����Ҷ� ���
    step number default 0  -- �����亯�� �Խ��ǿ��� �亯�� ���� �׷����Ҷ� ���
    );
    
select * from freeboard2;        
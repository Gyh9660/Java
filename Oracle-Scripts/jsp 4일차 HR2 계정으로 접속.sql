
create table freeboard (
    id number constraint PK_freeboard_id primary key, --자동 증가 컬럼
    name varchar2(100) not null,
    password varchar2(100) null,
    email varchar2(100) null,
    subject varchar2(100) not null, -- 글제목
    content varchar2(2000) not null, -- 글내용
    inputdate varchar2(100) not null, -- 글쓴 날짜
    masterid number default 0 , -- 질문답변형 게시판에서 답변의 글을 그룹핑할때 사용 
    readcount number default 0, -- 글 조회수
    replaynum number default 0,  -- 질문답변형 게시판에서 답변의 글을 그룹핑할때 사용
    step number default 0  -- 질문답변형 게시판에서 답변의 글을 그룹핑할때 사용
    );
    
select * from freeboard where id = 3;
desc freeboard;
delete freeboard;
commit;
insert into freeboard (
id,name,password,email,subject, 
content, inputdate, masterid, readcount, replaynum, step)
values (1,'홍길','1234','bbbb@bbb.com',
'첫번째 글입니다.','첫 번째 내용입니다. 글 내용 입니다. 글 내용 2 입니다.',
'22-05-11 11:54 오전',1,0,0,0);


-- 답변글이 존재하는 테이블을 출력 할때, 정렬을 잘 해서 가져와야 한다.
select * from freeboard order by masterid desc, replaynum, step, id;
-- masterid 를 기준으로 desc해서 가져와야함, replayunm, step, id 는 asc가 생략되어있다.
    --masterid 컬럼에 중복된 값이 있을경우 , replaynum 을 asc정렬, 
        -- replaynum에도 중복된값이 존재할 경우 step을 asc정렬,
            --step에도 중복된값이 존재할 경우 id를 asc정렬
select * from freeboard
order by id desc;

-- id 컬럼 : 새로운 글이 등록될 때 기존의 id컬럼에 최대값을 가져와서 +1 
-- <= 새 글 번호에 넘버링
-- 답변글을 처리하는 컬럼이 3개 필요하다. (masterid , replyNum, sep)
-- masterid     : 글의 답변에 대한 그룹핑 , id 컬럼의 값이 그대로 들어간 경우, 답변긍리 아니다, 처음글
    
-- replyNum     : 답변 글에 대한 넘버링 (1,2,3.....)
-- step         : 답변 글의 깊이 넘버링 (0,1,2,3,.....)
        -- 0 -> 처음글 (자신의 글, 답변x)
        -- 1 -> 처음글의 답변글
        -- 2 -> 처음글의 답변글의 답변글 ......
        -- 3 -> 처음글의 답변글의 답변글의 답변글..........
        
        
        
        
        

create table freeboard2 (
    id number constraint PK_freeboard2_id primary key, --자동 증가 컬럼
    name varchar2(100) not null,
    password varchar2(100) null,
    email varchar2(100) null,
    subject varchar2(100) not null, -- 글제목
    content varchar2(2000) not null, -- 글내용
    inputdate varchar2(100) not null, -- 글쓴 날짜
    masterid number default 0 , -- 질문답변형 게시판에서 답변의 글을 그룹핑할때 사용 
    readcount number default 0, -- 글 조회수
    replynum number default 0,  -- 질문답변형 게시판에서 답변의 글을 그룹핑할때 사용
    step number default 0  -- 질문답변형 게시판에서 답변의 글을 그룹핑할때 사용
    );
    
select * from freeboard2;        
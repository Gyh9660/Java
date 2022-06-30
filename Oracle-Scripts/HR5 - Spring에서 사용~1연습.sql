
create table b_user(
id varchar2 (100) not null primary key,            -- primary key
u_id varchar2 (30) not null,                        -- 유저아이디 유니크키?
u_pass varchar2 (30) not null,                      -- 비밀번호
email varchar2 (40) not null,                       -- 이메일
grade varchar2 (20) default '1' not null,           -- 등급
phone varchar2 (20) not null,                       -- 핸드폰
nick varchar2 (20) not null,                        -- 닉네임
u_name varchar2 (20) not null,                      -- 이름
u_profile varchar2 (40) default 'none' not null,    -- 프로필 사진
point number default 0 not null,                    -- 포인트
apoint number default 0 not null,                   -- 누적 포인트
u_date date default sysdate not null,                -- 가입일
like varchar2 null,                                   -- 좋아요 게시물?
question varchar2(1000) not null,                    -- 아이디 찾기용 질문
answer varchar2 (1000) not null                        -- 답변
);
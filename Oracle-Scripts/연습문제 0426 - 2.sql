create table member(    --가입한 회원정보를 관리
    id varchar2(20) not null constraint PK_member_id primary key, --고객 아이디
    pwd varchar2(20),                                  --고객 암호
    name varchar2(50),                                 --고객 이름
    zipcode varchar2(7),                               --우편 번호
    address varchar2(20),                              --주소
    tel varchar2(13),                                  --연락처
    indate date default sysdate,                       --가입일
    constraint FK_member_zipcode foreign key (zipcode) references tb_zipcode(zipcode)
    );
    
    select * from member;
    
    insert into member
    values ('aaaa','1111','홍길동','333-444','GASAN','010-0000-0000',default);
    
    insert into member
    values ('bbbb','1111','홍길은','444-555','DOKSAN','010-1111-1111',default);
    
    insert into member
    values ('cccc','1111','홍길금','555-666','GASAN','010-2222-2222',default);
    
    commit;
    
create table tb_zipcode(    --우편번호 정보를 관리
    zipcode varchar2(7) not null constraint PK_tb_zipcode_zipcode primary key, --우편번호
    sido varchar2(30),                                                         --시도
    gugum varchar2(30),                                                        --구군
    dong varchar2(30),                                                         --동
    bungi varchar2(30)                                                         --번지
    );
    select * from tb_zipcode;
    
    insert into tb_zipcode
    values('333-444','SEOUL','GEUMCHEON','GASAN','111');
    
    insert into tb_zipcode
    values('444-555','SEOUL','GEUMCHEON','DOKSAN','112');
    
    insert into tb_zipcode
    values('555-666','SEOUL','GEUMCHEON','GASAN','153');
    
    commit;
    
create table products(  --상품 정보를 관리
    product_code varchar2(20) not null constraint PK_products_product_code primary key, --상품 코드
    product_name varchar2(100),                                                         --상품명
    product_kind char(1),                                                               --등록 상품 구분
    product_price1 varchar2(10),                                                        --상품원가
    product_price2 varchar2(10),                                                        --상품판매가
    product_content varchar2(1000),                                                     --상품내용
    product_image varchar2(50),                                                         --상품이미지명
    sizeSt varchar2(5),                                                                 --사이즈 시작
    sizeEt varchar2(5),                                                                 --사이즈 끝
    product_quantity varchar2(5),                                                       --수량
    useyn char(1),                                                              --상품 사용 유무(삭제대신)
    indate date                                                                 --등록일
    );
    
    select * from products;
    
    insert into products
    values ('0001','사과','1','1000','3000','RED APPLE','APPLE','1','5','10','1',sysdate);
    
    insert into products
    values ('0002','오렌지','1','1000','5000','ORANGE','ORANGE','1','6','15','1',sysdate);
    
    insert into products
    values ('0003','바나나','1','1200','11000','BANANA','BANANA','1','10','15','1',sysdate);
    
    commit;
    
create table orders ( --주문정보를 관리
    o_seq number(10) not null constraint PK_order_o_seq primary key,    --주문 일련 번호
    product_code varchar2(20),                                          --주문 상품 코드
    id varchar2(16),                                                    --주문자 아이디
    product_size varchar2(5),                                           --주문 상품 사이즈
    quantity varchar2(5),                                               --주문 수량
    result char(1),                                                     --주문 처리 여부
    indate date,                                                        --주문일
    constraint FK_orders_product_code foreign key (product_code) references products(product_code),
    constraint FK_orders_id foreign key (id) references member(id)
    );
    
    select * from orders;
    
    insert into orders
    values('1234','0001','aaaa','5','10','1',sysdate);
    
    insert into orders
    values('1235','0002','bbbb','5','12','1',sysdate);
    
    insert into orders
    values('1236','0003','cccc','5','14','1',sysdate);
    
    commit;
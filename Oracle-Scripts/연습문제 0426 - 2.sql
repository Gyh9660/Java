create table member(    --������ ȸ�������� ����
    id varchar2(20) not null constraint PK_member_id primary key, --�� ���̵�
    pwd varchar2(20),                                  --�� ��ȣ
    name varchar2(50),                                 --�� �̸�
    zipcode varchar2(7),                               --���� ��ȣ
    address varchar2(20),                              --�ּ�
    tel varchar2(13),                                  --����ó
    indate date default sysdate,                       --������
    constraint FK_member_zipcode foreign key (zipcode) references tb_zipcode(zipcode)
    );
    
    select * from member;
    
    insert into member
    values ('aaaa','1111','ȫ�浿','333-444','GASAN','010-0000-0000',default);
    
    insert into member
    values ('bbbb','1111','ȫ����','444-555','DOKSAN','010-1111-1111',default);
    
    insert into member
    values ('cccc','1111','ȫ���','555-666','GASAN','010-2222-2222',default);
    
    commit;
    
create table tb_zipcode(    --�����ȣ ������ ����
    zipcode varchar2(7) not null constraint PK_tb_zipcode_zipcode primary key, --�����ȣ
    sido varchar2(30),                                                         --�õ�
    gugum varchar2(30),                                                        --����
    dong varchar2(30),                                                         --��
    bungi varchar2(30)                                                         --����
    );
    select * from tb_zipcode;
    
    insert into tb_zipcode
    values('333-444','SEOUL','GEUMCHEON','GASAN','111');
    
    insert into tb_zipcode
    values('444-555','SEOUL','GEUMCHEON','DOKSAN','112');
    
    insert into tb_zipcode
    values('555-666','SEOUL','GEUMCHEON','GASAN','153');
    
    commit;
    
create table products(  --��ǰ ������ ����
    product_code varchar2(20) not null constraint PK_products_product_code primary key, --��ǰ �ڵ�
    product_name varchar2(100),                                                         --��ǰ��
    product_kind char(1),                                                               --��� ��ǰ ����
    product_price1 varchar2(10),                                                        --��ǰ����
    product_price2 varchar2(10),                                                        --��ǰ�ǸŰ�
    product_content varchar2(1000),                                                     --��ǰ����
    product_image varchar2(50),                                                         --��ǰ�̹�����
    sizeSt varchar2(5),                                                                 --������ ����
    sizeEt varchar2(5),                                                                 --������ ��
    product_quantity varchar2(5),                                                       --����
    useyn char(1),                                                              --��ǰ ��� ����(�������)
    indate date                                                                 --�����
    );
    
    select * from products;
    
    insert into products
    values ('0001','���','1','1000','3000','RED APPLE','APPLE','1','5','10','1',sysdate);
    
    insert into products
    values ('0002','������','1','1000','5000','ORANGE','ORANGE','1','6','15','1',sysdate);
    
    insert into products
    values ('0003','�ٳ���','1','1200','11000','BANANA','BANANA','1','10','15','1',sysdate);
    
    commit;
    
create table orders ( --�ֹ������� ����
    o_seq number(10) not null constraint PK_order_o_seq primary key,    --�ֹ� �Ϸ� ��ȣ
    product_code varchar2(20),                                          --�ֹ� ��ǰ �ڵ�
    id varchar2(16),                                                    --�ֹ��� ���̵�
    product_size varchar2(5),                                           --�ֹ� ��ǰ ������
    quantity varchar2(5),                                               --�ֹ� ����
    result char(1),                                                     --�ֹ� ó�� ����
    indate date,                                                        --�ֹ���
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
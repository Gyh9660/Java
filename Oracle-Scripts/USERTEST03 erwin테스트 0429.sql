drop table member;
drop table orders;
drop table products;
drop table tb_zipcode;


CREATE TABLE member
(
	id                   VARCHAR2(20) NOT NULL ,
	pwd                  VARCHAR2(20) NULL ,
	name                 VARCHAR2(50) NULL ,
	address              VARCHAR2(20) NULL ,
	tel                  VARCHAR2(13) NULL ,
	indate               DATE NULL ,
	zipcode              VARCHAR2(7) NOT NULL 
);



CREATE UNIQUE INDEX XPK회원 ON member
(id   ASC);



ALTER TABLE member
	ADD CONSTRAINT  XPK회원 PRIMARY KEY (id);



CREATE TABLE orders
(
	o_seq                NUMBER(10) NOT NULL ,
	product_size         VARCHAR2(5) NULL ,
	quantity             VARCHAR2(5) NULL ,
	result               CHAR(1) NULL ,
	indate               DATE NULL ,
	product_code         VARCHAR2(20) NOT NULL ,
	id                   VARCHAR2(20) NOT NULL 
);



CREATE UNIQUE INDEX XPK주문 ON orders
(o_seq   ASC);



ALTER TABLE orders
	ADD CONSTRAINT  XPK주문 PRIMARY KEY (o_seq);



CREATE TABLE products
(
	product_code         VARCHAR2(20) NOT NULL ,
	product_name         VARCHAR2(100) NULL ,
	product_kind         CHAR(1) NULL ,
	product_price1       VARCHAR2(10) NULL ,
	product_content      VARCHAR2(1000) NULL ,
	product_image        VARCHAR2(50) NULL ,
	sizeSt               VARCHAR2(5) NULL ,
	sizeEt               VARCHAR2(5) NULL ,
	product_quantity     VARCHAR2(5) NULL ,
	useyn                CHAR(1) NULL ,
	indate               DATE NULL 
);



CREATE UNIQUE INDEX XPK상품 ON products
(product_code   ASC);



ALTER TABLE products
	ADD CONSTRAINT  XPK상품 PRIMARY KEY (product_code);



CREATE TABLE tb_zipcode
(
	zipcode              VARCHAR2(7) NOT NULL ,
	sido                 VARCHAR2(30) NULL ,
	gugun                VARCHAR2(30) NULL ,
	dong                 VARCHAR2(30) NULL ,
	bungi                VARCHAR2(30) NULL 
);



CREATE UNIQUE INDEX XPK우편번호 ON tb_zipcode
(zipcode   ASC);



ALTER TABLE tb_zipcode
	ADD CONSTRAINT  XPK우편번호 PRIMARY KEY (zipcode);



ALTER TABLE member
	ADD (CONSTRAINT R_10 FOREIGN KEY (zipcode) REFERENCES tb_zipcode (zipcode));



ALTER TABLE orders
	ADD (CONSTRAINT R_11 FOREIGN KEY (product_code) REFERENCES products (product_code));



ALTER TABLE orders
	ADD (CONSTRAINT R_12 FOREIGN KEY (id) REFERENCES member (id));
    

select * from user_tab_columns;
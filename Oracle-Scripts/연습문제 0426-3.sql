    --1--
    Alter table tb_zipcode
    rename column  gogum to GOGUN;
    
    --2--
    Alter table tb_zipcode
    add (ZIP_SEQ varchar2(6));
    
    --3--
    Alter table tb_zipcode
    rename column  bungi to BUNJI;
    
    --4--
    Alter table tb_zipcode
    modify dong varchar(100);
    
    --5--
    Alter table tb_zipcode
    drop constraint PK_tb_zipcode_zipcode;
  
    Alter table member
    drop constraint FK_member_zipcode;
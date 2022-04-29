show user;

--�ְ� ������ ����(sys) : ������ ������ �� �ִ� ������ ������ �ִ�.

--���̵� : usertest01 ��й�ȣ : 1234
create user usertest01 identified by 1234;

--������ ��ȣ�� �����ߴٰ� �ؼ� ����Ŭ���� ����(X) ������ �� �ִ� ������ �ο��޾ƾ� ���Ӱ���

--system privileges :
    -- create session : ����Ŭ�� �����Ҽ��ִ� ����
    -- create table : ����Ŭ���� ���̺��� �����Ҽ��ִ±���
    -- create sequence : �������� ������ �� �ִ� ����
    -- create view : �並 ���� �� �� �ִ� ����.

-- ������ �������� ����Ŭ�� ������ �� �ִ� create session ������ �ο�

/*
    DDL : ��ü���� (create , alter ,drop)
    DML : ���ڵ� ���� (insert, update , delete)
    DQL : ���ڵ� �˻� (select)
    DTL : Ʈ����� ( Begin transaction, rollback, commit)
    DCL : ���Ѱ��� ( grant ,revoke ,deny)
    
*/

--������ �������� ����Ŭ�� ���� �� �� �ִ� create session ������ �ο�
-- grant �ο��ұ��� to ������
grant create session to usertest01;

-- ����Ŭ�� �����Ҽ��ִٰ� �ؼ� �ٸ������� �ִ°Ǿƴ� (���̺����ٱ���...)
grant create table to usertest01;

/* ���̺� �����̽� (Table Space) : ��ü (���̺�,��,������,�ε���,Ʈ����,�������ν���,�Լ�....)
    �� �����ϴ� ����. ������ �������� �� ����ں� ���̺� �����̽��� Ȯ��.
    �Ϲݰ��������� Ȯ�� x
    system : dba (������ ���������� ���ٰ���)
*/
select * from dba_users;  --dba_ �� �ְ������(sys)���������� ��밡��(Ȯ�ΰ���)
-- default_tablespace / temporary_tablespace �ַ� Ȯ�� �ֿ�Ȯ��?

select username, default_tablespace as DataFile , temporary_tablespace LogFile
from dba_users
where username in ('HR', 'USERTEST01');

--�������� ���̺� �����̽� ���� (system ==> users) ����
alter user usertest01
default tablespace users --DataFile ���� :��ü�� ����Ǵ� ����(���̺�,��,Ʈ����,�ε���...)
temporary tablespace temp; -- LOG�� ���� : DML (Insert ,Update, Delete)
-- LOG�� ȣĪ�Ҷ� Transaction log : �ý����� ���� �߻��� ��������� �ƴ϶� ������ �������� �����ϱ� ���ؼ� �ʿ�

--���̺� �����̽� : ��ü�� �α׸� �����ϴ� �������� ����
    --DataFile : ��ü�� �����ϰ� �ִ�. (���̺�,��,�ε���....)
    --Log : Transaction Log �� ����
    
    -- DataFile�� Log ������ ���������� �ٸ� �ϵ������ �����ؾ� ������ ���ϼ� �ִ�.
        --RAID�� ������ �����ϸ� ������ ���� �� �ִ�.



-- �������� users ���̺� �����̽��� ����Ҽ� �ִ� ���� �Ҵ�. (users ���̺� �����̽��� 2mb�� ����Ҽ��ִ� ���� �Ҵ�)
alter user usertest01
quota 2m on users;

-------------------------------------
--����: usertest02 ������ �����Ŀ� users ���̺� �����̽����� ���̺� (tbl2) �����Ŀ� insert
create user usertest02 identified by 1234;

grant create session to usertest02;

grant create table to usertest02;

alter user usertest02
default tablespace users
temporary tablespace temp;

alter user usertest02
quota 2m on users;
--alter user usertest02 quota unlimit on users <== unlimit��� �ɼ��� �ֱ�����.

select username, default_tablespace as DataFile , temporary_tablespace LogFile
from dba_users
where username in ('USERTEST02');

select * from all_tables --���̺��� �����ָ� ����� �ش�. �������� ������ ���̺��� ���
where owner in ('HR','USERTEST01','USERTEST02');

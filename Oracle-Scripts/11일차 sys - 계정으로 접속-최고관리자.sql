  -- Ư�� ���̺� select ���� �ο� �ϱ�
 
 -- sys (�ְ������) �������� �����ؾ� �������� ����
 -- Autication (����) : credential (ID+pw)
 
    create user user_test10 identified by 1234; -- ���� ����.
   
-- Authorization (�㰡) : system ���� �Ҵ�
grant create session, create table, create view to user_test10;
    
-- �⺻������ ������ �����ϸ� system ���̺� �����̽��� ����Ѵ�.
-- <== �����ڸ� ��밡���� ���̺� �����̽�

--���̺� �����̽� �ٲٱ�. (USERS)
alter user user_test10
default tablespace "USERS"
temporary tablespace "TEMP"; --users / temp�� �ص���

--���̺� �����̽� �뷮 �Ҵ�
alter user user_test10
quota unlimited on users;

--Ư�� �������� ��ü�� �����ϸ� �� ������ �� ��ü�� �����ϰ� �ȴ�.
select * from dba_tables
where owner in ('HR','USER_TEST10');

--�ٸ� ������� ���̺��� ���� �Ϸ��� ������ ������ �Ѵ�.

grant select on hr.employee to user_test10;

-- grant ��ü�Ǳ��� on ��ü�� to ����ڸ�;
--���Ѻο� grant
grant select on hr.emp_copy55 to user_test10;

grant insert, update, delete on hr.emp_copy55 to user_test10;

--���� ����
revoke insert, update, delete on hr.emp_copy55 from user_test10;

/* with grant option : Ư�� �������� ������ �ο��ϸ鼭 �ش������ �ٸ�
����ڿ��� �ο��� �� �ִ� ����

    �ο����� ������ �ٸ�����ڿ��� �ο��� �� �� �ִ� ����.
*/

grant select on hr.employee to user_test10 with grant option;
    --user_test10  ������ hr.employee ���̺� ���ؼ� �ٸ� ����ڿ��� select ������ �ο��Ҽ� �ִ�.
    


grant select on hr.dept_copy55 to user_test10 with grant option;

/* public : ��� ����ڿ��� ������ �ο��ϴ� ��. */

grant select, insert, update, delete on hr.dept_copy56 to public;

/* �� (Role) : ���� ����ϴ� �������� ������ ���� ���� ��
-�߿�-?
    1. DBA Role : �ý����� ��� ������ ����� Role , sys( �ְ� ������ ����)
    2. connect : 
    3. resours :
*/
 
 --���� ���� Role ���� : ���� ����ϴ� ���� ���� ��� role�� ����
 -- 1. �� ����
    create role roletest1;
    
-- 2. �ѿ� ���� ����ϴ� ������ ����.
    grant create session, create table, create view, create sequence, create trigger
    to roletest1;
    
--3. ������ ���� �������� ����.
    grant roletest1 to user_test10;
    
/* ���� ����ڿ��� �ο��� �� Ȯ�� */

    select * from user_role_privs;
    
/* �ѿ� �ο��� ���� ���� Ȯ��*/

select * from role_sys_privs
where role like 'DBA';


select * from role_sys_privs
where role like 'ROLETEST1';

/* ��ü ������ - role�� �ο��ϱ� */

create role roletest2;

grant select on hr.empolyee to roletest2; -- �������� ��ü ������ ������ ���� �ƴ϶� �ѿ� ����.

grant roletest2 to user_test10;  -- ���� �������� ����
  
    
/* �ǽ�
hr.dept_copy57 �� ����

-- �� ���� : roletest3
roletest3 : hr.dept_copy57 (select, insert, delete) ��ü ��
user_test10 �� ����
*/

drop role roletest3;
create role roletest3;

grant select, insert, delete on hr.dept_copy57 to roletest3;

grant roletest3 to user_test10;
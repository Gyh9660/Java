create table test10Tbl(
    a number not null,
    b varchar2(50) null
    );
    
    
-- user_test10���� HR�� �������� employee ���̺��� ���� �Ҷ� -- ��ü�� ���ٱ����� �ʿ��ϴ�

select * from hr.employee;

--�⺻������ �ڽ��� ��ü�� ����Ҷ� ���� ����
show user;
select * from test10Tbl;

--�ٸ� ������� ��ü�� ���� �Ҷ��� �����ָ�.��ü��
select * from employee; --- �ڽ� ������ ��ü employee�� ��������� ��
select * from hr.employee; -- �ٸ� ������� ��ü�� �����Ҷ� ������ �־�� �Ѵ�.

-- �ٸ� ����� ���̺��� insert ����.
desc hr.emp_copy55;

select * from hr.emp_copy55;

--insert
insert into hr.emp_copy55(eno)
values (3333);

commit;
--with grant option�� �ο� �޾Ҵ�. (select , hr.employee) 

grant select on hr.employee to user_test11;

select * from hr.dept_copy55;

grant select on hr.dept_copy55 to user_test11;

select * from hr.dept_copy56;

-- ���� ����ڿ� �ο��� �� Ȯ��
select * from user_role_privs;

select * from hr.dept_copy57;

select * from hr.employee;


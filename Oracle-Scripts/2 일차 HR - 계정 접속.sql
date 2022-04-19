-- 2���� : DQL : Select

-- desc
desc department;

select * from department;

/*
SQL : ����ȭ�� ���� ���

Select ������ ��ü �ʵ� ����

Select      <== �÷���
Distinct    <== �÷����� ���� �ߺ��� �����ض�
From        <== ���̺��, ���
Where       <== ����
Group By    <== Ư�� ���� �׷���
Having      <== �׷��� �� ���� ����
Order by    <== ���� �����ؼ� ���

*/

desc employee;
select *
from employee;

--Ư�� �÷��� ��� �ϱ�
select eno, ename from employee;

-- Ư�� �÷��� ������ ���

select eno, ename, eno, ename, ename from employee;

select eno, ename, salary from employee;

-- �÷��� ������ ������ �� �ִ�.

select eno, ename, salary, salary*12 from employee;

-- �÷��� �˸��(Alias) : �÷��� �̸��� ����, 
    --�÷��� ������ �ϰų� �Լ��� ����ϸ� �÷����� ��������.
select eno, ename, salary, salary*12 as ���� from employee;
select eno as �����ȣ, ename as �����,  salary as ����, salary *12 ���� from employee;                     
select eno �����ȣ, ename ����� , salary ����, salary*12 ���� from employee;
    --�����̳� Ư�����ڰ� ��� ������ ""���� ó���ؾ� �Ѵ�.
select eno "��� #��ȣ" , ename "���?��", salary ����, salary*12 ���� from employee;

-- nvl �Լ� : ����ÿ� null�� ó���ϴ� �Լ�
select * from employee;

--nvl �Լ��� ������� �ʰ� ��ü ������ ���. 
--(null�� ���Ե� �÷��� ������ �����ϸ� null���)
    --null�� 0���� ó���ؼ� �����ؾ� ��. : NVL �Լ� 
select eno �����ȣ , ename ����� , salary ����, commission ���ʽ�,
salary * 12,
salary * 12 + commission -- ��ü���� 
from employee;

--nvl �Լ��� ����ؼ� ����
select eno �����ȣ , ename ����� , salary ����, commission ���ʽ�,
salary * 12,
salary * 12 + NVL(commission, 0) -- ��ü���� 
from employee;

--Ư�� �÷��� ������ �ߺ� ������ ���
select * from employee;
select dno from employee;
select distinct dno from employee;

-- ���� �߻� ename���� �ߺ����� �ٸ��÷� ������ �������� �ִ�
-- ���� distinct�� �÷�1���� ����
select ename, distinct dno from employee;

-- ������ ����ؼ� �˻� (Where)
select * from employee;

select 
eno �����ȣ,
ename �����,
job ��å,
manager ���ӻ��,
hiredate �Ի糯¥,
salary ����,
commission ���ʽ�,
dno �μ���ȣ
from employee;

-- ��� ��ȣ�� 7788�� ����� �̸��� �˻�.
select * from employee
where eno = 7788;

select ename from employee
where eno = 7788;

--��� ��ȣ�� 7788�� ����� �μ���ȣ, ���ް� �Ի糯¥�� �˻�.
select hiredate �Ի糯¥, salary ����, dno �μ���ȣ 
from employee
where eno = 7788;

desc employee;
-- ���� �����ö� ���ڴ� '' �ȿ��ְ� ��ҹ��� ����
select *
from employee
where ename = 'SMITH';

--���ڵ�(�ο�)�� �����ö� 
    --number �϶��� '' ������ �ʴ´�.
    --���� �����͸�(char,varchar2)�� ��¥(data)�� �����ö� ''�� ó��
    --��ҹ��ڸ� ����
    
-- �Ի� ��¥�� '81/12/03'�� ��� ���
select ename, hiredate
from employee
where hiredate = '81/12/03';

--�μ� �ڵ尡 10�� ��� ������� ���.
select ename, dno
from employee
where dno = 10;

select * from employee;

-- ������ 3000 �̻��� ����� �̸��� �μ���, �Ի糯¥,������ ���
select ename �����, dno �μ�, hiredate �Ի糯¥, salary ����
from employee
where salary >= 3000;

-- NULL �˻� : is Ű���� ��� <== ���� : null�˻��� = ����ϸ� �ȵȴ�.

select *
from employee
where commission is null;

-- commission�� 300�̻��� ����̸���, ��å, ������ ���
select ename, job, salary, commission
from employee
where commission >= 300;

-- Ŀ�̼��� ���� ������� �̸��� ���.
select ename, commission
from employee
where commission is null;


--���ǿ��� and , or, not 

--������ 500�̻� 2500 �̸��� ������� �̸�, �����ȣ, �Ի糯¥�� ���
select ename, eno, hiredate, salary
from employee
where salary >= 500 and salary <2500;


-- 1. ��å�� SALESMAN �̰ų� �μ��ڵ尡 20�� ����̸�,��å,����,�μ��ڵ� ���
select * from employee;

select ename, job, salary, dno
from employee
where job = 'SALESMAN' or dno = 20;

--2. Ŀ�̼��� ���� ������߿� �μ��ڵ尡 20�� ������� �̸�, �μ��ڵ�, �Ի糯¥�� ���

select ename, dno, hiredate, commission
from employee
where commission is null and dno = 20;

--3. Ŀ�̼��� null�� �ƴ� ������� �̸�, �Ի糯¥, �������

select ename, hiredate, salary , commission
from employee
where not commission is null;

-- ��¥ �˻� :
select * from employee;

-- 1982/1/1 ~ 1983/12/31 ���̿� �Ի��� ����� �̸�,��å,�Ի糯¥
select ename, job, hiredate
from employee
where hiredate >= '82/1/1' and hiredate <= '83/12/31';

-- 1981�⵵�� �Ի��� ����� ����� �̸�, ��å, �Ի糯¥
select ename, job, hiredate
from employee
where hiredate >= '81/1/1' and hiredate <= '81/12/31';

-- between A and B : A �̻� B ����
select ename, job, hiredate
from employee
where hiredate between '81/1/1' and '81/12/31';

-- IN ������
--Ŀ�̼��� 300, 500, 1400�� ����� �̸��� ��å, �Ի����� ���
select * from employee;

select ename, job, hiredate ,commission
from employee
where commission = 300 or commission = 500 or commission = 1400;

select ename, job, hiredate ,commission
from employee
where commission in (300,500,1400);

-- like : �÷����� Ư���� ���ڿ��� �˻� <== �۰˻� ����� ����Ҷ�
    -- % : �ڿ� ����ڰ� �͵� �������.
    -- _ : �ѱ��ڰ� ����� �͵� �������.
    
--F�� �����ϴ� �̸��� ���� ����� ��ΰ˻�
select * from employee;

select *
from employee
where ename like 'A%';

--�̸��� ES�� ������ ��� �˻� �ϱ�

select ename from employee
where ename like '%ES';

-- J�� ���۵ǰ� J���� �α��ڰ� ����� �͵� ������� ������, �ڿ��� ES�� ��������
SELECt ename
FROM employee
where ename like 'J__%ES';

--������ ���ڰ� R�γ����� ������
select *
from employee
where ename like '%R';

-- MAN�ܾ �� ��å �� ���
select *
from employee
where job like '%MAN%';

-- 81�⵵�� �Ի��� ����� ����ϱ�.
select *
from employee
where hiredate >= '81/1/1' and hiredate <= '81/12/31';

select *
from employee
where hiredate between '81/1/1' and '81/12/31';

select *
from employee
where hiredate like '81%';

--81�� 2���� �Ի��� ����� ���
select *
from employee
where hiredate like '81/02%';

--���� : order by desc(������������ 10->0) ,
            -- asc (������������ 0->10) : �⺻��

SELECT *
FROM employee
order by eno; -- asc ������

SELECT *
FROM employee
order by eno asc ;

SELECT *
FROM employee
order by eno desc ;

--�̸� �÷��� ����

SELECT *
FROM employee
order by ename asc ;

SELECT *
FROM employee
order by ename desc ;

--��¥����

SELECT *
FROM employee
order by hiredate asc ;


SELECT *
FROM employee
order by hiredate desc;

--���� �亯�� �Խ��ǿ��� �ַ� ���. �ΰ��̻��� �÷��� �����Ҷ�

select * from employee
order by dno desc;

--�ΰ��� �÷��� ���� : ���� ó�� �÷��� ������ �ϰ�,
-- ������ ���� ���ؼ� �ι�° �÷��� ����

select dno, ename
from employee
order by dno , ename;

select dno, ename
from employee
order by dno desc , ename desc;

-- where ����  order by ���� ���� ���ɶ�;
select *
from employee
where commission is null
order by ename;

--1. ���������ڸ� ����Ͽ� ��� ����� ���ؼ� $300�� �޿��λ��� ������� ����̸�,�޿�,�λ�ȱ޿� ���
select ename ����̸�, salary �޿�, salary+300 "�λ�� �޿�"
from employee;

--2. ����� �̸�, �޿�, ���� �� ������ ������ ���� ���������� ���
-- �����Ѽ����� ���޿� 12�� ������ 100$�󿩱��� ���ؼ� ���
select ename ����̸�, salary �޿�, (salary*12)+100 "���� �� ����"
from employee
order by "���� �� ����" desc;

--3. �޿��� 2000�� �Ѵ� ����� �̸��� �޿��� �޿��� ������ ���� ���������� ���
select ename ����̸�, salary �޿�
from employee
where salary >2000
order by salary desc;

--4. �����ȣ�� 7788�� ����� �̸��� �μ���ȣ�� ���
select ename ����̸�, dno �μ���ȣ
from employee
where eno = 7788;

--5. �޿��� 2000���� 3000���̿� ���Ե��� �ʴ� ����� �̸��� �޿��� ���
select ename ����̸�, salary �޿�
from employee
where not salary between 2000 and 3000;

--6. 1981�� 2�� 20�Ϻ��� 81�� 5�� 1�� ������ �Ի��� ����� �̸� ����, �Ի��� ���
select ename ����̸�, job ������, hiredate �Ի���
from employee
where hiredate between '81/02/20' and '81/05/01';

--7. �μ���ȣ�� 20�� 30�� ���� ����� �̸��� �μ���ȣ�� ����ϵ� �̸��� ���� �������� ���
select ename ����̸�, dno �μ���ȣ
from employee
where dno = 20 or dno =30
order by ����̸� desc;

--8. ����� �޿��� 2000���� 3000���̿� ���Եǰ� �μ���ȣ�� 20 �Ǵ� 30�� �����
-- �̸�, �޿��� �μ���ȣ�� ����ϵ� �̸��� ������������ ���
select ename ����̸�, salary �޿�, dno �μ���ȣ
from employee
where (salary between 2000 and 3000) and (dno =20 or dno =30)
order by ����̸�;

--9. 1981�⵵ �Ի��� ����� �̸��� �Ի����� ����Ͻÿ�
-- like�����ڿ� ���ϵ� ī�� ���
select ename ����̸�, hiredate �Ի���
from employee
where hiredate like '81%';

--10. �����ڰ� ���� ����� �̸��� �������� ����ϼ���.
select ename ����̸�, job ������
from employee
where manager is null;

--11. Ŀ�Լ��� ���� �� �ִ� �ڰ��� �Ǵ� ����� �̸�,�޿�,Ŀ�̼��� ����ϵ�
--�޿��� Ŀ�̼��� �������� �������� �����Ͽ� ǥ���ϼ���
select ename ����̸�, salary �޿�, commission Ŀ�̼�
from employee
where commission is not null
order by �޿� desc , Ŀ�̼� desc;

--12. �̸��� ����° ������ R�� ����� �̸��� ǥ���Ͻÿ�.
select ename ����̸�
from employee
where ename like '__R%';

--13. �̸��� A�� E�� ��� �����ϰ� �ִ� ����� �̸��� ǥ���Ͻÿ�.
select ename ����̸�
from employee
where ename like '%A%' and ename like '%E%';

--14. ��� ������ �繫��(CLERK) �Ǵ� ������� SALESMAN �̸鼭
-- �޿��� $1600,$950,�Ǵ� $1300�� �ƴ� ����� �̸�, ������, �޿��� ���
select ename ����̸�, job ������, salary �޿�
from employee
where job in('CLERK','SALESMAN') and not salary in(1600,950,1300);
--where (job = 'CLERK' or job ='SALESMAN') and not salary in(1600,950,1300)
--15. Ŀ�̼��� $500 �̻��� ����� �̸��� �޿� �� Ŀ�̼����
select ename ����̸�, salary �޿�, commission Ŀ�̼�
from employee
where commission >=500;

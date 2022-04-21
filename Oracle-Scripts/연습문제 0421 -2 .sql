
--1. EQUI ������ ����Ͽ� SCOTT ����� �μ� ��ȣ�� �μ� �̸��� ��� �Ͻÿ�. 
select ename ����̸� ,e.dno �μ���ȣ , dname �μ��̸�
from employee e, department d
where e.dno = d.dno
and ename = 'SCOTT';
--2. INNER JOIN�� ON �����ڸ� ����Ͽ� ����̸��� 
--�Բ� �� ����� �Ҽӵ� �μ��̸��� �������� ����Ͻÿ�. 

select ename ����̸� , dname �μ��̸� , loc ������
from employee e join department d
on e.dno = d.dno;

--3. INNER JOIN�� USING �����ڸ� ����Ͽ� 10�� �μ��� ���ϴ� 
--   ��� ��� ������ ������ ���(�ѹ����� ǥ��)�� �μ��� �������� �����Ͽ� ��� �Ͻÿ�. 
select e.dno �μ���ȣ, loc ������ , job ����
from employee e join department d
on e.dno = d.dno
where e.dno = 10;

--4. NATUAL JOIN�� ����Ͽ� Ŀ�Լ��� �޴� ��� ����� 
--�̸�, �μ��̸�, �������� ��� �Ͻÿ�. 
select ename ����̸�, dname �μ��̸�, loc ������
from employee e natural join department d
where commission is not null;

--5. EQUI ���ΰ� WildCard�� ����Ͽ� �̸��� A �� ���Ե� 
--��� ����� �̸��� �μ����� ��� �Ͻÿ�. 

select ename ����̸�, dname �μ��̸�
from employee e , department d
where e.dno = d.dno
and ename like '%A%';


--6. NATURAL JOIN�� ����Ͽ� NEW YORK�� �ٹ��ϴ� ��� ����� 
--�̸�, ����, �μ���ȣ �� �μ����� ����Ͻÿ�. 
select ename ����̸�, job ����, dno �μ���ȣ, dname �μ��̸�
from employee e natural join department d
where loc = 'NEW YORK';


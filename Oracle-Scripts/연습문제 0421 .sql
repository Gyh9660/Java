--1. ��� ����� �޿� �ְ��, ������, �Ѿ�, �� ��� �޿��� ��� �Ͻÿ�.
--�÷��� ��Ī�� ����(�ְ��, ������, �Ѿ�, ���)�ϰ� �����ϰ� ��տ� ���ؼ��� ������ �ݿø� �Ͻÿ�.
select *
from employee;

select max(salary)�ְ��, min(salary)������, sum(salary)�Ѿ�, round(avg(salary))���
from employee;

--2. �� ������ �������� �޿� �ְ��, ������, �Ѿ� �� ��վ��� ����Ͻÿ�.
--�÷��� ��Ī�� ����(�ְ��, ������, �Ѿ�, ���)�ϰ� �����ϰ� ��տ� ���ؼ��� ������ �ݿø� �Ͻÿ�. 
select job ������, max(salary)�ְ��, min(salary)������, sum(salary)�Ѿ�, round(avg(salary))���
from employee
group by job;

--3. count(*)�Լ��� ����Ͽ� ��� ������ ������ ������� ����Ͻÿ�. 
select job , count(*)
from employee
group by job;

--4. ������ ���� ���� �Ͻÿ�. �÷��� ��Ī�� "�����ڼ�" �� ���� �Ͻÿ�. 
select manager ������, count(*) �����ڼ�
from employee
group by manager;


--5. �޿� �ְ��, ���� �޿����� ������ ��� �Ͻÿ�, �÷��� ��Ī�� "DIFFERENCE"�� �����Ͻÿ�. 
select max(salary)�ְ�,min(salary)����,(max(salary) - min(salary))DIFFERENCE
from employee;

--6. ���޺� ����� ���� �޿��� ����Ͻÿ�. �����ڸ� �� �� ���� ��� �� ���� �޿��� 2000�̸��� �׷��� ���� ��Ű��
--����� �޿��� ���� ������������ �����Ͽ� ��� �Ͻÿ�. 
select job ���� ,manager ������ , min(salary)����
from employee
group by job,manager
having min(salary)>2000 and manager is not null;

--7. �� �μ������� �μ���ȣ, �����, �μ����� ��� ����� ��� �޿��� ����Ͻÿ�. 
--�÷��� ��Ī�� [�μ���ȣ, �����, ��ձ޿�] �� �ο��ϰ� ��ձ޿��� �Ҽ��� 2°�ڸ����� �ݿø� �Ͻÿ�. 
select dno �μ���ȣ, count(*) �����, round(avg(salary),1)��ձ޿�
from employee
group by dno;

--8. �� �μ��� ���� �μ���ȣ�̸�, ������, �����, �μ����� ��� ����� ��� �޿��� ����Ͻÿ�. 
--�ᷳ�� ��Ī�� [�μ���ȣ�̸�, ������, �����,��ձ޿�] �� �����ϰ� ��ձ޿��� ������ �ݿø� �Ͻÿ�.  
/*
[��¿���] 

dname		Location		Number of People		Salary
-----------------------------------------------------------------------------------------------
SALES		CHICAO			6		1567
RESERCH		DALLS			5		2175
ACCOUNTING   	NEW YORK		3		2917

*/

select decode(dno,10,'SALES',
                  20,'RESERCH',
                  30,'ACCOUNTING'
             )"dname" ,
decode(dno,10,'CHICAO',
           20,'DALLS',
           30,'NEW YORK'
       )"Location" ,
       
count(*) "Number of People",
round(avg(salary))"Salary"
from employee
group by dno;
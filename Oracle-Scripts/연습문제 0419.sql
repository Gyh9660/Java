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
--where (job = 'CLERK' or job ='SALESMAN') and not salary in(1600,950,1300);

--15. Ŀ�̼��� $500 �̻��� ����� �̸��� �޿� �� Ŀ�̼����
select ename ����̸�, salary �޿�, commission Ŀ�̼�
from employee
where commission >=500;

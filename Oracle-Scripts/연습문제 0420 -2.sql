--1. SUBSTR �Լ��� ����Ͽ� ������� �Ի��� �⵵�� �Ի��� �޸� ����Ͻÿ�
select ename ����̸�,SUBSTR(hiredate, 1, 5) "�⵵/��"
from employee;

--2. SUBSTR �Լ��� ����Ͽ� 4���� �Ի��� ����� ��� �Ͻÿ�.
select ename ����̸�, hiredate �Ի�⵵
from employee
where substr(hiredate, 4,2) like('04');

--3. MOD�Լ��� ����Ͽ� ���ۻ���� Ȧ���� ����� ����Ͻÿ�
select ename ����̸� , manager ���ۻ��
from employee
where MOD(manager,2) = 1;

-- 3-1. MOD �Լ��� ����Ͽ� ������ 3�� ����� ����鸸 ����ϼ���.
select ename ����̸�, salary ����
from employee
where MOD(salary,3)= 0;

--4. �Ի��� �⵵�� 2�ڸ� (YY), ���� (MON)�� ǥ���ϰ� ������ ���(DY)�� �����Ͽ� ���
select ename ����̸�, to_char (hiredate,'YY MON DY') "YY/MON/DY"
from employee;  

--5 ���� ������ �������� ��� �Ͻÿ�. ���� ��¥���� ���� 1�� 1���� �A ����� ����ϰ�
-- TO_DATE�Լ��� ����Ͽ� ������ ������ ��ġ ��Ű�ÿ�
select trunc( sysdate - to_date(20220101,'YYYYMMDD')) "���� ��������"
from dual;

--5-1 �ڽ��� �¾ ��¥���� ������� �� ���� �������� ��� �ϼ���.
select trunc(sysdate - to_date(19960122,'YYYYMMDD')) "����-�¾��"
from dual;

--5-2 �ڽ��� �¾ ��¥���� ������� �� ������ �������� ��� �ϼ���.
select trunc (months_between(sysdate ,'19960122')) "�������� 1"
from dual;

select trunc (months_between(sysdate ,to_date(19960122,'YYYYMMDD'))) "�������� 2"
from dual;

-- 6. ������� ��� ����� ����ϵ� ����� ���� ����� ���ؼ��� null�� ��� 0���� ���
select ename ����̸� , NVL(manager, 0) ������
from employee;

--7. DECODE �Լ��� ���޿� ���� �޿��� �λ��ϵ��� �Ͻÿ�. ������ 'ANAIYST' ����� 200,
--'SALESMAN' ����� 180, 'MANAGER'�� ����� 150, 'CLERK'�� ����� 100�� �λ��Ͻÿ�.

select ename ����̸� , salary �޿�, decode (job ,'CLERK',salary+100,
                                                'MANAGER',salary+150,
                                                'SALESMAN',salary+180,
                                                'ANAIYST',salary+200,
                                                salary
                                           ) �λ�ȱ޿�
from employee;                                         

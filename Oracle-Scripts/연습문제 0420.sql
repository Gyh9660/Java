-- dno�÷��� 10�� �μ��� ��� ���޿���+ 300�� ó���ϰ� , 20�� �μ��� ��� ���޿� +500�� 
-- �μ���ȣ�� 30�� ��� ���޿� +700 �� �ؼ� �̸�,����,�μ��������÷����� ����� ���

select *
from employee;

select ename, dno,salary,decode ( dno, 10, salary+300,
                                    20, salary+500,
                                    30, salary+700,
                                    salary) �μ��������÷���
from employee;
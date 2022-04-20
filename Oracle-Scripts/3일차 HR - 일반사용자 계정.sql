--1.
desc employee;

select *
from employee;

select eno as �����ȣ, ename �����, job ��å, manager "���ӻ�� ID", hiredate �Ի糯¥,
salary ����, commission ���ʽ�, dno �μ���ȣ
from employee;

select ename, salary, salary + 300
from employee;

--2.
select ename, salary, commission,salary*12, salary*12 + NVL(commission,0) +100 as �ѿ���
from employee;

--3.
select ename, salary    --�÷���
from employee           --���̺� ,��
where salary >= 2000    --����
order by salary desc;   --����

--4.
select ename, dno, eno
from employee
where eno = 7788;

--5.
select ename, salary
from employee
where not salary between 2000 and 3000;

--6.
select ename, job, hiredate
from employee
where hiredate between '81/2/20' and '81/05/01';

--7.
select ename, dno
from employee
where dno = 20 or dno = 30
order by ename desc;

select ename, dno
from employee
where dno in (20,30)
order by ename desc;

8.
select ename, salary , dno
from employee
where (salary between 2000 and 3000) and (dno = 20 or dno =30)
order by ename ;

select ename, salary , dno
from employee
where (salary between 2000 and 3000) and (dno in (20,30))
order by ename ;

--9. 
select ename, hiredate
from employee
where hiredate like '81%';

--10.
select ename , job, manager
from employee
where manager is null;

--11.
select ename , salary , commission
from employee
where commission is not null
order by salary desc ,commission desc;

--12
select ename
from employee
where ename like '__R%';


--13
select ename
from employee
where ename like '%A%' and ename like '%E%';

--14

select ename, job, salary
from employee
where job in ('CLERK', 'SALESMAN') and not salary in (1600,950,1300);

select ename, job, salary
from employee
where (job = 'CLERK' or job = 'SALESMAN') and salary not in (1600,950,1300);

--15
select ename , salary, commission
from employee
where commission >= 500;



-- �����Լ�
/*
    ROUND : Ư�� �ڸ������� �ݿø��ϴ� �Լ�
    TRUNC : Ư�� �ڸ������� �߶󳽴�. (������)
    MOD : �Է¹��� ���� ���� ������ ���� ���
    
*/
-- round ( ��� ) : �Ҽ��� ���ڸ����� �ݿø�
-- round ( ���, �Ҽ����ڸ��� ) :
    -- �Ҽ��� �ڸ��� : ����϶� �Ҽ��� ���������� �ڸ�����ŭ �̵� ���ڸ��� �ڿ��� �ݿø�
        --<==���� 
    -- �Ҽ��� �ڸ��� : �����϶� �Ҽ��� �������� �ڸ�����ŭ �̵��ϰ� ���ڸ������� �ݿø�
        --������ �ݿø�
        --�Ҽ��� �ڸ��� ��� ����
select 98.7654 , ROUND (98.7654) ,ROUND (98.7654, 2), round (98.7654, -1),
round (98.7654, -2), round (98.7654, -3), round (98.7654, 3)
from dual;

select 12345.6789, round (12345.6789) , round (12345.6789, -3) ,round (123678.123456, -3)
from dual;



--
select 98.7654, TRUNC (98.7654), TRUNC (98.7654, 2) , TRUNC (98.7654, -1)
from dual;

--mod (��� , ������ ��) => ����� ����� ���������� ���
select mod (31,2) , mod (31,5) , mod (31,8)
from dual;

select *
from employee;

select salary, mod(salary,300)
from employee;

-- employee table ���� �����ȣ�� ¦���� ����鸸 ���
select eno, mod(eno,2)
from employee
where mod(eno,2) =0;

/*  ��¥�Լ�
    sysdate : �ý��ۿ� ����� ���� ��¥�� ���.
    months_between : �� ��¥ ������ �� ���������� ��ȯ
    add_months : Ư�� ��¥�� �������� ���Ѵ�.
    next_day : Ư�� ��¥���� ���ʷ� �����ϴ� ���ڷ� ���������� ��¥�� ��ȯ.
    last_day : ���� ������ ��¥�� ��ȯ
    round : ���ڷ� ���� ��¥�� Ư�� �������� �ݿø�.
    trunc : ���ڷ� ���� ��¥�� Ư�� �������� ����.

*/

select sysdate
from dual;

select sysdate -1 ������¥, sysdate ���ó�¥, sysdate +1 ���ϳ�¥
from dual;

select *
from employee
order by hiredate asc ;

select hiredate , hiredate -1 , hiredate + 10
from employee;

desc employee;

-- �Ի��Ͽ��� ���� ��������� �ٹ��ϼ��� ���
select round ((sysdate - hiredate),2) "�� �ٹ� �ϼ�"
from employee;

select trunc (sysdate - hiredate) "�� �ٹ� �ϼ�"
from employee;

--Ư�� ��¥���� �� (Month)�� �������� ������ ��¥ ���ϱ�

select hiredate, trunc (hiredate, 'MONTH') 
from employee;
--Ư�� ��¥���� �� (Month)�� �������� �ݿø��� ��¥ ���ϱ� : 16�� �̻��� ��� �ݿø�
select hiredate, round (hiredate, 'MONTH') 
from employee;

-- months_between (Date1, date2 ) : date1�� date2 ������ �������� ���

-- �Ի��Ͽ��� ������� �� ������� �ٹ��� ������ ���ϱ�
select ename, sysdate, hiredate , months_between (sysdate,hiredate) "�ٹ� ������"
from employee;

select ename, sysdate, hiredate , trunc(months_between (sysdate,hiredate)) "�ٹ� ������"
from employee;


--add_months (date1, ������) : date1 ��¥�� �������� ���� ��¥�� ���.
-- �Ի����� 6������ ���� ������ ���.
select hiredate, add_months (hiredate, 6)
from employee;


-- �Ի����� 100���� ���� ������ ���.
select hiredate, hiredate + 100 "�Ի��� 100��"
from employee;

--next_day (date , '����' ) : date�� �����ϴ� ���Ͽ� ���� ��¥�� ����ϴ� �Լ�
select sysdate, next_day (sysdate,'�����') "�̹��� �����"
from dual;

--last_day (date ) : date �� �� ���� ������ ��¥

select hiredate, last_day (hiredate)
from employee;

--�� ��ȯ �Լ� <== �߿�
/*
    TO_CHAR  : ��¥�� �Ǵ� �������� ���������� ��ȯ�ϴ� �Լ�
    TO_DATE : �������� ��¥������ ��ȯ�ϴ� �Լ�
    TO_NUMBER : �������� ���������� ��ȯ�ϴ� �Լ�.

*/
 -- ��¥ �Լ� ����ϱ�
 --TO_CHAR (date, 'YYYYMMDD')
 select ename, hiredate, to_char (hiredate,'YYYYMMDD'), to_char (hiredate, 'YYMM'),
 to_char (hiredate, 'YYYYMMDD DAY'), to_char (hiredate, 'YYYYMMDD DY')
 from employee;
 
 --���� �ý����� ���� ��¥�� ����ϰ� �ð� �ʱ��� ���.
 
 select sysdate , to_char(sysdate , 'YYYY-MM-DD DAY HH:MI:SS')
 from dual;
 
 desc employee;
 
select hiredate,to_char(hiredate, 'YYYY-MM-DD HH:MI:SS DY')
from employee;

-- to_char ���� ���ڿ� ���õ� ����
/*
    0 : �ڸ����� ��Ÿ���� �ڸ����� ���� ���� ��� 0���� ä��ϴ�.
    9 : �ڸ����� ��Ÿ���� �ڸ����� ���� ���� ��� ä���� �ʽ��ϴ�.
    L : �� ������ ��ȭ ��ȣ�� ���
    . : �Ҽ������� ǥ��
    , : õ������ ������
*/
desc employee;



select ename, salary, to_char(salary, 'L999,999'), to_char (salary, 'L0,000,000')
from employee;

-- to_date ('char', 'format') : ��¥�������� ��ȯ.

--���� �߻� : date - char �� ���� �����߻�
select sysdate, sysdate -'20000101'
from dual;

--2000�� 1�� 1�Ͽ��� ���ñ����� �ϼ�
select sysdate, trunc (sysdate - to_date('20000101','YYYYMMDD')) 
from dual;

select sysdate, to_date ('02/10/10', 'YY/MM/DD')��ȯ ,trunc(sysdate - to_date('021010','YYMMDD')) ��¥����
from dual;

select ename,hiredate
from employee
where hiredate = '81/02/22';

select ename,hiredate
from employee
where hiredate = to_date(19810222,'YYYYMMDD');


select ename,hiredate
from employee
where hiredate = to_date('1981-02-22','YYYY--MM-DD') ;

--2000�� 12�� 25�Ϻ��� ���ñ��� �� ����� �������� ���
select sysdate , trunc( months_between(sysdate, '20001225'))
from dual;

select sysdate , trunc( months_between(sysdate, to_date(20001225,'YYYYMMDD')))
from dual;

-- to_number : number ������ Ÿ������ ��ȯ,
select 100000 - 50000
from dual;

--���� �߻� : ���ڿ� -���ڿ�
select '100,000' - '50,000'
from dual;

select to_number('100,000','999,999') - to_number('50,000','999,999')
from dual;

--NVL�Լ� : null�� �ٸ� ������ ġȯ ���ִ� �Լ�
    --nvl (expr1, expr2 ) : expr1���� null�� ������ expr2�� ġȯ�϶�
select commission
from employee;

select commission, NVL (commission , 0)
from employee;

select manager
from employee;

select manager, NVL(manager, 1111)
from employee;

-- NVL2 �Լ�
    --nvl2 (expr1, expr2, expr3 ) : expr1�� null�� �ƴϸ� expr2 �� ���,
                                --  expr1�� null�̸� expr3�� ���
                                
select salary, commission
from employee;

--NVL �Լ��� ���� ����ϱ�
select salary,salary*12,commission,NVL(commission,0),
salary*12 + NVL(commission,0) ����
from employee;

--NVL2 �Լ��� ����ؼ� ���� ����ϱ�
select salary,commission, NVL2( commission , salary*12+commission, salary*12) ����
from employee;

--nullif : �� ǥ������ ���ؼ� ������ ��� Null �� ��ȯ�ϰ� �������� �ʴ� ��� ù��° ǥ������ ��ȯ

select nullif ('A', 'A') , nullif ('A', 'B')
from dual;

--coalesce �Լ�
--coalesce (expr1, expr2, expr3.....expr-n):
    --expr1 �� null�� �ƴϸ� expr1�� ��ȯ�ϰ�,
    --expr1 �� null�̰� expr2�� null�� �ƴϸ� expr2�� ��ȯ
    --expr1 �� null�̰� expr2�� null�̰� expr3�� null�� �ƴϸ� expr3�� ��ȯ

select coalesce ('abc','bcd','def','efg','fgi')
from dual;

select coalesce (null,'bcd','def','efg','fgi')
from dual;

select coalesce (null,null,'def','efg','fgi')
from dual;

select coalesce (null,null,null,'efg','fgi')
from dual;

select coalesce (null,null,null,null,'fgi')
from dual;

select ename, salary,commission, coalesce (commission,salary,0)
from employee;

--decode �Լ� : switch case ���� ������ ����
/*
    DECODE ( ǥ���� , ����1, ���1,
                     ����2, ���2,
                     ����3, ���3,
                     �⺻���n
            )    
*/
select ename, dno, decode (dno, 10, 'ACCOUNTING',
                                20, 'RESEARCH',
                                30, 'SALES',
                                40, 'OPERATION',
                                'DEFAULF') as DNAME
from employee;

-- dno�÷��� 10�� �μ��� ��� ���޿���+ 300�� ó���ϰ� , 20�� �μ��� ��� ���޿� +500�� 
-- �μ���ȣ�� 30�� ��� ���޿� +700 �� �ؼ� �̸�,����,�μ��������÷����� ����� ���

select *
from employee;

select ename, dno,salary,decode ( dno, 10, salary+300,
                                    20, salary+500,
                                    30, salary+700,
                                    salary) �μ��������÷���
from employee
order by dno asc;

-- case : if ~ else if, else if~~
/*
    case ǥ���� WHEN ����1 THEN ���1
               WHEN ����2 THEN ���2
               WHEN ����3 THEN ���3
               ELSE ���n
    END
*/

select ename, dno, case when dno=10 then 'ACCOUNTING'
                        when dno=20 then 'RESEARCH'
                        when dno=30 then 'SALES'
                        ELSE 'DEFAULT'
                   END �μ���
from employee
order by dno asc;
                        
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

--8. �����ȣ,������ȣ,����̸�,�����̸� ��� 

select eno �����ȣ,rpad(substr(eno,1,2),4,'*') ������ȣ , ename ����̸� ,
rpad(substr(ename,1,1),4,'*') �����̸�
from employee;

--9. �ֹι�ȣ: �� ����ϵ� 801210-1****** ����ϵ���, ��ȭ��ȣ :010-11*******
select '�ֹι�ȣ : 801210-1333333' �ֹι�ȣ,
rpad(substr('�ֹι�ȣ : 801210-1333333',1,15),25,'*') �����ֹι�ȣ,
'��ȭ��ȣ : 010-1111-2222' ��ȭ��ȣ,
rpad(substr('��ȭ��ȣ : 010-1111-2222',1,13),24,'*') ������ȭ��ȣ
from dual;

--10. 10. �����ȣ, �����, ���ӻ��, 
/*	[���ӻ���� �����ȣ�� ���� ��� : 0000
	 ���ӻ���� �����ȣ��  �� 2�ڸ��� 75�� ��� : 5555
	���ӻ���� �����ȣ��  �� 2�ڸ��� 76�� ��� : 6666
	���ӻ���� �����ȣ��  �� 2�ڸ��� 77�� ��� : 7777
	���ӻ���� �����ȣ��  �� 2�ڸ��� 78�� ��� : 8888
	�׿ܴ� �״�� ���. 
  */
select eno, ename , manager ,case when manager is null then '0000'
                                  when substr(manager,1,2) = '75' then '5555'             
                                  when substr(manager,1,2) = '76' then '6666'
                                  when substr(manager,1,2) = '77' then '7777'
                                  when substr(manager,1,2) = '78' then '8888'
                             ELSE to_char(manager)
                             END "�����ȣ�� ���� �з�"        
from employee;
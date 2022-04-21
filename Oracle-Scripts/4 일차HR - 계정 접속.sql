--1.
select *
from employee;

select substr(hiredate,1,5) ���
from employee;

--2.
select ename ����̸� ,hiredate �Ի�⵵
from employee
where substr(hiredate,4,2) = 04;

--3.
select ename ����̸� , manager ���ӻ��
from employee
where mod(manager,2) =1;

--3-1.
select ename ����̸�, salary ����
from employee
where mod(salary , 3)= 0;

--4.
select ename ����̸� ,hiredate �Ի糯 ,to_char(hiredate, 'YY MON DD DY') ��°��
from employee;


--5.
select trunc(sysdate-to_date(20220101,'YYYYMMDD')) "����-1��1��"
from dual;

--5-1.

select trunc(sysdate-to_date(19960122,'YYYYMMDD')) "����-�¾��¥"
from dual;

--5-2
select trunc (MONTHS_BETWEEN(sysdate,'19960122'))
from dual;


--6.
select ename,manager, NVL(manager,0) ó����, nvl2(manager,manager,0)ó��2
from employee;

--7
select ename ,job, salary, decode(job,'ANALYST',salary+200,
                                       'SALESMAN',salary+180,
                                       'MANAGER',salary+150,
                                       'CLERK',salary+100,
                                       salary
                                    )"�λ�� �޿�"
from employee;
--8.
select eno �����ȣ, rpad(substr(eno,1,2),4,'*')������ȣ,
ename ����̸�, rpad(substr(ename,1,1),4,'*')�����̸�
from employee;

select eno �����ȣ, rpad (substr(eno,1,2),length(eno),'*')������ȣ,
ename ����̸�, rpad(substr(ename,1,1),length(ename),'*')�����̸�
from employee;

select ename, length(ename)
from employee;
--9
select '801210-1234567' �ֹι�ȣ,
rpad(substr('801210-1234567',1,8),14,'*')�����ֹι�ȣ,
'010-1122-3344' ��ȭ��ȣ,
rpad(substr('010-1122-3344',1,6),13,'*')������ȭ��ȣ
from dual;

select '801210-1234567' �ֹι�ȣ,
rpad(substr('801210-1234567',1,8),length('801210-1234567'),'*')�����ֹι�ȣ,
'010-1122-3344' ��ȭ��ȣ,
rpad(substr('010-1122-3344',1,6),length('010-1122-3344'),'*')������ȭ��ȣ
from dual;



--10
select eno �����ȣ, ename �����, manager ���ӻ��,
case when manager is null then '0000'
     when substr(manager,1,2)='75' then '5555'
     when substr(manager,1,2)='76' then '6666'
     when substr(manager,1,2)='77' then '7777'
     when substr(manager,1,2)='78' then '8888'
     else to_char(manager)
     end ���ӻ��ó��
from employee;


select eno �����ȣ, ename �����, manager ���ӻ��,
case when manager is null then 0000
     when substr(manager,1,2)= 75 then 5555
     when substr(manager,1,2)= 76 then 6666
     when substr(manager,1,2)= 77 then 7777
     when substr(manager,1,2)= 78 then 8888
     else manager
     end ���ӻ��ó��
from employee;

/*
    �׷� �Լ� : ������ ���� ���ؼ� �׷����ؼ� ó���ϴ� �Լ�
        group by ���� Ư�� �÷��� ������ ���,
        �ش� �÷��� ������ ������ �׷����ؼ� ������ ����.

    �����Լ� : 
        - SUM : �׷��� �հ�
        - AVG : �׷��� ���
        - MAX : �׷��� �ִ밪
        - MIN : �׷��� �ּҰ�
        - COUNT : �׷��� �� ���� (���ڵ�� record, �ο�� row)
        
*/

select sum(salary), round(avg(salary),2), max(salary), min(salary)
from employee;

--���� : ���� �Լ��� ó�� �Ҷ�, ����÷� ����

select sum(salary)
from employee;

select ename
from employee;

select *
from employee;


--sum avg max min(�����Լ���)��null���� �ڵ����� ó���ؼ� �����Ѵ�.
select sum(commission), avg(commission), max(commission), min(commission)
from employee;

--count () : ���ڵ� �� , �ο��
            --NULL�� ó������ �ʴ´�.
            --���̺��� ��ü ���ڵ� ���� ������ ��� : 
            --count(*) �Ǵ� NOT NULL�÷��� count()
desc employee;


select eno
from employee;

select count (eno)
from employee;


select commission
from employee;

select count(commission)
from employee;

select count (*)
from employee;

select *
from employee;

--��ü ���ڵ� ī��Ʈ
select count(*)
from employee;

select count(eno)
from employee;

--�ߺ��������� ������ ���� (job)
select job
from employee;

select count(distinct job)
from employee;

-- �μ��� ���� (dno)
select dno
from employee;

select count(distinct dno)
from employee;

--Group by : Ư�� �÷��� ���� �׷����Ѵ�. �ַ� �����Լ��� select������ ���� ���
/*
    select �÷���, �����Լ�ó�����÷�
    from ���̺�
    where ����
    group by �÷���
    having ���� (group by�� ����� ���� ����)
    order by ����

*/

--�μ��� ��� �޿�.
select dno �μ���ȣ, trunc( avg(salary)) ��ձ޿�
from employee
group by dno; --dno �÷��� �ߺ��� �׷���

select dno 
from employee
order by dno ;
 
--��ü ��� �޿�.
select avg(salary) ��ձ޿�
from employee;


--group by�� ����ϸ鼭 select ���� ������ �÷��� �������ؾ��Ѵ�.
select dno,count(dno), sum(salary) , 
trunc( avg(salary)), max(commission),min(commission) 
from employee
group by dno;

select job
from employee;

--������ ��å�� �׷����ؼ� ������ ���,�հ�,�ִ밪,�ּҰ� ���
select job,count(job), round( avg(salary),1), sum(salary),max(salary),min(salary)
from employee
group by job; --������ ��å�� �׷����ؼ� ���踦 �Ѵ�.

--���� �÷��� �׷��� �ϱ�
select dno, job , count(*),sum(salary)
from employee
group by dno,job -- ���÷� ��� ��ġ�ϴ� ���� �׷���
order by count(*) desc;

select dno, job
from employee
where dno = 20 and job = 'CLERK';

--having : group by ���� ���� ����� �������� ó�� �Ҷ�
    -- ��Ī�̸��� �������� ����ϸ� �ȵȴ�.
    
--�μ��� ������ �հ谡 9000 �̻��ΰ͸� ���.
select dno, count(*), sum(salary)�μ����հ�, round(avg(salary),2) �μ������
from employee
group by dno
having sum(salary)>9000
order by dno;

--�μ��� ������ ����� 2000�̻� ���
select dno, count(*), sum(salary)�μ����հ�, round(avg(salary),2) �μ������
from employee
group by dno
having avg(salary)>2000
order by dno;

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

--where�� having ���� ���� ���Ǵ� ���
    --where : ���� ���̺��� �������� �˻�
    --having : group by ����� ���ؼ� ������ ó��
    
select *
from employee;

--������ 1500���ϴ� �����ϰ� �� �μ����� ������ ����� ���ϵ�
--������ ����� 2000�̻� �ΰ͸� ���
select dno �μ���ȣ,count(*), round(avg(salary),2)
from employee
where salary>1500
group by dno
having avg(salary)>2500;

--ROLLUP
--CUBE
    --Group by ������ ����ϴ� Ư���� �Լ�
    --���� �÷��� ���� �� �� �ִ�.
    --group by ���� �ڼ��� ������ ���...
    
--1. Rollup , cube�� ������� �ʴ� ���

select dno, count(*),sum(salary), round(avg(salary))
from employee
group by dno
order by dno;

--2. Rollup :�μ��� �հ�� ����� ����ϰ� ������ ���ο� ��ü �հ�,���
select dno, count(*),sum(salary), round(avg(salary))
from employee
group by rollup(dno)
order by dno ;

--cube : �μ��� �հ�� ����� ��� ��, ������ ���ο� ��ü �հ�,���
select dno, count(*),sum(salary), round(avg(salary))
from employee
group by cube(dno)
order by dno;

-- Rollup : �� �÷��̻�
select dno, job, count(*), MAX(salary),sum(salary),round(avg(salary))
from employee
group by rollup(dno,job); -- �ΰ��� �÷��������, ���÷��� ���ļ� �����Ҷ� �׷���

select dno, job, count(*), MAX(salary),sum(salary),round(avg(salary))
from employee
group by dno,job
order by dno;

--cube
select dno, job, count(*), MAX(salary),sum(salary),round(avg(salary))
from employee
group by cube(dno,job)
order by dno, job;

--join : ���� ���̺��� ���ļ� �� ���̺��� �÷��� �����´�.
    /*  department�� employee�� ������ �ϳ��� ���̺��� ������
        �𵨸�(�ߺ�����, �������)�� ���ؼ� �� ���̺��� �и�
        �� ���̺��� ����Ű �÷� (dno), employee ���̺��� dno�÷���
        department ���̺��� dno�÷��� �����ϰ� �ִ�.
        �ΰ� �̻��� ���̺��� �÷��� join������ ����ؼ� ���.
    */
select *
from department; -- �μ������� �����ϴ� ���̺�
select *
from employee;   -- ��������� �����ϴ� ���̺�

-- equi join : ����Ŭ���� ���� ���̾��� join ,Oracle������ ��밡��
    --from �� : join�� ���̺��� ,�� ó���Ѵ�
    --where �� : �� ���̺��� ������ Ű �÷��� = �� ó��
        --and �� : ������ ó��.

--where�� : ���� Ű�÷��� ó��
select *
from employee,department
where department.dno = employee.dno --����Ű ����
and job = 'MANAGER';                --���� ó��

-- ANSI ȣȯ SQL       
    -- on �� : �� ���̺��� ������ Ű �÷��� " = " �� ó��
        --where �� : ������ ó��
         --from ���� join�� ���̺��� join���� ó���Ѵ�
--ANSI ȣȯ : INNER JOIN (INNER ��������) <== ���SQL���� ��� ������ ���ι��

--on�� : ���� Ű�÷��� ó��
select *
from employee e INNER join department d -- on������ join���� ó��
on e.dno = d.dno                  -- ����Ű ����
where job = 'MANAGER';            -- ����ó��

-- join�� ���̺� �˸�� (���̺� �̸��� ��Ī���� �ΰ� ���� ���)
select *
from employee e, department d
where e.dno = d.dno
and salary >1500;

-- select ������ ������ Ű �÷��� ��½ÿ� ������̺��� Ű���� ��� :dno
select eno, job, d.dno , dname
from employee e, department d
where e.dno = d.dno;

-- �� ���̺��� join�ؼ� �μ���[�μ���]�� ������ �ִ밪�� �μ������� ����� ������.
select dname �μ���,count(*), max(salary) �ִ밪 
from employee e, department d
where e.dno = d.dno
group by dname;

-- NATURAL JOIN : Oracle 9i ����
/*  EQUI JOIN �� Where ���� ����
    => �� ���̺��� ������ Ű �÷��� ���� " = "
    ������ Ű �÷��� Oracle ���������� �ڵ����� �����ؼ� ó��.
    ���� Ű�÷��� ��Ī�̸��� ����ϸ� ������ �߻�
    �ݵ�� ���� Ű �÷��� ������ Ÿ���� ���ƾ� �Ѵ�.
    from ���� natural join Ű���带 ���.
    
*/
select eno, ename, dname, dno
from employee e natural join department d;

--���� : select ���� ����Ű �÷��� ��½� ���̺���� ����ϸ� �����߻�

-- equi join vs natural join �� ���� Ű �÷� ó��
/* EQUI JOIN : SELECT ���� �ݵ�� ���� Ű�÷��� ����Ҷ� ���̺����
                �ݵ�� ���.(������̺��� Ű����ex)(d.dno)
    NATURAL JOIN : SELECT ���� �ݵ�� ���� Ű�÷��� ����Ҷ� ���̺����
                    �ݵ�� ������� �ʾƾߵȴ�.ex) (dno)
*/
--EQUI
select ename, salary, dname , d.dno --EQUI JOIN������ ���
from employee e , department d      -- e.dno
where e.dno = d.dno
and salary>2000;


--NATURAL
select ename, salary, dname, dno    --natural join ������ ��� x
from employee e natural join department d -- dno
where salary>2000;

--ANSI ȣȯ INNER JOIN
select ename, salary, dname, d.dno --inner join������ ������̺����� ���
from employee e inner join department d --d.dno
on e.dno = d.dno
where salary>2000;

--NON EQUI JOIN : EQUI JOIN ���� Where ���� "="�� ������� �ʴ� join
select *
from salgrade; -- ������ ����� ǥ�� �ϴ� ���̺�

select ename, salary, grade
from employee, salgrade
where salary between losal and hisal;

-- ���̺� 3�� ����
select ename, dname, salary, grade
from employee e,department d, salgrade s
where e.dno = d.dno
and salary between losal and hisal;


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













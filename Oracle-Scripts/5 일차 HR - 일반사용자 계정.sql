--1.
select * from employee;

select max(salary)�ְ��, min(salary)������, sum(salary)�Ѿ� , round(avg(salary))���
from employee;  

--2.
select job ����,count(*), max(salary) �ְ��, min(salary)������, sum(salary)�Ѿ�, round(avg(salary))���
from employee
group by job;

--rollup , cube : group by ������ ����ϴ� Ư���� Ű����\
select job ����,count(*), max(salary) �ְ��, min(salary)������, sum(salary)�Ѿ�, round(avg(salary))���
from employee
group by rollup(job);

select job ����,count(*), max(salary) �ְ��, min(salary)������, sum(salary)�Ѿ�, round(avg(salary))���
from employee
group by cube(job)
order by job;

-- �ΰ� �̻��� �÷��� �׷���
select dno, job ����,count(*), max(salary) �ְ��, min(salary)������, sum(salary)�Ѿ�, round(avg(salary))���
from employee
group by job,dno -- �ΰ��̻��� �÷��� �׷��� : ���÷��� ��� ����
order by dno;

select dno, job ����,count(*), max(salary) �ְ��, min(salary)������, sum(salary)�Ѿ�, round(avg(salary))���
from employee
group by rollup(dno,job)
order by dno;

select dno, job ����,count(*), max(salary) �ְ��, min(salary)������, sum(salary)�Ѿ�, round(avg(salary))���
from employee
group by cube(dno,job)
order by dno;

--3.
select distinct job
from employee;

select count(distinct job)
from employee;


select job , count(*)
from employee
group by job; --�̰Ը���

--4.
select count(distinct manager)
from employee; --�̰Ը��� count�� null�� �������� �ʴ´�.

select manager , count(*) �����ڼ�
from employee
group by manager;

--5.
select max(salary) - min(salary) DIFFERENCE
from employee;

--6. where , having ��� ���.
select job, min(salary)
from employee
where manager is not null
group by job
having min(salary)>2000;
--having not min(salary)<2000;

--7.

select dno, count(*), round(avg(salary),1)
from employee
group by dno;

--8.
select decode(dno,10,'SALES'
                 ,20,'RESERCH'
                 ,30,'ACCOUNTING'
             )"dname",
       decode(dno,10,'CHICAO'
                 ,20,'DALLS'
                 ,30,'NEW YORK'
                 )"Location",
count(*)"Number of People" , round(avg(salary)) "Salary"
from employee
group by dno;

--���ι��� 
--1.
select *
from employee;
select *
from department;
select ename, d.dno, dname
from employee e , department d
where e.dno = d.dno
and ename = 'SCOTT';

--�������� : ���̺��� �÷��� �Ҵ�Ǿ �������� ���Ἲ�� Ȯ��
    -- Primary key : ���̺� �ѹ��� ����� �� �ִ�. �ϳ��� �÷�, �ΰ��̻��� �׷����ؼ� ���밡��.
            -- �ߺ��� ���� ������ ����. NULL���� ������ ����.
    -- UNIQUE : ���̺� ���� �÷��� �Ҵ� �� �� �ִ�. �ߺ��� ���� ���� �� ����.
                --NULL ������ �ִ�. �� �ѹ��� null
    -- Foreign key : �ٸ� ���̺��� Ư�� �÷��� ���� �����ؼ� ���� ���ִ�.
                --�ڽ��� �÷��� ������ ���� �Ҵ����� ���Ѵ�.
    -- NOT NULL : NULL ���� �÷��� �Ҵ��� �� ����.
    -- CHECK : �÷��� ���� �Ҵ� �� �� üũ�ؼ� (���ǿ� �����ϴ�) ���� �Ҵ�.
    -- Default : ���� ���� ������ �⺻���� �Ҵ�.
    
--2.
select ename ����̸�, dname �μ��̸�, loc ������
from employee e inner join department d
on e.dno = d.dno;

--3.
--join���� using ����ϴ� ���
    --natural join : ���� Ű �÷��� oracle ���ο��� �ڵ��˻��ؼ� ó��
        --�ݵ�� �����̺��� ����Ű �÷��� ������ Ÿ���� ���ƾ��Ѵ�.
    --using ������� : �����̺��� ����Ű�÷��� ������ Ÿ���� �ٸ���� using�� ����Ѵ�.
    -- �� ���̺��� ���� Ű �÷���  �������� ��� using ���
select dno, loc , job
from employee e inner join department d
using (dno)
where dno =10;
-- on���
select e.dno, loc, job
from employee e inner join department d
on e.dno = d.dno
where e.dno =10;



--4.
select ename, dname, loc
from employee e Natural join department d
where commission is not null;

--5.
select ename, dname
from employee e, department d
where e.dno = d.dno
and ename like '%A%';

--6
select ename, job , dno, dname ,loc
from employee e natural join department d
where loc = 'NEW YORK';

--=================================0422=============================
--self join : �ڱ� �ڽ��� ���̺��� �����Ѵ�. (�ַ� ����� ��� ������ ����Ҷ� �����,���������)
/*  ��Ī�� �ݵ�� ����ؾ��Ѵ�.
    select �� : ��� ���̺� �ִ� �÷����� �ݵ�� ���
*/

select eno, ename, manager
from employee
where manager = '7788';

select *
from employee;

--EQUI join ���� self join ó��
select e.eno �����ȣ, e.ename ����̸�, e.manager ���ӻ����ȣ ,m.ename ���ӻ���̸�
from employee e , employee m    --Self JOIN :
where e.manager = m.eno
order by e.ename ;

select eno, ename, manager, eno, ename
from employee;

--ANSI ȣȯ : INNER JOIN���� ó��
select e.eno �����ȣ, e.ename ����̸�, e.manager ���ӻ����ȣ ,m.ename ���ӻ���̸�
from employee e INNER JOIN employee m    --Self JOIN :
on e.manager = m.eno
order by e.ename ;

-- EQUI JOIN - SELF JOIN
select e.ename || '�� ���ӻ����' || e.manager ||'�Դϴ�.'
from employee e, employee m
where e.manager = m.eno
order by e.ename;

--ANSI ȣȯ INNER JOIN ���� SELF JOINó��

select e.ename || '�� ���ӻ����' || e.manager ||'�Դϴ�.'
from employee e INNER JOIN employee m
on e.manager = m.eno
order by e.ename;

--Outer join :
/*  Ư�� �÷��� �� ���̺��� ���������� �ʴ� ������ ��� �ؾ� �ҋ�.
    ���������� �ʴ� �÷��� NULL�� ����̵�
    + ��ȣ�� ����ؼ� ��� : Oracle
    ANSI ȣȯ :  OUTER JOIN ������ ����ؼ� ��� <== ��� DBMS ���� ȣȯ
*/
--Oracle �� 
select e.ename, m.ename
from employee e join employee m
on e.manager = m.eno (+) --�����������ʾƵ� ������ ����ض� 
order by e.ename ;

--ansi ȣȯ�� ����ؼ� ���.
    -- Left outer join : �������� �κ��� ������ ������ ������ ��� ���
    -- rigth outer join : �������� �κ��� ������ �������� ������ ��� ���
    -- full outer join : �������� �κ��� ������ ���ʸ�� ������ ���
select e.ename, m.ename
from employee e left outer join employee m
on e.manager = m.eno
order by e.ename;

------5���� ��������

-- sub query : select �� ���� select ���� �ִ� ����
select ename, salary
from employee;
select salary
from employee
where ename='SCOTT';
-- scott�� ���޺��� ���� ����ڸ� ����϶�. (���� ����)

select ename, salary
from employee
where salary >=3000;

select ename, salary
from employee
where salary >= (select salary from employee where ename ='SCOTT');

--SCOTT�� ������ �μ��� �ٹ��ϴ� ����� ����ϱ� (sub Query)

select dno from employee where ename = 'SCOTT';
select ename, dno from employee where dno =20;

select ename ,dno
from employee
where dno = (select dno from employee where ename ='SCOTT');
--and not ename = 'SCOTT'; <<=scott�� ������ �μ��� �ٹ��ϴ� ������ + ���߿� scott�»���

--�ּ� �޿��� �޴� ����� �̸�, ������, �޿� ����ϱ� (sub query)
select min (salary ) from employee;
select ename, job, salary from employee where salary = 800;

select ename, job ,salary
from employee
where salary = (select min(salary) from employee); --���ϰ��̳��������


--30�� �μ�(dno)���� �ּ� ������ �޴� ������� ���� ����� �̸��� �μ���ȣ�� �������
select ename, dno , salary
from employee
where  salary > (select min(salary) from employee where dno =30);

--������Ǯ��
select salary from employee where dno = 30;
select min(salary) from employee where dno=30;

select ename, dno, salary
from employee
where salary > (select min(salary) from employee where dno =30);

--Having ���� sub query ����ϱ�


--30���μ��� �ּҿ��޺��� ū �� �μ��� �ּ� ����
select dno, min(salary), count(dno)
from employee
group by dno
having min(salary) > (select min(salary) from employee where dno =30);

/*  ������ ���� ���� : Sub Query�� ��� ���� �� �ϳ��� ���.
        ������ �� ������ : > , = , >= , < , <= , <>(�����ʴ�), 
    ������ ���� ���� : sub query�� ��� ���� ������ ���
        ������ �������� ������ : IN, ANY, SOME, ALL, EXISTS
            IN : ���� ������ �� ���� ('='�����ڷ� ���� ���)�� ���������� ������߿�
            �ϳ��� ��ġ�ϸ� ��
            ANY, SOME : ���� ������ �� ������ ���������� �˻� ����� �ϳ� �̻� ��ġ �ϸ� ��
            ALL : ���� ������ �� ������ ���� ������ �˻� ����� ��� ���� ��ġ �ϸ� ��
            EXIST : ���� ������ �� ������ ���� ������ ����� �߿��� �����ϴ� ���� 
            �ϳ��� �����ϸ� ��
*/

-- IN ������ ����ϱ�
select ename, eno, dno, salary
from employee
order by dno;

--�μ����� �ּ� ������ �޴� ����ڵ� ��� �ϱ� (���������� �ݵ�� ���)
select dno, min(salary) , count(*)
from employee
group by dno;

select ename, dno , salary
from employee
where salary in (950, 800, 1300);

select ename, dno , salary
from employee
where salary in (select min(salary) from employee group by dno);

-- ANY ������ ���
/*  ���� ������ ��ȯ�ϴ� �� ���� ���� ����
    ' < any ' �� �ִ밪 ���� ������ ��Ÿ��.
    ' > any ' �� �ּҰ� ���� ŭ�� ��Ÿ��.
    ' = any ' �� in�� ������.
*/

-- ������ SALESMAN�� �ƴϸ鼭 �޿��� ������ SALESMAN���� ���� ����� ���.
                            --SALESMAN�� �ְ��ӱݺ��� �������?
select eno, ename, job, salary
from employee
where salary < any (select salary from employee where job = 'SALESMAN')
--where salary < (select max(salary) from employee where job = 'SALESMAN')
and job <> 'SALESMAN';

select ename, job, salary
from employee
order by job;

select ename
from employee
where salary < any (select salary from employee where job = 'SALESMAN');

--ALL ������
/*  sub query�� ��ȯ�ϴ� ��� ���� ��
        ' > all ' : �ִ밪 ���� ŭ�� ��Ÿ��
        ' < all ' : �ּҰ� ���� ������ ��Ÿ��
*/
--��) ������ SALESMAN�� �ƴϸ鼭 SALESMAN���� �޿��� ���������
            --1250 (�ּҰ�) ���� ���� ��� (������ salesman�ƴ�)
select eno, ename, job, salary
from employee
where salary < all(select salary from employee where job = 'SALESMAN')
and job <> 'SALESMAN';

--��� ������ �м���(ANALYST)�� ������� �޿��� �����鼭 ������ �м����� �ƴ� ����� ���
select eno, ename, job, salary
from employee
where salary < all(select salary from employee where job ='ANALYST')
and job <> 'ANALYST';

--�޿��� ��� �޿����� ���� ������� �����ȣ�� �̸��� ǥ���ϵ� ��� �ްܿ� ���ؼ� ��������
select eno, ename, salary
from employee
where salary < (select avg(salary) from employee )
order by salary;



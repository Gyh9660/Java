--5���� ����Ǯ��-------

--7.
-- EQUI join : ����Ŭ������ ����ϴ� ����, �����̺��� Ű�� ��ġ�ϴ� �͸� ���
-- ANSI : INNER JOIN  ���� ��ȯ ���� (��� DBMS ���� ���� ����,MSSQL,My SQL....
select e.ename ����̸� ,e.eno �����ȣ , m.ename �������̸� , m.eno �����ڹ�ȣ
from employee e , employee m
where e.manager = m.eno;

select * from employee;
select e.ename ����̸� ,e.eno �����ȣ , m.ename �������̸� , m.eno �����ڹ�ȣ
from employee e inner join employee m
on e.manager = m.eno;

--8
select e.ename ����̸� ,e.eno �����ȣ , m.ename �������̸� , m.eno �����ڹ�ȣ
from employee e , employee m
where e.manager = m.eno(+)
order by e.eno desc;

select e.ename ����̸� ,e.eno �����ȣ , m.ename �������̸� , m.eno �����ڹ�ȣ
from employee e left outer join employee m
on e.manager = m.eno;
--9.
select e.ename �̸�, e.dno �μ���ȣ, m.ename ����
from employee e , employee m
where e.dno = m.dno -- <== �� ���̺��� �μ� �÷��� ����Ű�� ���
and e.ename = 'SCOTT'
and m.ename <> 'SCOTT';


select * from employee where ename = 'SCOTT';
select * from employee where dno = 20;

select ename, dno, ename, dno from employee;

--10.
select * from employee;

select * from employee
where hiredate > '81/02/22';

select * from employee
where hiredate > to_date(19810222, 'YYYYMMDD');

select * from employee
where hiredate > to_date ('1981_02_22', 'YYYY_MM_DD');

select m.ename �̸� ,m.hiredate �Ի���
from employee e , employee m
where e.hiredate < m.hiredate 
and e.ename = 'WARD'
order by m.hiredate;

select ename, hiredate , ename ,hiredate from employee;

select e2.ename �̸�, e2.hiredate �Ի���
from employee e1 , employee e2
where e2.hiredate > e1.hiredate
and e1.ename = 'WARD'
order by e2.hiredate asc;

--11
select eno, ename, manager, hiredate from employee;

select e1.ename ����̸�, e1.hiredate ������Ի���, e2.ename , e2.hiredate
from employee e1 , employee e2
where e1.manager = e2.eno
and e1.hiredate < e2.hiredate;

select e.ename ����̸�, e.hiredate �Ի���, m.ename �������̸�, m.hiredate �������Ի���
from employee e , employee m
where e.manager = m.eno
and e.hiredate < m.hiredate;

select eno, ename, manager, hiredate, eno, ename, manager, hiredate
from employee;

--subquery
--1. 
select job, ename from employee where eno =7788;
select ename, job from employee where job = 'ANALYST';

select ename, job from employee 
where job = (select job from employee where eno =7788)
and eno <> '7788';

--2.
select ename ����̸� , job ����, salary ����
from employee
where salary > (select salary from employee where eno=7499);

--3.
--i--
select ename ����̸�, job ����, salary �޿�
from employee
where salary in (select min(salary) from employee group by job );
--t--
select job, count(*), min(salary)
from employee
group by job;

select ename ����̸�, job ������, salary �޿�
from employee
where salary in ( select min(salary) from employee group by job);

--4
--t--

select job ,round(avg(salary)) from employee 
group by job;
select * from employee where job ='CLERK';

select ename �̸�, job ����, salary �޿�
from employee
where salary = ( select min(salary) from employee
                    group by job
                    having avg(salary)= (select min(avg(salary))
                    from employee group by job)
               );
--t2--
select min (salary) �޿�, job ����
from employee
group by job
having avg (salary) <= all (select avg(salary)from employee
group by job);
               
--i--               
select ename ����̸�, salary �޿� ,job ����
from employee
where salary = ( select min(salary)from employee group by job
having min(salary) <all(select round(avg(salary)) from employee group by job));

--i2--
select job ���� , min(salary) �޿�
from employee 
group by job
having min(salary)<all(select round(avg(salary)) from employee group by job);

--5.

select ename ����̸�, job ������, salary �޿�
from employee
where salary in ( select min(salary)
from employee 
group by job);

--6.
select * from employee where job ='ANALYST';

select eno �����ȣ, ename �̸�, job ������, salary �޿�
from employee
where salary < all(select salary from employee where job ='ANALYST')
and job <> 'ANALYST';

--7.


select eno,ename ����̸�
from employee
where eno not in ( select manager from employee where manager is not null);

--8.
select eno,ename ����̸�
from employee
where eno in ( select manager from employee where manager is not null);


--9.
select * from employee where ename = 'BLAKE';
select ename ����, hiredate �Ի��� , dno
from employee
where dno = (select dno from employee where ename = 'BLAKE')
and ename <> 'BLAKE';

--10
select eno, ename, salary
from employee
where salary > (select round(avg(salary)) from employee)
order by salary;

-11
select eno �����ȣ, ename �̸�
from employee
where dno in (select dno from employee where ename like '%K%');

select * from employee where ename like '%K%';

--12
select * from department;
--i--
select ename �̸�, dno �μ���ȣ, job ������
from employee
where dno = (select dno from department where loc = 'DALLAS');

--t -join--
select ename, e.dno, job, loc
from employee e, department d
where e.dno = d.dno
and loc = 'DALLAS';
--t -sub query--
select ename, e.dno , job ,loc
from employee e , department d
where e.dno =d.dno
and e.dno in (select dno from department where loc ='DALLAS');

--13.
select * from employee;
select ename �̸�, salary �޿�
from employee
where manager = (select eno from employee where ename = 'KING');

--14.
select * from department;
--i--
select dno �μ���ȣ, ename ����̸� ,job ����
from employee
where dno = (select dno from department where dname = 'RESEARCH');

--t join--
select d.dno �μ���ȣ, ename ����̸�, job ������,dname �μ���
from employee e, department d
where e.dno = d.dno
and d.dname = 'RESEARCH';

--t sun query
select e.dno �μ���ȣ, ename ����̸�, job ������ , dname �μ���
from employee e, department d
where e.dno = d.dno
and e.dno in (select dno from department where dname = 'RESEARCH');

--15.
select avg(salary) from employee;

select eno �����ȣ, ename �̸�, salary �޿�
from employee
where salary > (select round(avg(salary)) from employee)
and dno in (select dno from employee where ename like '%M%');

select * from employee where ename like '%M%';
--16
--t--
select job ����, avg(salary) ��ձ޿�
from employee
group by job
having avg(salary) = (select min(avg(salary)) from employee group by job);

--i--
select job , avg(salary)
from employee
group by job
having avg(salary) <= all (select avg(salary) from employee group by job);

--17
select ename ����̸�
from employee
where dno in (select dno from employee where job = 'MANAGER')
--and job <> 'MANAGER'
;

select * from employee where job = 'MANAGER';

----------------6���� ----------------

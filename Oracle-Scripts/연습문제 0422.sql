/*subquery ����. 

Join ����.
�Ϸ� �ð� : 6:20�б���. */

--7. SELF JOIN�� ����Ͽ� ����� �̸� �� �����ȣ�� ������ �̸� �� ������ ��ȣ�� �Բ� ��� �Ͻÿ�. 
 	--������ ��Ī���� �ѱ۷� �����ÿ�. 
select e.eno �����ȣ  ,e.ename ����̸� , e.manager �����ڹ�ȣ, d.ename �������̸�
from employee e join employee d 
on e.manager = d.eno
order by e.eno;
--8. OUTER JOIN, SELF JOIN�� ����Ͽ� �����ڰ� ���� ����� �����Ͽ� �����ȣ�� �������� �������� �����Ͽ� ��� �Ͻÿ�. 

select e.eno �����ȣ  ,e.ename ����̸� , e.manager �����ڹ�ȣ, d.ename �������̸�
from employee e left outer join employee d 
on e.manager = d.eno
order by e.eno desc;

--9. SELF JOIN�� ����Ͽ� ������ ����� �̸�, �μ���ȣ, ������ ����� ������ �μ����� �ٹ��ϴ� ����� ����Ͻÿ�. 
   --��, �� ���� ��Ī�� �̸�, �μ���ȣ, ����� �Ͻÿ�. 
select e.ename �̸� , e.dno �μ���ȣ , m.ename ����
from employee e join employee m
on e.dno = m.dno 
where e.ename = 'SCOTT';

--10. SELF JOIN�� ����Ͽ� WARD ������� �ʰ� �Ի��� ����� �̸��� �Ի����� ����Ͻÿ�. 
select m.ename �̸� , m.hiredate �Ի���
from employee e join employee m
on e.hiredate < m.hiredate
where e.ename ='WARD';
--11. SELF JOIN�� ����Ͽ� ������ ���� ���� �Ի��� ��� ����� �̸� �� �Ի����� ������ �̸� �� �Ի��ϰ� �Բ� ����Ͻÿ�. 
   -- ��, �� ���� ��Ī�� �ѱ۷� �־ ��� �Ͻÿ�. 
   
select e.ename ����̸�, e.hiredate �Ի���, m.ename �������̸�, m.hiredate �������Ի���
from employee e join employee m
on e.manager = m.eno
where e.hiredate < m.hiredate;

--<<�Ʒ� ������ ��� Subquery�� ����Ͽ� ������ Ǫ����.>>

--1. �����ȣ�� 7788�� ����� ��� ������ ���� ����� ǥ��(����̸� �� ������) �Ͻÿ�.  
select ename ����̸�, job ����
from employee
where job = (select job from employee where eno = 7788);
--2. �����ȣ�� 7499�� ������� �޿��� ���� ����� ǥ�� (����̸� �� ������) �Ͻÿ�. 
select ename ����̸�, job ����
from employee
where salary > (select salary from employee where eno = 7788);
--3. ���� ���� �ּ� �޿��� �޴� ����� �̸�, ��� ���� �� �޿��� ǥ�� �Ͻÿ�(�׷� �Լ� ���)

select ename ����̸�, job ���� ,salary �޿�
from employee
where salary in (select min(salary) from employee group by job );



--4. ���޺��� ��� �޿��� ���ϰ� �������� ������տ��� �������� ����� ���ް� ��� �޿��� ǥ���Ͻÿ�
select job ���� , min(salary) �޿�
from employee 
group by job
having min(salary) <all(select round(avg(salary)) from employee group by job);

--�ٽ�Ǯ��
select ename ����̸�, salary �޿� ,job ����
from employee
where salary = ( select min(salary)from employee group by job
having min(salary) <all(select round(avg(salary)) from employee group by job));

--5. �� �μ��� �ʼ� �޿��� �޴� ����� �̸�, �޿�, �μ���ȣ�� ǥ���Ͻÿ�.
select ename ����̸�, dno �μ���ȣ ,salary �޿�
from employee
where salary in (select min(salary) from employee group by dno );
--6. ��� ������ �м���(ANALYST) �� ������� �޿��� �����鼭 ������ �м����� �ƴ� ������� ǥ�� (�����ȣ, �̸�, ������, �޿�) �Ͻÿ�.
select eno �����ȣ, ename �̸�, job ������, salary �޿�
from employee
where salary < all(select salary from employee where job = 'ANALYST')
and job <> 'ANALYST';

--7. ���������� ���� ����� �̸��� ǥ�� �Ͻÿ�. 
select ename ����̸�
from employee
where eno not in (select manager from employee where manager is not null); 
select *
from employee;

--8. ���������� �ִ� ����� �̸��� ǥ�� �Ͻÿ�. 
select ename ����̸�
from employee
where eno in (select manager from employee where manager is not null);
--9. BLAKE �� ������ �μ��� ���� ����� �̸��� �Ի����� ǥ���ϴ� ���Ǹ� �ۼ��Ͻÿ�(��, BLAKE �� ����). 
select ename ����̸�, hiredate �Ի���
from employee
where job in (select job from employee where ename = 'BLAKE')
and ename <> 'BLAKE';

--10. �޿��� ��պ��� ���� ������� �����ȣ�� �̸��� ǥ���ϵ� ����� �޿��� ���ؼ� ���� �������� ���� �Ͻÿ�. 
select eno �����ȣ, ename ����̸�
from employee
where salary > (select round(avg(salary)) from employee)
order by salary;
--11. �̸��� K �� ���Ե� ����� ���� �μ����� ���ϴ� ����� �����ȣ�� �̸��� ǥ���ϴ� ���Ǹ� �ۼ��Ͻÿ�. 
select eno �����ȣ, ename ����̸�
from employee
where ename in (select ename from employee where ename like '%K%');
--12. �μ� ��ġ�� DALLAS �� ����� �̸��� �μ� ��ȣ �� ��� ������ ǥ���Ͻÿ�. 
select ename ����̸�, dno �μ���ȣ, job ������
from employee
where dno in (select dno from department where loc = 'DALLAS');
--13. KING���� �����ϴ� ����� �̸��� �޿��� ǥ���Ͻÿ�. 
select ename ����̸�, salary �޿�
from employee
where manager = (select eno from employee where ename ='KING');
--14. RESEARCH �μ��� ����� ���� �μ���ȣ, ����̸� �� ��� ������ ǥ�� �Ͻÿ�. 
select dno �μ���ȣ, ename ����̸�, job ����
from employee
where dno = (select dno from department where dname ='RESEARCH');

--15. ��� �޿����� ���� �޿��� �ް� �̸��� M�� ���Ե� ����� ���� �μ����� �ٹ��ϴ� ����� �����ȣ, �̸�, �޿��� ǥ���Ͻÿ�. 
select eno �����ȣ, ename �̸�, salary �޿�
from employee
where dno in (select dno from employee where ename like '%M%')
and salary > (select round(avg(salary)) from employee); 

--16. ��� �޿��� ���� ���� ������ ã���ÿ�. 
select job ����, round(avg(salary)) ��ձ޿�
from employee
group by job
having round(avg(salary)) <= all(select round(avg(salary)) from employee group by job);
--17. �������� MANAGER�� ����� �Ҽӵ� �μ��� ������ �μ��� ����� ǥ���Ͻÿ�. 
select ename ����̸�
from employee
where dno in (select dno from employee where job = 'MANAGER');
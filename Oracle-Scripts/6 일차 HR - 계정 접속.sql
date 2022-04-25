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

--11
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
/* CRUD ( Create, Read, Update, Delete)

Object (��ü) : DataBase �� ���� (XE, <= Express Edtion(�������)
, Standard Edition(����),Enterprise Edition(����))
    1. ���̺� , 2. �� , 3. �������ν��� , 4. Ʈ���� ,
    5. �ε��� , 6. �Լ� ,7. ������ <== DDL (Create, Alter, Drop)
    

���̺� ���� ( Create) -- DDL ��ü ����

    Create Table ���̺�� (
        �÷��� �ڷ��� null��뿩�� [��������],
        �÷��� �ڷ��� null��뿩�� [��������],
        �÷��� �ڷ��� null��뿩�� [��������]
    );

*/

create table dept (
    dno number(2) not null,
    dname varchar2(14) not null,
    loc varchar2(13) null
    );
    
select * from dept;

--DML : ���̺��� ��(���ڵ�, �ο�)�� �ְ�(INSERT), �����ϰ�(UPDATE) ����(DELETE)�ϴ� ����
/*  --Ʈ������� �߻� ��Ŵ :  log�� ����� ���� �ϰ� Database�� �����Ѵ�.
    
    insert into ���̺�� (�÷���1,�÷���2,�÷���3)
    valaues (��1, ��2, ��3 )
*/
begin transaction ; -- Ʈ�� ��� ���� (insert, update, delete ������ ���۵Ǹ�  �ڵ����� ����)
rollback ; --Ʈ�� ����� �ѹ� (RAM�� ����� Ʈ������� ����)
commit ; --Ʈ�� ����� ����( ���� DataBase�� ������ ����)

insert into dept (dno, dname, loc) 
values (10, 'MANAHER', 'SEOUL');
    
    --insert, update, delete ������ �ڵ����� Ʈ������� ����(begin transaction)
        --RAM���� ����Ǿ� �ִ� ����
rollback ;

commit;

/* insert �� �÷����� ����
    insert into dept 
    values (��1,��2,��3)
*/

select * from dept;

insert into dept
values (20, 'ACCOUNTING', 'PUSAN');

commit;

desc dept ;

/* null ��� �÷��� ���� ���� �ʱ�
*/
insert into dept(dno,dname)
values(30, 'RESEARCH');

/*������ ������ ���� �ʴ� �� ������ ���� �߻�*/

insert into dept (dno, dname, loc)
values (300, 'SALES' , 'TAEGUE'); -- �����߻�, NUMBER(2)

insert into dept (loc, dname, dno)
values ('TAEGUN', 'SALESSSSSSSSSSSSS' , 60); --���� �߻�, dname varchar2(14)�� ����


--�ڷ��� ( ���� �ڷ���)
    --char (10) : ����ũ�� 10����Ʈ , 3����Ʈ�� ���� ��� ����� 7����Ʈ ����
        --������ ����(����), �ϵ��������(����)
        --�ڸ����� �˼� �ִ� ����ũ�� �÷� (�ֹι�ȣ, ��ȭ��ȣ)
    --varchar2 (10) : ����ũ�� 10����Ʈ,3����Ʈ�� ���� ��� 3����Ʈ�� �����Ҵ�
        --������ ����(����), �ϵ�������� ����(����)
        --�ڸ����� ����ũ���� ��� (�ּ�, �����ּ�, )
    --Nchar (10) : �����ڵ� 10��(�ѱ�,�߱���,�Ϻ���....)
    --Nvarchar2  (10) : �����ڵ� 10�� (�ѱ�,�߱���,�Ϻ���....)
    
--�ڷ��� (���� �ڷ���)
    -- NUMBER(2) : ���� 2�ڸ��� �Է� ����
    -- NUMBER (7,3) : ���� 7�ڸ� , �Ҽ��� 3�ڸ����� ������ ��.
    -- NUMBER (8,5) : ���� 8�ڸ�, �Ҽ��� 5�ڸ����� �����.
    
create table test1_tb1 (
    a number(3,2) not null,
    b number(7,5) not null,
    c char(6) null,
    d varchar2(10) null,
    e Nchar (6) null,
    f Nvarchar2(10) null
    );
    

    
desc test1_tb1 ;

drop table test1_tb1 ;

select * from test1_tb1;

insert into test1_tb1 (a,b,c,d,e,f)
values ( 3.22, 77.55555,'aaaaaa','bbbbbbbbbb','�ѱۿ����ڸ�','�ѱۿ��ڱ����Դϴ���');

insert into test1_tb1 (a,b,c,d,e,f)
values ( 3.22, 77.555,'�ѱ�','�ѱ�','�ѱۿ����ڸ�','�ѱۿ��ڱ����Դϴ���');

--�ѱ� 1�ڴ� 3byte�� �����Ѵ�.

create table test2_tb2(
    a NUMBER (3,2) not null); --NUMBER (3,2) :��ü 3�ڸ��� �Ҽ� 2�ڸ�
    
insert into test2_tb2 (a)
values (3.22);
select * from test2_tb2;
commit;    

create table member1 (
    no number (10) not null,
    id varchar2 (50) not null,
    passwd varchar2 (50) not null,
    name Nvarchar2 (6) not null,
    phone varchar2(50) null,
    address varchar2(100) null,
    mdate date not null,
    email varchar2 (50) null
    );
    
insert into member1 (no,id,passwd,name,phone,address,mdate,email)
values (1,'aaa','password','ȫ�浿','010-1111-1111','���� �߱� ���굿',sysdate,'aaa@aaa.com');

insert into member1
values (2,'bbb','password','�̼���','010-2222-2222','���� �߱� ���굿',sysdate,'bbb@bbb.com');

--null ��� �÷��� null�� ���� �Ҵ�.
insert into member1 (no,id,passwd,name,phone,address,mdate,email)
values (3,'ccc','password','������',null,null,sysdate,null);

--null��� �÷��� ���� ���� ���� ��� null���� ��.
insert into member1 (no,id,passwd,name,mdate)
values (4,'ddd','password','�̼���',sysdate);


commit; --���ϸ� ����--

select * from member1;

drop table member1; 
    
desc member1;    
    
--������ ���� (update : ������ ������ commit ,
        --�ݵ�� where ������ ����ؾ� �Ѵ�.�׷��� ������ ��� ���ڵ尡 ������.
        /*
            update ���̺��
            set �÷��� = ������ ��
            where �÷��� = ��
        */
        update member1 --member1 ���̺��� ����
        set name = '�Ż��Ӵ�' --name �÷��� '�Ż��Ӵ�'���� �ٲٴµ�
        where no = 2; -- no�÷��� 2���� �÷��� ���� �ٲ��
        commit;
    
--where�� ���������� name�÷��� ��� �ٲ� 
select * from member1;    
update member1
set name = '��������'
where no = 3;
rollback;
commit;

update member1
set id = 'abcd'
where no = 3;

update member1
set name = '������'
where no =1;

update member1
set mdate = '2022/01/01'
where no = 4;

update member1
set email = 'abcd@abcd.com'
where no = 1;
rollback;
commit;
select * from member1;

--�ϳ��� ���ڵ忡�� �����÷� ���ÿ� �����ϱ�
update member1
set name = '������' , email = 'kkk@kkk.com' , phone = '010-7777-7777'
where no = 1;

select * from member1;

update member1
set mdate = to_date('2022-01-01','YYYY-MM-DD')
--set madet = '2022-01-01'
where no = 3;
commit;

--���ڵ� (�ο�) ���� (delete : �ݵ�� where ������ ����ؾ���.)

/*
    delete ���̺�� 
    where �÷��� = ��
    
*/

select * from member1;

delete member1
where no = 3;

commit;

delete member1 ; -- where���� ����ϸ� ��� ���ڵ尡 ������

rollback;

/*
    update�� delete�� �ݵ�� where������ ����ؾ� �Ѵ�. 
    Ʈ������� ���� (rollback, commit)                  
    
*/

/*
    update, delete �� where���� ���Ǵ� �÷��� ������ �÷��̾��� �Ѵ�.
    (Primary key, Unique �÷��� ����ؾ� �Ѵ�.)
    �׷��� ������ ���� �÷��� ������Ʈ �ǰų� ������ ���� �ִ�.
    
*/
update member1
set name = '��ʶ�'
where no = 4;
select * from member1;

--���� ���� : �÷��� ���Ἲ�� Ȯ���ϱ� ���ؼ� ���, 
    --���Ἲ : ���Ծ��� ������ (��, �������� ������, �������ϴ� �����͸� ����)
    --primary key
        --�ϳ��� ���̺� �ѹ��� ���
        --�ߺ��� �����͸� ������ ������.
        --null���� ���� �� ����. (�Ҵ� �� �� ����.)
create table member2 (
    no number (10) not null primary key,
    id varchar2 (50) not null,
    passwd varchar2 (50) not null,
    name Nvarchar2 (6) not null,
    phone varchar2(50) null,
    address varchar2(100) null,
    mdate date not null,
    email varchar2 (50) null
    );
    
    insert into member2 (no,id,passwd,name,phone,address,mdate,email)
values (7,'aaa','password','ȫ�浿','010-1111-1111','���� �߱� ���굿',sysdate,'aaa@aaa.com');

insert into member2
values (2,'bbb','password','�̼���','010-2222-2222','���� �߱� ���굿',sysdate,'bbb@bbb.com');

--null ��� �÷��� null�� ���� �Ҵ�.
insert into member2 (no,id,passwd,name,phone,address,mdate,email)
values (3,'ccc','password','������',null,null,sysdate,null);

--null��� �÷��� ���� ���� ���� ��� null���� ��.
insert into member2 (no,id,passwd,name,mdate)
values (4,'ddd','password','�̼���',sysdate);

select * from member2;

update member2
set name = '������'
where no = 6; -- <== ���̺��� �ߺ����� �ʴ� ������ �÷��� �������� ����ؾ� �Ѵ�.

commit;
rollback;

/*
    ��������
        -- UNIQUE : �ߺ����� �ʴ� ������ ���� ����. 
            -- �ϳ��� ���̺��� ���� �÷��� ���� �� �� �ִ�.
            -- null���� ����Ѵ�. null�� �ѹ��� ���� �� �ִ�.
            
*/

create table member3 (
    no number (10) not null primary key, -- �ߺ��� ���� ���� �� ����.
    id varchar2 (50) not null Unique , -- �ߺ��� ���� ���� �� ����.
    passwd varchar2 (50) not null,
    name Nvarchar2 (6) not null,
    phone varchar2(50) null,
    address varchar2(100) null,
    mdate date not null,
    email varchar2 (50) null
    );
    
    insert into member3 (no,id,passwd,name,phone,address,mdate,email)
values (1,'aaa','password','ȫ�浿','010-1111-1111','���� �߱� ���굿',sysdate,'aaa@aaa.com');

insert into member3
values (2,'bbb','password','�̼���','010-2222-2222','���� �߱� ���굿',sysdate,'bbb@bbb.com');

--null ��� �÷��� null�� ���� �Ҵ�.
insert into member3 (no,id,passwd,name,phone,address,mdate,email)
values (3,'ccc','password','������',null,null,sysdate,null);

--null��� �÷��� ���� ���� ���� ��� null���� ��.
insert into member3 (no,id,passwd,name,mdate)
values (6,'fff','password','�̼���',sysdate);

select * from member3;

commit;
rollback;
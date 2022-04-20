-- dno컬럼이 10번 부서일 경우 월급에서+ 300을 처리하고 , 20번 부서일 경우 월급에 +500을 
-- 부서번호가 30일 경우 월급에 +700 을 해서 이름,월급,부서별월급플러스한 결과를 출력

select *
from employee;

select ename, dno,salary,decode ( dno, 10, salary+300,
                                    20, salary+500,
                                    30, salary+700,
                                    salary) 부서별월급플러스
from employee;
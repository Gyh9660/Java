--8. 사원번호,가린번호,사원이름,가린이름 출력 

select eno 사원번호,rpad(substr(eno,1,2),4,'*') 가린번호 , ename 사원이름 ,
rpad(substr(ename,1,1),4,'*') 가린이름
from employee;

--9. 주민번호: 를 출력하되 801210-1****** 출력하도록, 전화번호 :010-11*******
select '주민번호 : 801210-1333333' 주민번호,
rpad(substr('주민번호 : 801210-1333333',1,15),25,'*') 가린주민번호,
'전화번호 : 010-1111-2222' 전화번호,
rpad(substr('전화번호 : 010-1111-2222',1,13),24,'*') 가린전화번호
from dual;

--10. 10. 사원번호, 사원명, 직속상관, 
/*	[직속상관의 사원번호가 없을 경우 : 0000
	 직속상관의 사원번호가  앞 2자리가 75일 경우 : 5555
	직속상관의 사원번호가  앞 2자리가 76일 경우 : 6666
	직속상관의 사원번호가  앞 2자리가 77일 경우 : 7777
	직속상관의 사원번호가  앞 2자리가 78일 경우 : 8888
	그외는 그대로 출력. 
  */
select eno, ename , manager ,case when manager is null then '0000'
                                  when substr(manager,1,2) = '75' then '5555'             
                                  when substr(manager,1,2) = '76' then '6666'
                                  when substr(manager,1,2) = '77' then '7777'
                                  when substr(manager,1,2) = '78' then '8888'
                             ELSE to_char(manager)
                             END "상관번호에 따른 분류"        
from employee;
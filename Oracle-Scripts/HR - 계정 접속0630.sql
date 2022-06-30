select * from employees;
select * from departments;
select * from job_history;
select * from locations;

select * 
from employees e ,
     departments d ,
     job_history j ,
     locations l
where e.department_id = d.department_id
      and d.location_id = l.location_id
      and j.department_id = d.department_id;
      
      
select * 
from employees e ,
     departments d ,
     job_history j ,
     locations l
where e.department_id = d.department_id
      and d.location_id = l.location_id
      and j.department_id = d.department_id;

SELECT E.EMPLOYEE_ID, E.FIRST_NAME, E.LAST_NAME, E.EMAIL, E.PHONE_NUMBER, E.HIRE_DATE,
			   E.JOB_ID, E.SALARY, E.COMMISSION_PCT, E.MANAGER_ID, E.DEPARTMENT_ID,
			   D.DEPARTMENT_NAME, D.LOCATION_ID,
			   L.STREET_ADDRESS, L.POSTAL_CODE, L.CITY, L.STATE_PROVINCE, L.COUNTRY_ID,
			   J.START_DATE, J.END_DATE
		FROM EMPLOYEES E ,
    	DEPARTMENTS D ,
     	JOB_HISTORY J ,
     	LOCATIONS L
		WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID
      			AND D.LOCATION_ID = L.LOCATION_ID
      			AND J.DEPARTMENT_ID = D.DEPARTMENT_ID;
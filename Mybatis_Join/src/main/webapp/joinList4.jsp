<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@taglib uri ="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>조인 출력</title>
</head>
<body>

<section style="align-content: center;">
	<h2>조인 정보 출력</h2>
	
	<hr>
	
	<table border ="1" width ="700" cellspacing="0" cellpadding="0">
		<tr>
			<td>EMPLOYEE_ID</td>
			<td>FIRST_NAME</td>
			<td>LAST_NAME</td>
			<td>EMAIL</td>
			<td>PHONE_NUMBER</td>
			<td>HIRE_DATE</td>
			<td>JOB_ID</td>
			<td>SALARY</td>
			<td>COMMISSION_PCT</td>
			<td>MANAGER_ID</td>
			<td>DEPARTMENT_ID</td>
			<td>DEPARTMENT_NAME</td>
			<td>LOCATION_ID</td>
			<td>STREET_ADDRESS</td>
			<td>POSTAL_CODE</td>
			<td>CITY</td>
			<td>STATE_PROVINCE</td>
			<td>COUNTRY_ID</td>
			<td>START_DATE</td>
			<td>END_DATE</td>
		</tr>
		
		<!-- Loop 시작 -->
		<c:forEach items="${joinList}" var="join" varStatus="loop">
		<tr>
			<td>${join.JEmps.employee_id}</td>
			<td>${join.JEmps.first_name}</td>
			<td>${join.JEmps.last_name}</td>
			<td>${join.JEmps.email}</td>
			<td>${join.JEmps.phone_number}</td>
			<td>${join.JEmps.hire_date}</td>
			<td>${join.JEmps.job_id}</td>
			<td>${join.JEmps.salary}</td>
			<td>${join.JEmps.commission_pct}</td>
			<td>${join.JEmps.manager_id}</td>
			<td>${join.JEmps.department_id}</td>
			<td>${join.JDepts.department_name}</td>
			<td>${join.JDepts.location_id}</td>
			<td>${join.JLoca.street_address}</td>
			<td>${join.JLoca.postal_code}</td>
			<td>${join.JLoca.city}</td>
			<td>${join.JLoca.state_province}</td>
			<td>${join.JLoca.country_id}</td>
			<td>${join.JJob.start_date}</td>
			<td>${join.JJob.end_date}</td>
		</tr>  
		</c:forEach>
	</table>
</section>


</body>
</html>
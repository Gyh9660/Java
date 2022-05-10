<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Oracle</title>
</head>
<body>
	<form method = "post" action="Update01_process.jsp">
	<p> 사원번호 <input type ="number" name = "eno">
	<p> 사원이름 <input type ="text" name = "ename">
	<p> 업무 <input type ="text" name = "job">
	<p> 상사번호 <input type ="number" name = "manager">
	<p> 입사일 <input type = "date" name = "hiredate">
	<p> 월급 <input type = "number" name = "salary">
	<p> 수당 <input type = "number" name = "commission">
	<p> 부서번호 <input type = "number" name = "dno">
	<p> <input type = "submit" name = "전송">
	
	</form>

</body>
</html>
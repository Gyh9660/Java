<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@taglib uri ="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Spring 조인 출력</title>
</head>
<body>

<section style="align-content: center;">
	<h2>Spring 조인 정보 출력</h2>
	
	<hr>
	
	<table border ="1" width ="700" cellspacing="0" cellpadding="0">
		<tr>
			<td>DEPTNO</td>
			<td>DNAME</td>
			<td>LOC</td>
			<td>EMPTNO</td>
			<td>ENAME</td>
			<td>SAL</td>
		</tr>
		
		<!-- Loop 시작 -->
		<c:forEach items="${sjoinList}" var="join" varStatus="loop">
		<tr>
			<td>${join.sdept.deptno }</td>
			<td>${join.sdept.dname }</td>
			<td>${join.sdept.loc}</td>
			<td>${join.semp.empno}</td>
			<td>${join.semp.ename}</td>
			<td>${join.semp.sal}</td>
		</tr>   
		</c:forEach>
	</table>
</section>


</body>
</html>
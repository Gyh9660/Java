<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	request.setCharacterEncoding("UTF-8");

	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	String name = request.getParameter("name");
	
%>
	<!-- JSTL로 DataBase 커넥션 설정 -->
	<sql:setDataSource var ="dataSource" 
		url = "jdbc:oracle:thin:@localhost:1521:XE"
		driver ="oracle.jdbc.driver.OracleDriver"
		user = "hr2" password="1234"/>

	<sql:update dataSource="${dataSource }" var="resultSet">
		insert into member (id,pass,name) values (?,?,?)
		<sql:param value = "<%=id %>"/>
		<sql:param value = "<%=passwd %>"/>
		<sql:param value = "<%=name %>"/>
	</sql:update>

	<!--  forward와 비슷한 개념 -->
	<c:import var = "url" url="sql01.jsp"/>
	
	${url }


</body>
</html>
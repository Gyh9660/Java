<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="person" class="dao.Person" scope="request"></jsp:useBean>
	<jsp:setProperty property="id" name="person" value="20220606"/>
	<jsp:setProperty property="name" name="person" value ="현충일(휴일)"/>
	
	<p> 아이디 : <jsp:getProperty property="id" name="person"/>
	<p> 이름 : <jsp:getProperty property="name" name="person"/>
	
</body>
</html>
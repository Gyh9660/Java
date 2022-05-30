<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="person" class = "dao.Person" scope="request"></jsp:useBean>

	<p> 아이디 : <%= person.getId() %>
	<p> 이름 : <%= person.getName() %>
	
	<%	//기본 생성자 : 실행부는 비어있음
		//Setter 주입
		person.setId(20220530);
		person.setName("김유신");

	%>
	
	<p>
	<p>
	<p>
	<jsp:include page="UseBean03.jsp"></jsp:include>
	
	

</body>
</html>
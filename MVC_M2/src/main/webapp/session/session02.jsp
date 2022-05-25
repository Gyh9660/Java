<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session 객체의 변수에 할당된 값 가져오기</title>
</head>
<body>
<h2> session 객체의 변수에 할당된 값 가져오기</h2>
<%
	//Session 객체의 값을 가져올때 Object타입이므로 반드시 다운캐스팅이 필요하다.
		
		//모든 페이지에서 세션의 변수에 들어간 값을 가져와서 null 일 경우 : 로그인이 안된 상태>
		//getAttribute < == 세션객체에 담긴 하나의 변수의 값을 가져올 때
	String user_id = (String)session.getAttribute("userID");

	String user_pw = (String)session.getAttribute("userPW");

	out.println ("<p>설정된 세션의 속성값 1 : "+user_id);
	out.println ("<p>설정된 세션의 속성값 2 : "+user_pw);
%>

</body>
</html>
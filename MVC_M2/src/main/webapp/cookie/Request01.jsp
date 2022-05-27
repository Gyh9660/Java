<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request객체에 유용한 메소드들</title>
</head>
<body>
	<p> 클라이언트 IP :<%= request.getRemoteAddr() %> <!-- :0:0:0:0:0:0:0:1 ipv6 의 localhost(자기자신) -->
	<p> 요청 정보 길이 : <%= request.getContentLength() %>
	<p> 요청 정보 인코딩 : <%= request.getCharacterEncoding() %>
	<p> 요청 정보 컨텐츠 유형 : <%= request.getContentType() %>
	<p> 요청 정보 프로토콜 : <%= request.getProtocol() %>
	<p> 요청 정보 URL : <%= request.getRequestURL() %>
	<p> 요청 정보 URI : <%= request.getRequestURI() %>
	<p> 컨텍스트 경로 : <%= request.getContextPath() %>
	<p> 접속 서버 이름 : <%= request.getServerName() %>
	<P> 접속 서버 포트 : <%= request.getServerPort() %>
	<p> 서버의 물리적인 경로 : <%= request.getRealPath("cookie") %>
	
</body>
</html>
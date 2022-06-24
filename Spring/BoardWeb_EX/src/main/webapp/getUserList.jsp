<%@page contentType="text/html; charset=EUC-KR"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>유저목록</title>
</head>
<body>
	<center>
		<h1>유저 목록</h1>
		<h3>
			유저 목록 게시판<a href="logout.do">Log-out</a>
			<!-- 커맨드객체 출력 jstl아아님 -->
		</h3>
		<table border="1" cellpadding="0" cellspacing="0" width="700">
			<tr>
				<th bgcolor="orange" width="100">야이디</th>
				<th bgcolor="orange" width="200">비밀번호</th>
				<th bgcolor="orange" width="150">이름</th>
				<th bgcolor="orange" width="150">role</th>
			</tr>
			<c:forEach items="${userList }" var="user">
				<tr><!-- jstl -->
					<td align="left"><a href="getUser.do?id=${user.id }">
							${user.id }</a></td>
					<td>${user.pass }</td>
					<td>${user.name }</td>
					<td>${user.role }</td>
				</tr>
			</c:forEach>
		</table>
		<br> <a href="index.jsp">목록으로 돌아가기</a>
	</center>
</body>
</html>
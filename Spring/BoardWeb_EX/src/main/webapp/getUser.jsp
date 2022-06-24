<%@page contentType="text/html; charset=EUC-KR"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>유저 상세</title>
</head>
<body>
	<center>
		<h1>유저 상세</h1>
		<a href="logout.do">Log-out</a>
		<hr>
		<form action="updateUser.do" method="post">
			<input name="seq" type="hidden" value="${user.id}" />
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="orange" width="70">비밀번호</td>
					<td align="left"><input name="pass" type="password"
						value="${user.pass }" /></td>
				</tr>
				<tr>
					<td bgcolor="orange">이름</td>
					<td align="left"><input name="name" type="text"
						value="${user.name }" /></td>
				</tr>
				<tr>
					<td bgcolor="orange">role</td>
					<td align="left"><input name="role" type="text"
						value="${user.role}" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="유저 정보 수정" /></td>
				</tr>
			</table>
		</form>
		<hr>
		<a href="insertUser.jsp">유저 등록</a>&nbsp;&nbsp;&nbsp; 
		<a href="deleteUser.do?id=${user.id }">유저 삭제</a>&nbsp;&nbsp;&nbsp;
		<a href="getUserList.do">유저 목록</a>
	</center>
</body>
</html>

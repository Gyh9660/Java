<%@page contentType="text/html; charset=EUC-KR"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>���� ��</title>
</head>
<body>
	<center>
		<h1>���� ��</h1>
		<a href="logout.do">Log-out</a>
		<hr>
		<form action="updateUser.do" method="post">
			<input name="seq" type="hidden" value="${user.id}" />
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="orange" width="70">��й�ȣ</td>
					<td align="left"><input name="pass" type="password"
						value="${user.pass }" /></td>
				</tr>
				<tr>
					<td bgcolor="orange">�̸�</td>
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
						value="���� ���� ����" /></td>
				</tr>
			</table>
		</form>
		<hr>
		<a href="insertUser.jsp">���� ���</a>&nbsp;&nbsp;&nbsp; 
		<a href="deleteUser.do?id=${user.id }">���� ����</a>&nbsp;&nbsp;&nbsp;
		<a href="getUserList.do">���� ���</a>
	</center>
</body>
</html>

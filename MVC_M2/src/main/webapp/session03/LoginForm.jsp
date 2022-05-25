<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session 03</title>
</head>
<body>
	<table border = "1" style = "width:90%">
		<tr>
			<td align = "center">
				<% if (session.getAttribute("userId")== null)  {%>
					<a href = "../session03/LoginForm.jsp">로그인</a>
				<% }else{  %>
					<a href = "Logout.jsp">로그아웃</a>
				<% } %>
			</td>
		</tr>
	
	</table>
	
	<h2> 로그인 페이지 </h2>
	
	<span style = "color:red; font-size:1.2em;align:center;" >
		<%=request.getAttribute("LoginErrMsg")==null ? "" : request.getAttribute("LoginErrMsg") %>
	</span>
	
	<%
		if(session.getAttribute("userId")== null){
	%>
		<script type="text/javascript">
			function validateForm (form){
				if (!form.user_id.value){
					alert ("아이디를 입력해 주세요!!");
					return false;
				}
				if (!form.user_pw.value){
					alert ("패스워드를 입력해 주세요!!");
					return false;
				}
			}
		</script>
		<form action = "LoginProcess.jsp" method ="post" name = "loginFrm" onsubmit = "return validateForm(this);">
			<table>
				<tr>
					<td> 아이디 : </td>
					<td> <input type = "text" name = "user_id"> </td>
				</tr>
				<tr>
					<td> 패스워드 : </td>
					<td> <input type = "password" name = "user_pw"> </td>
				</tr>
				<tr>
					<td colspan="2"> <input type ="submit" value ="로그인"></td>
				</tr>	
			</table>
		</form>
		
		<% }else {  %>
			
			<% if (session.getAttribute("userGrade").equals("vip")) { %>
				
				<div style="background-color:red;width:300px;height: 10px;"></div>
				
			<% }else if (session.getAttribute("userGrade").equals("gold") ) { %>
				
				<div style="background-color:yellow;width:300px;height: 10px;"></div>
				
			<% }else if (session.getAttribute("userGrade").equals("silver") ) { %>
			
				<div style="background-color:blue;width:300px;height: 10px;"></div>
				
			<% } %>
			
			<%=session.getAttribute("userName") %>회원님, 로그인 하셨습니다.<br>
			<a href = "Logout.jsp">[로그아웃]</a>
		
		
		<% } %>
		
		
		
		
		
</body>
</html>
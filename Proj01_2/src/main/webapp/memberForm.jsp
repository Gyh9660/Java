<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
function fn_sendMember(){
	 var frmMember = document.frmMember;
	 var id = frmMember.id.value;
	 var pwd = frmMember.pwd.value;
	 var name = frmMember.name.value;
	 var email = frmMember.email.value;
	 
	 if(id.length ==0 || id ==""){
		 alert ("아이디는 필수 입니다.");
	 }else if (pwd.length ==0 || pwd ==""){
		 alert ("패스워드는 필수 입니다.");
	 }else if (name.length ==0 || name ==""){
		 alert ("이름은 필수 입니다.");
	 }else if (email.length ==0 || email ==""){
		 alert ("이메일은 필수 입니다.");
	 }else {
		 frmMember.method="post";
		 frmMember.action="member.do";
		 frmMember.submit(); 
	 }
 }
</script>
</head>
<body>
	<h2>회원 가입 입력 폼</h2>

	<!-- form태그 내의 action, method는 java 스크립트에서 처리해서 전송 -->
	<form name = "frmMember">
	<table>
		<tr>
			<td> 아이디 </td>
			<td><input type = "text" name ="id"></td>
		</tr>
		<tr>
			<td> 비밀번호 </td>
			<td><input type = "password" name ="pwd"></td>
		</tr>
		<tr>
			<td> 이름 </td>
			<td><input type = "text" name = "name"></td>
		</tr>
		<tr>
			<td> 이메일 </td>
			<td><input type = "text" name = "email"></td>
		</tr>
		<tr>
			<td colspan = "2" align ="center">
			<input type ="button" value = "가입하기" onclick = "fn_sendMember()"/>
			<input type ="reset" value = "다시 입력">
			<input type ="hidden" name = "command" value = "addMember">
			</td>
		</tr>
	
	</table>
	</form>
</body>
</html>
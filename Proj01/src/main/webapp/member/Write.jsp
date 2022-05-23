<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 -Write</title>
<script type="text/javascript">
	function validateForm (form){
		if(form.id.value == "" || form.id.value.length==0){
			alert("ID를 입력하세요");
			form.id.focus();
			return false;
		}
		if(form.pwd.value == "" || form.pwd.value.length==0){
			alert("PWD를 입력하세요");
			form.pwd.focus();
			return false;
		}
		if(form.name.value == "" || form.name.value.length==0){
			alert("NAME을 입력하세요");
			form.name.focus();
			return false;
		}
		if(form.email.value == "" || form.email.value.length==0){
			alert("EMAIL을 입력하세요");
			form.email.focus();
			return false;
		}
	}


</script>
</head>
<body>
	<h2>게시판 - Write</h2>
	
	<form name = "writeFrm" method ="post" action ="../member/write.do" onsubmit ="return validateForm(this)">
		<table>
			<tr>
				<td> 아이디 : </td>
				<td> <input type="text" name="id" style="width:150px;" ></td>
			</tr>
			<tr>
				<td> 비밀번호 : </td>
				<td> <input type="password" name="pwd" style="width:90%;" ></td>
			</tr>
			<tr>
				<td> 이름 : </td>
				<td>  <input type="text" name="name" style="width:90%;" ></td>
			</tr>
			<tr>
				<td> 이메일 : </td>
				<td> <input type="text" name="email" style="width:90%;" ></td>
			</tr>
			<tr>
			<td colspan="2" align="center">
				<button type="submit"> 작성 완료 </button>
				<button type="reset"> RESET </button>
				<button type="button" onclick="location.href = '../member/list.do';" > 목록 바로가기 </button>
			</td>
		</tr>
	
	
		</table>
	
	
	</form>
</body>
</html>
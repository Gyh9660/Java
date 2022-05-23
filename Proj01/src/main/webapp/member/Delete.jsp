<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	function validateForm(form){
		if (form.id.value == ""){
			alert("아이디를 입력하세요");
			form.id.focus();
			return false;
		}
		if (form.pwd.value == ""){
			alert("비밀번호를 입력하세요");
			form.pwd.focus();
			return false;
		}
	}

</script>



<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> DELETE</h2>
	
	<form name= "writeFrm" method ="post" action = "../member/delete.do" onsubmit = "return validateForm(this);">	
		<table border = "1" style ="width:90%">
			<tr>
				<td> 아이디 : </td>
				<td><input type ="text" name = "id" style ="width:100px"></td>
			</tr>
			<tr>
				<td> 비밀번호 : </td>
				<td><input type ="password" name = "pwd" style ="width:100px"></td>
			</tr>
			<tr>
				<td colspan = "2" align ="center">
					<button type = "submit" > 검증하기 </button>
					<button type = "reset" > RESET </button>
					<button type = "button" onclick = "location.href ='../member/list.do';"> 
						목록 바로가기 
					</button>
					
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
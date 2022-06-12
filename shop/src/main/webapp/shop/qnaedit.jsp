<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-1.11.0.min.js"></script>
<script src="qnawrite.js"></script>
</head>
<body>
<%@ include file = "header.jsp" %>   
 <br>
	<br>
	<br>
	<br>
	<br>
	<br> 
	<h2 style="text-align: center;">글 수정</h2>
	<br>
	<br>
	<br> 
	<hr style="width: 80%;height: 5px; background-color: black;">
	<br>
<form name="writeFrm" method="post" action="../shop/edit.do" onsubmit="return validateForm(this)">
	<input type="hidden"  name="u_id" value = <%=u_id %>>
	<input type="hidden"  name="q_id" value = "${param.q_id }">
	<table  style ="width:80%;border-collapse: collapse; background-color: white;" border="1">
		<tr style="height: 15px"></tr>
		<tr style="border:none">
			<td style ="width:15%; text-align: center;border:none"> 작성자 </td>
			<td style="border:none"> <input type="text" name="id" style="width:150px;" 
				value = <%=u_id %> disabled></td>
		</tr>
		<tr style="height: 30px;border:none"></tr>
		<tr style="border:none"></tr>
		<tr style="border:none">
			<td style ="width:15%; text-align: center;border:none"> 제목 </td>
			<td style="border:none"> <input type="text" name="subject" style="width:80%;" value="${qdto.subject }"disabled></td>
		</tr>
		<tr style="height: 5px"></tr>
		<tr style="border:none">
			<td style ="width:15%; text-align: center;border:none"> 내용 </td>
			<td style="border:none"> <textarea name="content" style="width:80%;height:300px;resize:none" >${qdto.content }</textarea></td>
		</tr>
		<tr style="height: 30px;border:none"></tr>
		<tr style="border:none">
			<td colspan="2" align="center" style="border:none">
				<button type="submit"> 수정 완료 </button>
				<button type="reset"> RESET </button>
				<button type="button" onclick="location.href = '../shop/list.do';" > 목록 바로가기 </button>
			</td>
		</tr>
		<tr style="height: 15px"></tr>
	</table>

</form>
<%@ include file = "footer.jsp" %> 
</body>
</html>
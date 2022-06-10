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
  
<form name="writeFrm" method="post" action="../shop/write.do" onsubmit="return validateForm(this)">
	<table  style ="width:90%">
		<tr>
			<td> 작성자 </td>
			<td> <input type="text" name="name" style="width:150px;" 
				value = <%=u_id %> disabled></td>
		</tr>
		<tr>
			<td> 분류 </td>
			<td> <select name="qnatype">
                <option value="1">[상품 문의]</option>
                <option value="2">[배송 문의]</option>
                <option value="3">[기타 문의]</option>
            	</select>
			</td>
		</tr>
		<tr>
			<td> 제목 </td>
			<td> <input type="text" name="title" style="width:90%;" ></td>
		</tr>
		<tr>
			<td> 내용 </td>
			<td> <textarea name="content" style="width:90%;height:100px;"></textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="submit"> 작성 완료 </button>
				<button type="reset"> RESET </button>
				<button type="button" onclick="location.href = '../shop/list.do';" > 목록 바로가기 </button>
			</td>
		</tr>
	
	</table>

</form>
<%@ include file = "footer.jsp" %> 
</body>
</html>
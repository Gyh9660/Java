<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- enctype는 파일을첨부해서 올릴때 반드시 post여야하고 multipart/form-data여야 한다. -->
	<h2>파일 첨부형 게시판 - 수정하기 (Edit)</h2>
	<!-- 
		폼에서 파일을 업로드 할때
			1.method 가 반드시 post
			2.enctype = "multipart/form-data"로 설정이 되어야한다.
			파일첨부가 없으면 생략해도 되지만 있으면 반드시 써야한다.
				form의 모든 변수는 request객체(를못씀)가 아니라 라이브러리에서 지정한 메소드에서 변수의값을 받는다.
				multipart/form-data를 처리하기위해서 cos.jar필요
				
				cos.jar => 파일을 업로드 할수있는 라이브러리
	 -->
	<form name = "writeFrm" method = "post" enctype="multipart/form-data" action ="../mvcboard/edit.do" onsubmit="return validateForm(this);">
	<!--  넘어온 변수값을 다음페이지로 전송하기위한 hidden -->
	<input type ="hidden" name = "idx" value = "${dto.idx }">
	<input type ="hidden" name = "prevOfile" value = "${dto.ofile }">
	<input type ="hidden" name = "prevSfile" value = "${dto.sfile }">

		<table border = "1" style ="width:90%">
		<tr>
			<td> 작성자 </td>
			<td>
				<input type ="text" name="name" style ="width:150px" value = "${dto.name }">
			</td>
		
		</tr>
		
		<tr>
			<td> 제목 </td>
			<td>
				<input type ="text" name = "title" style ="width:90%" value = "${dto.title }">
			</td>
		
		</tr>
		
		<tr>
			<td> 내용 </td>
			<td>
				<textarea name ="content" style ="width:90%; heigh:500px">${dto.content }</textarea>
			</td>
			
		</tr>
		
		<tr>
			<td> 첨부파일 </td>
			<td>
				<input type ="file" name = "ofile" >
			</td>	
		</tr>
		<tr>
			<td colspan = "2" align = "center">
				<button type ="submit" > 작성완료 </button>
				<button type ="reset" > RESET </button>
				<button type = "button" onclick ="location.href='../mvcboard/list.do';">목록 바로가기</button>
		
			</td>
		</tr>
		
		
		</table>


	</form>


</body>
</html>
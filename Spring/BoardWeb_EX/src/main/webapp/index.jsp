<%@page contentType="text/html; charset=EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Main Page</title>
</head>
<body>
	<center>
		<h1>게시판 프로그램</h1>
		<hr>
		<a href="login.do">로그인</a><br>
		<br>
		<a href= "insertUser.do" >회원가입</a>
		<br>
		<!-- a태그를 통해서 링크걸린 전송방식은 get방식으로 전송 -->
		<br> <a href="getBoardList.do">글 목록 바로가기</a><br><br><br>
		
		<br>
		<a href ="getUserList.do">유저 목록 바로가기</a><br>
		<br>
		
		<a href="dataTransform.do">글 목록 변환 처리</a><br>
		<hr>
	</center>
</body>
</html>
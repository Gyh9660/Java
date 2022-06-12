<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link rel='stylesheet' type='text/css' media='screen' href='../css/header.css'>
    <!-- fond-awesome.css 추가 -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.css">
</head>
<body>
<%
String u_id ="";
try{
	//id세션 속성의 값을 얻어내서 id변수에 저장
	//인증된 사용자의 경우  id세션 속성의 값 null또는 공백이 아님
	u_id = (String)session.getAttribute("u_id");
%>
 <header>
        <div class="top">
        <%if(u_id == null || u_id.equals("")){ //인증되지 않은 사용자 영역%>
            <ul class="home">
                <li><a class ="headera" href="main.jsp">Home</a></li>
                <li><a class ="headera" href="#">장바구니</a></li>
                <li><a class ="headera" href="../shop/login.do">로그인</a></li>
                <li><a class ="headera" href="#">마이페이지</a></li>
            </ul>
        <%}else if(u_id.equals("admin")){//관리자%>
        	<ul class="home">
                <li><a class ="headera" href="main.jsp">Home</a></li>
                <li><a class ="headera" href="#">장바구니</a></li>
                <li><a class ="headera" href="../shop/login.do">로그아웃</a></li>
                <li><a class ="headera" href="#">마이페이지</a></li>
                <li><a class ="headera" href="../shop/admin.do">관리페이지</a></li>
            </ul>
        <%}else{//인증된 사용자 영역%>
	    	<ul class="home">
	            <li><a class ="headera" href="main.jsp">Home</a></li>
	            <li><a class ="headera" href="#">장바구니</a></li>
	            <li><a class ="headera" href="../shop/login.do">로그아웃</a></li>
	            <li><a class ="headera" href="#">마이페이지</a></li>
       		</ul>
        <%}}catch(Exception e){e.printStackTrace();}%>    
            <div class="logo"><a class ="headera" href="main.jsp"><img src="../img/logo1.jpg" alt="로고"></a></div>
            <nav class="menu">
                <ul class="nav">
                    <li><a class ="headera" href="#">BEST</a>
                    </li>
                    <li><a class ="headera" href="#">EVENT</a>
                        <ul class="submenu">
                            <li><a class ="headera" href="#">SALE</a></li>
                            <li><a class ="headera" href="#">EVENT</a></li>
                            <li><a class ="headera" href="#">예약구매</a></li>
                        </ul>
                    </li>
                    <li><a class ="headera" href="../shop/plist.do">Switch</a>
                        <ul class="submenu">
                            <li><a class ="headera" href="../shop/plist.do">하드웨어</a></li>
                            <li><a class ="headera" href="../shop/plist.do">소프트웨어</a></li>
                            <li><a class ="headera" href="../shop/plist.do">주변기기</a></li>
                        </ul>
                    </li>
                    <li><a class ="headera" href="#">3DS</a>
                        <ul class="submenu">
                            <li><a class ="headera" href="#">하드웨어</a></li>
                            <li><a class ="headera" href="#">소프트웨어</a></li>
                            <li><a class ="headera" href="#">주변기기</a></li>
                        </ul>
                    </li>
                    <li><a class ="headera" href="#">액세서리</a>
                        <ul class="submenu">
                            <li><a class ="headera" href="#">Switch</a></li>
                            <li><a class ="headera" href="#">3DS</a></li>
                            <li><a class ="headera" href="#">굿즈</a></li>
                        </ul>
                    </li>
                    <li><a class ="headera" href="../shop/list.do">고객센터</a>
                        <ul class="submenu">
                            <li><a class ="headera" href="#">공지사항</a></li>
                            <li><a class ="headera" href="#">1대1문의</a></li>
                            <li><a class ="headera" href="#">상품후기</a></li>
                        </ul>
                    </li>
                </ul>
            </nav>
        </div>
    </header>
</body>
</html>
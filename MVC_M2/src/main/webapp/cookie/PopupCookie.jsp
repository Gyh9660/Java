<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>팝업 쿠키를 처리하는 페이지</title>
</head>
<body>
	<%
		String chkVal = request.getParameter("inactiveToday");
	
	if	(chkVal != null && chkVal.equals("1")){
		Cookie cookie = new Cookie("popupClose", "off"); //쿠키 생성
		cookie.setPath(request.getContextPath()); // 경로 설정 (/MVC_M2)
		cookie.setMaxAge(60 * 60 * 24); // 쿠키 저장 기간 : 하루
		response.addCookie(cookie);
		out.println ("쿠키 : 하루동안 열리지 않음 ( 쿠키 저장 성공)");
	
	
	}
	
	
	
	%>




</body>
</html>
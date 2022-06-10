<%@page import="com.springbook.biz.impl.UserDAO"%>
<%@page import="com.springbook.biz.user.UserVO"%>
<%@page contentType="text/html; charset=UTF-8" %>

<%
	//1. 사용자 입력 정보 추출
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	
	//2. DB연동 처리
	UserVO vo = new UserVO();
	vo.setId(id);
	vo.setPass(pass);
	
	UserDAO userDAO = new UserDAO();
	UserVO user = userDAO.getUser(vo);
	
	//3. 화면 네비게이션
	if(user != null){
		response.sendRedirect("getBoardList.jsp");
		
	}else {
		response.sendRedirect("login.jsp");
	}



%>
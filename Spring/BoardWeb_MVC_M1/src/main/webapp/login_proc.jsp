<%@page import="com.springbook.biz.user.impl.UserDAO"%>
<%@page import="com.springbook.biz.user.UserVO"%>
<%@page contentType="text/html; charset=EUC-KR"%>

<%
	// 1. ����� �Է� ���� ����
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	
	// 2. DB ���� ó��
	UserVO vo = new UserVO();
	vo.setId(id);
	vo.setPass(pass);
	UserDAO userDAO = new UserDAO();
	UserVO user = userDAO.getUser(vo);
	// 3. ȭ�� �׺���̼�
	if (user != null) {
		response.sendRedirect("getBoardList.jsp");
	} else {
		response.sendRedirect("login.jsp");
	}
%>
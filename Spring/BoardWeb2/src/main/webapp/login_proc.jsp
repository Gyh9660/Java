<%@page import="com.springbook.biz.user.impl.UserDAO"%>
<%@page import="com.springbook.biz.user.UserVO"%>
<%@page import="com.springbook.biz.user.UserService"%>
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
	userDAO.getUser(vo);
	UserVO user = userDAO.getUser(vo);
	System.out.println(user);
	System.out.println(vo.getId());
	System.out.println(vo.getPass());
	System.out.println("�ٺ�"+userDAO.getUser(vo));
	// 3. ȭ�� �׺���̼�
	if (user != null) {
		response.sendRedirect("getBoardList.jsp");
	} else {
		response.sendRedirect("login.jsp");
	}
%>
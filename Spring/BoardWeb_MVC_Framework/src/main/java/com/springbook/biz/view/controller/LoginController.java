package com.springbook.biz.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

public class LoginController implements Controller{

	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("�α��� ó�� - MVC_Freamwork");
		
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
		//view ������ ������.
		if (user != null) {
			return "getBoardList.do";
		} else {
			return "login"; //ViewResolver ���������� ���������� �ϼ���.
		}
	}

	
}

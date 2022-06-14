package com.springbook.view.springmvc.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("�α��� ó��");
		
		// 1. ����� �Է� ���� ����
		String id = request.getParameter("id");
<<<<<<< HEAD
		String pass = request.getParameter("pass");
=======
		String password = request.getParameter("password");
>>>>>>> 9e0d4adb58faea260cdc14d29e5db0017df7b0c2

		//System.out.println("���̵� : " + id );
		//System.out.println("�н����� : " + password );
		
		// 2. DB ���� ó��
		UserVO vo = new UserVO();
		vo.setId(id);
<<<<<<< HEAD
		vo.setPass(pass);
=======
		vo.setPassword(password);
>>>>>>> 9e0d4adb58faea260cdc14d29e5db0017df7b0c2

		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUser(vo);
		/*
		if (user != null) {
			System.out.println("DB ���� �� ���� ���� ");
		}
		*/
		// 3. ȭ�� �׺���̼�
		ModelAndView mav = new ModelAndView();
		if (user != null) {
			mav.setViewName("redirect:getBoardList.do");
		} else {
			mav.setViewName("redirect:login.jsp");
		}
		return mav;
	}

}

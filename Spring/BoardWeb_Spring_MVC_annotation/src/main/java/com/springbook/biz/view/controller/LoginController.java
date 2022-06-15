package com.springbook.biz.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

public class LoginController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("�α��� ó�� - Spring_MVC ȣ��");
		
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
		ModelAndView mav = new ModelAndView();
		
		
		if (user != null) {
			mav.setViewName("redirect:getBoardList.do");;
			//redirect : viewResolver ������ �����ϰ� �����̷�Ʈ�Ѵ�
			//redirect : viewResolver�� preix suffix�� ������� �ʵ��� �Ѵ�,
		
			//�⺻���� Controller�� View�������� ���� ������ ����� Forward ����Դϴ�.
				//Ŭ���̾�Ʈ�� URL�� �ٲ��� �ʴ´�.
				//ViewResolver�� �۵��� �ȴ�. prefix, suffix�� ����
			//redirect : �������� ������ �������� client�� ���û
				//Ŭ���̾�Ʈ�� URL�� �ٲ��.
				//ViewResolver�� �۵��� �ҵȴ�.
			
		
		} else {
			mav.setViewName("redirect:login.jsp"); //ViewResolver ���������� ���������� �ϼ���.
		}
		return mav;
		
	}

	
}

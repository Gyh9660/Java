package com.springbook.biz.view.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

@Controller
public class LoginController {
	
	@RequestMapping(value="/login.do")
	public String login( UserVO vo, UserDAO userDAO) {
		System.out.println("�α��� ó�� - Spring_MVC ������̼� ȣ��");
		
		System.out.println("id "+vo.getId());
		System.out.println("pass "+vo.getPass());
		
		
		if (userDAO.getUser(vo) != null) {
			return "redirect:getBoardList.do";
			//redirect : viewResolver ������ �����ϰ� �����̷�Ʈ�Ѵ�
			//redirect : viewResolver�� preix suffix�� ������� �ʵ��� �Ѵ�,
		
			//�⺻���� Controller�� View�������� ���� ������ ����� Forward ����Դϴ�.
				//Ŭ���̾�Ʈ�� URL�� �ٲ��� �ʴ´�.
				//ViewResolver�� �۵��� �ȴ�. prefix, suffix�� ����
			//redirect : �������� ������ �������� client�� ���û
				//Ŭ���̾�Ʈ�� URL�� �ٲ��.
				//ViewResolver�� �۵��� �ҵȴ�.
		} else {
			return "redirect:login.jsp"; 
		}
		
	}

	
}

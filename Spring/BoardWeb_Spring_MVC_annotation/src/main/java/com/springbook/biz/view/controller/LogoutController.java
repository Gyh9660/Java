package com.springbook.biz.view.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController  {
	
	@RequestMapping(value="/logout.do")
	public String logout(HttpSession session) {
		System.out.println("�α׾ƿ� ó�� Spring MVC ������̼�");
		
		// 1. �������� �����? ���� ��ü�� ���� �����Ѵ�.
		session.invalidate();
		// 2. ���� ������, ���� ȭ������ �̵��Ѵ�.
		return "redirect:login.jsp";
	}

}

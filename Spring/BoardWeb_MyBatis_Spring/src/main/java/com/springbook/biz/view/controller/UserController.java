package com.springbook.biz.view.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

@Controller
public class UserController {

	//1-1. �α� �� : login Controller ���� (GET ��� ó�� �޼ҵ�)
		@RequestMapping(value="/login.do",method = RequestMethod.GET)
		//public String loginViewGet(UserVO vo) {
		public String loginViewGet(@ModelAttribute("user") UserVO vo) {
			System.out.println("�α��� ó�� - Spring_MVC ������̼� ȣ�� Controller ����");
			vo.setId("admin");
			vo.setPass("1234");
			return "login.jsp";	//forward�� ���۽� vo�� ������ ���� �� ���޵�
			//return "redirect:login.jsp";
			
			//Command ��ü�� ������ ���� ��Ƽ� View �������� ���� �� �� �ִ�.
			//VO ��ü�� Ŭ���� �̸��� UserVO, ${userCO.id} ������������ ����� �� �� �ִ�.
		/*
		 * @ModelAtrrtibute : Command ��ü�� �������� ��ü �̸��� �ٸ� �̸����� ����
		 * (UserVO => user)		
		 * view ���������� ��½� : ${user.id},${user.pass}
		 * 	
		 * */	
			
			
		}
		//1-2. �α� �� : login Controller ���� (POST ��� ó�� �޼ҵ�)
		@RequestMapping(value="/login.do",method = RequestMethod.POST)
		public String loginViewPost(UserVO vo, UserDAO userDAO,HttpSession session) {
			System.out.println("�α��� ó�� - Spring_MVC ������̼� ȣ�� Controller ����");
			
			if (vo.getId() == null || vo.getId().equals("")) {
				throw new IllegalArgumentException("���̵�� �ݵ�� �Է�");
			}	//vo�� id ������ ���� �Ѿ���� ������ ������ ���ܸ� �߻���Ŵ .....
			
			UserVO user = userDAO.getUser(vo);
			
			if(user != null) {
				session.setAttribute("userName", user.getName());
				return "getBoardList.do";
			}else {
				return "login.jsp";
			}
			
			
		}
		/*
		//1-3. �α� �� : login Controller ���� 
		@RequestMapping(value="/login.do")
		public String login( UserVO vo, UserDAO userDAO) {
			System.out.println("�α��� ó�� - Spring_MVC ������̼� ȣ�� Controller ����");
			
			if (userDAO.getUser(vo) != null) {
				return "redirect:getBoardList.do";
			} else {
				return "redirect:login.jsp"; 
			}
			
		}
		*/
		//2. �α� �ƿ� : logout Controller ����
		@RequestMapping(value="/logout.do")
		public String logout(HttpSession session) {
			System.out.println("�α׾ƿ� ó�� Spring MVC ������̼�  Controller ����");
			
			session.invalidate();
			return "redirect:login.jsp";
		}
}

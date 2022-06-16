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

	//1-1. 로그 인 : login Controller 통합 (GET 방식 처리 메소드)
		@RequestMapping(value="/login.do",method = RequestMethod.GET)
		//public String loginViewGet(UserVO vo) {
		public String loginViewGet(@ModelAttribute("user") UserVO vo) {
			System.out.println("로그인 처리 - Spring_MVC 어노테이션 호출 Controller 통합");
			vo.setId("admin");
			vo.setPass("1234");
			return "login.jsp";	//forward로 전송시 vo의 변수의 값이 잘 전달됨
			//return "redirect:login.jsp";
			
			//Command 객체에 변수의 값을 담아서 View 페이지로 전송 할 수 있다.
			//VO 객체의 클래스 이름은 UserVO, ${userCO.id} 뷰페이지에서 출력을 할 수 있다.
		/*
		 * @ModelAtrrtibute : Command 객체로 던져지는 객체 이름을 다른 이름으로 변경
		 * (UserVO => user)		
		 * view 페이지에서 출력시 : ${user.id},${user.pass}
		 * 	
		 * */	
			
			
		}
		//1-2. 로그 인 : login Controller 통합 (POST 방식 처리 메소드)
		@RequestMapping(value="/login.do",method = RequestMethod.POST)
		public String loginViewPost(UserVO vo, UserDAO userDAO,HttpSession session) {
			System.out.println("로그인 처리 - Spring_MVC 어노테이션 호출 Controller 통합");
			
			System.out.println("id : " + vo.getId());
			System.out.println("pass : "+ vo.getPass());
			
			UserVO user = userDAO.getUser(vo);
			
			if(user != null) {
				session.setAttribute("userName", user.getName());
				return "getBoardList.do";
			}else {
				return "login.jsp";
			}
			
			
		}
		/*
		//1-3. 로그 인 : login Controller 통합 
		@RequestMapping(value="/login.do")
		public String login( UserVO vo, UserDAO userDAO) {
			System.out.println("로그인 처리 - Spring_MVC 어노테이션 호출 Controller 통합");
			
			if (userDAO.getUser(vo) != null) {
				return "redirect:getBoardList.do";
			} else {
				return "redirect:login.jsp"; 
			}
			
		}
		*/
		//2. 로그 아웃 : logout Controller 통합
		@RequestMapping(value="/logout.do")
		public String logout(HttpSession session) {
			System.out.println("로그아웃 처리 Spring MVC 어노테이션  Controller 통합");
			
			session.invalidate();
			return "redirect:login.jsp";
		}
}

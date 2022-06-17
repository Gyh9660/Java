package com.springbook.biz.view.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

@Controller
public class LoginController {
	
	@RequestMapping(value="/login.do")
	public String login( UserVO vo, UserDAO userDAO) {
		System.out.println("로그인 처리 - Spring_MVC 어노테이션 호출");
		
		System.out.println("id "+vo.getId());
		System.out.println("pass "+vo.getPass());
		
		
		if (userDAO.getUser(vo) != null) {
			return "redirect:getBoardList.do";
			//redirect : viewResolver 설정을 무시하고 리다이렉트한다
			//redirect : viewResolver의 preix suffix가 적용되지 않도록 한다,
		
			//기본적인 Controller가 View페이지를 통해 던지는 방식은 Forward 방식입니다.
				//클라이언트의 URL이 바뀌지 않는다.
				//ViewResolver가 작동이 된다. prefix, suffix가 적용
			//redirect : 서버에서 전송한 페이지를 client가 재요청
				//클라이언트의 URL이 바뀐다.
				//ViewResolver가 작동이 앋된다.
		} else {
			return "redirect:login.jsp"; 
		}
		
	}

	
}

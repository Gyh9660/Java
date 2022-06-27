package com.tmap.biz.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tmap.biz.user.UserVO;
import com.tmap.biz.user.impl.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	
	//3. 회원 등록 (insert)
			@RequestMapping(value= "/insertUser", method = RequestMethod.GET)
			public String insertView (UserVO vo) {
				return "insertUser";
			}
			
			//회원등록 폼에서 값을 넣고 전송 : DB에저장 <==POST
			@RequestMapping(value = "/insertUser", method =RequestMethod.POST)
			public String insertUser(UserVO vo) {
				
				System.out.println("회원 가입 성공 : - insertUser()메소드 호출 - Mybatis");
				userService.insertUser(vo);
				return "index";
			}
}

package com.springbook.biz.view.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

@Controller
@SessionAttributes("user")

public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value ="/insertUser.do", method = RequestMethod.GET)
	public String userInsertGet(UserVO vo) throws IOException{
		
		
		return "insertUser.jsp";
			
		
	}
	@RequestMapping(value ="/insertUser.do", method = RequestMethod.POST)
	public String insertUser(UserVO vo) throws IOException{
		
		userService.insertUser(vo);
		return "login.jsp";
	}
	
	@RequestMapping(value ="/updateUser.do")
	public String updateUser(@ModelAttribute("user")UserVO vo) {
		userService.updateUser(vo);
		
		return "redirect:getUserList.do";
	}
	
	@RequestMapping(value ="/deleteUser.do")
	public String deleteUser(UserVO vo) {
		userService.deleteUser(vo);
		
		return "redirect:getUserList.do";
	}
	
	@RequestMapping(value ="/getUserList.do")
	public String getUserList(UserVO vo, Model model) {
		
		model.addAttribute("userList",userService.getUserList(vo));
		
		return "getUserList.jsp";
	}
	
	@RequestMapping(value ="/getUser.do")
	public String getUser(UserVO vo, Model model) {
		
		model.addAttribute("user",userService.getUser(vo));
		return "getUser.jsp";
	}
	
	
}

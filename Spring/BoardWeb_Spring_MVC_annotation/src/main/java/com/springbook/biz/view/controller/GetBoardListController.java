package com.springbook.biz.view.controller;

import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class GetBoardListController {

	@RequestMapping(value="/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println("�� ��� �˻� ó�� -- Spring MVC ȣ�� annotation");
		
		mav.addObject("boardList",boardDAO.getBoardList(vo));
		mav.setViewName("getBoardList.jsp"); //Forward�� �̵�
		
		return mav;
		
		
		
	}
}
package com.springbook.biz.view.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.biz.board.impl.BoardDAOSpring;

@Controller
public class InsertBoardController{
	
	@RequestMapping(value="/insertBoard.do") //Ŭ���̾�Ʈ ��û
	/*public void insertBoard(BoardVO vo){
		System.out.println("�� ��� ó��- Spring MVC ������̼� �۵�");
		
		
		BoardDAOSpring boardDAO = new BoardDAOSpring();
		boardDAO.insertBoard(vo);
		

		*/
	public String insertBoard(BoardVO vo,BoardDAO boardDAO){
		System.out.println("�� ��� ó��- Spring MVC ������̼� �۵�");
		
		System.out.println(vo.getTitle());
		System.out.println(vo.getContent());
		System.out.println(vo.getWriter());
		boardDAO.insertBoard(vo);
		
		return "getBoardList.do"; //Forward ������� �� ������ ����
	}

}

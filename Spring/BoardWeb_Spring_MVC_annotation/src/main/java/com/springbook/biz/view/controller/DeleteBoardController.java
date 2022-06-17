package com.springbook.biz.view.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class DeleteBoardController {

	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO){
		System.out.println("�� ���� ó�� Spring MVC ������̼�");
		
		boardDAO.deleteBoard(vo);
		
		return "redirect:getBoardList.do"; 
		//redirect�� �̵�, ������ �⺻���� Forward http://localhost:8383/biz/getBoardList.do���̵�
		//return "getBoardList.do"; 
		//Forward�� �̵�http://localhost:8383/biz/deleteBoard.do?seq=4�� �̵�
		//String �϶��� �׳� return ���� String���� �̵��� �ּ� �����Է�
	}

}

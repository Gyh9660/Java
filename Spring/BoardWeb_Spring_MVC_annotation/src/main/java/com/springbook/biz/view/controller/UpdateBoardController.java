package com.springbook.biz.view.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class UpdateBoardController {

	@RequestMapping(value ="/updateBoard.do")
	public String updateBoadr(BoardVO vo, BoardDAO boardDAO){
		System.out.println("글 수정 처리 Spring MVC 어노테이션");
		
		System.out.println(vo.getTitle());
		System.out.println(vo.getContent());
		System.out.println(vo.getSeq());
		
		boardDAO.updateBoard(vo);
		
		return "redirect:getBoardList.do";
		

	}
}
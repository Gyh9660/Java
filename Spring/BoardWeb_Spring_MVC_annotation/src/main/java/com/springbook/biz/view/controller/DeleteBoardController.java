package com.springbook.biz.view.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class DeleteBoardController {

	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO){
		System.out.println("글 삭제 처리 Spring MVC 어노테이션");
		
		boardDAO.deleteBoard(vo);
		
		return "redirect:getBoardList.do"; 
		//redirect로 이동, 없으면 기본값은 Forward http://localhost:8383/biz/getBoardList.do로이동
		//return "getBoardList.do"; 
		//Forward로 이동http://localhost:8383/biz/deleteBoard.do?seq=4로 이동
		//String 일때는 그냥 return 으로 String으로 이동할 주소 직접입력
	}

}

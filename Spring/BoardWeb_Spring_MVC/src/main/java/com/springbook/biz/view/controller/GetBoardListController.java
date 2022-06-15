package com.springbook.biz.view.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

public class GetBoardListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("�� ��� �˻� ó��");
		// 1. ����� �Է� ���� ����(�˻� ����� ���߿� ����)
		// 2. DB ���� ó��
		BoardVO vo = new BoardVO();
		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		// 3. �˻� ����� ���ǿ� �����ϰ� ��� ȭ���� �����Ѵ�.
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		session.setAttribute("boardList", boardList);
		mav.setViewName("getBoardList");
			//redirect : viewResolver������ �����ϰ� ������ �����̷�Ʈ
			//forward�� �������� ����, viewResolver�� �۵���, prefix+ getBoardList + suffis
		
		return mav;
	}
}
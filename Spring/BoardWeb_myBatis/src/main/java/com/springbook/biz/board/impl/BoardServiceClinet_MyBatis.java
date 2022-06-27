package com.springbook.biz.board.impl;

import java.sql.SQLException;
import java.util.List;

import com.springbook.biz.board.BoardVO;

public class BoardServiceClinet_MyBatis {
	
	public static void main(String[] args) throws SQLException{	
	 
	BoardDAOMyBatis boardDAO = new BoardDAOMyBatis();
		
	BoardVO vo = new BoardVO();

	vo.setTitle("myBatis ����");
	vo.setWriter("ȫ�浿");
	vo.setContent("myBatis ���� �Դϴ�.");
	
	boardDAO.insertBoard(vo);
	
	// null�� �Ѿ�� �ʵ��� ���� (�⺻����)
	vo.setSearchCondition("TITLE");
	vo.setSearchKeyword("");
	
	List<BoardVO> boardList = boardDAO.getBoardList(vo);
	for (BoardVO board : boardList) {
		System.out.println("---->"+board.toString());
	}
	
	}
	
}
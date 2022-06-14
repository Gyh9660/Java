package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 7a6b14bb83f22218a13c7a0564af8bc7b4fb36c6

@Service("boardService")
public class BoardServiceImpl implements BoardService {


	@Autowired					//타입으로 객체 주입
	private BoardDAO boardDAO;
				//MVC M1, M2, MVC_Pramework 의 View
	//@Autowired
	//private BoardDAOSpring boardDAO;  //Spring 의 BoardDAO
	//private BoardDAOJPA boardDAO;
	//private BoardDAO boardDAO;



	@Override
<<<<<<< HEAD
=======
=======
@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	
	@Autowired //타입으로 객체 주입
	private BoardDAO boardDAO;		//MVC M1,M2,MVC_Freamwork의 View
	//private BoardDAOSpring boardDAO; //Spring의 BoardDAO 
	//private BoardDAOJPA boardDAO;
	//private BoardDAO boardDAO;
	
	
>>>>>>> 9e0d4adb58faea260cdc14d29e5db0017df7b0c2
>>>>>>> 7a6b14bb83f22218a13c7a0564af8bc7b4fb36c6
	public void insertBoard(BoardVO vo) {
		boardDAO.insertBoard(vo);
	}

<<<<<<< HEAD
	@Override
=======
<<<<<<< HEAD
	@Override
=======
>>>>>>> 9e0d4adb58faea260cdc14d29e5db0017df7b0c2
>>>>>>> 7a6b14bb83f22218a13c7a0564af8bc7b4fb36c6
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

<<<<<<< HEAD
	@Override
=======
<<<<<<< HEAD
	@Override
=======
>>>>>>> 9e0d4adb58faea260cdc14d29e5db0017df7b0c2
>>>>>>> 7a6b14bb83f22218a13c7a0564af8bc7b4fb36c6
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}

<<<<<<< HEAD
	@Override
=======
<<<<<<< HEAD
	@Override
=======
>>>>>>> 9e0d4adb58faea260cdc14d29e5db0017df7b0c2
>>>>>>> 7a6b14bb83f22218a13c7a0564af8bc7b4fb36c6
	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}

<<<<<<< HEAD
	@Override
=======
<<<<<<< HEAD
	@Override
=======
>>>>>>> 9e0d4adb58faea260cdc14d29e5db0017df7b0c2
>>>>>>> 7a6b14bb83f22218a13c7a0564af8bc7b4fb36c6
	public List<BoardVO> getBoardList(BoardVO vo) {
		return boardDAO.getBoardList(vo);
	}
}
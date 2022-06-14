package com.springbook.biz.board.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
import com.springbook.biz.board.BoardVO_;
=======
<<<<<<< HEAD
import com.springbook.biz.board.BoardVO_;
=======
import com.springbook.biz.board.BoardVO;
>>>>>>> 9e0d4adb58faea260cdc14d29e5db0017df7b0c2
>>>>>>> 7a6b14bb83f22218a13c7a0564af8bc7b4fb36c6

//@Repository
public class BoardDAOMybatis{
	
	@Autowired
	private SqlSessionTemplate mybatis;

<<<<<<< HEAD
	public void insertBoard(BoardVO_ vo) {
=======
<<<<<<< HEAD
	public void insertBoard(BoardVO_ vo) {
=======
	public void insertBoard(BoardVO vo) {
>>>>>>> 9e0d4adb58faea260cdc14d29e5db0017df7b0c2
>>>>>>> 7a6b14bb83f22218a13c7a0564af8bc7b4fb36c6
		System.out.println("===> Mybatis로 insertBoard() 기능 처리");
		mybatis.insert("BoardDAO.insertBoard", vo);
	}

<<<<<<< HEAD
	public void updateBoard(BoardVO_ vo) {
=======
<<<<<<< HEAD
	public void updateBoard(BoardVO_ vo) {
=======
	public void updateBoard(BoardVO vo) {
>>>>>>> 9e0d4adb58faea260cdc14d29e5db0017df7b0c2
>>>>>>> 7a6b14bb83f22218a13c7a0564af8bc7b4fb36c6
		System.out.println("===> Mybatis로 updateBoard() 기능 처리");
		mybatis.update("BoardDAO.updateBoard", vo);
	}

<<<<<<< HEAD
	public void deleteBoard(BoardVO_ vo) {
=======
<<<<<<< HEAD
	public void deleteBoard(BoardVO_ vo) {
=======
	public void deleteBoard(BoardVO vo) {
>>>>>>> 9e0d4adb58faea260cdc14d29e5db0017df7b0c2
>>>>>>> 7a6b14bb83f22218a13c7a0564af8bc7b4fb36c6
		System.out.println("===> Mybatis로 deleteBoard() 기능 처리");
		mybatis.delete("BoardDAO.deleteBoard", vo);
	}

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 7a6b14bb83f22218a13c7a0564af8bc7b4fb36c6
	public BoardVO_ getBoard(BoardVO_ vo) {
		System.out.println("===> Mybatis로 getBoard() 기능 처리");
		return (BoardVO_) mybatis.selectOne("BoardDAO.getBoard", vo);
	}

	public List<BoardVO_> getBoardList(BoardVO_ vo) {
<<<<<<< HEAD
=======
=======
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Mybatis로 getBoard() 기능 처리");
		return (BoardVO) mybatis.selectOne("BoardDAO.getBoard", vo);
	}

	public List<BoardVO> getBoardList(BoardVO vo) {
>>>>>>> 9e0d4adb58faea260cdc14d29e5db0017df7b0c2
>>>>>>> 7a6b14bb83f22218a13c7a0564af8bc7b4fb36c6
		System.out.println("===> Mybatis로 getBoardList() 기능 처리");
		return mybatis.selectList("BoardDAO.getBoardList", vo);
	}
}
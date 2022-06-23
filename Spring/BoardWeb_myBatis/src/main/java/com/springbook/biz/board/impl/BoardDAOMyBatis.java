package com.springbook.biz.board.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.util.sqlSessionFactoryBean;

public class BoardDAOMyBatis {

	private SqlSession mybatis;
	
	public BoardDAOMyBatis() { //기본 생성자
		mybatis = sqlSessionFactoryBean.getSqlSessionInstance();
		
	}
	public void insertBoard(BoardVO vo) {
		System.out.println("mybatis를 사용해서 insertboard()메소드 호출");
		System.out.println(vo.getTitle());
		System.out.println(vo.getContent());
		System.out.println(vo.getWriter());
		mybatis.insert("BoardDAO.insertBoard",vo);
		mybatis.commit();
	}
	public void updateBoard(BoardVO vo) {
		mybatis.update("BoardDAO.updateBoard",vo);
		mybatis.commit();
	}
	public void deleteBoard(BoardVO vo) {
		mybatis.delete("boardDAO.deleteBoard",vo);
		mybatis.commit();
	}
	public BoardVO getBoard(BoardVO vo) {
		return (BoardVO) mybatis.selectOne("BoardDAO.getBoard",vo);
	}
	public List<BoardVO> getBoardList(BoardVO vo){
		return mybatis.selectList("BoardDAO.getBoard",vo);
	}
	
}

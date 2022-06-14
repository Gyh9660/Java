package com.springbook.biz.board.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 7a6b14bb83f22218a13c7a0564af8bc7b4fb36c6
import com.springbook.biz.board.BoardVO;

public class BoardRowMapper implements RowMapper<BoardVO> {
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO board = new BoardVO();
<<<<<<< HEAD
=======
=======
import com.springbook.biz.board.BoardVO_;

public class BoardRowMapper implements RowMapper<BoardVO_> {
	public BoardVO_ mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO_ board = new BoardVO_();
>>>>>>> 9e0d4adb58faea260cdc14d29e5db0017df7b0c2
>>>>>>> 7a6b14bb83f22218a13c7a0564af8bc7b4fb36c6
		board.setSeq(rs.getInt("SEQ"));
		board.setTitle(rs.getString("TITLE"));
		board.setWriter(rs.getString("WRITER"));
		board.setContent(rs.getString("CONTENT"));
<<<<<<< HEAD
		board.setRegdate(rs.getDate("REGDATE")); 
=======
<<<<<<< HEAD
		board.setRegdate(rs.getDate("REGDATE")); 
=======
		board.setRegDate(rs.getDate("REGDATE"));
>>>>>>> 9e0d4adb58faea260cdc14d29e5db0017df7b0c2
>>>>>>> 7a6b14bb83f22218a13c7a0564af8bc7b4fb36c6
		board.setCnt(rs.getInt("CNT"));
		return board;
	}
}
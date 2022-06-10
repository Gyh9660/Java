package com.springbook.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springbook.biz.BoardVO;

@Repository("boardDAOSpring")
public class BoardDAOSpring {
	
	
	//Spring에서는 Connection객체, statement, preparedStatement, ResuletSet
		//선언 x , 사용 x , 대신 jdbcTemplate를 사용해서 처리
	
	//JDBCTemplate을 사용하면 코드가 간단하고 깔끔해 진다.
	
	//insert,update,delete
	//jdbcTemplate.update( sql구문 ,?,?,?)
	
	//select
		//1. 단일 레코드 출력 (상세내용)
			//jdbcTemplate.queryForObject(sql 구문, ?, ?, new RowMapper인터페이스를 구현한 객체로 전달())
		//2. 여러개의 레코드 출력 (리스트)
			//jdbcTemplate.query(sql 구문, ?, ?, new RowMapper인터페이스를 구현한 객체로 전달)
	


	@Autowired			//jdbcTemplate 객체 활성화
	private JdbcTemplate jdbcTemplate;
	
	//2. SQL 쿼리 정의 (상수로 선언)
		private final String BOARD_INSERT = "insert into board (seq,title,writer,content) "
				+ " values ((select nvl(max(seq), 0)+1 from board) ,? ,? ,? )";
		
		//*트랜잭션 작동 실습시 임시로 구현
		//private final String BOARD_INSERT = "insert into board (seq,title,writer,content) "
		//			+ " values (? ,? ,? ,? )";
		//////////////////////////////////////////////	
		private final String BOARD_UPDATE = "update board set title = ? , content = ?"
				+ " where seq = ?";
		
		private final String BOARD_DELETE = "delete board where seq = ?";
		
		private final String BOARD_GET = "select * from board where seq = ? ";
		
		private final String BOARD_LIST = "select * from board order by seq desc";
	
	//3. CRUD 기능 구현
		//1. 글 작성
			public void insertBoard(BoardVO vo) {
				System.out.println("===> Spring JDBC로 insertBoard() 기능처리");
				//jdbcTemplate.update(BOARD_INSERT,vo.getTitle(),vo.getWriter(),vo.getContent());
				Object[] args = {vo.getSeq(),vo.getTitle(),vo.getWriter(),vo.getContent()};
				jdbcTemplate.update(BOARD_INSERT,args);
			}
			
		//2. 글수정
			public void updateBoard(BoardVO vo) {
				System.out.println("===>Spring JDBC로 updateBoard() 기능처리");
				jdbcTemplate.update(BOARD_UPDATE,vo.getTitle(),vo.getContent(),vo.getSeq());
			}
			
		//3. 글삭제
			public void deleteBoard(BoardVO vo) {
				System.out.println("===>Spring JDBC로 deleteBoard() 기능처리");
				jdbcTemplate.update(BOARD_DELETE,vo.getSeq());
			}
		//4. 글 상세 조회
			public BoardVO getBoard(BoardVO vo) {
				System.out.println("===>Spring JDBC로 getBoard() 기능처리");
				Object[] args = {vo.getSeq()};
				return jdbcTemplate.queryForObject(BOARD_GET, args,new BoardRowMapper());
				
			}
			
		//5. 글 목록 조회
			public List<BoardVO> getBoardList(BoardVO vo){
				System.out.println("===> Spring JDBC로 getBoardList() 기능 처리"); 
				return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
			}
}

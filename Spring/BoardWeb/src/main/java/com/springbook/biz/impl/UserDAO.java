package com.springbook.biz.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.springbook.biz.common.JDBCUtil;
import com.springbook.biz.user.UserVO;

@Repository("userDAO")	//UserDAO 클래스를 객체화해서 userDAO
public class UserDAO {
	
	//1. JDBC 관련 변수 선언 (conn, pstmt, rs)
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	
	//2. SQL 상수 구문 적용
	private final String USER_GET = "select * from users where id = ? and pass = ? ";
	private final String USER_INSERT = "insert into users(id,pass,name,role) values(?,?,?,?)";
	
	
	//3. CRUD 기능의 메소드 구현
		//회원 정보 검색 (ID와 Password를 매개변수로 받아서 처리 )
	public UserVO getUser(UserVO vo) {
		UserVO user = null; // user : DB에서 select해온 값을 리턴
		
		try {
			System.out.println("===> JDBC로 getUser() 기능처리");
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(USER_GET);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPass());
			rs = pstmt.executeQuery(); //sql을 실행한결과를 rs에담습니다.
				//rs의 값이 조재하면 DB의 vo로 넘어오는 id와 password가 db에 존재한다.
			
			//rs의 값이 존재 할때 user(VO)에 저장해서 리턴 해서 값을 돌려 준다.
			if(rs.next()) { //id와 password가 일치 할때 rs.next가 true다
				user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setPass(rs.getString("PASS"));
				user.setName(rs.getString("NAME"));
				user.setRole(rs.getString("ROLE"));
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		
		return user;
	}
	//insert
	public void insertUser(UserVO vo) {
		System.out.println("===> JDBC로 insertUser() 기능처리");
		
		try {
			conn = JDBCUtil.getConnection(); //Connection객체 호출
			pstmt = conn.prepareStatement(USER_INSERT);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPass());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getRole());
			pstmt.executeUpdate();
			
			System.out.println("insert 성공");
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
	}
}

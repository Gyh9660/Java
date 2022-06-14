package com.springbook.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.springbook.biz.common.JDBCUtil;
import com.springbook.biz.user.UserVO;

// DAO(Data Access Object)
@Repository("userDAO")
public class UserDAO {
	// JDBC 관련 변수
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	// SQL 명령어들
<<<<<<< HEAD
	private final String USER_GET = "select * from users where id=? and pass=?";
=======
<<<<<<< HEAD
	private final String USER_GET = "select * from users where id=? and pass=?";
=======
	private final String USER_GET = "select * from users where id=? and password=?";
>>>>>>> 9e0d4adb58faea260cdc14d29e5db0017df7b0c2
>>>>>>> 7a6b14bb83f22218a13c7a0564af8bc7b4fb36c6

	// CRUD 기능의 메소드 구현
	// 회원 등록
	public UserVO getUser(UserVO vo) {
		UserVO user = null;
		try {
			System.out.println("===> JDBC로 getUser() 기능 처리");
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_GET);
			stmt.setString(1, vo.getId());
<<<<<<< HEAD
			stmt.setString(2, vo.getPass());
=======
<<<<<<< HEAD
			stmt.setString(2, vo.getPass());
=======
			stmt.setString(2, vo.getPassword());
>>>>>>> 9e0d4adb58faea260cdc14d29e5db0017df7b0c2
>>>>>>> 7a6b14bb83f22218a13c7a0564af8bc7b4fb36c6
			rs = stmt.executeQuery();
			if (rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("ID"));
<<<<<<< HEAD
				user.setPass(rs.getString("PASS"));
=======
<<<<<<< HEAD
				user.setPass(rs.getString("PASS"));
=======
				user.setPassword(rs.getString("PASSWORD"));
>>>>>>> 9e0d4adb58faea260cdc14d29e5db0017df7b0c2
>>>>>>> 7a6b14bb83f22218a13c7a0564af8bc7b4fb36c6
				user.setName(rs.getString("NAME"));
				user.setRole(rs.getString("ROLE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return user;
	}
}
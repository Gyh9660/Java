package com.springbook.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springbook.biz.user.UserVO;

@Repository("userDAOSpring")
public class UserDAOSpring {

		
		@Autowired
		private JdbcTemplate jdbcTemplate;
		
		//2. SQL 상수 구문 적용
		private final String USER_GET = "select * from users where id = ? and pass = ? ";
		private final String USER_INSERT = "insert into users(id,pass,name,role) values(?,?,?,?)";

		
		//유저 정보 출력
		
		public UserVO getUser(UserVO vo) {
			System.out.println("===> Spring JDBC로 getUser() 기능처리");
			Object[] args = {vo.getId(),vo.getPass()};
			
			return jdbcTemplate.queryForObject(USER_GET, args, new UserRowMapper());
		}
		
		
		//유저 등록
		
		public void insertUser(UserVO vo) {
			System.out.println("===> Spring JDBC로 insertUser() 기능처리");
			jdbcTemplate.update(USER_INSERT,vo.getId(),vo.getPass(),vo.getName(),vo.getRole());
			
		}
		
		
}

package com.springbook.biz.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springbook.biz.user.UserVO;

@Repository
public class UserDAOJDBC {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final String USER_GET = "select * from users where id= ?";
	private final String USER_LIST = "select * from users order by id desc";
	private final String USER_INSERT = "insert into users(id, pass, name,role) values (?,?,?,?) ";
	private final String USER_UPDATE = "update users set pass =? ,name = ?, role =? where id=?";
	private final String USER_DELETE = "delete users where id = ?";
	

	public void insertUser(UserVO vo) {
		Object[] args = {vo.getId(), vo.getPass(), vo.getName(),vo.getRole()};
		jdbcTemplate.update(USER_INSERT,args);
				
		}

	public void updateUser(UserVO vo) {
		Object[] args = {vo.getPass(), vo.getName(), vo.getRole(),vo.getId()};
		jdbcTemplate.update(USER_UPDATE,args);
	}
	
	public void deleteUser(UserVO vo) {
		jdbcTemplate.update(USER_DELETE, vo.getId());
	}

	public UserVO getUser(UserVO vo) {
		Object[] args = {vo.getId()};
		return jdbcTemplate.queryForObject(USER_GET, args,new UserRowMapper());
			
	}
	
	public List<UserVO> getUserList(UserVO vo){
		return jdbcTemplate.query(USER_LIST, new UserRowMapper());
	}
	
	
}

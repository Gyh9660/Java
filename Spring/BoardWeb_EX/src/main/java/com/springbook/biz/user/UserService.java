package com.springbook.biz.user;

import java.util.List;


public interface UserService {
	// CRUD 기능의 메소드 구현
	// 회원 등록
	UserVO getUser(UserVO vo);
	
	List<UserVO> getUserList(UserVO vo);
	
	void insertUser(UserVO vo);

	void updateUser(UserVO vo);

	void deleteUser(UserVO vo);
}

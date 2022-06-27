package com.springbook.biz.user;

import java.util.List;


public interface UserService {
	// CRUD ����� �޼ҵ� ����
	// ȸ�� ���
	UserVO getUser(UserVO vo);
	
	List<UserVO> getUserList(UserVO vo);
	
	void insertUser(UserVO vo);

	void updateUser(UserVO vo);

	void deleteUser(UserVO vo);
}
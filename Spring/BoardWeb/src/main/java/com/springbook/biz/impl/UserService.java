package com.springbook.biz.impl;

import com.springbook.biz.user.UserVO;

public interface UserService {

	//3. CRUD 기능의 메소드 구현
	//회원 정보 검색 (ID와 Password를 매개변수로 받아서 처리 )
	UserVO getUser(UserVO vo);

	//3-2
	void insertUser(UserVO vo);
}
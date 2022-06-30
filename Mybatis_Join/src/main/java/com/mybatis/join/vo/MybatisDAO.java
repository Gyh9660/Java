package com.mybatis.join.vo;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<JoinVO> selectListJoin (JoinVO vo){
		System.out.println("selectListJoin() 메소드 호출");
		return mybatis.selectList("Join.selectListJoin",vo);
	}
	
	public List<End_VO> selectListJoin2 (End_VO vo){
		System.out.println("selectListJoin2() 메소드 호출");
		return mybatis.selectList("Join.selectListJoin2",vo);
	}
	
	public List<AllJoinVO> selectListJoin3 (AllJoinVO vo){
		System.out.println("selectListJoin3() 메소드 호출");
		return mybatis.selectList("Join.selectListJoin3",vo);
	}

	public List<JoinVO2> selectListJoin4 (JoinVO2 vo){
		System.out.println("selectListJoin() 메소드 호출");
		return mybatis.selectList("Join.selectListJoin4",vo);
	}
	
	
}

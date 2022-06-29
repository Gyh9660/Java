package com.mybatis.join.vo;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@Component
public class DepartmentVO {
	private int dno;
	private String dname;
	private String loc;
	
	
}

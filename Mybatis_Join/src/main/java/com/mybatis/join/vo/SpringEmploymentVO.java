package com.mybatis.join.vo;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Component
public class SpringEmploymentVO {

	private int empno;
	private String ename;
	private int sal;
	private int deptno;
	
}

package com.mybatis.join.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class SpringJoinVO {

	private SpringDepartmentVO sdept;
	private SpringEmploymentVO semp;
	
}

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
public class DeptsVO {
	
	 private int department_id;
	 private String department_name;
	 private int manager_id;
	 private int location_id;

	
}

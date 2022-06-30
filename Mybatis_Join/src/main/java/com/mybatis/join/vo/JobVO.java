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
public class JobVO {

	 private int employee_id;
	 private String start_date;
	 private String end_date;
	 private String job_id;
	 private int department_id;
}

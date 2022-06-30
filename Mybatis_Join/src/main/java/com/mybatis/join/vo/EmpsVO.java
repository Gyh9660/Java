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
public class EmpsVO {

	 private int employee_id;
	 private String first_name;
	 private String last_name;
	 private String email;
	 private String phone_number;
	 private String hire_date;
	 private String job_id;
	 private int salary;
	 private int commission_pct;
	 private int manager_id;
	 private int department_id;

	
}

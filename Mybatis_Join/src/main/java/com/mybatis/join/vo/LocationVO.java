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
public class LocationVO {

	 private int location_id;
	 private String street_address;
	 private String postal_code;
	 private String city;
	 private String state_province;
	 private String country_id;
	
}

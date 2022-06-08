package com.springbook.biz.user;

public class UserVO {
	private String id;
	private String pass;
	private String name;
	private String role;
	
	//getter, setter 생성
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() { //UserVO 객체의 RAM에 로드된 값을 출력
		
		return "UserVO [id ="+id+", pass ="+pass+", name ="+name+", role ="+role+"]";
	}
	
}

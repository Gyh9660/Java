package com.springbook.biz.user;

//VO(Value Object)
public class UserVO {
	private String id;
<<<<<<< HEAD
	private String pass;
=======
	private String password;
>>>>>>> 9e0d4adb58faea260cdc14d29e5db0017df7b0c2
	private String name;
	private String role;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

<<<<<<< HEAD
	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
=======
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
>>>>>>> 9e0d4adb58faea260cdc14d29e5db0017df7b0c2
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
	public String toString() {
<<<<<<< HEAD
		return "UserVO [id=" + id + ", pass=" + pass + ", name=" + name + ", role=" + role + "]";
=======
		return "UserVO [id=" + id + ", password=" + password + ", name=" + name + ", role=" + role + "]";
>>>>>>> 9e0d4adb58faea260cdc14d29e5db0017df7b0c2
	}
}
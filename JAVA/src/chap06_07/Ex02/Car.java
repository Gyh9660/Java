package chap06_07.Ex02;

public class Car {

	String company;
	String model;
	String color;
	int maxSpeed;
	
	public String getCompany() { 
		return company;			
	}	 
	public void setCompany(String company) {//setter는 RAM(메모리) 의 값을 부여할때
		this.company = company;//this : 자신의 객체
	}//메소드에 인풋되는 변수명, 인풋되는 변수를 받는 변수명,메모리에 로드할 변수명이 같을때 (this.메모리에 로드할 변수명)
	public String getModel() {
		return model;
	}
	public void setModel(String mo) { // 세개의 변수명이 동일하지 않을때 (인풋,인풋을 받는 변수. 메모리에 로드할변수) this. 생략가능
		model = mo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
}

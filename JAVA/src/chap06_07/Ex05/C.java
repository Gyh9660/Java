package chap06_07.Ex05;

public class C { // 다른 패키지에서 import 가능 (public 이 붙어있기 떄문에)
	
	//필드에 부여 되는 접근 제어자
	private String company = "현대자동차"; //회사명
	String model; //모델, default
	protected String color; //색
	public int maxSpeed; //최대속도

	
	
	public String getCompany() {
		return company;
	}



	public void setCompany(String company) {
		this.company = company;
	}



	public String getModel() {
		return model;
	}



	public void setModel(String model) {
		this.model = model;
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



	public void print() {
		System.out.println("company : " + company + "model : " + model + "color : " + color + "maxSpeed : " + maxSpeed);

	}

}

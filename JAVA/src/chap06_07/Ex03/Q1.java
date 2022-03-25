package chap06_07.Ex03;

class Car {
	String company;
	String model;
	String color;
	double maxSpeed;
	Car () {}
	Car (String company, String model, String color, double maxSpeed){
		this.company = company;
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
	void work() {
		System.out.println("company : "+ company);
		System.out.println("model : "+ model);
		System.out.println("color : "+ color);
		System.out.println("maxSpead : "+ maxSpeed);
	}
}


public class Q1 {

	public static void main(String[] args) {
		//생성자를 통해서 기본 값을 할당후 메모리의 내용을 work()메소드를 사용해서 출력
		Car a = new Car();
		a.work();
		System.out.println("================");
		Car aa = new Car("현대","소나타","흰색",200);
		aa.work();
		
		
		
		
	}

}

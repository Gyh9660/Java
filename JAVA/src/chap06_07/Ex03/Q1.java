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
		//�����ڸ� ���ؼ� �⺻ ���� �Ҵ��� �޸��� ������ work()�޼ҵ带 ����ؼ� ���
		Car a = new Car();
		a.work();
		System.out.println("================");
		Car aa = new Car("����","�ҳ�Ÿ","���",200);
		aa.work();
		
		
		
		
	}

}

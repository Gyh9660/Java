package chap06_07.Ex03;

class Car2{
	String company; //�ʵ�(�ν��Ͻ� �ʵ�)�� company�� �˷��ִ� this, Heap �޸𸮿� ����
	String model; //�ν��Ͻ� : ��üȭ�� ������ ��� ������ �ʵ�
	String color; //[�ʵ��� �ʵ��� ��]�� Heap������ ����
	double maxSpeed;
	Car2 () {} // �⺻ ������
	Car2 ( String company, String model, String color, double max){
		this.company =company; //this Ű�� ��ü�� �ʵ��� ������ ����
		this.model = model; //this : 3���� ���� ��ΰ� ������ ��� ��ü�� �ʵ��� ������ �˷��ִ� ����
		this.color = color;
		this.maxSpeed = max; // this Ű���尡 ������ ����
		
	}
	void work() { //�޼ҵ�(�ν��Ͻ� �޼ҵ�) :Heap ������ �޼ҵ��� �����͸� �����ϰ��ִ�.
		System.out.println(company); // �޼ҵ��� ��ü������ Ŭ���� ������ �޼ҵ� ������ ����                                                                                                                        
		System.out.println(model); //�ν��Ͻ� �޼ҵ�� ��üȭ�������� ��밡��
		System.out.println(color);
		System.out.println(maxSpeed);
	}
	
	
}
public class Q1_01 {

	public static void main(String[] args) {

		Car2 car = new Car2();
		car.work();
		
		Car2 car2 = new Car2("����", "�׷���","����",234.0);
		car2.work();
		
	}

}

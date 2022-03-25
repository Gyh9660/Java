package chap11.Ex06;

abstract class Animal2{ //�߻� Ŭ���� : �߻� �޼ҵ尡 �ϳ��̻� ���ԵǾ��ִ� ���
	//�߻� Ŭ������ ��ü ���� �Ұ�, Ÿ���� ��� ����
	//�ڽ�Ŭ������ �θ� Ŭ������ �޼ҵ带 ������ ������ ����
	//�߻� Ŭ������ �߻� Ŭ���� ���� �߻�޼ҵ带 �ڽ� Ŭ�������� �ݵ�� �����ϵ��� ����޴´�
String name;
int age;

abstract void cry(); //�߻� �޼ҵ� : �����ΰ� ���� �޼ҵ�
//void cry() {} <==�ϴ� �޼ҵ� : ����Ÿ�� �޼ҵ��̸� (�Է¸Ű�����) {�����ڵ�}
abstract void run();

	@Override
		public String toString() { //��ü ��ü�� ��½� �޸��� ������ ���
			return "�̸� : " + name + " , ���� :" + age;
		}
}
class Cat2 extends Animal2{ //Cat�� Animal ��� (�Ϻθ� ����� ���)
							//��� �߻� �޼ҵ带 ������ ���� ��ũ��Ʈ Ŭ������ �ȴ�.
	Cat2(String name, int age){
		super.name = name;
		super.age = age;
	}
	@Override
	void cry() { //�߻� �޼ҵ带 ������ �޼ҵ�
		System.out.println("�߿�");
	}
	
	@Override
	void run() {
		System.out.println("����̴� �����ϰ� �ݴϴ�.");
	}
	
}

class Tiger2 extends Animal2{

	Tiger2(String name, int age){
		super.name = name;
		super.age = age;
	}
	@Override
	void cry() {
		System.out.println("����");
	}

	@Override
	void run() {
		System.out.println("ȣ���̴� ������ �޸��ϴ�.");
	}
	
}

class Eagle2 extends Animal2{

	Eagle2(String name, int age){
		super.name = name;
		super.age = age;
	}
	@Override
	void cry() {
		System.out.println("���� �ϰ� ��ϴ�.");
	}

	@Override
	void run() {
		System.out.println("�������� ���ϴ�");
	}
	
}
public class Ex {

	public static void main(String[] args) {
		
		
		Animal2 a1 = new Cat2("�����",10);
		Animal2 a2 = new Tiger2("ȣ����",5);
		Animal2 a3 = new Eagle2("������",15);

		//1. Animal2 �迭 ��ü�� ����
		Animal2[] arr1 = {a1,a2,a3};
		
		//2. For ���� ����ؼ� ��ü�� ��½� �̸��� ���̸� ���, cry�� run�޼ҵ� ���
		for (int i=0; i<arr1.length; i++) {
			System.out.println(arr1[i]); //��ü ��� ,Animal2�� toString() ���
			arr1[i].cry(); //��ü�� �������̵��� �޼ҵ����
			arr1[i].run(); //Animal�� cry(), run() ���==>�������̵� (�ڽ��� cry�� runȣ��)
			System.out.println("===================");
		}
			System.out.println();
			System.out.println();
		
		//3. Enhanced For ���� ����ؼ� �̸��� ���̸� ���, cry() , run()
		for( Animal2 k : arr1) {
			System.out.println(k);
			k.cry();
			k.run();
			System.out.println("=====================");
		}
	}

}

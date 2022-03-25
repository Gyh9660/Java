package chap11.Ex06;

abstract class Animal{ //�߻� Ŭ���� : �߻� �޼ҵ尡 �ϳ��̻� ���ԵǾ��ִ� ���
						//�߻� Ŭ������ ��ü ���� �Ұ�, Ÿ���� ��� ����
						//�ڽ� Ŭ������ �θ� Ŭ������ �޼ҵ带 ������ ������ ����
						//�߻� Ŭ������ �߻� Ŭ���� ���� �߻�޼ҵ带 �ڽ� Ŭ�������� �ݵ�� �����ϵ��� ����޴´�
	String name;
	int age;
	
	abstract void cry(); //�߻� �޼ҵ� : �����ΰ� ���� �޼ҵ�
		//void cry() {} <==�ϴ� �޼ҵ� : ����Ÿ�� �޼ҵ��̸� (�Է¸Ű�����) {�����ڵ�}
	abstract void run();
	/*@Override  �̰� ������.. (��ü ��ü�� ��½� �޸��� ������ ���)
		public String toString() {
			return "�̸� :" + name + "���� : " + age;
		}*/ 
}
class Cat extends Animal{	//Cat�� Animal ��� (�Ϻθ� ����� ���)
	//��� �߻� �޼ҵ带 ������ ���� ��ũ��Ʈ Ŭ������ �ȴ�.
	Cat(String name, int age){
		this.name = name;
		this.age = age;
	}
	void cry() {	//�߻� �޼ҵ带 ������ �޼ҵ�
		System.out.println("�߿�");
	}
	void run() {
		System.out.println("����̴� �׹߷� �޸��ϴ�.");
	}
}
class Tiger extends Animal{
	Tiger(String name, int age){
		this.name = name;
		this.age = age;
	}
	void cry() {
		System.out.println("����");
	}
	void run() {
		System.out.println("ȣ���̴� �׹߷� �޸��ϴ�.");
	}
}
class Eagle extends Animal{
	Eagle(String name, int age){
		this.name = name;
		this.age = age;
	}
	void cry() {
		System.out.println("����");
	}
	void run() {
		System.out.println("�������� ������ ���ϴ�.");
	}
}

public class AbstractModifier_4 {

	public static void main(String[] args) {

		Animal a1 = new Cat("�����",10);
		Animal a2 = new Tiger("ȣ����",5);
		Animal a3 = new Eagle("������",15);

		//1. Animal �迭 ��ü�� ����
		Animal[] arr1 = {a1,a2,a3};
		
		//2. For ���� ����ؼ� ��ü�� ��½� �̸��� ���̸� ���, cry�� run�޼ҵ� ���
		//System.out.println(arr1[0]); toString �������̵� ������
		for(int i=0; i<arr1.length; i++){
			System.out.println("�̸� : "+arr1[i].name+", ���� : "+ arr1[i].age);
			arr1[i].cry();
			arr1[i].run();
			System.out.println();	
		}
		
		//3. Enhanced For ���� ����ؼ� �̸��� ���̸� ���, cry() , run()
		System.out.println("=============================");
		for(Animal k : arr1) {
			System.out.println("�̸� : "+k.name+", ���� : "+ k.age);
			//System.out.println(k); toString �������̵� ������
			k.cry();
			k.run();
			System.out.println();
		}
		
	}

}

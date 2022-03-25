package chap11.Ex05;

//�߻� Ŭ������ ����ؼ� ��� ���� �ϴ� ���
abstract class Animal{	//�߻� Ŭ���� : �߻�޼ҵ尡 �ϳ��̻� ���ԵǾ��ִ� Ŭ����
	abstract void cry(); //�߻� �޼ҵ� : ���� �Ǿ��ְ� ������ ���� �޼ҵ�
}

class Cat extends Animal{
	@Override
	void cry() {
		System.out.println("�߿�");
	}
}

class Dog extends Animal{
	@Override
	void cry() {
		System.out.println("�۸�");
	}
}

public class AbstractModifier_3 {

	public static void main(String[] args) {

		Animal a1 = new Cat(); // �߻�Ŭ������ Ÿ�����δ� �����ɼ��ִ�.
		Animal a2 = new Dog();
		
		a1.cry();
		a2.cry();
		
		//�߻� Ŭ������ ��äȭ �� �� ����.
		
		//Animal a3 = new Animal(); //�߻� Ŭ������ ��üȭ �� �� ����.
	}

}

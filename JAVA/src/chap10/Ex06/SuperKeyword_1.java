package chap10.Ex06;

//super : �θ�Ŭ���� (��Ӱ��迡�� �θ�)
//this : �ڽ��� ��ü

//���� ���̵� : �θ��� �޼ҵ尡 ������ �������� �ʾҴ�. �׷��� �������̵� �Ǵ��� super�� ����ϸ� �θ��� �޼ҵ带 ȣ���ؼ� ��°����ϴ�.

class A {
	
	void abc() {
		System.out.println("A class abc method");
	}
}

class B extends A {
	@Override
	void abc() {
		System.out.println("B class abc method");
	}
	void bcd() {
		abc(); //this.abc //this�� �ڽ��� ��ü abc�տ� this����
	}
	void cdf() {
		super.abc(); //super A(�θ�)Ŭ���� �� abc
	}
}

public class SuperKeyword_1 {

	public static void main(String[] args) {
		//1. ��ü ����
		B b = new B();
		//2. �޼ҵ� ȣ��
		b.bcd(); // B class�� bcd ȣ��
		
		b.cdf(); // B class�� cdf ȣ��
		
		
	}

}

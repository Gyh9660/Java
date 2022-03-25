package chap12.Ex06;

// interface�� default �޼ҵ� : �������̽� ������ �����ΰ� �ִ� �޼ҵ�
	//������ �����Ǿ� �ִ� �������̽����� ���ο� ����� �߰��Ҷ� ���� Ŭ�������� ������ �ʿ���� ���ο����� �߰��Ҷ� ��� 


	//public default void bcd() {}
		//Java 1.8 �̻󿡼� ���Ӱ� �߰��� ���
	// default Ű�� �־���� �Ѵ� => ���⼭ ����ϴ� default�� ���������ڰ� �ƴϴ�.


interface A {
	void abc();  	//2005�� ������ �޼ҵ� , public abstract�� ������, �����ΰ� ���� �߻� �޼ҵ�
	default void bcd() {	//2020�� ���� �޼ҵ�
		System.out.println("A interface bcd()");
	}
	//void ttt(); //���� Ŭ�������� ���ο� �߻�޼ҵ带 �߰��ϸ� ��ӵ� ��� ���� Ŭ������ ������ �߻��Ѵ�.
}
class B implements A {	//2005�� ������ Ŭ����
	public void abc() {
		System.out.println("B class abc()");
	}
}
class C implements A {
	public void abc() {
		System.out.println("C class abc()");
	}
	public void bcd() {		//default method�� overriding �Ҽ� �ִ�.
		System.out.println("C class bcd()");
	}
}


public class DefaultMethod {

	public static void main(String[] args) {
		//1. ��ü ����
		A a1= new B();
		A a2 = new C();
		
		//2. �޼ҵ� ȣ��
		a1.abc();
		a1.bcd();
		
		a2.abc();
		a2.bcd();
		
	}

}

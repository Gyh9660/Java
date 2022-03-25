package chap12.Ex07;

interface A {	//�θ� �������̽�
	default void abc() {	//�������̽����� �����ΰ� �ִ� �޼ҵ带 ���� : default
		System.out.println("A interface abc()");
	}
}
class B /*extends Object*/ implements A { //extends Object�� �����Ǿ�����
	@Override
	public void abc() { //�������̵�
		//super.abc(); //super.abc�� object���ִ� abc()�� ����Ŵ
		A.super.abc();
		System.out.println("B class abc()");
	}
}



public class DefaultMethod_2 {

	public static void main(String[] args) {
		//1. ��ü ����
		B b = new B();

		
		//2. �޼ҵ� ȣ��
		b.abc();	// B�� abc()�� ȣ��
		System.out.println("======================");
		A a1 = new B(); // �������̽��� ��ü������ �Ұ� Ÿ�Ժ����� ����
		a1.abc();
		
		
		
		
	}

}

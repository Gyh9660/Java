package chap13.Ex02;

//�̳�Ŭ�������� �ܺ�Ŭ������ �޼ҵ� ���� ���
/*
 * �������̵� : 	1. �θ�� �ڽ��� ��� ���谡 �־�� �Ѵ�.
 * 				2. �������̵��� �ν��Ͻ��޼ҵ� �������̵� >> �ν��Ͻ��޼ҵ常 �������̵��ȴ�.
 * 				3. �ν��Ͻ� �ʵ�, static �ʵ�, static �޼ҵ�� �������̵� ���� �ʴ´�.
 */




class A{
	int a =3;
	int b =4;
	int c = 33;
	int d = 44;
	void abc() { //���� : �������̵��� �ƴϴ�. �ܺ�, ����Ŭ������ ������ �޼ҵ�� ������ ������ ��ġ
		System.out.println("A Class Method abc()");
	}
	class B{	//�̳�Ŭ�������� �ܺ� Ŭ������ >>�ߺ���<< �ʵ峪 �޼ҵ� ȣ���� ��� : A.this.xxx
				//super�� �ƴϴ�! <<== ��Ӱ��迡�� �θ�Ŭ������ ����
		int a =5;
		int b =6;
		void abc() { //�������̵��� �ƴ϶� ������ �޼ҵ� �Դϴ�.
			System.out.println("B Class Method abc()");
		}
		void bcd() { 
			// 1. �ڱ��ڽ��� �ʵ�� �޼ҵ� ȣ�� (�̳�Ŭ������ �ʵ�� �޼ҵ�)
			System.out.println(a); //5 this.a
			System.out.println(b); //6 this.b
			abc(); //this.abc()
			//2.Outer Ŭ������ �ʵ�� �޼ҵ� ȣ��
			System.out.println(A.this.a); //3	A.this.a:Outer Class�� �ʵ尪 ȣ��:
			System.out.println(A.this.b); //4	<����> super ��� �ϸ�ȵȴ�.
			//3.Outer Ŭ������ �ʵ�� �޼ҵ� ȣ��
			System.out.println(c); //33
			System.out.println(d); //44
		}
	}
}


public class InnerClass_2 {

	public static void main(String[] args) {

		//1. �ܺ� Ŭ���� ��ü ����
		A a = new A();
		//2. �̳� Ŭ���� ��ü ����
		A.B b = a.new B();
		b.bcd();
		System.out.println("=============================");
		//3. ����Ŭ������ �ʵ�� �޼ҵ� ȣ��
		System.out.println(b.a);
		System.out.println(b.b);
		b.abc();
		
		
		
	}

}

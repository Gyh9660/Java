package chap10.Ex05;
class A {
	A(){} //�⺻ ������ : Ŭ���� ���� �ٸ� �����ڰ� �������� ���� ��� ���� ����
	
	//�ν��Ͻ� �޼ҵ� �������̵�: ��Ӱ��迡�� �޼ҵ� �������̵��� �ν��Ͻ� �޼ҵ常 �������̵� �ȴ�
		//��Ӱ��迡�� �ν��Ͻ� �ʵ�, static �ʵ�, static �޼ҵ�� �������̵� �����ʴ´�.
		//�������̵� �Ҷ��� �ñ״�ó�� ���ƾ��Ѵ�. ����Ÿ��, �޼ҵ��, �Ű�����Ÿ��, �Ű����� ����
	
	
	void print() {
		System.out.println("Class A ���");
	}
}

class B extends A {
	
	@Override
	
	void print() {
		
		System.out.println("Class B ���");
	}
}

class C extends A {
	
	@Override
	
	void print() {
		
		System.out.println("Class C ���");
	}
}
public class MethodOverriding {

	public static void main(String[] args) {

		//1.A Ÿ��, A ������
		A a = new A();
		a.print();
		//2.B Ÿ��, B ������
		B b = new B();
		b.print();
		//3.C Ÿ��, C ������
		C c = new C();
		c.print();
		
		System.out.println("===============");	
		
		//4.A Ÿ��, B ������ (�������̵� �Ǿ� A�� print()ȣ���, B�� print()�� ��µȴ�.
		A ab = new B();
		ab.print(); //A�� print()�޼ҵ� ȣ��====> B�� print()�� ��µ�.
		//5.A Ÿ��, C ������
		A ac = new C();
		ac.print(); //A�� print()�޼ҵ� ȣ�� ====> C�� print()�� ��µ�
		System.out.println("==============");
		A[] arr = {ab,ac}; //�迭�� A Ÿ���� ��ü�� ����
		
		
		for( int i=0; i<arr.length; i++)
			arr[i].print();
		
		System.out.println("===========");
		for (A k : arr) {
			k.print();
		}
		
	}

}

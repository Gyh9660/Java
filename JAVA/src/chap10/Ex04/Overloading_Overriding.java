package chap10.Ex04;

//�޼ҵ� �����ε�(Method Overloading) vs �޼ҵ� �������̵�(Method Overriding)
/*
 * 	1. �޼ҵ� �����ε� : ������ �޼ҵ� �̸����� (�Ű����� Ÿ��, �Ű����� ��)�� ���� �ش� �޼ҵ尡 ȣ��
 * 			-- ��Ӱ��� ������ ����., �����ڿ��� ���� ���...
 * 	2. �޼ҵ� �������̵� : �ݵ�� ��� ���迡�� ���.
 * 		�θ��� �޼ҵ带 �ڽĿ��� ���Ӱ� �����ؼ� ���.
 * 			1. ��Ӱ���, 2. �޼ҵ��� �ñ״�ó�� ���ƾ� �Ѵ�,(�޼ҵ��, �Ű����� ����, �Ű����� Ÿ��)
 * 			3. �ڽĿ��� �θ��� ���������ڿ� ���ų� �� ���� ������� �Ѵ�.
 */

class Ab {
	void print1() { //���� ���̵�
		System.out.println("AbŬ������ print1() ");
	}
	void print2() { //���� �ε�
		System.out.println("AbŬ������ print2() ");
	}
	
}
class Bc extends Ab{
	@Override
	void print1() { //���� ���̵�
		System.out.println("BcŬ������ print1() ");
	}
	void print2 (int a) { //���� �ε�
		System.out.println("BcŬ������ print2() ");
	}
}




public class Overloading_Overriding {

	public static void main(String[] args) {
		//1. AbŸ�� ����
		
		Ab aa = new Ab();
		aa.print1(); // Ab Ŭ������ print1 ȣ��
		aa.print2(); // Ab Ŭ������ print2 ȣ��
		System.out.println("============");

		//2. BcŸ�� ����, ������ ȣ�� Bb
		Bc bb = new Bc();
		bb.print1(); //Bc Ŭ������ print1 ȣ��
		bb.print2(); //Ab Ŭ������ print2 ȣ�� : �θ�Ŭ������ �޼ҵ�ȣ��
		bb.print2(2); //Bc Ŭ������ print2 ȣ�� : �ڽ�Ŭ������ �޼ҵ�ȣ��
		
		System.out.println("=================");
		//3.  AbŸ������ ����+ BcŸ�� ������ ȣ��
		Ab cc = new Bc();
		cc.print1(); //�޼ҵ� �������̵��� �Ǿ������Ƿ� �������ε��� ���ؼ� BcŬ������ print1 ȣ��
		cc.print2(); //AbŬ������ �޼ҵ常 ȣ���� ����
		
		
	}

}

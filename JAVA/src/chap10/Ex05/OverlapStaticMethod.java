package chap10.Ex05;

class AAAA{	//Static �޼ҵ嵵 �������̵� ���� �ʴ´�.
	static void print() {
		System.out.println("A Ŭ����");
	}
}

class BBBB extends AAAA {
	static void print() {
		System.out.println("B Ŭ����");
	}
}


public class OverlapStaticMethod {

	public static void main(String[] args) {
		//1. ��ü ���� ���� ȣ��
		AAAA.print();
		BBBB.print();
		System.out.println("============");
		
		//2. ��ü ������ ȣ��
		AAAA aaaa = new AAAA();
		BBBB bbbb = new BBBB();
		AAAA aabb = new BBBB();
		aaaa.print();	//A class
		bbbb.print();	//B class
		aabb.print();	//A class //static �޼ҵ�� �������̵� ���� �ʴ´�.
	}

}

package chap12.Ex01;


abstract class D {	//Ŭ���� ���ο� �߻�޼ҵ尡 �ð�� �߻�Ŭ������ �Ǿ�� �Ѵ�
					//�ڽ� Ŭ�������� �ݵ�� �������� �޼ҵ带 ������ �ϴ°����� ����.
	abstract void print(); //�߻�޼ҵ� , �����ΰ� ���� , ���� �� �޼ҵ�
}

class E extends D {//�ڽ� Ŭ������ �߻�Ŭ������ �޼ҵ带 ������(�������̵�)�ؾ��Ѵ�.

	@Override
	void print() {
		System.out.println("E Ŭ������ print()");
	} 
	
}

public class AbstractClass_3 {

	public static void main(String[] args) {
		//1. ��üȭ�ؼ� ���
			//�Ź� ���� ����ϴ� ���
		D d1 = new E(); //�ڽ� Ŭ���� �����ڸ� ȣ���ؼ� �θ� Ÿ������ ����.
		D d2 = new E();
		D d3 = new E();
		d1.print();
		d2.print();
		d3.print();
	
		//2. �͸� Ŭ������ ���� �ؼ� ���
			//��ü ���� ���� �ӽ÷� ����ϴ� ���
		//�߻�Ŭ������ ��äȭ �Ұ��� ==> D dd1 = new D() <==�Ұ���
		// �͸� Ŭ������ ������ ��밡��
		D dd1 = new D() { 
			void print() {		 	
				System.out.println("���2");
			}
		};
		D dd2 = new D() {
			//D �߻� Ŭ������ �ڽ� Ŭ���� ����(�͸�(Ŭ�����̸��̾���)Ŭ����)
			void print() {
				System.out.println("���2");
			}
		};
		D dd3 = new D() {
			void print() {
				System.out.println("���2");
			}
		};
		dd1.print();
		dd2.print();
		dd3.print();
		
		
		
		
	}

}

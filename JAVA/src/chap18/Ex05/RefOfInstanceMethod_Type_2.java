package chap18.Ex05;

//2. �޼ҵ� ���� (���� �޼ҵ� ǥ��)
	//�޼ҵ� ���� �� ���� ���������ʰ� �����Ǿ��ִ� �޼ҵ带 ȣ���ؼ� �ҷ��ͼ� �����ؼ� ���
	//���� �޼ҵ� ����

interface A{
	void abc();
}

class B {
	static void bcd() {		//<<< static�� �پ����� [static �޼ҵ�]: Ŭ�����̸����� ȣ���� ����
		System.out.println("method");
	}
}


public class RefOfInstanceMethod_Type_2 {

	public static void main(String[] args) {
		//1. ���� �޼ҵ� ���� : �̳� Ŭ������ ó��
		A a1 = new A() {
			@Override
			public void abc() {
				B.bcd();  //static�� ����� ���� �޼ҵ�ȣ��, ��ü�������� Ŭ�����̸����� ȣ��
			}
		};
				
		//2. ���ٽ� ǥ��
		A a2 = ()->{B.bcd();}; //[���ٽ� ǥ��]static�� ����� ���� �޼ҵ�ȣ��, ��ü�������� Ŭ�����̸����� ȣ��
		
		//3. ���� �޼ҵ� ���� ǥ��
		A a3 = B::bcd;
		
		
		a1.abc();
		a2.abc();
		a3.abc();
		
		
	}

}

package chap18.Ex06;

interface A {
	void abc(B b, int k);
}

class B {
	void bcd(int k) {		//�ν��Ͻ��޼ҵ� : static�� ����
		System.out.println(k);
	}
}






public class RefOfInstanceMethod_Type_2_1 {

	public static void main(String[] args) {

		//�ν��Ͻ� �޼ҵ� ���� type 2
		//�͸� �̳�Ŭ����
		
		A a1 = new A(){
			@Override
			public void abc(B b, int k) {
				b.bcd(k);
			}
		};
		
		
		//���ٽ� ǥ��
		
		A a2 = (b,k) -> {b.bcd(k);};
		
		
		//�ν��Ͻ� �޼ҵ� ����
		A a3 = B::bcd;	//<== �ν��Ͻ� �޼ҵ��̳� B��ü�� ��ǲ �޾Ƽ� bcd �޼ҵ�ȣ��
			//1. ��ü��::�޼ҵ��; 
			//������ b(�ҹ���)�� ������ B (�빮�ڰ� ���°��) - �����޼ҵ� ȣ���϶�, �ν��Ͻ��޼ҵ� ȣ�������� �Ű������� ��ü�� ��ǲ ������ �� �� 
		
		
		B b = new B();
		a1.abc(b, 7);
		a2.abc(b, 8);
		a3.abc(b, 9);
		
		
		
		
		
		
	}

}

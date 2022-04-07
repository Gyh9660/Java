package chap18.Ex10;


interface A{
	B abc(int k);		//����Ÿ���� B��ü�� ����
}

class B{
	B(){
		System.out.println("ù��° ������");
	}
	B(int k){
		System.out.println("�ι�° ������");
	}
	
	
}


public class RefOfClassConstructor_2 {

	public static void main(String[] args) {
		//1. Ŭ���� ������ ����.
				//�͸��̳�Ŭ����
				A a1 = new A() {
					@Override
					public B abc(int k) {	//abc(int k)�޼ҵ� ȣ��� B��ü�� �ι�° ������ ȣ�� ==> ������ ���� 
						return new B(3);
					}
				};
				
				//���ٽ� ǥ��
				A a2 = (int k)->{return new B();}; //��ü ����
				A a3 = (k)-> new B(3); //return�� ������ ��� ����(return���Ž� �ݵ��{};�� ����)
										//��� ǥ��
				//Ŭ���� ������ ����
				A a4 = B::new; //B�� �ι�° ������ ȣ��
				
				a1.abc(3);
				a2.abc(3);
				a3.abc(3);
				a4.abc(3);
				
				System.out.println("================================");

	}

}

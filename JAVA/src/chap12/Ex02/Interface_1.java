package chap12.Ex02;

//���� ���̽� (interface) : �ܺο� ���θ� ���� �����ִ� ����..(�ܼ�Ʈ)=>[�ܺ�������ġ >>�ܼ�Ʈ << ����]
					//������ (���, TV ���� �߰���) , API 
//��ü �����Ұ�, Ÿ���� ���� ����
// ��� �ʵ�� �ݵ�� : public static final ����
// ��� �޼ҵ�� : public abstract ����


interface A {		//���� ǥ��
	public static final int A = 3;	//�������̽� �ʵ��� ���� ǥ��
	public abstract void abc();		//�������̽� �޼ҵ��� ���� ǥ��
	
}
interface B{	//������ ����
	int A =3;
	void abc();	//�߻� �޼ҵ� :
}

abstract class C{	//�߻� Ŭ���� �ϋ��� abstract�� �����ɼ� ����.
	abstract void abc(); { //������ ���� �߻�
		
	}
}


public class Interface_1 {

	public static void main(String[] args) {
		
		
		//�������̽��� ��ü ���� �Ұ�.
		//A a new A(); //A�� �������̽��� ��ü �����Ұ�
		//1. interface�� static �ʵ��� ������ ���
		
		System.out.println(A.A); //�������̽��� �ʵ� ���, A<== static�� ���־ �̸����� ��� ����
		System.out.println(B.A);
		//2. final �� ����Ǿ� �ֱ� ������ ���� �����Ұ�
		//A.A =5; //final�� �����Ǿ� �ֱ� ������ ���� ���� �Ұ�
		//B.A =6;
		
		
		
	}

}

package chap06_07.Ex02;

//�������� ����������
//�޼ҵ� �����ε� : �ϳ��� �޼ҵ�� �Ű�����Ÿ�԰� ������ ���� ���� �ٸ� �޼ҵ尡 ȣ��� ( Java )
//�޼ҵ� �������̵� : ��ӿ��� �θ� Ŭ������ �޼ҵ带 ������ �ؼ� ���

//�ҽ��ȿ� class A�� ���鋚 ������Ű���ȿ� claas A�������� �������� 
	
// �پ��� Ÿ���� �޼ҵ�(���� Ÿ���� �ִ� ���[int,double,String......],
					//����Ÿ���� ���� ���� void Ű�� ���
public class ExternalCallMethods {

	public static void main(String[] args) {
		//��ü����
		A a = new A(); //���� ��Ű�� ���� Ŭ������ import���� ȣ���ؼ� ��밡��
						//�ٸ� ��Ű����� import�������
		//�޼ҵ� ȣ�� 
		a.print(); //AŬ������ �ٸ���Ű���� �־ ������ �߻��Ѵٸ� public�־������ �տ�
		System.out.println("=======");
		
		int k = a.data(); //3
		System.out.println(k);	
		System.out.println("======");
		
		double result = a.sum(3, 5.2);
		System.out.println(result);
		System.out.println("======");
		
		a.pringMethod(5); // 1 ~ 12 ������ ��
		a.pringMethod(13); // 1 ~12 �� ��� ��
		
		//���� :
		
		System.out.println(a.data()); //��±������� ȣ�� ������ �޼ҵ� (������ �ִ� �޼ҵ�)
		//System.out.println(a.print()); // a.print �޼ҵ�ȿ� �����̾��� �����ڵ�,
										//��±����� �̹� �ֱ⶧���� �����߻�
		a.print();
		System.out.println(a.sum(4, 10.5));
		//System.out.println(a.pringMethod(3)); //���� �߻�
		
		a.pringMethod(3);
		
		
		
		
	}

}

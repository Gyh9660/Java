package chap06_07.Ex06;

class S{
	int m = 3; //�ʵ�(�ν��Ͻ� �ʵ�): ��ü�� �����Ŀ� ��� ���� //stack�޸��� a�� 100����(������)�� ����Ű�� m��������� ���� heap�� ���� n�� �����ּҰ���? �ְ�AŬ���������� ����Ŵ �������� AŬ���������� ���� n�� Ŭ���������� ��ġ���ֱ⋚���� A.n���� ȣ���� �����ϴ�
	static int n = 4;
 //�ʵ� (static �ʵ�): ��ü�� �������� �ʾƵ� ��� ����
									 //��ü �����Ŀ��� ����� ����
									//��� ��ü�� �����ϴ� ����			
	void print1() { //�޼ҵ� (�ν��Ͻ� �޼ҵ�):��ü�� ������ ȣ�� ����
		//�ν��Ͻ� �ʵ��,static �ʵ尡 �ü� �ִ�.
		System.out.println("�ν��Ͻ� �޼ҵ� ���"+ "m :" + m+ "," +"n :"+  n );
	}
	
	static void print2() {//�޼ҵ� (static �޼ҵ�) :��ü �������� ȣ�� ����, ��ü�����Ŀ��� ȣ�Ⱑ��
		//static �޼ҵ忡���� �ν��Ͻ� �ʵ�� �� �� ����
		//static �޼ҵ�� ��ü�������� ȣ���� �ǹǷ� �ν��Ͻ� �ʵ尡 �ü�����.
		
		System.out.println("static �޼ҵ� ���"+"n : "+ n);
	}
}
public class Static_1 {

	public static void main(String[] args) {

		//1. ��ü ������ �ʵ�� �޼ҵ� ȣ��(�ν��Ͻ� �ʵ�,static �ʵ�, �ν��Ͻ� �޼ҵ� static�޼ҵ�)���ȣ��
		S s = new S();
		s.m = 10; //�ν��Ͻ� �ʵ� ȣ��
		s.n = 20; //static �ʵ� ȣ��
		s.print1(); //�ν��Ͻ� �޼ҵ� ȣ��
		s.print2(); //static �޼ҵ� ȣ��
		
		//2. ��ü �������� Ŭ���� ������ static�ʵ�� static�޼ҵ� ȣ��(static �ʵ�� static�޼ҵ常 ȣ�� �̰���)
		s.n = 100; // static �ʵ� :Ŭ���� ������ ȣ���
		s.print2();// static �޼ҵ� : Ŭ������ ���� ȣ���
		
		S bbb = new S();
		System.out.println(bbb.n); //100
		
		S ccc = new S();
		System.out.println(ccc.n); //100
		
		S ddd = new S();
		System.out.println(ddd.n); //100
		
		S eee= new S();
		System.out.println(eee.n); //100
		
		eee.n=300;
		System.out.println("=======static �ʵ尡 ����� �ʵ�� ��� ��ü���� �������� �ٶ󺸴� ����=======");
		
		System.out.println(s.n);
		System.out.println(bbb.n);
		System.out.println(ccc.n);
		System.out.println(ddd.n);
		System.out.println(eee.n);
		
		
		
		
	}

}

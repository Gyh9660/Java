package chap01;
public class Hello02 {
	//�޼ҵ� ����(�޼ҵ� : ��ü������� �Լ��� �޼ҵ��� ȣĪ�Ѵ�.) �Լ�(��ǲ���� �־ ���α׷������� ����� ���)//
	public static int sum (int n, int m) {
		return n+m;
	}
	public static void main(String[] args) {
		//���� ����//
		int i = 20; //i������ ������ ������ �ְ�, �ʱⰪ���� 20�� �Ҵ��ؼ� �ֽ��ϴ�.//
		int s ; //s������ �������� ������ �ְ�, �ʱⰪ�� �����//
		char a ; //a������ �ѱ��ڸ� ������ �ְ�(�ƽ�Ű�� char), ''(��������ǥ)�� ����ؼ� �����Ҵ��մϴ�.//
		String b;
		
		b="������ ������ �����ϴ�. ";
		
		s = sum (i,10); //sum�޼ҵ� ȣ��//
		a = '?';
		System.out.println(a);
		System.out.println("Hello");
		System.out.println(s);
		
		System.out.println(b);
	}

}

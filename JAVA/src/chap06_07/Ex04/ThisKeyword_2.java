package chap06_07.Ex04;

//this �ݵ�� �߱��ؾ��ϴ� ��� [����� this Ű���� �߰�]

class Aa{ //this key�� ������� ���� ��� : ���������� �ν�
	int m;
	int n;
	void init (int m, int n) {
		m = m; //this keyword�� ������� ���� ��� m<==��������m
		n = n; //this keyword�� ������� ���� ��� n<==��������n
		
	}
	
}

class Bb{ //this key�� ����ϴ� ���
	int m;
	int n;
	void init (int m, int n) { //this Ű�� ���������� �ݵ�� ����ؼ� m�� n�� �ʵ��� m�� n�̶�� �˷���� �Ѵ�.
		this.m = m; //this Ű�� ����� ��� m <== �ʵ� m
		this.n = n; //this Ű�� ����� ��� n <== �ʵ� n
		
	}
	
}

public class ThisKeyword_2 {

	public static void main(String[] args) {
		
		// 1. �ʵ��� ��� ���������� ���� ���� ��� (this Ű���带 ������� ���� ��� : ���������� ����)
		Aa aa = new Aa();
		aa.init(2, 3);
		System.out.println(aa.m); //0
		System.err.println(aa.n); //0
		// 2. �ʵ��� ��� ���������� ���� ���� ��� (this Ű���带 ����� ��� : �ʵ� ������ ����)
		
		Bb bb = new Bb();
		bb.init(2, 3);
		System.out.println(bb.m); //2
		System.out.println(bb.n); //3
	}

}

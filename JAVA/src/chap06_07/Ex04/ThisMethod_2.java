package chap06_07.Ex04;

//Aaa Ŭ������ �������� �����ڸ� ����� ��� this(); ���� ����� ���: �ߺ��� ���� �Ź� �Է�
class Aaa{
	int m1, m2, m3, m4; //�ʵ� 4�� ����
	Aaa(){ //�Ű������� ���� ������
		m1 = 1; //this�� �� �����Ǿ� ����
		m2 = 2;
		m3 = 3;
		m4 = 4;
	}
	Aaa(int a){
		m1 = a;
		m2 = 2;
		m3 = 3;
		m4 = 4;
	}
	Aaa(int a, int b){
		m1 = a;
		m2 = b;
		m3 = 3;
		m4 = 4;
	}
	Aaa(int a, int b, int c){
		m1 = a;
		m2 = b;
		m3 = c;
		m4 = 4;
	}
	Aaa(int a, int b, int c, int d){
		m1 = a;
		m2 = b;
		m3 = c;
		m4 = d;
	}
	void print () { // �� �޸��� ���� ���....
		System.out.print(m1 + " ");
		System.out.print(m2 + " ");
		System.out.print(m3 + " ");
		System.out.print(m4 + " ");
		System.out.println();
	}
}

//Bbb Ŭ������ �������� �����ڸ� ����� ��� this();�� ����Ѱ��

class Bbb{
	int m1, m2, m3, m4; //�ʵ� 4�� ����
	Bbb(){
		m1 = 1; //�ʱⰪ �Ҵ�
		m2 = 2;
		m3 = 3;
		m4 = 4;
	}
	Bbb(int a){
		this(); // ��ǲ ���� ���� ������ ȣ��
		m1 = a;
	}
	Bbb(int a, int b){
		this(a);
		m2 = b;
	}
	Bbb(int a, int b, int c){
		this(a,b);
		m3 = c;
	}
	Bbb(int a, int b, int c, int d){
		this(a,b,c);
		m4 = d;
	}
	void print2() { //�� �޸��� ���� ���....
		System.out.print(m1 + " ");
		System.out.print(m2 + " ");
		System.out.print(m3 + " ");
		System.out.print(m4 + " ");
		System.out.println();
	}
}

public class ThisMethod_2 {

	public static void main(String[] args) {
		//this �̻�� 5���� ��ü����
		Aaa aaa = new Aaa(); // �Ű� ������ ���� ������ ȣ��
		aaa.print();
		System.out.println("============");
		Aaa aaa1 = new Aaa(9);// �Ű� ������ �ϳ��� ������ ȣ��
		aaa1.print();
		System.out.println("============");
		Aaa aaa2 = new Aaa(9,8);//�Ű� ������ �ΰ��� ������ ȣ��
		aaa2.print();
		System.out.println("============");
		Aaa aaa3 = new Aaa(9,8,7);//�Ű� ������ ������ ������ ȣ��
		aaa3.print();
		System.out.println("============");
		Aaa aaa4 = new Aaa(9,8,7,6);//�Ű� ������ �װ��� ������ ȣ��
		aaa4.print();
		
		//2. this ��� 5���� ��ü����
		System.out.println("=====Bbb����=======");
		
		Bbb bbb = new Bbb();
		bbb.print2();//�Ű� ������ ���� ������ ȣ��(�⺻������)
		System.out.println("============");
		Bbb bbb1 = new Bbb(11);//�Ű� ������ �ϳ��� ������ ȣ��
		bbb1.print2();
		System.out.println("============");
		Bbb bbb2 = new Bbb(11,12);//�Ű� ������ �ΰ��� ������ ȣ��
		bbb2.print2();
		System.out.println("============");
		Bbb bbb3 = new Bbb(11,12,13);//�Ű� ������ ������ ������ ȣ��
		bbb3.print2();
		System.out.println("============");
		Bbb bbb4 = new Bbb(11,12,13,14);//�Ű� ������ �װ��� ������ ȣ��
		bbb4.print2();
		
	}

}

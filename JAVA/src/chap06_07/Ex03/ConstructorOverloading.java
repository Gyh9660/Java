package chap06_07.Ex03;


//������ �����ε� : �ϳ��� ������ �� ������Ÿ��, ������ ���� �ٸ� �����ڰ� ȣ��
	//����) ������Ÿ�԰� ���� �ΰ���ΰ� ������찡 2���̻� ������ �������߻�
class Abc{
	int a,b,c;
	String d;
	
	Abc(){System.out.println(a+","+b+","+c);} //�⺻ ������
	Abc(int a){ //�Ű����� 1���� ������
		this.a =a;
		System.out.println(a);
	}
	Abc(String d){ 
		this.d = d; 
		System.out.println(d);
	}
	
	Abc(int a, int b){ //�Ű����� 2���� ������
		this.a=a;
		this.b=b;
		System.out.print(a+ "," + b);
		System.out.println();
	}
	Abc(int a, int b, int c){ //�Ű����� 3���� ������
		this.a=a;
		this.b=b;
		this.c=c;
		System.out.print(a+","+b+","+c);
		System.out.println();
	}

	
}


public class ConstructorOverloading {

	public static void main(String[] args) {

		Abc a = new Abc(); //�⺻ ������ ȣ��
		
		Abc ab = new Abc(6); //�Ű� ���� �ϳ��� ������ ȣ��(int Ÿ��)
		
		Abc ab2 = new Abc("����"); //�Ű� ������ �ϳ��� ������ ȣ��(StringŸ��) �Ű������� ���� ������ Ÿ���̴ٸ��� �ش� �޼ҵ带 ȣ��
		
		Abc abc = new Abc(6,7); //�Ű� ���� �ΰ��� ������ ȣ��
		
		Abc abcd = new Abc (6,7,8); //�Ű� ���� ������ ������ ȣ��
		
	}

}

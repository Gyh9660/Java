package chap18.Ex03;

import java.util.Scanner;

interface Ex1{
	void ex(double a, double b);
}

//2����
class Ex2 implements Ex1{
	@Override
	public void ex(double a, double b) {
		System.out.println("a+b :"+ (a+b)+ ", a-b :"+ (a-b) + ", a*b : " + (a*b)+ ", a/b : "+(a/b));
	}
}

public class EX {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("�� �Ǽ��� ������ �����ؼ� �Է� �ϼ���>>");
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		//���ٽ� : �������̽��� �߻�޼ҵ带 �͸�Ŭ������ �����Ѱ��� ���ǥ��
		Ex1 ex1 = (x,y) -> {System.out.println("a+b :"+ (x+y)+ ", a-b :"+ (x-y) + ", a*b : " + (a*b)+ ", a/b : "+(x/b));};
		
		ex1.ex(a, b);
		
		
		//2. �������̽��� ������ Ŭ������ ������ �޼ҵ� ȣ��
		Ex1 ex2 = new Ex2();
		ex2.ex(a, b);
		
		
		//3. �͸� �̳� Ŭ������ ���
		Ex1 ex3 = new Ex1() {
			@Override
			public void ex(double a, double b) {
				System.out.println("a+b :"+ (a+b)+ ", a-b :"+ (a-b) + ", a*b : " + (a*b)+ ", a/b : "+(a/b));
				
			}
		};
		
		ex3.ex(a, b);
		
	}

}

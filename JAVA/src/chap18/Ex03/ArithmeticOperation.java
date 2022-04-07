package chap18.Ex03;

import java.util.Scanner;

//1. ��ĳ�ʸ� ����ؼ� double�� �μ��� ��ǲ �޽��ϴ�.
//2. ���1. ���ٽ��� ����ؼ� ��ǲ���� �ΰ��� +, -, *, / ,��Ģ������ �����ؼ� ���
//3. ���2 �������̽��� ������ �ڽ� ��ü�� ����ؼ� ��ǲ���� �ΰ��� +,-.*./ ��Ģ������ �����ؼ� ���
//4. ���3 �͸��̳�Ŭ������ ����ؼ� ��ǲ���� �ΰ��� +,-.*./ ��Ģ������ �����ؼ� ���
//4. ArithmeticExcepton ó�� 0���� ������ ���� �߻�. ����ó�� <int�� ��츸, double<==�ش������ �ƴϴ�

@FunctionalInterface
interface Arithmetic{
	void arithmeicOpr(double a, double b);
}

class A implements Arithmetic{
	Scanner sc = new Scanner(System.in);
	@Override
	public void arithmeicOpr(double a, double b) {
		double a2 = sc.nextDouble();
		double b2 = sc.nextDouble();
		System.out.println("+ :"+ (a2+b2) + ", - : "+(a2-b2)+", * : " + (a2*b2)+", / : " +(a2/b2));};
		
		
	
}


public class ArithmeticOperation {

	public static void main(String[] args) {

		//���1.���ٽ�
		//��ĳ���Է��ؾ���
		Scanner sc = new Scanner(System.in);
		
		Arithmetic arith1 = (a,b) ->  {
		double a1 = sc.nextDouble();
		double b1 = sc.nextDouble();
		System.out.println("+ :"+ (a1+b1) + ", - : "+(a1-b1)+", * : " + (a1*b1)+", / : " +(a1/b1));};
		arith1.arithmeicOpr(0, 0);
		System.out.println("======================");
		
		//���2. �������̽��� ������ �ڽ� ��ü
		//��ĳ���Է��ؾ���
		Arithmetic arith2 = new A();
		arith2.arithmeicOpr(0, 0);
		System.out.println("======================");
		
		//���3. �͸��̳�Ŭ������ ���
		//��ĳ���Է��ؾ���
		Arithmetic arith3 = new Arithmetic() {
			
			@Override
			public void arithmeicOpr(double a, double b) {
				double a3 = sc.nextDouble();
				double b3 = sc.nextDouble();
				System.out.println("+ :"+ (a3+b3) + ", - : "+(a3-b3)+", * : " + (a3*b3)+", / : " +(a3/b3));};
		};
		
		arith3.arithmeicOpr(0, 0);
	
	try {
		Arithmetic arith4 = (a,b) ->  {
			int a4 = sc.nextInt();
			int b4 = sc.nextInt();
			System.out.println("+ :"+ (a4+b4) + ", - : "+(a4-b4)+", * : " + (a4*b4)+", / : " +(a4/b4));};
			arith4.arithmeicOpr(0, 0);
	} catch (ArithmeticException e) {
		System.out.println("���ܹ߻�");
	}
		
	}

}

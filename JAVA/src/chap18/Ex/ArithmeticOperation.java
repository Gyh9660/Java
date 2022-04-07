package chap18.Ex;

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
	@Override
	public void arithmeicOpr(double a, double b) {
		System.out.println("+ :"+ (a+b) + ", - : "+(a-b)+", * : " + (a*b)+", / : " +(a/b));};
		
		
	
}


public class ArithmeticOperation {

	public static void main(String[] args) {

		//���1.���ٽ�
		//��ĳ���Է��ؾ���
		Scanner sc = new Scanner(System.in);
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		Arithmetic arith1 = (a1,b1) ->  {
		
		System.out.println("+ :"+ (a1+b1) + ", - : "+(a1-b1)+", * : " + (a1*b1)+", / : " +(a1/b1));};
		arith1.arithmeicOpr(a, b);
		System.out.println("======================");
		
		//���2. �������̽��� ������ �ڽ� ��ü
		//��ĳ���Է��ؾ���
		Arithmetic arith2 = new A();
		arith2.arithmeicOpr(a, b);
		System.out.println("======================");
		
		//���3. �͸��̳�Ŭ������ ���
		//��ĳ���Է��ؾ���
		Arithmetic arith3 = new Arithmetic() {
			
			@Override
			public void arithmeicOpr(double a, double b) {
				System.out.println("+ :"+ (a+b) + ", - : "+(a-b)+", * : " + (a*b)+", / : " +(a/b));};
		};
		
		arith3.arithmeicOpr(a, b);
	
	try {
		Arithmetic arith4 = (a1,b1) ->  {
			int a4 = sc.nextInt();
			int b4 = sc.nextInt();
			System.out.println("+ :"+ (a4+b4) + ", - : "+(a4-b4)+", * : " + (a4*b4)+", / : " +(a4/b4));};
			arith4.arithmeicOpr(a, b);
	} catch (ArithmeticException e) {
		System.out.println("���ܹ߻�");
	}
		
	}

}

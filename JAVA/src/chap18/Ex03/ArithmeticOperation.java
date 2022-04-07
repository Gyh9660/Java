package chap18.Ex03;

import java.util.Scanner;

//1. 스캐너를 사용해서 double의 두수를 인풋 받습니다.
//2. 방법1. 람다식을 사용해서 인풋받은 두값을 +, -, *, / ,사칙연산을 구현해서 출력
//3. 방법2 인터페이스를 구현한 자식 객체를 사용해서 인풋받은 두값을 +,-.*./ 사칙연산을 구현해서 출력
//4. 방법3 익명이너클래스를 사용해서 인풋받은 두값을 +,-.*./ 사칙연산을 구현해서 출력
//4. ArithmeticExcepton 처리 0으로 나누면 에외 발생. 예외처리 <int의 경우만, double<==해당사항이 아니다

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

		//방법1.람다식
		//스캐너입력해야함
		Scanner sc = new Scanner(System.in);
		
		Arithmetic arith1 = (a,b) ->  {
		double a1 = sc.nextDouble();
		double b1 = sc.nextDouble();
		System.out.println("+ :"+ (a1+b1) + ", - : "+(a1-b1)+", * : " + (a1*b1)+", / : " +(a1/b1));};
		arith1.arithmeicOpr(0, 0);
		System.out.println("======================");
		
		//방법2. 인터페이스를 구현한 자식 객체
		//스캐너입력해야함
		Arithmetic arith2 = new A();
		arith2.arithmeicOpr(0, 0);
		System.out.println("======================");
		
		//방법3. 익명이너클래스를 사용
		//스캐너입력해야함
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
		System.out.println("예외발생");
	}
		
	}

}

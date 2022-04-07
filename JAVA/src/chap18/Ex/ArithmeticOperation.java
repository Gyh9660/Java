package chap18.Ex;

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
	@Override
	public void arithmeicOpr(double a, double b) {
		System.out.println("+ :"+ (a+b) + ", - : "+(a-b)+", * : " + (a*b)+", / : " +(a/b));};
		
		
	
}


public class ArithmeticOperation {

	public static void main(String[] args) {

		//방법1.람다식
		//스캐너입력해야함
		Scanner sc = new Scanner(System.in);
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		Arithmetic arith1 = (a1,b1) ->  {
		
		System.out.println("+ :"+ (a1+b1) + ", - : "+(a1-b1)+", * : " + (a1*b1)+", / : " +(a1/b1));};
		arith1.arithmeicOpr(a, b);
		System.out.println("======================");
		
		//방법2. 인터페이스를 구현한 자식 객체
		//스캐너입력해야함
		Arithmetic arith2 = new A();
		arith2.arithmeicOpr(a, b);
		System.out.println("======================");
		
		//방법3. 익명이너클래스를 사용
		//스캐너입력해야함
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
		System.out.println("예외발생");
	}
		
	}

}

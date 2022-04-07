package chap18.Ex03;

import java.util.Scanner;

interface Ex1{
	void ex(double a, double b);
}

//2번쨰
class Ex2 implements Ex1{
	@Override
	public void ex(double a, double b) {
		System.out.println("a+b :"+ (a+b)+ ", a-b :"+ (a-b) + ", a*b : " + (a*b)+ ", a/b : "+(a/b));
	}
}

public class EX {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("두 실수를 공백을 구분해서 입력 하세요>>");
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		//람다식 : 인터페이스의 추상메소드를 익명클래스로 생성한것의 약식표현
		Ex1 ex1 = (x,y) -> {System.out.println("a+b :"+ (x+y)+ ", a-b :"+ (x-y) + ", a*b : " + (a*b)+ ", a/b : "+(x/b));};
		
		ex1.ex(a, b);
		
		
		//2. 인터페이스를 구현한 클래스를 생성후 메소드 호출
		Ex1 ex2 = new Ex2();
		ex2.ex(a, b);
		
		
		//3. 익명 이너 클래스로 출력
		Ex1 ex3 = new Ex1() {
			@Override
			public void ex(double a, double b) {
				System.out.println("a+b :"+ (a+b)+ ", a-b :"+ (a-b) + ", a*b : " + (a*b)+ ", a/b : "+(a/b));
				
			}
		};
		
		ex3.ex(a, b);
		
	}

}

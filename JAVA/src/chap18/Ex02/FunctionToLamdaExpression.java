package chap18.Ex02;

//람다식 문법


//아래 4개의 인터페이스는 람다식으로 처리가 가능 : 함수형 인터페이스이기 떄문에

@FunctionalInterface
interface A{	//입력x , 리턴x
	void method1();
}

@FunctionalInterface
interface B{	//입력o, 리턴x
	void method2(int a);
}

@FunctionalInterface
interface C{	//입력x,리턴o
	int method3();
}

@FunctionalInterface
interface D{	//입력o,리턴o
	double method4(int a, int b);
}




public class FunctionToLamdaExpression {

	public static void main(String[] args) {

		//인터페이스의 구현되지 않는 함수를 구현 --> 람다식
		
		//1. 입력x, 리턴x
			//1-1 : 익명 이너클래스로 처리
			A a1 = new A() {
				@Override
				public void method1() {
					System.out.println("method 1");
				}
			};
			a1.method1();
			
			//1-2 : 람다식으로 처리
				//람다식은 리턴타입, 메소드이름 까지 제거
				//(인풋) -> {구현부};
				A a2 = () -> {System.out.println("method 2");}; //전체
				A a3 = () -> System.out.println("method 3"); //구현부에 한라인만 존재할떄 {};를 생략가능
			
				a2.method1();
			
				a3.method1();
			
		//2. 입력o, 리턴x
			//2-1: 익명 이너클래스로 처리
			B b1 = new B() {
				public void method2(int a) {
					System.out.println("method 2 - 4 : "+ a);
				};
			};
			b1.method2(0);
			//2-2 람다식으로 처리 (생략가능한것은 최대한 생략해서 표현)
			B b2 = (int a)->{System.out.println("method 2 - 4 : "+ a);}; //전체 구문
			B b3 = (a)->{System.out.println("method 2 - 5 : "+ a);}; //입력매개변수의 타입은 생략가능
			B b4 = (a)-> System.out.println("method 2 - 6 : "+ a); //실행문이 한라인일때 {};생략가능
			B b5 = a-> System.out.println("method 2 - 7 : "+ a); //입력매개변수가 하나일떄 ()생략가능
			
			b2.method2(1);
			b3.method2(2);
			b4.method2(3);
			b5.method2(4);
			
		//3. 입력x, 리턴o
			//3-1 익명이너클래스
			C c1 = new C() {
				public int method3() {
					return 4;
				};
			};
			
			System.out.println("돌려받은 값은 : "+c1.method3());
			
			//3-2 : 람다식으로 표현
			
			C c2 = () -> {return 5;}; //전체구문
			C c3 = () ->6; //리턴이 한라인으로 적용된 경우 return 생략가능,반드시 중괄호와 함꼐 생략
			
			System.out.println("돌려받은 값은 : "+c2.method3());
			System.out.println("돌려받은 값은 : "+c3.method3());
			
		//4. 입력o, 리턴o
			//4-1 : 익명 이너 클래스
			
			D d1 = new D() {
				public double method4(int a, int b) {
					return a +b;
				};
			};
			
			System.out.println("두 수의 합은 : " + d1.method4(1, 2) );
			
			//4-2 : 람다식으로 처리
			D d2 = (int a, int b) -> {return a + b; }; //전체 표현
			D d3 = (a,b) -> {return a + b; }; //인풋 타입은 생략가능
			D d4 = (a,b) -> a + b; //리턴이 하나일때 생략 가능, 중괄호와 반드시 같이 생략
			
			
			System.out.println("두 수의 합은 : " + d2.method4(3, 4));
			System.out.println("두 수의 합은 : " + d3.method4(5, 6));
			System.out.println("두 수의 합은 : " + d4.method4(7, 8));
			
			
	}

}

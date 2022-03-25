package chap12.Ex07;

interface A {	//부모 인터페이스
	default void abc() {	//인터페이스에서 구현부가 있는 메소드를 정의 : default
		System.out.println("A interface abc()");
	}
}
class B /*extends Object*/ implements A { //extends Object가 생략되어있음
	@Override
	public void abc() { //오버라이딩
		//super.abc(); //super.abc는 object에있는 abc()를 가리킴
		A.super.abc();
		System.out.println("B class abc()");
	}
}



public class DefaultMethod_2 {

	public static void main(String[] args) {
		//1. 객체 생성
		B b = new B();

		
		//2. 메소드 호출
		b.abc();	// B의 abc()를 호출
		System.out.println("======================");
		A a1 = new B(); // 인터페이스는 객체생성은 불가 타입변경은 가능
		a1.abc();
		
		
		
		
	}

}

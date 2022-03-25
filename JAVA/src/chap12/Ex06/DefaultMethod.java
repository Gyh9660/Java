package chap12.Ex06;

// interface의 default 메소드 : 인터페이스 내에서 구현부가 있는 메소드
	//기존의 구현되어 있는 인터페이스에서 새로운 기능을 추가할때 하위 클래스에서 재정의 필요없이 새로운기능을 추가할때 사용 


	//public default void bcd() {}
		//Java 1.8 이상에서 새롭게 추가된 기능
	// default 키를 넣어줘야 한다 => 여기서 사용하는 default는 접근지정자가 아니다.


interface A {
	void abc();  	//2005년 생성한 메소드 , public abstract가 생략됨, 구현부가 없는 추상 메소드
	default void bcd() {	//2020년 생성 메소드
		System.out.println("A interface bcd()");
	}
	//void ttt(); //상위 클래스에서 새로운 추상메소드를 추가하면 상속된 모든 하위 클래스는 오류가 발생한다.
}
class B implements A {	//2005년 생성된 클래스
	public void abc() {
		System.out.println("B class abc()");
	}
}
class C implements A {
	public void abc() {
		System.out.println("C class abc()");
	}
	public void bcd() {		//default method도 overriding 할수 있다.
		System.out.println("C class bcd()");
	}
}


public class DefaultMethod {

	public static void main(String[] args) {
		//1. 객체 생성
		A a1= new B();
		A a2 = new C();
		
		//2. 메소드 호출
		a1.abc();
		a1.bcd();
		
		a2.abc();
		a2.bcd();
		
	}

}

package chap10.Ex06;

//super : 부모클래스 (상속관계에서 부모)
//this : 자신의 객체

//오버 라이딩 : 부모의 메소드가 완전히 삭제되지 않았다. 그래서 오버라이딩 되더라도 super를 사용하면 부모의 메소드를 호출해서 출력가능하다.

class A {
	
	void abc() {
		System.out.println("A class abc method");
	}
}

class B extends A {
	@Override
	void abc() {
		System.out.println("B class abc method");
	}
	void bcd() {
		abc(); //this.abc //this는 자신의 객체 abc앞에 this생략
	}
	void cdf() {
		super.abc(); //super A(부모)클래스 의 abc
	}
}

public class SuperKeyword_1 {

	public static void main(String[] args) {
		//1. 객체 생성
		B b = new B();
		//2. 메소드 호출
		b.bcd(); // B class의 bcd 호출
		
		b.cdf(); // B class의 cdf 호출
		
		
	}

}

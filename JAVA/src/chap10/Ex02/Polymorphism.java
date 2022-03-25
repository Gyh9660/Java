package chap10.Ex02;

//다형성 (Polymorphism) : 객체의 상속 관계에서 여러 데이터타입으로 변환 가능

class A {
	
}

class B extends A{
	
}

class C extends B{
	
}

class D extends B{
	
}



public class Polymorphism {

	public static void main(String[] args) {

		// 1. 업캐스팅 (자동으로 변환)자식 => 부모 : 생략시 컴파일러가 자동으로 추가;
		
		A ac = (A)new C(); //C => A : C는 A다. , ac는 A, B, C의 필드와 메소드를 모두 포함하고 있고, A의 필드와 메소드에만 접근가능하다.
		A ab = new B(); //B => A : B는 A다. (A)생략 <--생략가능 업캐스팅. ab는 A, B의 필드와 메소드가 포함되어 있고, A의 필드와 메소드에만 접근가능하다.
		B bd = new D(); //D => B : D는 B다. , bd는 A,B,D의 필드와 메소드가 포함, A,B의 필드와 메소드만 접근가능하다.
		C c = new C(); // C => C : C는 C다. , c는 A,B,C의 필드와 메소드가 포함, A,B,C의 필드와 메소드에 접근가능하다.
	
		//2. 객체 생성을 할수 없는 경우 (상속)
		/*
		B b = new A(); //오류 A => B :A는 B다 (불가능)
		C cc1 = new B();
		D dd1 = new B(); //부모에서 자식으로 내려올수없다
		C cd = new D(); //상속관계가 아예없음
		*/
		
		
		//3. 다운 캐스팅 : 부모 => 자식 (수동 변환 ) : 캐스팅이 불가능하면 에러발생 (실행시 오류발생 런타임에러)
		
		A aa = new A();
//		B b1 = (B) aa; // // A => B 다운캐스팅 (수동 변환) <= 실행시 오류 발생
			//Java.lang.ClassCastException: 다운캐스팅시 객체 내에 해당 타입이 존재하지 않는경우
		//C cc2 = (C) aa; //aa는 C타입을 내포하지 않는데 다운캐스팅을 할경우 문법적인 오류는 없지만 실행시에 오류발생
		
		//컴파일 오류 : 프로그램을 실행전 이클립스가 체크
		//런타임 오류 : 실행시에 발생되는 오류
		
		//4. 다운 캐스팅이 가능한 경우 (수동변환) : 객체 내부에 자식데이터테입을 가지고있으면 캐스팅 가능
		A ac3 = new C(); //ac3는 A,B,C 포함. A만 사용 가능
		
		B ac5 = (B) ac3; // A => B로 다운캐스팅
		
		C ac6 = (C) ac3; // A => C로 다운캐스팅
		
		A ad2 = new D(); // D => A로 업캐스팅, ad2는 A,B,D포함 , A만접근 가능
		
		B bd3 = (B) ad2; // A => B로 다운캐스팅
		
		D dd4 = (D) ad2; //
		
		
		
	}

}

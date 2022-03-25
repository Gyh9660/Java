package chap12.Ex03;

interface A {
	
}

interface B {
	
}
//1. 단일 인터페이스 상속
class C implements A { //class C는 interface A를 구현(상속)
	
}

//2. 다중 인터페이스 상속
class D implements A,B{ //interface는 다중 구현(상속)이 가능
	
}

//3. 클래스와 인터페이스를 한번에 상송 (extends와 implements의 순서는 변경불가)
	//클래스는 다중 상속 불가, 인터페이스는 다중 상속이 가능
class E extends C implements A,B { //
	
}


public class Interface_3 {

	public static void main(String[] args) {

		
		
		
		
		
	}

}

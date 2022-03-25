package chap13.Ex09;

//4.매개변수로 받아서 처리 : 인터페이스를 구현한 클래스(자식클래스)가 (X),

interface A {
	void abc();			//public abstract
}
class C {
	void cde(A a) {
		a.abc();
	}
}


public class AnonymousClass_4 {

	public static void main(String[] args) {
		C c = new C();
		//3. 인터페이스를 구현한 클래스 (X)+ 참조변수 생성(O)
		A a = new A() { //인터페이스를 구현한 자식 익명 객체생성후 타입을 A로 지정한 참조변수를 생성
			public void abc() {
				System.out.println("클래스(X) + 참조변수 (O)");
			}			
		};
		c.cde(a); // 참조변수를 매개 변수로 전달
		
		//4. 인터페이스를 구현한 클래스 (X)+ 참조변수 생성(X) <=== 제일 많이 사용 (임시로 한번만 사용할때)
			//이벤트 처리
		c.cde(new A() {
			public void abc() {
				System.out.println("클래스(X) + 참조변수 (X)");
			}
		});
		
		
		
	}

}

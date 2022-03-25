package chap13.Ex09.Ex1;

interface A {
	void cry();
	void fly();
}
class C {
	void abc(A a) {
		a.cry();
		a.fly();
	}
}


public class AnonymousClass_4_1 {

	public static void main(String[] args) {
		C c = new C();
		//1. 클래스는 존재(X) + 참조 변수 (O)
		
		A a = new A() {
			@Override
			public void cry() {
				System.out.println("야옹");
			}
			@Override
			public void fly() {
				System.out.println("날지 못합니다.");
			}
		};
		c.abc(a);
		
		//2. 클래스는 존재(X) + 참조 변수 (X)
		c.abc(new A() {
			@Override
			public void cry() {
				System.out.println("야옹");
			}
			@Override
			public void fly() {
				System.out.println("날지 못합니다.");
			}
		});
		
	}

}

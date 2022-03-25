package chap10.Ex04;



//메소드 오버 라이딩(Method Overriding) :
	// 1.반드시 상속 관계에서만 메소드 오버라이딩이 구현됨
	// 2. 부모 클래스에서 선언된 메소드를 자식 클래스에서 새롭게 정의해서 사용하는것.
	// 3. @Override  라는 어노테이션을 사용하면 메소드 재정의시 오류를 줄일수있다.
	// 4. 시그니쳐가 같아야 한다. ( 메소드명, 매개변수타입, 매개변수 갯수)
	// 5. 메소드의 접근 제어자가 같거나 넓어야한다. (public >protected >default >private )


class A{
	void print() {
		System.out.println("A 클래스");
	}
}
class B extends A{
	//@Override  //메소드 오버라이딩 시, 반드시 부모의 메소드를 재정의 하도록 설정
					//@Override 어노테이션을 사용하지 않을 경우 : 오타가 나거나 형식에 맞지 않을경우 별개의 메소드로 정의됨.
	void print() {
		System.out.println("B 클래스");
	}
}

public class MethodOverriding {

	public static void main(String[] args) {
		//1. A타입
		A aa = new A();
		aa.print(); //A클래스의 print() 출력 => A 클래스
		
		//2. B타입
		B bb = new B();
		bb.print(); //B클래스 print() 출력 => B 클래스

		//3. A타입으로 업캐스팅 <<<==== 중요 B를 업캐스팅해서 A타입으로 두면
		A ab = new B();
		ab.print(); //B클래스의 print() 출력 => B 클래스
		//타입을 A로 둿기떄문에 ab.print는 A에있는 프린트 호출 근데왜 B클래스의 프린트가 찍히느냐?
		//바인딩이달라서 b가찍힘
		// 객체화시킬떄 A클래스가 먼저 만들어지고 B클래스가 만들어짐
		// B가생성될때 같은이름인 print 를 덮어씌워버림 (override)
		//그래서 A로 접근하는데 B의값이 출력됨..?
			
			//ab.print();는 A클래스의 print를 호출, 동적바인딩을 통해 overriding된 클래스의 print인 B클래스의 print를 호출 **아주아주아주아주 중요한 개념**
		
	}

}

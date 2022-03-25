package chap13.Ex02;

//이너클래스에서 외부클래스의 메소드 접근 방법
/*
 * 오버라이딩 : 	1. 부모와 자식이 상속 관계가 있어야 한다.
 * 				2. 오버라이딩은 인스턴스메소드 오버라이딩 >> 인스턴스메소드만 오버라이딩된다.
 * 				3. 인스턴스 필드, static 필드, static 메소드는 오버라이딩 되지 않는다.
 */




class A{
	int a =3;
	int b =4;
	int c = 33;
	int d = 44;
	void abc() { //주의 : 오버라이딩이 아니다. 외부, 내부클래스의 동일한 메소드는 별개의 공간에 위치
		System.out.println("A Class Method abc()");
	}
	class B{	//이너클래스에서 외부 클래스의 >>중복된<< 필드나 메소드 호출할 경우 : A.this.xxx
				//super가 아니다! <<== 상속관계에서 부모클래스를 뜻함
		int a =5;
		int b =6;
		void abc() { //오버라이딩이 아니라 별개의 메소드 입니다.
			System.out.println("B Class Method abc()");
		}
		void bcd() { 
			// 1. 자기자신의 필드와 메소드 호출 (이너클래스의 필드와 메소드)
			System.out.println(a); //5 this.a
			System.out.println(b); //6 this.b
			abc(); //this.abc()
			//2.Outer 클래스의 필드와 메소드 호출
			System.out.println(A.this.a); //3	A.this.a:Outer Class의 필드값 호출:
			System.out.println(A.this.b); //4	<주의> super 사용 하면안된다.
			//3.Outer 클래스의 필드와 메소드 호출
			System.out.println(c); //33
			System.out.println(d); //44
		}
	}
}


public class InnerClass_2 {

	public static void main(String[] args) {

		//1. 외부 클래스 객체 생성
		A a = new A();
		//2. 이너 클래스 객체 생성
		A.B b = a.new B();
		b.bcd();
		System.out.println("=============================");
		//3. 내부클래스의 필드와 메소드 호출
		System.out.println(b.a);
		System.out.println(b.b);
		b.abc();
		
		
		
	}

}

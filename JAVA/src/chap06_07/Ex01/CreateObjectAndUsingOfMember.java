package chap06_07.Ex01;

//클래스(class) : 객체를 생성하기 위한 틀(템플릿), 설계도. 붕어빵의 틀 <<중요>>
//객체(Object) : 클래스를 복사해서 메모리(RAM)에서 작동되는 실행코드 (설계도에 따라 나온 집, 붕어빵 틀에 의해 나온 붕어빵)
	// 객체 = 인스턴스 
	// 인스턴스화 (객체화) 시킨다. (메인 메소드에서 객체를 인스턴스화 시켜 줘야한다.)
	// A a = new A(); <== 클래스를 객체화 시켜서 메모리에 로드

class A { //외부 클래스
	int m = 3;		// m => 필드(변수) : class블락에서 선언된 변수를 필드라 호칭
					// 필드는 인스턴스화 (객체화) 시켜야 사용이 가능하다.
					// 필드는 메모리의 Heap영역에 생성
	
	void print() { //메소드 : 절차지향언어의 함수 = 객체지향언어의 메소드 /객체지향언어에서 함수를 메소드라 호칭
		System.out.println("객체 생성 및 활용");
	}
	
}

class B { //외부 클래스
	String name = "홍길동";
	int age = 24;
	String phone = "010-1111-1111";
	
	void print_name () {
		System.out.println(name);
	}
	void printage () {
		System.out.println(age);
	}
	void printphone() {
		System.out.println(phone);
	}
}

public class CreateObjectAndUsingOfMember {

	public static void main(String[] args) {
		A a = new A(); //Class A를 객체화(인스턴스화) 시킨다.=>메모리(RAM)에 로드시킨다.
		System.out.println(a.m);
		a.print();
		
		System.out.println("================");
		
		A b = new A();		//Class A를 객체화(인스턴스화) 시킨다.(RAM에 로드시킨다.) 
		//()는 생성자 안에 매개변수없는걸 기본생성자라고함 A=클래스 b= 객체
		/*----------------------------------------------------------------
		 *  실제값(실제메소드)         |  b       |  메소드값이 있는주소(포인트값)   |
		 *  클래스영역               | stack     | Heap                     |
		 *----------------------------------------------------------------
		 */
		System.out.println(b.m);
		b.print();
	
		System.out.println("================");
		
		A c = new A();
		System.out.println(c.m);
		c.print();
		
		System.out.println("================");
		
		B bb = new B(); //B class를 bb 라는 이름으로 객체화
		bb.print_name(); //bb객체의 메소드를 호출
		bb.printage();	//bb객체의 메소드 호출
		bb.printphone();	//bb객체의 메소드 호출
		
		B cc = new B();
		cc.print_name();
		cc.printage();
		cc.printphone();
		
		
		
		
	}

}

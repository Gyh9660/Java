package chap12.Ex01;


abstract class D {	//클래스 내부에 추상메소드가 올경우 추상클래스가 되어야 한다
					//자식 클래스에서 반드시 오류없이 메소드를 재정의 하는것을을 보장.
	abstract void print(); //추상메소드 , 구현부가 없는 , 선언만 된 메소드
}

class E extends D {//자식 클래스는 추상클래스의 메소드를 재정의(오버라이딩)해야한다.

	@Override
	void print() {
		System.out.println("E 클래스의 print()");
	} 
	
}

public class AbstractClass_3 {

	public static void main(String[] args) {
		//1. 객체화해서 출력
			//매번 자주 사용하는 경우
		D d1 = new E(); //자식 클래스 생성자를 호출해서 부모 타입으로 생성.
		D d2 = new E();
		D d3 = new E();
		d1.print();
		d2.print();
		d3.print();
	
		//2. 익명 클래스를 생성 해서 출력
			//객체 생성 없이 임시로 사용하는 경우
		//추상클래스는 객채화 불가능 ==> D dd1 = new D() <==불가능
		// 익명 클래스를 생성후 사용가능
		D dd1 = new D() { 
			void print() {		 	
				System.out.println("방법2");
			}
		};
		D dd2 = new D() {
			//D 추상 클래스의 자식 클래스 영역(익명(클래스이름이없는)클래스)
			void print() {
				System.out.println("방법2");
			}
		};
		D dd3 = new D() {
			void print() {
				System.out.println("방법2");
			}
		};
		dd1.print();
		dd2.print();
		dd3.print();
		
		
		
		
	}

}

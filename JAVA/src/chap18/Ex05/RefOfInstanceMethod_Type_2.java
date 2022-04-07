package chap18.Ex05;

//2. 메소드 참조 (정적 메소드 표현)
	//메소드 참조 ㅣ 내가 구현하지않고 구현되어있는 메소드를 호출해서 불러와서 참조해서 사용
	//정적 메소드 참조

interface A{
	void abc();
}

class B {
	static void bcd() {		//<<< static이 붙어있음 [static 메소드]: 클래스이름으롷 호출이 가능
		System.out.println("method");
	}
}


public class RefOfInstanceMethod_Type_2 {

	public static void main(String[] args) {
		//1. 정적 메소드 참조 : 이너 클래스로 처리
		A a1 = new A() {
			@Override
			public void abc() {
				B.bcd();  //static이 적용된 정적 메소드호출, 객체생성없이 클래스이름으로 호출
			}
		};
				
		//2. 람다식 표현
		A a2 = ()->{B.bcd();}; //[람다식 표현]static이 적용된 정적 메소드호출, 객체생성없이 클래스이름으로 호출
		
		//3. 정적 메소드 참조 표현
		A a3 = B::bcd;
		
		
		a1.abc();
		a2.abc();
		a3.abc();
		
		
	}

}

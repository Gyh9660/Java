package chap18.Ex06;

interface A {
	void abc(B b, int k);
}

class B {
	void bcd(int k) {		//인스턴스메소드 : static이 없다
		System.out.println(k);
	}
}






public class RefOfInstanceMethod_Type_2_1 {

	public static void main(String[] args) {

		//인스턴스 메소드 참조 type 2
		//익명 이너클래스
		
		A a1 = new A(){
			@Override
			public void abc(B b, int k) {
				b.bcd(k);
			}
		};
		
		
		//람다식 표현
		
		A a2 = (b,k) -> {b.bcd(k);};
		
		
		//인스턴스 메소드 참조
		A a3 = B::bcd;	//<== 인스턴스 메소드이나 B객체를 인풋 받아서 bcd 메소드호출
			//1. 객체명::메소드명; 
			//원래는 b(소문자)가 들어가지만 B (대문자가 들어가는경우) - 정적메소드 호출일때, 인스턴스메소드 호출이지만 매개변수로 객체가 인풋 값으로 들어갈 때 
		
		
		B b = new B();
		a1.abc(b, 7);
		a2.abc(b, 8);
		a3.abc(b, 9);
		
		
		
		
		
		
	}

}

package chap13.Ex10.Ex1;


class A {
	B b; // B : 인터페이스 타입, b : 참조변수 : 값을 할당 하는 방법
			//b : null
				//1. 객체생성후 값을 할당.
				//2. 생성자를 통해서 값을 할당.
				//3. setter를 통해서 값을 할당.
	A(){} //기본생성자
	A(B b){
		this.b = b;
	}
	
	
	public void setB(B b) {
		this.b = b;
	}
	
	interface B {
		void play();
		void stop();
	}
	
	void abc () {	//play() 재정의, stop() 재정의
		b.play();
		b.stop();
	}
}
public class InnerInterface_1_2 {

	public static void main(String[] args) {
		//3. setter를 통해서 값을 할당
		A a = new A();
		a.setB(new A.B() {
			
			@Override
			public void stop() {
				System.out.println("play");
			}
			
			@Override
			public void play() {
				System.out.println("stop");
			}
		});
		a.abc();
		
		System.out.println("==============");
		//1. 객체 생성후 필드의 값을 할당.
		A a1 = new A();
		a1.b = (A.B) new A.B() {//인터페이스 : A.B
			public void play() {System.out.println("짹짹");};
			public void stop() {System.out.println("새는 하늘을 납니다.");};
		}; 
		
		a.abc();
		System.out.println("==================");
		//2. 생성자를 이용해서 값을 할당
		A a2 = new A(
				new A.B() {
					@Override
					public void stop() {
						System.out.println("어흥 중지");
					}
					
					@Override
					public void play() {
						System.out.println("어흥 실행");
					}
				}
				
				
				);		//생성자 내부에 A.B 타입의 객체 생성후 주입
		
		a2.abc();
		
	}
}

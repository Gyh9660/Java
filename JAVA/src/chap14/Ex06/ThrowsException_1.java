package chap14.Ex06;
/*
 * 
 * 예외 처리 2가지 방법:
 * 		1. 직접 처리 :try catch
 * 		2. 예외 전가(미룬다) :throws ,메소드를 호출하는 쪽에서 예외를 처리 하도록 전가(미룬다)
 * 			throw : 강제로 예외를 발생시킨다. 
 */

class A{
	void abc() { //메소드 내부에서 예외처리를 직접 구현
		bcd();
	}
	void bcd() {
		
		try {
			Thread.sleep(1000);//일반 예외 : try catch InterruptedException
		} catch (InterruptedException e) {
			
			//e.printStackTrace();
			System.out.println("예외발생 1");
			
		} 
	}
}

class B {
	void abc() {
		try {	//bcd()메소드의 예외를 처리할 의미를 가진다.
			bcd(); //
		} catch (InterruptedException e) {
			//e.printStackTrace();
			System.out.println("예외발생 2");
		}
	}
	void bcd() throws InterruptedException { //bcd()메소드를 호출하는 쪽에서 예외를 처리하도록 미룬다
		Thread.sleep(1000);		//일반 예외 : try catch InterruptedException			
		
	}
}





public class ThrowsException_1 {

	public static void main(String[] args) {

		A a1 = new A();
		a1.abc();
		
		B b1 = new B();
		b1.abc();
		
		
		
	}

}

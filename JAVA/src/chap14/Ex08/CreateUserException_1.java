package chap14.Ex08;
//사용자 정의 예외
//	1. Exception을 상속하는 예외(일반예외) Checked Exception-컴파일단계에서 예외처리 필요
//	2. RunTimeException을 상속하는 예외(실행예외):UnChecked Exception,Runtime Exception - 실행시에 예외가 발생


class MyExceptin extends Exception{ //일반 예외
	public MyExceptin ( ) { //기본 생성자 
		super();
	}
	public MyExceptin(String message){ //예외 메세지 출력시 사용. 
		super(message);
	}
		
}
class MyRTException extends RuntimeException { //실행 예외
	public MyRTException() { //기본 생성자
		super();
	}
	public MyRTException(String message) {//예외 발생시 메세지를 출력해주는 생성자
		super(message);
	}
}

class A {
	//사용자 정의 예외 객체 생성 (일반 예외 객체)
	MyExceptin me1 = new MyExceptin(); //기본 생성자 호출
	MyExceptin me2 = new MyExceptin("예외 메세지 : MyException");
			//예외가 발생시 예외 메세지를 출력 하는 생성자.
	//2. 런타임 예외 객체
	MyRTException mre1 = new MyRTException();// 기본 생성자
	MyRTException mre2 = new MyRTException("예외 메세지 : MyRTExe");
	
	//예외를 강제로 발생시키기 (throw) :
	void abc_1(int num) {
		try {
			
			if (num > 70) {  //abc_1(숫자)
				System.out.println("정상 작동");
			}else {
				throw me1; //예외를 강제로 발생시킴
			}
			
		}catch (MyExceptin e) { //me1에 강제로 throw를 사용해서 강제로 예외를 발생시킨다.
			System.out.println("70이하 값을 넣었습니다. 70이상 값을 넣으세요.");
			System.out.println(e.getMessage());
		}
		
	}
	//예외의 전가 (throws) : abc_2() 메소드를 호출하는 곳에서 예외 처리
	void abc_2(int num) throws MyExceptin {
		if (num>70) {
			System.out.println("정상 작동");
		}else {
			throw me2; //강제로 예외를 발생 (throw)
		}
	}
	
	void bcd_1() {
		abc_1(65); //예외가 발생
	}
	void bce_2() {
		try {
			abc_2(65);
		} catch (MyExceptin e) {
			System.out.println("70이상 값을 넣으세요");
			System.out.println(e.getMessage());
		}
		
	}
	
	
}


public class CreateUserException_1 {

	public static void main(String[] args) {
		A a = new A();
		a.bcd_1();			//예외를 직접 구현,
		a.bce_2(); 			//throws로 예외 전가를 시킴 (호출하는쪽에서 예외 처리)
		
		
		
	}

}

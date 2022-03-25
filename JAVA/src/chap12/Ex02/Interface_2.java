package chap12.Ex02;


//interface 구현한 클래스 ,
	//Overriding : 완전한 메소드를 새로정의하는 것
	//Implements : 미완성 메소드를 완성시키는 것.
	//extends : 부모클래스의 기능을 상속받아서  자신의 기능을 추가해서 확장

interface AA {

	void cry(); //추상(미완성) 메소드, public abstract 생략
	
	void run(); //추상(미완성) 메소드, public abstract 생략
}


class BB implements AA{//BB클래스는 AA인터페이스의 미완성된 메소드를 구현 한다.

	@Override
	public void cry() {
		System.out.println("야옹");
	}

	@Override
	public void run() {
		 System.out.println("펄쩍");
	} 
	
}


public class Interface_2 {

	public static void main(String[] args) {
		//
		AA aa = new BB(); //BB : 인터페이스의 미완성메소드를 구현한 클래스
		aa.cry();
		aa.run();
		
		
		
		
	}

}

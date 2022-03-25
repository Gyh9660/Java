package chap06_07.Ex05;

import chap06_07.Ex06.Bcd; // ctrl + shift + o : 자동 import

//import chap06_07.Ex06.Abc; //Abc 클래스에  접근제한자가 default : 외부 패키지에서 접근 불가

public class External_Abc extends Bcd{ // External_Abc(자식)클래스는 Bcd(부모)클래스를 상속하겠다
		//부모 클래스 : Bcd, 자식 클래스 : External_ABc

	
	
	public static void main(String[] args) {

	//	Abc abc2 = new Abc(); //class 접근 제어자가 default여서 접근불가
		Bcd bcd1 = new Bcd(); // 부모 클래스 객체
		External_Abc ext = new External_Abc(); //자식클래스
		//다른 패키지에서 필드 호출 : 1. import(public:클래스 접근 지정자), 
		//2. 객체 생성, 3.접근 지정자 확인후 접근( 필드, 메소드)
		
			bcd1.a = 1000; //public : 다른 패키지에서 접근 가능
			ext.b = 2000; //protected : 다른패키지에서 상속 관계에 잇을 때 접근가능
			//자식 클래스에서 부모 클래스의 protected를 다른패키지에서 접근(상속 관계)
			System.out.println(ext.b);
	
	
	}
			
		
		
		


}

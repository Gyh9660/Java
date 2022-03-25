package chap06_07.Ex06;

//import chap06_07.Ex05.B; //default 이기 떄문에 외부(다른패키지의 클래스)에서 임포트가 안됨 
					//class B는 클래스 접근 제어자가 default이므로 다른패키지에서 접근불가

import chap06_07.Ex05.Bb; //다른 패키지의 클래스에서(클래스를 호출 할 떄) import되기 위해서는 public(접근제한자)키가 들어가있어야함

public class ExternalClass_2 {

	public static void main(String[] args) {

		//B b = new B();
		
		// 다른 패키지의 클래스에서 Bb클래스를 접근 하는경우
			//1. import 를 먼저해야한다.
			//2. Bb 클래스의  클래스 접근제한자는 public가 들어가 있어야한다.
			//3. 필드, 메소드의 접근 제한자에 따라서 접근이 가능(protected{다른 패키지일때 상속관계에 있을때만 접근가능},public), 불가능 (private, default)
		
		Bb bb = new Bb(); //다른 패키지의 클래스 : 1. 클래스 접근 제어자에 public
		
		
		// <<필드 접근>>
		
		//bb.a = 10; // <오류발생> 접근불가능 private : 같은클래스 내에서만 접근가능
		//bb.b = 20; // <오류발생> 접근불가능 default : 같은패키지 내에서만 접근가능
		//bb.c = 30; // <오류발생> 접근불가능 protected : 다른패키지는 상속관계여야 접근가능
												//default 포함 
		bb.d = 40; // public 접근가능 : protected 포함 + 다른패키지 접근가능
		
		
		//<<메소드 접근>>
		//bb.print1(); //<오류발생> 접근불가능 private
		//bb.print2(); //<오류발생> 접근불가능 default
		//bb.print3(); //<오류발생> 접근불가능 protected : 외부의 다른 패키지에서 접근 하려면 상속 관계가 필요.
		bb.print4(); //접근 가능 public
		
	}

}

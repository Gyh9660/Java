package chap06_07.Ex06;

import chap06_07.Ex05.A;

public class Ex_A {

	public static void main(String[] args) {

		
		//다른 패키지의 객체를 사용하는 방법 :
		//그냥 A a = new A();는 default이기 떄문에 다른패키지에서 접근 불가
			// 1. 전체 클래스이름을 사용하는 방법
		chap06_07.Ex05.A a = new chap06_07.Ex05.A(); //클래스의 전체이름을 사용
													//패키지명.클래스명
		//a.m=10;//접근 불가 :default는 다른패키지 클래스에서는 접근이 불가,
		a.k=50; //public 이 들어가있음: 다른 패키지의 클래스에서 접근 가능

		a.print2(); //public 이 들어가있음: 다른 패키지의 클래스에서 접근 가능
		
			//2. import를 사용해서 접근하는 방법
		
		A aa = new A(); //import 후 사용하는 방법
		aa.k = 100;
		aa.print2(); //public : 다른 패키지의 클래스에서 접근 가능
		
		
	}

}

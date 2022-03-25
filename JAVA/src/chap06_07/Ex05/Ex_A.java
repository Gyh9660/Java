package chap06_07.Ex05;

//같은 패키지 내에서 A class로 접근

public class Ex_A {

	public static void main(String[] args) {
		//A class는 같은 패키지 내부에 존재 하므로 import 를 사용하지 않고 사용.
		
		A a = new A(); //import 없이 사용: 같은패키지 내에 A class가 존재하기 떄문에
		
		a.m = 10; // A class의 접근 제어자가, default로 되어있기 때문에 접근 가능
		a.n = 20;
		
		a.print(); // default 접근 제어자 이므로 접근 가능
		
	}

}

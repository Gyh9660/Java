package chap06_07.Ex04;
/*
 * 묵시적 this keyword 자동 추가
 * 1. 클래스 내부에서 필드, 메소드 이름앞에 자동으로 this 키워드가 붙음.
 * 		this 키는 자기자신의 객체의 필드와 객체의 메소드를 지칭,
 */
class A{
	int m;
	int n;
	
	//A(){} //기본 생성자가 생략됨
	
	void init (int a,int b) { // a, b, c는 지역변수(메소드내에서만 사용) Stack 영역에 변수면과 값을 가짐
		int c;	//init() 메소드 생성시, stack안에 a,b,c가 생성되고 메소드 끝날시 메모리에서 소멸
		c = 3;
		this.m =a; //this 키를 생략시, 컴파일러가 자동으로 추가
		this.n =b; //this 키를 생략시, 컴파일러가 자동으로 추가
	}
	void work() {
		this.init(2, 3); //this 키를 생략시, 컴파일러가 자동으로 추가
		System.out.println(this.m +","+ this.n );//this는 생략 가능, 생략시 컴파일러가 자동으로 추가
	}
}

public class ThisKeyword_1 {

	public static void main(String[] args) {
		//2. 객체 생성
		A a = new A();
		
		//3. 메소드 호출
		a.work();
		
	}

}

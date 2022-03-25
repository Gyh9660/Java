package chap10.EX;
//1 생성자는 클래스명과 같아야한다. /리턴 타입이 없어야한다
class A{
	int m =2;
	static int n = 4;
	void method1() {
		System.out.println("AI");
		
	}
	static void method2() {
		System.out.println("AS");
	}
}

class B extends A{
	int m =6;
	static int n = 8;
	void method1() {
		System.out.println("BI");
	}
	static void method2() {
		System.out.println("BS");
	}
}
public class Ex {

	public static void main(String[] args) {
	
		A ab = new B();
		System.out.println(ab.m);
		System.out.println(ab.n);
		ab.method1();
		ab.method2();
	}

}

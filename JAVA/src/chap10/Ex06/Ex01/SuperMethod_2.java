package chap10.Ex06.Ex01;

//자식 객체를 생성할대 부모클래스의 기본 생성자를 먼저 호출 : super()
//모든 자식 객체의 생성자에는 super()가 생략되어 있다.



class A {
	
	A(){
		System.out.println("A class의 기본 생성자");
	}
	
	A(int a){
		System.out.println("A class의 매개변수 정수 1 생성자 : "+ a);
	}
	A(int a, int b){
		System.out.println("A class 매개변수 정수 2 생성자 : " +a + " , "+ b);
	}
}

class B extends A{
	B(){
		super();
		System.out.println("B class의 기본 생성자");
	}
	B(String a){
		super(3, 5);
		System.out.println("B class의 문자열 1 입력 : " + a );
	}
}

class C extends B{
	C(){
		super("c에서 호출");
		System.out.println("C class의 기본 생성자 ");
	}
}
public class SuperMethod_2 {

	public static void main(String[] args) {
		C c = new C();
		
		
		
	}

}

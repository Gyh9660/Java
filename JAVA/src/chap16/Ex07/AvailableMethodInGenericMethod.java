package chap16.Ex07;

//제네릭 메소드 내부에서 사용 가능한 메소드 : Object 클래스의 메소드만 사용 가능하다.

class A{
	public <T> void method(T t) {
		//System.out.println(t.length());		//t.length() : String 클래스에서 글자수를 리턴해줌
												//사용불가 //오류발생
		System.out.println(t.equals("안녕"));  	//t.equals는 Object클래스의 메소드는 사용가능
	}		
	public <T extends Object> void method2 (T t){ //그냥 T라고 선언하면 extends  Object 가 생략되었다 T [extends Object]
		System.out.println("반갑습니다."); //사용 가능하다. Object클래스의 메소드만 사용가능하다
		//System.out.println(t.);
		
	}
	public <T extends String> void method3 (T t) {
		System.out.println(t.length());
		//System.out.println(t.);
	}
}

public class AvailableMethodInGenericMethod {

	public static void main(String[] args) {
		A a = new A();
		a.<String>method("안녕");
		
		
		
	}

}

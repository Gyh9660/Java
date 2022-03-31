package chap16.Ex07;

//제네릭 클래스 : 클래스 선언할때 타입 변수를 선언 <T> <<정의>>. 객체를 생성시 T에 적용할 타입을 지정

//제네릭 메소드 : 일반 클래스 내부의 메소드 선언시 제너릭 타입 변수를 사용.

class Genericmethod { //일반 클래스
	
	public <T> T method1 (T t) {		//제너릭 메소드 : 타입 1개 <T 리턴타입 ex)String> T[String]
		return t;
	}
	
	public <T> boolean method2 (T t1, T t2) { //제너릭 메소드 : 타입 1개
		return t1.equals(t2); //두값을 비교해서 true / false를 리턴
								//기본 자료형일때는 값을 비교, 참조자료형 일때는 객체의 주소를 비교
								//String일 경우 특수해서 equals가 재정의되어 있어서 값을 비교
								//Integer,Double equals가 재정의 되어있다.
		
	}
	
	public <K, V> void method3 (K k, V v) { //제너릭 메소드 : 타입 2개
		System.out.println(k+" : "+v);
	}
	
	public <K, V> void method4 () {
		System.out.println("매개변수가 인풋값으로 없는 경우 생략시 오류발생");
	}
}


public class GerneriMethod {

	public static void main(String[] args) {

		//1. 일반 클래스 객체 생성후 제너릭 메소드 호출
		Genericmethod gm = new Genericmethod();
		String str1 = gm.<String>method1("안녕");
		String str2 = gm.method1("안녕");		//타입을 알수 있는 경우 호출할때 생략가능 (매개변수로 값이 들어갈때)
		System.out.println(str1);
		System.out.println(str2);
		System.out.println("===================");
		
		Integer i = gm.<Integer>method1(100);
		Integer i2 = gm.<Integer>method1(200);
		System.out.println(i);
		System.out.println(i2);
		System.out.println("==================");
		
		Boolean b1 = gm.<Boolean>method1(true);
		Boolean b2 = gm.<Boolean>method1(false);
		System.out.println(b1);
		System.out.println(b2);
		System.out.println("==================");
		
		Boolean d1 = gm.<Double>method2(2.55,2.55); //리턴받을 타입이 Boolean
		Boolean d2 = gm.<Double>method2(32.55,2.55); //리턴받을 타입이 Boolean
		System.out.println(d1);
		System.out.println(d2);
		System.out.println("==================");
		
		gm.<String, Integer>method3("국어", 90);
		gm.method3("영어", 80); //매개변수로 인풋되는 데이터 타입을 추정할 수 있는 경우 생략 가능
		
		gm.<Integer, String>method3(500,"서버 에러 입니다.");
		gm.method3(402, "파일을 찾을 수 없습니다.");
		System.out.println("===================");
		
		gm.method4();
		
	}

}

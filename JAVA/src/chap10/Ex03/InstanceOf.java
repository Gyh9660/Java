package chap10.Ex03;

//instanceof : 객체 내부의 캐스팅이 가능한지 가능여부를 알수있도록 하는 키워드
	//업캐스팅한 객체 내부에 어떤 타입이 존재하는지 True 또는 False로 리턴
	//다운 캐스팅시 런타임 오류가 발생할수있다. 런타임 오류를 방지 시켜준다.
	//다운 캐스팅시 해당타입이 객체에 존재할때 다운캐스팅 하도록 설정



class A{
	int m;
	void a() {
		System.out.println("m : " +m);
	}
}

class B extends A{
	int n;
	void b() {
		System.out.println("n : "+ n);
	}
}


public class InstanceOf {

	public static void main(String[] args) {

		//1. instanceof : 객체명 instanceof 타입 결과 true/ false
		
		A aa = new A(); //aa는 A타입만 가지고있다.
		A ab = new B(); //ab는 A,B 포합하고, A만 사용가능(접근)
		
		System.out.println( aa instanceof A); //true
		System.out.println( ab instanceof A); //true
		System.out.println( aa instanceof B); //false
		System.out.println( ab instanceof B); //true
		
		if ( aa instanceof B) { //aa 객체에 B타입이 포함되어있을경우에만 캐스팅을한다.
			B b = (B)aa; //런타임시 오류방지목적
			System.out.println("aa를 B로 캐스팅 했습니다.");
		}else {
			System.out.println("aa는 B타입으로 캐스팅 불가");
		}
		
		if ( ab instanceof B ) { //ab에 B타입이 존재하는 경우 다운캐스팅
			B b = (B)ab;
			System.out.println("ab를 B타입으로 캐스팅 했습니다.");
		}else {
			System.out.println("ab는 B타입으로 캐스팅 불가");
		}
		
		if("안녕" instanceof String) { //객체의 데이터타입을 확인
			System.out.println("\"안녕\"은 String 클래스 입니다.");
		}else {
			System.out.println("\"안녕\"은 String 클래스가 아닙니다.");
		}
		
	}

}

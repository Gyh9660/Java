package chap06_07.Ex02;

class B {
	static String name = "BTS"; //변수나 메소드앞에 static를 넣을수있음 //변수
	
	static void print () { //메소드 // static키가 할당이 되면 객체 생성없이 호출
		System.out.println(name);
		System.out.println("static 이 붙은 메소드 입니다.");
	}
	
}


public class MethodOverloading {

	public static void main(String[] args) {
		//면접에서 질문많이함
		//메소드 오버로딩 : 하나의 메소드명에 매개변수타입과 갯수에 따라서 각각 다른 메소드가 호출됨 ( Java )
		//메소드 오버라이딩 : 상속에서 부모 클래스의 메소드를 재정의 해서 사용
		
		//static : 객체 생성 없이 바로 호출해서 사용가능하도록 할 수 있는 키워드
			//객체이름이 아니라 클래스 이름으로 호출해서 사용가능
		
		// static가 있으면 객체생성안해도 바로 호출가능
		
		System.out.println(B.name); //객체이름이 아닌 클래스 이름으로 호출
		B.print();					//클래스 이름으로 호출
		
		System.out.println("================");
		
		print1(); //static 키가 들어가 있고 동일한 클래스에 생성된 메소드는 바로 호출 가능
		print1(3); //매개변수가 1개이고 정수타입의 메소드를 호출
		print1(30.8); // 매개변수가 1개이고 double 타입의 메소드 호출
		print1(2,5); // 매개변수가 2개이고 정수(int), 정수(int)타입의 메소드를 호출
		
		
	}//여기까지 메인메소드
	
		//메소드 오버라이딩 : 메소드 이름은 동일하나 매개변수타입, 매개변수 개수에 따라 해당 메소드를호출
			//JVM이 동일한 메소드 이름의 데이터 타입이나 갯수에 따라서 해당 메소드를 작동
				//주의: 동일한 매개변수 타입과 갯수가 같으면 오류를 발생시킴
	
	public static void print1() { //메소드 이름 앞에 static: 객체생성없이 바로호출
			System.out.println("데이터가 없습니다.");
		
		}
		public static void print1 (int a) {
			System.out.println("정수:" + a);
		}
		public static void print1 (double a) {
			System.out.println("double : " + a);
		}
		/* 오류발생 : 동일한 데이터 타입, 갯수도 동일한 메소드가 존재하는경우
		public static void print1(double k, double g) { 
		//매개변수가 1, 데이터 타입이 double 
			System.out.println("double : " + k + g);
		// 동일한 매개변수타입과 매개변수 개수에 의해 오류발생 둘다 동일해야 오류발생
		}
		*/
		
		public static void print1 (int a, int b) {
			System.out.println("a : " + a + "\nb : "+ b);
		}
		/*오류발생
		public static void print1(int c, int d) {
			System.out.println(c + d);
		}
		*/
		
		
		
}

package chap06_07.Ex06;

class S{
	int m = 3; //필드(인스턴스 필드): 객체를 생성후에 사용 가능 //stack메모리의 a가 100번지(힙역역)를 가르키고 m은변수명과 값이 heap에 저장 n은 힙에주소값이? 있고A클래스영역을 가르킴 실제값은 A클래스영역에 저장 n은 클래스영역에 위치해있기떄문에 A.n으로 호출이 가능하다
	static int n = 4;
 //필드 (static 필드): 객체를 생성하지 않아도 사용 가능
									 //객체 생성후에도 사용이 가능
									//모든 객체가 공유하는 변수			
	void print1() { //메소드 (인스턴스 메소드):객체를 생성후 호출 가능
		//인스턴스 필드와,static 필드가 올수 있다.
		System.out.println("인스턴스 메소드 출력"+ "m :" + m+ "," +"n :"+  n );
	}
	
	static void print2() {//메소드 (static 메소드) :객체 생성없이 호출 가능, 객체생성후에도 호출가능
		//static 메소드에서는 인스턴스 필드는 올 수 없다
		//static 메소드는 객체생성없이 호출이 되므로 인스턴스 필드가 올수없다.
		
		System.out.println("static 메소드 출력"+"n : "+ n);
	}
}
public class Static_1 {

	public static void main(String[] args) {

		//1. 객체 생성후 필드와 메소드 호출(인스턴스 필드,static 필드, 인스턴스 메소드 static메소드)모두호출
		S s = new S();
		s.m = 10; //인스턴스 필드 호출
		s.n = 20; //static 필드 호출
		s.print1(); //인스턴스 메소드 호출
		s.print2(); //static 메소드 호출
		
		//2. 객체 생성없이 클래스 명으로 static필드와 static메소드 호출(static 필드와 static메소드만 호출 이가능)
		s.n = 100; // static 필드 :클래스 명으로 호출됨
		s.print2();// static 메소드 : 클래스ㅡ 명ㅇ로 호출됨
		
		S bbb = new S();
		System.out.println(bbb.n); //100
		
		S ccc = new S();
		System.out.println(ccc.n); //100
		
		S ddd = new S();
		System.out.println(ddd.n); //100
		
		S eee= new S();
		System.out.println(eee.n); //100
		
		eee.n=300;
		System.out.println("=======static 필드가 적용된 필드는 모든 객체에서 공통으로 바라보는 변수=======");
		
		System.out.println(s.n);
		System.out.println(bbb.n);
		System.out.println(ccc.n);
		System.out.println(ddd.n);
		System.out.println(eee.n);
		
		
		
		
	}

}

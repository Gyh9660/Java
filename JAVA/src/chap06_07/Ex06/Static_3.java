package chap06_07.Ex06;

//정적 초기화 블록 : 생성자와 같이 static 필드의 값을 초기화하는 역할

//생성자와 static 블럭:
	// - 생성자 : 인스턴스 필드를 초기화, 정적 필드의 값도 초기화
	// - static 블럭: static 필드의 값을 초기화, 인스턴스 필드의 값은 초기화 할수없다.
	/*
	 * Java에서 초기화 뜻은?

선언한 객체에 최초로 값을 넣어주는 것
자바에서 초기화 하는 이유는?
클래스 영역에서 선언할 경우에는
컴파일러가 자동으로 값 할당을 해주나
메소드 영역에서 선언할 경우에는
자동으로 값이 할당되지 않기 때문에
에러가 발생해서 그렇다
	 */
class E{
	
	int a;
	static int b; //객체 생성 없이도 호출
	static int c = 10;
	static { //정적(static) 초기화 블럭:객체 생성 없이 클래스 명으로 호출할때 초기화
		//a=3 ; //오류가 발생, 인스턴스 필드는 초기화 할수 없다.
		b = 5;
		System.out.println("클래스 E가 로딩되었습니다. 변수 b : "+b );
	}
	E(){		//생성자 : 객체화를 할때 필드의 값을 초기화
		a=3;	//인스턴스 필드 초기화
		b=10;	//static 필드 초기화
	}
}

public class Static_3 {

	public static void main(String[] args) {
		System.out.println(E.b); //객체 생성없이 E.b로 호출 될때 static 블락이 작동된다.(생성자 호출과같다)
		E e = new E();
		System.out.println(e.a);
		System.out.println(E.c);
		System.out.println(e.c);
	}

}

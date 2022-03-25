package chap12.Ex02;

//인터 페이스 (interface) : 외부와 내부를 연결 시켜주는 접점..(콘센트)=>[외부전기장치 >>콘센트 << 전기]
					//리모콘 (사람, TV 연결 중간자) , API 
//객체 생성불가, 타입은 설정 가능
// 모든 필드는 반드시 : public static final 생략
// 모든 메소드는 : public abstract 생략


interface A {		//정식 표현
	public static final int A = 3;	//인터페이스 필드의 정식 표현
	public abstract void abc();		//인터페이스 메소드의 정식 표현
	
}
interface B{	//생략된 구현
	int A =3;
	void abc();	//추상 메소드 :
}

abstract class C{	//추상 클래스 일떄는 abstract는 생략될수 없다.
	abstract void abc(); { //생략시 오류 발생
		
	}
}


public class Interface_1 {

	public static void main(String[] args) {
		
		
		//인터페이스는 객체 생성 불가.
		//A a new A(); //A가 인터페이스라 객체 생성불가
		//1. interface의 static 필드의 내용을 출력
		
		System.out.println(A.A); //인터페이스의 필드 출력, A<== static가 들어가있어서 이름으로 출력 가능
		System.out.println(B.A);
		//2. final 이 적용되어 있기 때문에 값을 수정불가
		//A.A =5; //final이 설정되어 있기 때문에 값을 수정 불가
		//B.A =6;
		
		
		
	}

}

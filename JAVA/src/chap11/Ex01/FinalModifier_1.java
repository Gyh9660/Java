package chap11.Ex01;

/*
 *  Final : 마지막
 *  	- 필드명, 지역변수명 앞에 : 상수 , final double PI = 3.14;
 *  			: 상수는 값을 변경할 수 없다.
 *  			: 상수 영역에 값이 복사 , 객체나 메소드가 사라질 경우에도 호출이 가능
 *  
 *  	- 메소드명 : 오버라이딩이 불가한 메소드 (부모 클래스에서 자식 클래스에서 메소드 오버라이딩이 불가하도록)
 *  			: final void print (){}
 *  	- 클래스명 : 상속이 불가한 클래스
 *  			: final class A {}  <== 자식클래스를 두지 않는 마지막 클래스
 */	

class A1 {
	int a = 3;		//필드명, 지역변수명 = 소문자를 사용, 여러문자를 이어질경우 이어지는 첫자 대문자
	final int B= 5; //final은 일반적으로 변수 대문자, 상수명 대문자로 사용, 값을 변경 할수 없다.
	
}
class A2 {
	int a;
	final int B;
	A2(){
		a = 3;
		B = 5;
	}
}
class A3 {
	int a =3;		//필드 : 값을 변경
	final int b =5;	//상수 : 값을 변경 불가
	A3(){
		a= 5;
	//	b= 10; //[오 류 발 생] Final은 값을 변경할수없다.
	}
}
class B {
	void bcd() {			//지역 변수 : 메소드에서 선언한 변수 (메소드 호출이 끝나면 지역변수는 사라짐)
		int a =3;		//스택 공간에 변수의 값이 할당. 메소드 호출이 끝나면 사라짐
		final int B = 5;	//상수는 클래스 영역의 상수영역에 복사, 메소드가 사라져도 상수영역에 남아있음
		a=7;
		//B=9; //final은 값을 변경할수 없다. [ 오 류 발 생 ] 상수
	}
}

public class FinalModifier_1 {

	public static void main(String[] args) {

		
		
	}

}

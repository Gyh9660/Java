package chap18.Ex07;

interface A{
	int abc (String str);
}



public class RefOfInstanceMethod_Type_2_2 {

	public static void main(String[] args) {
		
		//인스턴스 메소드 참조 Type2 : 정적메소드
		//1. 익명이너클래스
		A a1 = new A() {
			@Override
			public int abc(String str) {
				return str.length();
			}
		};
		
		//2. 람다식 표현
		A a2 = (str)-> {return str.length();};
		
		
		//3. 인스턴스 메소드 참조 Type 2
		A a3= String::length;	//String::length 객체명::메소드 호출
		
		System.out.println(a1.abc("안녕"));
		System.out.println(a2.abc("안녕하세요"));
		System.out.println(a3.abc("안녕하세요 반갑습니다"));
	}

}

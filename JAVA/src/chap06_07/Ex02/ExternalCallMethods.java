package chap06_07.Ex02;

//면접에서 자주질문함
//메소드 오버로딩 : 하나의 메소드명에 매개변수타입과 갯수에 따라서 각각 다른 메소드가 호출됨 ( Java )
//메소드 오버라이딩 : 상속에서 부모 클래스의 메소드를 재정의 해서 사용

//소스안에 class A를 만들떄 같은패키지안에 claas A가있으면 오류가남 
	
// 다양한 타입의 메소드(리턴 타입이 있는 경우[int,double,String......],
					//리턴타입이 없는 경우는 void 키를 사용
public class ExternalCallMethods {

	public static void main(String[] args) {
		//객체생성
		A a = new A(); //같은 패키지 내의 클래스는 import없이 호출해서 사용가능
						//다른 패키지라면 import해줘야함
		//메소드 호출 
		a.print(); //A클래스가 다른패키지에 있어서 오류가 발생한다면 public넣어줘야함 앞에
		System.out.println("=======");
		
		int k = a.data(); //3
		System.out.println(k);	
		System.out.println("======");
		
		double result = a.sum(3, 5.2);
		System.out.println(result);
		System.out.println("======");
		
		a.pringMethod(5); // 1 ~ 12 사이의 값
		a.pringMethod(13); // 1 ~12 를 벗어난 값
		
		//주의 :
		
		System.out.println(a.data()); //출력구문에서 호출 가능한 메소드 (리턴이 있는 메소드)
		//System.out.println(a.print()); // a.print 메소드안에 리턴이없고 실행코드,
										//출력구문이 이미 있기때문에 오류발생
		a.print();
		System.out.println(a.sum(4, 10.5));
		//System.out.println(a.pringMethod(3)); //오류 발생
		
		a.pringMethod(3);
		
		
		
		
	}

}

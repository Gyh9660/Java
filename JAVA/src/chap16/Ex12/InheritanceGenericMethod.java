package chap16.Ex12;

//제너릭 메소드의 상속 : 일반 클래스 내의 제너릭 메소드

class Parent {	//일반 클래스
	
	//Number : Charter, Boolean를 제외한 Wrapper(기본 데이터 타입을 객체형 데이터 타입으로 변환)타입의 클래스가 올 수 있다. 
			//Byte,Short,Integer,Long,Float,Double
	
	<T extends Number> void print(T t) { //제너릭메소드
		System.out.println(t);
	}
}

class Child extends Parent{ //제너릭 메소드 상속은 일반 상속과 같다.
	
}

public class InheritanceGenericMethod {

	public static void main(String[] args) {
		//1. 부모 클래스의 제너릭 메소드 사용
		Parent p = new Parent();
		p.<Integer>print(100);
		p.<Double>print(100.2345);
		//p.<String>print("안녕");//오류 발생, Number만 들어갈 수 있다.
		p.print(300); //매개변수로 들어가는 값의 타입을 알수있는 경우 생략 가능
		p.print(300.3333);
		
		
		System.out.println("========================");
		//2. 자식 클래스에서 제네릭 메소드 사용
		Child c = new Child();
		c.<Integer>print(200);
		c.<Double>print(200.12345);
		
		
		
		
	}

}

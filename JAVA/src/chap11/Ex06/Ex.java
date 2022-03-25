package chap11.Ex06;

abstract class Animal2{ //추상 클래스 : 추상 메소드가 하나이상 포함되어있는 경우
	//추상 클래스는 객체 생성 불가, 타입은 사용 가능
	//자식클래스는 부모 클래스의 메소드를 구현시 오류를 방지
	//추상 클래스는 추상 클래스 내의 추상메소드를 자식 클래스에서 반드시 구현하도록 보장받는다
String name;
int age;

abstract void cry(); //추상 메소드 : 구현부가 없느 메소드
//void cry() {} <==일단 메소드 : 리턴타입 메소드이름 (입력매개변수) {구현코드}
abstract void run();

	@Override
		public String toString() { //객체 자체를 출력시 메모리의 정보를 출력
			return "이름 : " + name + " , 나이 :" + age;
		}
}
class Cat2 extends Animal2{ //Cat은 Animal 상속 (일부만 상속한 경우)
							//모두 추상 메소드를 구현한 경우는 콘크리트 클래스가 된다.
	Cat2(String name, int age){
		super.name = name;
		super.age = age;
	}
	@Override
	void cry() { //추상 메소드를 구현한 메소드
		System.out.println("야옹");
	}
	
	@Override
	void run() {
		System.out.println("고양이는 껑충하고 뜁니다.");
	}
	
}

class Tiger2 extends Animal2{

	Tiger2(String name, int age){
		super.name = name;
		super.age = age;
	}
	@Override
	void cry() {
		System.out.println("어흥");
	}

	@Override
	void run() {
		System.out.println("호랑이는 힘차게 달립니다.");
	}
	
}

class Eagle2 extends Animal2{

	Eagle2(String name, int age){
		super.name = name;
		super.age = age;
	}
	@Override
	void cry() {
		System.out.println("끼오 하고 웁니다.");
	}

	@Override
	void run() {
		System.out.println("독수리는 납니다");
	}
	
}
public class Ex {

	public static void main(String[] args) {
		
		
		Animal2 a1 = new Cat2("고양이",10);
		Animal2 a2 = new Tiger2("호랑이",5);
		Animal2 a3 = new Eagle2("독수리",15);

		//1. Animal2 배열 객체에 저장
		Animal2[] arr1 = {a1,a2,a3};
		
		//2. For 문을 사용해서 객체를 출력시 이름과 나이를 출력, cry와 run메소드 출력
		for (int i=0; i<arr1.length; i++) {
			System.out.println(arr1[i]); //객체 출력 ,Animal2의 toString() 출력
			arr1[i].cry(); //객체의 오버라이딩된 메소드출력
			arr1[i].run(); //Animal의 cry(), run() 출력==>오버라이딩 (자식의 cry와 run호출)
			System.out.println("===================");
		}
			System.out.println();
			System.out.println();
		
		//3. Enhanced For 문을 사용해서 이름과 나이를 출력, cry() , run()
		for( Animal2 k : arr1) {
			System.out.println(k);
			k.cry();
			k.run();
			System.out.println("=====================");
		}
	}

}

package chap11.Ex04;


//추상 클래스를 사용하지 않는 경우 :
	//자식클래스에서 메소드 오버 라이딩 시 오버라이딩이 오타를 통해 잘못 구현 될 수 있다.

class Animal {
	void cry() {}		//팀장이 cry() 정의해주고 구현은 팀원에게 위임.
}

class Cat extends Animal {
	void cRy() {				//오버라이딩이 아닌 자식클래스에서 새롭게 정의된 메소드
		System.out.println("야옹");
	}
}

class Dog extends Animal {
	void Cry() {
		System.out.println("멍멍");
	}
}


public class AbstractModifier_2 {

	public static void main(String[] args) {

		//1. 객체생성
		Animal a1 = new Cat();
		Animal a2 = new Dog();
		
		//2. 메소드 호출
		a1.cry(); //오타로인해 제대로 호출이 안됨
		a2.cry();
	}

}

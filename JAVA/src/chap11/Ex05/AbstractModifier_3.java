package chap11.Ex05;

//추상 클래스를 사용해서 기능 구현 하는 경우
abstract class Animal{	//추상 클래스 : 추상메소드가 하나이상 포함되어있는 클래스
	abstract void cry(); //추상 메소드 : 선언만 되어있고 구현이 없는 메소드
}

class Cat extends Animal{
	@Override
	void cry() {
		System.out.println("야옹");
	}
}

class Dog extends Animal{
	@Override
	void cry() {
		System.out.println("멍멍");
	}
}

public class AbstractModifier_3 {

	public static void main(String[] args) {

		Animal a1 = new Cat(); // 추상클래스는 타입으로는 지정될수있다.
		Animal a2 = new Dog();
		
		a1.cry();
		a2.cry();
		
		//추상 클래스는 객채화 할 수 없다.
		
		//Animal a3 = new Animal(); //추상 클래스는 객체화 될 수 없다.
	}

}

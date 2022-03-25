package chap10.Ex04;

//메소드 오버라이딩

class Animal {
	void cry() {
		
	}
}

class Bird extends Animal{
	@Override
	void cry() {
		System.out.println("짹쨱");
	}
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




public class MethodOverriding_1 {

	public static void main(String[] args) {
		//1. 각각의 타입으로 선언 + 각각의 타입으로 생성.
		Animal aa = new Animal(); //Animal 클래스의 cry()
		Bird bb = new Bird();	//Bird 클래스의 cry()
		Cat cc = new Cat();		//Cat 클래스의 cry()
		Dog dd = new Dog();		//Dog 클래스의 cry()
			aa.cry();
			bb.cry();
			cc.cry();
			dd.cry();
		System.out.println("=====================");
		
		//2. Animal 타입으로 선언 + 자식 타입으로 생성 :동적 바인딩에 의해서 부모의 cry()를 호출할 경우 자식의 오버로딩된 cry()로 바인딩됨 
		
		
		Animal ab = new Bird();
//Bird를 객채화해서 Animal타입으로 //ab는 Animal,Bird 타입을 내포, Animal필드와 메소드만 접근
		ab.cry(); 	
		//Animal의 cry() 를 호출할 경우 동적바인딩에 의해서 Bird클래스의 cry()를 호출
		
		Animal ac = new Cat();
//Cat를 객채화해서 Animal타입으로 //ac는 Animal,Cat타입을 내포, Animal필드와 메소드만 접근
		ac.cry();
		//Animal의 cry() 를 호출할 경우 동적바인딩에 의해서 Cat클래스의 cry()를 호출
		
		Animal ad = new Dog();
//Dog를 객채화해서 Animal타입으로 //ac는 Animal,Dog타입을 내포, Animal필드와 메소드만 접근
		ad.cry();	
		//Animal의 cry() 를 호출할 경우 동적바인딩에 의해서 Dog클래스의 cry()를 호출
			
		System.out.println("=====================");
		
		//3. 객체 배열로 관리
	
		Animal[] animal = {ab, ac, ad};
	 //객체타입배열 배열이름 = {객체,객체,객체};
		
		for (Animal k : animal) {
			k.cry();
		}
		
		System.out.println("=========================");
		
		for (int i = 0; i<animal.length;i++) {
			animal[i].cry();
		}
		
		
	}

}

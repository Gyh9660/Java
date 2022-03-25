package chap11.Ex06;

abstract class Animal{ //추상 클래스 : 추상 메소드가 하나이상 포함되어있는 경우
						//추상 클래스는 객체 생성 불가, 타입은 사용 가능
						//자식 클래스는 부모 클래스의 메소드를 구현시 오류를 방지
						//추상 클래스는 추상 클래스 내의 추상메소드를 자식 클래스에서 반드시 구현하도록 보장받는다
	String name;
	int age;
	
	abstract void cry(); //추상 메소드 : 구현부가 없느 메소드
		//void cry() {} <==일단 메소드 : 리턴타입 메소드이름 (입력매개변수) {구현코드}
	abstract void run();
	/*@Override  이거 뺴먹음.. (객체 자체를 출력시 메모리의 정보를 출력)
		public String toString() {
			return "이름 :" + name + "나이 : " + age;
		}*/ 
}
class Cat extends Animal{	//Cat은 Animal 상속 (일부만 상속한 경우)
	//모두 추상 메소드를 구현한 경우는 콘크리트 클래스가 된다.
	Cat(String name, int age){
		this.name = name;
		this.age = age;
	}
	void cry() {	//추상 메소드를 구현한 메소드
		System.out.println("야옹");
	}
	void run() {
		System.out.println("고양이는 네발로 달립니다.");
	}
}
class Tiger extends Animal{
	Tiger(String name, int age){
		this.name = name;
		this.age = age;
	}
	void cry() {
		System.out.println("어흥");
	}
	void run() {
		System.out.println("호랑이는 네발로 달립니다.");
	}
}
class Eagle extends Animal{
	Eagle(String name, int age){
		this.name = name;
		this.age = age;
	}
	void cry() {
		System.out.println("끼룩");
	}
	void run() {
		System.out.println("독수리는 날개로 납니다.");
	}
}

public class AbstractModifier_4 {

	public static void main(String[] args) {

		Animal a1 = new Cat("고양이",10);
		Animal a2 = new Tiger("호랑이",5);
		Animal a3 = new Eagle("독수리",15);

		//1. Animal 배열 객체에 저장
		Animal[] arr1 = {a1,a2,a3};
		
		//2. For 문을 사용해서 객체를 출력시 이름과 나이를 출력, cry와 run메소드 출력
		//System.out.println(arr1[0]); toString 오버라이딩 빼먹음
		for(int i=0; i<arr1.length; i++){
			System.out.println("이름 : "+arr1[i].name+", 나이 : "+ arr1[i].age);
			arr1[i].cry();
			arr1[i].run();
			System.out.println();	
		}
		
		//3. Enhanced For 문을 사용해서 이름과 나이를 출력, cry() , run()
		System.out.println("=============================");
		for(Animal k : arr1) {
			System.out.println("이름 : "+k.name+", 나이 : "+ k.age);
			//System.out.println(k); toString 오버라이딩 빼먹음
			k.cry();
			k.run();
			System.out.println();
		}
		
	}

}


package chap16.Ex08;



//제네릭 클래스를 생성 해서, 타입 제한 (Apple, Strawberry, Banana), Pencil은타입으로 접근 할수 없도록 설정

abstract class Fluit {
	public abstract void print(); //추상 메소드
}

class Apple extends Fluit{
	String name;
	int price;
	Apple(String name, int price){
		this.name = name;
		this.price = price;
	}
	@Override
	public String toString() {
		return name +"이고 가격은 : " + price;

	}
	public void print() {
		System.out.println("Apple");
	}
}

class Strawberry extends Fluit{
	String name;
	int price;
	Strawberry(String name, int price){
		this.name = name;
		this.price = price;
	}
	@Override
	public String toString() {
		return name +"이고 가격은 : " + price;

	}
	public void print() {
		System.out.println("Strawberry");
	}
}

class Banana extends Fluit{
	String name;
	int price;
	Banana(String name, int price){
		this.name = name;
		this.price = price;
	}
	@Override
	public String toString() {
		return name +"이고 가격은 : " + price;

	}
	public void print() {
		System.out.println("Banana");
	}
}

class Pencil{
	String name;
	int price;
	Pencil(String name, int price){
		this.name = name;
		this.price = price;
	}
	@Override
	public String toString() {
		return name +"이고 가격은 : " + price;

	}
	public void print() {
		System.out.println("Pencil");
	}
}

class Generic<T extends Fluit>{ //DTO , VO 필드에 getter/setter만 있는 클래스
								//DTO(Data Transfer Object)- getter, setter 
								//VO(Value Object) - getter
	private T t;				//데이터를 받아서 전송하는 중간자 역할
								//계층간에 값을 받아서 전송, 중간자 역할

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	
	public String toString() {
		return t.toString();
	}
}


public class EX_Restric_Generic_Type {

	public static void main(String[] args) {
		
		Generic<Fluit> a1 = new Generic<Fluit>();
		a1.setT(new Apple("사과2",2000));
		System.out.println(a1.getT());
		//Fluit로 호출?하면 사과 바나나 딸기 전부 호출가능
		
		
		Generic<Apple> genericapple = new Generic<>();
		genericapple.setT(new Apple("사과",1000));
		Apple apple = genericapple.getT();
		System.out.println(genericapple);
		System.out.println(apple);
		apple.print();
		System.out.println("=================");
		
		Generic<Strawberry> genericstrawberry = new Generic<>();
		genericstrawberry.setT(new Strawberry("딸기", 2000));
		Strawberry strawberry = genericstrawberry.getT();
		System.out.println(genericstrawberry);
		System.out.println(strawberry);
		strawberry.print();
		System.out.println("==================");
		
		Generic<Banana> genericbanana = new Generic<>();
		genericbanana.setT(new Banana("바나나",3000));
		Banana banana = genericbanana.getT();
		System.out.println(genericbanana);
		System.out.println(banana);
		banana.print();
		
		
	}

}

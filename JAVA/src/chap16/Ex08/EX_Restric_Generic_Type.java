
package chap16.Ex08;



//���׸� Ŭ������ ���� �ؼ�, Ÿ�� ���� (Apple, Strawberry, Banana), Pencil��Ÿ������ ���� �Ҽ� ������ ����

abstract class Fluit {
	public abstract void print(); //�߻� �޼ҵ�
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
		return name +"�̰� ������ : " + price;

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
		return name +"�̰� ������ : " + price;

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
		return name +"�̰� ������ : " + price;

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
		return name +"�̰� ������ : " + price;

	}
	public void print() {
		System.out.println("Pencil");
	}
}

class Generic<T extends Fluit>{ //DTO , VO �ʵ忡 getter/setter�� �ִ� Ŭ����
								//DTO(Data Transfer Object)- getter, setter 
								//VO(Value Object) - getter
	private T t;				//�����͸� �޾Ƽ� �����ϴ� �߰��� ����
								//�������� ���� �޾Ƽ� ����, �߰��� ����

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
		a1.setT(new Apple("���2",2000));
		System.out.println(a1.getT());
		//Fluit�� ȣ��?�ϸ� ��� �ٳ��� ���� ���� ȣ�Ⱑ��
		
		
		Generic<Apple> genericapple = new Generic<>();
		genericapple.setT(new Apple("���",1000));
		Apple apple = genericapple.getT();
		System.out.println(genericapple);
		System.out.println(apple);
		apple.print();
		System.out.println("=================");
		
		Generic<Strawberry> genericstrawberry = new Generic<>();
		genericstrawberry.setT(new Strawberry("����", 2000));
		Strawberry strawberry = genericstrawberry.getT();
		System.out.println(genericstrawberry);
		System.out.println(strawberry);
		strawberry.print();
		System.out.println("==================");
		
		Generic<Banana> genericbanana = new Generic<>();
		genericbanana.setT(new Banana("�ٳ���",3000));
		Banana banana = genericbanana.getT();
		System.out.println(genericbanana);
		System.out.println(banana);
		banana.print();
		
		
	}

}

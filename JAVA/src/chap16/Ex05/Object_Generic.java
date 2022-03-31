package chap16.Ex05;


class Apple{ //사과 클래스, 사과의 정보를 담은 객체
	String name;
	int price;
	
	Apple (String name, int price){ //생성자
		this.name = name;
		this.price = price;
	}
	//다운캐스팅하는이유 //메소드가 존재한다고 가정하면 object에있는 객체를 다운캐스팅해야 abc를 출력할수있다.
	public void abc() {
		System.out.println("abc() 메소드 출력");
	}
	@Override
	public String toString() { //객체 자체를 출력시 객체의 주소가 아니라 필드의 정보를 출력
		return "이름 : " + name + " , 가격 : " + price;
	}
}


class Pencil { //연필 클래스
	String name;
	int price;
	
	Pencil (String name, int price){ //생성자를 통해서 필드의 값 할당.
		this.name = name;
		this.price = price;
	}
	public void bcd() {
		System.out.println("bcd() 메소드 출력");
	}
	@Override
	public String toString() {
		return "이름 : " + name + " , 가격 : " + price;
	}
}

//제너릭을 사용해서 객체를 저장후 값읽어 오기.

//제너릭 클래스
class Goods<T>{
	private T t;

	public T get() {
		return t;
	}

	public void set(T t) {
		this.t = t;
	}
	
}

public class Object_Generic {

	public static void main(String[] args) {
		Goods<Apple> goods1 = new Goods<Apple>(); //ggods1는 Apple 데이터 타입이다.

		goods1.set(new Apple ("사과1",1000));
		System.out.println(goods1.get()); 	//제너릭에서는 다운 캐스팅을 할 필요가 없다.
		goods1.get().abc(); //다운 캐스팅 없이 Apple객체의 abc메소드 호출
		
		Goods<Pencil> goods2 = new Goods();
		goods2.set(new Pencil("연필1", 2000));
		System.out.println(goods2.get());
		goods2.get().bcd();
		
	}

}

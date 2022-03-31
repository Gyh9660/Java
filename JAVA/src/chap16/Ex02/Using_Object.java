package chap16.Ex02;

//Generic 사용전 문제점 - 
//Object는 모든 객체를 저장 할 수 있다.
//상품을 저장하는 클래스에 Object 타입으로 저장하면 모든 객체를 담을 수 있다.
//Object의 장점 - 모든 객체를 담을수있다.(캐스팅 할수있다 casting)
//			단점 - 매번 다운캐스팅을 해줘야한다.
			//  - 약한 타입 체크 : 실행시 ClassCastException 발생할수있음.
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
	@Override
	public String toString() {
		return "이름 : " + name + " , 가격 : " + price;
	}
}

class Goods{ //Object를 사용해서 모든 상품을 저장
	private Object object = new Object(); //Object : 모든 클래스는 Object 타입으로 변환

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) { //Object 타입으로 업캐스팅됨.
		this.object = object;
	}
	
}




public class Using_Object {

	public static void main(String[] args) {
		
		//1. Apple를 저장후 출력. Object
		Goods goods1 = new Goods();
		goods1.setObject(new Apple ("사과3", 4000)); //Setter로 값을 할당.
		System.out.println((Apple)goods1.getObject());		//Getter로 객체를 출력 : Object타입 ===>Apple로 다운캐스팅해줘야함
		((Apple) goods1.getObject()).abc(); //Object ==> Apple로 다운 캐스팅후 abc()메소드 호출
		
		//2.Pencil을 저장후 출력. Object
		Goods goods2 = new Goods();
		goods2.setObject(new Pencil("연필3",5000));//Setter로 값을 할당.
		System.out.println((Pencil)goods2.getObject());//Getter로 객체를 추력 : Object타입 ===>Pancil로 다운캐스팅 해줘야함
		
		//3.Generic를 안쓰고 Object를 썼을때 문제점 - 잘못된 캐스팅을 할 수 있다.(약한 타입 체크)
		
		Goods goods3 = new Goods();
		goods3.setObject(new Apple("사과4", 5000));
		System.out.println((Pencil)goods3.getObject()); //약한 타입 체크 : 실행시 오류 발생
		
		
		
	}

}

package chap16.Ex01;

//Generic 사용전 문제점 -상품을 저장할 클래스를 매번 생성해 줘야 한다.

//객체를 담을 클래스를 만들 경우, 매번 객체를 생헐할때 마다 그 객체를 담을 클래스를 만들어줘야한다.
//객체를 저장할 클래스를 생성해서 객체 정보를 담을 수 있다 <== 새로운 상품이 추가 될때 마다 그 상품을 담을 클래스를 생성해 줘야 한다.
// 코드가 굉장히 복잡해진다




class Apple{ //사과 클래스, 사과의 정보를 담은 객체
	String name;
	int price;
	
	Apple (String name, int price){ //생성자
		this.name = name;
		this.price = price;
	}
	@Override
	public String toString() { //객체 자체를 출력시 객체의 주소가 아니라 필드의 정보를 출력
		return "이름 : " + name + " , 가격 : " + price;
	}
}
//1. Apple를 담을 수 있는 클래스 생성.
class Goods1 { //상품에 사과를 담는 클래스
	private Apple apple = new Apple("사과",1000);

	public Apple getApple() { //getter  : 객체 필드의 정보를 출력하는 것
		return apple;
	}

	public void setApple(Apple apple) { //setter
		this.apple = apple;
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

class Goods2{ //상품2 :연필 상품을 담은 클래스
	private Pencil pencil = new Pencil("연필",2000);

	public Pencil getPancil() {
		return pencil;
	}

	public void setPancil(Pencil pencil) {
		this.pencil = pencil;
	}
		
	
}


public class ProblemsBeforeGeneric {

	public static void main(String[] args) {
		//1. Goods1 상품이 저장되어 있다. Apple 객체 추가 및 가져오기
		Goods1 goods1 = new Goods1(); //기본생성자
		goods1.setApple(new Apple("사과2", 2000)); //setter로 값을할당
		System.out.println(goods1.getApple());//필드의 내용을 출력
		 
		//2. Goods2 상품이 저장. Pencil 객체를 저장,
		Goods2 goods2 = new Goods2();
		goods2.setPancil(new Pencil("연필2",3000));
		System.out.println(goods2.getPancil());
	}

}

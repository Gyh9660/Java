package chap06_07.Ex03;

class Car2{
	String company; //필드(인스턴스 필드)의 company를 알려주는 this, Heap 메모리에 저장
	String model; //인스턴스 : 객체화를 했을때 사용 가능한 필드
	String color; //[필드명과 필드의 값]은 Heap영역에 저장
	double maxSpeed;
	Car2 () {} // 기본 생성자
	Car2 ( String company, String model, String color, double max){
		this.company =company; //this 키는 객체의 필드의 변수를 뜻함
		this.model = model; //this : 3개의 변수 모두가 동일할 경우 객체의 필드의 변수를 알려주는 역할
		this.color = color;
		this.maxSpeed = max; // this 키워드가 생략된 상태
		
	}
	void work() { //메소드(인스턴스 메소드) :Heap 영역에 메소드명과 포인터를 저장하고있다.
		System.out.println(company); // 메소드의 전체구문은 클래스 영역의 메소드 영역에 저장                                                                                                                        
		System.out.println(model); //인스턴스 메소드는 객체화시켯을때 사용가능
		System.out.println(color);
		System.out.println(maxSpeed);
	}
	
	
}
public class Q1_01 {

	public static void main(String[] args) {

		Car2 car = new Car2();
		car.work();
		
		Car2 car2 = new Car2("현대", "그렌져","검정",234.0);
		car2.work();
		
	}

}

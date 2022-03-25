package chap10.Ex04;

class Human{ 		//부모 클래스
	String name;	//인스턴스 필드: 객체화 시켜야 사용, Heap에 저장
	int age;
	
	void eat() {	//인스턴스 메소드 : 객체화 시켜야 사용, Heap영역에 는 Pointer만 가지고있음, 내용은 클래스영역 내의 인스턴스 메소드영역에 실제 메소드의 코드가 저장
		System.out.println("사람이 먹습니다.");
	}
	
	void sleep () {
		System.out.println("사람이 잠을 잡니다.");
		
	}
}
class Student extends Human{
	int studentID;
	void gotoScool() {
		System.out.println("학생은 학교에 갑니다.");
	}
}
class Worker extends Human{
	int workerID;
	void gotoCompany() {
		System.out.println("직장에 갑니다.");
	}
}




public class Test01 {

	
	
	public static void main(String[] args) {

		Human h = new Human(); //부모클래스
		h.name = "홍길동";
		h.age = 30;
		h.eat();
		h.sleep();
		
		
		Student s = new Student(); //자식 클래스: 자식클래스는 부모클래스의필드와 메소드를 상속
		s.name = "신사임당"; //부모 클래스의 필드
		s.eat();	//부모 클래스의 메소드
		s.studentID = 1111; //자식 클래스의 필드
		s.gotoScool(); //자식 클래스의 메소드
		
		Worker w = new Worker(); //자식클래스
		w.name = "BTS"; // 부모클래스의 필드
		w.eat(); //부모클래스의 메소드
		w.workerID = 2222; //자식 클래스의 필드
		w.gotoCompany(); //자식 클래스의 메소드
		 
		Human h1 = new Student (); // 업캐스팅 : 자식에서 부모 타입으로 형변환
		//h : Human, Student 타입이 모두 저정, Human만 접근 가능
		 
		h1.name = "이순신";
		h1.eat();
		
		System.out.println("===================");
		
		
		//다운캐스팅 : 부모===> 자식으로 타입 변환 , if 조건을 사용해서 instanceof를 사용해서 처리
			//런타임 오류 방지
		
		
		System.out.println(h1 instanceof Student);//true
		System.out.println(h1 instanceof Human); //true

		if (h1 instanceof Student) { //다운 캐스팅 할때 런타임 오류를 방지하기 위해서 객체의 다운캐스팅할 데이터 타입이 존재할 때 반드시 instanceof  써줘야함.
			Student s2 = (Student) h1;
			s2.studentID = 3333;
			s2.gotoScool();
		}
		
		if (h1 instanceof Worker) {
			Worker W4  = (Worker) h1; //false
		}
		
		//Worker w4 = (Worker)h1;  //오류가 발생하지 않는다.(컴파일 오류는 발생하지 않는다.)
			//실행시 오류 발생, 런타임 오류
		System.out.println(h1 instanceof Worker); //false
		
		
		
		
	}

}

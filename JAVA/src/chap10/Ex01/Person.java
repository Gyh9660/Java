package chap10.Ex01;

class Student_sub extends Student {
	//Studen_sub는 Student를 상속 받고 있따. Student의 필드와 메소드를 상속받는다.
	//Student는 Person을 상속 받고 있다. Student는 Person의 필드와 메소드를 상속 받고 있다.
	
	//Student_sub는 Person의 필드와 메소드와 Student의 필드와 메소드를 모두 상속 받고 있따.
	
	String sub1;
	
	void sub1() {
		System.out.println("Student_sub 클래스 입니다.부모의 필드와 메소드를 물려 받습니다.");
	}
}



public class Person { //상속 : 부모 클래스의 (필드, 메소드, 내부클래스)를 자식클래스에게 상송
	
	String name; // 상속의 이점: 1.중복된 코드의 제거(코드의 재사용)
	int age;		//2. 코드가 간결해진다. 3. 다형성(메소드 오버라이딩)
					//다형성: 하나의 메소드 이름으로 여러형식으로 출력
	
	void eat() {
		
		System.out.println("부모 클래스의 eat() 메소드");
	}
	
	void sleep() {
		
		System.out.println("부모 클래스의 sleep() 메소드");
	}




	public static void main(String[] args) {

		//1. person  객체 생성
		Person p = new Person();
		p.name = "홍길동";
		p.age = 20;
		p.eat();
		p.sleep();
		
		
		System.out.println("=========Student class===========");
		
		//2. Student 객체 생성
		Student s = new Student(); //Person 클래스를 상속, Person 클래스의 필드와 메소드를 사용
		//Person 클래스의 필드
		s.name="이순신";
		s.age=50;
		//Student 클래스의 필드
		s.studentID= 20200310;
		
		//Person 클래스의 메소드
		s.eat();
		s.sleep();
		
		//Student 클래스의 메소드
		s.goToSchool();
		
		System.out.println("=========Worker class=============");
		//3. Worker 객체 생성
		Worker w = new Worker(); //Person 클래스를 상속 한다. Person 클래스의 필드와 메소드를 사용.
		
		//부모 클래스의 필드 :Person
		w.name = "세종대왕";
		w.age = 60;
		
		//자식 클래스의 필드 : Worker
		w.workID=20220310; //사번
		
		//부모 클래스의 메소드 :Person
		w.eat();
		w.sleep();
		
		//자식 클래스의 메소드 :Worker
		w.goToWork();
		
		System.out.println("========객체 생성시 타입 변환 ===========");
		
		Person p1 = new Person(); //Person()은 Person이다. (자식은 부모다)
		Person ps = new Student(); //업캐스팅, student는 person이다. 자식-> 부모는 성립
		//Student sp = new Person(); // 부모는 자식이다 (성립x)오류발생
		Person pw = new Worker(); // 업캐스팅, Worker 는 Person이다. (자식은 부모다)
		//Worker wp = new Person(); // 사람은 직장인이다. (성립x)오류발생
		System.out.println();
		System.out.println("=======Person<Student<Student_sub========");
		
		Student_sub sub1 = new Student_sub();//가능
		//|클래스 타입|객체명|       |자식 클래스|
		//	(Type)
		
			//Person 클래스의 필드와 메소드 사용 가능
			sub1.name = "신 사임당";
			sub1.age = 55;
			sub1.eat();
			sub1.sleep();
			//Student 클래스의 필드와 메소드
			sub1.studentID = 20220310;
			sub1.goToSchool();
			//Student_sub 클래스의 필드와 메소드
			sub1.sub1= "자식의 자식 클래스";
			sub1.sub1();
		
		Person ps1 = new Student_sub(); // 업캐스팅: Student_sub객체를 생성시 부모 데이터 타입으로 형변환 하는 것
			//Student_sub는 Person 타입으로 업캐스팅, Person래스의 멤버만 사용 가능
		
		//Person 클래스의 필드와 메소드만 접근
		ps1.name = "BTS"; //Person                                                                                                                                                                                                      
		ps1.age = 30;
		ps1.eat();
		ps1.sleep();
		
		
		Student ss1 = new Student_sub(); //업캐스팅: Student_sub를 Student타입으로 업캐스팅
		
		//person과 student의 필드와 메소드를 사용가능
		
		//Parson의 필드와 메소드
		ss1.name="SES";
		ss1.age =30;
		ss1.eat();
		ss1.sleep();
		
		
		//Student의 필드와 메소드
		ss1.studentID = 20110310;
		ss1.goToSchool();
		
		Student_sub ss2 = new Student_sub(); //Person, Student, Student_sub의 필드와 메소드 모두 사용.
		
		
		//Person 클래스의 필드와 메소드
		ss2.name = "봄여름가을겨울";
		ss2.age = 40;
		ss2.eat();
		ss2.sleep();
		
		//Student 클래스의 필드와 메소드
		ss2.studentID= 20220130;
		ss2.goToSchool();
		
		//Student_sub 클래스의 필드와 메소드
		ss2.sub1= "자식의 자식클래스";
		ss2.sub1();
		
	//상속 관계에서 객체 생성시 부모 데이터 타입으로 업캐스팅 가능	
		//부모 데이터 타입으로 업캐스팅 된 경우 부모의 필드와 메소드만 사용가능
		
		//Person <=== Student <=== Studetn_sub
		
		Person ps4 = new Student_sub();
			//Student_sub객체를 생성시 Person타입으로 업캐스팅(자동으로 변환)
			//Student_sub는 Person과 Student와 Student_sub의 모든 필드와 메소드를 포함한다.
			//그중에서 Person클래스의 필드와 메소드만 접근가능
		
		
		Student ss4 = new Student_sub();
		
			//Student_sub객체를 생성시 Student타입으로 업캐스팅
			//Student_sub는 Person과 Student와 Student_sub의 모든 필드와 메소드를 포함한다.
			//그중에서 Person, Student클래스의 필드와 메소드만 접근가능
		
		Student_sub ss5 = new Student_sub();
		
			//Student_sub객체를 생성시 Student_sub타입으로 적용
			//Student_sub는 Person과 Student와 Student_sub의 모든 필드와 메소드를 포함한다.
			//그중에서 Person, Student, Student_sub클래스의 필드와 메소드dp 접근가능
		
	
		
		//다운 캐스팅 : 부모 데이터 타입으로 업캐스팅된것을 자식 데이터 타입으로 변환(수동으로 변환)
	
		Student ps5 = (Student) ps4; //ps4(Person, Student,Student_sub)의 (접근가능한)데이터 타입은 person
		//ps5는 Person과 Student의 필드와 메소드접근 가능
		
		ps5.name ="다운 캐스팅";
		ps5.age = 30;
		ps5.studentID=30306330; //Student 필드와 메소드 사용가능
		ps5.goToSchool(); //Student의 메소드 사용
		
		Student_sub ps6 = (Student_sub) ps4; //ps4는 Person데이터 타입에서 Student_sub로 다운캐스팅
			//Student_subfh로 다운캐스팅됨(Person,Student,Student_sub의 필드와 메소드 사용가능)
		
		ps6.name ="이용식"; //Person
		ps6.age = 20; //Person
		ps6.studentID = 20202020; //Student
		ps6.goToSchool();//Student
		ps6.sub1 = "자식의 자식클래스";//Student_sub
		ps6.sub1();//Student_sub
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

class Student extends Person{ //대학생 클래스, Person: 부모, Student 자식
	// 자식 클래스는 부모 클래스의 필드, 메소드,이너클래스를 그대로 상속 받는다.
	
	int studentID;
	void goToSchool() {
		System.out.println("자식 클래스의 student 메소드 goToSchool 호출");
	}
	
	
}

class Worker extends Person { //직장인 클래스
	int workID; // 사번
	void goToWork() {
		System.out.println("직장인 클래스의 메소드 호출");
	}
	
	
}


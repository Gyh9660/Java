package cooperation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


/*	객체간의 협업
 * 				학생의 용돈 100,000원
 * 		학생		: 			버스를 탈대(-1000원)	지하철을 탈때 (-1500원)
 * 		버스		: 1,000원	승객수 증가, 수입 증가
 * 		지하철	: 1,500원						승객수 증가, 수입 증가
 * 
 */

class Student {
	String studentName;	//학생명
	int money;			//학생이 가진돈, 초기값 : 100000
	Bus bus;
	Subway subway;
	
	public Student() {
		
	}
	public Student(String studentName,int money) {
		this.studentName = studentName;
		this.money = money;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public void takeBus(Bus bus) { //학생이 버스를 탔을때 버스에 돈을 지불해야 한다.
		bus.take(1000);
		this.bus = bus;
		this.money-=1000;
	}
	public void takeOutBus (Bus bus) { //버스에서 내림
		bus.takeOut();
		this.bus = null;
	}
	public void takeSubway(Subway subway) { //지하철 탑승
		subway.take(1500);
		this.subway = subway;
		this.money-=1500;
	}
	public void takeOutSubway(Subway subway) { //지하철 내릴때
		subway.takeOut();
		this.subway = null;
	}
	@Override
	public String toString() {
		return studentName +"님의 남은돈은"+ money +"입니다.";
	}
}
class Bus{
	int busName; //100번 버스. 200버스 <== 인풋값을 받아서, 생성자.
	int passngerCount; //승객수
	int money;			//버스의 수입
	
	public int getBusName() {
		return busName;
	}
	public void setBusName(int busName) {
		this.busName = busName;
	}
	public int getPassngerCount() {
		return passngerCount;
	}
	public void setPassngerCount(int passngerCount) {
		this.passngerCount = passngerCount;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public void take(int money) { //버스의 수입을 처리, 승객수를 처리
		this.money += money;
		this.passngerCount++;
		
	}
	public void takeOut() { //승객수만 감소
		this.passngerCount--;
		
	}
	Bus(){
		setBusName(100);
	}
	@Override
	public String toString() {
		return "버스"+getBusName()+"번의 승객은"+getPassngerCount()+"명이고 수입은" +getMoney()+ "입니다.";
	}
}
class Subway{
	String lineNumber; //1호선 2호선 .....
	int passngerCount; //승객수
	int money; //지하철 수입
	
	public String getLineNumber() {
		return lineNumber;
	}
	public void setLineNumber(String lineNumber) {
		this.lineNumber = lineNumber;
	}
	public int getPassngerCount() {
		return passngerCount;
	}
	public void setPassngerCount(int passngerCount) {
		this.passngerCount = passngerCount;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	Subway(){
		setLineNumber("1호선");
	}
	//생성자를 통해서 지하철 호선을 인풋 받아서 활성화
	public void take(int money) { //수입을 처리하는 메소드, 승객수
		this.money += money;
		this.passngerCount++;
		return;
	}
	public void takeOut() { //지하철에서 승객 감소
		this.passngerCount--;
	}
	@Override
	public String toString() {
		return "지하철"+getLineNumber()+"호선의 승객은"+getPassngerCount()+"명이고 수입은" +getMoney()+ "입니다.";
	}
	
}
public class CooperationBetweenObject {
	private static ArrayList<Student> studentList = new ArrayList<Student>();
	private static ArrayList<Bus>	busList = new ArrayList<>();
	private static ArrayList<Subway> subwayList = new ArrayList<>();
	private static Scanner sc = new Scanner(System.in);
	
	private static void createStudent() {
		Bus bus = new Bus();
		Subway sub = new Subway();
		busList.add(bus);
		subwayList.add(sub);
		System.out.println("학생이름 : ");
		String name = sc.next();
		System.out.println("돈 입력 : ");
		int money = sc.nextInt();
		Student student = new Student(name,money);
		studentList.add(student);
		System.out.println(student.getStudentName()+" 학생 정보가 등록되었습니다.");
	}
	
	private static void studentList() {
		
		System.out.println("==학생정보 출력==");
		System.out.println("학생이름\t가진돈");
		for(int i=0; i<studentList.size(); i++) {
			System.out.println(studentList.get(i).getStudentName()+"\t"+studentList.get(i).getMoney());
		}
		System.out.println("학생선택(이름입력) >>");
		String studentName = sc.next();
		Student student = findStudent(studentName);
		System.out.println(studentName+"학생이 선택되었습니다.");
		Bus bus = new Bus();
		Subway sub = new Subway();
		while(true) {
			System.out.println("================================================================================");
			System.out.println("4. 버스를 탐 | 5. 버스를 내림 | 6. 지하철을 탐 | 7. 지하철을 내림 | 8. 뒤로" );
			System.out.println("================================================================================");
			int num = sc.nextInt();
			if(num == 4) {
				System.out.println("선택 >> 4");
				System.out.println(student.getStudentName()+"님 "+bus.busName+"번 버스를 탔습니다. 즐거운 하루되세요.");
				student.takeBus(bus);
				busList.add(bus);
				System.out.println(student);
				System.out.println(bus);
			}else if(num == 5) {
				System.out.println("선택 >> 5");
				System.out.println(student.getStudentName()+"님"+bus.busName+"버스를 내렸습니다. 굿바이~~~.");
				bus.takeOut();
				System.out.println(student);
				System.out.println(bus);
			}else if(num == 6) {
				System.out.println("선택 >> 6");
				System.out.println(student.getStudentName()+"님 "+sub.lineNumber+"지하철를 탔습니다. 즐거운 하루되세요.");
				student.takeSubway(sub);
				System.out.println(student);
				System.out.println(sub);
			}else if(num == 7) {
				System.out.println("선택 >> 7");
				System.out.println(student.getStudentName()+"님 "+sub.lineNumber+"지하철를 내렸습니다. 안녕 ~~~");
				student.takeOutSubway(sub);
				System.out.println(student);
				System.out.println(sub);
			}else if(num == 8) {
				System.out.println("선택 >> 8");
				break;
			}	
		}
	}
	
	/*private static void busTake() {
		Student student = new Student(choice, choiceMoney);
		Bus bus = new Bus();
		System.out.println(student.getStudentName()+"님 "+bus.busName+"번 버스를 탔습니다. 즐거운 하루되세요.");
		student.takeBus(bus);
		System.out.println(student);
		System.out.println(bus);
	}
	private static void busTakeOut() {
		Student student = new Student(choice, choiceMoney);
		Bus bus = new Bus();
		System.out.println(student.getStudentName()+"님"+bus.busName+"버스를 내렸습니다. 굿바이~~~.");
		bus.takeOut();
		System.out.println(student);
		System.out.println(bus);
	}
	private static void subwayTake() {
		
	}
	private static void subwayTakeOut() {
		
	}
	*/
	private static Student findStudent(String studentName) {
		for(int i = 0; i<studentList.size();i++) {
			if(studentList.get(i).getStudentName().equals(studentName)) {
				return studentList.get(i);
			}
		}
		System.out.println("학생이 존재하지 않습니다.");
		return null;	
		
	}		
	public static void main(String[] args) {
		
		
		int num = 0;
		boolean run = true;		
		 
		while(run) {
			System.out.println("====================================================================");
			System.out.println("1. 학생객체 생성 | 2. 학생정보 출력 및 선택 | 3. 종료 ");
			System.out.println("================================================================================");
				
			System.out.println("선택>>");
			
			num = sc.nextInt();
			if(num == 1) {
				System.out.println("선택 >> 1");
				createStudent();
			}else if(num == 2) {
				System.out.println("선택 >> 2");
				studentList();
			}else if(num == 3) {
				System.out.println("선택 >> 3");
				break;
			}	
		}
		System.out.println("프로그램 종료");
		sc.close();
		/*
		학생 5명 입력 : 학생당 100,000만원 초기값 할당. 
		=============================================
		1. 학생객체 생성  | 2. 학생정보 출력 및 선택  
		3. 버스를 탐 |  4.  버스를 내림 5. 지하철을 탐 , 6. 지하철을 내림.   7. 종료  
		=============================================
		선택>> 1
		학생이름  : 
		 돈 입력   : 

		선택>> 2 
		=====학생정보 출력=====
		학생이름	가진돈



		학생선택(이름입력)>> 


		선택>> 3
		000 님 000 번 버스를 탔습니다. 즐거운 하루되세요. 
		000 님의 남은돈은 000 입니다. 
		버스 000번의 승객은 000명이고 수입은000 입니다. 

		선택>> 4
		000 님 000 번 버스를 내렸습니다. 굿바이~~~. 
		000 님의 남은돈은 000 입니다. 
		버스 00번의 승객은 000명이고 수입은 000 입니다. 

		선택>> 5
		000 님 000 호선 지하철를 탔습니다. 즐거운 하루되세요. 
		000 님의 남은돈은 000 입니다. 
		지하철 00 호선의 승객은 00명이고 수입은  000 입니다. 

		선택>> 6
		000 님 000 호선 지하철를 내렸습니다. 안녕 ~~~
		000 님의 남은돈은 000 입니다. 
		지하철 00 호선의 승객은 00명이고 수입은  000 입니다. 
		*/ 

	}

}

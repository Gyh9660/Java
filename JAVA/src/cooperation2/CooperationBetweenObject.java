package cooperation2;

import java.util.ArrayList;
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
	
	public Student() {
		
	}
	public Student(String studentName,int money) {
		this.studentName = studentName;
		this.money = money;
	}
	public void takeBus(Bus bus) { //학생이 버스를 탔을때 버스에 돈을 지불해야 한다.
		bus.take(1000);
		this.money-=1000;
	}
	public void takeOutBus (Bus bus) { //버스에서 내림
		bus.takeOut();
	}
	public void takeSubway(Subway subway) { //지하철 탑승
		subway.take(1500);
		this.money-=1500;
	}
	public void takeOutSubway(Subway subway) { //지하철 내릴때
		subway.takeOut();
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
	
	public void take(int money) { //버스의 수입을 처리, 승객수를 처리
		this.money += money;
		this.passngerCount++;
		
	}
	public void takeOut() { //승객수만 감소
		this.passngerCount--;
	}
	Bus(int busName){
		this.busName =busName;
	}
	@Override
	public String toString() {
		return "버스"+this.busName+"번의 승객은"+this.passngerCount+"명이고 수입은" +this.money+ "입니다.";
	}
}
class Subway{
	String lineNumber; //1호선 2호선 .....
	int passngerCount; //승객수
	int money; //지하철 수입
	
	Subway(String lineNumber){
		this.lineNumber=lineNumber;
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
		return "지하철"+this.lineNumber+"호선의 승객은"+this.passngerCount+"명이고 수입은" +this.money+ "입니다.";
	}
	
}
public class CooperationBetweenObject {
	private static ArrayList<Student> studentList = new ArrayList<Student>();
	private static ArrayList<Bus>	busList = new ArrayList<>();
	private static ArrayList<Subway> subwayList = new ArrayList<>();
	private static Scanner sc = new Scanner(System.in);
	
	private static Student findStudent(String studentName) {
		for(int i = 0; i<studentList.size();i++) {
			if(studentList.get(i).studentName.equals(studentName)) {
				return studentList.get(i);
			}
		}
		System.out.println(studentList);
		System.out.println("학생이 존재하지 않습니다.");
		return null;	
		
	}		
	public static void main(String[] args) {
		
		
		int num = 0;
		boolean run = true;		
		System.out.println("버스를 생성하세요.");
		Bus bus = new Bus(sc.nextInt());
		System.out.println("지하철을 생성하세요.");
		Subway sub = new Subway(sc.next());
		busList.add(bus);
		subwayList.add(sub);
		System.out.println(bus.busName+"번 버스");
		System.out.println(sub.lineNumber);
		while(run) {
			System.out.println("================================================================================");
			System.out.println("1. 학생객체 생성 | 2. 학생정보 출력 및 선택 | 3. 종료 ");
			System.out.println("================================================================================");
				
			System.out.println("선택>>");
			
			num = sc.nextInt();
			if(num == 1) {
				System.out.println("선택 >> 1");
					System.out.println("학생이름 : ");
					String name = sc.next();
					System.out.println("돈 입력 : ");
					int money = sc.nextInt();
					Student student = new Student(name,money);
					studentList.add(student);
					System.out.println(student.studentName+" 학생 정보가 등록되었습니다.");
			}else if(num == 2) {
				System.out.println("선택 >> 2");
				System.out.println("==학생정보 출력==");
				System.out.println("학생이름\t가진돈");
				for(int i=0; i<studentList.size(); i++) {
					System.out.println(studentList.get(i).studentName+"\t"+studentList.get(i).money);
				}
				System.out.println("학생선택(이름입력) >>");
				String studentName = sc.next();
				Student student = findStudent(studentName);
				System.out.println(studentName+"학생이 선택되었습니다.");
				while(true) {
					System.out.println("================================================================================");
					System.out.println("4. 버스를 탐 | 5. 버스를 내림 | 6. 지하철을 탐 | 7. 지하철을 내림 | 8. 뒤로" );
					System.out.println("================================================================================");
					int num2 = sc.nextInt();
					if(num2 == 4) {
						System.out.println("선택 >> 4");
						System.out.println(student.studentName+"님 "+bus.busName+"번 버스를 탔습니다. 즐거운 하루되세요.");
						student.takeBus(bus);
						System.out.println(student);
						System.out.println(bus);
					}else if(num2 == 5) {
						System.out.println("선택 >> 5");
						System.out.println(student.studentName+"님"+bus.busName+"버스를 내렸습니다. 굿바이~~~.");
						bus.takeOut();
						System.out.println(student);
						System.out.println(bus);
					}else if(num2 == 6) {
						System.out.println("선택 >> 6");
						System.out.println(student.studentName+"님 "+sub.lineNumber+"지하철를 탔습니다. 즐거운 하루되세요.");
						student.takeSubway(sub);
						System.out.println(student);
						System.out.println(sub);
					}else if(num2 == 7) {
						System.out.println("선택 >> 7");
						System.out.println(student.studentName+"님 "+sub.lineNumber+"지하철를 내렸습니다. 안녕 ~~~");
						student.takeOutSubway(sub);
						System.out.println(student);
						System.out.println(sub);
					}else if(num2 == 8) {
						System.out.println("선택 >> 8");
						break;
					}	
				}
			}else if(num == 3) {
				System.out.println("선택 >> 3");
				break;
			}	
		}
		System.out.println("프로그램 종료");
		sc.close();
		
	}

}

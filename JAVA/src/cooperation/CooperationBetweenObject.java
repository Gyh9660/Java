package cooperation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


/*	��ü���� ����
 * 				�л��� �뵷 100,000��
 * 		�л�		: 			������ Ż��(-1000��)	����ö�� Ż�� (-1500��)
 * 		����		: 1,000��	�°��� ����, ���� ����
 * 		����ö	: 1,500��						�°��� ����, ���� ����
 * 
 */

class Student {
	String studentName;	//�л���
	int money;			//�л��� ������, �ʱⰪ : 100000
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
	public void takeBus(Bus bus) { //�л��� ������ ������ ������ ���� �����ؾ� �Ѵ�.
		bus.take(1000);
		this.bus = bus;
		this.money-=1000;
	}
	public void takeOutBus (Bus bus) { //�������� ����
		bus.takeOut();
		this.bus = null;
	}
	public void takeSubway(Subway subway) { //����ö ž��
		subway.take(1500);
		this.subway = subway;
		this.money-=1500;
	}
	public void takeOutSubway(Subway subway) { //����ö ������
		subway.takeOut();
		this.subway = null;
	}
	@Override
	public String toString() {
		return studentName +"���� ��������"+ money +"�Դϴ�.";
	}
}
class Bus{
	int busName; //100�� ����. 200���� <== ��ǲ���� �޾Ƽ�, ������.
	int passngerCount; //�°���
	int money;			//������ ����
	
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
	public void take(int money) { //������ ������ ó��, �°����� ó��
		this.money += money;
		this.passngerCount++;
		
	}
	public void takeOut() { //�°����� ����
		this.passngerCount--;
		
	}
	Bus(){
		setBusName(100);
	}
	@Override
	public String toString() {
		return "����"+getBusName()+"���� �°���"+getPassngerCount()+"���̰� ������" +getMoney()+ "�Դϴ�.";
	}
}
class Subway{
	String lineNumber; //1ȣ�� 2ȣ�� .....
	int passngerCount; //�°���
	int money; //����ö ����
	
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
		setLineNumber("1ȣ��");
	}
	//�����ڸ� ���ؼ� ����ö ȣ���� ��ǲ �޾Ƽ� Ȱ��ȭ
	public void take(int money) { //������ ó���ϴ� �޼ҵ�, �°���
		this.money += money;
		this.passngerCount++;
		return;
	}
	public void takeOut() { //����ö���� �°� ����
		this.passngerCount--;
	}
	@Override
	public String toString() {
		return "����ö"+getLineNumber()+"ȣ���� �°���"+getPassngerCount()+"���̰� ������" +getMoney()+ "�Դϴ�.";
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
		System.out.println("�л��̸� : ");
		String name = sc.next();
		System.out.println("�� �Է� : ");
		int money = sc.nextInt();
		Student student = new Student(name,money);
		studentList.add(student);
		System.out.println(student.getStudentName()+" �л� ������ ��ϵǾ����ϴ�.");
	}
	
	private static void studentList() {
		
		System.out.println("==�л����� ���==");
		System.out.println("�л��̸�\t������");
		for(int i=0; i<studentList.size(); i++) {
			System.out.println(studentList.get(i).getStudentName()+"\t"+studentList.get(i).getMoney());
		}
		System.out.println("�л�����(�̸��Է�) >>");
		String studentName = sc.next();
		Student student = findStudent(studentName);
		System.out.println(studentName+"�л��� ���õǾ����ϴ�.");
		Bus bus = new Bus();
		Subway sub = new Subway();
		while(true) {
			System.out.println("================================================================================");
			System.out.println("4. ������ Ž | 5. ������ ���� | 6. ����ö�� Ž | 7. ����ö�� ���� | 8. �ڷ�" );
			System.out.println("================================================================================");
			int num = sc.nextInt();
			if(num == 4) {
				System.out.println("���� >> 4");
				System.out.println(student.getStudentName()+"�� "+bus.busName+"�� ������ �����ϴ�. ��ſ� �Ϸ�Ǽ���.");
				student.takeBus(bus);
				busList.add(bus);
				System.out.println(student);
				System.out.println(bus);
			}else if(num == 5) {
				System.out.println("���� >> 5");
				System.out.println(student.getStudentName()+"��"+bus.busName+"������ ���Ƚ��ϴ�. �¹���~~~.");
				bus.takeOut();
				System.out.println(student);
				System.out.println(bus);
			}else if(num == 6) {
				System.out.println("���� >> 6");
				System.out.println(student.getStudentName()+"�� "+sub.lineNumber+"����ö�� �����ϴ�. ��ſ� �Ϸ�Ǽ���.");
				student.takeSubway(sub);
				System.out.println(student);
				System.out.println(sub);
			}else if(num == 7) {
				System.out.println("���� >> 7");
				System.out.println(student.getStudentName()+"�� "+sub.lineNumber+"����ö�� ���Ƚ��ϴ�. �ȳ� ~~~");
				student.takeOutSubway(sub);
				System.out.println(student);
				System.out.println(sub);
			}else if(num == 8) {
				System.out.println("���� >> 8");
				break;
			}	
		}
	}
	
	/*private static void busTake() {
		Student student = new Student(choice, choiceMoney);
		Bus bus = new Bus();
		System.out.println(student.getStudentName()+"�� "+bus.busName+"�� ������ �����ϴ�. ��ſ� �Ϸ�Ǽ���.");
		student.takeBus(bus);
		System.out.println(student);
		System.out.println(bus);
	}
	private static void busTakeOut() {
		Student student = new Student(choice, choiceMoney);
		Bus bus = new Bus();
		System.out.println(student.getStudentName()+"��"+bus.busName+"������ ���Ƚ��ϴ�. �¹���~~~.");
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
		System.out.println("�л��� �������� �ʽ��ϴ�.");
		return null;	
		
	}		
	public static void main(String[] args) {
		
		
		int num = 0;
		boolean run = true;		
		 
		while(run) {
			System.out.println("====================================================================");
			System.out.println("1. �л���ü ���� | 2. �л����� ��� �� ���� | 3. ���� ");
			System.out.println("================================================================================");
				
			System.out.println("����>>");
			
			num = sc.nextInt();
			if(num == 1) {
				System.out.println("���� >> 1");
				createStudent();
			}else if(num == 2) {
				System.out.println("���� >> 2");
				studentList();
			}else if(num == 3) {
				System.out.println("���� >> 3");
				break;
			}	
		}
		System.out.println("���α׷� ����");
		sc.close();
		/*
		�л� 5�� �Է� : �л��� 100,000���� �ʱⰪ �Ҵ�. 
		=============================================
		1. �л���ü ����  | 2. �л����� ��� �� ����  
		3. ������ Ž |  4.  ������ ���� 5. ����ö�� Ž , 6. ����ö�� ����.   7. ����  
		=============================================
		����>> 1
		�л��̸�  : 
		 �� �Է�   : 

		����>> 2 
		=====�л����� ���=====
		�л��̸�	������



		�л�����(�̸��Է�)>> 


		����>> 3
		000 �� 000 �� ������ �����ϴ�. ��ſ� �Ϸ�Ǽ���. 
		000 ���� �������� 000 �Դϴ�. 
		���� 000���� �°��� 000���̰� ������000 �Դϴ�. 

		����>> 4
		000 �� 000 �� ������ ���Ƚ��ϴ�. �¹���~~~. 
		000 ���� �������� 000 �Դϴ�. 
		���� 00���� �°��� 000���̰� ������ 000 �Դϴ�. 

		����>> 5
		000 �� 000 ȣ�� ����ö�� �����ϴ�. ��ſ� �Ϸ�Ǽ���. 
		000 ���� �������� 000 �Դϴ�. 
		����ö 00 ȣ���� �°��� 00���̰� ������  000 �Դϴ�. 

		����>> 6
		000 �� 000 ȣ�� ����ö�� ���Ƚ��ϴ�. �ȳ� ~~~
		000 ���� �������� 000 �Դϴ�. 
		����ö 00 ȣ���� �°��� 00���̰� ������  000 �Դϴ�. 
		*/ 

	}

}

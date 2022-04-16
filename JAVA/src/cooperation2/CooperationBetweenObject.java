package cooperation2;

import java.util.ArrayList;
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
	
	public Student() {
		
	}
	public Student(String studentName,int money) {
		this.studentName = studentName;
		this.money = money;
	}
	public void takeBus(Bus bus) { //�л��� ������ ������ ������ ���� �����ؾ� �Ѵ�.
		bus.take(1000);
		this.money-=1000;
	}
	public void takeOutBus (Bus bus) { //�������� ����
		bus.takeOut();
	}
	public void takeSubway(Subway subway) { //����ö ž��
		subway.take(1500);
		this.money-=1500;
	}
	public void takeOutSubway(Subway subway) { //����ö ������
		subway.takeOut();
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
	
	public void take(int money) { //������ ������ ó��, �°����� ó��
		this.money += money;
		this.passngerCount++;
		
	}
	public void takeOut() { //�°����� ����
		this.passngerCount--;
	}
	Bus(int busName){
		this.busName =busName;
	}
	@Override
	public String toString() {
		return "����"+this.busName+"���� �°���"+this.passngerCount+"���̰� ������" +this.money+ "�Դϴ�.";
	}
}
class Subway{
	String lineNumber; //1ȣ�� 2ȣ�� .....
	int passngerCount; //�°���
	int money; //����ö ����
	
	Subway(String lineNumber){
		this.lineNumber=lineNumber;
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
		return "����ö"+this.lineNumber+"ȣ���� �°���"+this.passngerCount+"���̰� ������" +this.money+ "�Դϴ�.";
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
		System.out.println("�л��� �������� �ʽ��ϴ�.");
		return null;	
		
	}		
	public static void main(String[] args) {
		
		
		int num = 0;
		boolean run = true;		
		System.out.println("������ �����ϼ���.");
		Bus bus = new Bus(sc.nextInt());
		System.out.println("����ö�� �����ϼ���.");
		Subway sub = new Subway(sc.next());
		busList.add(bus);
		subwayList.add(sub);
		System.out.println(bus.busName+"�� ����");
		System.out.println(sub.lineNumber);
		while(run) {
			System.out.println("================================================================================");
			System.out.println("1. �л���ü ���� | 2. �л����� ��� �� ���� | 3. ���� ");
			System.out.println("================================================================================");
				
			System.out.println("����>>");
			
			num = sc.nextInt();
			if(num == 1) {
				System.out.println("���� >> 1");
					System.out.println("�л��̸� : ");
					String name = sc.next();
					System.out.println("�� �Է� : ");
					int money = sc.nextInt();
					Student student = new Student(name,money);
					studentList.add(student);
					System.out.println(student.studentName+" �л� ������ ��ϵǾ����ϴ�.");
			}else if(num == 2) {
				System.out.println("���� >> 2");
				System.out.println("==�л����� ���==");
				System.out.println("�л��̸�\t������");
				for(int i=0; i<studentList.size(); i++) {
					System.out.println(studentList.get(i).studentName+"\t"+studentList.get(i).money);
				}
				System.out.println("�л�����(�̸��Է�) >>");
				String studentName = sc.next();
				Student student = findStudent(studentName);
				System.out.println(studentName+"�л��� ���õǾ����ϴ�.");
				while(true) {
					System.out.println("================================================================================");
					System.out.println("4. ������ Ž | 5. ������ ���� | 6. ����ö�� Ž | 7. ����ö�� ���� | 8. �ڷ�" );
					System.out.println("================================================================================");
					int num2 = sc.nextInt();
					if(num2 == 4) {
						System.out.println("���� >> 4");
						System.out.println(student.studentName+"�� "+bus.busName+"�� ������ �����ϴ�. ��ſ� �Ϸ�Ǽ���.");
						student.takeBus(bus);
						System.out.println(student);
						System.out.println(bus);
					}else if(num2 == 5) {
						System.out.println("���� >> 5");
						System.out.println(student.studentName+"��"+bus.busName+"������ ���Ƚ��ϴ�. �¹���~~~.");
						bus.takeOut();
						System.out.println(student);
						System.out.println(bus);
					}else if(num2 == 6) {
						System.out.println("���� >> 6");
						System.out.println(student.studentName+"�� "+sub.lineNumber+"����ö�� �����ϴ�. ��ſ� �Ϸ�Ǽ���.");
						student.takeSubway(sub);
						System.out.println(student);
						System.out.println(sub);
					}else if(num2 == 7) {
						System.out.println("���� >> 7");
						System.out.println(student.studentName+"�� "+sub.lineNumber+"����ö�� ���Ƚ��ϴ�. �ȳ� ~~~");
						student.takeOutSubway(sub);
						System.out.println(student);
						System.out.println(sub);
					}else if(num2 == 8) {
						System.out.println("���� >> 8");
						break;
					}	
				}
			}else if(num == 3) {
				System.out.println("���� >> 3");
				break;
			}	
		}
		System.out.println("���α׷� ����");
		sc.close();
		
	}

}

package Employeeinfo;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeSet;




class Employee{ 		//����� ������ ���� Ŭ����
	private int empNo; 			//�����ȣ
	private String empName; 	//����̸�
	private String phone;		//����ó
	private int age;			//����
	private String dept; 		//�μ�
	private String compRank;	//����
	
	Employee(int empNo, String empName, String phone, int age, String dept, String compRank){
		this.empNo = empNo;
		this.empName = empName;
		this.phone = phone;
		this.age = age;
		this.dept = dept;
		this.compRank=compRank;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getCompRank() {
		return compRank;
	}
	public void setCompRank(String compRank) {
		this.compRank = compRank;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Employee) {
			if(this.empNo== ((Employee)obj).empNo) {
				return true;
			}
		}
		return false;
	
	}
	@Override
		public int hashCode() {
			return Objects.hash(empNo);
		}
	
}
//TreeSet : �ߺ��� �����͸� ���� �� �� ����. Wrapper Ŭ������ ������ �Ǿ��ִ�. equals(), hashCode()
	//���ĵǾ ���� Comparable compareTo() ,Comparator compare()
		//�Ϲݰ�ü�� Set�ڷ����� �����Ҷ��� ��ü�� Ư�� �ʵ尡 �ߺ� ������� �ʵ���  equals(), hashCode() �������������
		//
	//Wrapper : �⺻�ڷ����� ��üȭ �⺻�ڷ������� ���� �޼ҵ尡 �߰�. (Boolean,Byte,Character,Integer,Double.....)
		//Comparable compareTo() :����ؼ� ����, ��ü����, Comparator compare() : �������� �ٷ� ��밡�� �� ������ �Ǿ� �ִ�.
public class Employee_info {

	private static TreeSet<Employee> tSet = new TreeSet<Employee>(new Comparator<Employee>() {
		@Override
		public int compare(Employee o1, Employee o2) {
			if(o1.getEmpNo() < o2.getEmpNo()) {
				return -1;
			}else if(o1.getEmpNo() == o2.getEmpNo()) {
				return 0;					
			}else {
				return 1;
			}
		}
	});
	public static boolean removeEmp(int empNo) { 
		
		for(Employee k : tSet) {
			if(k.getEmpNo() == empNo) {
				tSet.remove(k);
				return true;
			}
		}
		return false;
	}
	private static Scanner scanner = new Scanner(System.in);
	
	private static void creatEmp() {
		System.out.println("- ��� : ");
		int empNo = scanner.nextInt();
		
		System.out.println("- �̸� : ");
		String empName = scanner.next();
		
		System.out.println("- ����ó : ");
		String phone = scanner.next();
		
		System.out.println("- ���� : ");
		int age = scanner.nextInt();
		
		System.out.println("- �μ� : ");
		String dept = scanner.next();
		
		System.out.println("- ���� : ");
		String compRank=scanner.next();
		
		Employee employee = new Employee(empNo, empName, phone, age, dept, compRank);
		tSet.add(employee);
		System.out.println(empName+"���� ������ ���������� �Է� �Ǿ����ϴ�.");
	}
	
	private static void empList() {
		
		System.out.println();
		System.out.println("���\t�̸�\t����ó\t\t����\t�μ�\t����");
		
		Iterator<Employee> iterator = tSet.iterator();
		while (iterator.hasNext()) {
			Employee employee = iterator.next();			
			System.out.print(employee.getEmpNo());
			System.out.print("\t");
			System.out.print(employee.getEmpName()); 
			System.out.print("\t"); 
			System.out.print(employee.getPhone()); 
			System.out.print("\t"); 
			System.out.print(employee.getAge()); 
			System.out.print("\t"); 
			System.out.print(employee.getDept()); 
			System.out.print("\t"); 
			System.out.print(employee.getCompRank()); 
			System.out.println(); 
		}
		System.out.println();
	}
	
	private static void empRe() {
		System.out.println("������ ��� : ");
		int empNo = scanner.nextInt();
		System.out.println("������ �ʵ� ����[1. ����ó, 2. ����, 3. �μ�, 4. ����]");
		int ch = scanner.nextInt();
		
		Employee employee = findEmployee(empNo);
		
		if(employee == null) {
			System.out.println("��� : �ش� ����� �������� �ʽ��ϴ�.");
			return; 
		}
		while (true) {
			if(ch == 1) {
			System.out.println("������ ����ó�� �Է��ϼ���.");
			employee.setPhone(scanner.next());
			System.out.println("����ó�� �����Ǿ����ϴ�.");
			break;
		}else if(ch ==2) {
			System.out.println("������ ���̸� �Է��ϼ���.");
			employee.setAge(scanner.nextInt());
			System.out.println("���̰� �����Ǿ����ϴ�.");
			break;
		}else if(ch ==3) {
			System.out.println("������ �μ��� �Է��ϼ���.");
			employee.setDept(scanner.next());
			System.out.println("�μ��� �����Ǿ����ϴ�.");
			break;
		}else if(ch ==4) {
			System.out.println("������ ������ �Է��ϼ���.");
			employee.setCompRank(scanner.next());
			System.out.println("������ �����Ǿ����ϴ�.");
			break;
		}
			
		}
		
		
		
	}
	
	private static void empDel() {
		
		System.out.println("������ ��� : ");
		int empNo = scanner.nextInt();
		
		Employee employee = findEmployee(empNo);
		
		if(employee == null) {
			System.out.println("��� : �ش� ����� �������� �ʽ��ϴ�.");
			return; 
		}
		//removeEmp(empNo);
		tSet.remove(employee); //�̷��� �ϸ� removeEmp�������ؼ� ���ʿ䰡����..
		System.out.println(employee.getEmpName()+"����� ���� �Ǿ����ϴ�.");
		
		
	}
	
	private static Employee findEmployee(int empNo) {
		Iterator<Employee> ir = tSet.iterator(); 
		 while (ir.hasNext()) {					
			 Employee employee = ir.next();			
		 	int tempEmpNo = employee.getEmpNo();
		 	
		 	if (tempEmpNo == empNo){
		 		return employee;
		 	}
		 }
		 	System.out.println("����� �������� �ʽ��ϴ�.");
			return null;	
	}		
	
	public static void main(String[] args) {

		
		boolean run = true;
		while (run) {
			System.out.println("=================================================");
			System.out.println("# 1. ������� �űԵ��" );
			System.out.println("# 2. ������� �˻�" );
			System.out.println("# 3. ������� ����" );
			System.out.println("# 4. ������� ����" );
			System.out.println("# 5. ���α׷� ����" );
			System.out.println("=================================================");
			System.out.println("����>>");
			int selectNo = scanner.nextInt();
			
			if (selectNo == 1) {
				System.out.println("�޴� �Է� : "+ selectNo);
				creatEmp(); //�޼ҵ� ȣ��
			}else if (selectNo ==2) {
				System.out.println("�޴� �Է� : "+ selectNo);
				empList();
			}else if (selectNo ==3) {
				System.out.println("�޴� �Է� : "+ selectNo);
				empRe();
			}else if (selectNo ==4) {
				System.out.println("�޴� �Է� : "+ selectNo);
				empDel();
			}else if (selectNo ==5) {
				System.out.println("�޴� �Է� : "+ selectNo);
				break;
			}
		}
		scanner.close();
		System.out.println("���α׷� ����");
		
	}

}

package Employeeinfo;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeSet;




class Employee{ 		//사원의 정보를 담은 클래스
	private int empNo; 			//사원번호
	private String empName; 	//사원이름
	private String phone;		//연락처
	private int age;			//나이
	private String dept; 		//부서
	private String compRank;	//직급
	
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
//TreeSet : 중복된 데이터를 저장 할 수 없다. Wrapper 클래스는 재정의 되어있다. equals(), hashCode()
	//정렬되어서 저장 Comparable compareTo() ,Comparator compare()
		//일반객체를 Set자료형에 저장할때는 객체의 특정 필드가 중복 저장되지 않도록  equals(), hashCode() 재정의해줘야함
		//
	//Wrapper : 기본자료형을 객체화 기본자료형에는 없는 메소드가 추가. (Boolean,Byte,Character,Integer,Double.....)
		//Comparable compareTo() :상속해서 구현, 객체수정, Comparator compare() : 수정없이 바로 사용가능 가 재정의 되어 있다.
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
		System.out.println("- 사번 : ");
		int empNo = scanner.nextInt();
		
		System.out.println("- 이름 : ");
		String empName = scanner.next();
		
		System.out.println("- 연락처 : ");
		String phone = scanner.next();
		
		System.out.println("- 나이 : ");
		int age = scanner.nextInt();
		
		System.out.println("- 부서 : ");
		String dept = scanner.next();
		
		System.out.println("- 직급 : ");
		String compRank=scanner.next();
		
		Employee employee = new Employee(empNo, empName, phone, age, dept, compRank);
		tSet.add(employee);
		System.out.println(empName+"님의 정보가 정삭적으로 입력 되었습니다.");
	}
	
	private static void empList() {
		
		System.out.println();
		System.out.println("사번\t이름\t연락처\t\t나이\t부서\t직급");
		
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
		System.out.println("수정할 사번 : ");
		int empNo = scanner.nextInt();
		System.out.println("수정할 필드 선택[1. 연락처, 2. 나이, 3. 부서, 4. 직급]");
		int ch = scanner.nextInt();
		
		Employee employee = findEmployee(empNo);
		
		if(employee == null) {
			System.out.println("결과 : 해당 사원이 존재하지 않습니다.");
			return; 
		}
		while (true) {
			if(ch == 1) {
			System.out.println("수정할 연락처를 입력하세요.");
			employee.setPhone(scanner.next());
			System.out.println("연락처가 수정되었습니다.");
			break;
		}else if(ch ==2) {
			System.out.println("수정할 나이를 입력하세요.");
			employee.setAge(scanner.nextInt());
			System.out.println("나이가 수정되었습니다.");
			break;
		}else if(ch ==3) {
			System.out.println("수정할 부서를 입력하세요.");
			employee.setDept(scanner.next());
			System.out.println("부서가 수정되었습니다.");
			break;
		}else if(ch ==4) {
			System.out.println("수정할 직급을 입력하세요.");
			employee.setCompRank(scanner.next());
			System.out.println("직급이 수정되었습니다.");
			break;
		}
			
		}
		
		
		
	}
	
	private static void empDel() {
		
		System.out.println("삭제할 사번 : ");
		int empNo = scanner.nextInt();
		
		Employee employee = findEmployee(empNo);
		
		if(employee == null) {
			System.out.println("결과 : 해당 사원이 존재하지 않습니다.");
			return; 
		}
		//removeEmp(empNo);
		tSet.remove(employee); //이렇게 하면 removeEmp재정의해서 할필요가없다..
		System.out.println(employee.getEmpName()+"사원이 삭제 되었습니다.");
		
		
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
		 	System.out.println("사번이 존재하지 않습니다.");
			return null;	
	}		
	
	public static void main(String[] args) {

		
		boolean run = true;
		while (run) {
			System.out.println("=================================================");
			System.out.println("# 1. 사원정보 신규등록" );
			System.out.println("# 2. 사원정보 검색" );
			System.out.println("# 3. 사원정보 수정" );
			System.out.println("# 4. 사원정보 삭제" );
			System.out.println("# 5. 프로그램 종료" );
			System.out.println("=================================================");
			System.out.println("선택>>");
			int selectNo = scanner.nextInt();
			
			if (selectNo == 1) {
				System.out.println("메뉴 입력 : "+ selectNo);
				creatEmp(); //메소드 호출
			}else if (selectNo ==2) {
				System.out.println("메뉴 입력 : "+ selectNo);
				empList();
			}else if (selectNo ==3) {
				System.out.println("메뉴 입력 : "+ selectNo);
				empRe();
			}else if (selectNo ==4) {
				System.out.println("메뉴 입력 : "+ selectNo);
				empDel();
			}else if (selectNo ==5) {
				System.out.println("메뉴 입력 : "+ selectNo);
				break;
			}
		}
		scanner.close();
		System.out.println("프로그램 종료");
		
	}

}

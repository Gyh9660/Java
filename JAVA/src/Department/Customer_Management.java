package Department;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;




/*
 * 백화점의 고객 관리 프로그램. (상속과 다형성)
 * 
 * 고객 등급 : 1. 일반고객(silver) : 보너스포인트 (구매액의 1%적립),할인율 X , 
 * 			2.Gold 고객 : 포인트 구매액의 2%적립, 한인율 5%
 * 			3. Vip 고객 : 보너스 구매액의 5% , 할인률 10%, 담당 에이전트가 존재
 */
class Customer {
	int customerID; 		//고객 ID
	String customerName;	//고객 이름
	String customerGrade;	//고객 등급(Silver, Gold, VIP)
	double bonusPoint;		//보너스 포인트값
	private double bonusRatio;		//보너스 포인트 적립율
	private double saleRatio;
 
	
	public Customer() {
	}

	Customer(int customerID,String customerName){
		this.customerID =customerID;
		this.customerName = customerName;
		this.customerGrade = "Silver";
		this.bonusRatio = 0.01;
	}
	//생성자에서 기본으로 2개의 필드값은 로드 customerGrad : silver ,bonusRatio :1% 
	
	public double clacPrice(int price) { //하위 클래스에서 오버라이딩 해서 처리>>
		//물품의 가격을 받아서 보너스 포인트 적립하는 코드
		bonusPoint += price*bonusRatio;
		System.out.println(customerID+"고객님"+price+"원 지불 하셨습니다.");
		System.out.println(customerID+"고객님 등급은"+customerGrade+"이고 현재 포인트는 "+bonusPoint+"이고 할인은"+(price*saleRatio)+"원 되었습니다.");
		
		return price; //할인된 가격을 리턴
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerGrade() {
		return customerGrade;
	}
	public void setCustomerGrade(String customerGrade) {
		this.customerGrade = customerGrade;
	}
	public double getBonusPoint() {
		return bonusPoint;
	}
	public void setBonusPoint(double bonusPoint) {
		this.bonusPoint = bonusPoint;
	}
	public double getBonusRatio() {
		return bonusRatio;
	}
	public void setBonusRatio(double bonusRatio) {
		this.bonusRatio = bonusRatio;
	}
	public String toString() {
		return customerID+"\t"+customerName+"\t"+customerGrade+"\t\t"+bonusRatio;
		
	}
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Customer) {
			if(this.customerID== ((Customer)obj).customerID) {
				return true;
			}
		}
		return false;
	
	}
	@Override
		public int hashCode() {
			return Objects.hash(customerID);
		}
}

class GoldCustomer extends Customer{
	
	double saleRatio; 	//물품 할인율 : 생성자에서 기본으로 : 5%
	public GoldCustomer() {
	}
	public GoldCustomer(int customerID,String customerName) {
		super(customerID,customerName);
		setCustomerGrade("Gold");
		setBonusRatio(0.02);
		setSaleRatio(0.05);
	}
		
	

	public double getSaleRatio() {
		return saleRatio;
	}
	public void setSaleRatio(double saleRatio) {
		this.saleRatio = saleRatio;
	}
	//생성자에서 기본으로 2개의 필드값은 로드 customerGrad : Gold ,bonusRatio :2% 
	@Override
	public double clacPrice(int price) {
		super.bonusPoint += price*getBonusRatio();
		System.out.println(customerID+"고객님"+(price-(price*saleRatio))+"원 지불 하셨습니다.");
		System.out.println(customerID+"고객님 등급은"+customerGrade+"이고 현재 포인트는 "+bonusPoint+"이고 할인은"+(price*saleRatio)+"원 되었습니다.");
		
		return price;
	}
	public String toString() {
		return getCustomerID()+"\t"+getCustomerName()+"\t"+getCustomerGrade()+"\t"+getSaleRatio()+"\t"+getBonusRatio();
	}
}

class VIPCustomer extends Customer{
	private int agentID; //바로접근x
	
	double saleRatio;	//물품할인율 10%
	public VIPCustomer() {
	}
	public VIPCustomer(int customerID,String customerName) {
		super(customerID,customerName);
		setCustomerGrade("VIP");
		setBonusRatio(0.05);
		setSaleRatio(0.1);
		getAgentID();
	}
	public double getSaleRatio() {
		return saleRatio;
	}
	public void setSaleRatio(double saleRatio) {
		this.saleRatio = saleRatio;
	}
	public int getAgentID() {
		return agentID;
	}
	public void setAgentID(int agentID) {
		this.agentID = agentID;
	}
	@Override
	public double clacPrice(int price) {
		super.bonusPoint += price*getBonusRatio();
		System.out.println(customerID+"고객님"+(price-(price*saleRatio))+"원 지불 하셨습니다.");
		System.out.println(customerID+"고객님 등급은"+customerGrade+"이고 현재 포인트는 "+bonusPoint+"이고 할인은"+(price*saleRatio)+"원 되었습니다.");
		return price;
	}
	public String toString() {
		return getCustomerID()+"\t"+getCustomerName()+"\t"+getCustomerGrade()+"\t"+getSaleRatio()+"\t"+getBonusRatio()+"\t\t"+getAgentID();
	}
}




public class Customer_Management {
	private static Scanner sc = new Scanner(System.in);
	private static Set<Customer> customerHashSet = new HashSet<Customer>();
	
	private static void creatSilver() {
		
		System.out.println("==일반고객 등록입니다==");
		System.out.println("고객 아이디 : ");
		int id = sc.nextInt();
		System.out.println("고객 이름 : ");
		String name = sc.next();
		Customer customer = new Customer(id, name);
		customerHashSet.add(customer);
	}
	private static void creatGold() {
		System.out.println("==Gold고객 등록입니다==");
		System.out.println("고객 아이디 : ");
		int id = sc.nextInt();
		System.out.println("고객 이름 : ");
		String name = sc.next();
		GoldCustomer gold = new GoldCustomer(id, name);
		customerHashSet.add(gold);
	}
	private static void creatVIP() {
		
		System.out.println("==VIP고객 등록입니다==");
		System.out.println("고객 아이디 : ");
		int id = sc.nextInt();
		System.out.println("고객 이름 : ");
		String name = sc.next();
		VIPCustomer vip = new VIPCustomer(id, name);
		System.out.println("담당에이젼트(ID) 등록 : ");
		vip.setAgentID(sc.nextInt());
		customerHashSet.add(vip);
	}
	private static void customerList() {
		System.out.println("==고객정보 출력입니다==");
		System.out.println("고객ID\t고객이름\t고객등급\t할인률\t보너스포인트비율\t에이젼트ID<VIP고객>");
		Iterator<Customer> iterator = customerHashSet.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next()+"\t");
		}
		System.out.println();
	}
	private static void buy() {
		System.out.println("==물품가격을 지불해 주세요 ==");
		System.out.println("고객 ID를 입력해 주세요.");
		int id;
		id = sc.nextInt();
		System.out.println("구매 물품 가격 : ");
		int price;
		price = sc.nextInt();
		Customer customer = findCustomer(id);
		if(customer == null) {
			System.out.println("결과 : 해당 고객이 존재하지 않습니다.");
			return; 
		}
		customer.clacPrice(price);
		
	}
	private static Customer findCustomer(int customerID) {
		Iterator<Customer> ir = customerHashSet.iterator(); 
		 while (ir.hasNext()) {					
			 Customer customer = ir.next();			
		 	int tempCustomerID = customer.getCustomerID();
		 	
		 	if (tempCustomerID == customerID){
		 		return customer;
		 	}
		 }
		 	System.out.println("ID가 존재하지 않습니다.");
			return null;	
	}		
	
	
	public static void main(String[] args) {
		
		
		
		int num = 0;
		boolean run = true;		
		while(run) {
		System.out.println("===============================================================================================");
		System.out.println("1. 일반고객 등록 | 2. VIP 고객등록 | 3. Gold 고객 등록 | 4. 정보 출력 | 5. 물품구매 | 6. 종료 ");
		System.out.println("===============================================================================================");
			System.out.println("선택>>");
			num = sc.nextInt();
			
			if(num == 1) {
				System.out.println("선택 >> 1");
				creatSilver();
			}else if(num == 2) {
				System.out.println("선택 >> 2");
				creatVIP();
			}else if(num == 3) {
				System.out.println("선택 >> 3");
				creatGold();
			}else if(num == 4) {
				System.out.println("선택 >> 4");
				customerList();
			}else if(num == 5) {
				System.out.println("선택 >> 5");
				buy();
			}else if(num == 6) {
				System.out.println("선택 >> 6");
				break;
			}
		}
		System.out.println("프로그램 종료");
		sc.close();
/*
		
		======================================================================
		1. 일반고객 등록	|   2. VIP 고객등록      |  3. Gold 고객 등록   4. 정보 출력    5. 물품구매  5. 종료 
		======================================================================
		선택 >> 1
		==일반고객 등록 입니다. ==
		고객 아이디 : 
		고객이름 : 

		선택 >>2
		==VIP 고객 등록 입니다. ==
		고객 아이디 : 
		고객이름 : 
		담당에이젼트(ID) 등록 : 

		선택 >>3
		==Gold 고객 등록 입니다. ==
		고객 아이디 : 
		고객이름 : 

		선택 >>4
		==고객 정보 출력  입니다. ==
		고객ID	고객이름	고객등급	할인률	보너스포인트비율	에이젼트ID<VIP고객>



		선택 >>5
		==물품가격을 지불해 주세요 ==
		구매 물품 가격 :  

		000 고객님 000 원 지불 하셨습니다. 
		000 고객님의 등급은 000 이고 현재 포인트는 000 이고 할인은 000원 되었습니다. 

		*/
		
		
		
	}

}

package Department;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;




/*
 * ��ȭ���� �� ���� ���α׷�. (��Ӱ� ������)
 * 
 * �� ��� : 1. �Ϲݰ�(silver) : ���ʽ�����Ʈ (���ž��� 1%����),������ X , 
 * 			2.Gold �� : ����Ʈ ���ž��� 2%����, ������ 5%
 * 			3. Vip �� : ���ʽ� ���ž��� 5% , ���η� 10%, ��� ������Ʈ�� ����
 */
class Customer {
	int customerID; 		//�� ID
	String customerName;	//�� �̸�
	String customerGrade;	//�� ���(Silver, Gold, VIP)
	double bonusPoint;		//���ʽ� ����Ʈ��
	private double bonusRatio;		//���ʽ� ����Ʈ ������
	private double saleRatio;
 
	
	public Customer() {
	}

	Customer(int customerID,String customerName){
		this.customerID =customerID;
		this.customerName = customerName;
		this.customerGrade = "Silver";
		this.bonusRatio = 0.01;
	}
	//�����ڿ��� �⺻���� 2���� �ʵ尪�� �ε� customerGrad : silver ,bonusRatio :1% 
	
	public double clacPrice(int price) { //���� Ŭ�������� �������̵� �ؼ� ó��>>
		//��ǰ�� ������ �޾Ƽ� ���ʽ� ����Ʈ �����ϴ� �ڵ�
		bonusPoint += price*bonusRatio;
		System.out.println(customerID+"����"+price+"�� ���� �ϼ̽��ϴ�.");
		System.out.println(customerID+"���� �����"+customerGrade+"�̰� ���� ����Ʈ�� "+bonusPoint+"�̰� ������"+(price*saleRatio)+"�� �Ǿ����ϴ�.");
		
		return price; //���ε� ������ ����
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
	
	double saleRatio; 	//��ǰ ������ : �����ڿ��� �⺻���� : 5%
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
	//�����ڿ��� �⺻���� 2���� �ʵ尪�� �ε� customerGrad : Gold ,bonusRatio :2% 
	@Override
	public double clacPrice(int price) {
		super.bonusPoint += price*getBonusRatio();
		System.out.println(customerID+"����"+(price-(price*saleRatio))+"�� ���� �ϼ̽��ϴ�.");
		System.out.println(customerID+"���� �����"+customerGrade+"�̰� ���� ����Ʈ�� "+bonusPoint+"�̰� ������"+(price*saleRatio)+"�� �Ǿ����ϴ�.");
		
		return price;
	}
	public String toString() {
		return getCustomerID()+"\t"+getCustomerName()+"\t"+getCustomerGrade()+"\t"+getSaleRatio()+"\t"+getBonusRatio();
	}
}

class VIPCustomer extends Customer{
	private int agentID; //�ٷ�����x
	
	double saleRatio;	//��ǰ������ 10%
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
		System.out.println(customerID+"����"+(price-(price*saleRatio))+"�� ���� �ϼ̽��ϴ�.");
		System.out.println(customerID+"���� �����"+customerGrade+"�̰� ���� ����Ʈ�� "+bonusPoint+"�̰� ������"+(price*saleRatio)+"�� �Ǿ����ϴ�.");
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
		
		System.out.println("==�Ϲݰ� ����Դϴ�==");
		System.out.println("�� ���̵� : ");
		int id = sc.nextInt();
		System.out.println("�� �̸� : ");
		String name = sc.next();
		Customer customer = new Customer(id, name);
		customerHashSet.add(customer);
	}
	private static void creatGold() {
		System.out.println("==Gold�� ����Դϴ�==");
		System.out.println("�� ���̵� : ");
		int id = sc.nextInt();
		System.out.println("�� �̸� : ");
		String name = sc.next();
		GoldCustomer gold = new GoldCustomer(id, name);
		customerHashSet.add(gold);
	}
	private static void creatVIP() {
		
		System.out.println("==VIP�� ����Դϴ�==");
		System.out.println("�� ���̵� : ");
		int id = sc.nextInt();
		System.out.println("�� �̸� : ");
		String name = sc.next();
		VIPCustomer vip = new VIPCustomer(id, name);
		System.out.println("��翡����Ʈ(ID) ��� : ");
		vip.setAgentID(sc.nextInt());
		customerHashSet.add(vip);
	}
	private static void customerList() {
		System.out.println("==������ ����Դϴ�==");
		System.out.println("��ID\t���̸�\t�����\t���η�\t���ʽ�����Ʈ����\t������ƮID<VIP��>");
		Iterator<Customer> iterator = customerHashSet.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next()+"\t");
		}
		System.out.println();
	}
	private static void buy() {
		System.out.println("==��ǰ������ ������ �ּ��� ==");
		System.out.println("�� ID�� �Է��� �ּ���.");
		int id;
		id = sc.nextInt();
		System.out.println("���� ��ǰ ���� : ");
		int price;
		price = sc.nextInt();
		Customer customer = findCustomer(id);
		if(customer == null) {
			System.out.println("��� : �ش� ���� �������� �ʽ��ϴ�.");
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
		 	System.out.println("ID�� �������� �ʽ��ϴ�.");
			return null;	
	}		
	
	
	public static void main(String[] args) {
		
		
		
		int num = 0;
		boolean run = true;		
		while(run) {
		System.out.println("===============================================================================================");
		System.out.println("1. �Ϲݰ� ��� | 2. VIP ����� | 3. Gold �� ��� | 4. ���� ��� | 5. ��ǰ���� | 6. ���� ");
		System.out.println("===============================================================================================");
			System.out.println("����>>");
			num = sc.nextInt();
			
			if(num == 1) {
				System.out.println("���� >> 1");
				creatSilver();
			}else if(num == 2) {
				System.out.println("���� >> 2");
				creatVIP();
			}else if(num == 3) {
				System.out.println("���� >> 3");
				creatGold();
			}else if(num == 4) {
				System.out.println("���� >> 4");
				customerList();
			}else if(num == 5) {
				System.out.println("���� >> 5");
				buy();
			}else if(num == 6) {
				System.out.println("���� >> 6");
				break;
			}
		}
		System.out.println("���α׷� ����");
		sc.close();
/*
		
		======================================================================
		1. �Ϲݰ� ���	|   2. VIP �����      |  3. Gold �� ���   4. ���� ���    5. ��ǰ����  5. ���� 
		======================================================================
		���� >> 1
		==�Ϲݰ� ��� �Դϴ�. ==
		�� ���̵� : 
		���̸� : 

		���� >>2
		==VIP �� ��� �Դϴ�. ==
		�� ���̵� : 
		���̸� : 
		��翡����Ʈ(ID) ��� : 

		���� >>3
		==Gold �� ��� �Դϴ�. ==
		�� ���̵� : 
		���̸� : 

		���� >>4
		==�� ���� ���  �Դϴ�. ==
		��ID	���̸�	�����	���η�	���ʽ�����Ʈ����	������ƮID<VIP��>



		���� >>5
		==��ǰ������ ������ �ּ��� ==
		���� ��ǰ ���� :  

		000 ���� 000 �� ���� �ϼ̽��ϴ�. 
		000 ������ ����� 000 �̰� ���� ����Ʈ�� 000 �̰� ������ 000�� �Ǿ����ϴ�. 

		*/
		
		
		
	}

}

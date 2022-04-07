package chap17.Ex13;

//�Ϸ� �ð� : ���� ��ħ 9: 30�б��� , p.jangwoo@gmail.com, �� ����Կ��� ���� 
import java.util.Scanner;

class Account2{ //���������������ϴ� ��ü ,�߿��� �ʵ�,private ĸ��ȭ 
				//DTO, VO<==���������� �ʵ��ǰ��� �����ϰ� �����ϴ� ���
				//��ü�� �ʵ�����(x) ������(o) getter,setter(o)
	private String ano ; 	//���� ��ȣ
	private String owner;   //���� �� , �̸�
	private int balance; 	// ���� �ݾ�, 
		
	Account2 (String ano, String owner, int balance){ //��ü ������ �ʵ��� ���� �޾Ƽ� �ʵ忡 �ε�
		this.ano=ano;
		this.owner=owner;
		this.balance=balance;
	}
	//getter,setter

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
}

public class BankAccountUsingArray_2 {
	//�迭�� ����ؼ� Account ��ü ��� 
	private static Account2[] accountArray = new Account2[100];    //�迭�� ��ü ����. 
		//Account[] : �迭Ÿ��,����Ÿ�� �迭�� ���濡 ���� �������� ���� ��� �⺻������ NULL
		//�迭 ������ ��(index) �� ũ�⸦ ����, index =0 , length()<==�迭���� ����,
	private static Scanner scanner = new Scanner(System.in); 
	
	private static void createAccount() {
		//�ڵ� �ۼ� : 1. ���� ����.  ��ĳ�ʷ� 1.���¹�ȣ, 2. �̸�, 3. �ʱ����� �ݾ�
		//�迭 ��ü�� ����. 
		System.out.println("----------------");
		System.out.println("1. ���� ����");
		System.out.println("----------------");
		System.out.println("���� ��ȣ�� �Է� �ϼ���.");
		String ano = scanner.next(); // ���¹�ȣ�� ��ǲ�޾Ƽ� ano������ �Ҵ� <�޼ҵ� �������� ����ϴ� ��������>
		System.out.println("�̸��� �Է� �ϼ���.");
		String owner = scanner.next();
		System.out.println("���� ������ �ʱ� �ݾ��� �Է��ϼ���.");
		int balance = scanner.nextInt();
		
		//���ʵ��� ������ ����ڷ� ���� �Ҵ� �޾Ƽ� ��ü�� ������ ��ü�� �ʵ��� ���� ����.
		Account2 account2 = new Account2(ano, owner, balance);//�����ڸ� ���ؼ� ��ü�� �ʵ尪 ������ ��ü����
		
		//�迭 ������ �޼ҵ�ܺο��� ����. �������� : ��� �޼ҵ忡�� ��밡��
		//��ü�� �迭�� ����. (����ִ� �濡 ����).for���� ����ؼ� null�ι��� ã�Ƽ�null�� ��� ��ü�� ����.
		for (int i=0; i<accountArray.length;i++) { //accountArray�迭 ���� 0~99����� ��ȸ
			if(accountArray[i]==null) { //0������� null�ι��� ã�Ƽ� null�� ��� ��ü�� �迭�� ����
				accountArray[i]= account2; //null�� �濡 ��ü�� ����
				System.out.println("���°� ���������� �����Ǿ����ϴ�.");
				break; //���»����ϰ� for���� �������´�(�������;���,,)
			}
		}
		
		
		
		
		
	}
	private static void accountList() {
		//�ڵ� �ۼ� :2. ���� ��� ��� :  �迭�� ����� ��ü�� �����ͼ� ���¹�ȣ, �̸�, �ݾ� �� ���
		//�迭�� �� ���� ��ȸ �ϸ鼭 null�� �ƴѰ�� �迭���� ��ü�� ������ �ʵ��� ������ ���
		System.out.println("-----------");
		System.out.println("2.���¸�����");
		System.out.println("-----------");
		
		//�迭�� ������ ���� null�� �ƴ� ���, ��ü�� �ʵ��� ���� ���
		for(int i =0; i<accountArray.length; i++) {
			//�� ���� ��ü�� ��� ������ ����
			Account2 account2 = accountArray[i]; //0������� 99������� ������ ��ü�� ������ͼ� account2 ���������� ��´�.
			if (account2 != null) { //�� ���� ���� null�� �ƴ� ��츸 ��ü������ �����ͼ� ���.
				System.out.print(account2.getAno());//��������
				System.out.print("    ");
				System.out.print(account2.getOwner()); //�̸�
				System.out.print("    "); 
				System.out.print(account2.getBalance()); //�ݾ�
				System.out.println(); //���� ����
			}
		}
		
		
		
		
		
	}
	private static void deposit() {
		//�ڵ� �ۼ� : 3. ���� <== ���¹�ȣ�� �޾Ƽ� ��ü���� �ش� ���¸� ã�Ƽ�, �Աݱݾ� : �ش� ���¿� ����. 
		//1.����ڷκ��� �Ա��� ���¸� �޾ƾߵȴ�.
		//2. ����ڷ� ���� ���� ��ȣ�� �迭�� ����� ��ü���� ���ҹ�ȣ�� Ȯ���� �ش���¿� �Է�
		
		System.out.println("------------");
		System.out.println("3. �����ϱ�");
		System.out.println("------------");
		System.out.println("������ ���� ��ȣ�� �Է��ϼ���.");
		String ano = scanner.next();
		System.out.println("������ �ݾ��� �Է��ϼ���.");
		int money = scanner.nextInt();
		
		//�ش� ���¸� �迭���� ã�Ƽ� ã�� ��ü�� �޾ƿ´�.
		Account2 account2 = findAccount(ano); // findAccount(���¹�ȣ) ȣ��

		if(account2 == null) {
			System.out.println("��� : �ش� ���°� �������� �ʽ��ϴ�.");
			return; //�޼ҵ带 �������� ,����
		}
		account2.setBalance(account2.getBalance()+money);//setter�� ����ؼ� ������ �ݾ�+ �߰��Ա��ѱݾ�
		System.out.println("��� : ������ ���������� �Ϸ� �Ǿ����ϴ�.");
		
		
		
	}
	private static void withdraw() {
		//�ڵ� �ۼ� : 4. ��� <== ���� ��ȣ�� ��ǲ �޾� �ش� ���¸� ��ü���� ã�Ƽ� ���. 
		//1.����ڷκ��� �Ա��� ���¸� �޾ƾߵȴ�.
		//2. ����ڷ� ���� ���� ��ȣ�� �迭�� ����� ��ü���� ���ҹ�ȣ�� Ȯ���� �ش���¿� �Է�
		System.out.println("------------");
		System.out.println("4. ����ϱ�");
		System.out.println("------------");
		System.out.println("����� ���� ��ȣ�� �Է��ϼ���.");
		String ano = scanner.next();
		System.out.println("����� �ݾ��� �Է��ϼ���.");
		int money = scanner.nextInt();
		
		//�ش� ���¸� �迭���� ã�Ƽ� ã�� ��ü�� �޾ƿ´�.
		Account2 account2 = findAccount(ano); // findAccount(���¹�ȣ) ȣ��

		if(account2 == null) {
			System.out.println("��� : �ش� ���°� �������� �ʽ��ϴ�.");
			return; //�޼ҵ带 �������� ,����
		}
		account2.setBalance(account2.getBalance()-money);//setter�� ����ؼ� ������ �ݾ� - ����ѱݾ�
		System.out.println("��� : ����� ���������� �Ϸ� �Ǿ����ϴ�.");
		System.out.println("���� �ݾ� : " + account2.getBalance());
	} 
	
	//�迭���� Account ��ü ���� ano[���¹�ȣ] �� ������ ���¸� ã�Ƽ� ã�� ��ü�� �������� ������. 
	//����,����Ҷ� �����ڵ� /���� �޼ҵ忡�� �ߺ� ���ɶ� ������ �޼ҵ带 �����ؼ� �ߺ��ڵ带 �����ϰ� ����� �ش�.
	private static Account2 findAccount(String ano) {
		Account2 account2 = null ; 
		//�ڵ� �ۼ� 
		for (int i =0; i<accountArray.length; i++) {
			if (accountArray[i] != null) {//�迭���� ���� null�� �ƴ� ��쿡 ��ü�� ano[����]��ȣ.Ȯ��
				//�� ��ü�� ���� ano�� ��� ���� ����.
				String dbAno = accountArray[i].getAno(); //�迭�� �� �濡 ����� ��ü��ano�� dbAno������ �Ҵ�.
				if(dbAno.equals(ano)) {
					account2 = accountArray[i];
					break;
				}
			}
		}
		return account2; 
	}
	
	
	
	

	public static void main(String[] args) {
		boolean run = true; 
		while (run) {
			System.out.println("-----------------------------------------------");
			System.out.println("1.���»��� | 2.���¸�� | 3.���� | 4.��� | 5.����");
			System.out.println("-----------------------------------------------");
			System.out.println("����>>");
			int selectNo = scanner.nextInt(); 
			
			if (selectNo == 1) {
				createAccount() ; 	//�޼ҵ� ȣ�� , ��ü���� ���� �޼ҵ������ ȣ��(static)
			}else if (selectNo == 2) {
				accountList(); 
			}else if (selectNo == 3) {
				deposit(); 
			}else if (selectNo == 4) {
				withdraw(); 
			}else if (selectNo == 5) {
				run = false; 
				//break; 
			}
			
		}
		scanner.close(); 
		System.out.println("���α׷� ����");
		
	}

}

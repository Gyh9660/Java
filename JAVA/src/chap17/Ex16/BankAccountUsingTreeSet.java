package chap17.Ex16;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;



//Account ��ü�� TreeSet�ȿ� ����, ano[���� ��ȣ], owner[�̸�], balance[���ݱݾ�]
//TreeSet�� �Ϲݰ�ü�� ������ � �÷��� ���������� ����, comparable<E>, Comparator<E>
//Account ��ü�� �������� �ʰ�, balance ���� ū�ͺ��� ��µǵ��� ����<��������>


public class BankAccountUsingTreeSet {

	private static TreeSet<Account> tSet = new TreeSet<Account>(new Comparator<Account>() {
		@Override
		public int compare(Account o1, Account o2) {
			if(o1.getBalance() < o2.getBalance()) {
				return 1;
			}else if(o1.getBalance() == o2.getBalance()) {
				return 0;					
			}else {
				return -1;
			}
		}
	});
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
		Account account = new Account(ano, owner, balance);//�����ڸ� ���ؼ� ��ü�� �ʵ尪 ������ ��ü����
		
		tSet.add(account);
		
		
		System.out.println("���°� ���������� �����Ǿ����ϴ�.");
		//�迭 ������ �޼ҵ�ܺο��� ����. �������� : ��� �޼ҵ忡�� ��밡��
		
		
		
		
		
		
	}
	private static void accountList() {
		//�ڵ� �ۼ� :2. ���� ��� ��� :  �迭�� ����� ��ü�� �����ͼ� ���¹�ȣ, �̸�, �ݾ� �� ���
		//�迭�� �� ���� ��ȸ �ϸ鼭 null�� �ƴѰ�� �迭���� ��ü�� ������ �ʵ��� ������ ���
		System.out.println("-----------");
		System.out.println("2.���¸�����");
		System.out.println("-----------");
		//�迭�� ������ ���� null�� �ƴ� ���, ��ü�� �ʵ��� ���� ���
		
		Iterator<Account> iterator = tSet.iterator();
		while (iterator.hasNext()) {
			Account account = iterator.next();			//Next(); ���� �����ְ� ���������� �̵�
			System.out.print(account.getAno());//��������
			System.out.print("    ");
			System.out.print(account.getOwner()); //�̸�
			System.out.print("    "); 
			System.out.print(account.getBalance()); //�ݾ�
			System.out.println(); //���� ����
		}
		System.out.println();
			
		
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
		Account account = findAccount(ano); // findAccount(���¹�ȣ) ȣ��
	
		if(account == null) {
			System.out.println("��� : �ش� ���°� �������� �ʽ��ϴ�.");
			return; //�޼ҵ带 �������� ,����
		}
		account.setBalance(account.getBalance()+money);//setter�� ����ؼ� ������ �ݾ�+ �߰��Ա��ѱݾ�
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
		Account account = findAccount(ano); // findAccount(���¹�ȣ) ȣ��
	
		if(account == null) {
			System.out.println("��� : �ش� ���°� �������� �ʽ��ϴ�.");
			return; //�޼ҵ带 �������� ,����
		}
		account.setBalance(account.getBalance()-money);//setter�� ����ؼ� ������ �ݾ� - ����ѱݾ�
		System.out.println("��� : ����� ���������� �Ϸ� �Ǿ����ϴ�.");
		System.out.println("���� �ݾ� : " + account.getBalance());
	} 
	
	//�迭���� Account ��ü ���� ano[���¹�ȣ] �� ������ ���¸� ã�Ƽ� ã�� ��ü�� �������� ������. 
	//����,����Ҷ� �����ڵ� /���� �޼ҵ忡�� �ߺ� ���ɶ� ������ �޼ҵ带 �����ؼ� �ߺ��ڵ带 �����ϰ� ����� �ش�.
	private static Account findAccount(String ano) {
		//�ڵ� �ۼ� 
		Iterator<Account> ir = tSet.iterator(); //iterator :��ȸ��,
		 while (ir.hasNext()) {					//hasNext() :hashSet�� ���������ҋ� true,false
		 	Account account = ir.next();			//Next(); ���� �����ְ� ���������� �̵�
		 	String tempid = account.getAno();
		 	
		 	if (tempid.equals(ano)){
		 		return account;
		 	}
		 }
		 	System.out.println("���̵� �������� �ʽ��ϴ�.");
			return null;	
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

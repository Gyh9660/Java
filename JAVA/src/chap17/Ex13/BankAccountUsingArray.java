package chap17.Ex13;

import java.util.Scanner;

class Account{
	private String ano; //���¹�ȣ
	private String owner; //������, �̸�
	private int balance; //���� �ݾ�
	
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



public class BankAccountUsingArray {
	//�迭�� ����ؼ� Account ��ü ���
	private static Account[] accountArray = new Account[100]; //�迭�� ��ü ����.
	private static Scanner scanner = new Scanner(System.in);
	
	private static void createAccount() {
		//�ڵ��ۼ� : 1. ���»���. scanner�� 1.���¹�ȣ 2.�̸� 3.�ʱ�����ݾ�
		//�迭 ��ü�� ���� Account������
		Account account = new Account();
		System.out.println("���¹�ȣ�� �Է��ϼ���");
		account.setAno(scanner.next());
		System.out.println("�̸��� �Է��ϼ���");
		account.setOwner(scanner.next());
		System.out.println("�ʱ�����ݾ��� �Է��ϼ���");
		account.setBalance(scanner.nextInt());
		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] == null) {
				accountArray[i] = account;
				System.out.println("���°� �����Ǿ����ϴ�.");
				break;
			}
		}
	}
	private static void accountList() {
		//�ڵ��ۼ� 2.���¸�� ��� : �迭�� ����� ��ü�� �����ͼ� ���¹�ȣ, �̸�, �ݾ��� ���
		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] == null) {
				break;
			}else {
				System.out.println(
				accountArray[i].getOwner() + "\t" +accountArray[i].getAno()  + "\t" + accountArray[i].getBalance()+"��");
			}
			
		}
	}
	private static void deposit() {
		//�ڵ��ۼ� : 3.���� <== ���¹�ȣ�� �޾Ƽ� ��ä���� �ش� ���¸� ã�Ƽ�, �Աݱݾ��� ��ǲ�޾Ƽ� ����
		System.out.println("���¹�ȣ�� �Է��ϼ���.");
		String ano = scanner.next();
		System.out.println("���ݾ�");
		int dep = scanner.nextInt();
		if (findAccount(ano) == null) {
			System.out.println("���¹�ȣ�� ã�� ���߽��ϴ�.");
		} else {
			findAccount(ano).setBalance(findAccount(ano).getBalance() + dep);
			System.out.println("�ԱݿϷ�");
		}
	}
	private static void withdraw() {
		//�ڵ��ۼ� : 4.��� <== ���¹�ȣ�� ��ǲ �޾Ƽ� ��ü���� �ش� ���¸� ã�Ƽ� ���
		System.out.println("���¹�ȣ�� �Է��ϼ���.");
		String ano = scanner.next();
		System.out.print("��ݾ�");
		int wit = scanner.nextInt();
		
		if (findAccount(ano) == null) {
			System.out.println("���¹�ȣ�� ã�� ���߽��ϴ�.");
		} else {
			if (wit > findAccount(ano).getBalance()) {
				System.out.println("�ܾ׺��� ū �׼��� �Է��ϼ̽��ϴ�.");
			} else {
				findAccount(ano).setBalance(findAccount(ano).getBalance() - wit);
				System.out.println("��ݿϷ�");
			}
		}
	}
	//�迭���� Account ��ü���� ano[���¹�ȣ]�� ������ ���¸� ã�Ƽ� ã�� ��ü�� �������� ������
	private static Account findAccount(String ano) {
		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] == null) {
				break;
			}else if (accountArray[i].getAno().equals(ano)) {
				return accountArray[i];
			}
			
		}	
		
		return null;
	}

	public static void main(String[] args) {
			boolean run = true;
			while (run) {
				System.out.println("-------------------------------------------------");
				System.out.println("1.���»��� | 2.���¸�� | 3.���� | 4.��� | 5.����");
				System.out.println("-------------------------------------------------");
				System.out.println("����>>");
				int selectNo = scanner.nextInt();
				
				if (selectNo == 1) {
					createAccount(); //�޼ҵ� ȣ��
				}else if (selectNo ==2) {
					accountList();
				}else if (selectNo ==3) {
					deposit();
				}else if (selectNo ==4) {
					withdraw();
				}else if (selectNo ==5) {
					break;
				}
			}
			scanner.close();
			System.out.println("���α׷� ����");
	}

}

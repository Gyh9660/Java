package chap17.Ex13;

import java.util.Scanner;

class Account{
	private String ano; //계좌번호
	private String owner; //계좌주, 이름
	private int balance; //통장 금액
	
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
	//배열을 사용해서 Account 객체 등록
	private static Account[] accountArray = new Account[100]; //배열에 객체 저장.
	private static Scanner scanner = new Scanner(System.in);
	
	private static void createAccount() {
		//코드작성 : 1. 계좌생성. scanner로 1.계좌번호 2.이름 3.초기통장금액
		//배열 객체에 저장 Account를저장
		Account account = new Account();
		System.out.println("계좌번호를 입력하세요");
		account.setAno(scanner.next());
		System.out.println("이름을 입력하세요");
		account.setOwner(scanner.next());
		System.out.println("초기통장금액을 입력하세요");
		account.setBalance(scanner.nextInt());
		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] == null) {
				accountArray[i] = account;
				System.out.println("계좌가 생성되었습니다.");
				break;
			}
		}
	}
	private static void accountList() {
		//코드작성 2.계좌목록 출력 : 배열에 저장된 객체를 가져와서 계좌번호, 이름, 금액을 출력
		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] == null) {
				break;
			}else {
				System.out.println(
				accountArray[i].getOwner() + "\t" +accountArray[i].getAno()  + "\t" + accountArray[i].getBalance()+"원");
			}
			
		}
	}
	private static void deposit() {
		//코드작성 : 3.예금 <== 계좌번호를 받아서 객채에서 해당 계좌를 찾아서, 입금금액을 인풋받아서 저장
		System.out.println("계좌번호를 입력하세요.");
		String ano = scanner.next();
		System.out.println("예금액");
		int dep = scanner.nextInt();
		if (findAccount(ano) == null) {
			System.out.println("계좌번호를 찾지 못했습니다.");
		} else {
			findAccount(ano).setBalance(findAccount(ano).getBalance() + dep);
			System.out.println("입금완료");
		}
	}
	private static void withdraw() {
		//코드작성 : 4.출금 <== 계좌번호를 인풋 받아서 객체에서 해당 계좌를 찾아서 출금
		System.out.println("계좌번호를 입력하세요.");
		String ano = scanner.next();
		System.out.print("출금액");
		int wit = scanner.nextInt();
		
		if (findAccount(ano) == null) {
			System.out.println("계좌번호를 찾지 못했습니다.");
		} else {
			if (wit > findAccount(ano).getBalance()) {
				System.out.println("잔액보다 큰 액수를 입력하셨습니다.");
			} else {
				findAccount(ano).setBalance(findAccount(ano).getBalance() - wit);
				System.out.println("출금완료");
			}
		}
	}
	//배열에서 Account 객체내의 ano[계좌번호]와 동일한 계좌를 찾아서 찾은 객체를 리턴으로 돌려줌
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
				System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
				System.out.println("-------------------------------------------------");
				System.out.println("선택>>");
				int selectNo = scanner.nextInt();
				
				if (selectNo == 1) {
					createAccount(); //메소드 호출
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
			System.out.println("프로그램 종료");
	}

}

package chap17.Ex16;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;



//Account 객체를 TreeSet안에 저장, ano[계좌 번호], owner[이름], balance[예금금액]
//TreeSet에 일반객체를 넣을때 어떤 컬럼을 정렬할지를 지정, comparable<E>, Comparator<E>
//Account 객체를 수정하지 않고, balance 값이 큰것부터 출력되도록 구성<내림차순>


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
		//코드 작성 : 1. 계좌 생성.  스캐너로 1.계좌번호, 2. 이름, 3. 초기통장 금액
		//배열 객체에 저장. 
		System.out.println("----------------");
		System.out.println("1. 계좌 생성");
		System.out.println("----------------");
		System.out.println("계좌 번호를 입력 하세요.");
		String ano = scanner.next(); // 계좌번호를 인풋받아서 ano변수에 할당 <메소드 내에서만 사용하는 지역변수>
		System.out.println("이름을 입력 하세요.");
		String owner = scanner.next();
		System.out.println("계좌 개설시 초기 금액을 입력하세요.");
		int balance = scanner.nextInt();
		Account account = new Account(ano, owner, balance);//생성자를 통해서 객체에 필드값 적용후 객체생성
		
		tSet.add(account);
		
		
		System.out.println("계좌가 성공적으로 생성되었습니다.");
		//배열 선언은 메소드외부에서 선언. 전역변수 : 모든 메소드에서 사용가능
		
		
		
		
		
		
	}
	private static void accountList() {
		//코드 작성 :2. 계좌 목록 출력 :  배열에 저장된 객체를 가져와서 계좌번호, 이름, 금액 을 출력
		//배열의 각 방을 순회 하면서 null이 아닌경우 배열에서 객체를 꺼내서 필드의 정보를 출력
		System.out.println("-----------");
		System.out.println("2.계좌목록출력");
		System.out.println("-----------");
		//배열의 각방의 값이 null이 아닌 경우, 객체의 필드의 값을 출력
		
		Iterator<Account> iterator = tSet.iterator();
		while (iterator.hasNext()) {
			Account account = iterator.next();			//Next(); 값을 던져주고 다음값으로 이동
			System.out.print(account.getAno());//계좌정보
			System.out.print("    ");
			System.out.print(account.getOwner()); //이름
			System.out.print("    "); 
			System.out.print(account.getBalance()); //금액
			System.out.println(); //라인 개행
		}
		System.out.println();
			
		
	}
	private static void deposit() {
		//코드 작성 : 3. 예금 <== 계좌번호를 받아서 객체에서 해당 계좌를 찾아서, 입금금액 : 해당 계좌에 저장. 
		//1.사용자로부터 입금할 계좌를 받아야된다.
		//2. 사용자로 받은 계쫘 번호를 배열에 저장된 객체내의 계쫘번호를 확인후 해당계좌에 입력
		
		System.out.println("------------");
		System.out.println("3. 예금하기");
		System.out.println("------------");
		System.out.println("예금할 계좌 번호를 입력하세요.");
		String ano = scanner.next();
		System.out.println("예금할 금액을 입력하세요.");
		int money = scanner.nextInt();
		
		//해당 계좌를 배열에서 찾아서 찾은 객체를 받아온다.
		Account account = findAccount(ano); // findAccount(계좌번호) 호출
	
		if(account == null) {
			System.out.println("결과 : 해당 계좌가 존재하지 않습니다.");
			return; //메소드를 빠져나옴 ,종료
		}
		account.setBalance(account.getBalance()+money);//setter를 사용해서 기존의 금액+ 추가입금한금액
		System.out.println("결과 : 예금이 성공적으로 완료 되었습니다.");
		
		
		
	}
	private static void withdraw() {
		//코드 작성 : 4. 출금 <== 계좌 번호를 인풋 받아 해당 계좌를 객체에서 찾아서 출금. 
		//1.사용자로부터 입금할 계좌를 받아야된다.
		//2. 사용자로 받은 계쫘 번호를 배열에 저장된 객체내의 계쫘번호를 확인후 해당계좌에 입력
		System.out.println("------------");
		System.out.println("4. 출금하기");
		System.out.println("------------");
		System.out.println("출금할 계좌 번호를 입력하세요.");
		String ano = scanner.next();
		System.out.println("출금할 금액을 입력하세요.");
		int money = scanner.nextInt();
		
		//해당 계좌를 배열에서 찾아서 찾은 객체를 받아온다.
		Account account = findAccount(ano); // findAccount(계좌번호) 호출
	
		if(account == null) {
			System.out.println("결과 : 해당 계좌가 존재하지 않습니다.");
			return; //메소드를 빠져나옴 ,종료
		}
		account.setBalance(account.getBalance()-money);//setter를 사용해서 기존의 금액 - 출금한금액
		System.out.println("결과 : 출금이 성공적으로 완료 되었습니다.");
		System.out.println("남은 금액 : " + account.getBalance());
	} 
	
	//배열에서 Account 객체 내의 ano[계좌번호] 와 동일한 계좌를 찾아서 찾은 객체를 리턴으로 돌려줌. 
	//예금,출금할때 공통코드 /여러 메소드에서 중복 사용될때 별도의 메소드를 생성해서 중복코드를 간단하게 만들어 준다.
	private static Account findAccount(String ano) {
		//코드 작성 
		Iterator<Account> ir = tSet.iterator(); //iterator :순회자,
		 while (ir.hasNext()) {					//hasNext() :hashSet에 값이존재할떄 true,false
		 	Account account = ir.next();			//Next(); 값을 던져주고 다음값으로 이동
		 	String tempid = account.getAno();
		 	
		 	if (tempid.equals(ano)){
		 		return account;
		 	}
		 }
		 	System.out.println("아이디가 존재하지 않습니다.");
			return null;	
	}		
	public static void main(String[] args) {

		boolean run = true; 
		while (run) {
			System.out.println("-----------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("-----------------------------------------------");
			System.out.println("선택>>");
			int selectNo = scanner.nextInt(); 
			
			if (selectNo == 1) {
				createAccount() ; 	//메소드 호출 , 객체생성 없이 메소드명으로 호출(static)
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
		System.out.println("프로그램 종료");
		
		
	}

}

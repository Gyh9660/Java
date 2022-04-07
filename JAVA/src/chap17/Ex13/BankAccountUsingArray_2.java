package chap17.Ex13;

//완료 시간 : 내일 아침 9: 30분까지 , p.jangwoo@gmail.com, 각 팀장님에게 메일 
import java.util.Scanner;

class Account2{ //계좌정보를저장하는 객체 ,중요한 필드,private 캡슐화 
				//DTO, VO<==각계층으로 필드의값을 저장하고 전잘하는 기능
				//객체명 필드접근(x) 생성자(o) getter,setter(o)
	private String ano ; 	//계좌 번호
	private String owner;   //계좌 주 , 이름
	private int balance; 	// 통장 금액, 
		
	Account2 (String ano, String owner, int balance){ //객체 생성시 필드의 값을 받아서 필드에 로드
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
	//배열을 사용해서 Account 객체 등록 
	private static Account2[] accountArray = new Account2[100];    //배열에 객체 저장. 
		//Account[] : 배열타입,참조타입 배열의 각방에 값이 존재하지 않을 경우 기본값으로 NULL
		//배열 생성시 방(index) 의 크기를 선언, index =0 , length()<==배열방의 갯수,
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
		
		//각필드의 정보를 사용자로 부터 할당 받아서 객체를 생성후 객체에 필드의 값을 저장.
		Account2 account2 = new Account2(ano, owner, balance);//생성자를 통해서 객체에 필드값 적용후 객체생성
		
		//배열 선언은 메소드외부에서 선언. 전역변수 : 모든 메소드에서 사용가능
		//객체를 배열에 저장. (비어있는 방에 저장).for문을 사용해서 null인방을 찾아서null인 경우 객체를 저장.
		for (int i=0; i<accountArray.length;i++) { //accountArray배열 방을 0~99방까지 순회
			if(accountArray[i]==null) { //0번방부터 null인방을 찾아서 null일 경우 객체를 배열에 저장
				accountArray[i]= account2; //null인 방에 객체를 저장
				System.out.println("계좌가 성공적으로 생성되었습니다.");
				break; //계좌생성하고 for문을 빠져나온다(빠져나와야함,,)
			}
		}
		
		
		
		
		
	}
	private static void accountList() {
		//코드 작성 :2. 계좌 목록 출력 :  배열에 저장된 객체를 가져와서 계좌번호, 이름, 금액 을 출력
		//배열의 각 방을 순회 하면서 null이 아닌경우 배열에서 객체를 꺼내서 필드의 정보를 출력
		System.out.println("-----------");
		System.out.println("2.계좌목록출력");
		System.out.println("-----------");
		
		//배열의 각방의 값이 null이 아닌 경우, 객체의 필드의 값을 출력
		for(int i =0; i<accountArray.length; i++) {
			//각 방의 객체를 담는 변수를 선언
			Account2 account2 = accountArray[i]; //0번방부터 99번방까지 각방의 객체를 끄집어와서 account2 참조변수에 담는다.
			if (account2 != null) { //각 방의 값이 null이 아닐 경우만 객체정보를 가져와서 출력.
				System.out.print(account2.getAno());//계좌정보
				System.out.print("    ");
				System.out.print(account2.getOwner()); //이름
				System.out.print("    "); 
				System.out.print(account2.getBalance()); //금액
				System.out.println(); //라인 개행
			}
		}
		
		
		
		
		
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
		Account2 account2 = findAccount(ano); // findAccount(계좌번호) 호출

		if(account2 == null) {
			System.out.println("결과 : 해당 계좌가 존재하지 않습니다.");
			return; //메소드를 빠져나옴 ,종료
		}
		account2.setBalance(account2.getBalance()+money);//setter를 사용해서 기존의 금액+ 추가입금한금액
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
		Account2 account2 = findAccount(ano); // findAccount(계좌번호) 호출

		if(account2 == null) {
			System.out.println("결과 : 해당 계좌가 존재하지 않습니다.");
			return; //메소드를 빠져나옴 ,종료
		}
		account2.setBalance(account2.getBalance()-money);//setter를 사용해서 기존의 금액 - 출금한금액
		System.out.println("결과 : 출금이 성공적으로 완료 되었습니다.");
		System.out.println("남은 금액 : " + account2.getBalance());
	} 
	
	//배열에서 Account 객체 내의 ano[계좌번호] 와 동일한 계좌를 찾아서 찾은 객체를 리턴으로 돌려줌. 
	//예금,출금할때 공통코드 /여러 메소드에서 중복 사용될때 별도의 메소드를 생성해서 중복코드를 간단하게 만들어 준다.
	private static Account2 findAccount(String ano) {
		Account2 account2 = null ; 
		//코드 작성 
		for (int i =0; i<accountArray.length; i++) {
			if (accountArray[i] != null) {//배열방의 값이 null이 아닐 경우에 객체의 ano[계좌]번호.확인
				//각 객체의 방의 ano를 담는 변수 선언.
				String dbAno = accountArray[i].getAno(); //배열의 각 방에 저장된 객체의ano를 dbAno변수에 할당.
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

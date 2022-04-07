package chap17.Ex16;

import java.util.Objects;


public class Account {

	private String ano ; 	//계좌 번호
	private String owner;   //계좌 주 , 이름
	private int balance; 	// 통장 금액, 
		
	Account (String ano, String owner, int balance){ //객체 생성시 필드의 값을 받아서 필드에 로드
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
	@Override
		public boolean equals(Object obj) {
			if (obj instanceof Account) {
				if(this.ano.equals(((Account)obj).ano)) {//주의 : 잘못 다운캐스팅을 할 경우 : 예외가 발생됨
					return true;//this.ano == ((Account)obj).ano로 하면 안됨.<<그동안계속 안된이유
				}
			}
			return false;
		
		}
	
	@Override
		public int hashCode() {
			return Objects.hash(ano);
		}
}

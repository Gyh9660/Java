package chap06_07.Ex05;

	//접근 제어자(캡슐화:데이터를 외부로부터 보호하는 역할): 
		//public, protected, default(생략해서 사용), private
		//클래스 이름, 필드명, 메소드명, 생성자명 <<<=== 앞에 반드시 접근제어자가 할당이 되어있음
		//클래스 이름앞 : public과 default 만 사용가능

public class A {

	int m = 3; //필드의 기본 접근 제어자는 default: 생략됨, 같은 패키지 내에서만 접근가능
	int n = 4; //default : 같으느 패키지 내에 다른 클래스에서 접근이 가능 
				//다른 패키지의 클래스에서는 접근이 불가
	
	public int k = 10; //public : 다른패키지에서 접근이가능
	//private : 외부 클래스에서 접근이 불가능
			
	void print () { //default 생략 : 같은 패키지내의 클래스에서만 사용 가능
		System.out.println("임포트 성공"+m +","+n);
	}
	public void print2() {
		System.out.println("외부패키지에 다른 클래스에서 접근 가능 "+k);
	}
	public static void main(String[] args) {

		
	}

}

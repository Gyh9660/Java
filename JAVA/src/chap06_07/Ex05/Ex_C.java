package chap06_07.Ex05;

public class Ex_C {

	public static void main(String[] args) {
		//같은 패키지에 존재함.
		C c = new C(); //같은 패키지에 존재하는 클래스
		//c.company="삼성자동차"; //접근불가 private 외부클래스에서 접근 불가
		c.model = "소나타"; //모델 ,default
		c.color = "흰색";  // 색깔 protected
		c.maxSpeed = 200; // 최대속도 public
		
		c.print(); //public
		
	}

}

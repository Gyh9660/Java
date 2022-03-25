package chap10.Ex02;

class Aa{
	int m;
	void abc() { 
		System.out.println("부모메소드");
	}
}

class Bb extends Aa{
	int n;
	void bcd () {
		System.out.println("자식메소드");
	}
}


public class Inheritanc_1 {

	public static void main(String[] args) {
		//타입 캐스팅을 하지않은 경우
		Bb b = new Bb(); // b는 Aa, Bb의 필드와메소드를 다 포함. Aa, Bb 필드메소드 모두 접근가능
		b.m = 10; //부모필드
		b.n = 20; //자식필드
		b.abc(); //부모 메소드
		b.bcd(); //자식 메소드
		
		//업캐스팅 : 자식 => 부모 :Aa, Bb의 필드와 메소드를 다포함, Aa필드 메소드만 접근가능
		Aa a = new Bb();
		a.m = 100;
		//a.n = 200; //접근x 업캐스팅되어서
		a.abc();
		
		Bb bb6 = (Bb)a; //Aa[a] => Bb[bb6] 타입으로 다운캐스팅
		bb6.m = 100;
		bb6.n = 200;
		
	}

}

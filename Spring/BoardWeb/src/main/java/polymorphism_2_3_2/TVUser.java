package polymorphism_2_3_2;

public class TVUser {

	public static void main(String[] args) {
		
		//SamsungTV tv = new SamsungTV();
		LgTV tv = new LgTV();
		
		tv.powerOn();
		tv.powerOff();
		tv.volumUp();
		tv.volumDown();
		
		//인터페이스를 사용하면 약결합을 만들어서 유지 보스를 쉽게 한다.
		
	}

}

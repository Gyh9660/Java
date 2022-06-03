package polymorphism_4_2;

public class DusanTV implements TV {

	@Override
	public void powerOn() {
		System.out.println("두산TV - 전원을 켠다");

	}

	@Override
	public void powerOff() {
		System.out.println("두산TV - 전원을 끈다");

	}

	@Override
	public void volumUp() {
		System.out.println("두산TV - 소리를 키운다");

	}

	@Override
	public void volumDown() {
		System.out.println("두산TV - 소리를 줄인다");

	}

}

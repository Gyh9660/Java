package polymorphism_4_3_1;

public class SkTV implements TV {

	@Override
	public void powerOn() {
		System.out.println("SkTV - 전원을 켠다");
	}

	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("SkTV - 전원을 끈다");

	}

	@Override
	public void volumUp() {
		// TODO Auto-generated method stub
		System.out.println("SkTV - 볼륨을 키운다");

	}

	@Override
	public void volumDown() {
		// TODO Auto-generated method stub
		System.out.println("SkTV - 볼륨을 줄인다");

	}

}

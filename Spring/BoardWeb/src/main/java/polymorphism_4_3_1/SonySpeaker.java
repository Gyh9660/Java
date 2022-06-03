package polymorphism_4_3_1;

public class SonySpeaker implements Speaker {

	//기본 생성자
	
	public SonySpeaker() {
		System.out.println("===> 소니 스피커 객체 생성");
	}
	
	@Override
	public void volumUp() {
		System.out.println("SoNySpEaKeR --- VoLuMuP");
	}
	
	@Override
	public void volumDown() {
		System.out.println("sOnYsPeAkEr --- vOlUmDoWn");
	}
	
}

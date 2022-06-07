package polymorphism_5_2_1;

import org.springframework.stereotype.Component;

@Component("sony") //sony객체는 SonySpeaker타입과 Speaker 타입 두가지를 내포하고있다.
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

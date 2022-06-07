package polymorphism_5_1_1;

import org.springframework.stereotype.Component;

@Component("apple") //apple 는 AppleSpeaker타입과 Speaker타입 두가지 내포
public class AppleSpeaker implements Speaker {

	public AppleSpeaker() {
		System.out.println("===> AppleSpeaker 객체생성");
	}
	
	@Override
	public void volumUp() {
		System.out.println("AppleSpEaKeR --- VoLuMuP");
	}

	@Override
	public void volumDown() {
		System.out.println("ApplesPeAkEr --- vOlUmDoWn");
	}

}

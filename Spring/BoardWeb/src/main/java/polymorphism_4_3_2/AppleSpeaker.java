package polymorphism_4_3_2;

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

package chap12.Ex09;

public class Ex {

	public static void main(String[] args) {
		//1. 객체 생성 SamsungPhone 타입으로 지정
		SamsungPhone s1 = new SamsungPhone();
		s1.printLogo();		//interface에서 default method가 상속되어 내려온 기능
		s1.sendCall();		//
		s1.receiveCall();
		s1.flash();
		
		System.out.println("=========================");
		
		//2. PhoneInterface로 업캐스팅
		PhoneInterface s2 = new SamsungPhone();
		s2.printLogo();
		s2.sendCall();
		s2.receiveCall();
		SamsungPhone ss = (SamsungPhone)s2; //s2 : PhoneInterface ===> SamsungPhone로 타입 변환[다운캐스팅]
		ss.flash(); //flash 다운 캐스팅후 출력
		
		
	}

}

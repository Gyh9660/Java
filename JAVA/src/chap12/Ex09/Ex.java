package chap12.Ex09;

public class Ex {

	public static void main(String[] args) {
		//1. ��ü ���� SamsungPhone Ÿ������ ����
		SamsungPhone s1 = new SamsungPhone();
		s1.printLogo();		//interface���� default method�� ��ӵǾ� ������ ���
		s1.sendCall();		//
		s1.receiveCall();
		s1.flash();
		
		System.out.println("=========================");
		
		//2. PhoneInterface�� ��ĳ����
		PhoneInterface s2 = new SamsungPhone();
		s2.printLogo();
		s2.sendCall();
		s2.receiveCall();
		SamsungPhone ss = (SamsungPhone)s2; //s2 : PhoneInterface ===> SamsungPhone�� Ÿ�� ��ȯ[�ٿ�ĳ����]
		ss.flash(); //flash �ٿ� ĳ������ ���
		
		
	}

}

package chap10.Ex05;

import javax.sound.midi.SysexMessage;

class AAA{	// ㄴStatic필드는 오버라이딩 되지 않는다. 
	
	static int m = 3;
	
}

class BBB extends AAA{

	static int m = 4;
	
}

class CCC extends AAA{
	
	static int m = 5;

}

public class OverlapStaticField {

	public static void main(String[] args) {
		
		//1. 객체 생성 없이 호출 가능 ( 클래스이름으로)<==권장사항
		System.out.println(AAA.m); //3
		System.out.println(BBB.m); //4
		System.out.println(CCC.m); //5
		System.out.println("==========");
		//2. 객체 생성후 호출
		AAA aaa = new AAA();
		BBB bbb = new BBB();
		CCC ccc = new CCC();
		
		AAA aab = new BBB();
		AAA aac = new CCC();
		
		System.out.println(aaa.m); //3
		System.out.println(bbb.m); //4
		System.out.println(ccc.m); //5  //static 필드도 오버라이딩 되지 않는다
		System.out.println("=========");
		System.out.println(aab.m); //3
		System.out.println(aac.m); //3
	}

}

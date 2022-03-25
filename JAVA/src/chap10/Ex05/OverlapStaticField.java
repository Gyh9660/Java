package chap10.Ex05;

import javax.sound.midi.SysexMessage;

class AAA{	// ��Static�ʵ�� �������̵� ���� �ʴ´�. 
	
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
		
		//1. ��ü ���� ���� ȣ�� ���� ( Ŭ�����̸�����)<==�������
		System.out.println(AAA.m); //3
		System.out.println(BBB.m); //4
		System.out.println(CCC.m); //5
		System.out.println("==========");
		//2. ��ü ������ ȣ��
		AAA aaa = new AAA();
		BBB bbb = new BBB();
		CCC ccc = new CCC();
		
		AAA aab = new BBB();
		AAA aac = new CCC();
		
		System.out.println(aaa.m); //3
		System.out.println(bbb.m); //4
		System.out.println(ccc.m); //5  //static �ʵ嵵 �������̵� ���� �ʴ´�
		System.out.println("=========");
		System.out.println(aab.m); //3
		System.out.println(aac.m); //3
	}

}

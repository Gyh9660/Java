package chap10.Ex04;

import chap10.Ex03.InstanceOf;

class Animal2{
	void run() {
		
	}
}

class Tiger extends Animal2{ //ȣ���̴� �׹߷� �޸��ϴ�.
	@Override
	void run() {
		System.out.println("ȣ���̴� �׹߷� �޸��ϴ�.");
	}
	void tigerEat() {
		System.out.println("ȣ���̴� ������ �Խ��ϴ�.");
	}
}

class Eagle extends Animal2{
	@Override
	void run() {
		System.out.println("�������� �ϴ��� ���ϴ�.");
	}
	void eagleEat() {
		System.out.println("�������� �ٸ� ���� ��� �Խ��ϴ�.");
	}
}

class Snake extends Animal2{
	@Override
	void run() {
		System.out.println("���� ���ٴմϴ�.");
	}
}

public class MethodOverriding_2 {

	public static void main(String[] args) {

		//1. ��� ��ü�� Animal2 Ÿ������ ��ĳ�����ؼ� ����.
		Animal2 at = new Tiger();
		at.run();
		Animal2 ae = new Eagle();
		ae.run();
		Animal2 as = new Snake();
		as.run();
		
		//2. Animal2�迭�� �� ��ü�� ����
		Animal2[] animal = {at, ae, as};
		System.out.println("=======for ��===========");
		//3. for������ �迭�� ��ü�� ���, run()����
		for (int i=0; i<animal.length; i++) {
			animal[i].run();
		}
		System.out.println("========Enhanced For��========");
		//4. Enhanced For ���� ����ؼ� ��ü�� run()�޼ҵ� ���
		for (Animal2 k : animal) {
			k.run();
		}
		System.out.println("===========�ٿ�ĳ����==========");
		//5. �ٿ�ĳ���� (instanceof�� ����ؼ�) ���
		if (at instanceof Tiger) {
			Tiger tt = (Tiger)at;
			tt.tigerEat();
		}else {
			System.out.println("TigerŸ������ ĳ���� �Ұ�");
		}
		
		if (ae instanceof Eagle) {
			Eagle ee = (Eagle)ae;
			ee.eagleEat();
		}else {
			System.out.println("EagleŸ������ ĳ���� �Ұ�");
		}
		
		
	}

}

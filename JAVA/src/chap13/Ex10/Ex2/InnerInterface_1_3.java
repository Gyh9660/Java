package chap13.Ex10.Ex2;

class Abc { 
	//1. ��ü ������ �ʵ忡 ���� ���� �Ҵ�.(d1)
	//2. �����ڸ� ���ؼ� �� �Ҵ�,(d2)
	//3. setter�� ���ؼ� ���� �Ҵ�(d3)
	
	Def d; //�ʵ� ���
			//������ ���
	
	
	Abc(){} //�⺻������
	Abc(Def d){ //�����ڸ� ���ؼ� �ʵ��� �⺻�� �Ҵ�
		this.d=d;
	}
	public void setDef(Def d) { //setter�� ���ؼ� �ʵ��� �⺻�� �Ҵ�
		this.d=d;
	}
	interface Def { //Abc.Def
		void run ();
		void fly ();
	}
	
	void ghi() {
		d.run();
		d.fly();
		
	}
	
}



public class InnerInterface_1_3 {

	public static void main(String[] args) {
		//1.��ü ������ �ʵ忡 ���� ���� �Ҵ�
		Abc abc1 = new Abc();
		abc1.d = (Abc.Def) new Abc.Def() {
			
			@Override
			public void run() {
				System.out.println("run abc1");
			}
			
			@Override
			public void fly() {
				System.out.println("fly abc1");
			}
		};
		abc1.ghi();
		System.out.println("=====================");
		
		//2. �����ڸ� ���ؼ� ���� �Ҵ�
		Abc abc2 = new Abc(
				new Abc.Def() { //�̳� �������̽�
					@Override
					public void run() {
						System.out.println("run abc2");
					}
					@Override
					public void fly() {
						System.out.println("fly abc2");
					}
				}
				
				
				);
		abc2.ghi();
		System.out.println("=====================");
		//3. setter�� ���ؼ� ���Ҵ�
		Abc abc3 = new Abc();
		abc3.setDef(new Abc.Def() {
			
			@Override
			public void run() {
				System.out.println("run abc3");
			}
			
			@Override
			public void fly() {
				System.out.println("fly abc3");
			}
		});
		abc3.ghi();
	}

}

package chap13.Ex10.Ex2;

class Abc { 
	//1. 객체 생성후 필드에 직접 값을 할당.(d1)
	//2. 생성자를 통해서 값 할당,(d2)
	//3. setter을 통해서 값을 할당(d3)
	
	Def d; //필드 블락
			//생성자 블락
	
	
	Abc(){} //기본생성자
	Abc(Def d){ //생성자를 통해서 필드의 기본값 할당
		this.d=d;
	}
	public void setDef(Def d) { //setter를 통해서 필드의 기본값 할당
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
		//1.객체 생성후 필드에 직접 값을 할당
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
		
		//2. 생성자를 통해서 값을 할당
		Abc abc2 = new Abc(
				new Abc.Def() { //이너 인터페이스
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
		//3. setter를 통해서 값할당
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

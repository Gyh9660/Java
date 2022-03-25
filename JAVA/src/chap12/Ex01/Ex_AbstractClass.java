package chap12.Ex01;

abstract class Abc{
	abstract void cry(); //  
	
	
	
	abstract void fly(); //
	
}
class Cat extends Abc{
	@Override
		void cry() {
			System.out.println("야옹");
		}
	@Override
		void fly() {
			System.out.println("고양이는 날지 못합니다.");
		}
}

class Eagle extends Abc{
	@Override	
		void cry() {
			System.out.println("끼룩");
		}
	
	@Override
		void fly() {
			System.out.println("독수리는 하늘을 납니다.");
		}
}
public class Ex_AbstractClass {

	public static void main(String[] args) {
		//1. 자식 클래스 Cat, Eagle 클래스 생성후 출력
		Abc ac = new Cat();
		ac.cry();
		ac.fly();
		
		System.out.println("=================");
		Abc ae = new Eagle();
		ae.cry();
		ae.fly();
		
		System.out.println("=========================");
		System.out.println();
		System.out.println();
		//2. 익명 클래스 생성후 출력,
		Abc ac2 = new Abc() {
			void cry() {
				System.out.println("야옹");
			}
			void fly() {
				System.out.println("고양이는 날지 못합니다.");
			}	
		};
		
		Abc ae2 = new Abc() {
			void cry() {
				System.out.println("끼룩");
			}
			void fly() {
				System.out.println("독수리는 하늘을 납니다.");
			}
		};
		ac2.cry();
		ac2.fly();
		System.out.println("====================");
		ae2.cry();
		ae2.fly();
		
		
	}

}

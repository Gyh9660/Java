package chap12.Ex01;

abstract class Abc{
	abstract void cry(); //  
	
	
	
	abstract void fly(); //
	
}
class Cat extends Abc{
	@Override
		void cry() {
			System.out.println("�߿�");
		}
	@Override
		void fly() {
			System.out.println("����̴� ���� ���մϴ�.");
		}
}

class Eagle extends Abc{
	@Override	
		void cry() {
			System.out.println("����");
		}
	
	@Override
		void fly() {
			System.out.println("�������� �ϴ��� ���ϴ�.");
		}
}
public class Ex_AbstractClass {

	public static void main(String[] args) {
		//1. �ڽ� Ŭ���� Cat, Eagle Ŭ���� ������ ���
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
		//2. �͸� Ŭ���� ������ ���,
		Abc ac2 = new Abc() {
			void cry() {
				System.out.println("�߿�");
			}
			void fly() {
				System.out.println("����̴� ���� ���մϴ�.");
			}	
		};
		
		Abc ae2 = new Abc() {
			void cry() {
				System.out.println("����");
			}
			void fly() {
				System.out.println("�������� �ϴ��� ���ϴ�.");
			}
		};
		ac2.cry();
		ac2.fly();
		System.out.println("====================");
		ae2.cry();
		ae2.fly();
		
		
	}

}

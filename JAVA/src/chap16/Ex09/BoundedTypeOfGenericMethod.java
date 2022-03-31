package chap16.Ex09;

//���ʸ� �޼ҵ��� ���� ���� :

class A { //�Ϲ� Ŭ�������� ���ʸ� �޼ҵ�
	
	//Number : Boolean, Character�� ������ 6���� Ÿ��(Byte, Short, Integer, Long, Float, Double)
	public <T extends Number> void method1 (T t) {
		System.out.println(t.intValue()); //Number Ÿ���� �޼ҵ�/ t.intValue() ,������ ���
		
	}		
}



interface Myinterface {
	void print(); // public abstract����
}

class C implements Myinterface{ //�������̽��� ������ Ŭ����
	@Override
	public void print() {
		System.out.println("�������̽��� ������ Ŭ�������� ���");
	}
}


class B { //���ʸ� Ÿ�� ���ο���  �������̽��� ������ ������ extendsŰ�� ����Ѵ�.
	
	public <T extends Myinterface> void method2 (T t) { //T�� Ÿ�Կ� �� �� �ִ� ���� MyInterface�� ������ Ŭ������ �� �� �ִ�.
		t.print();
	}
}


class D {
	public <T extends String> void abc(T t) {
		System.out.println(t); //String�� toString �޼ҵ尡 �����ǵǾ�����
		System.out.println(t.toString());
	}
}



public class BoundedTypeOfGenericMethod {

	public static void main(String[] args) {
		A a = new A(); //�Ϲ� Ŭ���� ��ü ������ ���ʸ� �޼ҵ� ȣ��
		a.<Double>method1(5.3);
		a.method1(22.5);    //�Ű������� ������ ���� Ÿ���� �ĺ��Ҽ� �ִ� ��� ��������
		a.<Long>method1(100000L); //Long
		a.<Float>method1(100.5555F);//Float
		//a.<Boolean>method1(true); //Character, Boolean�� �����߻�
		
		B b = new B(); //���ʸ��޼ҵ� ȣ���ҋ��� �Ϲ�Ŭ������ ���� ����������
		
//Method2�� �Ź躯���� �� �� �ִ� ���� �������̽� Ÿ��, �������̽��� ������ �ڽ�Ŭ����
		//�������̽��� ������ ���� �͸�Ŭ����,
		
		b.<Myinterface>method2( new Myinterface() {
			public void print() {
				System.out.println("print() �͸� Ŭ������ ���");
			};
				
		}
				
			);
		
		b.<Myinterface> method2(new C()); //�Ű������� �������̽��� ������ �ڽ� ��ü
		
		//�͸� Ŭ������ ���ʸ� �޼ҵ� ȣ���� �Ű������� �����ֱ�

		b.method2(new Myinterface() {
			@Override
			public void print() {
				System.out.println("�͸����� ó���� Ŭ���� ���");
			}
		});
		
		
	
		D d = new D();
		d.<String>abc("�ȳ�");
		d.abc("�ϼ���");
		
	}
}

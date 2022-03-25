package chap06_07.Ex01;

//Ŭ����(class) : ��ü�� �����ϱ� ���� Ʋ(���ø�), ���赵. �ؾ�� Ʋ <<�߿�>>
//��ü(Object) : Ŭ������ �����ؼ� �޸�(RAM)���� �۵��Ǵ� �����ڵ� (���赵�� ���� ���� ��, �ؾ Ʋ�� ���� ���� �ؾ)
	// ��ü = �ν��Ͻ� 
	// �ν��Ͻ�ȭ (��üȭ) ��Ų��. (���� �޼ҵ忡�� ��ü�� �ν��Ͻ�ȭ ���� ����Ѵ�.)
	// A a = new A(); <== Ŭ������ ��üȭ ���Ѽ� �޸𸮿� �ε�

class A { //�ܺ� Ŭ����
	int m = 3;		// m => �ʵ�(����) : class������� ����� ������ �ʵ�� ȣĪ
					// �ʵ�� �ν��Ͻ�ȭ (��üȭ) ���Ѿ� ����� �����ϴ�.
					// �ʵ�� �޸��� Heap������ ����
	
	void print() { //�޼ҵ� : ������������ �Լ� = ��ü�������� �޼ҵ� /��ü������� �Լ��� �޼ҵ�� ȣĪ
		System.out.println("��ü ���� �� Ȱ��");
	}
	
}

class B { //�ܺ� Ŭ����
	String name = "ȫ�浿";
	int age = 24;
	String phone = "010-1111-1111";
	
	void print_name () {
		System.out.println(name);
	}
	void printage () {
		System.out.println(age);
	}
	void printphone() {
		System.out.println(phone);
	}
}

public class CreateObjectAndUsingOfMember {

	public static void main(String[] args) {
		A a = new A(); //Class A�� ��üȭ(�ν��Ͻ�ȭ) ��Ų��.=>�޸�(RAM)�� �ε��Ų��.
		System.out.println(a.m);
		a.print();
		
		System.out.println("================");
		
		A b = new A();		//Class A�� ��üȭ(�ν��Ͻ�ȭ) ��Ų��.(RAM�� �ε��Ų��.) 
		//()�� ������ �ȿ� �Ű��������°� �⺻�����ڶ���� A=Ŭ���� b= ��ü
		/*----------------------------------------------------------------
		 *  ������(�����޼ҵ�)         |  b       |  �޼ҵ尪�� �ִ��ּ�(����Ʈ��)   |
		 *  Ŭ��������               | stack     | Heap                     |
		 *----------------------------------------------------------------
		 */
		System.out.println(b.m);
		b.print();
	
		System.out.println("================");
		
		A c = new A();
		System.out.println(c.m);
		c.print();
		
		System.out.println("================");
		
		B bb = new B(); //B class�� bb ��� �̸����� ��üȭ
		bb.print_name(); //bb��ü�� �޼ҵ带 ȣ��
		bb.printage();	//bb��ü�� �޼ҵ� ȣ��
		bb.printphone();	//bb��ü�� �޼ҵ� ȣ��
		
		B cc = new B();
		cc.print_name();
		cc.printage();
		cc.printphone();
		
		
		
		
	}

}

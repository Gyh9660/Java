package chap06_07.Ex06;

//��ü�� �ʵ忡 ���� �Ҵ� �ϴ� ��� : 3����
	//1. �ʵ忡 ���� ����
		//<== ��ü�� ������
	//2. setter�� ���ؼ� ��ü�� �ʵ忡 ���� �ο��ϴ� ���(��Ʈ���� �ȴ�) 
		//<==��ü�� ���� �� ��ü�� �����ο�
	//3. �����ڸ� ���ؼ� ��ü�� �ʵ� ���� �ο� (��Ʈ�� �ȴ�)
		//<== ��ü�� ������ �� �ʱⰪ���� �ʵ忡 ���� �Ҵ�

class Aaa{ //1.��ü ������ ���� �ʵ忡 �� �Ҵ�
	String name; //�̸�
	int age;	//����
	String mail;	//�����ּ�
	
	void print() {
		System.out.println("name : "+name+ "age : "+age+ "mail : "+mail);
	}
	
	
}

class Bbb{ //2.setter�� ���ؼ� ��ü�� �ʵ��� ���� �Ҵ� 
	
	String name; //�̸�
	int age;	//����
	String mail;	//�����ּ�
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
	void print() {
		System.out.println("name : "+name+ "age : "+age+ "mail : "+mail);
	}
	
}

class Ccc{ //3. �����ڸ� ���ؼ� ��ü�� �ʵ��� ���� �Ҵ�
	
	String name; //�̸�
	int age;	//����
	String mail;	//�����ּ�
	
	Ccc(String name, int age, String mail){ //�����ڿ��� �Ű����� 3���� �޾Ƽ�
		this.name = name;
		this.age = age;
		this.mail = mail;
	}
	
	
	void print() {
		System.out.println("name : "+name+ "age : "+age+ "mail : "+mail);
	}
	
	
}


public class FieldOfValue_ex1 {

	public static void main(String[] args) {

		//1. ��ü�� �ʵ忡 ���� ���� �Ҵ�.
		Aaa aaa = new Aaa();		//��ü�� ������ �� �Ҵ�
		aaa.name = "ȫ�浿";
		aaa.age = 30;
		aaa.mail="aaa@aaa.com";
		aaa.print();
		//2. ��ü�� setter�� ���ؼ� �ʵ��� ���� �ο�.
		System.out.println(); 		//��ü�� ������ �� �Ҵ�	
		Bbb bbb = new Bbb();
		bbb.setName("������");
		bbb.setAge(50);
		bbb.setMail("bbb@bbb.com");
		bbb.print();
		//3. �����ڸ� ����ؼ� �ʵ��� ���� �ο�. (��ü�� �����ҋ� �ʵ��� ���� �ʱ�ȭ)
		Ccc ccc = new Ccc("�������",40,"ccc@ccc.com");		//��ü�� �����Ҷ� �� �ο�
		ccc.print();
		
		
	}

}

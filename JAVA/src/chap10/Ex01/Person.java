package chap10.Ex01;

class Student_sub extends Student {
	//Studen_sub�� Student�� ��� �ް� �ֵ�. Student�� �ʵ�� �޼ҵ带 ��ӹ޴´�.
	//Student�� Person�� ��� �ް� �ִ�. Student�� Person�� �ʵ�� �޼ҵ带 ��� �ް� �ִ�.
	
	//Student_sub�� Person�� �ʵ�� �޼ҵ�� Student�� �ʵ�� �޼ҵ带 ��� ��� �ް� �ֵ�.
	
	String sub1;
	
	void sub1() {
		System.out.println("Student_sub Ŭ���� �Դϴ�.�θ��� �ʵ�� �޼ҵ带 ���� �޽��ϴ�.");
	}
}



public class Person { //��� : �θ� Ŭ������ (�ʵ�, �޼ҵ�, ����Ŭ����)�� �ڽ�Ŭ�������� ���
	
	String name; // ����� ����: 1.�ߺ��� �ڵ��� ����(�ڵ��� ����)
	int age;		//2. �ڵ尡 ����������. 3. ������(�޼ҵ� �������̵�)
					//������: �ϳ��� �޼ҵ� �̸����� ������������ ���
	
	void eat() {
		
		System.out.println("�θ� Ŭ������ eat() �޼ҵ�");
	}
	
	void sleep() {
		
		System.out.println("�θ� Ŭ������ sleep() �޼ҵ�");
	}




	public static void main(String[] args) {

		//1. person  ��ü ����
		Person p = new Person();
		p.name = "ȫ�浿";
		p.age = 20;
		p.eat();
		p.sleep();
		
		
		System.out.println("=========Student class===========");
		
		//2. Student ��ü ����
		Student s = new Student(); //Person Ŭ������ ���, Person Ŭ������ �ʵ�� �޼ҵ带 ���
		//Person Ŭ������ �ʵ�
		s.name="�̼���";
		s.age=50;
		//Student Ŭ������ �ʵ�
		s.studentID= 20200310;
		
		//Person Ŭ������ �޼ҵ�
		s.eat();
		s.sleep();
		
		//Student Ŭ������ �޼ҵ�
		s.goToSchool();
		
		System.out.println("=========Worker class=============");
		//3. Worker ��ü ����
		Worker w = new Worker(); //Person Ŭ������ ��� �Ѵ�. Person Ŭ������ �ʵ�� �޼ҵ带 ���.
		
		//�θ� Ŭ������ �ʵ� :Person
		w.name = "�������";
		w.age = 60;
		
		//�ڽ� Ŭ������ �ʵ� : Worker
		w.workID=20220310; //���
		
		//�θ� Ŭ������ �޼ҵ� :Person
		w.eat();
		w.sleep();
		
		//�ڽ� Ŭ������ �޼ҵ� :Worker
		w.goToWork();
		
		System.out.println("========��ü ������ Ÿ�� ��ȯ ===========");
		
		Person p1 = new Person(); //Person()�� Person�̴�. (�ڽ��� �θ��)
		Person ps = new Student(); //��ĳ����, student�� person�̴�. �ڽ�-> �θ�� ����
		//Student sp = new Person(); // �θ�� �ڽ��̴� (����x)�����߻�
		Person pw = new Worker(); // ��ĳ����, Worker �� Person�̴�. (�ڽ��� �θ��)
		//Worker wp = new Person(); // ����� �������̴�. (����x)�����߻�
		System.out.println();
		System.out.println("=======Person<Student<Student_sub========");
		
		Student_sub sub1 = new Student_sub();//����
		//|Ŭ���� Ÿ��|��ü��|       |�ڽ� Ŭ����|
		//	(Type)
		
			//Person Ŭ������ �ʵ�� �޼ҵ� ��� ����
			sub1.name = "�� ���Ӵ�";
			sub1.age = 55;
			sub1.eat();
			sub1.sleep();
			//Student Ŭ������ �ʵ�� �޼ҵ�
			sub1.studentID = 20220310;
			sub1.goToSchool();
			//Student_sub Ŭ������ �ʵ�� �޼ҵ�
			sub1.sub1= "�ڽ��� �ڽ� Ŭ����";
			sub1.sub1();
		
		Person ps1 = new Student_sub(); // ��ĳ����: Student_sub��ü�� ������ �θ� ������ Ÿ������ ����ȯ �ϴ� ��
			//Student_sub�� Person Ÿ������ ��ĳ����, Person������ ����� ��� ����
		
		//Person Ŭ������ �ʵ�� �޼ҵ常 ����
		ps1.name = "BTS"; //Person                                                                                                                                                                                                      
		ps1.age = 30;
		ps1.eat();
		ps1.sleep();
		
		
		Student ss1 = new Student_sub(); //��ĳ����: Student_sub�� StudentŸ������ ��ĳ����
		
		//person�� student�� �ʵ�� �޼ҵ带 ��밡��
		
		//Parson�� �ʵ�� �޼ҵ�
		ss1.name="SES";
		ss1.age =30;
		ss1.eat();
		ss1.sleep();
		
		
		//Student�� �ʵ�� �޼ҵ�
		ss1.studentID = 20110310;
		ss1.goToSchool();
		
		Student_sub ss2 = new Student_sub(); //Person, Student, Student_sub�� �ʵ�� �޼ҵ� ��� ���.
		
		
		//Person Ŭ������ �ʵ�� �޼ҵ�
		ss2.name = "�����������ܿ�";
		ss2.age = 40;
		ss2.eat();
		ss2.sleep();
		
		//Student Ŭ������ �ʵ�� �޼ҵ�
		ss2.studentID= 20220130;
		ss2.goToSchool();
		
		//Student_sub Ŭ������ �ʵ�� �޼ҵ�
		ss2.sub1= "�ڽ��� �ڽ�Ŭ����";
		ss2.sub1();
		
	//��� ���迡�� ��ü ������ �θ� ������ Ÿ������ ��ĳ���� ����	
		//�θ� ������ Ÿ������ ��ĳ���� �� ��� �θ��� �ʵ�� �޼ҵ常 ��밡��
		
		//Person <=== Student <=== Studetn_sub
		
		Person ps4 = new Student_sub();
			//Student_sub��ü�� ������ PersonŸ������ ��ĳ����(�ڵ����� ��ȯ)
			//Student_sub�� Person�� Student�� Student_sub�� ��� �ʵ�� �޼ҵ带 �����Ѵ�.
			//���߿��� PersonŬ������ �ʵ�� �޼ҵ常 ���ٰ���
		
		
		Student ss4 = new Student_sub();
		
			//Student_sub��ü�� ������ StudentŸ������ ��ĳ����
			//Student_sub�� Person�� Student�� Student_sub�� ��� �ʵ�� �޼ҵ带 �����Ѵ�.
			//���߿��� Person, StudentŬ������ �ʵ�� �޼ҵ常 ���ٰ���
		
		Student_sub ss5 = new Student_sub();
		
			//Student_sub��ü�� ������ Student_subŸ������ ����
			//Student_sub�� Person�� Student�� Student_sub�� ��� �ʵ�� �޼ҵ带 �����Ѵ�.
			//���߿��� Person, Student, Student_subŬ������ �ʵ�� �޼ҵ�dp ���ٰ���
		
	
		
		//�ٿ� ĳ���� : �θ� ������ Ÿ������ ��ĳ���õȰ��� �ڽ� ������ Ÿ������ ��ȯ(�������� ��ȯ)
	
		Student ps5 = (Student) ps4; //ps4(Person, Student,Student_sub)�� (���ٰ�����)������ Ÿ���� person
		//ps5�� Person�� Student�� �ʵ�� �޼ҵ����� ����
		
		ps5.name ="�ٿ� ĳ����";
		ps5.age = 30;
		ps5.studentID=30306330; //Student �ʵ�� �޼ҵ� ��밡��
		ps5.goToSchool(); //Student�� �޼ҵ� ���
		
		Student_sub ps6 = (Student_sub) ps4; //ps4�� Person������ Ÿ�Կ��� Student_sub�� �ٿ�ĳ����
			//Student_subfh�� �ٿ�ĳ���õ�(Person,Student,Student_sub�� �ʵ�� �޼ҵ� ��밡��)
		
		ps6.name ="�̿��"; //Person
		ps6.age = 20; //Person
		ps6.studentID = 20202020; //Student
		ps6.goToSchool();//Student
		ps6.sub1 = "�ڽ��� �ڽ�Ŭ����";//Student_sub
		ps6.sub1();//Student_sub
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

class Student extends Person{ //���л� Ŭ����, Person: �θ�, Student �ڽ�
	// �ڽ� Ŭ������ �θ� Ŭ������ �ʵ�, �޼ҵ�,�̳�Ŭ������ �״�� ��� �޴´�.
	
	int studentID;
	void goToSchool() {
		System.out.println("�ڽ� Ŭ������ student �޼ҵ� goToSchool ȣ��");
	}
	
	
}

class Worker extends Person { //������ Ŭ����
	int workID; // ���
	void goToWork() {
		System.out.println("������ Ŭ������ �޼ҵ� ȣ��");
	}
	
	
}


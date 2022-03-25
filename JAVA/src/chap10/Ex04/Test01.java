package chap10.Ex04;

class Human{ 		//�θ� Ŭ����
	String name;	//�ν��Ͻ� �ʵ�: ��üȭ ���Ѿ� ���, Heap�� ����
	int age;
	
	void eat() {	//�ν��Ͻ� �޼ҵ� : ��üȭ ���Ѿ� ���, Heap������ �� Pointer�� ����������, ������ Ŭ�������� ���� �ν��Ͻ� �޼ҵ念���� ���� �޼ҵ��� �ڵ尡 ����
		System.out.println("����� �Խ��ϴ�.");
	}
	
	void sleep () {
		System.out.println("����� ���� ��ϴ�.");
		
	}
}
class Student extends Human{
	int studentID;
	void gotoScool() {
		System.out.println("�л��� �б��� ���ϴ�.");
	}
}
class Worker extends Human{
	int workerID;
	void gotoCompany() {
		System.out.println("���忡 ���ϴ�.");
	}
}




public class Test01 {

	
	
	public static void main(String[] args) {

		Human h = new Human(); //�θ�Ŭ����
		h.name = "ȫ�浿";
		h.age = 30;
		h.eat();
		h.sleep();
		
		
		Student s = new Student(); //�ڽ� Ŭ����: �ڽ�Ŭ������ �θ�Ŭ�������ʵ�� �޼ҵ带 ���
		s.name = "�Ż��Ӵ�"; //�θ� Ŭ������ �ʵ�
		s.eat();	//�θ� Ŭ������ �޼ҵ�
		s.studentID = 1111; //�ڽ� Ŭ������ �ʵ�
		s.gotoScool(); //�ڽ� Ŭ������ �޼ҵ�
		
		Worker w = new Worker(); //�ڽ�Ŭ����
		w.name = "BTS"; // �θ�Ŭ������ �ʵ�
		w.eat(); //�θ�Ŭ������ �޼ҵ�
		w.workerID = 2222; //�ڽ� Ŭ������ �ʵ�
		w.gotoCompany(); //�ڽ� Ŭ������ �޼ҵ�
		 
		Human h1 = new Student (); // ��ĳ���� : �ڽĿ��� �θ� Ÿ������ ����ȯ
		//h : Human, Student Ÿ���� ��� ����, Human�� ���� ����
		 
		h1.name = "�̼���";
		h1.eat();
		
		System.out.println("===================");
		
		
		//�ٿ�ĳ���� : �θ�===> �ڽ����� Ÿ�� ��ȯ , if ������ ����ؼ� instanceof�� ����ؼ� ó��
			//��Ÿ�� ���� ����
		
		
		System.out.println(h1 instanceof Student);//true
		System.out.println(h1 instanceof Human); //true

		if (h1 instanceof Student) { //�ٿ� ĳ���� �Ҷ� ��Ÿ�� ������ �����ϱ� ���ؼ� ��ü�� �ٿ�ĳ������ ������ Ÿ���� ������ �� �ݵ�� instanceof  �������.
			Student s2 = (Student) h1;
			s2.studentID = 3333;
			s2.gotoScool();
		}
		
		if (h1 instanceof Worker) {
			Worker W4  = (Worker) h1; //false
		}
		
		//Worker w4 = (Worker)h1;  //������ �߻����� �ʴ´�.(������ ������ �߻����� �ʴ´�.)
			//����� ���� �߻�, ��Ÿ�� ����
		System.out.println(h1 instanceof Worker); //false
		
		
		
		
	}

}

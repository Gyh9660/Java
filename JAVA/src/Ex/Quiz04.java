package Ex;

class E extends Object{ //�ڹ��� ��� Ŭ������ Object�� �ڽ��̴�
	String name;
	E (){} //�⺻ ������ : Ŭ�������� �ٸ� �����ڰ� �����Ҷ� �ܺο��� �⺻�����ڸ� ȣ���Ҷ� ���µǸ� �ȵȴ�.
	E (String name) {
		this.name=name; // �Ű������̸�, �����ο��� �Ű������� �޴� ������, �ʵ��� �� �������� ��� ����
					//this �ڽ��� ��ü
		
	}
	@Override
		public String toString() {	//��ü ��ü�� ��½� toString()�� ȣ��
			
			return "�̸� : " + name;		//this.name,			
		}
	@Override
		public boolean equals(Object obj) {	// e2.equals(e3);, ��ĳ���õ�

			if (this.name == ((E)obj).name) {
				return true;
			}else {
				return false;
			}
		}
	
	
	
	
	
}

class Student2 {
	int studentID;
	String name;
	int kor;
	int eng;
	
	Student2(){
		
	}
	Student2(int studentID, String name, int kor, int eng){
		this.studentID = studentID;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
	}
	@Override
	public boolean equals(Object obj) { //��ĳ���õ�
		if(this.studentID == ((Student2)obj).studentID){
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public String toString() {

		return studentID+ ","+ name + "," + kor+ "," +eng ;
	}
}

public class Quiz04 {

	public static void main(String[] args) {

		Student2 s1 = new Student2(1111,"ȫ�浿",90,80);
		Student2 s2 = new Student2(2222,"�����",50,100);
		Student2 s3 = new Student2(3333,"������",100,50);
		Student2 s4 = new Student2(1111,"ȫ�浿",90,80);
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
	
		/*studentID �� ���� ��� ���� �л��̴� ��� ���
		��ü�� studentID �÷��� ���ؼ� ���� ��� �����л��̴� ��� ���
			 == : �⺻ Ÿ��: ���� ��(boolean,byte,int,shot, long, double, float, char : 8��)
				����Ÿ���� ��� : ��ü�� �ּҸ� ��. �迭, ��ü String(Ư���ϰ� ���),
				String : toSring() ������ �Ǿ� �ִ�. equals(������)
		object �� toString() - ��ü ��ü�� println(a), ��Ű���̸�.Ŭ�����̸�@�ؽ��ڵ�
			//�������̵� �ؼ� ��ü�� �ʵ��� �������� ���.
		equals() : == �� ����. , ��ü�� �ּҸ� ��.
				�� ������ �ؼ� ��ü���� Ư�� �ʵ��� ���� ��.
		
		*/
		
		
		System.out.println(s1.equals(s4)); //true
		if(s1.equals(s4)) {
			System.out.println("���� �л��̴�.");
		}else {
			System.out.println("�ٸ� �л��̴�.");
		}
		
		 E e1 = new E(); //�⺻ ������ ȣ��: Heap�� �ʵ��� ���� �����ʱ�ȭ �ȴ�.
		 				//null
		 System.out.println(e1.name);
	
		 E e2 = new E("�����");
		 System.out.println(e2.name);
	
		 E e3 = new E("�����");
	
		 System.out.println(e2 == e3); //���� Ÿ�Կ��� (==): ��ü�� �ּҸ� ��
		 System.out.println(e2);
		 System.out.println(e3);
		 System.out.println(e2.equals(e3)); //Object�� equals(): (==)�� �⺻������ ����. ��ü�� �ּҰ� ��
		 //Object�� toString();�� equals()�� �������ؼ� ���
		 
		 
		 
	}

}

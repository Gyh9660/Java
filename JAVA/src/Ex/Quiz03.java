package Ex;

class Student{
	//�ڹٴ� ���� ����� �Ұ�,
	//�ڹ��� ��� Ŭ������ ObjectŬ������ �ڽ�Ŭ����
		//Object Ŭ�������� ������ �ʵ峪 �޼ҵ带 ���� �� �� �ִ�.
	String name; 	//�л��̸�
	int studentID;	//�й�
	int kor; 		//��������
	int eng;		//��������
	int math;		//��������
	int sum;		//�����հ�
	double avg;		//�������

	void hobby () {
		System.out.println("�� �л��� ��� �Դϴ�.");
	}

	@Override
	public String toString() { //Object Ŭ������ �޼ҵ�, ��ü ��ü�� ����Ҷ�,[��Ű����.Ŭ������@�ؽ��ڵ�]
		return "�̸� : "+ name + ", �й� : "+ studentID + ", ���� : " + kor +", ���� : " + eng + ", ���� : " + math + ", �հ� : " + sum + ", ��� : " + avg ;
	}

	
}
class S_ö�� extends Student{

	S_ö��(){ //������: 1. Ŭ������� ����, 2.����Ÿ���� �������
		
	}
	S_ö��(String a, int b,int c,int d,int e){
		super.name = a; //super �θ� Ŭ����, this �ڽ��� ��ü
		super.studentID = b;
		super.kor = c;
		super.eng = d;
		super.math = e;
		super.sum = c+d+e;
		super.avg = (double)super.sum/3; //�տ� ������������ ���ֱ�
	}
	@Override
	void hobby() {
		System.out.println("ö���� ��̴� �౸�Դϴ�. ");
	}
	
}

class S_���� extends Student{
	
	S_����(){
		
	}
	S_����(String a, int b,int c,int d,int e){
		super.name = a;
		super.studentID = b;
		super.kor = c;
		super.eng = d;
		super.math = e;
		super.sum = c+d+e;
		super.avg = (double)super.sum/3; 
	}
	@Override
	void hobby() {
		System.out.println("������ ��̴� ���Դϴ�. ");
	}
	
}

class S_���� extends Student{
	S_����(){
		
	}
	S_����(String a, int b,int c,int d,int e){
		super.name = a;
		super.studentID = b;
		super.kor = c;
		super.eng = d;
		super.math = e;
		super.sum = c+d+e;
		super.avg = (double)super.sum/3;
	}
	
	@Override
	void hobby() {
		System.out.println("������ ��̴� �߱��Դϴ�. ");
	}
	
}




public class Quiz03 {

	public static void main(String[] args) {
		
		Student sa1 = new S_ö��("ö��",1111,70,80,90);
		System.out.println(sa1);
		Student sa2 = new S_ö��();
		sa2.hobby();
		
		System.out.println("====================");
		
		Student sb1 = new S_����("����", 2222, 40, 36, 98);
		System.out.println(sb1);
		Student sb2 = new S_����();
		sb2.hobby();
		
		System.out.println("====================");
		
		Student sc1 = new S_����("����", 3333, 77, 100, 96);
		System.out.println(sc1);
		Student sc2 = new S_����();
		sc2.hobby();
		
		
		System.out.println("===========for ��===============");
		
		Student[] arr1 = {sa1,sb1,sc1};
		for (int i=0; i<arr1.length;i++) {
			System.out.println(arr1[i]);
		}
		
		Student[] arr2 = {sa2,sb2,sc2};
		for (int i=0; i<arr2.length; i++) {
			arr2[i].hobby();
		}
		
		System.out.println("===========���� for��=======");
		
		for(Student t : arr1) {
			System.out.println(t);
		}
		
		for(Student k : arr2) {
			k.hobby();
		}
	}

}

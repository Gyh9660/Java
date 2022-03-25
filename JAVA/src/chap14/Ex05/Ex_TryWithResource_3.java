package chap14.Ex05;
//�ڵ� ���ҽ�(��ü) ����

//�ʵ��� �� �Ҵ�. ������ ȣ��� �ʵ忡 ���� �ο�,
class Abc implements AutoCloseable{
	String name;
	int studentID;
	int kor;
	int eng;
	int math;
	double avg;
	
	Abc (String name, int studentID, int kor, int eng, int math) {
		this.name=name;
		this.studentID=studentID;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.avg = (double)(kor + eng + math)/3;
	}
	@Override
	public void close() throws Exception {
		System.out.println(name+","+studentID+","+kor+","+eng+","+math+","+avg);
		//�ʱ�ȭ ���� �޸��� ���� ���
		if (name != null || studentID != 0 || kor != 0 || eng != 0 || math != 0 || avg != 0.0) {
			name= null;
			studentID=0;
			kor =0;
			eng =0;
			math =0;
			avg =0;
			System.out.println("���ҽ��� ���� �Ǿ����ϴ�.");
			//�ʱ�ȭ ���� �޸𸮰�
			System.out.println(name+","+studentID+","+kor+","+eng+","+math+","+avg);
		}
	}
	
	
}
public class Ex_TryWithResource_3 {

	public static void main(String[] args) {
		//1. ��ü�� ��� �ʵ带 �ʱ�ȭ �ϰ� �ڵ����� close ();
		try(Abc abc = new Abc("ȫ�浿",1111,76,86,77);){
			
		}catch(Exception e) {
			System.out.println("���ܰ� �߻��߽��ϴ�.");
		}
		
		System.out.println("===========================");
		//2. ���� close() , finally ������� close()ȣ��
		
		Abc abc2 = null; 
		try {
			abc2 = new Abc("ȫ�浿",1111,76,86,77);
		}catch(Exception e) {
			
		}finally {
			if(abc2.name != null || abc2.studentID != 0 || abc2.kor != 0 || abc2.eng != 0 || abc2.math != 0 || abc2.avg != 0.0) {
			try {
				abc2.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			}
		}
		
		
		
	}

}

package chap14.Ex01;

public class CheckedException_1_2 {

	public static void main(String[] args) {
		try {
			System.out.println(10/0); //���α׷��� ������ ����Ǿ� ������.
										//���ܿ� ���� ó��
			
		}catch (ArithmeticException e) {
			//try{}���� ������ �߻��� ��쿡 �۵��ȴ�.
			//e.printStackTrace(); //������ ���� �ڼ��� ������ ���
			System.out.println("0�� ���� �� �����ϴ�!!!");
			//catch{}�� ���� ��� ������ ���� ���� �ʾƵ� ����ó���� ��
		
		}finally {
			//try{}�� ������ ��� �۵�(O), ������ �־ �۵�(O)
			//try{}�� �۵��Ǹ� �׻� �۵�
			//��ü�� ����� ��ü�� �޸𸮸� �����Ҷ� ���, ��) sc.close();
			System.out.println("finally{} ����� �׻� ȣ�� �˴ϴ�.");
		}
		
		System.out.println("���α׷��� ���� ���� �մϴ�."); //���� ����
		
	}
}

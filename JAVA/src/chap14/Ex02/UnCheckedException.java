package chap14.Ex02;

//���� ���� (UnChecked Exception, RunTime Exception): ������ �ܰ迡���� ���� �߻����� ����
	//����ÿ� �߻��ɼ��ִ�.

class AA{}

class BB extends AA{}


public class UnCheckedException {

	public static void main(String[] args) {
		//���� ����
		//ArithmeticException : 0���� ����� ������ ������ �߻�
		//System.out.println(10/0);
		
		//ClassCastException : Ŭ������ Ÿ���� ��ȯ�Ҷ� ��ȯ ���� �ʴ� ����
		AA aa = new AA();
		//BB bb = (BB) aa; //������ �ܰ迡���� ������ �߻����� �ʴ´�.
		
		//ArrayIndexOutOfBoundsException : �迭���� �������� �ʴ� ���ȣ�� ����Ұ�� �߻�
		int[] array = {1,2,3};
		//System.out.println(array[3]);
		
		//NumberFormatException : ������ ���ڸ� ����Ÿ������ ��ȯ�� �� ���� ����
		//int num = Integer.parseInt("10!"); //���ڿ� 10�� ������ ��ȯ
		//System.out.println(num);
		
		//NullPointerException
		//String str = null;
		//System.out.println(str.charAt(4));
		
		
	}

}

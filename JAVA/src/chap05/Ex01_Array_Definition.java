package chap05;

import java.io.StreamCorruptedException;

public class Ex01_Array_Definition {

	public static void main(String[] args) {

		/*
		 * �迭 ���� ���� �ٹ�
		 * 		- �迭�� �ϳ��� �迭 ������ ���� �����͸� ����.
		 * 		- �迭�� ����� ������ �ڷ����� ���� ����, (�÷����� ���� ������ Ÿ���� ����)
		 * 		- �迭�� �迭�� ���� ������ ��ũ�⸦ �����ϸ� ��ũ�⸦ ���� �� �� ����. 
		 * (�÷����� ��ũ�Ⱑ �ڵ����� �þ��. )
		 * 
		 */
		
		// �迭 ���� ���
		
		int[] array1 = new int[3]; //�迭�� ����� ���ÿ� �迭��ũ�⸦ �Ҵ� ��ũ�Ⱑ -> array1[0] / [1] / [2]������ ����: �ڷ��� �ڿ� []
		int[] array2;
		array2= new int[3]; // array2 �迭������ �����ϰ��� ���� ��ũ�⸦ ����

		//�迭 ���� ���� ���2
		
		int array3[] = new int[3];  // �迭 ���� ����� ���ÿ� ��ũ�� ����: ������ �ڿ� []
		
		int array4[];
		array4 = new int[3]; //new�� ��ü�� �����Ű���� ���߿���� RAM���� ���� ������ �ִµ�, �迭������ stack�� �迭������(array4)�� �� int[3]�迭�� ���� ���� Heap������ ��. stack�� �� �ּҰ��� ���� �������� heap�� ������. �� stack���� heap�� �ּҰ��̵������ stack�� �ּҰ������� �ּҸ� ã�ư��� heap���� �����͸� ������?
		
		//�پ��� �迭 ���� (�⺻ �ڷ��� �迭, ���� �ڷ��� �迭)
		boolean[] array5=new boolean[3];
		int[] array6=new int[5];
		double[] array7=new double[7]; //����3���� �⺻�ڷ���
		String[] array8=new String[9]; // �����ڷ��� 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

package chap05;

public class Ex03_InitialValue {

	public static void main(String[] args) {
		//�Ѵ� �ʱⰪ�� ���������� ��½� �������߻�
		//1. �޸��� �ʱⰪ  //�⺻ �ڷ����� �ʱⰪ�� �Ҵ����� ������
		int value1;
		//System.out.println(value1);
		int[] value2;     //�迭: ���� �ڷ��� 
		//System.out.println(value2);
		
		
		int value3=0;		//�⺻ �ڷ����� 0������ �ʱⰪ�� �Ҵ�
		System.out.println(value3);
		
		int[] value4 = null; //���� �ڷ����� �ʱⰪ���� null�� �Ҵ� (�˼����� ,����ִ»���_
		System.out.println(value4);
		
		// 2. Heap �޸��� �ʱ� (���� �ʱ���), Heap���� ���� �ڷ����� ���� �Ҵ��.
		// �⺻ �ڷ��� �迭 �� ���?
			//boolean : false , int(������) : 0 , double(�Ǽ���) : 0.0
		boolean[] array1 = new boolean[200];
		System.out.print(array1[0]+ " "+ array1[1]+ " "+array1[2]);
		
		System.out.println("=======for  ���� ����ؼ� �迭 ���� ���� ���============");
		System.out.println();
		for (int i = 0; i<100; i++) {
			System.out.print(array1[1]+" ");
		}// ���� �������� �ϳ��ϳ� ��������, �׷��� for���� ���
		System.out.println();
		System.out.println("��ü�� �޸� �ּ� : " + array1);
		//��ü��ü�� ������ ��ü�� �޸� �ּҰ��� ���, ���ȣ�� ����ؾ� �׾��� ���� ���
		
		System.out.println("��ü�� ���� ������ ��� :"+ array1.length); //array.length = array1�� ���ǰ���
		System.out.println("==========for �� : array1.length=========");
		for ( int i=0; i<array1.length; i++) {
			System.out.println("array["+ i +"] ��° ���� ���� : " + array1[i]);
		}
		System.out.println("=======================");
		int [] array2 = new int[3]; // 0 �� �⺻������ �Ҵ�.
		for (int i = 0; i<array2.length; i++) {
			System.out.print(array2[i] + " ");
		}
		System.out.println();
		System.out.println("=================");
		double[] array3 =new double[3]; //0.0�� �⺻��
		for ( int i =0; i<array3.length; i++) {
			System.out.print(array3[i]+ " ");
		}
		System.out.println();
		System.out.println("=====������ �ڷ��� �迭=======");
		//������ �ڷ��� �迭�� ���� �⺻ ������ null�� ��
		String[] array4 = new String[3];// null
		for ( int i =0 ; i< array4.length; i++) {
			System.out.print(array4[i]+" ");
		}
		
		
			
		
	}

}

package chap19.Ex04;

/*
 * ASCII �ڵ� �� ��� : 1byte=8bit, ���� ó����Ʈ�� ��ȣ ��Ʈ, 7bit :128�� (0~127)
 * 	1 ~ 32��Ʈ ������ : ����� �Ҽ����� Ư���� �ڵ�, ��) null, ����� ����, �����(7) ����[LF] (10).....
 * 127 : delete.
 * 
 * ���� ��� ������ 33�� ��Ʈ~ 126��Ʈ
 * ����, ����, Ư������.
 * 
 * ���
 * ===================================
 * ASCII	����		�ƽ�Ű�ڵ�	����
 * ===================================
 * 33	!		34		&
 * 35	#		36		$
 * ....
 * 126	~
 */
public class Ascii_Code_Print {

	public static void main(String[] args) {

		System.out.println("���");
		System.out.println("======================================");
		System.out.println("ASCII\t����\t\tASCII\t����");
		System.out.println("======================================");
		
		/*for(int i = 33; i<127; i+=2) {
			System.out.println(i+"\t"+(char)i+"\t\t"+(i+1)+"\t"+(char)(i+1));
		}
		
		System.out.println();*/
		
		int[] arr1 = new int[94];
		for(int i = 0; i<arr1.length; i+=2) {
			arr1[i]= 33+i; arr1[i+1]= 34+i;
			System.out.println(arr1[i]+"\t"+(char)arr1[i]+"\t\t"+arr1[i+1]+"\t"+(char)arr1[i+1]);
		}
	}

}

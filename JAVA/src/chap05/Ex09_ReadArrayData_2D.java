package chap05;

public class Ex09_ReadArrayData_2D {

	public static void main(String[] args) {
		//1. 2���� ����Ÿ �迭�� ����
		//�߿�
		int [][] array1 = new int[2][3];
		System.out.println(array1.length); //2���� �迭�� ���: .length�� ���� ������ ���
		System.out.println(array1[0].length); //2���� �迭�� ��� ���ȣ.length�ϸ� ���� ������ ���// ���� �ε��� 0�� ���ǰ���
		System.out.println(array1[1].length); //���� �ε��� 1�� ���ǰ���
		
		
		int[] array11 = new int[10];
		System.out.println(array11.length);//1���� �迭�� ���: .length�� ���� ������ ���
		//�߿�
		
		System.out.println("========================");
		
		// 2���� �迭 ��� ��� 1
		int[][] array2 = new int[][] {{1,2},{3,4,5}};
		System.out.println(array2.length);    //2 (���� ����)
		System.out.println(array2[0].length); //2 (0������ ���� ����)
		System.out.println(array2[1].length); //3 (1������ ���� ����)
		
		
		System.out.println("=================");
		
		// �迭�� index ��ȣ�� ����ϴ� ���
  		System.out.print(array2[0][0]+" "+array2[0][1]);
 System.out.println();
  		System.out.print(array2[1][0]+" "+array2[1][1]+" "+array2[1][2]);
  		
		System.out.println();
		System.out.println("=========for ���� ����ؼ� ���========");
		
		// ���� for���� ����ؼ� ��� �ϴ� ���
		for (int i= 0; i<array2.length; i++) { //�ٱ��� for�� : ���� ���� ������.
			for(int j=0; j<array2[i].length; j++ ) { // ���� for ��: ���� ���� ������.
				System.out.print(array2[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("====���� ���� for ��=========");
		
		for ( int[] array : array2){ //2���� �迭�� ���� ���� 1���� �迭 ������ ���(array�� 1���� �迭 ����) //array�� ���Ƿμ���
			for ( int k: array) { //�迭�� ���� ������ ��Ƽ� ��� //k�� ���Ƿ� ����
				System.out.print(k + " ");
			}
			System.out.println();
		}
		//���� for���� 2���� �迭�� ����ü�� 1���� �迭�� �����ְ� 1���� �迭�� k�� ������ ���� ����ְ�, �ݺ�? 
		
		
		
		
		
		
		
		
		
		
	}

}

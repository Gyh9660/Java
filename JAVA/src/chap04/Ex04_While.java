package chap04;

public class Ex04_While {

	public static void main(String[] args) {

		//while���� �⺻ ����
		
		int a = 0; // �ʱ�� , �ʱⰪ
		while(a<10) { // ����
			System.out.print(a + " "); //���೻��
			
			a++; //������ 
		}
			//0,1,2,3,4,5,6,7,8,9 : 10�� ���
		System.out.println();
		
		// while ���� for������ ��ȯ
		
		for( int i = 0; i<10; i++) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		
		//while ���� 10���� �����ؼ� 1�� ����
		int b = 10;
		while(b>0) {
			System.out.print(b + " ");
			b--;
		}
		
		System.out.println();
		
		//for ���� 10���� �����ؼ� 1�� ����
		
		for(int j = 10; j>0; j--) {
			System.out.print(j + " ");
		}
		
		System.out.println();
		
		// while���� ���ѷ���
		
	/*	while (true) {
			System.out.println("while�� ���ѷ��� �߻�");
		} */

		// while�� ���ѷ��� ����
		
		int c1 = 0;
		while (true) {
			
			if (c1 >100) {
				break;
			}
			System.out.println(c1);
			
			c1++;
		}
		
		
		
		
		
		
		
	}

}

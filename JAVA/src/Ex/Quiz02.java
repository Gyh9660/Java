package Ex;

import java.util.Scanner;

public class Quiz02 {

	public static void main(String[] args) {
		boolean run = true;
		int nu = 0; //��ĳ�ʷ� ��ȣ�� ��ǲ
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("=======================================================");
			System.out.println(" 1. 19�� ��� | 2. Ȧ���ܸ� ��� | 3. 3�ǹ���ܸ� ��� |4.����");
			System.out.println("=======================================================");
			System.out.println("��ȣ�� �Է��� �ּ���.");
			nu = sc.nextInt();
			if (nu == 1) { //���� for���� ����ؼ� 1�������ý� 19�����
				for(int i =1; i<20; i++) {
					for(int j=1; j<20;j++) {
						System.out.printf("%d * %d = %d",i,j,i*j);
						System.out.println();
					}
				}
			}else if ( nu == 2) { //���� for���� ����ؼ� 2�����ý� Ȧ���ܸ� ���
				for(int i =1; i<20; i+=2) {
					for(int j=1; j<20;j+=2) {
						System.out.printf("%d * %d = %d",i,j,i*j);
						System.out.println();
					}
				}
			}else if ( nu == 3) { // 3�� ����ܸ� ���
				for(int i=1; i<20; i++) {
					if(i % 3 == 0) {
						for(int j=1;j<20; j++) {
							System.out.printf("%d * %d = %d",i,j,i*j);
							System.out.println();
						}
					}
				}
			}else if ( nu == 4) { // ���α׷� ����
				break;
			}
			
		}while (run);
		sc.close();
		System.out.println("���α׷��� �����մϴ�.");
	}

}

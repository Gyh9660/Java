package chap06_07.Ex06;

import java.util.Scanner;

public class Ex_Exercise01 {

	public static void main(String[] args) {
		/*
		 * ������ ��� �̸��� �ְ� �ش� ��� ������(���)�� �־ ����ϴ� ���α׷��� �ۼ���, ��ü �� �� ����� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
		 * ��)
		 * �Է�>>
		 * Ź�� 2 �߱� 9 �౸ 11 �� 6 ���� 2
		 * ���>>
		 * Ź�� : 2, �߱� �� 9, �౸ : 11, �� : 6, ���� : 2
		 * ������� ������ �� �հ�:
		 * ������� ��� �������� :
		 * 
		 * "�׸�: �̶�� �Է��ϸ� ���α׷� ����
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("��̸� ���������� ������ �̿��ؼ� �Է��ϼ���.");
		System.out.println("��) �Է� >>>Ź�� 2 �߱� 9 �౸ 11 �� 6 ���� 2");
		
		String str; 	//��ü String���� ��ǲ�޴� ����
		int sum ; 	//��������� ���� �����ϴ� ����
		int memberCount;
		double avg; 	// �������� ����� ���ϴ� ����: (double)��ü�������� ��/������ ��
		String[] arr ; 	// ������ �������� �߶� �迭�� �����ϴ� ����
		int b ;	// �� ������ �������� ��� ����
		
		do {
			sum = 0;
			avg = 0;
			b = 0;
			memberCount=0;
			str=sc.nextLine(); //sc.next() : ��������� String
			//sc.nextLine() : ���� ���� ��ü�� String
			
			arr = str.split(" ");//str�� ������ �������� �߶� arr�迭�� ����
			if (str.equals("�׸�")){ //str�� ���� ���� ���̹Ƿ� str.equals()�� ����Ѵ�.
				break;
			}
			
			for ( int i = 0 ; i < arr.length; i++) {//arr.length :�迭�� index 0 ~������ �����
				if (i % 2 != 0) { // i : ���� ��ȣ �̰� ���ڸ� ������ �´�
					b = Integer.parseInt(arr[i]); //�� ���� String Ÿ���� ������ ��ȯ
					sum += b; //sum = sum + b //sum ��ü�������� ��
					memberCount++; // avg= sum/memberCount
					
				}
			}
			avg = (double)sum/memberCount; //���
			
			System.out.println(str);
			System.out.println("sum : "+sum );
			System.out.println("avg : "+avg );
		
			
			
		} while (true); //sum�̰�� �����Ǵ� �����߻� ���߿� Ȯ��
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	}
	
	
}

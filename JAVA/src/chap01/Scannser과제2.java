package chap01;

import java.util.Scanner;

public class Scannser����2 {

	public static void main(String[] args) {
		System.out.println("�������� �Է��ϼ���?");
		Scanner sc = new Scanner(System.in);
		int value = sc.nextInt();
		if ( value % 3 == 0) {
			System.out.println("3�� ����Դϴ�."); 
		}
		else {
			System.out.println("3�� ����� �ƴմϴ�.");
		}
		sc.close();
	}

}

package chap01;

import java.util.Scanner;

public class Scannser���� {

	public static void main(String[] args) {
		System.out.println("�������� �Է��ϼ���?");
		Scanner sc = new Scanner(System.in);
		int value = sc.nextInt();
		System.out.println( (value % 3 ==0)? "3�� ����Դϴ�." : "3�� ����� �ƴմϴ�.");
		sc.close();
	}

}

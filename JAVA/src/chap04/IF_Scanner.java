package chap04;

import java.util.Scanner;

public class IF_Scanner {

	public static void main(String[] args) {
		System.out.println("operatior�� �Է��� �ּ���.");
		Scanner sc = new Scanner(System.in);
		char operator = sc.next().charAt(0);
		int num1 = 10;
		int num2 = 2;
		int result = 0;
	
		if ( operator == '+') {
			result = num1 + num2;
		}else if (operator == '-') {
			result = num1 - num2;
		}else if (operator == '*' ) {
			result = num1 * num2;
		}else if ( operator == '/') {
			result = num1 / num2;
		}else {
			System.out.println("������ �����Դϴ�.");
			sc.close();
			return;
		}
		
		System.out.println("��� ���� :" + result + "�Դϴ�.");
		
		sc.close();
	}

}

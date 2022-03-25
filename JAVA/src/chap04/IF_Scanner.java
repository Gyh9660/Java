package chap04;

import java.util.Scanner;

public class IF_Scanner {

	public static void main(String[] args) {
		System.out.println("operatior을 입력해 주세요.");
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
			System.out.println("연산자 오류입니다.");
			sc.close();
			return;
		}
		
		System.out.println("결과 값은 :" + result + "입니다.");
		
		sc.close();
	}

}

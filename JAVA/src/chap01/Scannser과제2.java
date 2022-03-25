package chap01;

import java.util.Scanner;

public class Scannser과제2 {

	public static void main(String[] args) {
		System.out.println("정수값을 입력하세요?");
		Scanner sc = new Scanner(System.in);
		int value = sc.nextInt();
		if ( value % 3 == 0) {
			System.out.println("3의 배수입니다."); 
		}
		else {
			System.out.println("3의 배수가 아닙니다.");
		}
		sc.close();
	}

}
